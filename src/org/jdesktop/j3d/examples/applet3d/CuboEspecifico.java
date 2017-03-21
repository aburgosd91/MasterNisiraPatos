package org.jdesktop.j3d.examples.applet3d;

/**
*
* @author alex4024
*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.awt.Polygon;

class PointEspecifico{
	public double x;
	public double y;
	public double z;
	public int origenX;
	public int origenY;
	PointEspecifico(){ 
		this.x=0; 
		this.y=0; 
		this.z=0;
		this.origenX=CuboEspecifico.originX;
		this.origenY=CuboEspecifico.originY;
	}
	PointEspecifico(double x,double y, double z, int origenX, int origenY){ 
		this.x=x; 
		this.y=y; 
		this.z=z;
		this.origenX=origenX;
		this.origenY=origenY;
	}
	int getXCoordinate(){
		return this.origenX +(int)this.x;
	}
	
	int getYCoordinate(){
		return this.origenY - (int)this.y;
	}
	int getZCoordinate(){
		return 0;
	} 
}

class FaceEspecifico{
	PointEspecifico p1,p2,p3,p4;
	Polygon side= new Polygon();
	
	FaceEspecifico(){}
	
	FaceEspecifico(PointEspecifico p1,PointEspecifico p2,PointEspecifico p3,PointEspecifico p4){
		this.p1=p1;this.p2=p2;this.p3=p3;this.p4=p4;
		this.side.addPoint(p1.getXCoordinate(),p1.getYCoordinate());
		this.side.addPoint(p2.getXCoordinate(),p2.getYCoordinate());
		this.side.addPoint(p3.getXCoordinate(),p3.getYCoordinate());
		this.side.addPoint(p4.getXCoordinate(),p4.getYCoordinate());
	}
	
	public void drawFace(Graphics g){ 
		g.fillPolygon(side); 
	}
	public boolean isVisible(){
		PointEspecifico aux1, aux2;
		aux1 = new PointEspecifico(p2.x-p1.x, p2.y-p1.y, p2.z-p1.z,CuboEspecifico.originX,CuboEspecifico.originY); // p1->p2
		aux2 = new PointEspecifico(p4.x-p1.x, p4.y-p1.y, p4.z-p1.z,CuboEspecifico.originX2,CuboEspecifico.originY2); // p1->p4
		if((aux1.x*aux2.y - aux1.y*aux2.x) > 0)
			return true;
		return false;
	}
}

public class CuboEspecifico extends Applet implements Runnable, MouseMotionListener{
	Thread luxury;
	/**/
	
	static PointEspecifico[] vertex1 = new PointEspecifico[8];
	static PointEspecifico[] vertex2 = new PointEspecifico[8];
	static int maxSize =300; 
	static int xMouseP=0, yMouseP =0;
	int xAux , yAux ; 
	int module = 50;
	static int originX = maxSize/2;
	static int originY = maxSize/2;
	
	static int originX2 = maxSize/2;
	static int originY2 = 100+((maxSize)/2);
	Image canvasAux;
	Graphics backBuffer;
	public void init(){
		setSize(maxSize,maxSize);
		setBackground( new Color(0.2f,0.6f,0.1f,1.0f) );
		addMouseMotionListener(this);
		int[] coordX = new int[]{-module,module,module,-module,-module,module,module,-module};
		int[] coordY = new int[]{-module,-module,module,module,-module,-module,module,module};
		int[] coordZ = new int[]{module,module,module,module,-module,-module,-module,-module};
		
		canvasAux = createImage(500,500);
		backBuffer = canvasAux.getGraphics();
		for(int i =0; i<vertex1.length; i++){
			vertex1[i] = new PointEspecifico(coordX[i],coordY[i],coordZ[i],CuboEspecifico.originX,CuboEspecifico.originY);
		}
		
		for(int i =0; i<vertex2.length; i++){
			vertex2[i] = new PointEspecifico(coordX[i],coordY[i],coordZ[i],CuboEspecifico.originX2,CuboEspecifico.originY2);
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
		
		
		int[] pts12 = new int[]{0,1,5,0,0,3};
		int[] pts22 = new int[]{1,5,4,3,4,2};
		int[] pts32 = new int[]{2,6,7,7,5,6};
		int[] pts42 = new int[]{3,2,6,4,1,7};
		
		Color[] colorRGB = new Color[]{ Color.white, Color.blue,Color.orange,Color.pink,Color.red, Color.yellow};
		FaceEspecifico[] faces = new FaceEspecifico[6];
		FaceEspecifico[] faces2 = new FaceEspecifico[6];
		backBuffer.clearRect(0,0,500,500);
		for(int i=0; i<6; i++){
			backBuffer.setColor(colorRGB[i]);
			faces[i] = new FaceEspecifico(vertex1[pts1[i]],vertex1[pts2[i]],vertex1[pts3[i]],vertex1[pts4[i]]);
			if(faces[i].isVisible()){
				faces[i].drawFace(backBuffer);
			}
			/*CuboEspecifico 2*/
			faces2[i] = new FaceEspecifico(vertex1[pts1[i]],vertex1[pts2[i]],vertex1[pts3[i]],vertex1[pts4[i]]);
			if(faces2[i].isVisible()){
				faces2[i].drawFace(backBuffer);
			}
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
	
	void rota(double angleTeta, double anglePhi, double anglePsi,PointEspecifico[] vertice){
		double teta= Math.toRadians(angleTeta);
		double phi= Math.toRadians(anglePhi);
		double psi= Math.toRadians(anglePsi);
		PointEspecifico pAux = new PointEspecifico();
		PointEspecifico pAux1 = new PointEspecifico();
		PointEspecifico pAux2 = new PointEspecifico();
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
		if(yMouseP > yAux){ 
			rota(2,0,0,vertex1);
			rota(2,0,0,vertex2);
		}
		if(yMouseP < yAux){ 
			rota(-2,0,0,vertex1);
			rota(-2,0,0,vertex2); 
		}
		if(xMouseP > xAux){ 
			rota(0,2,0,vertex1);
			rota(0,2,0,vertex2); 
		}
		if(xMouseP < xAux){ 
			rota(0,-2,0,vertex1); 
			rota(0,-2,0,vertex2); 
		}
		repaint();
		e.consume();
	}
	
	public void mouseMoved( MouseEvent e ) { 
		
	}
	
} 