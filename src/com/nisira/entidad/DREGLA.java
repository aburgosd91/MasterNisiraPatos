package com.nisira.entidad;

import java.sql.Timestamp;
import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
@Tabla(nombre = "DREGLA")
public class DREGLA {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDREGLA;
	@ClavePrimaria
	@Columna
	private Integer IDPARAMETRO;
	@Columna
	private String DESCRIPCION;
	@Columna
	private Integer PRIORIDAD;
	@Columna
	private String TIPO;
	@Columna
	private String VALOR;
	@Columna
	private String CONDICION;
	@Columna
	private Integer ESTADO;
	@Columna
	private Date FECHACREACION;
	public DREGLA() {
	}
	public Integer getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(Integer iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public Integer getIDREGLA() {
		return IDREGLA;
	}
	public void setIDREGLA(Integer iDREGLA) {
		IDREGLA = iDREGLA;
	}
	public Integer getIDPARAMETRO() {
		return IDPARAMETRO;
	}
	public void setIDPARAMETRO(Integer iDPARAMETRO) {
		IDPARAMETRO = iDPARAMETRO;
	}
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	public Integer getPRIORIDAD() {
		return PRIORIDAD;
	}
	public void setPRIORIDAD(Integer pRIORIDAD) {
		PRIORIDAD = pRIORIDAD;
	}
	public String getTIPO() {
		return TIPO;
	}
	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}
	public String getVALOR() {
		return VALOR;
	}
	public void setVALOR(String vALOR) {
		VALOR = vALOR;
	}
	public String getCONDICION() {
		return CONDICION;
	}
	public void setCONDICION(String cONDICION) {
		CONDICION = cONDICION;
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
		return "[" + IDEMPRESA + ", " + IDREGLA + ", " + IDPARAMETRO + ", " + DESCRIPCION + ", " + (PRIORIDAD==null?"Null":PRIORIDAD) + ", "
				+ TIPO + ", " + VALOR + ", " + CONDICION + ", " + (ESTADO==null?"Null":ESTADO) + ", " + FECHACREACION + "]";
	}
	
}
