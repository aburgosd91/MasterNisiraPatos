package com.nisira.entidad;

import java.sql.Timestamp;
import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
@Tabla(nombre = "REGLA")
public class REGLA {
	@ClavePrimaria
	@Columna
    private int IDEMPRESA;
	@ClavePrimaria
	@Columna
    private int IDREGLA;
	@Columna
    private String DESCRIPCION;
	@Columna
    private int CANTIDADPARAMETROS;
	@Columna
    private int ESTADO;
	@Columna
    private Date FECHACREACION;
	
	public REGLA() {
		
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

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}

	public int getCANTIDADPARAMETROS() {
		return CANTIDADPARAMETROS;
	}

	public void setCANTIDADPARAMETROS(int cANTIDADPARAMETROS) {
		CANTIDADPARAMETROS = cANTIDADPARAMETROS;
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
		return "[" + IDEMPRESA + ", " + IDREGLA + ", " + DESCRIPCION + ", " + CANTIDADPARAMETROS + ", " + ESTADO + ", "
				+ FECHACREACION + "]";
	}
	
}
