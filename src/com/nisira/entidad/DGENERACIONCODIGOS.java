package com.nisira.entidad;

import java.sql.Timestamp;
import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "DGENERACIONCODIGOS")
public class DGENERACIONCODIGOS {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDGENERACION;
	@ClavePrimaria
	@Columna
	private Integer IDREGISTROCODIGO;
	@Columna
	private Integer NUMDIGITO;
	@Columna
	private Integer SINCRONIZADO;
	@Columna
	private String PARAMETRO;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer TIPOVALOR;

	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDGENERACION(Integer IDGENERACION) {
		this.IDGENERACION = IDGENERACION;
	}

	public Integer getIDGENERACION() {
		return this.IDGENERACION;
	}

	public void setIDREGISTROCODIGO(Integer IDREGISTROCODIGO) {
		this.IDREGISTROCODIGO = IDREGISTROCODIGO;
	}

	public Integer getIDREGISTROCODIGO() {
		return this.IDREGISTROCODIGO;
	}
	public void setNUMDIGITO(Integer NUMDIGITO) {
		this.NUMDIGITO = NUMDIGITO;
	}

	public Integer getNUMDIGITO() {
		return this.NUMDIGITO;
	}

	public void setSINCRONIZADO(Integer SINCRONIZADO) {
		this.SINCRONIZADO = SINCRONIZADO;
	}

	public Integer getSINCRONIZADO() {
		return this.SINCRONIZADO;
	}

	public String getPARAMETRO() {
		return PARAMETRO;
	}

	public void setPARAMETRO(String pARAMETRO) {
		PARAMETRO = pARAMETRO;
	}

	public Date getFECHACREACION() {
		return FECHACREACION;
	}

	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}

	public Integer getTIPOVALOR() {
		return TIPOVALOR;
	}

	public void setTIPOVALOR(Integer tIPOVALOR) {
		TIPOVALOR = tIPOVALOR;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDGENERACION + ", " + (IDREGISTROCODIGO==null?"Null":IDREGISTROCODIGO)  + ", "
				+ ", " + (NUMDIGITO==null?"Null":NUMDIGITO) + ", " + (SINCRONIZADO==null?"Null":SINCRONIZADO) + ", " + PARAMETRO + ", " + FECHACREACION
				+ ", " + (TIPOVALOR==null?"Null":TIPOVALOR) + "]";
	}
	

	/* Sets & Gets FK*/

}