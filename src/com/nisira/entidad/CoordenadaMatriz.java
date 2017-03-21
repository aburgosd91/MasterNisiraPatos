package com.nisira.entidad;

public class CoordenadaMatriz implements Comparable<CoordenadaMatriz> {
	private int posicion;
	private int x;
	private int y;
	public CoordenadaMatriz(int posicion,int x, int y){
		this.posicion=posicion;
		this.x=x;
		this.y=y;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public int compareTo(CoordenadaMatriz o) {
		// TODO Auto-generated method stub
		return String.valueOf(this.x+""+this.y).compareTo(String.valueOf(o.x+""+o.y));
	}
	
}
