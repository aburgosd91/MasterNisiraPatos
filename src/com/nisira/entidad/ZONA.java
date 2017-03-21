package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.sql.Timestamp;
import java.util.Date;

@Tabla(nombre = "ZONA")
public class ZONA {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private Integer IDZONA;
	@Columna
	private String DESCRIPCION;
	@Columna
	private Integer IDTIPOZONA;
	@Columna
	private Integer IDUNIDADMEDIDA;
	@Columna
	private Float AREA;
	@Columna
	private Integer AREAUNIDADDIAGRAMA;
	@Columna
	private Integer LARGOUNIDADDIAGRAMA;
	@Columna
	private Integer ANCHOUNIDADDIAGRAMA;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer ESTADO;
	@Columna
	private Integer SINCRONIZA;
	@Columna
	private String COLOR;
	@Columna
	private Integer IDPROCESO;
	@XStreamOmitField
	private String TIPO;


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

	public void setIDZONA(Integer IDZONA) {
		this.IDZONA = IDZONA;
	}

	public Integer getIDZONA() {
		return this.IDZONA;
	}

	public void setDESCRIPCION(String DESCRIPCION) {
		this.DESCRIPCION = DESCRIPCION;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
	}

	public void setIDTIPOZONA(Integer IDTIPOZONA) {
		this.IDTIPOZONA = IDTIPOZONA;
	}

	public Integer getIDTIPOZONA() {
		return this.IDTIPOZONA;
	}

	public void setIDUNIDADMEDIDA(Integer IDUNIDADMEDIDA) {
		this.IDUNIDADMEDIDA = IDUNIDADMEDIDA;
	}

	public Integer getIDUNIDADMEDIDA() {
		return this.IDUNIDADMEDIDA;
	}

	public void setAREA(Float AREA) {
		this.AREA = AREA;
	}

	public Float getAREA() {
		return this.AREA;
	}

	public void setAREAUNIDADDIAGRAMA(Integer AREAUNIDADDIAGRAMA) {
		this.AREAUNIDADDIAGRAMA = AREAUNIDADDIAGRAMA;
	}

	public Integer getAREAUNIDADDIAGRAMA() {
		return this.AREAUNIDADDIAGRAMA;
	}

	public void setLARGOUNIDADDIAGRAMA(Integer LARGOUNIDADDIAGRAMA) {
		this.LARGOUNIDADDIAGRAMA = LARGOUNIDADDIAGRAMA;
	}

	public Integer getLARGOUNIDADDIAGRAMA() {
		return this.LARGOUNIDADDIAGRAMA;
	}

	public void setANCHOUNIDADDIAGRAMA(Integer ANCHOUNIDADDIAGRAMA) {
		this.ANCHOUNIDADDIAGRAMA = ANCHOUNIDADDIAGRAMA;
	}

	public Integer getANCHOUNIDADDIAGRAMA() {
		return this.ANCHOUNIDADDIAGRAMA;
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

	public void setSINCRONIZA(Integer SINCRONIZA) {
		this.SINCRONIZA = SINCRONIZA;
	}

	public Integer getSINCRONIZA() {
		return this.SINCRONIZA;
	}

	public String getTIPO() {
		return TIPO;
	}

	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}
	
	public void setCOLOR(String COLOR) {
		this.COLOR = COLOR;
	}

	public String getCOLOR() {
		return this.COLOR;
	}

	public Integer getIDPROCESO() {
		return IDPROCESO;
	}

	public void setIDPROCESO(Integer iDPROCESO) {
		IDPROCESO = iDPROCESO;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDZONA + ", " + DESCRIPCION + ", " + IDTIPOZONA + ", "
				+ IDUNIDADMEDIDA + ", " + AREA + ", " + AREAUNIDADDIAGRAMA + ", " + LARGOUNIDADDIAGRAMA + ", "
				+ ANCHOUNIDADDIAGRAMA + ", " + FECHACREACION + ", " + (ESTADO==null?"Null":ESTADO) + ", " + SINCRONIZA + ", " + COLOR + ", "
				+ IDPROCESO==null?"null":IDPROCESO + "]";
	}


	/* Sets & Gets FK*/

}