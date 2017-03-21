package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "ClieProv")
public class ClieProv {
	@ClavePrimaria
	@Columna
	private String IdClieprov;
	@Columna
	private String RazonSocial;
	@Columna
	private String Direccion;
	@Columna
	private String RUC;
	@Columna
	private Integer es_cliente;
	@Columna
	private Integer es_proveedor;
	@Columna
	private Integer agente_retencion;
	@Columna
	private Integer agente_percepcion;
	@Columna
	private Integer buen_contribuyente;



	/* Sets & Gets */
	public void setIdClieprov(String IdClieprov) {
		this.IdClieprov = IdClieprov;
	}

	public String getIdClieprov() {
		return this.IdClieprov;
	}

	public void setRazonSocial(String RazonSocial) {
		this.RazonSocial = RazonSocial;
	}

	public String getRazonSocial() {
		return this.RazonSocial;
	}

	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}

	public String getDireccion() {
		return this.Direccion;
	}

	public void setRUC(String RUC) {
		this.RUC = RUC;
	}

	public String getRUC() {
		return this.RUC;
	}

	public Integer getEs_cliente() {
		return es_cliente;
	}

	public void setEs_cliente(Integer es_cliente) {
		this.es_cliente = es_cliente;
	}

	public Integer getEs_proveedor() {
		return es_proveedor;
	}

	public void setEs_proveedor(Integer es_proveedor) {
		this.es_proveedor = es_proveedor;
	}

	public Integer getAgente_retencion() {
		return agente_retencion;
	}

	public void setAgente_retencion(Integer agente_retencion) {
		this.agente_retencion = agente_retencion;
	}

	public Integer getAgente_percepcion() {
		return agente_percepcion;
	}

	public void setAgente_percepcion(Integer agente_percepcion) {
		this.agente_percepcion = agente_percepcion;
	}

	public Integer getBuen_contribuyente() {
		return buen_contribuyente;
	}

	public void setBuen_contribuyente(Integer buen_contribuyente) {
		this.buen_contribuyente = buen_contribuyente;
	}

	



	/* Sets & Gets FK*/

}