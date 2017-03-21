package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.sql.Timestamp;
import java.util.Date;

@Tabla(nombre = "ALMACEN")
public class ALMACEN {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private Integer IDALMACEN;

	private String SUCURSAL;
	@Columna
	private String DESCRIPCION;
	@Columna
	private String DIRECCION;
	@Columna
	private String IDTIPOALMACEN;
	@Columna
	private Integer ESTADO;
	@Columna
	private Integer SINCRONIZA;
	@Columna
	private Date FECHACREACION;
	@Columna
	private String NOMBRE_CORTO;


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

	public void setDESCRIPCION(String DESCRIPCION) {
		this.DESCRIPCION = DESCRIPCION;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
	}

	public void setDIRECCION(String DIRECCION) {
		this.DIRECCION = DIRECCION;
	}

	public String getDIRECCION() {
		return this.DIRECCION;
	}

	public void setIDTIPOALMACEN(String IDTIPOALMACEN) {
		this.IDTIPOALMACEN = IDTIPOALMACEN;
	}

	public String getIDTIPOALMACEN() {
		return this.IDTIPOALMACEN;
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

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	public void setNOMBRE_CORTO(String NOMBRE_CORTO) {
		this.NOMBRE_CORTO = NOMBRE_CORTO;
	}

	public String getNOMBRE_CORTO() {
		return this.NOMBRE_CORTO;
	}
	
	/* Sets & Gets FK*/

	public String getSUCURSAL() {
		return SUCURSAL;
	}

	public void setSUCURSAL(String sUCURSAL) {
		SUCURSAL = sUCURSAL;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + "," + IDSUCURSAL + "," + IDALMACEN + "," + DESCRIPCION + ","
				+ DIRECCION + "," + IDTIPOALMACEN.trim() + "," + (ESTADO==null?"Null":ESTADO) + "," + (SINCRONIZA==null?"Null":SINCRONIZA) + "," + FECHACREACION + ","
				+ NOMBRE_CORTO + "]";
	}
	
}