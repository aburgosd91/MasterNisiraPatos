package com.nisira.vista.formularios;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseWheelEvent;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.text.StyleContext;

import org.json.JSONArray;
import org.json.JSONObject;

import com.alien.enterpriseRFID.reader.AlienReaderException;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.nisira.Inicio;
import com.nisira.alien.ReaderAlien;
import com.nisira.alien.TagsRfid;
import com.nisira.core.NisiraORMException;
import com.nisira.dao.ACCIONESDao;
import com.nisira.dao.ACTIVIDADESDao;
import com.nisira.dao.CONFIGACTIVIDADESDao;
import com.nisira.dao.DACCIONESDao;
import com.nisira.dao.DASIGNACIONCHIPSDao;
import com.nisira.dao.DGENERACIONCODIGOSDao;
import com.nisira.dao.DPROGRAMAALMEJECUCIONDao;
import com.nisira.dao.DZONAGENERALDao;
import com.nisira.dao.DprogramaciontareallegadaDao;
import com.nisira.dao.DprogramaciontareapartidaDao;
import com.nisira.dao.FLOYDDao;
import com.nisira.dao.GENERACIONCODIGOSDao;
import com.nisira.dao.MOVUBICACIONDao;
import com.nisira.dao.ProgramaciontareaDao;
import com.nisira.dao.ZONAGENERALDao;
import com.nisira.entidad.ACCIONES;
import com.nisira.entidad.ACTIVIDADES;
import com.nisira.entidad.CONFIGACTIVIDADES;
import com.nisira.entidad.CoordenadaMatriz;
import com.nisira.entidad.DACCIONES;
import com.nisira.entidad.DASIGNACIONCHIPS;
import com.nisira.entidad.DGENERACIONCODIGOS;
import com.nisira.entidad.DPROGRAMAALMEJECUCION;
import com.nisira.entidad.DPROGRAMACIONTAREALLEGADA;
import com.nisira.entidad.DPROGRAMACIONTAREAPARTIDA;
import com.nisira.entidad.DZONADIAGRAMA;
import com.nisira.entidad.DZONAGENERAL;
import com.nisira.entidad.FLOYD;
import com.nisira.entidad.GENERACIONCODIGOS;
import com.nisira.entidad.MOVUBICACION;
import com.nisira.entidad.PROGRAMACIONLLENADO;
import com.nisira.entidad.PROGRAMACIONTAREA;
import com.nisira.entidad.ZONAGENERAL;
import com.nisira.floy.Floyd;
import com.nisira.libgdx.NisiraLibGDX;
import com.nisira.libgdx.entities.Zelda;
import com.nisira.thread.NotacionesThread;
import com.nisira.utilitarios.TextPanelStyle;
import com.nisira.utils.nisiracore.Constantes;
import com.nisira.vista.barras.PanelBarraMaestro;
import com.nisira.vista.controles.JTextLabelPanel;
import com.nisira.vista.controles.NSRInternalFrame;
import com.nisira.vista.movil.map.ConfigTooltip;
import com.nisira.vista.movil.map.DiagramaDistribucion;
import com.nisira.vista.movil.map.MatrizRutas;
import com.nisira.vista.movil.map.StreetView;
import com.nisira.vista.utilitarios.ProgressBarDialog;

import core.inicio.ConfigInicial;
import javafx.util.Pair;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import test.GeneracionCodigoXml;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import com.nisira.vista.formularios.movil.ObjetoTecladoMovil;
import com.nisira.vista.formularios.movil.PanelHeaderMovilZona;
import java.awt.Canvas;

public class FrmSysZona extends NSRInternalFrame implements InternalFrameListener {
	private static final long serialVersionUID = 7755124973019289267L;
	/*** CONFIGURACIONES ***/
	public final static int widthPanel = 734;
	public final static int heightPanel = 500;
	public final int timer = 200;
	final Integer tiempoCierre = 15;
	public static int varHiloUbicacion = 0;
	final Color alerta = Color.white;
	private int tamanio;
	public Boolean panelActivo;
	public ProgressBarDialog progress;
	/******* CONTROLS *****/
	public JTextPane textPaneInfo;
	public ThreadGroup threadGroup;
	public Thread hilo;
	private JScrollPane ScrollPaneZona;
	private JScrollPane scrollPanelCabecera;
	private JPanel panelCabecera;
	private JCheckBox cbLlegada;
	private LwjglApplicationConfiguration config;
	private LwjglApplication lwjl;
	private Canvas canvas;
	private Observado observable_pos_actual;
	private Observable_Rutas observable_Rutas;
	private Observado_parpadeo observado_parpadeo;
	private ApplicationListener appListener;
	/******* ARRAY *******/
	private static List<ObjetoTecladoMovil> listTecladoMovil_CodigoBarra;
	private static ObjetoTecladoMovil tecladoMovil_RfidUbicacion;
	private List<DZONAGENERAL> listDzonaGeneral;
	private List<DZONAGENERAL> listDzonaGeneralCalles;
	private List<DZONAGENERAL> listDZonaGeneralPos;
	private List<DPROGRAMACIONTAREAPARTIDA> listDPROGRAMACIONTAREAPARTIDA;
	private List<DPROGRAMACIONTAREALLEGADA> listDPROGRAMACIONTAREALLEGADA;
	private List<DACCIONES> listDAcciones;
	private List<ACCIONES> listAcciones;
	private List<ACTIVIDADES> listActividades;
	private List<GENERACIONCODIGOS> listGeneracionCodigo;
	public List<CoordenadaMatriz> puntosExtremos;
	private List<DASIGNACIONCHIPS> listDAsignacionChips;
	private List<MOVUBICACION> listMovUbicacion;
	private static String[] objectPanelTexto;
	/******* ENTITY ******/
	public MatrizRutas wrutas;
	public Process process;
	private ZONAGENERAL zonaGeneral;
	private PROGRAMACIONTAREA programacionTarea;
	private DPROGRAMAALMEJECUCION ubicacionDispobible;
	private ACCIONES accionSelection;
	private DACCIONES dacciones;
	private CONFIGACTIVIDADES configActManulAutomatic;
	private DZONAGENERAL posicion;
	/*** DAO ***/
	private ZONAGENERALDao zonaGeneralDao;
	private DZONAGENERALDao dzonaGeneralDao;
	private ProgramaciontareaDao programacionTareaDao;
	private DprogramaciontareallegadaDao dprogramacionTareallegadaDao;
	private DprogramaciontareapartidaDao dprogramacionTareapartidaDao;
	private DPROGRAMAALMEJECUCIONDao dPROGRAMAALMEJECUCIONDao;
	private DACCIONESDao daccionesDao;
	private CONFIGACTIVIDADESDao configActividadesDao;
	private MOVUBICACIONDao movubicacionDao;

