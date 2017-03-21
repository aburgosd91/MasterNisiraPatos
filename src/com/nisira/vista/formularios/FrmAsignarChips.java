package com.nisira.vista.formularios;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import com.nisira.dao.DZONAGENERALDao;
import com.nisira.dao.ZONADao;
import com.nisira.dao.ZONAGENERALDao;
import com.nisira.entidad.DZONADIAGRAMA;
import com.nisira.entidad.DZONAGENERAL;
import com.nisira.entidad.ZONA;
import com.nisira.entidad.ZONAGENERAL;
import com.nisira.utils.nisiracore.Constantes;
import com.nisira.vista.barras.PanelBarraMaestro;
import com.nisira.vista.controles.NSRComboBox;
import com.nisira.vista.controles.NSRInternalFrame;

import core.inicio.ConfigInicial;

import javax.swing.JComboBox;

public class FrmAsignarChips extends NSRInternalFrame implements InternalFrameListener{
	public List<ZONA> listZona;
	
	/*************************************************************/
	public ThreadGroup threadGroup;
	public final int timer=500;
	public Thread hilo;
	public FrmTooltip frmToltip;
	/*****************CONFIGURACIÓN PARA TOOLTIP*****************/
	final Integer tiempoCierre=15;
	final Color alerta= Color.white; 
	/****************************** VARIABLES ACCESORIOS******************************/ 
//	private List<MULTITABLA> listTipoZona;
	/****************************** VARIABLES PRIMARIAS******************************/ 
	private ZONAGENERAL zonaGeneral;
	private List<ZONAGENERAL> listZonaGeneral;
	private List<DZONAGENERAL> listDzonaGeneral;
	private List<DZONAGENERAL> listDZonaGeneralPos; 

