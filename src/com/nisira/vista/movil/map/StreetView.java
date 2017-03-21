package com.nisira.vista.movil.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.nisira.utils.nisiracore.Constantes;
import com.nisira.vista.formularios.FrmSysZona;
import com.nisira.vista.formularios.FrmSysZona;

public class StreetView extends JPanel implements Runnable, MouseMotionListener{
	Thread luxury;
	/**************ELEMENTOS GENERICOS***********/
	ArrayList<Point[]> vertex;
	ArrayList<Origen> puntosOrigen;
	int tamanio;
	int maxSize;
	int origenCX;
	int origenCY;
	private int operacion;
	private int cuboAlert;
	private Color alertCubo;
	private List<Integer> ocupados;
	private Image iconoOcupado;
	private Image iconoDejar;
	/********************************************/
	int xMouseP=0, yMouseP =0;
	int xAux , yAux ; 
	int widthPanel;
	int heightPanel;
//	Image canvasAux;
//	Graphics backBuffer;
	/*************************MÉTODOS**********************/
	public ArrayList<Origen> getPuntosOrigen(){
		return puntosOrigen;
	}
	public void setPuntosOrigen(ArrayList<Origen> puntosOrigen_){
		this.puntosOrigen=puntosOrigen_;
	}
	public ArrayList<Point[]> getVertex(){
		return vertex;
	}
	public void setVertex(ArrayList<Point[]> vertex_){
		this.vertex=vertex_;
	}
	/********************************************************/
	public StreetView(int width,int height){
		/*********DEFINIR DATOS**********/
		widthPanel=width;
		heightPanel=height;
		setOperacion(0);
		setBackground(Constantes.hex2Rgb("#B9B9B9"));
		vertex = new ArrayList<Point[]>();
		tamanio=80; // DIMENSIÓN DEL CUBO
		maxSize=500;
		origenCX=80;
		origenCY=80;
		setCuboAlert(1);
		setAlertCubo(Color.green);
		puntosOrigen=new ArrayList<Origen>();
		setOcupados(new ArrayList<Integer>());
		getOcupados().add(0);
		getOcupados().add(1);
		getOcupados().add(2);
		getOcupados().add(5);
		getOcupados().add(8);
		setIconoOcupado(new ImageIcon(
				new ImageIcon(FrmSysZona.class.getResource("/resources/montacarga/cuboOcupado.png")).getImage()
				.getScaledInstance(tamanio, tamanio, java.awt.Image.SCALE_DEFAULT)).getImage());
		setIconoDejar(new ImageIcon(
				new ImageIcon(FrmSysZona.class.getResource("/resources/montacarga/cuboDejar.png")).getImage()
				.getScaledInstance(tamanio, tamanio, java.awt.Image.SCALE_DEFAULT)).getImage());
		/********************************TORRE 1***********************************/
		Origen org = new Origen();
		org.origenX=origenCX;
		org.origenY=origenCY;
		puntosOrigen.add(org);
		org = new Origen();
		org.origenX=origenCX;
		org.origenY=3*origenCY;
		puntosOrigen.add(org);
		org = new Origen();
		org.origenX=origenCX;
		org.origenY=5*origenCY;
		puntosOrigen.add(org);
		/******************************** TORRE 2***********************************/
		org = new Origen();
		org.origenX=3*origenCX;
		org.origenY=origenCY;
		puntosOrigen.add(org);
		org = new Origen();
		org.origenX=3*origenCX;
		org.origenY=3*origenCY;
		puntosOrigen.add(org);
		org = new Origen();
		org.origenX=3*origenCX;
		org.origenY=5*origenCY;
		puntosOrigen.add(org);
		/******************************** TORRE 3***********************************/
		org = new Origen();
		org.origenX=5*origenCX;
		org.origenY=origenCY;
		puntosOrigen.add(org);
		org = new Origen();
		org.origenX=5*origenCX;
		org.origenY=3*origenCY;
		puntosOrigen.add(org);
		org = new Origen();
		org.origenX=5*origenCX;
		org.origenY=5*origenCY;
		puntosOrigen.add(org);
		/**************************CONFIGURACIÓN GENERICO************************************/
		setSize(width,height);
		//setBackground( new Color(0.2f,0.6f,0.1f,1.0f) );
//		setBackground( new Color(172,172,172));
		addMouseMotionListener(this);
		int[] coordX = new int[]{-tamanio,tamanio,tamanio,-tamanio,-tamanio,tamanio,tamanio,-tamanio};
		int[] coordY = new int[]{-tamanio,-tamanio,tamanio,tamanio,-tamanio,-tamanio,tamanio,tamanio};
		int[] coordZ = new int[]{tamanio,tamanio,tamanio,tamanio,-tamanio,-tamanio,-tamanio,-tamanio};
//		canvasAux = createImage(734, 500);
//		backBuffer = canvasAux.getGraphics();
		/******************************************************************************************************/
		Point[] v;
		for(int i=0;i<puntosOrigen.size();i++){
			v= new Point[8];
			for(int j=0;j<v.length;j++){
				v[j] = new Point(coordX[j],coordY[j],coordZ[j],puntosOrigen.get(i));
			}
			vertex.add(v);
		}
	}
	
