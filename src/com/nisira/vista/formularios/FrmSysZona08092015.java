package com.nisira.vista.formularios;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseWheelEvent;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import com.alien.enterpriseRFID.reader.AlienReaderException;
import com.alien.enterpriseRFID.tags.Tag;
import com.nisira.Inicio;
import com.nisira.alien.ReaderAlien;
import com.nisira.core.NisiraORMException;
import com.nisira.dao.CONFIGACTIVIDADESDao;
import com.nisira.dao.DASIGNACIONCHIPSDao;
import com.nisira.dao.DGENERACIONCODIGOSDao;
import com.nisira.dao.DPROGRAMAALMEJECUCIONDao;
import com.nisira.dao.DZONAGENERALDao;
import com.nisira.dao.DprogramaciontareallegadaDao;
import com.nisira.dao.DprogramaciontareapartidaDao;
import com.nisira.dao.GENERACIONCODIGOSDao;
import com.nisira.dao.ProgramaciontareaDao;
import com.nisira.dao.ZONAGENERALDao;
import com.nisira.entidad.CONFIGACTIVIDADES;
import com.nisira.entidad.CoordenadaMatriz;
import com.nisira.entidad.DASIGNACIONCHIPS;
import com.nisira.entidad.DGENERACIONCODIGOS;
import com.nisira.entidad.DPROGRAMAALMEJECUCION;
import com.nisira.entidad.DPROGRAMACIONTAREALLEGADA;
import com.nisira.entidad.DPROGRAMACIONTAREAPARTIDA;
import com.nisira.entidad.DZONADIAGRAMA;
import com.nisira.entidad.DZONAGENERAL;
import com.nisira.entidad.GENERACIONCODIGOS;
import com.nisira.entidad.PROGRAMACIONTAREA;
import com.nisira.entidad.ZONAGENERAL;
import com.nisira.thread.NotacionesThread;
import com.nisira.utils.nisiracore.Constantes;
import com.nisira.vista.barras.PanelBarraMaestro;
import com.nisira.vista.controles.JTextLabelPanel;
import com.nisira.vista.controles.NSRInternalFrame;
import com.nisira.vista.movil.map.ConfigTooltip;
import com.nisira.vista.movil.map.DiagramaDistribucion;
import com.nisira.vista.movil.map.MatrizRutas;
import com.nisira.vista.movil.map.StreetView;
import core.inicio.ConfigInicial;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import test.GeneracionCodigoXml;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class FrmSysZona08092015 extends NSRInternalFrame implements InternalFrameListener{
	private static final long serialVersionUID = 7755124973019289267L;
	public JTextPane textPaneInfo;
	final DefaultStyledDocument doc;
	final Style heading2Style;
	public MatrizRutas wrutas;
	public final static int widthPanel=734;
	public final static int heightPanel=500;
	/*************************************************************/
	public Process process;
	public ThreadGroup threadGroup;
	public final int timer=200;
	public static int varHiloUbicacion=0;
	public Thread hilo;
	private Boolean selected;
	/*****************CONFIGURACIÓN PARA TOOLTIP*****************/
	final Integer tiempoCierre=15;
	final Color alerta= Color.white; 
	/****************************** VARIABLES PRIMARIAS******************************/
	private ZONAGENERAL zonaGeneral;
	private List<DZONAGENERAL> listDzonaGeneral;
	private List<DZONAGENERAL> listDzonaGeneralCalles;
	private List<DZONAGENERAL> listDZonaGeneralPos; 
	
	private ZONAGENERALDao zonaGeneralDao;
	private DZONAGENERALDao dzonaGeneralDao;
	/**** ATRIBUTOS DE TAREA ****/
	private PROGRAMACIONTAREA programacionTarea;
	private List<DPROGRAMACIONTAREAPARTIDA> listDPROGRAMACIONTAREAPARTIDA;
	private List<DPROGRAMACIONTAREALLEGADA> listDPROGRAMACIONTAREALLEGADA;
	private ProgramaciontareaDao programacionTareaDao;
	private DprogramaciontareallegadaDao dprogramacionTareallegadaDao;
	private DprogramaciontareapartidaDao dprogramacionTareapartidaDao;

	private DPROGRAMAALMEJECUCIONDao dPROGRAMAALMEJECUCIONDao;
	private DPROGRAMAALMEJECUCION ubicacionDispobible;
	private int tamanio;
	private String textoBoton;
	/***********************************************************************/
	
	private JScrollPane ScrollPaneZona;
    public DiagramaDistribucion panelZona;
    public StreetView panelZona3D;
    private JButton btnReturn;
    private static final int _ancho = 40;
    private static final int _alto = 40;
    private JScrollPane scrollPanelCabecera;
    private JPanel panelCabecera;
    private List<GENERACIONCODIGOS> listGeneracionCodigo;
    private JCheckBox chkPosicion;
    private JCheckBox chkObstaculo;
    private JCheckBox cbLlegada;
    public List<CoordenadaMatriz> puntosExtremos;
    public Boolean panelActivo;
    /*CONFIGURACION DE ACTIVIDADES*/
    private List<CONFIGACTIVIDADES> listConfigActividades;
    /*RECONOCIMIENTO DE CHIPS*/
    private List<DASIGNACIONCHIPS> listDAsignacionChips;
    public static void main(String[] args) {
			new FrmSysZona08092015();
	}
    public void __constructor(){
    	/***************** PARAMETROS INICIALES *********************/
    	textoBoton="";
    	/****************************************************************/
    	zonaGeneral =new ZONAGENERAL();
    	setListDzonaGeneral(new ArrayList<DZONAGENERAL>());
    	zonaGeneralDao=new ZONAGENERALDao();
    	dzonaGeneralDao = new DZONAGENERALDao();
    	dPROGRAMAALMEJECUCIONDao = new DPROGRAMAALMEJECUCIONDao();
    	listGeneracionCodigo =new ArrayList<GENERACIONCODIGOS>();
    	setListDAsignacionChips(new ArrayList<DASIGNACIONCHIPS>());
    	setTamanio(3);
    	selected=true;
    	puntosExtremos = new ArrayList<CoordenadaMatriz>();
    	panelActivo=true;
    	/*CARGAR DATOS DE TAREA*/
    	programacionTarea = new PROGRAMACIONTAREA();
    	listDPROGRAMACIONTAREAPARTIDA = new ArrayList<>();
    	listDPROGRAMACIONTAREALLEGADA = new ArrayList<>(); 
    	programacionTareaDao =new ProgramaciontareaDao();
    	dprogramacionTareapartidaDao = new DprogramaciontareapartidaDao();
    	dprogramacionTareallegadaDao = new DprogramaciontareallegadaDao();
    	ubicacionDispobible = new DPROGRAMAALMEJECUCION();
    	/*CONFIGURACION DE ACTIVIDADES*/
        listConfigActividades= new ArrayList<>();
    }
    public void cargarDatosMapa(){
    	try {
    		/*CARGAR DATOS DE MAPA*/
    		zonaGeneral=zonaGeneralDao.getZonaGeneralPrincipal(Inicio.idempresa,Inicio.idsucursal);
			this.setListDzonaGeneral(dzonaGeneralDao.getLisDZonaGeneral_(zonaGeneral));
			/*CARGAR UBICACIONES POR DONDE TRANSCITAR*/
			listDzonaGeneralCalles=dzonaGeneralDao.getLisDZonaGeneralCalles(1,zonaGeneral);
			listGeneracionCodigo =(new GENERACIONCODIGOSDao()).listar(1,"IDEMPRESA=? AND PARAMETRO=? AND ESTADO=?",ConfigInicial.LlenarConfig()[8],"FrmSysZona",1);
			/*RECONSTRUCCIÓN DE XML*/
			if(listGeneracionCodigo.size()>0)
				GeneracionCodigoXml.reconstruccionXML(listGeneracionCodigo);
			/*CARGA PROGRAMACION*/
			/*RECONOCIMIENTO DE CHIPS*/
			setListDAsignacionChips((new DASIGNACIONCHIPSDao()).getListAdsignacionChips(Integer.parseInt(ConfigInicial.LlenarConfig()[8]),Integer.parseInt(ConfigInicial.LlenarConfig()[9])));
			/*CONFIGURACIONES*/
			DiagramaDistribucion.chkPosicion=chkPosicion.isSelected();
			String pantalla="";
			if(Inicio.notificacion!=null){
				pantalla=Inicio.notificacion.getMENSAJE()+"\n\n"+
						"Código:"+Inicio.notificacion.getTOQUEN();
			}else{
				pantalla="NO EXISTE TAREA ASIGNADA"+"\n\n";
			}
			InsetarTextPanel(pantalla);
			/*CARGAR CONFIGURACION DE ACTIVIDADES*/
			listConfigActividades = (new CONFIGACTIVIDADESDao()).listar(1,true);
    	} catch (SQLException | NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void cargarDatosEstadoUbicacion(){
    	try {
    		/*CARGAR DATOS DE TAREA*/
    		if(Inicio.notificacion!=null){
    			programacionTarea = programacionTareaDao.findProgramacionTarea(Inicio.idempresa, Inicio.idsucursal, 
    					Inicio.notificacion.getTOQUEN(),Inicio.idmontacarga,1);/*ESTADO -> PENDIENTE*/
    			if(programacionTarea!=null){
    				listDPROGRAMACIONTAREAPARTIDA = dprogramacionTareapartidaDao.findDPROGRAMACIONTAREAPARTIDA(Inicio.idempresa, Inicio.idsucursal,
    						programacionTarea.getIDPROGRAMACIONTAREA());
    				listDPROGRAMACIONTAREALLEGADA = dprogramacionTareallegadaDao.findDPROGRAMACIONTAREALLEGADA(Inicio.idempresa, Inicio.idsucursal,
    						programacionTarea.getIDPROGRAMACIONTAREA());
    			}
    		}
    		/*UBICACIONES DISPONIBLES*/
    	} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void resetPanel(){
    	crearmatriz();
    }
	public FrmSysZona08092015(){
		super();
		__constructor();
		setTitle("Configuración Zona");
		panelZona3D =new StreetView(widthPanel,heightPanel);
        setPanelZona(new DiagramaDistribucion(getListDzonaGeneral(),new ConfigTooltip(0,this.timer,1,this.tiempoCierre,null,alerta),this.getTamanio()){
        	@Override
        	public DZONAGENERAL seleccionClick(int y,int x){
        		DZONAGENERAL dz=null;
        		boolean flag=false;
        		int cXi,cYi,cXf,cYf;
        		for(int i=0;i<getListDzonaGeneral().size();i++){
            		dz=getListDzonaGeneral().get(i);
            		cXi=dz.getCORDENADAX().intValue()*tamanio;
        			cYi=dz.getCORDENADAY().intValue()*tamanio;
        			cXf=cXi+tamanio;
        			cYf=cYi+tamanio;
            		if(y>=cYi & y<=cYf & x>=cXi & x<=cXf){
            			flag=true;
            			break;
            		}
        		}
        		if(flag)
        			return dz;
        		else
        			return null;
        	}
        	@Override
        	public void mouseWheelMoved(MouseWheelEvent e) {
        		// TODO Auto-generated method stub
        		/* SOBRESCRIBIR -> AUMENTAR Y DISMINUYER EN TABLET */
        		if(e.getPreciseWheelRotation()>0){
        			if(tamanio>3){
                		tamanio-= e.getPreciseWheelRotation();
                		setTamanio(tamanio);
                		panelZoom(this);
                		Constantes.log.info("Tamanio:"+tamanio);
                		Constantes.log.info("Touch :"+e.getPreciseWheelRotation());
                		repaint();
        			}
        		}else{
        			tamanio-=e.getPreciseWheelRotation();
        			setTamanio(tamanio);
            		panelZoom();
        			Constantes.log.info("Tamanio:"+tamanio);
            		Constantes.log.info("Touch :"+e.getPreciseWheelRotation());
            		repaint();
        		}
        	}
        });
        getPanelZona().setVisible(true);
        setMaximizable(true);
		setIconifiable(false);
		setClosable(true);
		setVisible(true);
		setResizable(true);
		this.show();
		this.addInternalFrameListener(this);
		ScrollPaneZona = new javax.swing.JScrollPane();
		ScrollPaneZona.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ScrollPaneZona.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        getPanelZona().setPreferredSize(new Dimension(widthPanel,heightPanel));
        panelZona3D.setPreferredSize(new Dimension(widthPanel,heightPanel));
        ScrollPaneZona.setViewportView(panelZona3D);
        ScrollPaneZona.add(panelZona);
        ScrollPaneZona.add(panelZona3D);
        ScrollPaneZona.setViewportView(panelZona);
        
        JButton btnZoommenos = new JButton("");
        btnZoommenos.setBorder(UIManager.getBorder("Button.border"));
        btnZoommenos.setAlignmentY(Component.TOP_ALIGNMENT);
        btnZoommenos.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnZoommenos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ZoomMenosDistribucion();
        	}
        });
        btnZoommenos.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/zoom_out.png")).getImage()
				.getScaledInstance(_ancho, _alto, java.awt.Image.SCALE_DEFAULT)));
        
        JButton btnZoommas = new JButton("");
        btnZoommas.setBorder(UIManager.getBorder("Button.border"));
        btnZoommas.setAlignmentY(Component.TOP_ALIGNMENT);
        btnZoommas.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnZoommas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		ZoomMasDistribucion();
        	}
        });
        
        btnZoommas.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/zoom_in.png")).getImage()
				.getScaledInstance(_ancho, _alto, java.awt.Image.SCALE_DEFAULT)));
        JButton btnBarcode = new JButton("");
        btnBarcode.setBorder(UIManager.getBorder("Button.border"));
        btnBarcode.setAlignmentY(Component.TOP_ALIGNMENT);
        btnBarcode.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnBarcode.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		/*CARGAR DATO DE C#*/
        		EjecutarBar();
        	}
        });
        btnBarcode.setIcon(new ImageIcon(FrmSysZona08092015.class.getResource("/resources/barcode.png")));
        btnReturn = new JButton("");
        btnReturn.setAlignmentY(Component.TOP_ALIGNMENT);
        btnReturn.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnReturn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		List<Tag> tag;
        		DASIGNACIONCHIPS filtroDAsignacionChips=null;
        		List<DASIGNACIONCHIPS> list =new ArrayList<DASIGNACIONCHIPS>();
        		List<DZONAGENERAL> listDZonaGen = new ArrayList<DZONAGENERAL>();
        		DZONAGENERAL filtro=null;
				try {
					tag = ReaderAlien.lecturaRfid();
					if(tag!=null){
						for(Tag x:tag){
							for(DASIGNACIONCHIPS valor :getListDAsignacionChips()){
								if(valor.getSERIECHIP()!=null){
									if(!valor.getSERIECHIP().trim().equals("")){
										if(valor.getSERIECHIP().trim().equalsIgnoreCase(x.getTagID().trim())){
											list.add(valor);
										}
									}
								}
							}
						}
						/*FILTRO DE LIST<DZONAGENERAL> VS LIST<DASIGNACIONCHIPS>*/
						for(int j=0;j<list.size();j++){
							DASIGNACIONCHIPS xlis=list.get(j);
							if(xlis.getIDUBICACION()!= null){
								if(!xlis.getIDUBICACION().trim().equals("")){
									DZONAGENERAL dzonageneral;
									for(int i=0;i<getListDzonaGeneral().size();i++){
										dzonageneral=getListDzonaGeneral().get(i);
										if(dzonageneral.getIDUBICACION()!=null){
											if(!dzonageneral.getIDUBICACION().trim().equals("")){
												if(dzonageneral.getIDUBICACION().equalsIgnoreCase(xlis.getIDUBICACION())){
													listDZonaGen.add(dzonageneral);
												}
											}
										}
									}
								}
							}
						}
						if(listDZonaGen.size()>0)
							AlertUbicacionTocaList(listDZonaGen);
					}
				} catch (AlienReaderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        });
        btnReturn.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/rfid_signal.png")).getImage()
				.getScaledInstance(_ancho, _alto, java.awt.Image.SCALE_DEFAULT)));
        
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
        		if(dzonageneral!=null)
        			AlertUbicacionToca(dzonageneral);
        	}
        });
        
        JButton btnStop = new JButton("Stop");
        btnStop.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		NotacionesThread.stopThreadClass("FrmSysZona");
        		resetPanel();
        	}
        });
        
        JButton btnTrafico = new JButton("Tráfico");
        btnTrafico.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		getPanelZona().removeAll();
        		getPanelZona().revalidate();
            	getPanelZona().repaint();
        	}
        });
        
