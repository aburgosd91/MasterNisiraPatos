package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "DACCIONESVISTA")
public class DACCIONESVISTA {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDACCION;
	@ClavePrimaria
	@Columna
	private String VISTA;
	@Columna
	private Integer ORDEN;
	@Columna
	private Date FECHACREACION;



	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIdempresa() {
		return this.IDEMPRESA;
	}

	public void setIDACCION(Integer IDACCION) {
		this.IDACCION = IDACCION;
	}

	public Integer getIDACCION() {
		return this.IDACCION;
	}

	public void setVISTA(String VISTA) {
		this.VISTA = VISTA;
	}

	public String getVISTA() {
		return this.VISTA;
	}

	public void setORDEN(Integer ORDEN) {
		this.ORDEN = ORDEN;
	}

	public Integer getORDEN() {
		return this.ORDEN;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDACCION + ", " 
				+ VISTA + ", " + ORDEN + ", " + FECHACREACION + "]";
	}



	/* Sets & Gets FK*/

}