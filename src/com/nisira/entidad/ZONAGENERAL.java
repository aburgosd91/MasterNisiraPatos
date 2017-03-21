package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.sql.Timestamp;
import java.util.Date;

@Tabla(nombre = "ZONAGENERAL")
public class ZONAGENERAL {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private Integer IDZONAGENERAL;
	@Columna
	private Float AREA;
	@Columna
	private Integer LARGO;
	@Columna
	private Integer ANCHO;
	@Columna
	private Date FECHACREACION;
	@Columna
	private String CODIGOEQUIVALENTE;
	@Columna
	private Integer ESTADO;
	@Columna
	private Integer SINCRONIZA;



	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDSUCURSAL(Integer IDSUCURSAL) {
		this.IDSUCURSAL = IDSUCURSAL;
	}

	public Integer getIDSUCURSAL() {
		return this.IDSUCURSAL;
	}

	public void setIDZONAGENERAL(Integer IDZONAGENERAL) {
		this.IDZONAGENERAL = IDZONAGENERAL;
	}

	public Integer getIDZONAGENERAL() {
		return this.IDZONAGENERAL;
	}

	public void setAREA(Float AREA) {
		this.AREA = AREA;
	}

	public Float getAREA() {
		return this.AREA;
	}

	public void setLARGO(Integer LARGO) {
		this.LARGO = LARGO;
	}

	public Integer getLARGO() {
		return this.LARGO;
	}

	public void setANCHO(Integer ANCHO) {
		this.ANCHO = ANCHO;
	}

	public Integer getANCHO() {
		return this.ANCHO;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	public void setCODIGOEQUIVALENTE(String CODIGOEQUIVALENTE) {
		this.CODIGOEQUIVALENTE = CODIGOEQUIVALENTE;
	}

	public String getCODIGOEQUIVALENTE() {
		return this.CODIGOEQUIVALENTE;
	}

	public void setESTADO(Integer ESTADO) {
		this.ESTADO = ESTADO;
	}

	public Integer getESTADO() {
		return this.ESTADO;
	}

	public void setSINCRONIZA(Integer SINCRONIZA) {
		this.SINCRONIZA = SINCRONIZA;
	}

	public Integer getSINCRONIZA() {
		return this.SINCRONIZA;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDZONAGENERAL + ", " + AREA + ", " + LARGO + ", " + ANCHO
				+ ", " + FECHACREACION + ", " + CODIGOEQUIVALENTE + ", " + ESTADO + ", " + SINCRONIZA + "]";
	}



	/* Sets & Gets FK*/

}