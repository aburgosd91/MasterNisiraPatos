package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "DMONTACARGAEQUIPO")
public class DMONTACARGAEQUIPO {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDMONTACARGA;
	@ClavePrimaria
	@Columna
	private Integer IDEQUIPO;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer ESTADO;
	@Columna
	private String CODIGOEQUIVALENTE;



	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDMONTACARGA(Integer IDMONTACARGA) {
		this.IDMONTACARGA = IDMONTACARGA;
	}

	public Integer getIDMONTACARGA() {
		return this.IDMONTACARGA;
	}

	public void setIDEQUIPO(Integer IDEQUIPO) {
		this.IDEQUIPO = IDEQUIPO;
	}

	public Integer getIDEQUIPO() {
		return this.IDEQUIPO;
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

	public void setCODIGOEQUIVALENTE(String CODIGOEQUIVALENTE) {
		this.CODIGOEQUIVALENTE = CODIGOEQUIVALENTE;
	}

	public String getCODIGOEQUIVALENTE() {
		return this.CODIGOEQUIVALENTE;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDMONTACARGA + ", " + IDEQUIPO + ", " + FECHACREACION + ", " + (ESTADO==null?"Null":ESTADO) + ", "
				+ CODIGOEQUIVALENTE + "]";
	}
	


	/* Sets & Gets FK*/

}