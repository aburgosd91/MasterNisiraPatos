package com.nisira.entidad;

import java.sql.Timestamp;
import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "DDPROGRAMACIONALMPRIORIDAD")
public class DDPROGRAMACIONALMPRIORIDAD {
	@ClavePrimaria
	@Columna
	private int IDEMPRESA;
	@ClavePrimaria
	@Columna
	private int IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private int IDPROGRAMAALM;
	@ClavePrimaria
	@Columna
	private int IDALMACEN;
	@ClavePrimaria
	@Columna
	private int IDRACK;
	@ClavePrimaria
	@Columna
	private int PRIORIDADALMACEN;
	@ClavePrimaria
	@Columna
	private int PRIORIDADRACK;
	@Columna
	private String IDNFORMACIONUBICACION;
	@Columna
	private int IDREGLA;
	@Columna
	private int IDDISTRIBUCIONPISO;
	@Columna
	private Date FECHACREACION;

	public DDPROGRAMACIONALMPRIORIDAD() {
	}

	public int getIDEMPRESA() {
		return IDEMPRESA;
	}

	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}

	public int getIDSUCURSAL() {
		return IDSUCURSAL;
	}

	public void setIDSUCURSAL(int iDSUCURSAL) {
		IDSUCURSAL = iDSUCURSAL;
	}

	public int getIDPROGRAMAALM() {
		return IDPROGRAMAALM;
	}

	public void setIDPROGRAMAALM(int iDPROGRAMAALM) {
		IDPROGRAMAALM = iDPROGRAMAALM;
	}

	public int getIDALMACEN() {
		return IDALMACEN;
	}

	public void setIDALMACEN(int iDALMACEN) {
		IDALMACEN = iDALMACEN;
	}

	public int getIDRACK() {
		return IDRACK;
	}

	public void setIDRACK(int iDRACK) {
		IDRACK = iDRACK;
	}

	public int getPRIORIDADALMACEN() {
		return PRIORIDADALMACEN;
	}

	public void setPRIORIDADALMACEN(int pRIORIDADALMACEN) {
		PRIORIDADALMACEN = pRIORIDADALMACEN;
	}

	public int getPRIORIDADRACK() {
		return PRIORIDADRACK;
	}

	public void setPRIORIDADRACK(int pRIORIDADRACK) {
		PRIORIDADRACK = pRIORIDADRACK;
	}

	public String getIDNFORMACIONUBICACION() {
		return IDNFORMACIONUBICACION;
	}

	public void setIDNFORMACIONUBICACION(String iDNFORMACIONUBICACION) {
		IDNFORMACIONUBICACION = iDNFORMACIONUBICACION;
	}

	public int getIDREGLA() {
		return IDREGLA;
	}

	public void setIDREGLA(int iDREGLA) {
		IDREGLA = iDREGLA;
	}

	public int getIDDISTRIBUCIONPISO() {
		return IDDISTRIBUCIONPISO;
	}

	public void setIDDISTRIBUCIONPISO(int iDDISTRIBUCIONPISO) {
		IDDISTRIBUCIONPISO = iDDISTRIBUCIONPISO;
	}

	public Date getFECHACREACION() {
		return FECHACREACION;
	}

	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDPROGRAMAALM + ", " + IDALMACEN + ", " + IDRACK + ", "
				+ PRIORIDADALMACEN + ", " + PRIORIDADRACK + ", " + IDNFORMACIONUBICACION + ", " + IDREGLA + ", "
				+ IDDISTRIBUCIONPISO + ", " + FECHACREACION + "]";
	}
	
}
