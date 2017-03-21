package com.nisira.vista.movil.map;

public class Point {
	public double x;
	public double y;
	public double z;
	public Origen po;
	Point(){ 
		this.x=0; 
		this.y=0; 
		this.z=0;
//		po= new Origen((new Cubo()).getPuntosOrigen().get(0).origenX,(new Cubo()).getPuntosOrigen().get(0).origenY);
	}
	Point(double x,double y, double z, Origen pot){ 
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
