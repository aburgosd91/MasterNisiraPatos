package com.nisira.entidad;

public class FilaSyncro {
	private boolean sincro;
	private String descripcion;
	private int pendientes;
	private int afectados;
	private int tabla;
	private String tipo;
	public FilaSyncro() {

	}
	public boolean isSincro() {
		return sincro;
	}
	public void setSincro(boolean sincro) {
		this.sincro = sincro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPendientes() {
		return pendientes;
	}
	public void setPendientes(int pendientes) {
		this.pendientes = pendientes;
	}
	public int getAfectados() {
		return afectados;
	}
	public void setAfectados(int afectados) {
		this.afectados = afectados;
	}
	
	public int getTabla() {
		return tabla;
	}
	public void setTabla(int tabla) {
		this.tabla = tabla;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString(){
		return String.valueOf(isSincro())+" "+getDescripcion()+" "+String.valueOf(getPendientes())+" "+String.valueOf(getAfectados()) ;
		
	}
}