//        DragScrollListener dl = new DragScrollListener(panelZona);
//		panelZona.addMouseListener(dl);
//		panelZona.addMouseMotionListener(dl);

        JButton btnRecorrido = new JButton("Recorrido");
        btnRecorrido.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		/******CALCULO COORDENA DE RUTA********/
        		MostrarRecorrido();
//        		wrutas.marcarRecorrido();
        	}
        });
        
        chkPosicion = new JCheckBox("Posición");
        chkPosicion.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
//				System.out.println("Check "+e.getStateChange());
				DiagramaDistribucion.chkPosicion=e.getStateChange()==1?true:false;
			}
		});
        chkPosicion.setSelected(true);
        
        chkObstaculo = new JCheckBox("Obstaculo");
        chkObstaculo.setSelected(true);
        
        JButton btnStreetview = new JButton("StreetView");
        btnStreetview.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(panelActivo){
        			ScrollPaneZona.setViewportView(panelZona3D);
        			panelActivo=false;
        		}else{
        			ScrollPaneZona.setViewportView(panelZona);
        			panelActivo=true;
        		}
        	}
        });
        
        JCheckBox cbLlegada = new JCheckBox("P. Llegada");
        cbLlegada.setSelected(true);
        
        JButton btnAlertStreetView = new JButton("Alert SV");
        btnAlertStreetView.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AlertStreetView();
        	}
        });
        
        JButton btnMcodbarra = new JButton("M-CodBarra");
        btnMcodbarra.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int pos=0;
        		FrmMWCodigoBarras manuaCodigoBarra = new FrmMWCodigoBarras(Inicio.mainF,"Código Barra");
        		manuaCodigoBarra.setLocation(getWidth()/2,(getHeight()/2)-100);
        		/*DEFINICIONES*/
    			for(GENERACIONCODIGOS gc : listGeneracionCodigo){
        			manuaCodigoBarra.listField.add(new JTextLabelPanel(pos++,gc.getIDGENERACION().toString(),gc.getDESCRIPCION().toString(), "",gc.getBARCODETOTAL()){
    					@Override
    					public void ordenfocusPanel(){
    						if(manuaCodigoBarra.listField.size()-1== row)
    							manuaCodigoBarra.listField.get(0).textField.requestFocus();
    						else
    							manuaCodigoBarra.listField.get(row+1).textField.requestFocus();
    					}
    				});
        		}        		
        		manuaCodigoBarra.cargarRow();
        		manuaCodigoBarra.show();
        		manuaCodigoBarra.ordenfocus(0);
        	}
        });
        
        JScrollPane scrollPaneInformacion = new JScrollPane();
        
        JButton btnDejarPalet = new JButton("Dejar Palet");
        btnDejarPalet.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		/*CAPTURAR*/
        	}
        });
        
        JButton btnUbActual = new JButton("Ub. Actual");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(ScrollPaneZona, GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(scrollPanelCabecera, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        						.addComponent(scrollPaneInformacion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(btnBarcode, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btnReturn)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btnZoommas)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(btnZoommenos))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(btnRecorrido)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btnTrafico)
        							.addGap(10)
        							.addComponent(btnStop)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btnUbicacin))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(cbLlegada, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(chkPosicion)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(chkObstaculo, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(btnDejarPalet)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(btnUbActual))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(btnMcodbarra)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(btnAlertStreetView, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(btnStreetview)))
        							.addGap(2)))))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(scrollPaneInformacion, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(scrollPanelCabecera, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnZoommenos)
        						.addComponent(btnZoommas)
        						.addComponent(btnReturn)
        						.addComponent(btnBarcode, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnUbicacin)
        						.addComponent(btnStop)
        						.addComponent(btnTrafico)
        						.addComponent(btnRecorrido))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnStreetview)
        						.addComponent(btnAlertStreetView)
        						.addComponent(btnMcodbarra))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnDejarPalet)
        						.addComponent(btnUbActual))
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(chkObstaculo)
        						.addComponent(chkPosicion)
        						.addComponent(cbLlegada))
        					.addGap(7)))
        			.addGap(11)
        			.addComponent(ScrollPaneZona, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        			.addContainerGap())
        );
        
        
        /*EDICIÓN*/
     // Create the StyleContext, the document and the pane
        StyleContext sc = new StyleContext();
        doc = new DefaultStyledDocument(sc);
        textPaneInfo = new JTextPane(doc);
        textPaneInfo.setEditable(false);

        // Create and add the style
        heading2Style = sc.addStyle("Heading2", null);
        heading2Style.addAttribute(StyleConstants.Foreground, Color.blue);
        heading2Style.addAttribute(StyleConstants.FontSize, new Integer(18));
        heading2Style.addAttribute(StyleConstants.FontFamily, "Tahoma");
        heading2Style.addAttribute(StyleConstants.Bold, new Boolean(true));
        
        scrollPaneInformacion.setViewportView(textPaneInfo);
        getContentPane().setLayout(layout);
