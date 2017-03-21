package com.nisira.vista.movil.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Face {
	Point p1,p2,p3,p4;
	Polygon side= new Polygon();
	Origen punto1;
	Face(){}
	
	Face(Point p1,Point p2,Point p3,Point p4,Origen punto1){
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
