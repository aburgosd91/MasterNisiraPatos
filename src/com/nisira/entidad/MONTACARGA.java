package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "MONTACARGA")
public class MONTACARGA {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDMONTACARGA;
	@Columna
	private String DESCRIPCION;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer ESTADO;
	@Columna
	private String CODIGOEQUIVALENTE;
	@Columna
	private Integer SINCRONIZA;



	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDMONTACARGA(Integer IDMONTACARGA) {
		this.IDMONTACARGA = IDMONTACARGA;
	}

	public Integer getIDMONTACARGA() {
		return this.IDMONTACARGA;
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

	public void setCODIGOEQUIVALENTE(String CODIGOEQUIVALENTE) {
		this.CODIGOEQUIVALENTE = CODIGOEQUIVALENTE;
	}

	public String getCODIGOEQUIVALENTE() {
		return this.CODIGOEQUIVALENTE;
	}

	public void setSINCRONIZA(Integer SINCRONIZA) {
		this.SINCRONIZA = SINCRONIZA;
	}

	public Integer getSINCRONIZA() {
		return this.SINCRONIZA;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDMONTACARGA + ", " + DESCRIPCION + ", " + FECHACREACION + ", " + (ESTADO==null?"Null":ESTADO) + ", "
				+ CODIGOEQUIVALENTE + ", " + (SINCRONIZA==null?"Null":SINCRONIZA)+ "]";
	}



	/* Sets & Gets FK*/

}