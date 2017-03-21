package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.CampoRelacionado;

@Tabla(nombre = "NOTIFICACION")
public class NOTIFICACION {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDNOTIFICACION;
	@Columna
	private String MENSAJE;
	@Columna
	private String TOQUEN;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer PRIORIDAD;
	@Columna
	private Integer ESTADO;
	@Columna
	private String MODO;
	@Columna
	private Integer MESTADO;
	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDNOTIFICACION(Integer IDNOTIFICACION) {
		this.IDNOTIFICACION = IDNOTIFICACION;
	}

	public Integer getIDNOTIFICACION() {
		return this.IDNOTIFICACION;
	}

	public void setMENSAJE(String MENSAJE) {
		this.MENSAJE = MENSAJE;
	}

	public String getMENSAJE() {
		return this.MENSAJE;
	}

	public void setTOQUEN(String TOQUEN) {
		this.TOQUEN = TOQUEN;
	}

	public String getTOQUEN() {
		return this.TOQUEN;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	public void setPRIORIDAD(Integer PRIORIDAD) {
		this.PRIORIDAD = PRIORIDAD;
	}

	public Integer getPRIORIDAD() {
		return this.PRIORIDAD;
	}

	public void setESTADO(Integer ESTADO) {
		this.ESTADO = ESTADO;
	}

	public Integer getESTADO() {
		return this.ESTADO;
	}

	public void setMODO(String MODO) {
		this.MODO = MODO;
	}

	public String getMODO() {
		return this.MODO;
	}
	
	public Integer getMESTADO() {
		return MESTADO;
	}

	public void setMESTADO(Integer mESTADO) {
		MESTADO = mESTADO;
	}
	
	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDNOTIFICACION + ", " + MENSAJE + ", " + TOQUEN + ", " + FECHACREACION + ", "
				+ PRIORIDAD + ", " + ESTADO + ", " + MODO+ ", " + MESTADO + "]";
	}

}