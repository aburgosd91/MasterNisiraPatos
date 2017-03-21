package com.nisira.entidad;

import java.sql.Timestamp;
import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "FORMAUBICACION")
public class FORMAUBICACION {
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
	@Columna
    private String DESCRIPCION;
	@Columna
    private boolean ESTADO;
	@Columna
    private Date FECHACREACION;
	public FORMAUBICACION() {
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
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	public boolean isESTADO() {
		return ESTADO;
	}
	public void setESTADO(boolean eSTADO) {
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
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDALMACEN + ", " + IDPARAMETRO + ", " + IDFORMACIONUBICACION
				+ ", " + DESCRIPCION + ", " + ESTADO + ", " + FECHACREACION + "]";
	}
	
}
