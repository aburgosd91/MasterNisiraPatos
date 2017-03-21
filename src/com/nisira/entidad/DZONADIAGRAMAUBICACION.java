package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.sql.Timestamp;
import java.util.Date;

@Tabla(nombre = "DZONADIAGRAMAUBICACION")
public class DZONADIAGRAMAUBICACION {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDZONA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
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
	private Integer IDACCESORIO;
	@Columna
	private Integer IDALMACEN;
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

	public void setIDZONA(Integer IDZONA) {
		this.IDZONA = IDZONA;
	}

	public Integer getIDZONA() {
		return this.IDZONA;
	}

	public void setIDSUCURSAL(Integer IDSUCURSAL) {
		this.IDSUCURSAL = IDSUCURSAL;
	}

	public Integer getIDSUCURSAL() {
		return this.IDSUCURSAL;
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

	public void setIDACCESORIO(Integer IDACCESORIO) {
		this.IDACCESORIO = IDACCESORIO;
	}

	public Integer getIDACCESORIO() {
		return this.IDACCESORIO;
	}

	public void setIDALMACEN(Integer IDALMACEN) {
		this.IDALMACEN = IDALMACEN;
	}

	public Integer getIDALMACEN() {
		return this.IDALMACEN;
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
		return "[" + IDEMPRESA + ", " + IDZONA + ", " + IDSUCURSAL + ", " + CORDENADAX + ", " + CORDENADAY + ", "
				+ IDUBICACION + ", " + (IDACCESORIO==null?"Null":IDACCESORIO) + ", " + (IDALMACEN==null?"Null":IDALMACEN) + ", " + FECHACREACION + ", " + (SINCRONIZA==null?"Null":SINCRONIZA) + "]";
	}



	/* Sets & Gets FK*/

}