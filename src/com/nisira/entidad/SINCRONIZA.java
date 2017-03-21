package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.sql.Timestamp;
import java.util.Date;

@Tabla(nombre = "SINCRONIZA")
public class SINCRONIZA {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private Integer IDSINCRONIZA;
	@ClavePrimaria
	@Columna
	private String IDUSUARIO;
	@Columna
	private String LOGSEGUIMIENTO;	
	@Columna
	private Integer TIPO;
	@Columna
	private Date FECHAINICIO;
	@Columna
	private Date FECHAFIN;
	@Columna
	private Date FECHACREACION;
	public SINCRONIZA() {
	}
	public Integer getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(Integer iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public Integer getIDSUCURSAL() {
		return IDSUCURSAL;
	}
	public void setIDSUCURSAL(Integer iDSUCURSAL) {
		IDSUCURSAL = iDSUCURSAL;
	}
	public Integer getIDSINCRONIZA() {
		return IDSINCRONIZA;
	}
	public void setIDSINCRONIZA(Integer iDSINCRONIZA) {
		IDSINCRONIZA = iDSINCRONIZA;
	}
	public String getIDUSUARIO() {
		return IDUSUARIO;
	}
	public void setIDUSUARIO(String iDUSUARIO) {
		IDUSUARIO = iDUSUARIO;
	}
	public String getLOGSEGUIMIENTO() {
		return LOGSEGUIMIENTO;
	}
	public void setLOGSEGUIMIENTO(String lOGSEGUIMIENTO) {
		LOGSEGUIMIENTO = lOGSEGUIMIENTO;
	}
	public Integer getTIPO() {
		return TIPO;
	}
	public void setTIPO(Integer tIPO) {
		TIPO = tIPO;
	}
	public Date getFECHAINICIO() {
		return FECHAINICIO;
	}
	public void setFECHAINICIO(Date fECHAINICIO) {
		FECHAINICIO = fECHAINICIO;
	}
	public Date getFECHAFIN() {
		return FECHAFIN;
	}
	public void setFECHAFIN(Date fECHAFIN) {
		FECHAFIN = fECHAFIN;
	}
	public Date getFECHACREACION() {
		return FECHACREACION;
	}
	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}
	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDSINCRONIZA + ", " + IDUSUARIO + ", " + LOGSEGUIMIENTO
				+ ", " + (TIPO==null?"Null":TIPO) + ", " + FECHAINICIO + ", " + FECHAFIN + ", " + FECHACREACION + "]";
	}



	/* Sets & Gets */

	/* Sets & Gets FK*/

}