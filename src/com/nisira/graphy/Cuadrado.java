package com.nisira.graphy;

public class Cuadrado {
	private int x;
	private int y;
	private int height;
	private int width;
	public Cuadrado(){
		this.setX(0);
		this.setY(0);
		this.setHeight(0);
		this.setWidth(0);
	}
	public Cuadrado(int x,int y,int height,int width){
		this.setX(x);
		this.setY(y);
		this.setHeight(height);
		this.setWidth(width);
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
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
}
