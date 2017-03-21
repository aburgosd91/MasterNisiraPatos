package com.nisira.vista.formularios;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JWindow;
import javax.swing.ListSelectionModel;

import org.apache.commons.lang.SerializationUtils;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import com.nisira.Inicio;
import com.nisira.clientservice.HttpGENERACIONCODIGO;
import com.nisira.clientservice.HttpTablaSincroniza;
import com.nisira.clientservice.HttpTest;
import com.nisira.core.EConexion;
import com.nisira.core.NisiraORMException;
import com.nisira.dao.ALMACENDao;
import com.nisira.dao.DDNFORMAUBICACIONDao;
import com.nisira.dao.DDPROGRAMACIONALMPRIORIDADDao;
import com.nisira.dao.DGENERACIONCODIGOSDao;
import com.nisira.dao.DNFORMAUBICACIONDao;
import com.nisira.dao.DPROGALMMONTACARGADao;
import com.nisira.dao.DPROGRAMAALMPRIORIDADDao;
import com.nisira.dao.DREGLADao;
import com.nisira.dao.DZONAGENERALDao;
import com.nisira.dao.GENERACIONCODIGOSDao;
import com.nisira.dao.GenericDAO;
import com.nisira.dao.LogEnvioDao;
import com.nisira.dao.PROGRAMAALMDao;
import com.nisira.dao.REGLADao;
import com.nisira.dao.RESPONSABLEDao;
import com.nisira.dao.SINCRONIZADao;
import com.nisira.dao.ZONAGENERALDao;
import com.nisira.entidad.ALMACEN;
import com.nisira.entidad.CONFIGTABLASINCRO;
import com.nisira.entidad.DDNFORMAUBICACION;
import com.nisira.entidad.DDPROGRAMACIONALMPRIORIDAD;
import com.nisira.entidad.DGENERACIONCODIGOS;
import com.nisira.entidad.DNFORMAUBICACION;
import com.nisira.entidad.DPROGRAMAALMMONTACARGA;
import com.nisira.entidad.DPROGRAMAALMPRIORIDAD;
import com.nisira.entidad.DREGLA;
import com.nisira.entidad.DZONAGENERAL;
import com.nisira.entidad.FilaSyncro;
import com.nisira.entidad.GENERACIONCODIGOS;
import com.nisira.entidad.LogEnvio;
import com.nisira.entidad.PROGRAMAALM;
import com.nisira.entidad.REGLA;
import com.nisira.entidad.RESPONSABLE;
import com.nisira.entidad.SINCRONIZA;
import com.nisira.entidad.TABLASINCRONIZA;
import com.nisira.entidad.ZONAGENERAL;
import com.nisira.utilitarios.GenericObjectString;
import com.nisira.utilitarios.ListCreator;
import com.nisira.utils.nisiracore.Constantes;
import com.nisira.vista.celleditor.TxtSysFormulario;
import com.nisira.vista.controles.MaestroTableModel;
import com.nisira.vista.controles.NSRDatePicker;
import com.nisira.vista.controles.NSRInternalFrame;
import com.nisira.vista.controles.NSRTable;
import com.nisira.vista.controles.NSRTableModel;
import com.nisira.vista.formularios.FrmPorFirmar.Automatico;
import com.nisira.vista.formularios.FrmPorFirmar.ListenerError;
import com.nisira.vista.formularios.maestros.AbstractMaestro;
import com.thoughtworks.xstream.XStream;

import core.inicio.ConectionManager;
import core.inicio.ConfigInicial;

import javax.swing.JButton;

public class FrmSincronizacion extends NSRInternalFrame implements InternalFrameListener{
	private static final long serialVersionUID = 1L;
	/******************* TABLA SINCRONIZA **********************/
	private List<CONFIGTABLASINCRO> listConfTablas;
	private List<TABLASINCRONIZA> listTABLASINCRONIZA;
	/********************************************************/
	private NSRDatePicker dpDesde;
	private NSRDatePicker dpHasta;

	private NSRTable table;
	private JButton btnMostrar;
	private JButton btnEnviar;
	private JProgressBar pb;

	private JWindow errorPopUpWindow = null;

