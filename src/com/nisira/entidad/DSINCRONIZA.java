package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "DSINCRONIZA")
public class DSINCRONIZA {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private Integer IDSINCRONIZA;
	@ClavePrimaria
	@Columna
	private String IDUSUARIO;
	@ClavePrimaria
	@Columna
	private Integer IDDSINCRONIZA;
	@Columna
	private String TABLA;
	@Columna
	private Integer PENDIENTES;
	@Columna
	private Integer AFECTADOS;
	@Columna
	private Date FECHACREACION;



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

	public void setIDSINCRONIZA(Integer IDSINCRONIZA) {
		this.IDSINCRONIZA = IDSINCRONIZA;
	}

	public Integer getIDSINCRONIZA() {
		return this.IDSINCRONIZA;
	}

	public void setIDUSUARIO(String IDUSUARIO) {
		this.IDUSUARIO = IDUSUARIO;
	}

	public String getIDUSUARIO() {
		return this.IDUSUARIO;
	}

	public void setIDDSINCRONIZA(Integer IDDSINCRONIZA) {
		this.IDDSINCRONIZA = IDDSINCRONIZA;
	}

	public Integer getIDDSINCRONIZA() {
		return this.IDDSINCRONIZA;
	}

	public void setTABLA(String TABLA) {
		this.TABLA = TABLA;
	}

	public String getTABLA() {
		return this.TABLA;
	}

	public void setPENDIENTES(Integer PENDIENTES) {
		this.PENDIENTES = PENDIENTES;
	}

	public Integer getPENDIENTES() {
		return this.PENDIENTES;
	}

	public void setAFECTADOS(Integer AFECTADOS) {
		this.AFECTADOS = AFECTADOS;
	}

	public Integer getAFECTADOS() {
		return this.AFECTADOS;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}



	/* Sets & Gets FK*/

}