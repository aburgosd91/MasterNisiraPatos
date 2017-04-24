package com.nisira.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("barcode")
public class BarcodeXML  implements Serializable{
	private String inicio;/*Caracter Inicio de Lectura por codigo*/
	private String fin;/*Caracter Fin de Lectura por codigo*/
	private String descripcion;
	private String numini;
	private int total;/**/
//	private int cantidad;/**/
	private List<Digitos> digitos;
	public BarcodeXML(){
		inicio="@~";
		fin="~@";
		total=0;
		digitos=new ArrayList<Digitos>();
	}
	
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNumini() {
		return numini;
	}

	public void setNumini(String numini) {
		this.numini = numini;
	}

	public List<Digitos> getDigitos() {
		return digitos;
	}

	public void setDigitos(List<Digitos> digitos) {
		this.digitos = digitos;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
//	public int getCantidad() {
//		return cantidad;
//	}
//	public void setCantidad(int cantidad) {
//		this.cantidad = cantidad;
//	}
	public List<Digitos> getDig() {
		return digitos;
	}
	public void setDig(List<Digitos> dig) {
		this.digitos = dig;
	}
	public void agregarDigito(String parametro,int cantidad){
		digitos.add(new Digitos(cantidad,parametro));
	}
	@XStreamAlias("dbarcode")
	public class Digitos{
		int numdigito;
		String parametro;
		public Digitos(){
			numdigito=0;
			parametro="";
		}
		public Digitos(int num,String para){
			numdigito=num;
			parametro=para;
		}
	}
}

