package com.nisira.entidad;

import java.sql.Timestamp;
import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "DPROGRAMAALMMONTACARGA")
public class DPROGRAMAALMMONTACARGA {
	@ClavePrimaria
	@Columna
    private int IDEMPRESA;
	@ClavePrimaria
	@Columna
    private int IDPROGRAMAALM;
	@ClavePrimaria
	@Columna
    private String IDMONTACARGA;
	@Columna
    private Date FECHACREACION;
	@Columna
    private int NOTIFICADO;
	@Columna
    private int ESTADO;
	@Columna
    private int SINCRONIZA;
	
	public DPROGRAMAALMMONTACARGA() {
	}

	public int getIDEMPRESA() {
		return IDEMPRESA;
	}

	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}

	public int getIDPROGRAMAALM() {
		return IDPROGRAMAALM;
	}

	public void setIDPROGRAMAALM(int iDPROGRAMAALM) {
		IDPROGRAMAALM = iDPROGRAMAALM;
	}

	public String getIDMONTACARGA() {
		return IDMONTACARGA;
	}

	public void setIDMONTACARGA(String iDMONTACARGA) {
		IDMONTACARGA = iDMONTACARGA;
	}

	public Date getFECHACREACION() {
		return FECHACREACION;
	}

	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}

	public int getNOTIFICADO() {
		return NOTIFICADO;
	}

	public void setNOTIFICADO(int nOTIFICADO) {
		NOTIFICADO = nOTIFICADO;
	}

	public int getESTADO() {
		return ESTADO;
	}

	public void setESTADO(int eSTADO) {
		ESTADO = eSTADO;
	}

	public int getSINCRONIZA() {
		return SINCRONIZA;
	}

	public void setSINCRONIZA(int sINCRONIZA) {
		SINCRONIZA = sINCRONIZA;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDPROGRAMAALM + ", " + IDMONTACARGA + ", " + FECHACREACION + ", " + NOTIFICADO
				+ ", " + ESTADO + ", " + SINCRONIZA + "]";
	}
	
}
