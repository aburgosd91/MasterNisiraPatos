package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.sql.Timestamp;
import java.util.Date;

@Tabla(nombre = "DALMACEN_RACKS")
public class DALMACEN_RACKS {
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
	private Integer IDRACK;
	@Columna
	private String IDUBICACION;
	@Columna
	private Integer IDTIPORACKS;
	@Columna
	private String ITEM;
	@Columna
	private String TIPOUBICACION;
	@Columna
	private String CODIGOCLIENTE;
	@Columna
	private Integer ESTADO;
	@Columna
	private Integer SINCRONIZA;
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

	public void setIDRACK(Integer IDRACK) {
		this.IDRACK = IDRACK;
	}

	public Integer getIDRACK() {
		return this.IDRACK;
	}

	public void setIDUBICACION(String IDUBICACION) {
		this.IDUBICACION = IDUBICACION;
	}

	public String getIDUBICACION() {
		return this.IDUBICACION;
	}

	public void setIDTIPORACKS(Integer IDTIPORACKS) {
		this.IDTIPORACKS = IDTIPORACKS;
	}

	public Integer getIDTIPORACKS() {
		return this.IDTIPORACKS;
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

	@Override
	public String toString() {
		return "[" + IDEMPRESA + "," + IDSUCURSAL + "," + IDALMACEN + "," + IDDISTRIBUCION + "," + IDRACK + ","
				+ IDUBICACION + "," + (IDTIPORACKS==null?"Null":IDTIPORACKS) + "," + ITEM.trim() + "," + TIPOUBICACION + "," + CODIGOCLIENTE + ","
				+ (ESTADO==null?"Null":ESTADO) + "," + (SINCRONIZA==null?"Null":SINCRONIZA) + "," + FECHACREACION + "]";
	}
	


	/* Sets & Gets FK*/

}