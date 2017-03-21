package com.nisira.entidad;

import java.sql.Timestamp;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "NOTIFICACION")
public class NotitficaSP {
	@ClavePrimaria
	@Columna
    private int IDEMPRESA;
	@ClavePrimaria
	@Columna
    private int IDNOTIFICACION;
	@Columna
    private String MENSAJE;
	@Columna
    private Timestamp FECHACREACION;
	@Columna
    private int PRIORIDAD;
	@Columna
    private Timestamp FECHAENVIO;
	@Columna
    private int ESTADO;
	@Columna
	private int IDPROGRAMAALM;
	
	public NotitficaSP() {
	}
	
	public int getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public int getIDNOTIFICACION() {
		return IDNOTIFICACION;
	}
	public void setIDNOTIFICACION(int iDNOTIFICACION) {
		IDNOTIFICACION = iDNOTIFICACION;
	}
	public String getMENSAJE() {
		return MENSAJE;
	}
	public void setMENSAJE(String mENSAJE) {
		MENSAJE = mENSAJE;
	}
	public Timestamp getFECHACREACION() {
		return FECHACREACION;
	}
	public void setFECHACREACION(Timestamp fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}
	public int getPRIORIDAD() {
		return PRIORIDAD;
	}
	public void setPRIORIDAD(int pRIORIDAD) {
		PRIORIDAD = pRIORIDAD;
	}
	public Timestamp getFECHAENVIO() {
		return FECHAENVIO;
	}
	public void setFECHAENVIO(Timestamp fECHAENVIO) {
		FECHAENVIO = fECHAENVIO;
	}
	public int getESTADO() {
		return ESTADO;
	}
	public void setESTADO(int eSTADO) {
		ESTADO = eSTADO;
	}
	public int getIDPROGRAMAALM() {
		return IDPROGRAMAALM;
	}
	public void setIDPROGRAMAALM(int iDPROGRAMAALM) {
		IDPROGRAMAALM = iDPROGRAMAALM;
	}
	
}
