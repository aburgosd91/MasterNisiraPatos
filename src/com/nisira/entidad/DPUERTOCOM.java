package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Date;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.CampoRelacionado;

@Tabla(nombre = "DPUERTOCOM")
public class DPUERTOCOM {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDEQUIPOREADER;
	@ClavePrimaria
	@Columna
	private Integer IDPUERTOCOM;
	@Columna
	private Integer ORDEN;
	@Columna
	private Integer ACTIVO;
	@Columna
	private Date FECHACREACION;
	@XStreamOmitField
	@CampoRelacionado({@RelacionTabla(campo="IDEMPRESA",campoRelacionado="IDEMPRESA"), @RelacionTabla(campo="IDPUERTOCOM",campoRelacionado="IDPUERTOCOM")})
	private PUERTOCOM puertocom_fk_dpuertocom_puertocom;
	@XStreamOmitField
	@CampoRelacionado({@RelacionTabla(campo="IDEMPRESA",campoRelacionado="IDEMPRESA"), @RelacionTabla(campo="IDEQUIPOREADER",campoRelacionado="IDEQUIPOREADER")})
	private RFIDREADER rfidreader_fk_dpuertocom_rfidreader;
	@XStreamOmitField
	private String Descripcion;

	/* Sets & Gets */

	/* Sets & Gets FK*/
	public void setPuertocom_fk_dpuertocom_puertocom(PUERTOCOM puertocom_fk_dpuertocom_puertocom) {
		this.puertocom_fk_dpuertocom_puertocom = puertocom_fk_dpuertocom_puertocom;
	}

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

	public Integer getIDPUERTOCOM() {
		return IDPUERTOCOM;
	}

	public void setIDPUERTOCOM(Integer iDPUERTOCOM) {
		IDPUERTOCOM = iDPUERTOCOM;
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

	public PUERTOCOM getPuertocom_fk_dpuertocom_puertocom() {
		return this.puertocom_fk_dpuertocom_puertocom;
	}

	public void setRfidreader_fk_dpuertocom_rfidreader(RFIDREADER rfidreader_fk_dpuertocom_rfidreader) {
		this.rfidreader_fk_dpuertocom_rfidreader = rfidreader_fk_dpuertocom_rfidreader;
	}

	public RFIDREADER getRfidreader_fk_dpuertocom_rfidreader() {
		return this.rfidreader_fk_dpuertocom_rfidreader;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDEQUIPOREADER + ", " + IDPUERTOCOM + ", " + ORDEN + ", " + ACTIVO + ", "
				+ FECHACREACION + "]";
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}


}