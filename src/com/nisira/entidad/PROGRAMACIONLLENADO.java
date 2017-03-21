package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.io.Serializable;
import java.util.Date;

@Tabla(nombre = "PROGRAMACIONLLENADO")
public class PROGRAMACIONLLENADO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5174824158220904985L;
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
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
	private Date FINICIO;
	@Columna
	private Date FFIN;
	@Columna
	private Integer ESTADO;
	@Columna
	private String USRCREACION;
	@Columna
	private Date FECHACREACION;
	@Columna
	private String DESCRIPCION;



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

	public void setFINICIO(Date FINICIO) {
		this.FINICIO = FINICIO;
	}

	public Date getFINICIO() {
		return this.FINICIO;
	}

	public void setFFIN(Date FFIN) {
		this.FFIN = FFIN;
	}

	public Date getFFIN() {
		return this.FFIN;
	}

	public void setESTADO(Integer ESTADO) {
		this.ESTADO = ESTADO;
	}

	public Integer getESTADO() {
		return this.ESTADO;
	}

	public void setUSRCREACION(String USRCREACION) {
		this.USRCREACION = USRCREACION;
	}

	public String getUSRCREACION() {
		return this.USRCREACION;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	public void setDESCRIPCION(String DESCRIPCION) {
		this.DESCRIPCION = DESCRIPCION;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDPROGRAMACIONLLENADO + ", " + (IDPROCESO==null?"Null":IDPROCESO) + ", " + (IDFORMA==null?"Null":IDFORMA)
				+ ", " + (IDGENERACION==null?"Null":IDGENERACION) + ", " + IDREGLAS + ", " + FINICIO + ", " + FFIN + ", " + (ESTADO==null?"Null":ESTADO) + ", "
				+ USRCREACION + ", " + FECHACREACION + ", " + DESCRIPCION + "]";
	}



	/* Sets & Gets FK*/

}