package org.jdesktop.j3d.examples.applet3d;

/**
*
* @author alex4024
*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.util.ArrayList;
import com.nisira.utils.nisiracore.Constantes;

class Point{
	public double x;
	public double y;
	public double z;
	public OrigenEspecifico2 po;
	Point(){ 
		this.x=0; 
		this.y=0; 
		this.z=0;
		po= new OrigenEspecifico2(Cubo.puntosOrigen.get(0).origenX,Cubo.puntosOrigen.get(0).origenY);
	}
	Point(double x,double y, double z, OrigenEspecifico2 pot){ 
		this.x=x; 
		this.y=y; 
		this.z=z;
		this.po=pot;
	}
	int getXCoordinate(){
		return this.po.origenX +(int)this.x;
	}
	
	int getYCoordinate(){
		return this.po.origenY - (int)this.y;
	}
	int getZCoordinate(){
		return 0;
	} 
}
class Origen{

	public int origenX;
	public int origenY;
	Origen(){ 
		this.origenX=0;
		this.origenY=0;
	}
	Origen(int origenX,int origenY){ 

		this.origenX=origenX;
		this.origenY=origenY;
	}
	int getX(){
		return this.origenX;
	}
	
	int getY(){
		return this.origenY;
	}
}

class Face{
	Point p1,p2,p3,p4;
	Polygon side= new Polygon();
	OrigenEspecifico2 punto1;
	Face(){}
	
	Face(Point p1,Point p2,Point p3,Point p4,OrigenEspecifico2 punto1){
		this.p1=p1;this.p2=p2;this.p3=p3;this.p4=p4;
		this.side.addPoint(p1.getXCoordinate(),p1.getYCoordinate());
		this.side.addPoint(p2.getXCoordinate(),p2.getYCoordinate());
		this.side.addPoint(p3.getXCoordinate(),p3.getYCoordinate());
		this.side.addPoint(p4.getXCoordinate(),p4.getYCoordinate());
		this.punto1=punto1;
	}
	
	public void drawFace(Graphics g){
		
		g.fillPolygon(side);
		/*AGREGAR BORDES*/
		g.setColor(Color.BLACK);
		g.drawPolygon(side);
		
//		g.fillRect(p2.getYCoordinate(), p2.getXCoordinate(), Cubo.tamanio, Cubo.tamanio);
//		g.fillRect(p3.getYCoordinate(), p3.getXCoordinate(), Cubo.tamanio, Cubo.tamanio);
//		g.fillRect(p4.getYCoordinate(), p4.getXCoordinate(), Cubo.tamanio, Cubo.tamanio);
	}
	public boolean isVisible(){
		Point aux1, aux2;
		aux1 = new Point(p2.x-p1.x, p2.y-p1.y, p2.z-p1.z,punto1); // p1->p2
		aux2 = new Point(p4.x-p1.x, p4.y-p1.y, p4.z-p1.z,punto1); // p1->p4
		if((aux1.x*aux2.y - aux1.y*aux2.x) > 0)
			return true;
		return false;
	}
}

public class Cubo extends Applet implements Runnable, MouseMotionListener{
	Thread luxury;
	/**************ELEMENTOS GENERICOS***********/
	static int numeroCubos=0;
	static ArrayList<Point[]> vertex;
	static ArrayList<OrigenEspecifico2> puntosOrigen;
	static int tamanio;
	static int maxSize;
	static int alertaPiso;
	/********************************************/
	static int xMouseP=0, yMouseP =0;
	int xAux , yAux ; 
	Image canvasAux;
	Graphics backBuffer;
	public void init(){
		/*********DEFINIR DATOS**********/
		vertex = new ArrayList<Point[]>();
		numeroCubos=3; // # CUBOS
		tamanio=50; // DIMENSIÓN DEL CUBO
		maxSize=500;
		alertaPiso=1;
		puntosOrigen=new ArrayList<OrigenEspecifico2>();
		OrigenEspecifico2 org = new OrigenEspecifico2();
		org.origenX=(maxSize-100)/2;
		org.origenY=(maxSize-100)/2;
		puntosOrigen.add(org);
		org = new OrigenEspecifico2();
		org.origenX=(maxSize-100)/2;
		org.origenY=2*tamanio+(((maxSize-100))/2);
		puntosOrigen.add(org);
		org = new OrigenEspecifico2();
		org.origenX=(maxSize-100)/2;
		org.origenY=2*2*tamanio+(((maxSize-100))/2);
		puntosOrigen.add(org);
		/**************************CONFIGURACIÓN GENERICO************************************/
		setSize(maxSize,maxSize);
		//setBackground( new Color(0.2f,0.6f,0.1f,1.0f) );
		setBackground( new Color(172,172,172));
		addMouseMotionListener(this);
		int[] coordX = new int[]{-tamanio,tamanio,tamanio,-tamanio,-tamanio,tamanio,tamanio,-tamanio};
		int[] coordY = new int[]{-tamanio,-tamanio,tamanio,tamanio,-tamanio,-tamanio,tamanio,tamanio};
		int[] coordZ = new int[]{tamanio,tamanio,tamanio,tamanio,-tamanio,-tamanio,-tamanio,-tamanio};
		canvasAux = createImage(500,500);
		backBuffer = canvasAux.getGraphics();
		/******************************************************************************************************/
		Point[] v;
		for(int i=0;i<numeroCubos;i++){
			v= new Point[8];
			for(int j=0;j<v.length;j++){
				v[j] = new Point(coordX[j],coordY[j],coordZ[j],puntosOrigen.get(i));
			}
			vertex.add(v);
		}
		AlertaMovimiento ej = new AlertaMovimiento();
		Thread hilo = new Thread(ej,"AlertaMovimiento");
		hilo.start();
		Constantes.log.info(hilo.getName());
	}
	