	public void paint(Graphics g){
		int[] pts1 = new int[]{0,1,5,0,0,3};
		int[] pts2 = new int[]{1,5,4,3,4,2};
		int[] pts3 = new int[]{2,6,7,7,5,6};
		int[] pts4 = new int[]{3,2,6,4,1,7};
//		Color[] colorRGB = new Color[]{ Color.white, Color.blue,Color.orange,Color.pink,Color.red, Color.yellow};
		/*MOV. HORARIO
		 * (1)white
		 * (2)blue
		 * (3)orange
		 * (4)pink
		 * */
		Color[] colorRGB = new Color[]{ Color.red, Color.orange,Color.red,Color.orange,Color.red/*cabecera*/, Color.yellow/*cabecera*/};
		ArrayList<Face[]> listFace = new ArrayList<>();
		Face[] Face;
		g.clearRect(0,0,widthPanel, heightPanel);
		for(int j=0;j<puntosOrigen.size();j++){
			Face = new Face[6];
			for(int i=0; i<6; i++){
				g.setColor(colorRGB[i]);
				Face[i] = new Face(vertex.get(j)[pts1[i]],vertex.get(j)[pts2[i]],vertex.get(j)[pts3[i]],vertex.get(j)[pts4[i]],puntosOrigen.get(j));
				if(Face[i].isVisible()){
					Face[i].drawFace(g);
				}
			}
			listFace.add(Face);
		}
		/*POSICIONES OCUPADAS*/
//		for(int i=0;i<ocupados.size();i++){
//			for(int j=0;j<puntosOrigen.size();j++){
//				if(ocupados.get(i)==j){
//					Face=listFace.get(j);
//					g.drawImage(iconoOcupado,puntosOrigen.get(j).origenX*tamanio,puntosOrigen.get(j).origenY*tamanio,tamanio,tamanio,null);
//					for(int k=0;k<6;k++){
//						if(Face[k].isVisible()){
//							Face[k].drawFace(g);
//						}
//					}
//					listFace.set(j, Face);
//				}
//			}
//		}
		switch (this.operacion) {
			case 1://PITAR A CUBO
				for(int i=0;i<puntosOrigen.size();i++){
					if(i==getCuboAlert()){
						Face=listFace.get(i);
						g.setColor(alertCubo);
//						g.drawImage(iconoDejar,puntosOrigen.get(i).origenX*tamanio,puntosOrigen.get(i).origenY*tamanio,tamanio,tamanio,null);
						for(int k=0;k<6;k++){
							if(Face[k].isVisible()){
								Face[k].drawFace(g);
							}
						}
						listFace.set(i, Face);
					}
				}
				break;
			default:
				break;
		}
//		g.drawImage(canvasAux,0,0,this);
//		g.setColor(Color.black);
//		g.drawString(" Coordenadas: ", 30,30);
//		g.drawString(" X= " + xMouseP, 30,50);
//		g.drawString(" Y= " + yMouseP, 30,65);
//		setBackground(Constantes.hex2Rgb("#B9B9B9"));
		setSize(widthPanel, heightPanel);
		return;
	}
	
