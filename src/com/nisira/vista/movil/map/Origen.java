package com.nisira.vista.movil.map;

public class Origen {
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