	// Errores
	private JButton btnErrores;
	// private Thread hAutomatico;
	// private Automatico automatico = new Automatico();
	private LogEnvioDao logenvioDao = new LogEnvioDao();
	private PnlErrores pnlErrores;

	private LogEnvioDao logEnvioDao = new LogEnvioDao();
	private boolean selTodos = true;
	private JPanel pnlContenido;
	private NSRTable tblOpciones;

	/* COMPONENTES */
	private NSRTable tblTablaEstructura;
	private JScrollPane scrollPanel;
	private JButton btnDescarga;

	public FrmSincronizacion() throws ClassNotFoundException, NumberFormatException, SQLException, ParseException {
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setVisible(true);
		setResizable(true);
		setName("FrmSincronizacion");
		setTitle("Panel de Sincronizaciones Pendientes");		
		setSize(new Dimension(888, 600));
		setPreferredSize(new Dimension(888, 600));

		dpDesde = new NSRDatePicker();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		dpDesde.setDate(cal.getTime());

		JLabel lblDesde = new JLabel("Desde");

		JLabel lblHasta = new JLabel("Hasta");

		JLabel lblServidor = new JLabel("Servidor");
		this.addInternalFrameListener(this);
		// JLabel lblServidor = new JLabel("Servidor destino: ");
		pb = new JProgressBar();
		pb.setStringPainted(true);
		pb.setString("");
		pb.setVisible(false);

		dpHasta = new NSRDatePicker();
		dpHasta.setDate(new Date());

		btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					listConfTablas = (new HttpTablaSincroniza()).bajarServidor("TABLASINCRONIZA",
							"Sincronizacion.xhtml", ConfigInicial.LlenarConfig()[8], ConfigInicial.LlenarConfig()[9],
							NSRInternalFrame.MostrarFecha(dpDesde, 1), NSRInternalFrame.MostrarFecha(dpHasta, 1), "0",
							ConfigInicial.LlenarConfig()[15],
							"");/*
								 * MEJORAR (IDEMPRESA+ IDSUCURSAL+DESDE+ HASTA+
								 * OPERACION)
								 */
					llenar_lista();
					//
				} catch (ParseException | SQLException | NumberFormatException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnEnviar = new JButton("Sincronizar");
		btnEnviar.setEnabled(true);

		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int c = getDetalleTM().getTable().getColumnCount();
				int r = getDetalleTM().getTable().getRowCount();
				List<FilaSyncro> lfs = new ArrayList<FilaSyncro>();
				for (int i = 0; i < r; i++) {
					pb.setString("");
					pb.setValue(0);
					Object[] O = new Object[c];
					FilaSyncro fs = new FilaSyncro();
					for (int j = 0; j < c; j++) {
						if ((boolean) (getDetalleTM().getTable().getValueAt(i, 0))) {
							O[j] = getDetalleTM().getTable().getValueAt(i, j);
						}
					}
					if ((boolean) (getDetalleTM().getTable().getValueAt(i, 0))) {
						fs.setSincro((boolean) O[0]);
						fs.setDescripcion((String) O[1]);
						fs.setPendientes((int) O[2]);
						fs.setTipo((String) O[3]);
						fs.setTabla(i + 1);
						lfs.add(fs);
					}

				}
				for (FilaSyncro filsin : lfs) {
					try {
						Administrador(filsin, filsin.getTabla());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					llenar_lista();
				} catch (NumberFormatException | ClassNotFoundException | SQLException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnErrores = new JButton("Errores");
		btnErrores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<SINCRONIZA> ls = new ArrayList<SINCRONIZA>();
				try {
					ls = (new SINCRONIZADao()).listar(1, "idempresa = ? and idsucursal = ?", ConfigInicial.LlenarConfig()[8],
							ConfigInicial.LlenarConfig()[9]);
				} catch (NisiraORMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				StringBuffer sb= new StringBuffer();
				for(SINCRONIZA s: ls){
					sb.append(s.getLOGSEGUIMIENTO());
					sb.append(System.lineSeparator());
				}
				FrmLogSyncro frm = new FrmLogSyncro(sb.toString());
				frm.setVisible(true);
				Inicio.desktoppane.add(frm);
				frm.show();
			}
		});

		pnlErrores = new PnlErrores() {
			private static final long serialVersionUID = 1L;

			@Override
			public void consultar() {
				SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

				List<LogEnvio> log;
				try {
					log = logEnvioDao.getDesde(1, this.datePicker.getDate());
					while (this.model.getRowCount() != 0) {
						this.model.removeRow(0);
					}

					for (LogEnvio l : log) {
						model.addRow(new Object[] { dt.format(l.getFechaHora()), l.getMensaje() });
					}
				} catch (SQLException | NisiraORMException e) {
					e.printStackTrace();
				}

			}
		};

		pnlErrores.datePicker.setDate(new java.util.Date());

		errorPopUpWindow = new JWindow(Inicio.mainF);
		errorPopUpWindow.setOpacity(0.95f);
		errorPopUpWindow.getContentPane().add(pnlErrores);
		errorPopUpWindow.pack();

		// ListenerError listenerError = new ListenerError();
		// pnlErrores.table.addFocusListener(listenerError);
		// btnErrores.addFocusListener(listenerError);

		// TODO Auto-generated constructor stub
		scrollPanel = new JScrollPane();
		pnlContenido = new JPanel();

		tblTablaEstructura = new NSRTable(
				new NSRTableModel(new String[] { "Elegir", "Descripción", "Pendientes", "T.Sincronizacion" }) {
					/*************************************************/
					private static final long serialVersionUID = 1L;

					@Override
					public boolean evaluaEdicion(int row, int column) {
						if (column == 0)
							return true;
						return getEditar();
					}

					@Override
					public void addRow() {
						addRow(new Object[] { false, "", "", "" });
					}

					@Override
					public Class<?> getColumnClass(int column) {
						// TODO Auto-generated method stub
						if (column == 0) {
							return Boolean.class;
						}
						return super.getColumnClass(column);
					}

				});

		tblTablaEstructura.setFillsViewportHeight(true);
		scrollPanel.setViewportView(tblTablaEstructura);
		tblTablaEstructura.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		getDetalleTM().setNombre_detalle("Sincronización Formulario");

		getDetalleTM().setObligatorios(0, 1);
		getDetalleTM().setRepetidos(0);
		getDetalleTM().setScrollAndTable(scrollPanel, tblTablaEstructura);

		btnDescarga = new JButton("Descargar");

		JButton btnSyncFuente = new JButton("Envio Datos");
		btnSyncFuente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int c = getDetalleTM().getTable().getColumnCount();
				int r = getDetalleTM().getTable().getRowCount();
				List<FilaSyncro> lfs = new ArrayList<FilaSyncro>();
				for (int i = 0; i < r; i++) {
					Object[] O = new Object[c];
					FilaSyncro fs = new FilaSyncro();
					for (int j = 0; j < c; j++) {
						if ((boolean) (getDetalleTM().getTable().getValueAt(i, 0))) {
							O[j] = getDetalleTM().getTable().getValueAt(i, j);
						}
					}
					if ((boolean) (getDetalleTM().getTable().getValueAt(i, 0))) {
						fs.setSincro((boolean) O[0]);
						fs.setDescripcion((String) O[1]);
						fs.setPendientes((int) O[2]);
						fs.setTipo((String) O[3]);
						fs.setTabla(i + 1);
						lfs.add(fs);
					}

				}
				for (FilaSyncro filsin : lfs) {
					List<Object> olist;
					List<Object> olist2;
					try {
						olist = (new HttpTest()).synCentral(1, filsin.getDescripcion(), ConfigInicial.LlenarConfig()[8],
								ConfigInicial.LlenarConfig()[9], NSRInternalFrame.MostrarFecha(dpDesde, 1),
								NSRInternalFrame.MostrarFecha(dpHasta, 1), String.valueOf(filsin.getTabla()),
								ConfigInicial.LlenarConfig()[15].toString());
						olist2 = (new HttpTest()).synCentral(2, filsin.getDescripcion(), ConfigInicial.LlenarConfig()[8],
								ConfigInicial.LlenarConfig()[9], NSRInternalFrame.MostrarFecha(dpDesde, 1),
								NSRInternalFrame.MostrarFecha(dpHasta, 1), String.valueOf(filsin.getTabla()),
								ConfigInicial.LlenarConfig()[15].toString());
						Class cl = Class.forName("com.nisira.entidad." + filsin.getDescripcion());
						int temp = 0;
						if(olist2.isEmpty()){
								(new GenericDAO<>(cl)).insertarTest(2,olist);
						}else{
							for (Object o : olist) {
								boolean cond = false;
								for(Object o2 : olist2){
									String Ob1 = (new GenericObjectString<>(cl)).GenString(o);
									String Ob2 = (new GenericObjectString<>(cl)).GenString(o2);
									if (Ob1.equals(Ob2)) {
										cond = true;
										break;
									}
								}
								if (!cond) {
									(new GenericDAO<>(cl)).mezclar(2,cl.cast(o));
								}
								temp++;
								System.out.println(filsin.getDescripcion() + " " + temp);
							}
						}						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						SINCRONIZA a = new SINCRONIZA();
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						a.setIDEMPRESA(Integer.parseInt(ConfigInicial.LlenarConfig()[8]));
						a.setIDSUCURSAL(Integer.parseInt(ConfigInicial.LlenarConfig()[9]));
						Date dini = null;
						Date dfni = null;
						try {
							dini = dateFormat.parse(NSRInternalFrame.MostrarFecha(dpDesde, 1));
							dfni = dateFormat.parse(NSRInternalFrame.MostrarFecha(dpHasta, 1));
						} catch (ParseException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						a.setFECHAINICIO(dini);
						a.setFECHAFIN(dfni);
						a.setIDUSUARIO(Inicio.usuario.getIdUsuario());
						a.setTIPO(filsin.getTipo().equalsIgnoreCase("Manual") ? 1 : 2);
						a.setLOGSEGUIMIENTO(filsin.getDescripcion() + ":" + e.toString());
						Timestamp ini = new Timestamp(dini.getTime());
						Timestamp fin = new Timestamp(dfni.getTime());
						(new SINCRONIZADao()).grabarLog(a.getIDEMPRESA(), a.getIDSUCURSAL(), a,ini,fin);
					}
				}
			}

		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(284)
							.addComponent(btnSyncFuente)
							.addGap(18)
							.addComponent(btnErrores)
							.addGap(18)
							.addComponent(lblDesde, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dpDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblHasta, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dpHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnMostrar, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPanel, GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(pb, GroupLayout.PREFERRED_SIZE, 746, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnEnviar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addGap(10))
								.addComponent(lblServidor))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(374)
							.addComponent(lblServidor))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnMostrar)
								.addComponent(dpHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHasta)
								.addComponent(dpDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDesde)
								.addComponent(btnErrores)
								.addComponent(btnSyncFuente))
							.addGap(18)
							.addComponent(scrollPanel, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)))
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pb, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEnviar))
					.addContainerGap())
		);

		/************************************************************************************/
		getContentPane().setLayout(groupLayout);
		listConfTablas = (new HttpTablaSincroniza()).bajarServidor("TABLASINCRONIZA", "Sincronizacion.xhtml",
				ConfigInicial.LlenarConfig()[8], ConfigInicial.LlenarConfig()[9],
				NSRInternalFrame.MostrarFecha(dpDesde, 1), NSRInternalFrame.MostrarFecha(dpHasta, 1), "0",
				ConfigInicial.LlenarConfig()[15],
				"");/*
					 * MEJORAR (IDEMPRESA+ IDSUCURSAL+DESDE+ HASTA+ OPERACION)
					 */
		llenar_lista();
		pack();
	}

	public NSRTableModel getDetalleTM() {
		return ((NSRTableModel) tblTablaEstructura.getModel());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void Administrador(FilaSyncro f, int tablas) {
		try {
			List<Object> tl = (List<Object>) (new HttpTablaSincroniza()).fall(f.getDescripcion(),
					"Sincronizacion.xhtml", ConfigInicial.LlenarConfig()[8].toString(),
					ConfigInicial.LlenarConfig()[9].toString(), NSRInternalFrame.MostrarFecha(dpDesde, 1),
					NSRInternalFrame.MostrarFecha(dpHasta, 1), String.valueOf(f.getTabla()),
					ConfigInicial.LlenarConfig()[15].toString(), String.valueOf(f.getDescripcion()));
			List<Object> ll = (List<Object>) (new HttpTest()).synCentral(1, f.getDescripcion(),
					ConfigInicial.LlenarConfig()[8], ConfigInicial.LlenarConfig()[9],
					NSRInternalFrame.MostrarFecha(dpDesde, 1), NSRInternalFrame.MostrarFecha(dpHasta, 1),
					String.valueOf(f.getTabla()), ConfigInicial.LlenarConfig()[15].toString());
			int temp = 0;
			Class cl = Class.forName("com.nisira.entidad." + f.getDescripcion());

			List d = (new GenericDAO<>(cl)).listar(1);
			if (d.isEmpty()) {
				List datos = new ListCreator<>(cl).genList(tl, cl);
//				for(int i=0;i<datos.size();i++){
//					(new GenericDAO<>(cl)).insertar(1, datos.get(i));
//				}
					(new GenericDAO<>(cl)).insertarTest(1,datos);
				
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
					System.out.println(f.getDescripcion() + " " + temp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			SINCRONIZA a = new SINCRONIZA();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			a.setIDEMPRESA(Integer.parseInt(ConfigInicial.LlenarConfig()[8]));
			a.setIDSUCURSAL(Integer.parseInt(ConfigInicial.LlenarConfig()[9]));
			Date dini = null;
			Date dfni = null;
			try {
				dini = dateFormat.parse(NSRInternalFrame.MostrarFecha(dpDesde, 1));
				dfni = dateFormat.parse(NSRInternalFrame.MostrarFecha(dpHasta, 1));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			a.setFECHAINICIO(dini);
			a.setFECHAFIN(dfni);
			a.setTIPO(f.getTipo().equalsIgnoreCase("Manual") ? 1 : 2);
			a.setIDUSUARIO(Inicio.usuario.getIdUsuario());
			a.setLOGSEGUIMIENTO(f.getDescripcion() + ":" + e.toString());
			Timestamp ini = new Timestamp(dini.getTime());
			Timestamp fin = new Timestamp(dfni.getTime());
			(new SINCRONIZADao()).grabarLog(a.getIDEMPRESA(), a.getIDSUCURSAL(), a,ini,fin);
		}

	}

	@SuppressWarnings("unchecked")
	public void llenar_lista() throws ClassNotFoundException, NumberFormatException, SQLException, ParseException {
		getDetalleTM().limpiar();
		listTABLASINCRONIZA = new ArrayList<TABLASINCRONIZA>();
		Mostrar m = new Mostrar(getDetalleTM());
		new Thread(m, "Mostrar").start();
		// if (listTABLASINCRONIZA.size() > 0) {
		// System.out.println(listTABLASINCRONIZA.get(0));
		// setGeneracionCodigos(listTABLASINCRONIZA.get(0));
		// tblTablaEstructura.setRowSelectionInterval(0, 0);
		// }
		/*****************************************************************************************/
	}
	class MostrarSync implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
	class Mostrar implements Runnable {
		private NSRTableModel tabla;

		public Mostrar(NSRTableModel tabla) {
			this.tabla = tabla;
		}

		@Override
		public void run() {
			pb.setVisible(true);
			pb.setString("");
			pb.setValue(0);
			float valor = 0F;
			float rango = 100 / (float) listConfTablas.size();
			for (CONFIGTABLASINCRO l : listConfTablas) {
				TABLASINCRONIZA t = new TABLASINCRONIZA();
				t.setSELECTED(l.getTIPOSINCRO() == 1 ? false : true);
				t.setTABLA(l.getTABLA());
				try {
					List<Object> tl = (List<Object>) (new HttpTablaSincroniza()).fall(t.getTABLA(),
							"Sincronizacion.xhtml", ConfigInicial.LlenarConfig()[8].toString(),
							ConfigInicial.LlenarConfig()[9].toString(), NSRInternalFrame.MostrarFecha(dpDesde, 1),
							NSRInternalFrame.MostrarFecha(dpHasta, 1), "2", ConfigInicial.LlenarConfig()[15].toString(),
							String.valueOf(t.getTABLA()));

					List<Object> ll = (List<Object>) (new HttpTest()).synCentral(1, t.getTABLA(),
							ConfigInicial.LlenarConfig()[8], ConfigInicial.LlenarConfig()[9],
							NSRInternalFrame.MostrarFecha(dpDesde, 1), NSRInternalFrame.MostrarFecha(dpHasta, 1), "2",
							ConfigInicial.LlenarConfig()[15].toString());

					int con = 0;
					int temp = 0;
					Class cl = Class.forName("com.nisira.entidad." + t.getTABLA());
					valor += rango;
					pb.setValue((int) (valor));
					pb.setString("Consultando origen de Datos: " + t.getTABLA().trim().toUpperCase());
					for (Object ot : tl) {
						boolean cond = false;
						if (ll.isEmpty()) {
							con = tl.size();
							break;
						}
						for (Object ol : ll) {
							String Ob1 = (new GenericObjectString<>(cl)).GenString(ot);
							String Ob2 = (new GenericObjectString<>(cl)).GenString(ol);
							if (Ob1.equals(Ob2)) {
								cond = true;
								break;
							}
						}
						if (!cond) {
							con++;
						}
						temp++;
						if (temp == ll.size() && tl.size() >= ll.size()) {
							con = tl.size() - temp;
							break;
						}
						System.out.println(t.getTABLA() + " " + temp);
					}
					if (con > 0) {
						System.out.println("Paso por el loop");
					}
					t.setPENDIENTES(con);
					t.setTIPOSINC(l.getTIPOSINCRO() == 1 ? "Manual" : "Automatica");
					listTABLASINCRONIZA.add(t);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					SINCRONIZA a = new SINCRONIZA();
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					a.setIDEMPRESA(Integer.parseInt(ConfigInicial.LlenarConfig()[8]));
					a.setIDSUCURSAL(Integer.parseInt(ConfigInicial.LlenarConfig()[9]));
					Date dini = null;
					Date dfni = null;
					try {
						dini = dateFormat.parse(NSRInternalFrame.MostrarFecha(dpDesde, 1));
						dfni = dateFormat.parse(NSRInternalFrame.MostrarFecha(dpHasta, 1));							
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Timestamp ini = new Timestamp(dini.getTime());
					Timestamp fin = new Timestamp(dfni.getTime());
					a.setFECHAINICIO(dini);
					a.setFECHAFIN(dfni);
					a.setTIPO(l.getTIPOSINCRO());
					a.setIDUSUARIO(Inicio.usuario.getIdUsuario());
					a.setLOGSEGUIMIENTO(t.getTABLA() + ":" + e.toString());
					(new SINCRONIZADao()).grabarLog(a.getIDEMPRESA(), a.getIDSUCURSAL(), a,ini,fin);

				}
			}

			for (TABLASINCRONIZA ts : listTABLASINCRONIZA) {
				tabla.addRow(new Object[] { (ts.getSELECTED() == null ? false : ts.getSELECTED().booleanValue()),
								ts.getTABLA(), ts.getPENDIENTES(), ts.getTIPOSINC() });				
			}
			pb.setVisible(true);
			pb.setValue(0);
		}
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		ThreadGroup threadGroup = Thread.currentThread ().getThreadGroup ();
		Thread [] listaHilo= new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(listaHilo, true);
		for(int i=0;i<listaHilo.length;i++){
			Constantes.log.info(listaHilo[i].getName());
			if(listaHilo[i].getName().contains("Mostrar")){
				listaHilo[i].stop();
				break;
			}
		}
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		ThreadGroup threadGroup = Thread.currentThread ().getThreadGroup ();
		Thread [] listaHilo= new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(listaHilo, true);
		for(int i=0;i<listaHilo.length;i++){
			Constantes.log.info(listaHilo[i].getName());
			if(listaHilo[i].getName().contains("Mostrar")){
				listaHilo[i].stop();
				break;
			}
		}
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		
		// TODO Auto-generated method stub
		
	}
}