	public void update(Graphics g){ 
		paint(g); 
	}
	
	public void destroy(){
		try {
			Thread.sleep(1500);
		}catch (InterruptedException e) {
			System.out.println("Exception in sleep");
		}
	}
	
	void rota(double angleTeta, double anglePhi, double anglePsi,Point[] vertice){
		double teta= Math.toRadians(angleTeta);
		double phi= Math.toRadians(anglePhi);
		double psi= Math.toRadians(anglePsi);
		Point pAux = new Point();
		Point pAux1 = new Point();
		Point pAux2 = new Point();
		for(int i =0; i<8; i++){
			pAux1.x = vertice[i].x;
			pAux1.y= vertice[i].y * Math.cos(teta) + vertice[i].z * (-Math.sin(teta));
			pAux1.z = vertice[i].y * Math.sin(teta) + vertice[i].z * Math.cos(teta);
			
			pAux2.x = pAux1.x * Math.cos(phi) + pAux1.z * Math.sin(phi);
			pAux2.y = pAux1.y;
			pAux2.z = pAux1.x * (-Math.sin(phi)) + pAux1.z * Math.cos(phi);
			
			pAux.x= pAux2.x * Math.cos(psi) + pAux2.y * (-Math.sin(psi));
			pAux.y = pAux2.x * Math.sin(psi) + pAux2.y * Math.cos(psi);
			pAux.z= pAux2.z;
			
			vertice[i].x = pAux.x;
			vertice[i].y = pAux.y;
			vertice[i].z = pAux.z;
		}
	}
	
	public void mouseDragged( MouseEvent e ){
		xAux = xMouseP;
		yAux = yMouseP;
		xMouseP = e.getX();
		yMouseP = e.getY();
		
		for(int i=0;i<vertex.size();i++){
//			if(yMouseP > yAux){ 
//				rota(2,0,0,vertex.get(i));
//			}
//			if(yMouseP < yAux){ 
//				rota(-2,0,0,vertex.get(i));
//			}
			if(xMouseP > xAux){ 
				rota(0,2,0,vertex.get(i));
			}
			if(xMouseP < xAux){ 
				rota(0,-2,0,vertex.get(i));
			}
			repaint();
			e.consume();
		}
	}
	
	public void mouseMoved( MouseEvent e ) { 
		
	}

	public int getOperacion() {
		return operacion;
	}
	public void setOperacion(int operacion) {
		this.operacion = operacion;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public int getCuboAlert() {
		return cuboAlert;
	}
	public void setCuboAlert(int cuboAlert) {
		this.cuboAlert = cuboAlert;
	}
	public Color getAlertCubo() {
		return alertCubo;
	}
	public void setAlertCubo(Color alertCubo) {
		this.alertCubo = alertCubo;
	}
	public List<Integer> getOcupados() {
		return ocupados;
	}
	public void setOcupados(List<Integer> ocupados) {
		this.ocupados = ocupados;
	}
	public Image getIconoOcupado() {
		return iconoOcupado;
	}
	public void setIconoOcupado(Image iconoOcupado) {
		this.iconoOcupado = iconoOcupado;
	}
	public Image getIconoDejar() {
		return iconoDejar;
	}
	public void setIconoDejar(Image iconoDejar) {
		this.iconoDejar = iconoDejar;
	}
	
}

