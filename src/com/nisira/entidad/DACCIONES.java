package com.nisira.entidad;

import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "DACCIONES")
public class DACCIONES {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDACCION;
	@ClavePrimaria
	@Columna
	private Integer IDACTIVIDADES;
	@Columna
	private Integer DATOS;
	@Columna
	private Integer ORDEN;
	@Columna
	private String METHODAUT;
	@Columna
	private String METHODMAN;
	@Columna
	private Date FECHACREACION;


	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDACCION(Integer IDACCION) {
		this.IDACCION = IDACCION;
	}

	public Integer getIDACCION() {
		return this.IDACCION;
	}

	public void setIDACTIVIDADES(Integer IDACTIVIDADES) {
		this.IDACTIVIDADES = IDACTIVIDADES;
	}

	public Integer getIDACTIVIDADES() {
		return this.IDACTIVIDADES;
	}

	public void setDATOS(Integer DATOS) {
		this.DATOS = DATOS;
	}

	public Integer getDATOS() {
		return this.DATOS;
	}

	public void setORDEN(Integer ORDEN) {
		this.ORDEN = ORDEN;
	}

	public Integer getORDEN() {
		return this.ORDEN;
	}

	public void setMETHODAUT(String METHODAUT) {
		this.METHODAUT = METHODAUT;
	}

	public String getMETHODAUT() {
		return this.METHODAUT;
	}
	public void setMETHODMAN(String METHODMAN) {
		this.METHODMAN = METHODMAN;
	}

	public String getMETHODMAN() {
		return this.METHODMAN;
	}

	public Date getFECHACREACION() {
		return FECHACREACION;
	}

	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDACCION + ", " + IDACTIVIDADES + ", " + DATOS + ", " + ORDEN + ", " + (METHODAUT==null?"Null":METHODAUT)
				+ ", " + (METHODMAN==null? "Null":METHODMAN) + ", " + FECHACREACION + "]";
	}

	/* Sets & Gets FK*/

}