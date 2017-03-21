package com.nisira.vista.movil.map;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import com.nisira.Inicio;
import com.nisira.dao.DZONAGENERALDao;
import com.nisira.entidad.CoordenadaMatriz;
import com.nisira.entidad.DZONAGENERAL;
import com.nisira.entidad.MOVUBICACION;
import com.nisira.utils.nisiracore.Constantes;
import com.nisira.vista.controles.FormatStyleText;
import com.nisira.vista.formularios.DragScrollListener;
import com.nisira.vista.formularios.FrmSysZona;
import com.nisira.vista.formularios.FrmTooltip;
import com.nisira.vista.formularios.FrmTooltipOverlay;

public class DiagramaDistribucion04102016 extends JPanel implements MouseListener,MouseMotionListener,MouseWheelListener{

	private static final long serialVersionUID = 1L;
	/*CONTROLES*/
	public FrmTooltipOverlay frmToltip;
	public ConfigTooltip tooltip;
	/*PARAMETROS*/
	public static final int twidthOverlay=300;
	public static final int theightOverlay=200;
	public static boolean chkPosicion;
	public static Image cpaleta;
	public Boolean flagActivo;
	public Boolean selected_;
	public Image fondo;
	public Image iconofondo;
	public static final Image iconoPunto=(new ImageIcon(FrmSysZona.class.getResource("/resources/montacarga/montacargaanimacion.gif"))).getImage();
	public static final Image iconoDestino=(new ImageIcon(FrmSysZona.class.getResource("/resources/montacarga/packing.gif"))).getImage();
	public int operacion;
	public int cx;
	public int cy;
	public Color original;
	public Color ruta;
	public static int tamanio;
	/*ENTITY*/
	public DZONAGENERAL selectActual;
	public DZONAGENERAL antereorActual;/*SOLO PARA VALIDAR QUE EL VALOR DEL CLICK POR UBICACION SE DE UNA SOLA VEZ */
	public DZONAGENERAL selectDestino;
	/*ARRAY*/
	public List<Integer> puntosExtremos_;
	private List<DZONAGENERAL> listDzonaGeneral;
	public List<DZONAGENERAL> listDzonaGeneralObjetos;
	public List<MOVUBICACION> listMovUbicacion;
	public List<CoordenadaMatriz> puntos;
	public List<Integer> puntos_;

