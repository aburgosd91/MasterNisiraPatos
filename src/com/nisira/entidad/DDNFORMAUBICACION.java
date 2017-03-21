package com.nisira.entidad;

import java.sql.Timestamp;
import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@Tabla(nombre = "DDNFORMAUBICACION")
public class DDNFORMAUBICACION {
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
    private String IDNFORMACIONUBICACION;
	@ClavePrimaria
	@Columna
    private int FILAS;
	@ClavePrimaria
	@Columna
    private int COLUMNAS;
	@ClavePrimaria
	@Columna
    private String IDFILA;
	@ClavePrimaria
	@Columna
    private String IDCOLUMNA;
	@Columna
    private int PRIORIDAD;
	@Columna
    private int ESTADO;
	@XStreamOmitField
    private boolean SELECCIONADO;
    @Columna
    private Date FECHACREACION;
    
	public DDNFORMAUBICACION() {
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

	public String getIDNFORMACIONUBICACION() {
		return IDNFORMACIONUBICACION;
	}

	public void setIDNFORMACIONUBICACION(String iDNFORMACIONUBICACION) {
		IDNFORMACIONUBICACION = iDNFORMACIONUBICACION;
	}

	public int getFILAS() {
		return FILAS;
	}

	public void setFILAS(int fILAS) {
		FILAS = fILAS;
	}

	public int getCOLUMNAS() {
		return COLUMNAS;
	}

	public void setCOLUMNAS(int cOLUMNAS) {
		COLUMNAS = cOLUMNAS;
	}

	public String getIDFILA() {
		return IDFILA;
	}

	public void setIDFILA(String iDFILA) {
		IDFILA = iDFILA;
	}

	public String getIDCOLUMNA() {
		return IDCOLUMNA;
	}

	public void setIDCOLUMNA(String iDCOLUMNA) {
		IDCOLUMNA = iDCOLUMNA;
	}

	public int getPRIORIDAD() {
		return PRIORIDAD;
	}

	public void setPRIORIDAD(int pRIORIDAD) {
		PRIORIDAD = pRIORIDAD;
	}

	public int getESTADO() {
		return ESTADO;
	}

	public void setESTADO(int eSTADO) {
		ESTADO = eSTADO;
	}

	public boolean isSELECCIONADO() {
		return SELECCIONADO;
	}

	public void setSELECCIONADO(boolean sELECCIONADO) {
		SELECCIONADO = sELECCIONADO;
	}

	public Date getFECHACREACION() {
		return FECHACREACION;
	}

	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDALMACEN + ", " + IDNFORMACIONUBICACION + ", " + FILAS
				+ ", " + COLUMNAS + ", " + IDFILA + ", " + IDCOLUMNA + ", " + PRIORIDAD + ", " + ESTADO + ", "
				+ SELECCIONADO + ", " + FECHACREACION + "]";
	}
	
    
}