	private ZONADao zonaDao;
	private ZONAGENERALDao zonaGeneralDao;
	private DZONAGENERALDao dzonaGeneralDao;
	private int tamanio;
	int TIPODIAGRAMA;
	/***********************************************************************/
	private static final long serialVersionUID = 7755124973019289267L;
	private JScrollPane ScrollPaneZona;
    private JPanel panelZona;
    private JButton btnReset;
    private static final int _ancho = 40;
    private static final int _alto = 40;
    private JScrollPane scrollPanelCabecera;
    private JPanel panelCabecera;
    private NSRComboBox cboZona;
    private JLabel lblAlmacen;
    private JLabel lblAreaUD;
    public static void main(String[] args) {
		new FrmAsignarChips();
	}
    public void __constructor(){
    	
    	/*****************PARAMETROS INICIALES*********************/
    	TIPODIAGRAMA=0;
    	/************************LISTA*************************/
    	listZonaGeneral=new ArrayList<ZONAGENERAL>();
    	zonaGeneral =new ZONAGENERAL();
    	listDzonaGeneral=new ArrayList<DZONAGENERAL>();
    	
    	/*DAO*/
    	zonaDao= new ZONADao();
    	zonaGeneralDao=new ZONAGENERALDao();
    	dzonaGeneralDao = new DZONAGENERALDao();
    	dzonaGeneralDao = new DZONAGENERALDao();
    	tamanio=5;
    }
    public void cargarDatos(){
    	try {
//    		listZona = zonaDao.listar(1,"IDEMPRESA = ? AND IDSUCURSAL = ?",ConfigInicial.LlenarConfig()[8],
//    				ConfigInicial.LlenarConfig()[9]);//<IDEMPRESA> , <IDSUCURSAL>
    		listZona = zonaDao.getLisZona(1,Integer.parseInt(ConfigInicial.LlenarConfig()[8]), 
    				Integer.parseInt(ConfigInicial.LlenarConfig()[9]), 1);
//			listZonaGeneral=zonaGeneralDao.listar(1);
//			zonaGeneral=listZonaGeneral.get(0);
//			listDzonaGeneral=dzonaGeneralDao.getLisDZonaGeneral_(1,zonaGeneral);
			/*CARGA PROGRAMACION*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void resetPanel(){
    	getPanelZona().removeAll();
    	getPanelZona().repaint();
    	crearmatriz(this.TIPODIAGRAMA);
    	getPanelZona().revalidate();
    	getPanelZona().repaint();
    	ScrollPaneZona.repaint();
    }
	public FrmAsignarChips() {
		__constructor();
		cargarDatos();
		llenarComboZonas();
		setTitle("Asignacion de Chips");
        setPanelZona(new JPanel());
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
        getPanelZona().setPreferredSize(new Dimension(734, 500));
        ScrollPaneZona.setViewportView(getPanelZona());
        JButton btnZoommenos = new JButton("");
        btnZoommenos.setBorder(UIManager.getBorder("Button.border"));
        btnZoommenos.setAlignmentY(Component.TOP_ALIGNMENT);
        btnZoommenos.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnZoommenos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(tamanio>1){
        			tamanio-=5;
        			resetPanel();
        			panelZoom(getPanelZona());
        		}
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
    			tamanio+=5;
    			resetPanel();
    			panelZoom(getPanelZona());
        	}
        });
        
        btnZoommas.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/zoom_in.png")).getImage()
				.getScaledInstance(_ancho, _alto, java.awt.Image.SCALE_DEFAULT)));
        JButton btnCargar = new JButton("");
        btnCargar.setToolTipText("Refrescar Pantalla");
        btnCargar.setBorder(UIManager.getBorder("Button.border"));
        btnCargar.setAlignmentY(Component.TOP_ALIGNMENT);
        btnCargar.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnCargar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        	}
        });
        btnCargar.setIcon(new ImageIcon(FrmAsignarChips.class.getResource("/resources/actualizar.png")));
        btnReset = new JButton("");
        btnReset.setToolTipText("Resetear");
        btnReset.setAlignmentY(Component.TOP_ALIGNMENT);
        btnReset.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnReset.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		/****************************RETORNAR**************************/
        		TIPODIAGRAMA=2;
    	    	resetPanel();
        		/**************************************************************/
        	}
        });
        btnReset.setIcon(new ImageIcon(FrmAsignarChips.class.getResource("/resources/return1.png")));
        
        scrollPanelCabecera = new JScrollPane();
        scrollPanelCabecera.setBorder(UIManager.getBorder("ScrollPane.border"));
        panelCabecera = new JPanel();
        panelCabecera.setBorder(null);
        scrollPanelCabecera.setViewportView(panelCabecera);
        
        JLabel lblNewLabel = new JLabel("Zona:");

        JLabel lblTipo = new JLabel("Tipo:");
        
        lblAlmacen = new JLabel("ALMACEN");
        
        JLabel lblAreaud = new JLabel("Area(UD):");
        
        lblAreaUD = new JLabel("0000");
        GroupLayout gl_panelCabecera = new GroupLayout(panelCabecera);
        gl_panelCabecera.setHorizontalGroup(
        	gl_panelCabecera.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelCabecera.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(cboZona, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
        			.addGap(26)
        			.addComponent(lblTipo)
        			.addGap(18)
        			.addComponent(lblAlmacen)
        			.addGap(66)
        			.addComponent(lblAreaud)
        			.addGap(18)
        			.addComponent(lblAreaUD, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(96, Short.MAX_VALUE))
        );
        gl_panelCabecera.setVerticalGroup(
        	gl_panelCabecera.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelCabecera.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panelCabecera.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel)
        				.addComponent(cboZona, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblTipo)
        				.addComponent(lblAlmacen)
        				.addComponent(lblAreaUD)
        				.addComponent(lblAreaud))
        			.addGap(23))
        );
        panelCabecera.setLayout(gl_panelCabecera);
        
        DragScrollListener dl = new DragScrollListener(panelZona);
        GroupLayout gl_panelZona = new GroupLayout(panelZona);
        gl_panelZona.setHorizontalGroup(
        	gl_panelZona.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 838, Short.MAX_VALUE)
        );
        gl_panelZona.setVerticalGroup(
        	gl_panelZona.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 513, Short.MAX_VALUE)
        );
        panelZona.setLayout(gl_panelZona);
		panelZona.addMouseListener(dl);
		panelZona.addMouseMotionListener(dl);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(ScrollPaneZona, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(scrollPanelCabecera, GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
        					.addGap(18)
        					.addComponent(btnCargar, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnZoommas)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnZoommenos)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnZoommenos)
        				.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        					.addComponent(btnReset, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
        					.addComponent(btnCargar, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
        				.addComponent(btnZoommas)
        				.addComponent(scrollPanelCabecera, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(ScrollPaneZona, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);
        pack();
        
//        crearmatriz(this.TIPODIAGRAMA);
	}
	/****************************************************************/
	public void llenarComboZonas(){
		if(listZona.size()>0){
			List<String[]> listaZonasString=new ArrayList<String[]>();
			for(ZONA zona : listZona){
				String[] objeto={zona.getIDZONA().toString(),zona.getDESCRIPCION(),zona.getIDTIPOZONA().toString(),
						zona.getTIPO().toString()};
				listaZonasString.add(objeto);
			}
			cboZona = new NSRComboBox(listaZonasString, 0, 1);
			cboZona.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String[] objeto=(String[])cboZona.getSelectedItem();
					lblAlmacen.setText(objeto[1]);
					lblAreaUD.setText(objeto[3]);
				}
			});
		}
	}
	public String obtenerTipoZona(){
		String tipoZona;
		return null;
	}
	public void crearmatriz(int tipo){
		switch(tipo){
			case 0:DZONAGENERAL();break;
		}
		/*RECORRER MATRIZ*/
	}
	public void panelZoom(JPanel panel){
		panel.setPreferredSize(new Dimension(zonaGeneral.getLARGO()*tamanio,zonaGeneral.getANCHO()*tamanio));
		panel.repaint();
    	ScrollPaneZona.setPreferredSize(new Dimension(zonaGeneral.getLARGO()*tamanio,zonaGeneral.getANCHO()*tamanio));
		ScrollPaneZona.repaint();
		
	}
	public void DZONAGENERAL(){
		getPanelZona().removeAll();
		for(DZONAGENERAL dz:listDzonaGeneral){
			if(dz.getIDZONA()!=0 & !dz.getIDUBICACION().equals("")){
				Celda b = new Celda("",dz,tamanio,dz.getIDUBICACION(),estructuraHtml(dz,1),
						new ConfigTooltip(0,this.timer,1,this.tiempoCierre,null,alerta));
				getPanelZona().add(b);
			}
		}
		getPanelZona().revalidate();
    	getPanelZona().repaint();
    	getPanelZona().setPreferredSize(new Dimension(zonaGeneral.getLARGO()*tamanio,zonaGeneral.getANCHO()*tamanio));
    	getPanelZona().repaint();
    	ScrollPaneZona.setPreferredSize(new Dimension(zonaGeneral.getLARGO()*tamanio,zonaGeneral.getANCHO()*tamanio));
		ScrollPaneZona.repaint();
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
	public int getTIPODIAGRAMA() {
		return TIPODIAGRAMA;
	}
	public void setTIPODIAGRAMA(int tIPODIAGRAMA) {
		TIPODIAGRAMA = tIPODIAGRAMA;
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

    class ConfigTooltip{
    	public Integer numPisos;
    	public long timer;
    	public Integer pisoAlerta;
    	public Integer tiempoCierre;
    	public Color origen;
    	public Color alerta;
    	public ConfigTooltip(Integer p1,long p2,Integer p3,Integer p4,Color origen,Color alerta){
    		this.numPisos=p1;
    		this.timer=p2;
    		this.pisoAlerta=p3;
    		this.tiempoCierre=p4;
    		this.origen=origen;
    		this.alerta=alerta;
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
	    	//cargarDatosPosicionPisos(this.obj,this.configuracion);	    	
	    }

	}
    /***********************************************************************************************************************************/	
    public DZONAGENERAL getDZONAGENERALubicacion(String IDUBICACION){
    	DZONAGENERAL DZ=null;
    	for(int i=0;i<listDzonaGeneral.size();i++){
    		if(listDzonaGeneral.get(i).getIDUBICACION().trim().equalsIgnoreCase(IDUBICACION.trim())){
    			DZ=listDzonaGeneral.get(i);
    			break;
    		}
    	}
    	return DZ;
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
    		+ "<img src=\""+FrmAsignarChips.class.getResource("/resources/montacarga/montacargas3.png")+"\">"
			+ "</html>";
			break;
		case 2:
			DZONADIAGRAMA dzd = ((DZONADIAGRAMA)obj);
			html="<html>"
		    		+ "<center><h1>"+dzd.getTIPORACK()+"</h1></center><br>"
		    		+ "Almacen: <b>"+dzd.getTIPO()+"</b><br>"
    				+ "Id Zona: <b>"+dzd.getIDZONA()+"</b><br>"
    				+ "Id Almacen: <b>"+dzd.getIDALMACEN()+"</b><br>"
		    		+ "<img src=\""+FrmAsignarChips.class.getResource("/resources/montacarga/montacargas3.png")+"\">"
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
	}
	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		// TODO Auto-generated method stub
//		JOptionPane.showMessageDialog(null,"internalFrameClosing");
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
	public JPanel getPanelZona() {
		return panelZona;
	}
	public void setPanelZona(JPanel panelZona) {
		this.panelZona = panelZona;
	}
	public List<DZONAGENERAL> getListDZonaGeneralPos() {
		return listDZonaGeneralPos;
	}
	public void setListDZonaGeneralPos(List<DZONAGENERAL> listDZonaGeneralPos) {
		this.listDZonaGeneralPos = listDZonaGeneralPos;
	}
}