	public DiagramaDistribucion04102016(List<DZONAGENERAL> listDzonaGeneral ,ConfigTooltip tooltip,int tamanio){
		this.setListDzonaGeneral(listDzonaGeneral);
		this.tooltip=tooltip;
		this.addMouseListener(this);
		this.addMouseWheelListener(this);
		this.flagActivo=false;
		this.operacion=0;
		this.fondo=null;
		this.cx=0;
		this.cy=0;
		this.tamanio=tamanio;
		this.selected_=true;
		this.listDzonaGeneralObjetos= new ArrayList<DZONAGENERAL>();
		this.puntosExtremos_= new ArrayList<Integer>();
		this.cpaleta=(new ImageIcon(FrmSysZona.class.getResource("/resources/montacarga/palletanimacion.gif"))).getImage();
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseListener(this);
		/*DRAGSCROLL-LISTENER*/
		draggableComponent = this;
		antereorActual= new DZONAGENERAL();
		defaultCursor = draggableComponent.getCursor();
		draggableComponent.addPropertyChangeListener(new PropertyChangeListener(){
			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				setScroller();
				defaultCursor = draggableComponent.getCursor();
			}
		});
		setScroller();
   }
    // Se sobrescribe el método paint()
	@Override
    public void paint(Graphics g) {
    	super.paint(g); // Para que se dibuje el mismo 
    	Graphics2D g2 = (Graphics2D) g;
    	/*DIBUJAR VISTA DE PLANTA*/
    	DZONAGENERAL dz= new DZONAGENERAL();
    	DZONAGENERAL dz_anterior = null;
    	if(this.getListDzonaGeneral()!=null){
    		String dzIdUbicacion = "";
    		String dz_anteriorIdUbicacion = "";
    		List<DZONAGENERAL> listPisosDZonaGeneral= new ArrayList<>();
    		
    		/*PROPUESTA DE DISEÑO*/
    		for(int i=0;i<getListDzonaGeneral().size();i++){
	    		dz=getListDzonaGeneral().get(i);
	    		if(tamanio<=12){
	    			g.setColor(Constantes.hex2Rgb(dz.getCOLORZONA()));
	    			g.fillRect((dz.getCORDENADAY().intValue()+1)*tamanio,(dz.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
//		    		g.fillRect((dz.getCORDENADAY().intValue()+1)*tamanio,(dz.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
	    		}else{
		    		g.setColor(Constantes.hex2Rgb(dz.getCOLOR()));
		    		g.fillRect((dz.getCORDENADAY().intValue()+1)*tamanio,(dz.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
//		    		g.fillRect((dz.getCORDENADAY().intValue()+1)*tamanio,(dz.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
		    		/*CALLE SIN BORDE*/
		    		if(dz.getTIPORACKS()!=null)
		    			/* TIPO RACKS */
		    			if(!dz.getTIPORACKS().equalsIgnoreCase("CALLE")){
		    				/*DIBUJAR CUADRADO DENTRO DE UNA UBICACION*/
				    		if(dz_anterior!=null){
				    			if(!dz_anterior.getTIPORACKS().equalsIgnoreCase("CALLE")){
				    				/* COMPARAR LA ZONA */
					    			dzIdUbicacion = dz.getIDUBICACION().substring(0, 12)+""+dz.getIDUBICACION().substring(16,24);
					    			dz_anteriorIdUbicacion = dz_anterior.getIDUBICACION().substring(0, 12)+""+dz_anterior.getIDUBICACION().substring(16,24);
					    			/*S001A002R003P001F001C002*/
//					    			System.out.println(dzIdUbicacion);
					    			if(dzIdUbicacion.equals(dz_anteriorIdUbicacion)){
					    				if(listPisosDZonaGeneral.size()==0){
					    					listPisosDZonaGeneral.add(dz);
					    					listPisosDZonaGeneral.add(dz_anterior);
					    				}
					    				else
					    					listPisosDZonaGeneral.add(dz_anterior);
					    			}else{
					    				int xt=1;
					    				/*tpisos = 3*/
					    				if(listPisosDZonaGeneral.size()>0){
					    					int x_inicio=0;
					    					int y_inicio=0;
					    					int secciones = tamanio/(listPisosDZonaGeneral.size()>0?listPisosDZonaGeneral.size():1);
					    					g.setColor(Color.BLUE);
					    					for(DZONAGENERAL XD : listPisosDZonaGeneral){
					    						x_inicio=(XD.getCORDENADAY().intValue()+1)*tamanio;
						    					y_inicio=(XD.getCORDENADAX().intValue()+1)*tamanio;
						    					g.drawString("piso "+(xt),x_inicio, y_inicio);
						    					g.drawRect(x_inicio,y_inicio,tamanio,secciones);
						    					x_inicio+=secciones*(xt);
						    					xt++;
					    					}
					    					listPisosDZonaGeneral=new ArrayList<>();
					    				}
					    			}
				    			}
				    		}
		    			}
	    		}
	    		dz_anterior = dz;
    		}
    	}
    	/*DIBUJAR DIVISION COMPLETA*/
    	for(int i=0;i<getListDzonaGeneral().size();i++){
    		dz=getListDzonaGeneral().get(i);
    		if(tamanio>12){
//    			g.setColor(Constantes.hex2Rgb(dz.getCOLORZONA()));
//    			g.fillRect((dz.getCORDENADAY().intValue()+1)*tamanio,(dz.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
//	    		g.fillRect((dz.getCORDENADAY().intValue()+1)*tamanio,(dz.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
//    			g.setColor(Constantes.hex2Rgb(dz.getCOLOR()));
//	    		g.fillRect((dz.getCORDENADAY().intValue()+1)*tamanio,(dz.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
////	    		g.fillRect((dz.getCORDENADAY().intValue()+1)*tamanio,(dz.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
	    		/*CALLE SIN BORDE*/
	    		if(dz.getTIPORACKS()!=null)
	    			/* TIPO RACKS */
	    			if(!dz.getTIPORACKS().equalsIgnoreCase("CALLE")){
	    				/*DIBUJAR CUADRADO DENTRO DE UNA UBICACION*/
	    				g2.setColor(Color.BLACK);
    				    g2.setStroke(new BasicStroke(4.0f));
    				    g2.drawRect((dz.getCORDENADAY().intValue()+1)*tamanio,(dz.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
	    			}
    		}
		}
    	/*DIBUJAR ESTADO(OCUPADA/LIBRE) POSICIONES EN PLANTA*/
//    	if(tamanio>12){
//    		if(listMovUbicacion!=null){
//    			for(MOVUBICACION obj:listMovUbicacion){
//    				g.drawImage(cpaleta,(obj.getCORDENADAY()+1)*tamanio,(obj.getCORDENADAX()+1)*tamanio,tamanio,tamanio,this);
////    	    		g.fillRect((obj.getCORDENADAY().intValue()+1)*tamanio,(obj.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
////    	    		g.fillRect((obj.getCORDENADAY().intValue()+1)*tamanio,(obj.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
//    	    		g.setColor(Color.BLACK);
//    				g.drawRect((obj.getCORDENADAY().intValue()+1)*tamanio,(obj.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
//    			}
//    		}
//    	}
    	/*DIBUJAR UBICACIÓN ACTUAL EN PLANTA*/
    	if(selectActual!=null){
    		g.setColor(Color.WHITE);
			g.fillRect((selectActual.getCORDENADAY().intValue()+1)*tamanio,(selectActual.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
			g.drawImage(iconoPunto,(selectActual.getCORDENADAY()+1)*tamanio,(selectActual.getCORDENADAX()+1)*tamanio,tamanio,tamanio,null);
    		g.drawRect((selectActual.getCORDENADAY().intValue()+1)*tamanio,(selectActual.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
    	}
    	/*DIBUJAR UBICACIÓN DESTINO EN PLANTA*/
    	if(selectDestino!=null){
    		g.setColor(Color.WHITE);
			g.fillRect((selectDestino.getCORDENADAY().intValue()+1)*tamanio,(selectDestino.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
			g.drawImage(iconoDestino,(selectDestino.getCORDENADAY()+1)*tamanio,(selectDestino.getCORDENADAX()+1)*tamanio,tamanio,tamanio,null);
    		g.drawRect((selectDestino.getCORDENADAY().intValue()+1)*tamanio,(selectDestino.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
    	}
    	/*OPERACIONES EXTRAS*/
    	switch (this.operacion) {
		case 1://Agregar Imagen a un pasición
			g.drawImage(iconoPunto,cx*tamanio,cy*tamanio,tamanio,tamanio,null);
			break;
		case 2://Pintar Ruta
			/*** BORDE ***/
			int cordenada[]= new int[2];
			int cordenada_ant[]= new int[2];
			for(int i=0;i<puntos_.size();i++){
				cordenada=MatrizRutas.posicionMatrizRecorridoCoordenada(puntos_.get(i));
				g.setColor(Color.BLACK);
				g.drawRect((cordenada[1]+1)*tamanio,(cordenada[0]+1)*tamanio,tamanio, tamanio);
				/***************************************************************/
				String direccion="";
				if(!(cordenada_ant[0]==0 & cordenada_ant[1]==0)){
					direccion=prioridadOrientacion(cordenada_ant,cordenada);
					
					iconofondo=( new ImageIcon(
	    					new ImageIcon(FrmSysZona.class.getResource("/resources/"+direccion+".png")).getImage()
								.getScaledInstance(tamanio, tamanio, java.awt.Image.SCALE_DEFAULT))).getImage();
					g.drawImage(iconofondo,(cordenada[1]+1)*tamanio,(cordenada[0]+1)*tamanio,tamanio,tamanio,null);
				}
				cordenada_ant[0]=cordenada[0];
			    cordenada_ant[1]=cordenada[1];
			}
			break;
		case 3: 
			DZONAGENERAL dz_=this.selectActual;
			//Constantes.hex2Rgb("#5FE600");
			g.setColor(Color.WHITE);
			g.fillRect((dz_.getCORDENADAY().intValue()+1)*tamanio,(dz_.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
			g.drawImage(fondo,(dz_.getCORDENADAY()+1)*tamanio,(dz_.getCORDENADAX()+1)*tamanio,tamanio,tamanio,null);
    		g.drawRect((dz_.getCORDENADAY().intValue()+1)*tamanio,(dz_.getCORDENADAX().intValue()+1)*tamanio,tamanio, tamanio);
			;break;
		default:
			break;
		}
    }
	public String prioridadOrientacion(int antereor[],int actual[]){
		String direccion= "";
		/*DEPURAR POR DIRECCION*/
		if(antereor[0]<actual[0]){
			direccion="bottom_blue";
		}
		if(antereor[0]>actual[0]){
			direccion="top_blue";
		}
		if(antereor[1]<actual[1]){
			direccion="right_blue";
		}
		if(antereor[1]>actual[1]){
			direccion="left_blue";
		}
		return direccion;
	}
	/*OVERRIDE*/
	public DZONAGENERAL seleccionClick(int y,int x){
//		DZONAGENERAL dz=null;
//		boolean flag=false;
//		int cXi,cYi,cXf,cYf;
//		for(int i=0;i<getListDzonaGeneral().size();i++){
//    		dz=getListDzonaGeneral().get(i);
//    		cXi=dz.getCORDENADAX().intValue()*tamanio;
//			cYi=dz.getCORDENADAY().intValue()*tamanio;
//			cXf=cXi+tamanio;
//			cYf=cYi+tamanio;
//    		if(y>=cYi & y<=cYf & x>=cXi & x<=cXf){
//    			flag=true;
//    			break;
//    		}
//		}
//		if(flag)
//			return dz;
//		else
			return null;
	}
	public DZONAGENERAL findUbicacion(String idubicacion){
//		DZONAGENERAL dz=null;
//		boolean flag=false;
//		for(int i=0;i<getListDzonaGeneral().size();i++){
//    		dz=getListDzonaGeneral().get(i);
//    		if(dz.getIDUBICACION().equals(idubicacion)){
//    			flag=true;
//    			break;
//    		}
//		}
//		if(flag)
//			return dz;
//		else
			return null;
	}
	public void Zoom(int tamanio){
		this.tamanio=tamanio;
		this.operacion=0;
	}
	public void asignarPosicion(int cx,int cy,int tamanio,Color original,Boolean flagActivo){
		this.cx=cy+1;
		this.cy=cx+1;
		this.tamanio=tamanio;
		this.original=original;
		this.flagActivo=flagActivo;
		if(this.flagActivo)
			this.operacion=1;
		else
			this.operacion=10;
		this.repaint();
	}
	public void parpadear(ImageIcon fondo,int cx,int cy,int tamanio,Color original,Boolean flagActivo,DZONAGENERAL dz){
		this.fondo=fondo.getImage();
		this.cx=cy+1;
		this.cy=cx+1;
		this.tamanio=tamanio;
		this.original=original;
		this.flagActivo=flagActivo;
		if(this.flagActivo)
			this.operacion=3;
		else
			this.operacion=10;
		this.selectActual=dz;
//		repaint();
	}
	public void dibujarRuta(List<CoordenadaMatriz> puntos,Color ruta,int tamanio){
		this.puntos=puntos;
		this.ruta=ruta;
		this.tamanio=tamanio;
		this.operacion=2;
	}
	public void dibujarRutaMatriz(List<Integer> puntos,Color ruta,int tamanio){
		this.puntos_=puntos;
		this.ruta=ruta;
		this.tamanio=tamanio;
		this.operacion=2;
	}
	public void stockAlmacenes(List<MOVUBICACION> listMovUbicacion){
		if(listMovUbicacion!=null){
			this.listMovUbicacion=listMovUbicacion;
//			this.operacion=4;
		}
	}
	
	/**************************COMPONENTES DE DRAGSCROLL_LISTENER ******************************************/
	//flags used to turn on/off draggable scrolling directions
	public static final int DRAGGABLE_HORIZONTAL_SCROLL_BAR = 1;
	public static final int DRAGGABLE_VERTICAL_SCROLL_BAR = 2;
	//defines the intensite of automatic scrolling.
	private int scrollingIntensity = 10;
	//value used to descrease scrolling intensity during animation
	private double damping = 0.05;
	//indicates the number of milliseconds between animation updates. 
	private int animationSpeed = 20;
	//Animation timer
	private javax.swing.Timer animationTimer = null;
	//the time of the last mouse drag event
	private long lastDragTime = 0;
	private Point lastDragPoint = null;
	//animation rates
	private double pixelsPerMSX;
	private double pixelsPerMSY;
	//flag which defines the draggable scroll directions
	private int scrollBarMask = DRAGGABLE_HORIZONTAL_SCROLL_BAR | DRAGGABLE_VERTICAL_SCROLL_BAR;
	//the draggable component
	private final Component draggableComponent;
	//the JScrollPane containing the component - programmatically determined. 
	private JScrollPane scroller = null;
	//the default cursor
	private Cursor defaultCursor;
	//List of drag speeds used to calculate animation speed
	//Uses the Point2D class to represent speeds rather than locations
	private java.util.List<Point2D.Double> dragSpeeds = new ArrayList<Point2D.Double>();
	
	private void setScroller(){
		Component c = getParentScroller(draggableComponent);
		if ( c != null ){
			scroller = (JScrollPane)c;
		}else{
			scroller = null;
		}
	}
	/**
	 * Sets the Draggable elements - the Horizontal or Vertical Direction. One
	 * can use a bitmasked 'or' (HORIZONTAL_SCROLL_BAR | VERTICAL_SCROLL_BAR ).
	 * @param mask One of HORIZONTAL_SCROLL_BAR, VERTICAL_SCROLL_BAR, or HORIZONTAL_SCROLL_BAR | VERTICAL_SCROLL_BAR 
	 */
	public void setDraggableElements(int mask){
		scrollBarMask = mask;
	}
	/**
	 * Sets the scrolling intensity - the default value being 5. Note, that this has an
	 * inverse relationship to intensity (1 has the biggest difference, higher numbers having
	 * less impact). 
	 * @param intensity The new intensity value (Note the inverse relationship).
	 */
	public void setScrollingIntensity(int intensity){
		scrollingIntensity = intensity;
	}
	/**
	 * Sets how frequently the animation will occur in milliseconds. Default 
	 * value is 30 milliseconds. 60+ will get a bit flickery.
	 * @param timing The timing, in milliseconds.
	 */
	public void setAnimationTiming(int timing){
		animationSpeed = timing;
	}
	/**
	 * Sets the animation damping. 
	 * @param damping The new value
	 */
	public void setDamping(double damping){
		this.damping = damping;
	}
	
	private class ScrollAnimator implements ActionListener{
		/**
		 * Performs the animation through the setting of the JScrollBar values.
		 */
		public void actionPerformed(ActionEvent e){
			//damp the scrolling intensity
			pixelsPerMSX -= pixelsPerMSX * damping;
			pixelsPerMSY -= pixelsPerMSY * damping;
			//check to see if timer should stop.
			if ( Math.abs(pixelsPerMSX) < 0.01 && Math.abs(pixelsPerMSY) < 0.01  ){
				animationTimer.stop();
				return;
			}
			//calculate new X value
			int nValX = getHorizontalScrollBar().getValue() + (int)(pixelsPerMSX * scrollingIntensity);
			int nValY = getVerticalScrollBar().getValue() + (int)(pixelsPerMSY * scrollingIntensity);
			//Deal with out of scroll bounds
			if ( nValX <= 0 ){
				nValX = 0;
			}else if ( nValX >= getHorizontalScrollBar().getMaximum()){
				nValX = getHorizontalScrollBar().getMaximum();
			}
			if ( nValY <= 0 ){
				nValY = 0;
			}else if ( nValY >= getVerticalScrollBar().getMaximum() ){
				nValY = getVerticalScrollBar().getMaximum();
			}
			//Check again to see if timer should stop
			if ( (nValX == 0 || nValX == getHorizontalScrollBar().getMaximum()) && Math.abs(pixelsPerMSY) < 1  ){
				animationTimer.stop();
				return;
			}
			if ( (nValY == 0 || nValY == getVerticalScrollBar().getMaximum()) && Math.abs(pixelsPerMSX) < 1  ){
				animationTimer.stop();
				return;
			}
			//Set new values
			if ( (scrollBarMask & DRAGGABLE_HORIZONTAL_SCROLL_BAR ) != 0 ){
				getHorizontalScrollBar().setValue(nValX);
			}
			if ( (scrollBarMask & DRAGGABLE_VERTICAL_SCROLL_BAR ) != 0 ){
				getVerticalScrollBar().setValue(nValY);
			}
		}
	}
	/**
	 * Utility to retrieve the Horizontal Scroll Bar.
	 * @return
	 */
	private JScrollBar getHorizontalScrollBar(){
		return scroller.getHorizontalScrollBar();
	}
	/**
	 * Utility to retrieve the Vertical Scroll Bar
	 * @return
	 */	
	private JScrollBar getVerticalScrollBar(){
		return scroller.getVerticalScrollBar();
	}
	/**
	 * 
	 * @param c
	 * @return
	 */
	private Component getParentScroller(Component c){
		Container parent = c.getParent();
		if ( parent != null && parent instanceof Component ){
			Component parentC = (Component)parent;
			if ( parentC instanceof JScrollPane ){
				return parentC;
			}else{
				return getParentScroller(parentC);
			}
		}
		return null;
	}
	/**
	 * Testing main method as an SSCCE
	 * @param args
	 */
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Drawer dr = new Drawer();
		JScrollPane pane = new JScrollPane(dr);
		DragScrollListener dl = new DragScrollListener(dr);
		dr.addMouseListener(dl);
		dr.addMouseMotionListener(dl);
		pane.setPreferredSize(new Dimension(300,300));
		frame.getContentPane().add(pane);
		frame.pack();
		frame.setVisible(true);
		pane.getHorizontalScrollBar().setValue(10);
	}
	/**
	 * Testing inner class that draws several squares of randomly selected colors.
	 * @author Greg Cope
	 *
	 */
	public static class Drawer extends JPanel{
		static final long serialVersionUID = 43214321L;
		int width = 10000;
		int height = 5000;
		Color[][] colors;
		/**
		 * Constructs the JPanel and random colors
		 */
		public Drawer(){
			super();
			setPreferredSize(new Dimension(width,height));
			colors = new Color[width/100][height/100];
			for ( int i = 0; i < colors.length; i++ ){
				for ( int j = 0; j < colors[i].length; j++ ){
					int r = (int)((255)*Math.random());
					int g = (int)((255)*Math.random());
					int b = (int)((255)*Math.random());
					colors[i][j] = new Color(r,g,b,150);
				}
			}
		}
		@Override 
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			for ( int i = 0; i < width; i+= 100){
				for ( int j = 0; j < height; j+=100 ){
					g.setColor( colors[i/100][j/100] );
					g.fillRect(i+5, j + 5, 95, 95);
				}
			}
		}
	}
	/**************************EVENTOS******************************************/
	/*UTILIZO*/
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Evento : mouseClicked");
		DZONAGENERAL dz=seleccionClick(e.getX(),e.getY());
		if(dz!=null){
			selectActual = dz;
			if(antereorActual!=selectActual){
				if(chkPosicion){
//					if(chkObstaculo.isSelected())
//					asignarPosicion(dz.getCORDENADAX()-1,dz.getCORDENADAY()-1,this.tamanio,
//			    						Constantes.hex2Rgb(dz.getCOLOR()),true);
			    	int punto = MatrizRutas.posicionMatrizRecorrido(dz.getCORDENADAX()-1, dz.getCORDENADAY()-1);
			    	System.out.print("\nClick:("+(dz.getCORDENADAX()-1)+","+(dz.getCORDENADAY()-1)+")");
			    	puntosExtremos_.add(punto);
				}else{
//					this.tooltip.pisoAlerta=Integer.parseInt(dz.getIDUBICACION().substring(13,16));
			    	cargarDatosPosicionPisos(dz,this.tooltip);
				}
			}
			antereorActual=selectActual;
		}
		
//		g.fillRect(dz.getCORDENADAY().intValue()*tamanio,dz.getCORDENADAX().intValue()*tamanio,tamanio, tamanio);
	}
	/*UTILIZO*/
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		/* SOBRESCRIBIR */
		/*
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
		}*/
	}
	
	/**
	 * Empty implementation
	 */
	public void mouseEntered(MouseEvent e){
//		System.out.println("El puntero está sobre el botón");
//		int x= e.getPoint().x;
//		int y= e.getPoint().y;
	}
	/**
	 * Empty implementation
	 */
	public void mouseExited(MouseEvent e){
//		System.out.println("El puntero ha salido del botón");
//		int x= e.getPoint().x;
//		int y= e.getPoint().y;
	}

	/**
	 * Mouse pressed implementation
	 */
	public void mousePressed(MouseEvent e){	
		if ( animationTimer != null && animationTimer.isRunning() ){
			animationTimer.stop();
		}
		draggableComponent.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		dragSpeeds.clear();
		lastDragPoint = e.getPoint();
	}
	/**
	 * Mouse released implementation. This determines if further animation
	 * is necessary and launches the appropriate times. 
	 */
	public void mouseReleased(MouseEvent e){
		draggableComponent.setCursor(defaultCursor);
		if ( scroller == null ){
			return;
		}
		//make sure the mouse ended in a dragging event
		long durationSinceLastDrag = System.currentTimeMillis() - lastDragTime;
		if ( durationSinceLastDrag > 20 ){
			return;
		}
		//get average speed for last few drags
		pixelsPerMSX = 0;
		pixelsPerMSY = 0;
		int j = 0;
		for ( int i = dragSpeeds.size() - 1; i >= 0 && i > dragSpeeds.size() - 6; i--, j++ ){
			pixelsPerMSX += dragSpeeds.get(i).x;
			pixelsPerMSY += dragSpeeds.get(i).y;
		}
		pixelsPerMSX /= -(double)j;
		pixelsPerMSY /= -(double)j;
		//start the timer
		if ( Math.abs(pixelsPerMSX) > 0 || Math.abs(pixelsPerMSY) > 0 ){
			animationTimer = new javax.swing.Timer(animationSpeed, new ScrollAnimator());
			animationTimer.start();
		}
	}
	public void mouseDragged(MouseEvent e){
		if ( scroller == null ){
			return;
		}
		Point p = e.getPoint();
		int diffx = p.x - lastDragPoint.x;
		int diffy = p.y - lastDragPoint.y;
		lastDragPoint = e.getPoint();
		//scroll the x axis
		if ( (scrollBarMask & DRAGGABLE_HORIZONTAL_SCROLL_BAR ) != 0 ){
			getHorizontalScrollBar().setValue( getHorizontalScrollBar().getValue() - diffx);
		}
		//the Scrolling affects mouse locations - offset the last drag point to compensate
		lastDragPoint.x = lastDragPoint.x - diffx;
		//scroll the y axis
		if ( (scrollBarMask & DRAGGABLE_VERTICAL_SCROLL_BAR ) != 0 ){
			getVerticalScrollBar().setValue( getVerticalScrollBar().getValue() - diffy);
		}
		//the Scrolling affects mouse locations - offset the last drag point to compensate
		lastDragPoint.y = lastDragPoint.y - diffy;
		//add a drag speed
		dragSpeeds.add( new Point2D.Double(
				(e.getPoint().x - lastDragPoint.x), 
				(e.getPoint().y - lastDragPoint.y) ) );
		lastDragTime = System.currentTimeMillis();
	}
	/**
	 * Empty
	 */
	public void mouseMoved(MouseEvent e){}
	/**
	 * Private inner class which accomplishes the animation. 

	 * @author Greg Cope
	 *
	 */
	
	public List<DZONAGENERAL> getListDzonaGeneral() {
		return listDzonaGeneral;
	}
	public void setListDzonaGeneral(List<DZONAGENERAL> listDzonaGeneral) {
		this.listDzonaGeneral = listDzonaGeneral;
	}
	/*MÉTODOS COMPLEMENTARIOS*/
	public void cargarDatosPosicionPisos(DZONAGENERAL dz,ConfigTooltip configuracion){
    	try {
    		List<DZONAGENERAL> listDZonaGeneralPos =(new DZONAGENERALDao()).getListaDZonaGeneralPosicion(1,dz);
    		configuracion.numPisos=listDZonaGeneralPos.size();
    		Point punto=MouseInfo.getPointerInfo().getLocation();
//	    	frmToltip = new FrmTooltip(Inicio.mainF,punto.x, punto.y,Constantes.hex2Rgb(dz.getCOLOR()),configuracion.alerta,
//	    			configuracion.timer,configuracion.tiempoCierre, configuracion.numPisos,configuracion.pisoAlerta);
	    	String cadena=FormatStyleText.salto(3)+FormatStyleText.tab(1)+
	    				Constantes.isnull(dz.getZONA(),"")+FormatStyleText.salto(1)+
	    				" Ubicación :"+Constantes.isnull(dz.getIDUBICACION(),"");
    		if(frmToltip==null){
	    		frmToltip = new FrmTooltipOverlay(Inicio.mainF,punto.x, punto.y,twidthOverlay,
	    				theightOverlay,cadena);
	    	}else{
	    		frmToltip.Closed();
	    		frmToltip.setCx(punto.x);
	    		frmToltip.setCy(punto.y);
	    		frmToltip.setContenido(cadena);
	    	}
	    	frmToltip.showOverlay();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }

}