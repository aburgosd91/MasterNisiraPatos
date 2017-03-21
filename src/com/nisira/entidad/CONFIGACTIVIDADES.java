package com.nisira.entidad;

import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "CONFIGACTIVIDADES")
public class CONFIGACTIVIDADES {
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDACTIVIDADES;
	@ClavePrimaria
	@Columna
	private Integer IDCONFIGURACION;
	@Columna
	private String DESCRIPCION;
	@Columna
	private Integer TIPO;
	@Columna
	private Date FECHACREACION;


	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDACTIVIDADES(Integer IDACTIVIDADES) {
		this.IDACTIVIDADES = IDACTIVIDADES;
	}

	public Integer getIDACTIVIDADES() {
		return this.IDACTIVIDADES;
	}

	public void setIDCONFIGURACION(Integer IDCONFIGURACION) {
		this.IDCONFIGURACION = IDCONFIGURACION;
	}

	public Integer getIDCONFIGURACION() {
		return this.IDCONFIGURACION;
	}

	public void setDESCRIPCION(String DESCRIPCION) {
		this.DESCRIPCION = DESCRIPCION;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
	}

	public void setTIPO(Integer TIPO) {
		this.TIPO = TIPO;
	}

	public Integer getTIPO() {
		return this.TIPO;
	}

	public Date getFECHACREACION() {
		return FECHACREACION;
	}

	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDACTIVIDADES + ", " + IDCONFIGURACION + ", " + DESCRIPCION + ", " + TIPO + ", "
				+ FECHACREACION + "]";
	}



	/* Sets & Gets FK*/

}