//        CargaDistribucion();
//        CargarRutas();
        CargarDatosInicial();
        pack();
	}
	
	public void InsetarTextPanel(String info){
		try {
			doc.insertString(0, info, null);
			doc.setParagraphAttributes(0, 1, heading2Style, false);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<DPROGRAMAALMEJECUCION> cargarUbicacionesDisponibles(){
		List<DPROGRAMAALMEJECUCION> listUbicacionDisponibles = new ArrayList<>();
		try {
			if(!listDPROGRAMACIONTAREALLEGADA.isEmpty()){
				listUbicacionDisponibles=dPROGRAMAALMEJECUCIONDao.getListDPROGRAMAALMEJECUCION(Inicio.idempresa,Inicio.idsucursal, listDPROGRAMACIONTAREALLEGADA.get(0).getIDPROGRAMACIONLLENADO(),"PR");
			}
		} catch (SQLException | NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUbicacionDisponibles;
	}
	public DZONAGENERAL obtenerPosicionesLibres(){
		DZONAGENERAL posicionLibre=null;
		if(!listDPROGRAMACIONTAREALLEGADA.isEmpty()){
			ubicacionDispobible=cargarUbicacionesDisponibles().get(0);
			for(DZONAGENERAL dzonageneral: this.listDzonaGeneral){
				if(dzonageneral.getIDUBICACION().trim().equalsIgnoreCase(ubicacionDispobible.getIDUBICACION().trim())){
					posicionLibre = dzonageneral; 
					break;
				}
			}
		}
		return posicionLibre;
	} 
	/************************************************************************************************************/	
 	public void CargarRutas(){
		CargarRutas ej = new CargarRutas();
		hilo = new Thread(ej,NotacionesThread.tFrmSysZona_CargarRutas);
		hilo.start();
		Constantes.log.info(hilo.getName());
	}
	public void crearmatriz(){
		DZONAGENERAL();
	}
	public void panelZoom(JPanel panel){
		getPanelZona().Zoom(this.getTamanio());
		getPanelZona().setPreferredSize(new Dimension(zonaGeneral.getLARGO()*getTamanio(),zonaGeneral.getANCHO()*getTamanio()));
		getPanelZona().repaint();
    	ScrollPaneZona.setPreferredSize(new Dimension(zonaGeneral.getLARGO()*tamanio,zonaGeneral.getANCHO()*tamanio));
		ScrollPaneZona.repaint();
	}
	public void panelZoom(){
		ScrollPaneZona.repaint();
		getPanelZona().Zoom(this.getTamanio());
		getPanelZona().setPreferredSize(new Dimension(zonaGeneral.getLARGO()*getTamanio(),zonaGeneral.getANCHO()*getTamanio()));
		getPanelZona().repaint();
//    	ScrollPaneZona.setPreferredSize(new Dimension(zonaGeneral.getLARGO()*tamanio,zonaGeneral.getANCHO()*tamanio));
//		ScrollPaneZona.repaint();
		
	}
	public void DZONAGENERAL(){
    	getPanelZona().setPreferredSize(new Dimension(zonaGeneral.getLARGO()*getTamanio(),zonaGeneral.getANCHO()*getTamanio()));
    	getPanelZona().repaint();
	}
	/*CLASE DIAGRAMADOR*/
	public void CARGARCODIGO(String console,String charI,String charF){
		List<DGENERACIONCODIGOS> listDGeneracionCodigo =new ArrayList<DGENERACIONCODIGOS>();
		Map<String,String> mapa;
		int j=0;
		String codigo="";
		/*LIMPIAR PANEL*/
		panelCabecera.removeAll();
		panelCabecera.repaint();
		try{
			/*****************************TRAER DATOS DE CONSOLE*************************/
			ArrayList<String> listcodigo=new ArrayList<String>();
			for(int x=1;x<=listGeneracionCodigo.size();x++){
				listcodigo.add(codigo=Constantes.buscarFragmentoTexto(console,charI,charF,x));
			}
			/**************************RECORRER CABECERA********************************/
			for(GENERACIONCODIGOS gc : listGeneracionCodigo){
				mapa= new HashMap<String,String>();
				listDGeneracionCodigo 	=	(new DGENERACIONCODIGOSDao()).listar(1,"IDEMPRESA = ? and IDGENERACION = ?",gc.getIDEMPRESA(),gc.getIDGENERACION());
				/*BUSCAR CÓDIGO CON LONGITUD REQUERIDA*/
				codigo=buscarCadenaxLongitud(listcodigo,gc.getBARCODETOTAL());
				j=0;
				for(DGENERACIONCODIGOS dgc : listDGeneracionCodigo){
					mapa.put(dgc.getPARAMETRO(), codigo.substring(j,j+dgc.getNUMDIGITO()));
					j+=dgc.getNUMDIGITO();
				}
				/**********************************LLENAR DATOS**************************************/
				BarcodeTexto cajaTexto=new BarcodeTexto(mapa);
				panelCabecera.add(cajaTexto);
			}
			panelCabecera.revalidate();
			panelCabecera.repaint();
		}catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			Constantes.log.warn(e.getMessage());
			e.printStackTrace();
		}
	}
	public String buscarCadenaxLongitud(ArrayList<String> lista,int tamanio){
		String cadena="";
		for(String str : lista){
			if(str.length()==tamanio){
				cadena=str;
				break;
			}
		}
		return cadena;
	}
	/***************************************************************************************************************************/
	public int obtenerPisoAlerta(List<DZONADIAGRAMA> ldz){
		int piso=1;
		return piso;
	}
	private void EjecutarBar() {
		EjecutarBarcode ej = new EjecutarBarcode(process);
        new Thread(ej).start();
    }
	public void AlertUbicacion() {
		AlertUbicacion ej = new AlertUbicacion();
		hilo= new Thread(ej,NotacionesThread.tFrmSysZona_AlertaUbicacion);
		hilo.start();
		Constantes.log.info(hilo.getName());
//		new Thread(ej).start();
	}
	public void AlertUbicacionToca(DZONAGENERAL dzonageneral) {
		varHiloUbicacion=0;
		stopHilos(NotacionesThread.tFrmSysZona_AlertaUbicacionToca);
		AlertUbicacionToca ej = new AlertUbicacionToca(dzonageneral);
		hilo = new Thread(ej,NotacionesThread.tFrmSysZona_AlertaUbicacionToca+"-"+(varHiloUbicacion++));
		hilo.start();
		Constantes.log.info(hilo.getName());
		Constantes.log.info("Coordenada: x = "+dzonageneral.getCORDENADAX()+ ", y = "+dzonageneral.getCORDENADAY());
		Constantes.log.info("IDUBICACION : "+dzonageneral.getIDUBICACION());
//		new Thread(ej).start();
	}

	public void AlertUbicacionTocaList(List<DZONAGENERAL> listDz) {
		AlertUbicacionTocaList ej;
		varHiloUbicacion=0;
		stopHilos(NotacionesThread.tFrmSysZona_AlertaUbicacionToca);
		ej = new AlertUbicacionTocaList(listDz);
		hilo = new Thread(ej,NotacionesThread.tFrmSysZona_AlertaUbicacionToca+"-"+(varHiloUbicacion++));
		hilo.start();
		Constantes.log.info(hilo.getName());
		for(DZONAGENERAL dz : listDz){
			Constantes.log.info("Coordenada: x = "+dz.getCORDENADAX()+ ", y = "+dz.getCORDENADAY());
			Constantes.log.info("IDUBICACION : "+dz.getIDUBICACION());
		}
//		new Thread(ej).start();
	}
	public void StopAlertUbicacion() {
		AlertUbicacion ej = new AlertUbicacion();
		new Thread(ej).start();
	}
    private void EliminarBar() {
    	EliminarBarcode el = new EliminarBarcode(process);
        new Thread(el).start();
    }
    private void CargaDistribucion() {
    	CargaDistribucion el = new CargaDistribucion();
        new Thread(el).start();
    }
    private void ZoomMasDistribucion() {
    	ZoomMasDistribucion el = new ZoomMasDistribucion();
        new Thread(el).start();
    }
    private void ZoomMenosDistribucion() {
    	ZoomMenosDistribucion el = new ZoomMenosDistribucion();
        new Thread(el).start();
    }
    public String parametrosHtml(Map<String,String> claveValor){
    	String html="";
    	Iterator it = claveValor.entrySet().iterator();
    	Map.Entry e;
		while(it.hasNext()) {
			e = (Map.Entry)it.next();
			html+=Constantes.claveValorHtml(e.getKey().toString(),e.getValue().toString());
			System.out.println(e.getKey() + " " + e.getValue());
		}
    	return html;
    }
    public void stopHilos(String nameHilo){
    	threadGroup = Thread.currentThread ().getThreadGroup ();
		Thread [] listaHilo= new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(listaHilo, true);
		for(int i=0;i<listaHilo.length;i++){
			Constantes.log.info(listaHilo[i].getName());
			if(listaHilo[i].getName().contains(nameHilo)){
				listaHilo[i].stop();
				break;
			}
		}
    }
    public void CargarDatosInicial() {
    	CargarDatosInicial ej;
		ej = new CargarDatosInicial();
		hilo = new Thread(ej,NotacionesThread.tFrmSysZona_CargarDatosInicial);
		hilo.start();
	}
    public void MostrarRecorrido() {
    	MostrarRecorrido ej;
		ej = new MostrarRecorrido();
		hilo = new Thread(ej,NotacionesThread.tFrmSysZona_MostrarRecorrido);
		hilo.start();
	}
    class BarcodeTexto extends JLabel{
    	private static final long serialVersionUID = 1L;
    	public BarcodeTexto(Map<String,String> claveValor){
//    		super(parametrosHtml(claveValor));
    		this.setText("<html><p style=\"line-height: 150%;font-size:20;\">"+parametrosHtml(claveValor)+"</p></html>");
    		this.setVisible(true);
    		this.setSize(60, 200);
    		this.setFont(new Font(null, Font.PLAIN, 12));
//	        this.setOpaque(true);
//	        this.setForeground(Color.BLACK);
//	        this.setFont(new Font("Tahoma", Font.PLAIN, 12));
    		//this.name =new JLabel(name);
    	}
    }

	class Celda extends JButton implements ActionListener{
		private static final long serialVersionUID = 1L;
		private Integer x;
	    private Integer y;
	    private boolean selected;
	    public String id;
	    public ConfigTooltip configuracion;
	    public DZONAGENERAL obj;
	    public Celda(String text,DZONAGENERAL dz,Integer tamanio,String id,String tooltipHtml,ConfigTooltip cfg) {
	        super(text);
	        /**********************************************CONSTRUCCIÓN*********************/
	        this.id=id;
	        this.setBounds(dz.getCORDENADAY().intValue()*tamanio,dz.getCORDENADAX().intValue()*tamanio,tamanio.intValue(), tamanio.intValue());
	        this.setBackground(Constantes.hex2Rgb(dz.getCOLOR()));
	        this.setContentAreaFilled(false);
	        this.setOpaque(true);
	        this.setBorder(new LineBorder(new Color(240, 240, 240)));
	        this.configuracion=cfg;
//	        this.setToolTipText(tooltipHtml);
	        /*************************************************************************************/
	        this.x = dz.getCORDENADAY();
	        this.y = dz.getCORDENADAX();
	        obj=dz;
	        this.selected=true;
	        this.addActionListener(this);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	//S008A018R001P001F001C001
	    	this.configuracion.pisoAlerta=Integer.parseInt(obj.getIDUBICACION().substring(13,16));
	    	panelZona.cargarDatosPosicionPisos(this.obj,this.configuracion);
	    }

	}
	/*CLASES DE HILOS*/
	class CargarDatosInicial implements Runnable{
		@Override
		public synchronized void run() {
			// TODO Auto-generated method stub
			/*TRAER DATOS DE LA BASE DE DATOS*/
			cargarDatosMapa();
			wrutas = new MatrizRutas(){
	    		@Override
	    		public void marcarRecorrido(){
	    			List<Integer> test = panelZona.puntosExtremos_;
	    			int cPartida=panelZona.puntosExtremos_.get(0);
	    			int cLlegada=panelZona.puntosExtremos_.get(panelZona.puntosExtremos_.size()-1);
	    			caminoRecorrido= new ArrayList<CoordenadaMatriz>();
	    			List<Integer> l = f.MRutaList(cPartida,cLlegada);
	    			for (int i = 0; i< l.size(); i++) {
	    				for(int[] a : nodos) {
	    					if (l.get(i) == a[0]) {
	    						System.out.println(a[1]+ " " + a[2]);
	    					}
	    				}
	    			}
	    			System.out.println(f.MRuta(cPartida,cLlegada));  			
	    			if(l.size()>0){
	    				l.add(0, cPartida);
	    				getPanelZona().dibujarRutaMatriz(l,Color.GREEN,getTamanio());
	    				getPanelZona().repaint();
	    			}
//	    			panelZona.puntosExtremos_.clear();
	    		}
	    	};
	    	
			getPanelZona().setListDzonaGeneral(getListDzonaGeneral());
			/*DIBUJAR UBICACIONES*/
			CargaDistribucion();
			/*ALGORITMO DE RUTAS -> CREACION DE MATRIZ*/
			CargarRutas();
			/*DATOS ESTADO UBICACION*/
			cargarDatosEstadoUbicacion();
		}
	}
	class EliminarBarcode implements Runnable {
        public Process process;

        public EliminarBarcode(Process process) {
            this.process = process;
        }
        
        @Override
        public void run() {
            String archivo="WindowsApplication.exe";
            try{
                  Runtime.getRuntime().exec("TASKKILL /F /IM "+archivo);
            }
            catch(Exception e){
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
            String archivo=ConfigInicial.LlenarConfig()[10]; //Ruta_Proyecto HALCON 12
            try{
            	String console="";
                process = Runtime.getRuntime().exec(archivo);
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    console+=line;
                }
//                CARGARCODIGO(console,"@~", "~@");
                CARGARCODIGO(console,ConfigInicial.LlenarConfig()[11], ConfigInicial.LlenarConfig()[12]);
                reader.close();
            }
            catch(Exception e){
            	System.out.println(e.getMessage());
            }
        }
    }
    class AlertUbicacionToca implements Runnable{
    	public DZONAGENERAL dzAlerta;
    	public Boolean sincronize;
    	public AlertUbicacionToca(DZONAGENERAL dz){
    		this.sincronize=true;
    		this.dzAlerta=dz;
    	}
		@Override
		public synchronized void run() {
			// TODO Auto-generated method stub
			while(true){
				this.sincronize=alertaPosicionToca(this.dzAlerta,this.sincronize);
				try {
					Thread.sleep(timer);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    }
    class AlertUbicacionTocaList implements Runnable{
    	public List<DZONAGENERAL> listDZonaGeneral;
    	public Boolean sincronize;
    	public AlertUbicacionTocaList(List<DZONAGENERAL> listDZonaGeneral){
    		this.sincronize=true;
    		this.listDZonaGeneral=listDZonaGeneral;
    	}
		@Override
		public synchronized void run() {
			// TODO Auto-generated method stub
			while(true){
				
				this.sincronize=alertaPosicionTocaList(this.sincronize,this.listDZonaGeneral);
				try {
					Thread.sleep(timer);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    }
    class AlertUbicacion implements Runnable{
		@Override		
		public synchronized void run() {
			// TODO Auto-generated method stub
			int i=0;
			while(true){
				i=alertaUbicacion(i);
				try {
					Thread.sleep(timer);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

    }
    class CargaDistribucion implements Runnable{
    	@Override
    	public void run(){
    		crearmatriz();
    	}
    }
    class ZoomMasDistribucion implements Runnable{
    	@Override
    	public void run(){
			setTamanio(getTamanio() + 3);
			resetPanel();
			panelZoom(getPanelZona());
    	}
    }
    class ZoomMenosDistribucion implements Runnable{
    	@Override
    	public void run(){
    		if(getTamanio()>3){
    			setTamanio(getTamanio() - 3);
    			resetPanel();
    			panelZoom(getPanelZona());
    		}
    	}
    }
    class MostrarRecorrido implements Runnable{
		@Override		
		public synchronized void run() {
			// TODO Auto-generated method stub
			int i=0;
			while(true){
//				i=alertaUbicacion(i);
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
    class CargarRutas implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			wrutas.configuracionRutas(zonaGeneral, listDzonaGeneralCalles);
//    		estructuracionRutas();
		}
    }
    class RecorridoRuta implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			int i=0;
			while(true){
				i=alertaUbicacion(i);
				try {
					Thread.sleep(timer);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    }
    /***********************************************************************************************************************************/
    /*ELIMINAR OBJETOS ACTIVOS*/
    public void limpiarObjetos(){
    	/*Overlay-> Cerrar Tooltip*/
    	panelZona.frmToltip.Closed();
    }
    public DZONAGENERAL getDZONAGENERALubicacion(String IDUBICACION){
    	DZONAGENERAL DZ=null;
    	for(int i=0;i<getListDzonaGeneral().size();i++){
    		if(getListDzonaGeneral().get(i).getIDUBICACION().trim().equalsIgnoreCase(IDUBICACION.trim())){
    			DZ=getListDzonaGeneral().get(i);
    			break;
    		}
    	}
    	return DZ;
    }
    public Boolean alertaPosicionToca(DZONAGENERAL dz,Boolean sincronize){
    	if(sincronize){
	    	getPanelZona().parpadear(new ImageIcon(new ImageIcon(FrmSysZona08092015.class
								.getResource("/resources/montacarga/clipBlue2.png")).getImage()
								.getScaledInstance(getTamanio(), getTamanio(), java.awt.Image.SCALE_DEFAULT)
								), dz.getCORDENADAX(),dz.getCORDENADAY(),this.getTamanio(),
	    						Constantes.hex2Rgb(dz.getCOLOR()),this.selected,dz);
	    	sincronize=false;
    	}else{
    		getPanelZona().parpadear(new ImageIcon(new ImageIcon(FrmSysZona08092015.class
					.getResource("/resources/montacarga/clipBlue2.png")).getImage()
					.getScaledInstance(getTamanio(), getTamanio(), java.awt.Image.SCALE_DEFAULT)
					), dz.getCORDENADAX(),dz.getCORDENADAY(),this.getTamanio(),
    				Constantes.hex2Rgb(dz.getCOLOR()),this.selected,dz);
    		sincronize=true;
    	}
		getPanelZona().revalidate();
    	getPanelZona().repaint();
    	return sincronize;
    }
    public Boolean alertaPosicionTocaList(Boolean sincronize,List<DZONAGENERAL> listDZONAGENERAL){
    	if(sincronize){
	    	getPanelZona().parpadear(new ImageIcon(new ImageIcon(FrmSysZona08092015.class
								.getResource("/resources/montacarga/clipBlue4.png")).getImage()
								.getScaledInstance(getTamanio(), getTamanio(), java.awt.Image.SCALE_DEFAULT)
								), 0,0,this.getTamanio(),Color.black,sincronize,listDZONAGENERAL.get(0));
	    	sincronize=false;
    	}else{
    		getPanelZona().parpadear(new ImageIcon(new ImageIcon(FrmSysZona08092015.class
					.getResource("/resources/montacarga/clipBlue4.png")).getImage()
					.getScaledInstance(getTamanio(), getTamanio(), java.awt.Image.SCALE_DEFAULT)
					), 0,0,this.getTamanio(),Color.black,sincronize,listDZONAGENERAL.get(0));
    		sincronize=true;
    	}
		getPanelZona().revalidate();
    	getPanelZona().repaint();
    	return sincronize;
    }
    public int alertaUbicacion(int xc){
    	DZONAGENERAL dz= getListDzonaGeneral().get(xc);
    	for(int i=0;i<getPanelZona().getComponentCount();i++){
    		Celda cl = (Celda)getPanelZona().getComponent(i);
    		if(dz.getCORDENADAX()==cl.x & dz.getCORDENADAY()==cl.y){
				if(cl.selected){
					textoBoton=cl.getText();
					cl.setBackground(Color.WHITE);
					cl.setIcon(new ImageIcon(new ImageIcon(FrmSysZona08092015.class
							.getResource("/resources/montacarga/monticon2.png")).getImage()
							.getScaledInstance(cl.getWidth()+10, cl.getHeight(), java.awt.Image.SCALE_DEFAULT)
							));
					cl.selected=false;
				}else{
					cl.setText(textoBoton);
					cl.setBackground(Constantes.hex2Rgb(dz.getCOLOR()));
					cl.setIcon(null);
					cl.selected=true;
					xc++;
				}
				getPanelZona().setComponentZOrder(cl,i);
				break;
			}
    	}
		getPanelZona().revalidate();
    	getPanelZona().repaint();
    	return xc;
    }
    public String estructuraHtml(Object obj,int tipo){
    	String html="";
    	String style="<style>";
    	switch (tipo) {
		case 1:
			DZONAGENERAL dz =((DZONAGENERAL)obj);
	        html="<html>"
    		+ "<center><h1>Información</h1></center><br>"
    		+ "Zona: <b>"+dz.getZONA()+"</b><br>"
    		+ "Tipo: <b>"+dz.getTIPO()+"</b><br>"
    		+ "<img src=\""+FrmSysZona08092015.class.getResource("/resources/montacarga/montacargas3.png")+"\">"
			+ "</html>";
			break;
		case 2:
			DZONADIAGRAMA dzd = ((DZONADIAGRAMA)obj);
			html="<html>"
		    		+ "<center><h1>"+dzd.getTIPORACK()+"</h1></center><br>"
		    		+ "Almacen: <b>"+dzd.getTIPO()+"</b><br>"
    				+ "Id Zona: <b>"+dzd.getIDZONA()+"</b><br>"
    				+ "Id Almacen: <b>"+dzd.getIDALMACEN()+"</b><br>"
		    		+ "<img src=\""+FrmSysZona08092015.class.getResource("/resources/montacarga/montacargas3.png")+"\">"
					+ "</html>";
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
//		JOptionPane.showMessageDialog(null,"internalFrameClosed");
		NotacionesThread.stopThreadClass("FrmSysZona");
		limpiarObjetos();
		EliminarBar();
	}
	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		// TODO Auto-generated method stub
//		JOptionPane.showMessageDialog(null,"internalFrameClosing");
		NotacionesThread.stopThreadClass("FrmSysZona");
		EliminarBar();
		limpiarObjetos();
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
		return panelZona;
	}
	public void setPanelZona(DiagramaDistribucion panelZona) {
		this.panelZona = panelZona;
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
/************************************************** STREE VIEW ****************************************************/
	public Boolean AlertCubo(Boolean flag,int numCubo,Color colorAlert){
		if(flag){
			panelZona3D.setOperacion(1);
			flag=false;
		}else{
			panelZona3D.setOperacion(0);
			flag=true;
		}
		panelZona3D.repaint();
		return flag;
	}
	public void AlertStreetView() {
		Boolean flag=true;
		Integer numCubo=4;
		Color colorAlert=Color.GREEN;
		AlertStreetView ej = new AlertStreetView(flag,numCubo,colorAlert);
		hilo = new Thread(ej,NotacionesThread.tFrmSysZona_AlertStreetView);
		hilo.start();
		Constantes.log.info(hilo.getName());
//		new Thread(ej).start();
	}
	public List<DZONAGENERAL> getListDzonaGeneral() {
		return listDzonaGeneral;
	}
	public void setListDzonaGeneral(List<DZONAGENERAL> listDzonaGeneral) {
		this.listDzonaGeneral = listDzonaGeneral;
	}
	class AlertStreetView implements Runnable{
		Boolean flag;
		Integer numCubo;
		Color colorAlert;
		public AlertStreetView(Boolean flag,Integer numCubo,Color colorAlert){
			this.flag=flag;
			this.numCubo=numCubo;
			this.colorAlert=colorAlert;
		}
		@Override		
		public synchronized void run() {
			// TODO Auto-generated method stub
			while(true){
				flag=AlertCubo(this.flag,this.numCubo,this.colorAlert);
				try {
					Thread.sleep(timer+200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

    }
}