	public void start(){
		try { 
			luxury = new Thread(this); 
			luxury.start(); 
		}catch (Exception e){}
	}
	
	public void run() {}
	
	public void stop(){}
	
	public void paint(Graphics g){
		int[] pts1 = new int[]{0,1,5,0,0,3};
		int[] pts2 = new int[]{1,5,4,3,4,2};
		int[] pts3 = new int[]{2,6,7,7,5,6};
		int[] pts4 = new int[]{3,2,6,4,1,7};
		
		Color[] colorRGB = new Color[]{ Color.white, Color.blue,Color.orange,Color.pink,Color.red, Color.yellow};
		
		ArrayList<Face[]> listFaces = new ArrayList<>();
		Face[] faces;
		backBuffer.clearRect(0,0,500,500);
		for(int j=0;j<numeroCubos;j++){
			faces = new Face[6];
			
			for(int i=0; i<6; i++){
//		        Font fuente=new Font("Monospaced", Font.BOLD, 36);
//		        backBuffer.setFont(fuente);
//				backBuffer.setColor(Color.BLACK);
//				backBuffer.drawString("P0"+j,puntosOrigen.get(j).origenX,puntosOrigen.get(j).origenY);
				backBuffer.setColor(colorRGB[i]);
				faces[i] = new Face(vertex.get(j)[pts1[i]],vertex.get(j)[pts2[i]],vertex.get(j)[pts3[i]],vertex.get(j)[pts4[i]],puntosOrigen.get(j));
				if(faces[i].isVisible()){
					faces[i].drawFace(backBuffer);
				}
			}
			listFaces.add(faces);
		}
		g.drawImage(canvasAux,0,0,this);
		g.drawString(" Coordenadas: ", 30,30);
		g.drawString(" X= " + xMouseP, 30,50);
		g.drawString(" Y= " + yMouseP, 30,65);
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
		for(int i=0;i<Cubo.vertex.size();i++){
//			if(alertaPiso==i){
				if(yMouseP > yAux){ 
					rota(2,0,0,Cubo.vertex.get(i));
				}
				if(yMouseP < yAux){ 
					rota(-2,0,0,Cubo.vertex.get(i));
				}
				if(xMouseP > xAux){ 
					rota(0,2,0,Cubo.vertex.get(i));
				}
				if(xMouseP < xAux){ 
					rota(0,-2,0,Cubo.vertex.get(i));
				}
				repaint();
				e.consume();
//			}
		}
	}
	
	public void alertaMovimiento(){
		for(int i=0;i<Cubo.vertex.size();i++){
			if(alertaPiso==i){
//				rota(2,0,0,Cubo.vertex.get(i));
//				rota(-2,0,0,Cubo.vertex.get(i));
				rota(0,2,0,Cubo.vertex.get(i));
//				rota(0,-2,0,Cubo.vertex.get(i));
				repaint();
			}
		}
	}
	
	public void mouseMoved( MouseEvent e ) { 
		
	}
	
	class AlertaMovimiento implements Runnable{
    	@Override
    	public void run(){
    		while(true){
    			alertaMovimiento();
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
    	}
    }
} 