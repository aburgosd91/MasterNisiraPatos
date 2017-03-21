package com.nisira.entidad;

import java.sql.Timestamp;
import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "PUERTOSDESTINO")
public class PUERTOSDESTINO {
	@ClavePrimaria
	@Columna
	private int IDEMPRESA;
	@ClavePrimaria
	@Columna
	private String IDPUERTODESTINO;
	@Columna
	private String DESCRIPCION;
	@Columna
	private String CODIGOEQUIVALENTE;
	@Columna
	private Date FECHACREACION;
	@Columna
	private int ESTADO;
	public PUERTOSDESTINO() {
	}
	public int getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public String getIDPUERTODESTINO() {
		return IDPUERTODESTINO;
	}
	public void setIDPUERTODESTINO(String iDPUERTODESTINO) {
		IDPUERTODESTINO = iDPUERTODESTINO;
	}
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
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
	public int getESTADO() {
		return ESTADO;
	}
	public void setESTADO(int eSTADO) {
		ESTADO = eSTADO;
	}
	
}
