package com.nisira.entidad;

import java.sql.Timestamp;
import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "DNFORMAUBICACION")
public class DNFORMAUBICACION {
	@ClavePrimaria
	@Columna
    private String IDEMPRESA;
	@ClavePrimaria
	@Columna
    private String IDSUCURSAL;	
	@Columna
    private String IDDISTRIBUCION;
    @ClavePrimaria
	@Columna
    private String IDALMACEN;
    @ClavePrimaria
	@Columna
    private String IDNFORMACIONUBICACION;
    @Columna
    private int FILAS;
    @Columna
    private int COLUMNAS;
    @Columna
    private String DESCRIPCION;
    @Columna
    private int ESTADO;
    @Columna
    private Date FECHACREACION;
    
	public DNFORMAUBICACION() {
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

	public String getIDDISTRIBUCION() {
		return IDDISTRIBUCION;
	}

	public void setIDDISTRIBUCION(String iDDISTRIBUCION) {
		IDDISTRIBUCION = iDDISTRIBUCION;
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

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}

	public int getESTADO() {
		return ESTADO;
	}

	public void setESTADO(int eSTADO) {
		ESTADO = eSTADO;
	}

	public Date getFECHACREACION() {
		return FECHACREACION;
	}

	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDDISTRIBUCION + ", " + IDALMACEN + ", "
				+ IDNFORMACIONUBICACION + ", " + FILAS + ", " + COLUMNAS + ", " + DESCRIPCION + ", " + ESTADO + ", "
				+ FECHACREACION + "]";
	}
	
}
