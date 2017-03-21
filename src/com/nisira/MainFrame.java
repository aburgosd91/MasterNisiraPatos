package com.nisira;

import static com.nisira.utils.NisiraUtils.isNull;
import static org.pushingpixels.flamingo.api.ribbon.RibbonElementPriority.LOW;
import static org.pushingpixels.flamingo.api.ribbon.RibbonElementPriority.MEDIUM;
import static org.pushingpixels.flamingo.api.ribbon.RibbonElementPriority.TOP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.event.InternalFrameListener;

import org.pushingpixels.flamingo.api.common.JCommandButton;
import org.pushingpixels.flamingo.api.common.JCommandButton.CommandButtonKind;
import org.pushingpixels.flamingo.api.common.JCommandMenuButton;
import org.pushingpixels.flamingo.api.common.icon.ImageWrapperResizableIcon;
import org.pushingpixels.flamingo.api.common.icon.ResizableIcon;
import org.pushingpixels.flamingo.api.common.popup.JCommandPopupMenu;
import org.pushingpixels.flamingo.api.common.popup.JPopupPanel;
import org.pushingpixels.flamingo.api.common.popup.PopupPanelCallback;
import org.pushingpixels.flamingo.api.ribbon.JRibbonBand;
import org.pushingpixels.flamingo.api.ribbon.JRibbonFrame;
import org.pushingpixels.flamingo.api.ribbon.RibbonApplicationMenu;
import org.pushingpixels.flamingo.api.ribbon.RibbonApplicationMenuEntryFooter;
import org.pushingpixels.flamingo.api.ribbon.RibbonApplicationMenuEntryPrimary;
import org.pushingpixels.flamingo.api.ribbon.RibbonApplicationMenuEntrySecondary;
import org.pushingpixels.flamingo.api.ribbon.RibbonTask;
import org.pushingpixels.flamingo.api.ribbon.resize.CoreRibbonResizePolicies;
import org.pushingpixels.flamingo.api.ribbon.resize.IconRibbonBandResizePolicy;

import com.nisira.clientservice.HttpTablaSincroniza;
import com.nisira.clientservice.HttpTest;
import com.nisira.core.NisiraORMException;
import com.nisira.dao.CONFIGTABLASINCRODao;
import com.nisira.dao.GenericDAO;
import com.nisira.dao.NOTIFICACIONDao;
//import com.nisira.dao.SysFormularioDao;
import com.nisira.dao.SysModuloDao;
import com.nisira.entidad.CONFIGTABLASINCRO;
import com.nisira.entidad.NOTIFICACION;
import com.nisira.entidad.SysFormulario;
import com.nisira.entidad.SysGrupo;
import com.nisira.entidad.SysModulo;
import com.nisira.entidad.SysOpcion;
import com.nisira.entidad.SysTitulo;
import com.nisira.thread.NotacionesThread;
import com.nisira.utilitarios.GenericObjectString;
import com.nisira.utilitarios.ListCreator;
import com.nisira.utilitarios.MenuController;
import com.nisira.utilitarios.UtilMensajes;
import com.nisira.utils.nisiracore.Constantes;
import com.nisira.vista.controles.NSRDatePicker;
import com.nisira.vista.controles.NSRInternalFrame;
import com.nisira.vista.formularios.FrmRFIDreader;
import com.nisira.vista.formularios.movil.FrmNotificacion;
import com.scrollabledesktop.JScrollableDesktopPane;

import controlador.ControladorOpciones;
import core.inicio.ConfigInicial;

import javax.swing.JButton;

public class MainFrame extends JRibbonFrame {
	List<NOTIFICACION> lnoti;
	JButton btnNotifiaciones;
	boolean flag;
	static final String namebtnAlerta = "Notificaciones { 0 }";
	static JScrollableDesktopPane desktopPane;
	static ControladorOpciones cOpciones;

	static SysModuloDao moduloDAO = new SysModuloDao();

	// SysFormularioDao formularioDAO = new SysFormularioDao();
	static {
		cOpciones = new ControladorOpciones();
	}

