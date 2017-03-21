package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.sql.Timestamp;
import java.util.Date;

@Tabla(nombre = "DALMACEN_COLUMNAS")
public class DALMACEN_COLUMNAS {
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
	@ClavePrimaria
	@Columna
	private String IDRACK;
	@ClavePrimaria
	@Columna
	private String IDPISO;
	@ClavePrimaria
	@Columna
	private String IDFILA;
	@ClavePrimaria
	@Columna
	private String IDCOLUMNA;
	@Columna
	private String IDUBICACION;
	@Columna
	private String ITEMFILA;
	@Columna
	private String ITEMPISO;
	@Columna
	private String ITEMRACK;
	@Columna
	private String ITEM;
	@Columna
	private String TIPOUBICACION;
	@Columna
	private String CODIGOCLIENTE;
	@Columna
	private Integer ESTADO;
	@Columna
	private Date FECHACREACION;
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

	public void setIDRACK(String IDRACK) {
		this.IDRACK = IDRACK;
	}

	public String getIDRACK() {
		return this.IDRACK;
	}

	public void setIDPISO(String IDPISO) {
		this.IDPISO = IDPISO;
	}

	public String getIDPISO() {
		return this.IDPISO;
	}

	public void setIDFILA(String IDFILA) {
		this.IDFILA = IDFILA;
	}

	public String getIDFILA() {
		return this.IDFILA;
	}

	public void setIDCOLUMNA(String IDCOLUMNA) {
		this.IDCOLUMNA = IDCOLUMNA;
	}

	public String getIDCOLUMNA() {
		return this.IDCOLUMNA;
	}

	public void setIDUBICACION(String IDUBICACION) {
		this.IDUBICACION = IDUBICACION;
	}

	public String getIDUBICACION() {
		return this.IDUBICACION;
	}

	public void setITEMFILA(String ITEMFILA) {
		this.ITEMFILA = ITEMFILA;
	}

	public String getITEMFILA() {
		return this.ITEMFILA;
	}

	public void setITEMPISO(String ITEMPISO) {
		this.ITEMPISO = ITEMPISO;
	}

	public String getITEMPISO() {
		return this.ITEMPISO;
	}

	public void setITEMRACK(String ITEMRACK) {
		this.ITEMRACK = ITEMRACK;
	}

	public String getITEMRACK() {
		return this.ITEMRACK;
	}

	public void setITEM(String ITEM) {
		this.ITEM = ITEM;
	}

	public String getITEM() {
		return this.ITEM;
	}

	public void setTIPOUBICACION(String TIPOUBICACION) {
		this.TIPOUBICACION = TIPOUBICACION;
	}

	public String getTIPOUBICACION() {
		return this.TIPOUBICACION;
	}

	public void setCODIGOCLIENTE(String CODIGOCLIENTE) {
		this.CODIGOCLIENTE = CODIGOCLIENTE;
	}

	public String getCODIGOCLIENTE() {
		return this.CODIGOCLIENTE;
	}

	public void setESTADO(Integer ESTADO) {
		this.ESTADO = ESTADO;
	}

	public Integer getESTADO() {
		return this.ESTADO;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	public void setSINCRONIZA(Integer SINCRONIZA) {
		this.SINCRONIZA = SINCRONIZA;
	}

	public Integer getSINCRONIZA() {
		return this.SINCRONIZA;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + "," + IDSUCURSAL + "," + IDALMACEN + "," + IDDISTRIBUCION + "," + IDRACK.trim() + ","
				+ IDPISO.trim() + "," + IDFILA.trim() + "," + IDCOLUMNA.trim() + "," + IDUBICACION + "," + ITEMFILA.trim() + "," + ITEMPISO.trim()
				+ "," + ITEMRACK.trim() + "," + ITEM.trim() + "," + TIPOUBICACION + "," + CODIGOCLIENTE + "," + (ESTADO==null?"Null":ESTADO) + ","
				+ FECHACREACION + "," + (SINCRONIZA==null?"Null":SINCRONIZA) + "]";
	}
	


	/* Sets & Gets FK*/

}