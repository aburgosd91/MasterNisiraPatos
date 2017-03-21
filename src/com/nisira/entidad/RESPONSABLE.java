package com.nisira.entidad;

import java.sql.Timestamp;
import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "RESPONSABLE")
public class RESPONSABLE {
	@ClavePrimaria
	@Columna
    private int IDEMPRESA;
	@ClavePrimaria
	@Columna
    private int IDRESPONSABLE;
	@Columna
    private String IDOPERARIO;
	@Columna
    private int ESTADO;
	@Columna
    private Date FECHACREACION;
    private String NOMBRE;
    
	public RESPONSABLE() {
	}

	public int getIDEMPRESA() {
		return IDEMPRESA;
	}

	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}

	public int getIDRESPONSABLE() {
		return IDRESPONSABLE;
	}

	public void setIDRESPONSABLE(int iDRESPONSABLE) {
		IDRESPONSABLE = iDRESPONSABLE;
	}

	public String getIDOPERARIO() {
		return IDOPERARIO;
	}

	public void setIDOPERARIO(String iDOPERARIO) {
		IDOPERARIO = iDOPERARIO;
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

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDRESPONSABLE + ", " + IDOPERARIO + ", " + ESTADO + ", " + FECHACREACION+ "]";
	}    
	
}
