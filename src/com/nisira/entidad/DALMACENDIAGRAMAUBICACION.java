package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "DALMACENDIAGRAMAUBICACION")
public class DALMACENDIAGRAMAUBICACION {
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
	private Integer CORDENADAX;
	@ClavePrimaria
	@Columna
	private Integer CORDENADAY;
	@ClavePrimaria
	@Columna
	private String IDUBICACION;
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

	public void setIDUBICACION(String IDUBICACION) {
		this.IDUBICACION = IDUBICACION;
	}

	public String getIDUBICACION() {
		return this.IDUBICACION;
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
		return "[" + IDEMPRESA + "," + IDSUCURSAL + "," + IDALMACEN + "," + IDDISTRIBUCION + "," + CORDENADAX + ","
				+ CORDENADAY + "," + IDUBICACION + "," + FECHACREACION + "," + (SINCRONIZA==null?0:SINCRONIZA) + "]";
	}
	

	/* Sets & Gets FK*/

}