package com.nisira.entidad;

import java.sql.Timestamp;
import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "PARAMETROS")
public class PARAMETROS {
	@ClavePrimaria
	@Columna
    private int IDEMPRESA;
	@ClavePrimaria
	@Columna
    private String IDPARAMETRO;
	@Columna
    private String DESCRIPCION;
	@Columna
    private int VALOR;
	@Columna
    private String CODIGOEQUIVALENTE;
    @Columna
    private Date FECHACREACION;
    @Columna
    private int ESTADO;
	public PARAMETROS() {
	}
	public int getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public String getIDPARAMETRO() {
		return IDPARAMETRO;
	}
	public void setIDPARAMETRO(String iDPARAMETRO) {
		IDPARAMETRO = iDPARAMETRO;
	}
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	public int getVALOR() {
		return VALOR;
	}
	public void setVALOR(int vALOR) {
		VALOR = vALOR;
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
		return "[" + IDEMPRESA + ", " + IDPARAMETRO + ", " + DESCRIPCION + ", " + VALOR + ", " + CODIGOEQUIVALENTE
				+ ", " + FECHACREACION + ", " + ESTADO + "]";
	}
    
}

