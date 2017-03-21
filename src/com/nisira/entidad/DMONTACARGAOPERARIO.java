package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "DMONTACARGAOPERARIO")
public class DMONTACARGAOPERARIO {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDMONTACARGA;
	@ClavePrimaria
	@Columna
	private String IDOPERARIO;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer ESTADO;



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

	public void setIDOPERARIO(String IDOPERARIO) {
		this.IDOPERARIO = IDOPERARIO;
	}

	public String getIDOPERARIO() {
		return this.IDOPERARIO;
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

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDMONTACARGA + ", " + IDOPERARIO + ", " + FECHACREACION + ", " + (ESTADO==null?"Null":ESTADO) + "]";
	}
	


	/* Sets & Gets FK*/

}