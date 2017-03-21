package com.nisira;

import static com.nisira.utilitarios.UtilMensajes.mensaje_alterta;

import java.awt.EventQueue;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;

import com.nisira.alien.ComandosRfid;
import com.nisira.core.CoreUtil;
import com.nisira.core.EConexion;
import com.nisira.core.NisiraORMException;
import com.nisira.dao.EmpresaDao;
import com.nisira.dao.GrupoUsuarioDao;
import com.nisira.dao.UsuarioDao;
import com.nisira.entidad.CONFIGACTIVIDADES;
import com.nisira.entidad.Empresa;
import com.nisira.entidad.GrupoUsuario;
import com.nisira.entidad.NOTIFICACION;
import com.nisira.entidad.MUSUARIO;
import com.nisira.security.Encryption;
import com.nisira.utils.nisiracore.Constantes;
import com.nisira.vista.formularios.maestros.FrmLogin;
import com.nisira.vista.formularios.maestros.FrmLoginMovil;
import com.nisira.vista.formularios.maestros.FrmSysConfig;
import com.scrollabledesktop.JScrollableDesktopPane;

import controlador.Mensajes;
import core.inicio.ConectionManager;
import core.inicio.ConfigInicial;

public class Inicio {
	/*Configuración Patos*/
	public static final boolean consolesRfid=true;
	public static final int flujo =4;
	
	public static final String appName = "";

	public static final String EDICION = "EDICION";
	public static final String VISTA = "VISTA";
	public static final String NUEVO = "NUEVO";
	
	public static final int DIASBUSQUEDA = 20;
	public static final int LONGITUDNUMERO = 7;
	public static final String RUTATEMPORAL = System.getProperty("java.io.tmpdir");

	public final static String SYS_CONFIG = "config.properties";
	public final static String OG_CONFIG = "og.properties";
	public static EConexion cfgInicio;
	public static EConexion cfgOrigen;
	public static MUSUARIO usuario;
	public static Empresa empresa;
	public static JScrollableDesktopPane desktoppane;
	public static Mensajes mensajes;
	public final static Logger LOGGER = Logger.getLogger(Inicio.class.getName());
	public static NOTIFICACION notificacion;
	public static int idempresa;
	public static int idsucursal;
	public static int idmontacarga;
	private FrmSysConfig frm;
	public static MainFrame mainF;
	public static boolean validateConfigRfid;
	private String opcion;
	