	public void __constructor() {
		/*** CONFIGURACIONES ***/
		setTamanio(2);
		panelActivo = true;
		/*** ARRAY ***/
		listTecladoMovil_CodigoBarra = new ArrayList<>();
		setListDzonaGeneral(new ArrayList<DZONAGENERAL>());
		listGeneracionCodigo = new ArrayList<GENERACIONCODIGOS>();
		setListDAsignacionChips(new ArrayList<DASIGNACIONCHIPS>());
		puntosExtremos = new ArrayList<CoordenadaMatriz>();
		listDPROGRAMACIONTAREAPARTIDA = new ArrayList<>();
		listDPROGRAMACIONTAREALLEGADA = new ArrayList<>();
		listDAcciones = new ArrayList<>();
		listAcciones = new ArrayList<>();
		listActividades = new ArrayList<>();
		listMovUbicacion = new ArrayList<>();
		/*** ENTITY ***/
		tecladoMovil_RfidUbicacion = new ObjetoTecladoMovil();
		zonaGeneral = new ZONAGENERAL();
		programacionTarea = new PROGRAMACIONTAREA();
		ubicacionDispobible = new DPROGRAMAALMEJECUCION();
		dacciones = new DACCIONES();
		/*** DAO ***/
		daccionesDao = new DACCIONESDao();
		zonaGeneralDao = new ZONAGENERALDao();
		dzonaGeneralDao = new DZONAGENERALDao();
		dPROGRAMAALMEJECUCIONDao = new DPROGRAMAALMEJECUCIONDao();
		programacionTareaDao = new ProgramaciontareaDao();
		dprogramacionTareapartidaDao = new DprogramaciontareapartidaDao();
		dprogramacionTareallegadaDao = new DprogramaciontareallegadaDao();
		configActividadesDao = new CONFIGACTIVIDADESDao();
		movubicacionDao = new MOVUBICACIONDao();
		/*** OBSERVABLES ***/
		observable_Rutas = new Observable_Rutas();
		observable_pos_actual = new Observado();
		observado_parpadeo = new Observado_parpadeo();
	}

