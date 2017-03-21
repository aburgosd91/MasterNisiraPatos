package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "PUERTOCOM")
public class PUERTOCOM {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDPUERTOCOM;
	@Columna
	private String DESCRIPCION;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer ESTADO;
	public Integer getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(Integer iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public Integer getIDPUERTOCOM() {
		return IDPUERTOCOM;
	}
	public void setIDPUERTOCOM(Integer iDPUERTOCOM) {
		IDPUERTOCOM = iDPUERTOCOM;
	}
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	public Date getFECHACREACION() {
		return FECHACREACION;
	}
	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}
	public Integer getESTADO() {
		return ESTADO;
	}
	public void setESTADO(Integer eSTADO) {
		ESTADO = eSTADO;
	}
	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDPUERTOCOM + ", " + DESCRIPCION + ", " + FECHACREACION + ", " + ESTADO + "]";
	}
}