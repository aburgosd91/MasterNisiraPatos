package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.io.Serializable;
import java.util.Date;

@Tabla(nombre = "CONFIGTABLASINCRO")
public class CONFIGTABLASINCRO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4255099464744790076L;
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDTABLASINCRO;
	@Columna
	private String TABLA;
	@Columna
	private Integer TIPOSINCRO;
	@Columna
	private Integer UPDOWN;
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

	public void setIDTABLASINCRO(Integer IDTABLASINCRO) {
		this.IDTABLASINCRO = IDTABLASINCRO;
	}

	public Integer getIDTABLASINCRO() {
		return this.IDTABLASINCRO;
	}

	public void setTABLA(String TABLA) {
		this.TABLA = TABLA;
	}

	public String getTABLA() {
		return this.TABLA;
	}

	public void setTIPOSINCRO(Integer TIPOSINCRO) {
		this.TIPOSINCRO = TIPOSINCRO;
	}

	public Integer getTIPOSINCRO() {
		return this.TIPOSINCRO;
	}

	public void setUPDOWN(Integer UPDOWN) {
		this.UPDOWN = UPDOWN;
	}

	public Integer getUPDOWN() {
		return this.UPDOWN;
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
		return "[" + IDEMPRESA + ", " + IDTABLASINCRO + ", " + TABLA + ", " + (TIPOSINCRO==null?"Null":TIPOSINCRO) + ", " + (UPDOWN==null?"Null":UPDOWN) + ", "
				+ FECHACREACION + ", " + (ESTADO==null?"Null":ESTADO) + "]";
	}

	

	/* Sets & Gets FK*/

}
