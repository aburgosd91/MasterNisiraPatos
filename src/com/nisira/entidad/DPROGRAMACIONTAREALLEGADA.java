package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Date;

@Tabla(nombre = "DPROGRAMACIONTAREALLEGADA")
public class DPROGRAMACIONTAREALLEGADA {
	@Columna
	private Integer IDEMPRESA;
	@Columna
	private Integer IDSUCURSAL;
	@Columna
	private String IDPROGRAMACIONTAREA;
	@Columna
	private Integer ITEM;
	@Columna
	private String IDPROGRAMACIONLLENADO;
	@Columna
	private Integer IDPROCESO;
	@Columna
	private Integer IDFORMA;
	@Columna
	private Integer IDGENERACION;
	@Columna
	private String IDREGLAS;
	@Columna
	private Date FECHACREACION;



	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDSUCURSAL(Integer IDSUCURSAL) {
		this.IDSUCURSAL = IDSUCURSAL;
	}

	public Integer getIDSUCURSAL() {
		return this.IDSUCURSAL;
	}

	public void setIDPROGRAMACIONTAREA(String IDPROGRAMACIONTAREA) {
		this.IDPROGRAMACIONTAREA = IDPROGRAMACIONTAREA;
	}

	public String getIDPROGRAMACIONTAREA() {
		return this.IDPROGRAMACIONTAREA;
	}

	public void setITEM(Integer ITEM) {
		this.ITEM = ITEM;
	}

	public Integer getITEM() {
		return this.ITEM;
	}

	public void setIDPROGRAMACIONLLENADO(String IDPROGRAMACIONLLENADO) {
		this.IDPROGRAMACIONLLENADO = IDPROGRAMACIONLLENADO;
	}

	public String getIDPROGRAMACIONLLENADO() {
		return this.IDPROGRAMACIONLLENADO;
	}

	public void setIDPROCESO(Integer IDPROCESO) {
		this.IDPROCESO = IDPROCESO;
	}

	public Integer getIDPROCESO() {
		return this.IDPROCESO;
	}

	public void setIDFORMA(Integer IDFORMA) {
		this.IDFORMA = IDFORMA;
	}

	public Integer getIDFORMA() {
		return this.IDFORMA;
	}

	public void setIDGENERACION(Integer IDGENERACION) {
		this.IDGENERACION = IDGENERACION;
	}

	public Integer getIDGENERACION() {
		return this.IDGENERACION;
	}

	public void setIDREGLAS(String IDREGLAS) {
		this.IDREGLAS = IDREGLAS;
	}

	public String getIDREGLAS() {
		return this.IDREGLAS;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}



	/* Sets & Gets FK*/

}