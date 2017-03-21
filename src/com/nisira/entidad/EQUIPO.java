package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "EQUIPO")
public class EQUIPO {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDEQUIPO;
	@Columna
	private String NROSERIE;
	@Columna
	private Integer IDTIPOEQUIPOMONTACARGA;
	@Columna
	private String DESCRIPCION;
	@Columna
	private Integer ESTADO;
	@Columna
	private String CODIGOEQUIVALENTE;
	@Columna
	private Date FECHACREACION;
	public Integer getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(Integer iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public Integer getIDEQUIPO() {
		return IDEQUIPO;
	}
	public void setIDEQUIPO(Integer iDEQUIPO) {
		IDEQUIPO = iDEQUIPO;
	}
	public String getNROSERIE() {
		return NROSERIE;
	}
	public void setNROSERIE(String nROSERIE) {
		NROSERIE = nROSERIE;
	}
	public Integer getIDTIPOEQUIPOMONTACARGA() {
		return IDTIPOEQUIPOMONTACARGA;
	}
	public void setIDTIPOEQUIPOMONTACARGA(Integer iDTIPOEQUIPOMONTACARGA) {
		IDTIPOEQUIPOMONTACARGA = iDTIPOEQUIPOMONTACARGA;
	}
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	public Integer getESTADO() {
		return ESTADO;
	}
	public void setESTADO(Integer eSTADO) {
		ESTADO = eSTADO;
	}
	public String getCODIGOEQUIVALENTE() {
		return CODIGOEQUIVALENTE;
	}
	public void setCODIGOEQUIVALENTE(String cODIGOEQUIVALENTE) {
		CODIGOEQUIVALENTE = cODIGOEQUIVALENTE;
	}
	public Date getFECHACREACION() {
		return FECHACREACION;
	}
	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}
	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDEQUIPO + ", " + NROSERIE + ", " + IDTIPOEQUIPOMONTACARGA + ", " + DESCRIPCION
				+ ", " + ESTADO + ", " + CODIGOEQUIVALENTE + ", " + FECHACREACION + "]";
	}

	/* Sets & Gets FK*/

}