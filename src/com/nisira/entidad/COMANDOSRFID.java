package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "COMANDOSRFID")
public class COMANDOSRFID {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDCOMANDO;
	@Columna
	private String COMANDO;
	@Columna
	private String DESCRIPCION;
	@Columna
	private Integer ESTADO;
	@Columna
	private Date FECHACREACION;
	public Integer getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(Integer iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public Integer getIDCOMANDO() {
		return IDCOMANDO;
	}
	public void setIDCOMANDO(Integer iDCOMANDO) {
		IDCOMANDO = iDCOMANDO;
	}
	public String getCOMANDO() {
		return COMANDO;
	}
	public void setCOMANDO(String cOMANDO) {
		COMANDO = cOMANDO;
	}
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	public Integer getESTADO() {
		return ESTADO;
	}
	public void setESTADO(Integer eSTADO) {
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
		return "[" + IDEMPRESA + ", " + IDCOMANDO + ", " + COMANDO + ", " + DESCRIPCION + ", " + ESTADO + ", "
				+ FECHACREACION + "]";
	}

}