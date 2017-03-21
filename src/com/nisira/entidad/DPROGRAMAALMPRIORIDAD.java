package com.nisira.entidad;

import java.sql.Timestamp;
import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "DPROGRAMAALMPRIORIDAD")
public class DPROGRAMAALMPRIORIDAD {
	@ClavePrimaria
	@Columna
    private int IDPROGRAMAALM;
	@ClavePrimaria
	@Columna
    private int IDSUCURSAL;
	@ClavePrimaria
	@Columna
    private int IDALMACEN;
	@ClavePrimaria
	@Columna
    private int IDRACK;
	@ClavePrimaria
	@Columna
    private int IDEMPRESA;
	@Columna
    private int IDREGLA;
    @ClavePrimaria
	@Columna
    private int PRIORIDADALMACEN;
    @ClavePrimaria
	@Columna
    private int PRIORIDADRACK;
    @Columna
    private int ESTADO;
    @Columna
    private int SINCRONIZA;
    @Columna
    private Date FECHACREACION;
    private boolean detalle;
	public DPROGRAMAALMPRIORIDAD() {
		
	}
	public int getIDPROGRAMAALM() {
		return IDPROGRAMAALM;
	}
	public void setIDPROGRAMAALM(int iDPROGRAMAALM) {
		IDPROGRAMAALM = iDPROGRAMAALM;
	}
	public int getIDSUCURSAL() {
		return IDSUCURSAL;
	}
	public void setIDSUCURSAL(int iDSUCURSAL) {
		IDSUCURSAL = iDSUCURSAL;
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
	public int getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public int getIDREGLA() {
		return IDREGLA;
	}
	public void setIDREGLA(int iDREGLA) {
		IDREGLA = iDREGLA;
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
	public Date getFECHACREACION() {
		return FECHACREACION;
	}
	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}
	public boolean isDetalle() {
		return detalle;
	}
	public void setDetalle(boolean detalle) {
		this.detalle = detalle;
	}
	@Override
	public String toString() {
		return "[" + IDPROGRAMAALM + ", " + IDSUCURSAL + ", " + IDALMACEN + ", " + IDRACK + ", " + IDEMPRESA + ", "
				+ IDREGLA + ", " + PRIORIDADALMACEN + ", " + PRIORIDADRACK + ", " + ESTADO + ", " + SINCRONIZA + ", "
				+ FECHACREACION +"]";
	}
	
}
