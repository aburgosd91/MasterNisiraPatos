package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "ENVIONOTIFICACION")
public class ENVIONOTIFICACION {
	@Columna
	private Integer IDEMPRESA;
	@Columna
	private String IDENVIONOTIFICACION;
	@Columna
	private Integer IDNOTIFICACION;
	@Columna
	private Integer IDMONTACARGA;
	@Columna
	private Date FECHAENVIO;
	@Columna
	private Date FECHARECEPCION;
	@Columna
	private Date FECHACREACION;



	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDENVIONOTIFICACION(String IDENVIONOTIFICACION) {
		this.IDENVIONOTIFICACION = IDENVIONOTIFICACION;
	}

	public String getIDENVIONOTIFICACION() {
		return this.IDENVIONOTIFICACION;
	}

	public void setIDNOTIFICACION(Integer IDNOTIFICACION) {
		this.IDNOTIFICACION = IDNOTIFICACION;
	}

	public Integer getIDNOTIFICACION() {
		return this.IDNOTIFICACION;
	}

	public void setIDMONTACARGA(Integer IDMONTACARGA) {
		this.IDMONTACARGA = IDMONTACARGA;
	}

	public Integer getIDMONTACARGA() {
		return this.IDMONTACARGA;
	}

	public void setFECHAENVIO(Date FECHAENVIO) {
		this.FECHAENVIO = FECHAENVIO;
	}

	public Date getFECHAENVIO() {
		return this.FECHAENVIO;
	}

	public void setFECHARECEPCION(Date FECHARECEPCION) {
		this.FECHARECEPCION = FECHARECEPCION;
	}

	public Date getFECHARECEPCION() {
		return this.FECHARECEPCION;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	/* Sets & Gets FK*/
	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDENVIONOTIFICACION + ", " + IDNOTIFICACION + ", " + IDMONTACARGA + ", "
				+ FECHAENVIO + ", " + FECHARECEPCION + ", " + FECHACREACION + "]";
	}
	
}