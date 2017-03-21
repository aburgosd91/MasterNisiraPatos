package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "HTTPCLIENT")
public class HTTPCLIENT {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDHTTP;
	@Columna
	private String PAGE;
	@Columna
	private String DESCRIPCION;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Float ESTADO;



	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDHTTP(Integer IDHTTP) {
		this.IDHTTP = IDHTTP;
	}

	public Integer getIDHTTP() {
		return this.IDHTTP;
	}

	public void setPAGE(String PAGE) {
		this.PAGE = PAGE;
	}

	public String getPAGE() {
		return this.PAGE;
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

	public void setESTADO(Float ESTADO) {
		this.ESTADO = ESTADO;
	}

	public Float getESTADO() {
		return this.ESTADO;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDHTTP + ", " + PAGE + ", " + DESCRIPCION + ", " + FECHACREACION + ", " + ESTADO
				+ "]";
	}



	/* Sets & Gets FK*/

}