	public static void main(String[] args) {
		
		new SplashScreen();
		Constantes.DEBUG = true;
		Constantes.log = Logger.getLogger(Inicio.class);
		
		try {
			salir: for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				switch (info.getName()) {
					case "GTK+":
						javax.swing.UIManager.setLookAndFeel(info.getClassName());
						break salir;
					case "Windows":
						javax.swing.UIManager.setLookAndFeel(info.getClassName());
						break salir;
					default:
						javax.swing.UIManager
								.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
						break;
					}
				}
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio sys = null;
					if (args != null && args.length > 0 && args[0] != null) {
						sys = new Inicio(args[0]);
					} else {
						sys = new Inicio("");
					}
					sys.iniciar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inicio(String opcion) {
		this.setOpcion(opcion);
	}

	public void iniciar() {
		mensajes = new Mensajes("ESPANOL");
		
		File sys_file = new File(SYS_CONFIG);
		File og_file = new File(OG_CONFIG);
		String[] datos = null;
		String[] Origen = null;
		frm = new FrmSysConfig();
		frm.setLocationRelativeTo(null);
		boolean isOK;
		boolean isOKg;
		if (sys_file.exists()) {
			datos = ConfigInicial.LlenarConfig();
			Origen = ConfigInicial.LlenarConfigServerWeb();
			if (datos != null) {
				cfgInicio = new EConexion();

				cfgInicio.SERVIDOR = datos[0];
				cfgInicio.BASE_DATOS = datos[1];
				cfgInicio.USUARIO = datos[2];
				cfgInicio.CLAVE = datos[3];
				cfgInicio.TIPO = datos[4];
				cfgInicio.INSTANCIA = datos[5];
				cfgInicio.URLSINCRO = datos[6];
				cfgInicio.TIPOSINCRO = datos[7];
				cfgInicio.IDEMPRESA = datos[8];
				cfgInicio.IDSUCURSAL = datos[9];
				cfgInicio.RUTAPROYECTO = datos[10];
				cfgInicio.RUTAINICIO = datos[11];
				cfgInicio.RUTAFIN = datos[12];
				cfgInicio.RUTAERRINICIO = datos[13];
				cfgInicio.RUTAERRFIN = datos[14];
				cfgInicio.IDCPUMOVIL = datos[15];
				CoreUtil.conexiones.put("default", cfgInicio);
				
				cfgOrigen= new EConexion();

				cfgOrigen.SERVIDOR = Origen[0];
				cfgOrigen.BASE_DATOS = Origen[1];
				cfgOrigen.USUARIO = Origen[2];
				cfgOrigen.CLAVE = Origen[3];
				cfgOrigen.TIPO = Origen[4];
				cfgOrigen.INSTANCIA = Origen[5];
				cfgOrigen.URLSINCRO = Origen[6];
				cfgOrigen.TIPOSINCRO = Origen[7];
				cfgOrigen.IDEMPRESA = Origen[8];
//				CoreUtil.conexiones.put("default", cfgOrigen);
//				if (this.opcion.equals("UPDATE")) {
//					cfgInicio.setTipo_creacion("UPDATE");
//				}
				CoreUtil.conexiones.put("sync", cfgOrigen);
				isOK = ConectionManager.isConexionOK(cfgInicio, null);
				isOKg = ConectionManager.isConexionOK(cfgOrigen, null);
				if (isOK & isOKg) {
					try {
						abrir();
					} catch (SQLException | NisiraORMException e) {
						e.printStackTrace();
					}
				} else {
					mensaje_alterta("ERROR_CONFIG");
					frm.addChangeListener(new ChangeListener() {
						@Override
						public void stateChanged(ChangeEvent arg0) {
							ConfigInicial.CrearConfigOrgien(frm.cfgOrigne);
							ConfigInicial.CrearConfig(frm.cfgInicio);
							
							iniciar();
						}
					});
					frm.setVisible(true);
				}
			}
		} else {
			mensaje_alterta("NO_HAY_CONFIG");
			frm.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent arg0) {
					ConfigInicial.CrearConfigOrgien(frm.cfgOrigne);
					ConfigInicial.CrearConfig(frm.cfgInicio);					
					iniciar();
					frm.dispose();
				}
			});
			frm.setVisible(true);
		}
	}

	public void abrir() throws SQLException, NisiraORMException {

		frm.setVisible(false);

		GrupoUsuarioDao guDao = new GrupoUsuarioDao();
		UsuarioDao usuDao = new UsuarioDao();

		EmpresaDao empresaDAO = new EmpresaDao();

		List<GrupoUsuario> lstGrupos = guDao.listar(1,"t0.Idgrupousuario = ?",
				"ADM");

		if (lstGrupos.isEmpty()) {
			GrupoUsuario grpAdmin = new GrupoUsuario();
			grpAdmin.setIdgrupousuario("ADM");
			grpAdmin.setDescripcion("Grupo de Administradores");
			grpAdmin.setEs_administrador(1);
			guDao.insertar(1,grpAdmin);
		}

		List<MUSUARIO> lusu = usuDao.listar(1,"t0.IdgrupoUsuario = ?", "ADM");

		if (lusu.isEmpty()) {
			MUSUARIO u = new MUSUARIO();
			u.setIdUsuario("ADMINISTRADOR");
			u.setEstado(1);
			u.setIdgrupoUsuario("ADM");
			u.setNombres("USUARIO ADMINISTRADOR");
			u.setClave(Encryption.pss_encrypt("administrador"));
			usuDao.insertar(1,u);
		}

		List<Empresa> leemp = empresaDAO.listar(1,"t0.id = ?", "0");

		if (leemp.isEmpty()) {
			Empresa empresa = new Empresa();
			empresa.setId("0");
			empresa.setRazonSocial("Nueva Empresa");
			empresa.setRUC("12345678901");
			empresa.setDireccion("Nueva Dirección");
			empresa.setRUTA_EXPORTAR("c://EXPORTAR");
			empresa.setRUTA_REPORTES("c://REPORTES");
			empresaDAO.insertar(1,empresa);
			Inicio.empresa = empresa;
		} else {
			Inicio.empresa = leemp.get(0);
		}

		FrmLoginMovil frm = new FrmLoginMovil();
		frm.setVisible(true);
		frm.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				iniciaMainFrame();
			}
		});
	}

	private void iniciaMainFrame() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Inicio.mainF=new MainFrame();
			}
		});
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}
}