	public MainFrame() {

		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				doCerrar(evt);
			}
		});
		desktopPane = new JScrollableDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		Inicio.desktoppane = desktopPane;
		// Se establece el tamaño minimo del MainFrame
		setMinimumSize(new Dimension(400, 300));
		cOpciones.setDesktopPane(getDesktopPane());
		setTitle(Inicio.appName + " :: " + Inicio.empresa.getRazonSocial());
		setDefaultCloseOperation(JRibbonFrame.DO_NOTHING_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		try {
			IniciarRibbon();
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JToolBar tlbPie = new JToolBar();
		tlbPie.setRollover(true);
		tlbPie.setFloatable(false);
		getContentPane().add(tlbPie, BorderLayout.SOUTH);

		this.separator = new JSeparator();
		this.separator.setPreferredSize(new Dimension(20, 2));
		this.separator.setMinimumSize(new Dimension(50, 0));
		this.separator.setMaximumSize(new Dimension(50, 32767));
		tlbPie.add(this.separator);

		JLabel label = new JLabel(Inicio.usuario.getIdUsuario());
		tlbPie.add(label);

		tlbPie.add(new JSeparator());

		// Vtr Fecha Sistema
		Date fecha = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		btnNotifiaciones = new JButton(namebtnAlerta);
		btnNotifiaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int seleccion = JOptionPane.showOptionDialog(null, "Usted Tiene " + lnoti.size() + " Mesaje(s)",
							"Responde", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
							new Object[] { "Ver", "Continuar" }, "Ver");
					if (seleccion == 0) {
						FrmNotificacion frmn = new FrmNotificacion("NOTIFICACIONES");
						getDesktopPane().add(frmn);
						frmn.show();
					}
				} catch (NisiraORMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		tlbPie.add(btnNotifiaciones);
		JLabel lblFecha = new JLabel();
		lblFecha.setText(sdf.format(fecha));
		tlbPie.add(lblFecha);
		// getContentPane().add(desktopPane, BorderLayout.CENTER);
		pack();
		setVisible(true);
		/* VARIABLES */
		lnoti = new ArrayList<NOTIFICACION>();
		/* activar alertas */
		Font font = new Font("Tahoma", Font.BOLD, 12);
		btnNotifiaciones.setFont(font);
		flag = true;
		CargaNotificaciones();
		FrmNotificacion frmn;
		try {
			frmn = new FrmNotificacion("NOTIFICACIONES");
			getDesktopPane().add(frmn);
			frmn.show();
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ActualizarAuto();

	}

	public static JScrollableDesktopPane getDesktopPane() {
		return desktopPane;
	}

	private void IniciarRibbon() throws NisiraORMException {
		SysModulo moduloIncial = null;
		// getRibbon().setMinimized(true);

		RibbonApplicationMenu ribbon = new RibbonApplicationMenu();

		RibbonApplicationMenuEntryPrimary modulo_popup = new RibbonApplicationMenuEntryPrimary(
				getResizableIconFromResource("/resources/pie_chart.png"), "Modulo", null, CommandButtonKind.POPUP_ONLY);

		List<SysModulo> modulos = moduloDAO.listar(1);

		List<RibbonApplicationMenuEntrySecondary> modulos_arr = new ArrayList<RibbonApplicationMenuEntrySecondary>();

		for (final SysModulo m : modulos) {

			List<SysTitulo> titulos = MenuController.getTitulosPorModulo(m);

			boolean tiene_opciones = false;
			salir: for (SysTitulo tit : titulos) {
				for (SysGrupo grp : tit.getGrupos()) {
					if (!grp.getOpciones().isEmpty()) {
						if (moduloIncial == null) {
							moduloIncial = m;
						}
						tiene_opciones = true;
						break salir;
					}
				}
			}

			String url = null;
			if (m.getImagen() == null || m.getImagen().toString().trim().length() < 1) {
				url = "/resources/salir.png";
			} else {
				url = "/resources/" + m.getImagen().toString().trim();
			}
			if (tiene_opciones) {
				RibbonApplicationMenuEntrySecondary secondary = new RibbonApplicationMenuEntrySecondary(
						getResizableIconFromResource16x16(url), m.getDescripcion(), new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								CreaRibbonMenu(titulos);

							}
						}, CommandButtonKind.ACTION_ONLY);
				modulos_arr.add(secondary);
			}
		}

		if (!modulos_arr.isEmpty()) {

			RibbonApplicationMenuEntrySecondary[] modulos_vec = new RibbonApplicationMenuEntrySecondary[modulos_arr
					.size()];
			for (int ii = 0; ii < modulos_arr.size(); ii++) {
				modulos_vec[ii] = modulos_arr.get(ii);
			}
			modulo_popup.addSecondaryMenuGroup("Lista de Módulos", modulos_vec);
		}

		ribbon.addMenuEntry(modulo_popup);

		ribbon.addMenuSeparator();

		RibbonApplicationMenuEntryPrimary nn = new RibbonApplicationMenuEntryPrimary(
				getResizableIconFromResource("/resources/favoritos.png"), "DashBoard", new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// CreaRibbonMenu();
					}
				}, CommandButtonKind.ACTION_ONLY);

		ribbon.addMenuEntry(nn);

		RibbonApplicationMenuEntryPrimary config_popup = new RibbonApplicationMenuEntryPrimary(
				getResizableIconFromResource("/resources/config_inicial.png"), "Configuración Inicial", null,
				CommandButtonKind.POPUP_ONLY);

		RibbonApplicationMenuEntrySecondary[] configs = new RibbonApplicationMenuEntrySecondary[4];

		configs[0] = new RibbonApplicationMenuEntrySecondary(
				getResizableIconFromResource16x16("/resources/empresa.png"), "Empresa",
				cOpciones.actionAbrirFormulario("com.nisira.vista.formularios.maestros.FrmEmpresa"),
				CommandButtonKind.ACTION_ONLY);

		configs[1] = new RibbonApplicationMenuEntrySecondary(
				getResizableIconFromResource16x16("/resources/formulario.png"), "Gestion de Formularios",
				cOpciones.actionAbrirFormulario("com.nisira.vista.formularios.maestros.FrmSysFormulario"),
				CommandButtonKind.ACTION_ONLY);
		configs[2] = new RibbonApplicationMenuEntrySecondary(getResizableIconFromResource16x16("/resources/menu.png"),
				"Gestion de Modulos y Menús",
				cOpciones.actionAbrirFormulario("com.nisira.vista.formularios.maestros.FrmMenus"),
				CommandButtonKind.ACTION_ONLY);

		RibbonApplicationMenuEntrySecondary gestusuarios = new RibbonApplicationMenuEntrySecondary(
				getResizableIconFromResource16x16("/resources/config_usuarios.png"), "Gestión de Usuario", null,
				CommandButtonKind.ACTION_AND_POPUP_MAIN_ACTION);

		PopupPanelCallback pcb = new PopupPanelCallback() {

			@Override
			public JPopupPanel getPopupPanel(JCommandButton commandButton) {
				JCommandPopupMenu menu = new JCommandPopupMenu();

				JCommandMenuButton grdGrupo = new JCommandMenuButton("Grupo de Usuarios",
						getResizableIconFromResource16x16("/resources/config_usuarios.png"));
				menu.addMenuButton(grdGrupo);
				JCommandMenuButton grdUsuario = new JCommandMenuButton("Usuarios",
						getResizableIconFromResource16x16("/resources/usuario.png"));
				menu.addMenuButton(grdUsuario);
				grdGrupo.addActionListener(
						cOpciones.actionAbrirFormulario("com.nisira.vista.formularios.maestros.FrmGrupoUsuario"));
				grdUsuario.addActionListener(
						cOpciones.actionAbrirFormulario("com.nisira.vista.formularios.maestros.FrmUsuario"));
				return menu;
			}
		};

		gestusuarios.setPopupCallback(pcb);

		configs[3] = gestusuarios;

		if (Inicio.usuario.getGrupousuario_fk_usuario_grupousuario().getEs_administrador() == 1) {
			config_popup.addSecondaryMenuGroup("Configuración Inicial", configs);
			ribbon.addMenuEntry(config_popup);
		}

		ribbon.addMenuSeparator();

		RibbonApplicationMenuEntryPrimary cambiar_clave = new RibbonApplicationMenuEntryPrimary(
				getResizableIconFromResource("/resources/cambia_clave.png"), "Cambiar Clave",
				cOpciones.actionAbrirFormulario("com.nisira.vista.formularios.maestros.FrmCambioClave"),
				CommandButtonKind.ACTION_ONLY);

		ribbon.addMenuEntry(cambiar_clave);

		RibbonApplicationMenuEntryPrimary cerrar_sesion = new RibbonApplicationMenuEntryPrimary(
				getResizableIconFromResource("/resources/cerrar_sesion.png"), "Cerrar Sesión", cerrarSesion(),
				CommandButtonKind.ACTION_ONLY);

		ribbon.addMenuEntry(cerrar_sesion);
		RibbonApplicationMenuEntryFooter footer = new RibbonApplicationMenuEntryFooter(
				getResizableIconFromResource("/resources/salir.png"), "Salir", new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						doCerrar();
					}
				});
		ribbon.addFooterEntry(footer);
		getRibbon().setApplicationMenu(ribbon);
		setApplicationIcon(getResizableIconFromResource("/resources/nisiralogo.png"));
		setIconImage(new ImageIcon(MainFrame.class.getResource("/resources/nisiralogo.png")).getImage());

		if (moduloIncial != null) {
			try {
				CreaRibbonMenu(MenuController.getTitulosPorModulo(moduloIncial));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ActionListener cerrarSesion() {
		try {
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					doCerrarSesion();
				}
			};
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void CreaRibbonMenu(List<SysTitulo> titulos) {
		getRibbon().removeAllTasks();
		for (SysTitulo titulo : titulos) {

			List<JRibbonBand> bandas_aux = new ArrayList<JRibbonBand>();
			for (SysGrupo grupo : titulo.getGrupos()) {

				boolean dibujaGrupo = (grupo.getOpciones().size() > 0);
				JRibbonBand band = new JRibbonBand(grupo.getDescripcion(),
						getResizableIconFromResource("/resources/nuevo.png"));

				if (dibujaGrupo) {

					bandas_aux.add(band);

					for (SysOpcion opcion : grupo.getOpciones()) {

						// SysFormulario formulario =
						// opcion.getSysFormulario();

						SysFormulario formulario;

						// formulario =
						// formularioDAO.porClavePrimaria(opcion.getIdFormulario());

						formulario = opcion.getSysformulario_sys_opcionidformulario();

						String url = null;
						if (formulario.getImagen() == null || formulario.getImagen().toString().trim().length() < 1) {
							url = "/resources/nuevo.png";
						} else {
							url = "/resources/" + formulario.getImagen().toString().trim();
						}

						// formulario.setImagen("/resources/nuevo.png");

						JCommandButton button = new JCommandButton(formulario.getDescripcion(),
								getResizableIconFromResource(url));

						if (opcion.getPrioridad() == 0) {
							band.addCommandButton(button, TOP);
						} else if (opcion.getPrioridad() == 1) {
							band.addCommandButton(button, MEDIUM);
						} else {
							band.addCommandButton(button, LOW);
						}

						if (isNull(formulario.getEsLista(), 0) == 1) {
							button.addActionListener(cOpciones.actionAbrirFormulario(
									formulario.getPaquete().concat(".").concat(formulario.getClase()),
									formulario.getPaqueteDoc().concat(".").concat(formulario.getClaseDoc())));
						} else {
							button.addActionListener(cOpciones.actionAbrirFormulario(
									formulario.getPaquete().concat(".").concat(formulario.getClase())));
						}

					}

					band.setResizePolicies(
							(List) Arrays.asList(new CoreRibbonResizePolicies.Mid2Mid(band.getControlPanel()),
									new IconRibbonBandResizePolicy(band.getControlPanel())));
				}
			}

			if (bandas_aux.size() > 0) {
				JRibbonBand[] bandas = new JRibbonBand[bandas_aux.size()];
				for (int i = 0; i < bandas_aux.size(); i++) {
					bandas[i] = bandas_aux.get(i);
				}

				RibbonTask task = new RibbonTask(titulo.getDescripcion(), bandas);

				this.getRibbon().addTask(task);
			}
		}
	}

	private void doCerrar(java.awt.event.WindowEvent evt) {
		doCerrar();
	}

	/* CIERRE TOTAL DEL SISTEMA */
	private void doCerrar() {
		JInternalFrame[] frames = desktopPane.getDesktopMediator().getAllFrames();
		boolean cerrar = true;
		if (frames != null) {
			if (frames.length > 0) {
				if (frames.length == 1) {
					UtilMensajes.mensaje_alterta("NO_CERRAR_DOC_ABIERTO_1", Inicio.appName);
				} else {
					UtilMensajes.mensaje_alterta("NO_CERRAR_DOC_ABIERTO_N", Inicio.appName,
							String.valueOf(frames.length));
				}
				cerrar = false;
			}
		}
		if (cerrar) {
			int resp = UtilMensajes.mensaje_sino("CERRAR SISTEMA", Inicio.appName);
			if (resp == 0) {
				/* CERRAR HILOS */
				// Thread.currentThread().stop();
				NotacionesThread.stopThreadTotal();
				this.dispose();
			}
		}
	}

	private void doCerrarSesion() {
		JInternalFrame[] frames = desktopPane.getDesktopMediator().getAllFrames();
		boolean cerrar = true;
		if (frames != null) {
			if (frames.length > 0) {
				if (frames.length == 1) {
					UtilMensajes.mensaje_alterta("NO_CERRAR_DOC_ABIERTO_1", Inicio.appName);
				} else {
					UtilMensajes.mensaje_alterta("NO_CERRAR_DOC_ABIERTO_N", Inicio.appName,
							String.valueOf(frames.length));
				}
				cerrar = false;
			}
		}
		if (cerrar) {
			int resp = UtilMensajes.mensaje_sino("CERRAR SESION");
			if (resp == 0) {
				new Inicio("").iniciar();
				NotacionesThread.stopThreadTotal();
				// Thread.currentThread().stop();
				dispose();
			}
		}
	}

	/** Serial version unique id. */
	private static final long serialVersionUID = 1L;
	// private JButton btnVentanas;
	private JSeparator separator;

	public static ResizableIcon getResizableIconFromResource(String resource) {
		return ImageWrapperResizableIcon.getIcon(MainFrame.class.getResource(resource), new Dimension(48, 48));
	}

	public static ResizableIcon getResizableIconFromResource16x16(String resource) {
		return ImageWrapperResizableIcon.getIcon(MainFrame.class.getResource(resource), new Dimension(10, 10));
	}

	/************* ALERTA DE NOTIFICACIONES *************/
	/*
	 * MESTADOS DE NOTIFICACIONES (1)PENDIENTES (2)EJECUCION (3)TERMINADO
	 * (4)OBSERVADO
	 */
	public void cargarNotificaciones() {
		try {
			lnoti = (new NOTIFICACIONDao()).verNotificacionxMontacarga(Inicio.idempresa, Inicio.idmontacarga);
		} catch (SQLException | NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void AsignarNotificacionActiva() {
		if (lnoti.size() > 0) {
			salir: for (NOTIFICACION nt : lnoti) {
				if (nt.getMESTADO() == 2) {
					Inicio.notificacion = nt;
					break salir;
				}
			}
		}
	}

	public void actualizarTextNotificacion() {
		String texto = "";
		if (lnoti.size() > 0) {
			texto = "Notificaciones { " + obtenerNumeroNotificacionesxEstado(1) + " }";
			btnNotifiaciones.setText(texto);
			if (flag) {
				btnNotifiaciones.setForeground(Color.red);
				flag = false;
			} else {
				btnNotifiaciones.setForeground(Color.black);
				flag = true;
			}
		}
	}

	public int obtenerNumeroNotificacionesxEstado(int mestado) {
		int cont = 0;
		if (lnoti.size() > 0) {
			for (NOTIFICACION nt : lnoti) {
				if (nt.getMESTADO() == mestado) {
					cont++;
				}
			}
		}
		return cont;
	}

	public List<NOTIFICACION> obtenerNotificacionesxEstado(int mestado) {
		List<NOTIFICACION> list = new ArrayList<NOTIFICACION>();
		if (lnoti.size() > 0) {
			for (NOTIFICACION nt : lnoti) {
				if (nt.getMESTADO() == mestado) {
					list.add(nt);
				}
			}
		}
		return list;
	}

	public void ActualizarAuto() {
		ActulizaBase ej = new ActulizaBase();
		NotacionesThread.hilo = new Thread(ej, NotacionesThread.tMaintFrame_Actualizacion);
		NotacionesThread.hilo.start();
		Constantes.log.info(NotacionesThread.hilo.getName());
	}

	class ActulizaBase implements Runnable {
		@Override
		public synchronized void run() {
			NSRDatePicker dpDesde = new NSRDatePicker();
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DAY_OF_MONTH, 1);
			dpDesde.setDate(cal.getTime());
			NSRDatePicker dpHasta = new NSRDatePicker();
			dpHasta.setDate(new Date());
			List<CONFIGTABLASINCRO> lc = new ArrayList<CONFIGTABLASINCRO>();
			try {
				lc = (new CONFIGTABLASINCRODao()).listar(1, "IDEMPRESA = ? AND TIPOSINCRO = ? AND ESTADO = ?",
						ConfigInicial.LlenarConfig()[8], "2","1");
			} catch (NisiraORMException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (CONFIGTABLASINCRO c : lc) {
				try {
					@SuppressWarnings("unchecked")
					List<Object> tl = (List<Object>) (new HttpTablaSincroniza()).fall(c.getTABLA(),
							"Sincronizacion.xhtml", ConfigInicial.LlenarConfig()[8].toString(),
							ConfigInicial.LlenarConfig()[9].toString(), NSRInternalFrame.MostrarFecha(dpDesde, 1),
							NSRInternalFrame.MostrarFecha(dpHasta, 1), "2", ConfigInicial.LlenarConfig()[15].toString(),
							String.valueOf(c.getTABLA()));
					List<Object> ll = (List<Object>) (new HttpTest()).synCentral(1, c.getTABLA(),
							ConfigInicial.LlenarConfig()[8], ConfigInicial.LlenarConfig()[9],
							NSRInternalFrame.MostrarFecha(dpDesde, 1), NSRInternalFrame.MostrarFecha(dpHasta, 1), "2",
							ConfigInicial.LlenarConfig()[15].toString());
					int temp = 0;
					Class cl = Class.forName("com.nisira.entidad." + c.getTABLA());

					List d = (new GenericDAO<>(cl)).listar(1);
					if (d.isEmpty()) {
						List datos = new ListCreator<>(cl).genList(tl, cl);
//						for(int i=0;i<datos.size();i++){
//							(new GenericDAO<>(cl)).insertar(1, datos.get(i));
//						}
						(new GenericDAO<>(cl)).insertar(1,datos);
						
					} else {
						for (Object o : tl) {
							boolean cond = false;
							for (Object ol : ll) {
								String Ob1 = (new GenericObjectString<>(cl)).GenString(o);
								String Ob2 = (new GenericObjectString<>(cl)).GenString(ol);
								if (Ob1.equals(Ob2)) {
									cond = true;
									break;
								}
							}
							if (!cond) {
								(new GenericDAO<>(cl)).mezclar(1,cl.cast(o));
							}
							temp++;
							System.out.println(c.getTABLA() + " " + temp);
						}
					}
				} catch (ClassNotFoundException | NumberFormatException | SQLException | ParseException
						| NisiraORMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void CargaNotificaciones() {
		CargaNotificaciones ej = new CargaNotificaciones();
		NotacionesThread.hilo = new Thread(ej, NotacionesThread.tMaintFrame_Notifiacion);
		NotacionesThread.hilo.start();
		Constantes.log.info(NotacionesThread.hilo.getName());
	}

	class CargaNotificaciones implements Runnable {
		@Override
		public synchronized void run() {
			// TODO Auto-generated method stub
			while (true) {
				cargarNotificaciones();
				AsignarNotificacionActiva();
				actualizarTextNotificacion();
				try {
					Thread.sleep(NotacionesThread.time_MainFrame_Notificacion);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
