package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.io.Serializable;
import java.util.Date;

@Tabla(nombre = "DPROGRAMAALMEJECUCION")
public class DPROGRAMAALMEJECUCION implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2679631785299386224L;
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private String IDPROGRAMACIONLLENADO;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private Integer IDALMACEN;
	@ClavePrimaria
	@Columna
	private Integer IDRACK;
	@ClavePrimaria
	@Columna
	private String IDDISTRIBUCION;
	@ClavePrimaria
	@Columna
	private Integer IDPISO;
	@ClavePrimaria
	@Columna
	private Integer IDFILA;
	@ClavePrimaria
	@Columna
	private Integer IDCOLUMNA;
	@Columna
	private String IDUBICACION;
	@Columna
	private Integer PRIORIDAD;
	@Columna
	private String IDPALETAREGISTRADA;
	@Columna
	private String NROPALETAREGISTRADA;
	@Columna
	private String ESTADO;
	@Columna
	private Date FECHACREACION;
	@Columna
	private String IDCAMPANA;



	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDPROGRAMACIONLLENADO(String IDPROGRAMACIONLLENADO) {
		this.IDPROGRAMACIONLLENADO = IDPROGRAMACIONLLENADO;
	}

	public String getIDPROGRAMACIONLLENADO() {
		return this.IDPROGRAMACIONLLENADO;
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

	public void setIDRACK(Integer IDRACK) {
		this.IDRACK = IDRACK;
	}

	public Integer getIDRACK() {
		return this.IDRACK;
	}

	public void setIDDISTRIBUCION(String IDDISTRIBUCION) {
		this.IDDISTRIBUCION = IDDISTRIBUCION;
	}

	public String getIDDISTRIBUCION() {
		return this.IDDISTRIBUCION;
	}

	public void setIDPISO(Integer IDPISO) {
		this.IDPISO = IDPISO;
	}

	public Integer getIDPISO() {
		return this.IDPISO;
	}

	public void setIDFILA(Integer IDFILA) {
		this.IDFILA = IDFILA;
	}

	public Integer getIDFILA() {
		return this.IDFILA;
	}

	public void setIDCOLUMNA(Integer IDCOLUMNA) {
		this.IDCOLUMNA = IDCOLUMNA;
	}

	public Integer getIDCOLUMNA() {
		return this.IDCOLUMNA;
	}

	public void setIDUBICACION(String IDUBICACION) {
		this.IDUBICACION = IDUBICACION;
	}

	public String getIDUBICACION() {
		return this.IDUBICACION;
	}

	public void setPRIORIDAD(Integer PRIORIDAD) {
		this.PRIORIDAD = PRIORIDAD;
	}

	public Integer getPRIORIDAD() {
		return this.PRIORIDAD;
	}

	public void setIDPALETAREGISTRADA(String IDPALETAREGISTRADA) {
		this.IDPALETAREGISTRADA = IDPALETAREGISTRADA;
	}

	public String getIDPALETAREGISTRADA() {
		return this.IDPALETAREGISTRADA;
	}

	public void setNROPALETAREGISTRADA(String NROPALETAREGISTRADA) {
		this.NROPALETAREGISTRADA = NROPALETAREGISTRADA;
	}

	public String getNROPALETAREGISTRADA() {
		return this.NROPALETAREGISTRADA;
	}

	public void setESTADO(String ESTADO) {
		this.ESTADO = ESTADO;
	}

	public String getESTADO() {
		return this.ESTADO;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	public void setIDCAMPANA(String IDCAMPANA) {
		this.IDCAMPANA = IDCAMPANA;
	}

	public String getIDCAMPANA() {
		return this.IDCAMPANA;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDPROGRAMACIONLLENADO + ", " + IDSUCURSAL + ", " + IDALMACEN + ", " + IDRACK
				+ ", " + IDDISTRIBUCION + ", " + IDPISO + ", " + IDFILA + ", " + IDCOLUMNA + ", " + IDUBICACION + ", "
				+ (PRIORIDAD==null?"Null":PRIORIDAD) + ", " + IDPALETAREGISTRADA + ", " + NROPALETAREGISTRADA + ", " + ESTADO + ", "
				+ FECHACREACION + ", " + IDCAMPANA + "]";
	}

	

	/* Sets & Gets FK*/

}