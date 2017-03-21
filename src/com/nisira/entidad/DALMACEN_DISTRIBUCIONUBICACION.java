package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.sql.Timestamp;
import java.util.Date;

@Tabla(nombre = "DALMACEN_DISTRIBUCIONUBICACION")
public class DALMACEN_DISTRIBUCIONUBICACION {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private Integer IDALMACEN;
	@ClavePrimaria
	@Columna
	private String IDDISTRIBUCION;
	@Columna
	private Date FECHAINICIO;
	@Columna
	private Date FECHAFIN;
	@Columna
	private Float ESTADO;
	@Columna
	private Date FECHACREACION;


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

	public void setIDALMACEN(Integer IDALMACEN) {
		this.IDALMACEN = IDALMACEN;
	}

	public Integer getIDALMACEN() {
		return this.IDALMACEN;
	}

	public void setIDDISTRIBUCION(String IDDISTRIBUCION) {
		this.IDDISTRIBUCION = IDDISTRIBUCION;
	}

	public String getIDDISTRIBUCION() {
		return this.IDDISTRIBUCION;
	}

	public void setFECHAINICIO(Date FECHAINICIO) {
		this.FECHAINICIO = FECHAINICIO;
	}

	public Date getFECHAINICIO() {
		return this.FECHAINICIO;
	}

	public void setFECHAFIN(Date FECHAFIN) {
		this.FECHAFIN = FECHAFIN;
	}

	public Date getFECHAFIN() {
		return this.FECHAFIN;
	}

	public void setESTADO(Float ESTADO) {
		this.ESTADO = ESTADO;
	}

	public Float getESTADO() {
		return this.ESTADO;
	}

	public Date getFECHACREACION() {
		return FECHACREACION;
	}

	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDALMACEN + ", " + IDDISTRIBUCION + ", " + FECHAINICIO
				+ ", " + (FECHAFIN==null?"Null":FECHAFIN) + ", " + (ESTADO==null?"Null":ESTADO) + ", " + FECHACREACION + "]";
	}

	

	/* Sets & Gets FK*/

}