package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Date;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.CampoRelacionado;

@Tabla(nombre = "DANTENA")
public class DANTENA {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDEQUIPOREADER;
	@ClavePrimaria
	@Columna
	private Integer IDANTENA;
	@Columna
	private Integer ORDEN;
	@Columna
	private Integer ACTIVO;
	@Columna
	private Date FECHACREACION;
	@XStreamOmitField
	@CampoRelacionado({@RelacionTabla(campo="IDEMPRESA",campoRelacionado="IDEMPRESA"), @RelacionTabla(campo="IDANTENA",campoRelacionado="IDEQUIPO")})
	private EQUIPO equipo_fk_dantena_equipo;
	@XStreamOmitField
	@CampoRelacionado({@RelacionTabla(campo="IDEMPRESA",campoRelacionado="IDEMPRESA"), @RelacionTabla(campo="IDEQUIPOREADER",campoRelacionado="IDEQUIPOREADER")})
	private RFIDREADER rfidreader_fk_dantena_rfidreader;
	@XStreamOmitField
	private String Descripcion;
	public Integer getIDEMPRESA() {
		return IDEMPRESA;
	}

	public void setIDEMPRESA(Integer iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}

	public Integer getIDEQUIPOREADER() {
		return IDEQUIPOREADER;
	}

	public void setIDEQUIPOREADER(Integer iDEQUIPOREADER) {
		IDEQUIPOREADER = iDEQUIPOREADER;
	}

	public Integer getIDANTENA() {
		return this.IDANTENA;
	}

	public void setIDANTENA(Integer IDANTENA) {
		this.IDANTENA = IDANTENA;
	}

	public Integer getORDEN() {
		return ORDEN;
	}

	public void setORDEN(Integer oRDEN) {
		ORDEN = oRDEN;
	}

	public Integer getACTIVO() {
		return ACTIVO;
	}

	public void setACTIVO(Integer aCTIVO) {
		ACTIVO = aCTIVO;
	}

	public Date getFECHACREACION() {
		return FECHACREACION;
	}

	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}

	/* Sets & Gets FK*/
	public void setEquipo_fk_dantena_equipo(EQUIPO equipo_fk_dantena_equipo) {
		this.equipo_fk_dantena_equipo = equipo_fk_dantena_equipo;
	}

	public EQUIPO getEquipo_fk_dantena_equipo() {
		return this.equipo_fk_dantena_equipo;
	}

	public void setRfidreader_fk_dantena_rfidreader(RFIDREADER rfidreader_fk_dantena_rfidreader) {
		this.rfidreader_fk_dantena_rfidreader = rfidreader_fk_dantena_rfidreader;
	}

	public RFIDREADER getRfidreader_fk_dantena_rfidreader() {
		return this.rfidreader_fk_dantena_rfidreader;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDEQUIPOREADER + ", " + IDANTENA + ", " + ORDEN + ", " + ACTIVO + ", "
				+ FECHACREACION + "]";
	}


}