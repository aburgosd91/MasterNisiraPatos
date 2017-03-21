package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.sql.Timestamp;
import java.util.Date;

@Tabla(nombre = "ACTIVIDADES")
public class ACTIVIDADES {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDACTIVIDADES;
	@Columna
	private String DESCRIPCION;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer ESTADO;
	@Columna
	private String ICONO;
	
	private String TIPO;
	


	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDACTIVIDADES(Integer IDACTIVIDADES) {
		this.IDACTIVIDADES = IDACTIVIDADES;
	}

	public Integer getIDACTIVIDADES() {
		return this.IDACTIVIDADES;
	}

	public void setDESCRIPCION(String DESCRIPCION) {
		this.DESCRIPCION = DESCRIPCION;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
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
	
	public String getTIPO() {
		return TIPO;
	}

	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}
	
	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDACTIVIDADES + ", " + DESCRIPCION + ", " + FECHACREACION + ", " + (ESTADO==null?"Null":ESTADO) 
					+ ", " + TIPO + "]";
	}

	public String getICONO() {
		return ICONO;
	}

	public void setICONO(String iCONO) {
		ICONO = iCONO;
	}

	
	


	/* Sets & Gets FK*/

}