	public void configDatosIniciales() {
		try {
			/* CARGAR ACCIONES POR VISTA */
			// listDAccionesVista = (new
			// DaccionesvistaDao()).findAllVista(Inicio.idempresa,
			// "FrmSysZona");
			listAcciones = (new ACCIONESDao()).findAccionesXVista(Inicio.idempresa, "FrmSysZona");
			listActividades = (new ACTIVIDADESDao()).findAllActividadesVista(Inicio.idempresa, "FrmSysZona");
			// listDAcciones = (new
			// DACCIONESDao()).findDAcciones(Inicio.idempresa, "FrmSysZona");
			accionTransicion();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void cargarDatosMapa() {
		try {
			/* CARGAR DATOS DE MAPA */
			zonaGeneral = zonaGeneralDao.getZonaGeneralPrincipal(Inicio.idempresa, Inicio.idsucursal);
			this.setListDzonaGeneral(dzonaGeneralDao.getLisDZonaGeneral_(zonaGeneral));
			/******* CARGAR UBICACIONES POR DONDE TRANSCITAR **********/
			listDzonaGeneralCalles = dzonaGeneralDao.getLisDZonaGeneralCalles(1, zonaGeneral);
			listGeneracionCodigo = (new GENERACIONCODIGOSDao()).listar(1,
					"IDEMPRESA=? AND PARAMETRO=? AND ESTADO=? AND IDPROCESO=?", ConfigInicial.LlenarConfig()[8],
					"FrmSysZona", 1, programacionTarea.getIDPROCESO());
			/******* RECONSTRUCCIÓN DE XML **********/
			if (listGeneracionCodigo.size() > 0)
				GeneracionCodigoXml.reconstruccionXML(listGeneracionCodigo);
			/* CARGA PROGRAMACION */
			/* RECONOCIMIENTO DE CHIPS */
			setListDAsignacionChips((new DASIGNACIONCHIPSDao()).getListAdsignacionChips(
					Integer.parseInt(ConfigInicial.LlenarConfig()[8]),
					Integer.parseInt(ConfigInicial.LlenarConfig()[9])));
			/* CARGAR CONFIGURACION DE ACTIVIDADES */
			// listConfigActividades = (new
			// CONFIGACTIVIDADESDao()).listar(1,true);
			/* CARGAR DATOS DE UBICACIÓN (LLENO / VACION) */
			listMovUbicacion = movubicacionDao.listUbicacionContenido(Inicio.idempresa, Inicio.idsucursal, 0);
			// progress.execProgress();
			/* DATOS LIBGDX */
			if (config == null) {
				config = new LwjglApplicationConfiguration();
				config.width = ScrollPaneZona.getWidth();
				config.height = ScrollPaneZona.getHeight();
				config.forceExit = false;
			}

			if (appListener == null) {

				appListener = new NisiraLibGDX(observable_pos_actual, observable_Rutas) {
					@Override
					public void LlenarZelda() {
						for (DZONAGENERAL obj : listDzonaGeneral) {
							obj.getTIPORACKS();
							this.zelda.add(new Zelda(obj.getCORDENADAX(), obj.getCORDENADAY(), 1, obj.getCOLOR(),
									obj.getTIPORACKS(), obj.getIDUBICACION()));
						}
					}
				};
				lwjl = new LwjglApplication(appListener, config, canvas);
			}
			CargarRutas();
		} catch (SQLException | NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cargarDatosTareaRealizar() {
		try {
			/* CARGAR DATOS DE TAREA */
			if (Inicio.notificacion != null) {
				programacionTarea = programacionTareaDao.findProgramacionTarea(Inicio.idempresa, Inicio.idsucursal,
						Inicio.notificacion.getTOQUEN(), Inicio.idmontacarga,
						1);/* ESTADO -> PENDIENTE */
				if (programacionTarea != null) {
					listDPROGRAMACIONTAREAPARTIDA = dprogramacionTareapartidaDao.findDPROGRAMACIONTAREAPARTIDA(
							Inicio.idempresa, Inicio.idsucursal, programacionTarea.getIDPROGRAMACIONTAREA());
					DPROGRAMACIONTAREAPARTIDA tarea = listDPROGRAMACIONTAREAPARTIDA.get(0);
					DZONAGENERAL dzonageneral;
					try {
						dzonageneral = dzonaGeneralDao.getDZonaGeneralxTarea(tarea.getIDEMPRESA(),
								tarea.getIDSUCURSAL(), tarea.getIDUBICACION());
						observable_Rutas.actualizar(dzonageneral);
						System.out.println("Observer Enviado");

						listDPROGRAMACIONTAREALLEGADA = dprogramacionTareallegadaDao.findDPROGRAMACIONTAREALLEGADA(
								Inicio.idempresa, Inicio.idsucursal, programacionTarea.getIDPROGRAMACIONTAREA());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			/* UBICACIONES DISPONIBLES */
			// progress.execProgress();
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cargarDatosEstadoUbicacion() {
		try {
			if (listMovUbicacion != null) {
				if (listMovUbicacion.size() > 0) {
					// panelZona.stockAlmacenes(this.listMovUbicacion);
					// panelZona.repaint();
				}
			}
			// progress.execProgress();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public FrmSysZona() {
		super();
		/********* CONFIGURACIONES *********/
		__constructor();
		configDatosIniciales();
		/******************************/
		setTitle("Configuración Zona");
		setMaximizable(true);
		setIconifiable(false);
		setClosable(true);
		setVisible(true);
		setResizable(true);
		this.show();
		this.addInternalFrameListener(this);
		ScrollPaneZona = new javax.swing.JScrollPane();
		ScrollPaneZona.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		ScrollPaneZona.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanelCabecera = new JScrollPane();
		scrollPanelCabecera.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanelCabecera.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPanelCabecera.setBorder(UIManager.getBorder("ScrollPane.border"));
		panelCabecera = new JPanel();
		panelCabecera.setBorder(null);
		scrollPanelCabecera.setViewportView(panelCabecera);
		panelCabecera.setLayout(new BoxLayout(panelCabecera, BoxLayout.Y_AXIS));

		JButton btnUbicacin = new JButton("Toca");
		btnUbicacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DZONAGENERAL dzonageneral = obtenerPosicionesLibres();
				if (dzonageneral != null) {
					observable_pos_actual.actualizar_parpadeo(dzonageneral);
				}
			}
		});
		JButton btnStop = new JButton("Stop Rfid");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NotacionesThread.stopThreadName(NotacionesThread.tFrmSysZona_Rfid);
			}
		});

		JButton btnMcodbarra = new JButton("M-CodBarra");
		btnMcodbarra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pos = 0;
				FrmMWCodigoBarras manualCodigoBarra = new FrmMWCodigoBarras(Inicio.mainF, "Código Barra") {
					@Override
					public void save() {
						// TODO Auto-generated method stub
						if (this.listField != null) {
							if (this.listField.size() > 0) {
								listTecladoMovil_CodigoBarra.clear();
								for (JTextLabelPanel obj : listField) {
									obj.value = obj.textField.getText();/* idgeneracioncodigo */
									listTecladoMovil_CodigoBarra.add(
											new ObjetoTecladoMovil("CODIGO_BARRA", obj.descripcion, obj.id, obj.value));
									CARGARCODIGO(obj.value);
								}
							}
						}
						int x = 1;
						for (ObjetoTecladoMovil obj : listTecladoMovil_CodigoBarra) {
							System.out.println("[" + (x++) + "]:" + obj.getValue());
						}
						this.cancel();
					}
				};
				manualCodigoBarra.setLocation(getWidth() / 2, (getHeight() / 2) - 100);
				/* DEFINICIONES */
				for (GENERACIONCODIGOS gc : listGeneracionCodigo) {
					manualCodigoBarra.listField.add(new JTextLabelPanel(pos++, gc.getIDGENERACION().toString(),
							gc.getDESCRIPCION(), "", gc.getNUMDIGITOTOTAL()) {
						@Override
						public void ordenfocusPanel() {
							if (manualCodigoBarra.listField.size() - 1 == row)
								manualCodigoBarra.listField.get(0).textField.requestFocus();
							else
								manualCodigoBarra.listField.get(row + 1).textField.requestFocus();
						}
					});
				}
				manualCodigoBarra.cargarRow();
				manualCodigoBarra.show();
				manualCodigoBarra.ordenfocus(0);
			}
		});

		JScrollPane scrollPaneInformacion = new JScrollPane();

		JButton btnDejarPalet = new JButton("Dejar Palet");
		btnDejarPalet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*** CAPTURAR ***/
				// MatrizRutas.probarRuta();
				try {
					if (Inicio.notificacion != null) {
						programacionTarea = programacionTareaDao.findProgramacionTarea(Inicio.idempresa,
								Inicio.idsucursal, Inicio.notificacion.getTOQUEN(), Inicio.idmontacarga,
								1);/* ESTADO -> PENDIENTE */
						if (programacionTarea != null) {
							listDPROGRAMACIONTAREAPARTIDA = dprogramacionTareapartidaDao.findDPROGRAMACIONTAREAPARTIDA(
									Inicio.idempresa, Inicio.idsucursal, programacionTarea.getIDPROGRAMACIONTAREA());
							DPROGRAMACIONTAREAPARTIDA tarea = listDPROGRAMACIONTAREAPARTIDA.get(0);
							DZONAGENERAL dzonageneral;
							try {
								dzonageneral = dzonaGeneralDao.getDZonaGeneralxTarea(tarea.getIDEMPRESA(),
										tarea.getIDSUCURSAL(), tarea.getIDUBICACION());
								observable_Rutas.actualizar(dzonageneral);
								System.out.println("Observer Enviado");

								listDPROGRAMACIONTAREALLEGADA = dprogramacionTareallegadaDao
										.findDPROGRAMACIONTAREALLEGADA(Inicio.idempresa, Inicio.idsucursal,
												programacionTarea.getIDPROGRAMACIONTAREA());
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// observable_Rutas.actualizar();
				System.out.println("Observer Enviado");
			}
		});

		JButton btnUbActual = new JButton("Ub. Actual");
		btnUbActual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		PanelHeaderMovilZona panelHeaderMovilZona = new PanelHeaderMovilZona(listActividades, 400, 200) {

			@Override
			public void actionMethod(ACTIVIDADES actividades) {
				// TODO Auto-generated method stub
				try {
					// Method[] methods = FrmSysZona.class.getMethods();
					// for (Method m : methods){
					// System.out.println(m);
					// if (m.getName().equals("ZoomMasDistribucion_")){
					// System.out.println("encontrado : "+m);
					// break;
					// }
					// }
					dacciones = daccionesDao.getPorClavePrimaria(Inicio.idempresa, accionSelection.getIDACCION(),
							actividades.getIDACTIVIDADES());
					Method method = null;
					if (dacciones != null) {
						configActManulAutomatic = configActividadesDao
								.getConfigxActividades(actividades.getIDACTIVIDADES());
						if (configActManulAutomatic != null) {
							switch (configActManulAutomatic.getTIPO()) {
							case 0: /* AUTOMÁTICO */
								method = FrmSysZona.class.getMethod(dacciones.getMETHODAUT().trim());
								;
								break;
							case 1: /* MANUAL */
								method = FrmSysZona.class.getMethod(dacciones.getMETHODMAN().trim());
								;
								break;
							}
							if (method != null)
								method.invoke(FrmSysZona.this);

						}
						// Method method =
						// FrmSysZona.class.getMethod(dacciones.getMETHODAUT());
						// method.invoke(FrmSysZona.this);
					}
				} catch (SecurityException | SQLException | NisiraORMException | NoSuchMethodException
						| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		};
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(
								ScrollPaneZona, Alignment.LEADING)
								.addGroup(layout
										.createSequentialGroup().addGroup(
												layout.createParallelGroup(Alignment.LEADING).addComponent(
														scrollPaneInformacion, GroupLayout.DEFAULT_SIZE, 470,
														Short.MAX_VALUE).addComponent(
																scrollPanelCabecera, GroupLayout.DEFAULT_SIZE, 470,
																Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout
												.createSequentialGroup().addGap(34).addComponent(btnStop)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addGroup(layout
																.createSequentialGroup().addComponent(btnDejarPalet)
																.addGap(18).addComponent(btnUbActual))
														.addGroup(layout.createSequentialGroup().addGap(8)
																.addComponent(btnUbicacin)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(btnMcodbarra)))
												.addPreferredGap(ComponentPlacement.RELATED, 143, Short.MAX_VALUE))
												.addComponent(panelHeaderMovilZona, GroupLayout.DEFAULT_SIZE, 424,
														Short.MAX_VALUE))))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneInformacion, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelHeaderMovilZona, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout
								.createSequentialGroup()
								.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnMcodbarra)
										.addComponent(btnStop).addComponent(btnUbicacin))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnUbActual)
										.addComponent(btnDejarPalet)))
						.addComponent(scrollPanelCabecera, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(ScrollPaneZona, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE).addContainerGap()));

		this.canvas = new Canvas();
		ScrollPaneZona.setViewportView(canvas);

		/* EDICIÓN */
		// Create the StyleContext, the document and the pane
		StyleContext sc = new StyleContext();
		textPaneInfo = new JTextPane();
		textPaneInfo.setContentType("text/html");
		textPaneInfo.setEditable(false);

		scrollPaneInformacion.setViewportView(textPaneInfo);
		getContentPane().setLayout(layout);
		CargarDatosInicial();

		pack();
	}

	public void ManualCodigoBarras() {
		int pos = 0;
		FrmMWCodigoBarras manualCodigoBarra = new FrmMWCodigoBarras(Inicio.mainF, "Código Barra") {
			@Override
			public void save() {
				// TODO Auto-generated method stub
				if (this.listField != null) {
					if (this.listField.size() > 0) {
						listTecladoMovil_CodigoBarra.clear();
						for (JTextLabelPanel obj : listField) {
							obj.value = obj.textField.getText();/* idgeneracioncodigo */
							listTecladoMovil_CodigoBarra
									.add(new ObjetoTecladoMovil("CODIGO_BARRA", obj.descripcion, obj.id, obj.value));
							CARGARCODIGO(obj.value);
						}
					}
				}
				int x = 1;
				for (ObjetoTecladoMovil obj : listTecladoMovil_CodigoBarra) {
					System.out.println("[" + (x++) + "]:" + obj.getValue());
				}
				this.cancel();
			}
		};
		manualCodigoBarra.setLocation(getWidth() / 2, (getHeight() / 2) - 100);
		/* DEFINICIONES */
		for (GENERACIONCODIGOS gc : listGeneracionCodigo) {
			manualCodigoBarra.listField.add(new JTextLabelPanel(pos++, gc.getIDGENERACION().toString(),
					gc.getDESCRIPCION(), "", gc.getNUMDIGITOTOTAL()) {
				@Override
				public void ordenfocusPanel() {
					if (manualCodigoBarra.listField.size() - 1 == row)
						manualCodigoBarra.listField.get(0).textField.requestFocus();
					else
						manualCodigoBarra.listField.get(row + 1).textField.requestFocus();
				}
			});
		}
		manualCodigoBarra.cargarRow();
		manualCodigoBarra.show();
		manualCodigoBarra.ordenfocus(0);
	}

	public void ManualRfid() {
		FrmMWRfid manualRfid = new FrmMWRfid(Inicio.mainF, "Geolocalización - Planta") {
			@Override
			public void save() {
				if (this.listField != null) {
					if (this.listField.size() > 0) {
						tecladoMovil_RfidUbicacion = new ObjetoTecladoMovil();
						Object[] items = new Object[2];
						int c = 0;
						for (JTextLabelPanel obj : listField) {
							obj.value = obj.textField.getText();
							items[c] = obj.textField.getText();
							c++;
						}
						/*------------idubicacion------------*/
						DZONAGENERAL dzonageneral = SerieChipADZGeneral((String) items[0], (String) items[1]);
						if (dzonageneral != null) {
							observable_pos_actual.actualizar_parpadeo(dzonageneral);
						}
						/*------------------------------------*/
						// tecladoMovil_RfidUbicacion=new
						// ObjetoTecladoMovil("RFID",obj.descripcion,obj.id,obj.value);
						// objectPanelTexto[4] =obj.value;
						// /*OBTENER ZONA*/
						// if(obj.value!=null){
						//// if(!obj.value.equals("")){
						//// panelZona.selectActual=panelZona.findUbicacion(obj.value);
						//// if(panelZona.selectActual!=null)
						//// objectPanelTexto[2]=panelZona.selectActual.getZONA();
						//// }
						// }
					}
				}
				int x = 1;
				System.out.println("[" + (x++) + "]:" + tecladoMovil_RfidUbicacion.getValue());
				/* ACTUALIZAR UBICACIÓN PANEL INFORMATIVO */
				InsetarTextPanel();
				this.cancel();
			}
		};
		manualRfid.setLocation(getWidth() / 2, (getHeight() / 2) - 100);
		/* DEFINICIONES */
		manualRfid.listField.add(new JTextLabelPanel(0, "Codigo", "UBICACIÓN 1", "", 30) {
			@Override
			public void ordenfocusPanel() {
				if (manualRfid.listField.size() - 1 == row)
					manualRfid.listField.get(0).textField.requestFocus();
				else {
					manualRfid.listField.get(row + 1).textField.requestFocus();
				}

			}
		});
		manualRfid.listField.add(new JTextLabelPanel(0, "Codigo", "UBICACIÓN 2", "", 30) {
			@Override
			public void ordenfocusPanel() {
				if (manualRfid.listField.size() - 1 == row)
					manualRfid.listField.get(0).textField.requestFocus();
				else {
					manualRfid.listField.get(row + 1).textField.requestFocus();
				}

			}
		});
		manualRfid.cargarRow();
		manualRfid.show();
		manualRfid.ordenfocus(0);
	}

	public void AutomaticoRfid() {
		EjecutarRFID();
	}

	public void AutomaticoBarcode() {
		EjecutarBar();
	}

	public void accionTransicion() {
		if (listAcciones != null) {
			if (listAcciones.size() > 0) {
				if (accionSelection == null) {
					accionSelection = listAcciones.get(0);
				} else {
					int key = listAcciones.indexOf(accionSelection);
					if (listAcciones.size() - 1 == key) {
						accionSelection = listAcciones.get(0);
					} else {
						accionSelection = listAcciones.get(key + 1);
					}
				}
			}
		}
	}

	public void InsetarTextPanel() {
		try {
			/* CONFIGURACIÓN DATOS MOSTRAR PANEL */
			textPaneInfo.setText(TextPanelStyle.estructuracionTexto(objectPanelTexto));
			textPaneInfo.repaint();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<DPROGRAMAALMEJECUCION> cargarUbicacionesDisponibles() {
		List<DPROGRAMAALMEJECUCION> listUbicacionDisponibles = new ArrayList<>();
		try {
			if (!listDPROGRAMACIONTAREALLEGADA.isEmpty()) {
				listUbicacionDisponibles = dPROGRAMAALMEJECUCIONDao.getListDPROGRAMAALMEJECUCION(Inicio.idempresa,
						Inicio.idsucursal, listDPROGRAMACIONTAREALLEGADA.get(0).getIDPROGRAMACIONLLENADO(), "PR");
			}
		} catch (SQLException | NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUbicacionDisponibles;
	}

	public DZONAGENERAL obtenerPosicionesLibres() {
		DZONAGENERAL posicionLibre = null;
		if (!listDPROGRAMACIONTAREALLEGADA.isEmpty()) {
			ubicacionDispobible = cargarUbicacionesDisponibles().get(0);
			for (DZONAGENERAL dzonageneral : this.listDzonaGeneral) {
				if (dzonageneral.getIDUBICACION().trim()
						.equalsIgnoreCase(ubicacionDispobible.getIDUBICACION().trim())) {
					posicionLibre = dzonageneral;
					break;
				}
			}
		}
		return posicionLibre;
	}

	/************************************************************************************************************/
	public void CargarNotificaciones() {
		try {
			objectPanelTexto = new String[6];
			if (Inicio.notificacion != null) {
				objectPanelTexto[0] = Inicio.notificacion.getMENSAJE();
				// objectPanelTexto[1] = "Fecha : "+Constants.fechaActual();
				// objectPanelTexto[2] = "Zona : ";
				// objectPanelTexto[3] = "Hora : "+Constants.timeActual();
				// objectPanelTexto[4] = "Ubicación : ";
				objectPanelTexto[5] = Inicio.usuario.getNombres();
				/* OBTENER TOQUEN DE TAREA */
				programacionTarea = (new ProgramaciontareaDao()).findProgramacionTarea(Inicio.idempresa,
						Inicio.idsucursal, Inicio.notificacion.getTOQUEN(), Inicio.idmontacarga, 1);
			} else {
				objectPanelTexto[0] = "NO EXISTE TAREA ASIGNADA" + "\n\n";
				// objectPanelTexto[1] = "Fecha : "+Constants.fechaActual();
				// objectPanelTexto[2] = "Zona : ";
				// objectPanelTexto[3] = "Hora : "+Constants.timeActual();
				// objectPanelTexto[4] = "Ubicación : ";
				objectPanelTexto[5] = Inicio.usuario.getNombres();
			}
			InsetarTextPanel();
			// progress.execProgress();
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CargarRutas() {
		CargarRutas ej = new CargarRutas();
		hilo = new Thread(ej, NotacionesThread.tFrmSysZona_CargarRutas);
		hilo.start();
		Constantes.log.info(hilo.getName());
	}

	/* CLASE DIAGRAMADOR */
	public void CARGARCODIGO(String console) {
		String charI = ConfigInicial.LlenarConfig()[11];
		String charF = ConfigInicial.LlenarConfig()[12];
		// console=charI+console+charF;
		List<DGENERACIONCODIGOS> listDGeneracionCodigo = new ArrayList<DGENERACIONCODIGOS>();
		Map<String, String> mapa;
		int j = 0;
		String codigo = "";
		/* LIMPIAR PANEL */
		panelCabecera.removeAll();
		panelCabecera.repaint();
		try {
			/*****************************
			 * TRAER DATOS DE CONSOLE
			 *************************/
			ArrayList<String> listcodigo = new ArrayList<String>();
			for (int x = 1; x <= listGeneracionCodigo.size(); x++) {
				codigo = Constantes.buscarFragmentoTexto(console, charI, charF, x);
				listcodigo.add(codigo);
			}
			/**************************
			 * RECORRER CABECERA
			 ********************************/
			for (GENERACIONCODIGOS gc : listGeneracionCodigo) {
				mapa = new HashMap<String, String>();
				listDGeneracionCodigo = (new DGENERACIONCODIGOSDao()).listar(1, "IDEMPRESA = ? and IDGENERACION = ?",
						gc.getIDEMPRESA(), gc.getIDGENERACION());
				/* BUSCAR CÓDIGO CON LONGITUD REQUERIDA */
				codigo = buscarCadenaxLongitud(listcodigo, gc.getNUMDIGITOTOTAL(), gc.getIDGENERACION());
				j = 0;
				for (DGENERACIONCODIGOS dgc : listDGeneracionCodigo) {
					mapa.put(dgc.getPARAMETRO(), codigo);
					//mapa.put(dgc.getPARAMETRO(), codigo.substring(j, j + dgc.getNUMDIGITO()));
					j += dgc.getNUMDIGITO();
				}
				/**********************************
				 * LLENAR DATOS
				 **************************************/
				MOVUBICACIONDao movubicacionDao = new MOVUBICACIONDao();
				MOVUBICACION movubicacion = new MOVUBICACION();
				movubicacion.setCORDENADAX(1);
//				movubicacionDao.list)
				BarcodeTexto cajaTexto = new BarcodeTexto(mapa);
				panelCabecera.add(cajaTexto);
			}
			panelCabecera.revalidate();
			panelCabecera.repaint();
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			Constantes.log.warn(e.getMessage());
			e.printStackTrace();
		}
	}

	public String buscarCadenaxLongitud(ArrayList<String> lista, int tamanio, int col) {
		String cadena = "";
		for (String str : lista) {
			if (str.length() == tamanio) {
				if (tamanio == 1) {
					cadena = str;
					break;
				} else if (Integer.parseInt(str.substring(0, tamanio - 1)) == col-1) {
					//cadena = str;
					cadena = String.valueOf(str.charAt(str.length()-1));
					break;
				}
				
			}
		}
		return cadena;
	}

	/* METODOS DE BOTONES DINAMICOS <ACTIVIDADES> */
	public DZONAGENERAL buscarCodigoRfidUbicacion(String[] tags) {
		DZONAGENERAL dzRfid = null;
		return dzRfid;
	}

	public DZONAGENERAL ProcesarRfid(List<TagsRfid> lst) {
		DZONAGENERAL dz = null;
		DASIGNACIONCHIPS dasignacionchips = null;
		/* ALGORITMO PARA ENCONTRAR POSICION */
		try {
			for (TagsRfid item : lst) {/* SIZE -> NUMERO DE ANTENA 2 ANTENAS */
				if (item.getTag() != null) {
					dasignacionchips = (new DASIGNACIONCHIPSDao()).getAsignacionChips(Inicio.idempresa,
							Inicio.idsucursal, item.getTag().getTagID());
					if (dasignacionchips != null) {
						dz = dzonaGeneralDao.getDZonaGeneral(dasignacionchips.getIDEMPRESA(),
								dasignacionchips.getIDSUCURSAL(), dasignacionchips.getCORDENADAXT(),
								dasignacionchips.getCORDENADAYT(), dasignacionchips.getCORDENADAX(),
								dasignacionchips.getCORDENADAY(), dasignacionchips.getIDUBICACION());
						if (dz != null) {
							// dz_ant=dz;
							break;
						}
					}
				}
			}
			return dz;
		} catch (SQLException | NisiraORMException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	private void EjecutarBar() {
		EjecutarBarcode ej = new EjecutarBarcode(process);
		new Thread(ej).start();
	}

	private void EjecutarRFID() {
		EjecutarRFID ej = new EjecutarRFID();
		hilo = new Thread(ej, NotacionesThread.tFrmSysZona_Rfid);
		hilo.start();
	}

	public void EliminarBar() {
		EliminarBarcode el = new EliminarBarcode(process);
		new Thread(el).start();
	}

	public String parametrosHtml(Map<String, String> claveValor) {
		String html = "";
		Iterator it = claveValor.entrySet().iterator();
		Map.Entry e;
		while (it.hasNext()) {
			e = (Map.Entry) it.next();
			html += Constantes.claveValorHtml(e.getKey().toString(), e.getValue().toString());
			System.out.println(e.getKey() + " " + e.getValue());
		}
		return html;
	}

	public void stopHilos(String nameHilo) {
		threadGroup = Thread.currentThread().getThreadGroup();
		Thread[] listaHilo = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(listaHilo, true);
		for (int i = 0; i < listaHilo.length; i++) {
			Constantes.log.info(listaHilo[i].getName());
			if (listaHilo[i].getName().contains(nameHilo)) {
				listaHilo[i].stop();
				break;
			}
		}
	}

	public void CargarDatosInicial() {
		CargarDatosInicial ej;
		ej = new CargarDatosInicial();
		hilo = new Thread(ej, NotacionesThread.tFrmSysZona_CargarDatosInicial);
		hilo.start();
	}

	public DZONAGENERAL SerieChipADZGeneral(String seriechip1, String seriechip2) {
		List<DASIGNACIONCHIPS> ldasignacionchips;
		DASIGNACIONCHIPS dasignacionchips;
		DZONAGENERAL dz = null;
		try {
			ldasignacionchips = (new DASIGNACIONCHIPSDao()).getAsignacionChips2(Inicio.idempresa, Inicio.idsucursal,
					seriechip1, seriechip2);
			dasignacionchips = ldasignacionchips.get(0);
			if (dasignacionchips != null) {
				dz = dzonaGeneralDao.getDZonaGeneral(dasignacionchips.getIDEMPRESA(), dasignacionchips.getIDSUCURSAL(),
						dasignacionchips.getCORDENADAXT(), dasignacionchips.getCORDENADAYT(),
						dasignacionchips.getCORDENADAX(), dasignacionchips.getCORDENADAY(),
						dasignacionchips.getIDUBICACION());
				if (dz != null) {
					observable_pos_actual.actualizar_parpadeo(dz);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dz;
	}

	class BarcodeTexto extends JLabel {
		private static final long serialVersionUID = 1L;

		public BarcodeTexto(Map<String, String> claveValor) {
			// super(parametrosHtml(claveValor));
			this.setText(
					"<html><p style=\"line-height: 150%;font-size:20;\">" + parametrosHtml(claveValor) + "</p></html>");
			this.setVisible(true);
			this.setSize(60, 200);
			this.setFont(new Font(null, Font.PLAIN, 12));
			// this.setOpaque(true);
			// this.setForeground(Color.BLACK);
			// this.setFont(new Font("Tahoma", Font.PLAIN, 12));
			// this.name =new JLabel(name);
		}
	}

	/* CLASES DE HILOS */
	class CargarDatosInicial implements Runnable {
		@Override
		public synchronized void run() {
			// TODO Auto-generated method stub
			/* DEFINIR THREAD */
			// progress= new
			// ProgressBarDialog(Inicio.mainF,tareas,x,y,FrmSysZona.this);
			// progress.setVisible(true);
			/* TRAER DATOS DE LA NOTIFICACIONES */
			CargarNotificaciones();/* PROGRESS BAR(1) */
			/* TRAER DATOS DE LA BASE DE DATOS */
			cargarDatosMapa();/* PROGRESS BAR(2) */

			// wrutas = new MatrizRutas(){
			// @Overridezz
			// public void marcarRecorrido(){
			////// List<Integer> test = panelZona.puntosExtremos_;
			////// int cPartida=panelZona.puntosExtremos_.get(0);
			////// int
			// cLlegada=panelZona.puntosExtremos_.get(panelZona.puntosExtremos_.size()-1);
			////// caminoRecorrido= new ArrayList<CoordenadaMatriz>();
			//// List<Integer> l = f.MRutaList(cPartida,cLlegada);
			//// for (int i = 0; i< l.size(); i++) {
			//// for(int[] a : nodos) {
			//// if (l.get(i) == a[0]) {
			//// System.out.println(a[1]+ " " + a[2]);
			//// }
			//// }
			//// }
			//// System.out.println(f.MRuta(cPartida,cLlegada));
			//// if(l.size()>0){
			//// l.add(0, cPartida);
			//// getPanelZona().dibujarRutaMatriz(l,Color.GREEN,getTamanio());
			//// getPanelZona().repaint();
			//// }
			//// panelZona.puntosExtremos_.clear();
			// }
			// };
			// getPanelZona().setListDzonaGeneral(getListDzonaGeneral());
			// progress.execProgress();/*PROGRESS BAR(3)*/
			/* DATOS ESTADO UBICACION(LLENO/VACIO) */
			// cargarDatosEstadoUbicacion();/*PROGRESS BAR(4)*/
			/* ALGORITMO DE RUTAS -> CREACION DE MATRIZ */
			// CargarRutas();/*PROGRESS BAR(6)*/
			/* DATOS TAREA A REALIZAR */
			cargarDatosTareaRealizar();/* PROGRESS BAR(7) */
			// CargarRutas();
		}
	}

	class EliminarBarcode implements Runnable {
		public Process process;

		public EliminarBarcode(Process process) {
			this.process = process;
		}

		@Override
		public void run() {
			String archivo = "WindowsApplication.exe";
			try {
				Runtime.getRuntime().exec("TASKKILL /F /IM " + archivo);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	class EjecutarBarcode implements Runnable {
		public Process process;

		public EjecutarBarcode(Process process) {
			this.process = process;
		}

		@Override
		public void run() {
			String archivo = ConfigInicial.LlenarConfig()[10]; // Ruta_Proyecto
																// HALCON 12
			try {
				String console = "";
				process = Runtime.getRuntime().exec(archivo);
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
					console += line;
				}
				// CARGARCODIGO(console,"@~", "~@");
				CARGARCODIGO(console);
				reader.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	class EjecutarRFID implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					List<TagsRfid> lst = ReaderAlien.getDatosTag();
					// String mostrar ="";
					// for(TagsRfid rfid :lst){
					// /*UBICACION*/
					// mostrar+= "ANTENA
					// ["+(rfid.getAntena().getIdantena()-1)+"]
					// :"+rfid.getTag()+" ";
					// }
					posicion = ProcesarRfid(lst);
					System.out.println("Valor Posicion :" + posicion);
					if (posicion != null) {
						System.out.println(posicion.toString());
						// objectPanelTexto[4] = mostrar;
						objectPanelTexto[4] = posicion.getIDUBICACION();
						InsetarTextPanel();
						/* AGREGAR CODIGO PINTAR LIBGDX */

						observable_pos_actual.actualizar(posicion);
					}
					// try {
					// Thread.sleep(timer);
					// } catch (InterruptedException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
				}

			} catch (AlienReaderException e) {
				System.out.println("MENSAJE RFID: " + e.getMessage());
				NotacionesThread.stopThreadName(NotacionesThread.tFrmRFIDreader_LecturaRfid);

			}
		}
	}

	class MostrarRecorrido implements Runnable {
		@Override
		public synchronized void run() {
			// TODO Auto-generated method stub
			int i = 0;
			while (true) {
				// i=alertaUbicacion(i);
				wrutas.marcarRecorrido();
				try {
					Thread.sleep(timer);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	class CargarRutas implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			/* ANALIZAR LA MATRIZ RUTA */
			FLOYDDao floydao = new FLOYDDao();
			try {
				System.out.println("INICIANDO RUTA FLOYD W");
				List<FLOYD> lstfloy = floydao.listar(1, "IDEMPRESA=? AND IDSUCURSAL=?", Inicio.idempresa,
						Inicio.idsucursal);

				if (lstfloy.size() == 0) {
					MatrizRutas.configuracionRutas(zonaGeneral, listDzonaGeneralCalles);
					System.out.println("FLOYD: S " + MatrizRutas.f.S.length + " D " + MatrizRutas.f.D.length + " nodos "
							+ MatrizRutas.f.x);
					/* json */
					FLOYD floy = new FLOYD();
					floy.setIDEMPRESA(Inicio.idempresa);
					floy.setIDSUCURSAL(Inicio.idsucursal);
					floy.setMATRIZ_S(inttoString(MatrizRutas.f.S));
					floy.setMATRIZ_D(inttoString(MatrizRutas.f.D));
					floydao.setPorClavePrimaria(floy.getIDEMPRESA(), floy.getIDSUCURSAL(), 1, floy.getMATRIZ_S(),
							floy.getMATRIZ_D());
					// MatrizRutas.f.EscribirMatricez();
				} else {
					FLOYD floyd = lstfloy.get(0);
					System.out.println("EXISTE EN LA BD, GRABAMOS S / D");
					MatrizRutas.configuracionRutas_sinFloyd(zonaGeneral, listDzonaGeneralCalles);
					// MatrizRutas.f = new Floyd(999,999);

					JSONArray itemArray = new JSONArray(floyd.getMATRIZ_S());
					// System.out.println("JSON TRAER: "+itemArray.toString());
					Iterator I = itemArray.iterator();
					int i = 0;
					while (I.hasNext()) {
						JSONArray n = (JSONArray) I.next();
						// System.out.println("JSON TRAER2: "+n.toString());
						JSONArray jsonarray = n.getJSONArray(0);
						for (int j = 0; j < jsonarray.length(); j++) {
							MatrizRutas.f.S[i][j] = jsonarray.getInt(j);
						}
						i++;
					}
					itemArray = new JSONArray(floyd.getMATRIZ_D());
					I = itemArray.iterator();
					i = 0;
					while (I.hasNext()) {
						JSONArray n = (JSONArray) I.next();
						// System.out.println("JSON TRAER2: "+n.toString());
						JSONArray jsonarray = n.getJSONArray(0);
						for (int j = 0; j < jsonarray.length(); j++) {
							MatrizRutas.f.D[i][j] = (float) jsonarray.getDouble(j);
						}
						i++;
					}
					System.out.println("FLOYD: S " + MatrizRutas.f.S.length + " D " + MatrizRutas.f.D.length + " nodos "
							+ MatrizRutas.f.x);
					// MatrizRutas.f.EscribirMatricez();
				}
			} catch (NisiraORMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// progress.execProgress();
			// estructuracionRutas();
		}
	}

	/***********************************************************************************************************************************/
	/* ELIMINAR OBJETOS ACTIVOS */
	public void limpiarObjetos() {
		/* Overlay-> Cerrar Tooltip */
		// if(panelZona.frmToltip!=null)
		// panelZona.frmToltip.Closed();
	}

	public DZONAGENERAL getDZONAGENERALubicacion(String IDUBICACION) {
		DZONAGENERAL DZ = null;
		for (int i = 0; i < getListDzonaGeneral().size(); i++) {
			if (getListDzonaGeneral().get(i).getIDUBICACION().trim().equalsIgnoreCase(IDUBICACION.trim())) {
				DZ = getListDzonaGeneral().get(i);
				break;
			}
		}
		return DZ;
	}

	public String estructuraHtml(Object obj, int tipo) {
		String html = "";
		String style = "<style>";
		switch (tipo) {
		case 1:
			DZONAGENERAL dz = ((DZONAGENERAL) obj);
			html = "<html>" + "<center><h1>Información</h1></center><br>" + "Zona: <b>" + dz.getZONA() + "</b><br>"
					+ "Tipo: <b>" + dz.getTIPO() + "</b><br>" + "<img src=\""
					+ FrmSysZona.class.getResource("/resources/montacarga/montacargas3.png") + "\">" + "</html>";
			break;
		case 2:
			DZONADIAGRAMA dzd = ((DZONADIAGRAMA) obj);
			html = "<html>" + "<center><h1>" + dzd.getTIPORACK() + "</h1></center><br>" + "Almacen: <b>" + dzd.getTIPO()
					+ "</b><br>" + "Id Zona: <b>" + dzd.getIDZONA() + "</b><br>" + "Id Almacen: <b>"
					+ dzd.getIDALMACEN() + "</b><br>" + "<img src=\""
					+ FrmSysZona.class.getResource("/resources/montacarga/montacargas3.png") + "\">" + "</html>";
			break;
		default:
			break;
		}
		return html;
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		// JOptionPane.showMessageDialog(null,"internalFrameClosed");
		NotacionesThread.stopThreadClass("FrmSysZona");
		limpiarObjetos();
		EliminarBar();
		// progress.dispose();
		// appListener.dispose();
		config = null;
		lwjl.exit();
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		// JOptionPane.showMessageDialog(null,"internalFrameClosing");
		NotacionesThread.stopThreadClass("FrmSysZona");
		EliminarBar();
		limpiarObjetos();
		// progress.dispose();
		// appListener.dispose();
		config = null;
		lwjl.exit();
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

	public DiagramaDistribucion getPanelZona() {
		return null;
	}

	public void setPanelZona(DiagramaDistribucion panelZona) {
	}

	public List<DZONAGENERAL> getListDZonaGeneralPos() {
		return listDZonaGeneralPos;
	}

	public void setListDZonaGeneralPos(List<DZONAGENERAL> listDZonaGeneralPos) {
		this.listDZonaGeneralPos = listDZonaGeneralPos;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public List<DASIGNACIONCHIPS> getListDAsignacionChips() {
		return listDAsignacionChips;
	}

	public void setListDAsignacionChips(List<DASIGNACIONCHIPS> listDAsignacionChips) {
		this.listDAsignacionChips = listDAsignacionChips;
	}

	public List<DZONAGENERAL> getListDzonaGeneral() {
		return listDzonaGeneral;
	}

	public void setListDzonaGeneral(List<DZONAGENERAL> listDzonaGeneral) {
		this.listDzonaGeneral = listDzonaGeneral;
	}

	/***********************************************************************************************************************************/
	/* LIBGDX Y UTILITARIOS */

	public String inttoString(float s[][]) {
		String matriz;
		matriz = s.toString();
		JSONArray json = new JSONArray();
		JSONArray subjson = null;
		try {
			for (int i = 0; i < s.length; i++) {
				subjson = new JSONArray(Arrays.asList(s[i]));
				// System.out.println("");
				json.put(subjson);
			}
		} catch (Exception e) {
		}
		matriz = json.toString();
		// System.out.println("JsonString : " + matriz);
		return matriz;
	}

	public String inttoString(int s[][]) {

		String matriz;
		matriz = s.toString();
		JSONArray json = new JSONArray();
		JSONArray subjson = null;
		try {
			for (int i = 0; i < s.length; i++) {
				subjson = new JSONArray(Arrays.asList(s[i]));
				// System.out.println("");
				json.put(subjson);
			}
		} catch (Exception e) {
		}
		matriz = json.toString();
		// System.out.println("JsonString : " + matriz);
		return matriz;
	}

	public int[][] StringtoInt(String solucion) {
		int s[][] = null;
		JSONArray json = new JSONArray(solucion);
		try {
			for (int i = 0; i < json.length(); i++) {
				JSONArray subjson = new JSONArray(json.get(i));
				for (int j = 0; j < subjson.length(); j++) {
					s[i][j] = (int) subjson.get(j);
				}
			}
		} catch (Exception e) {
		}

		return s;
	}

	public class Observado extends Observable {
		Zelda zelda, zelda2;

		public Observado() {
			zelda = new Zelda();
			zelda2 = new Zelda();
			zelda.X = 0;
			zelda.Y = 0;
			zelda.color = "";
			zelda.idUbicacion = "";
		}

		public void actualizar(DZONAGENERAL p) {

			zelda.X = p.getCORDENADAX();
			zelda.Y = p.getCORDENADAY();
			zelda.color = p.getCOLOR();
			zelda.idUbicacion = p.getIDUBICACION();
			zelda.n_piso = 1;
			zelda.tipo = p.getTIPORACKS();
			setChanged();
			notifyObservers(zelda);
			// notifyObservers(); Este metodo solo notifica que hubo cambios en
			// el objeto
		}

		public void actualizar_parpadeo(DZONAGENERAL p) {
			zelda2.X = p.getCORDENADAX();
			zelda2.Y = p.getCORDENADAY();
			zelda2.color = p.getCOLOR();
			zelda2.idUbicacion = p.getIDUBICACION();
			zelda2.n_piso = 1;
			zelda2.tipo = p.getTIPORACKS();
			setChanged();
			notifyObservers(zelda2);
		}
	}

	public class Observable_Rutas extends Observable {

		List<Integer> caminoRecorrido;
		List<Pair<Integer, Integer>> caminoaMostrar;

		public Observable_Rutas() {
			caminoRecorrido = new ArrayList<Integer>();
			caminoaMostrar = new ArrayList<Pair<Integer, Integer>>();
		}

		public void actualizar(DZONAGENERAL fin) {
			// actualizar el observable cuando termine de cargar las rutas.
			// observable_pos_actual.zelda.X; AQUI USAMOS LA POSICION ACTUAL
			// PARA QUE SE ACTUALICE LA RUTA
			// Buscar el nodo del observable_posruta y luego el nodo del
			// destino.
			System.out.println(fin.toString());
			// int inicio_pos =
			// MatrizRutas.posicionMatrizRecorrido(observable_pos_actual.zelda.X,observable_pos_actual.zelda.Y);
			int fin_pos = 0;
			try {
				fin_pos = MatrizRutas.posicionMatrizRecorrido(fin.getCORDENADAX(), fin.getCORDENADAY());
			} catch (Exception e) {
				e.printStackTrace();
			}
			// NOTA: NO SE PUEDE UN UNA POSICION A LA MISMA. BOTA ERROR
			caminoRecorrido = MatrizRutas.f.solucion(0, fin_pos);
			for (int i = 0; i < caminoRecorrido.size(); i++) {
				for (int[] a : MatrizRutas.nodos) {
					if (caminoRecorrido.get(i) == a[0]) {
						System.out.println(a[1] + " " + a[2]);
						caminoaMostrar.add(new Pair<Integer, Integer>(a[1], a[2]));
					}
				}
			}
			setChanged();
			notifyObservers(caminoaMostrar);
		}
	}

	public class Observado_parpadeo extends Observable {
		Zelda zelda;
		Zelda zelda2;

		public Observado_parpadeo() {
			zelda = new Zelda();
			zelda2 = new Zelda();
			zelda.X = 0;
			zelda.Y = 0;
			zelda.color = "";
			zelda.idUbicacion = "";
		}

		public void actualizar(DZONAGENERAL p) {

			zelda.X = p.getCORDENADAX();
			zelda.Y = p.getCORDENADAY();
			zelda.color = p.getCOLOR();
			zelda.idUbicacion = p.getIDUBICACION();
			zelda.n_piso = 1;
			zelda.tipo = p.getTIPORACKS();
			setChanged();
			notifyObservers(zelda);
			// notifyObservers(); Este metodo solo notifica que hubo cambios en
			// el objeto
		}

	}
}
