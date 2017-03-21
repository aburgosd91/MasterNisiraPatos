package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.bouncycastle.asn1.tsp.TimeStampReq;

@Tabla(nombre = "ACCIONES")
public class ACCIONES implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1055497276154536809L;
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDACCION;
	@Columna
	private String DESCRIPCION;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer ESTADO;


	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDACCION(Integer IDACCION) {
		this.IDACCION = IDACCION;
	}

	public Integer getIDACCION() {
		return this.IDACCION;
	}

	public void setDESCRIPCION(String DESCRIPCION) {
		this.DESCRIPCION = DESCRIPCION;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	public void setESTADO(Integer ESTADO) {
		this.ESTADO = ESTADO;
	}

	public Integer getESTADO() {
		return this.ESTADO;
	}
	
	
	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDACCION + ", " + DESCRIPCION + ", " + FECHACREACION + ", " + 
				(ESTADO==null?"Null":ESTADO) + "]";
	}

	/* Sets & Gets FK*/

}