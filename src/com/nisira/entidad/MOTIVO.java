package com.nisira.entidad;

import java.sql.Timestamp;
import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "MOTIVO")
public class MOTIVO {
	@ClavePrimaria
	@Columna
    private int IDEMPRESA;
	@ClavePrimaria
	@Columna
    private String IDMOTIVO;
	@Columna
    private String DESCRIPCION;
	@Columna
    private String CODIGOEQUIVALENTE;
	@Columna
    private Date FECHACREACION;
	@Columna
    private int ESTADO;
	public MOTIVO() {
	}
	public int getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public String getIDMOTIVO() {
		return IDMOTIVO;
	}
	public void setIDMOTIVO(String iDMOTIVO) {
		IDMOTIVO = iDMOTIVO;
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
	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDMOTIVO + ", " + DESCRIPCION + ", " + CODIGOEQUIVALENTE + ", " + FECHACREACION
				+ ", " + ESTADO + "]";
	}
	
}
