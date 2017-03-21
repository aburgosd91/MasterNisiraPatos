package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "PROCESOS")
public class PROCESOS {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDPROCESO;
	@Columna
	private String DESCRIPCION;
	@Columna
	private Date FECHAINICIO;
	@Columna
	private Date FECHAFIN;
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

	public void setIDPROCESO(Integer IDPROCESO) {
		this.IDPROCESO = IDPROCESO;
	}

	public Integer getIDPROCESO() {
		return this.IDPROCESO;
	}

	public void setDESCRIPCION(String DESCRIPCION) {
		this.DESCRIPCION = DESCRIPCION;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
	}

	public void setFECHAINICIO(Date FECHAINICIO) {
		this.FECHAINICIO = FECHAINICIO;
	}

	public Date getFECHAINICIO() {
		return this.FECHAINICIO;
	}

	public void setFECHAFIN(Date FECHAFIN) {
		this.FECHAFIN = FECHAFIN;
	}

	public Date getFECHAFIN() {
		return this.FECHAFIN;
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
		return "[" + IDEMPRESA + ", " + IDPROCESO + ", " + DESCRIPCION + ", " + FECHAINICIO + ", "
				+ FECHAFIN + ", " + FECHACREACION + ", " + (ESTADO==null?"Null":ESTADO) + "]";
	}



	/* Sets & Gets FK*/

}