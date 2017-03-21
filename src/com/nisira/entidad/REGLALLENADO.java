package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.io.Serializable;
import java.util.Date;

@Tabla(nombre = "REGLALLENADO")
public class REGLALLENADO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -641870804490564914L;
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private String IDREGLAS;
	@Columna
	private Integer IDPROCESO;
	@Columna
	private Integer ESTADO;
	@Columna
	private Date FECHACREACION;
	@Columna
	private String DESCRIPCION;



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

	public void setIDREGLAS(String IDREGLAS) {
		this.IDREGLAS = IDREGLAS;
	}

	public String getIDREGLAS() {
		return this.IDREGLAS;
	}

	public void setIDPROCESO(Integer IDPROCESO) {
		this.IDPROCESO = IDPROCESO;
	}

	public Integer getIDPROCESO() {
		return this.IDPROCESO;
	}

	public void setESTADO(Integer ESTADO) {
		this.ESTADO = ESTADO;
	}

	public Integer getESTADO() {
		return this.ESTADO;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	public void setDESCRIPCION(String DESCRIPCION) {
		this.DESCRIPCION = DESCRIPCION;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDREGLAS + ", " + (IDPROCESO==null?"Null":IDPROCESO) + ", " + (ESTADO==null?"Null":ESTADO) + ", "
				+ FECHACREACION + ", " + DESCRIPCION + "]";
	}



	/* Sets & Gets FK*/

}