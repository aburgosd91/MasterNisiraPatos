package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "DALMACENDIAGRAMA")
public class DALMACENDIAGRAMA {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private Integer IDALMACEN;
	@Columna
	private String IDDISTRIBUCION;
	@ClavePrimaria
	@Columna
	private Integer CORDENADAX;
	@ClavePrimaria
	@Columna
	private Integer CORDENADAY;
	@Columna
	private Integer IDRACK;
	@Columna
	private String COLORHEXADECIMAL;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer ESTADO;
	@Columna
	private String SINCRONIZA;


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

	public void setCORDENADAX(Integer CORDENADAX) {
		this.CORDENADAX = CORDENADAX;
	}

	public Integer getCORDENADAX() {
		return this.CORDENADAX;
	}

	public void setCORDENADAY(Integer CORDENADAY) {
		this.CORDENADAY = CORDENADAY;
	}

	public Integer getCORDENADAY() {
		return this.CORDENADAY;
	}

	public void setIDRACK(Integer IDRACK) {
		this.IDRACK = IDRACK;
	}

	public Integer getIDRACK() {
		return this.IDRACK;
	}

	public void setCOLORHEXADECIMAL(String COLORHEXADECIMAL) {
		this.COLORHEXADECIMAL = COLORHEXADECIMAL;
	}

	public String getCOLORHEXADECIMAL() {
		return this.COLORHEXADECIMAL;
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

	public String getSINCRONIZA() {
		return SINCRONIZA;
	}

	public void setSINCRONIZA(String sINCRONIZA) {
		SINCRONIZA = sINCRONIZA;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDALMACEN + ", " + IDDISTRIBUCION + ", " + CORDENADAX + ", "
				+ CORDENADAY + ", " + (IDRACK==null?0:IDRACK) + ", " + COLORHEXADECIMAL + ", " + FECHACREACION + ", " + (ESTADO==null?0:ESTADO) + ", "
				+ SINCRONIZA + "]";
	}
	


	/* Sets & Gets FK*/

}