package com.nisira.entidad;

import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "DFORMAUBICACION")
public class DFORMAUBICACION {
	@ClavePrimaria
	@Columna
    private String IDEMPRESA;
	@ClavePrimaria
	@Columna
    private String IDSUCURSAL;
	@ClavePrimaria
	@Columna
    private String IDALMACEN;
	@ClavePrimaria
	@Columna
    private String IDPARAMETRO;
	@ClavePrimaria
	@Columna
    private String IDFORMACIONUBICACION;
	@ClavePrimaria
	@Columna
    private String IDRACK;
	@Columna
    private int R_PRIORIDAD;
	@Columna
    private Date FECHACREACION;
	public DFORMAUBICACION() {
	}
	public String getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(String iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public String getIDSUCURSAL() {
		return IDSUCURSAL;
	}
	public void setIDSUCURSAL(String iDSUCURSAL) {
		IDSUCURSAL = iDSUCURSAL;
	}
	public String getIDALMACEN() {
		return IDALMACEN;
	}
	public void setIDALMACEN(String iDALMACEN) {
		IDALMACEN = iDALMACEN;
	}
	public String getIDPARAMETRO() {
		return IDPARAMETRO;
	}
	public void setIDPARAMETRO(String iDPARAMETRO) {
		IDPARAMETRO = iDPARAMETRO;
	}
	public String getIDFORMACIONUBICACION() {
		return IDFORMACIONUBICACION;
	}
	public void setIDFORMACIONUBICACION(String iDFORMACIONUBICACION) {
		IDFORMACIONUBICACION = iDFORMACIONUBICACION;
	}
	public String getIDRACK() {
		return IDRACK;
	}
	public void setIDRACK(String iDRACK) {
		IDRACK = iDRACK;
	}
	public int getR_PRIORIDAD() {
		return R_PRIORIDAD;
	}
	public void setR_PRIORIDAD(int r_PRIORIDAD) {
		R_PRIORIDAD = r_PRIORIDAD;
	}
	public Date getFECHACREACION() {
		return FECHACREACION;
	}
	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}
	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDALMACEN + ", " + IDPARAMETRO + ", " + IDFORMACIONUBICACION
				+ ", " + IDRACK + ", " + R_PRIORIDAD + ", " + FECHACREACION + "]";
	}
	
}
