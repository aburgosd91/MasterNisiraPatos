package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.CampoRelacionado;

@Tabla(nombre = "DPROGRAMAALMMONTACARGANOTIFICACION")
public class DPROGRAMAALMMONTACARGANOTIFICACION {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDPROGRAMAALM;
	@ClavePrimaria
	@Columna
	private Integer IDMONTACARGA;
	@ClavePrimaria
	@Columna
	private Integer IDNOTIFICACION;
	@Columna
	private Date FECHARECEPCION;
	@Columna
	private Date FECHALECTURA;
	@Columna
	private Integer ESTADO;
	@Columna
	private Integer SINCRONIZA;
	@Columna
	private Date FECHACREACION;


	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDPROGRAMAALM(Integer IDPROGRAMAALM) {
		this.IDPROGRAMAALM = IDPROGRAMAALM;
	}

	public Integer getIDPROGRAMAALM() {
		return this.IDPROGRAMAALM;
	}

	public void setIDMONTACARGA(Integer IDMONTACARGA) {
		this.IDMONTACARGA = IDMONTACARGA;
	}

	public Integer getIDMONTACARGA() {
		return this.IDMONTACARGA;
	}

	public void setIDNOTIFICACION(Integer IDNOTIFICACION) {
		this.IDNOTIFICACION = IDNOTIFICACION;
	}

	public Integer getIDNOTIFICACION() {
		return this.IDNOTIFICACION;
	}

	public void setFECHARECEPCION(Date FECHARECEPCION) {
		this.FECHARECEPCION = FECHARECEPCION;
	}

	public Date getFECHARECEPCION() {
		return this.FECHARECEPCION;
	}

	public void setFECHALECTURA(Date FECHALECTURA) {
		this.FECHALECTURA = FECHALECTURA;
	}

	public Date getFECHALECTURA() {
		return this.FECHALECTURA;
	}

	public void setESTADO(Integer ESTADO) {
		this.ESTADO = ESTADO;
	}

	public Integer getESTADO() {
		return this.ESTADO;
	}

	public void setSINCRONIZA(Integer SINCRONIZA) {
		this.SINCRONIZA = SINCRONIZA;
	}

	public Integer getSINCRONIZA() {
		return this.SINCRONIZA;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDPROGRAMAALM + ", " + IDMONTACARGA + ", " + IDNOTIFICACION + ", "
				+ FECHARECEPCION + ", " + FECHALECTURA + ", " + (ESTADO==null?"Null":ESTADO) + ", " + SINCRONIZA==null?"Null":SINCRONIZA + ", " + FECHACREACION + "]";
	}
	


	/* Sets & Gets FK*/



}