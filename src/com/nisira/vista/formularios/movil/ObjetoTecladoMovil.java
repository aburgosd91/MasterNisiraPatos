package com.nisira.vista.formularios.movil;

public class ObjetoTecladoMovil {
	private String tabla;/*tabla*/
	private String descripcion;/*nombre del atributo*/
	private String id;/*codigo id del atributo*/
	private String value;/*valor que se ingresa*/
	public ObjetoTecladoMovil(){
		this.setTabla("");
		this.setId("");
		this.setValue("");
	}
	public ObjetoTecladoMovil(String tabla,String descripcion,String id,String value){
		this.setTabla(tabla);
		this.setId(id);
		this.setValue(value);
	}
	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
