package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "PROGRAMACIONTAREA")
public class PROGRAMACIONTAREA {
	@Columna
	private Integer IDEMPRESA;
	@Columna
	private Integer IDSUCURSAL;
	@Columna
	private String IDPROGRAMACIONTAREA;
	@Columna
	private Integer IDPROCESO;
	@Columna
	private String IDDOCUMENTO;
	@Columna
	private String SERIE;
	@Columna
	private String NUMERO;
	@Columna
	private Integer TIPOTAREA;
	@Columna
	private Integer GENERACION;
	@Columna
	private Integer IDMONTACARGA;
	@Columna
	private String OBSERVACION;
	@Columna
	private Date FECHAPROGRAMACION;
	@Columna
	private Date FECHAEJECUCION;
	@Columna
	private Date FECHAFINALIZACION;
	@Columna
	private Integer ESTADO;
	@Columna
	private String USRCREACION;
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

	public void setIDPROGRAMACIONTAREA(String IDPROGRAMACIONTAREA) {
		this.IDPROGRAMACIONTAREA = IDPROGRAMACIONTAREA;
	}

	public String getIDPROGRAMACIONTAREA() {
		return this.IDPROGRAMACIONTAREA;
	}

	public void setIDPROCESO(Integer IDPROCESO) {
		this.IDPROCESO = IDPROCESO;
	}

	public Integer getIDPROCESO() {
		return this.IDPROCESO;
	}

	public void setIDDOCUMENTO(String IDDOCUMENTO) {
		this.IDDOCUMENTO = IDDOCUMENTO;
	}

	public String getIDDOCUMENTO() {
		return this.IDDOCUMENTO;
	}

	public void setSERIE(String SERIE) {
		this.SERIE = SERIE;
	}

	public String getSERIE() {
		return this.SERIE;
	}

	public void setNUMERO(String NUMERO) {
		this.NUMERO = NUMERO;
	}

	public String getNUMERO() {
		return this.NUMERO;
	}

	public void setTIPOTAREA(Integer TIPOTAREA) {
		this.TIPOTAREA = TIPOTAREA;
	}

	public Integer getTIPOTAREA() {
		return this.TIPOTAREA;
	}

	public void setGENERACION(Integer GENERACION) {
		this.GENERACION = GENERACION;
	}

	public Integer getGENERACION() {
		return this.GENERACION;
	}

	public Integer getIDMONTACARGA() {
		return IDMONTACARGA;
	}

	public void setIDMONTACARGA(Integer iDMONTACARGA) {
		IDMONTACARGA = iDMONTACARGA;
	}

	public void setOBSERVACION(String OBSERVACION) {
		this.OBSERVACION = OBSERVACION;
	}

	public String getOBSERVACION() {
		return this.OBSERVACION;
	}

	public void setFECHAPROGRAMACION(Date FECHAPROGRAMACION) {
		this.FECHAPROGRAMACION = FECHAPROGRAMACION;
	}

	public Date getFECHAPROGRAMACION() {
		return this.FECHAPROGRAMACION;
	}

	public void setFECHAEJECUCION(Date FECHAEJECUCION) {
		this.FECHAEJECUCION = FECHAEJECUCION;
	}

	public Date getFECHAEJECUCION() {
		return this.FECHAEJECUCION;
	}

	public void setFECHAFINALIZACION(Date FECHAFINALIZACION) {
		this.FECHAFINALIZACION = FECHAFINALIZACION;
	}

	public Date getFECHAFINALIZACION() {
		return this.FECHAFINALIZACION;
	}

	public void setESTADO(Integer ESTADO) {
		this.ESTADO = ESTADO;
	}

	public Integer getESTADO() {
		return this.ESTADO;
	}

	public void setUSRCREACION(String USRCREACION) {
		this.USRCREACION = USRCREACION;
	}

	public String getUSRCREACION() {
		return this.USRCREACION;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}



	/* Sets & Gets FK*/

}