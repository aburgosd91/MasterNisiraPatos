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

class PointEspecifico2{
	public double x;
	public double y;
	public double z;
	public Origen po;
	PointEspecifico2(){ 
		this.x=0; 
		this.y=0; 
		this.z=0;
		po= new Origen(CuboEspecifico2.puntosOrigen.get(0).origenX,CuboEspecifico2.puntosOrigen.get(0).origenY);
	}
	PointEspecifico2(double x,double y, double z, Origen pot){ 
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
class OrigenEspecifico2{

	public int origenX;
	public int origenY;
	OrigenEspecifico2(){ 
		this.origenX=0;
		this.origenY=0;
	}
	OrigenEspecifico2(int origenX,int origenY){ 

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

class FaceEspecifico2{
	PointEspecifico2 p1,p2,p3,p4;
	Polygon side= new Polygon();
	Origen punto1;
	FaceEspecifico2(){}
	
	FaceEspecifico2(PointEspecifico2 p1,PointEspecifico2 p2,PointEspecifico2 p3,PointEspecifico2 p4,Origen punto1){
		this.p1=p1;this.p2=p2;this.p3=p3;this.p4=p4;
		this.side.addPoint(p1.getXCoordinate(),p1.getYCoordinate());
		this.side.addPoint(p2.getXCoordinate(),p2.getYCoordinate());
		this.side.addPoint(p3.getXCoordinate(),p3.getYCoordinate());
		this.side.addPoint(p4.getXCoordinate(),p4.getYCoordinate());
		this.punto1=punto1;
	}
	
	public void drawFaceEspecifico2(Graphics g){ 
		g.fillPolygon(side);
		/*AGREGAR BORDES*/
		g.setColor(Color.BLACK);
		g.drawPolygon(side);
//		g.fillRect(p2.getYCoordinate(), p2.getXCoordinate(), Cubo.tamanio, Cubo.tamanio);
//		g.fillRect(p3.getYCoordinate(), p3.getXCoordinate(), Cubo.tamanio, Cubo.tamanio);
//		g.fillRect(p4.getYCoordinate(), p4.getXCoordinate(), Cubo.tamanio, Cubo.tamanio);
	}
	public boolean isVisible(){
		PointEspecifico2 aux1, aux2;
		aux1 = new PointEspecifico2(p2.x-p1.x, p2.y-p1.y, p2.z-p1.z,punto1); // p1->p2
		aux2 = new PointEspecifico2(p4.x-p1.x, p4.y-p1.y, p4.z-p1.z,punto1); // p1->p4
		if((aux1.x*aux2.y - aux1.y*aux2.x) > 0)
			return true;
		return false;
	}
}

public class CuboEspecifico2 extends Applet implements Runnable, MouseMotionListener{
	Thread luxury;
	/**************ELEMENTOS GENERICOS***********/
	static int numeroCubos=0;
	static ArrayList<PointEspecifico2[]> vertex;
	static ArrayList<Origen> puntosOrigen;
	static int tamanio;
	static int maxSize;
	/********************************************/
	static int xMouseP=0, yMouseP =0;
	int xAux , yAux ; 
	Image canvasAux;
	Graphics backBuffer;
	public void init(){
		/*********DEFINIR DATOS**********/
		vertex = new ArrayList<PointEspecifico2[]>();
		numeroCubos=3; // # CUBOS
		tamanio=50; // DIMENSIÓN DEL CUBO
		maxSize=500;
		puntosOrigen=new ArrayList<Origen>();
		Origen org = new Origen();
		org.origenX=(maxSize-100)/2;
		org.origenY=(maxSize-100)/2;
		puntosOrigen.add(org);
		org = new Origen();
		org.origenX=(maxSize-100)/2;
		org.origenY=2*tamanio+(((maxSize-100))/2);
		puntosOrigen.add(org);
		org = new Origen();
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
		PointEspecifico2[] v;
		for(int i=0;i<numeroCubos;i++){
			v= new PointEspecifico2[8];
			for(int j=0;j<v.length;j++){
				v[j] = new PointEspecifico2(coordX[j],coordY[j],coordZ[j],puntosOrigen.get(i));
			}
			vertex.add(v);
		}
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
		
		ArrayList<FaceEspecifico2[]> listFaceEspecifico2s = new ArrayList<>();
		FaceEspecifico2[] FaceEspecifico2s;
		backBuffer.clearRect(0,0,500,500);
		for(int j=0;j<numeroCubos;j++){
			FaceEspecifico2s = new FaceEspecifico2[6];
			for(int i=0; i<6; i++){
				backBuffer.setColor(colorRGB[i]);
				FaceEspecifico2s[i] = new FaceEspecifico2(vertex.get(j)[pts1[i]],vertex.get(j)[pts2[i]],vertex.get(j)[pts3[i]],vertex.get(j)[pts4[i]],puntosOrigen.get(j));
				if(FaceEspecifico2s[i].isVisible()){
					FaceEspecifico2s[i].drawFaceEspecifico2(backBuffer);
				}
			}
			listFaceEspecifico2s.add(FaceEspecifico2s);
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
	
	void rota(double angleTeta, double anglePhi, double anglePsi,PointEspecifico2[] vertice){
		double teta= Math.toRadians(angleTeta);
		double phi= Math.toRadians(anglePhi);
		double psi= Math.toRadians(anglePsi);
		PointEspecifico2 pAux = new PointEspecifico2();
		PointEspecifico2 pAux1 = new PointEspecifico2();
		PointEspecifico2 pAux2 = new PointEspecifico2();
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
		for(int i=0;i<CuboEspecifico2.vertex.size();i++){
			if(yMouseP > yAux){ 
				rota(2,0,0,CuboEspecifico2.vertex.get(i));
			}
			if(yMouseP < yAux){ 
				rota(-2,0,0,CuboEspecifico2.vertex.get(i));
			}
			if(xMouseP > xAux){ 
				rota(0,2,0,CuboEspecifico2.vertex.get(i));
			}
			if(xMouseP < xAux){ 
				rota(0,-2,0,CuboEspecifico2.vertex.get(i));
			}
			repaint();
			e.consume();
		}
	}
	
	public void mouseMoved( MouseEvent e ) { 
		
	}
	
} 