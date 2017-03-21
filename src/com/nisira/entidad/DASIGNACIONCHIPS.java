package com.nisira.entidad;

import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "DASIGNACIONCHIPS")
public class DASIGNACIONCHIPS {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private String IDASIGNACIONCHIPS;
	@ClavePrimaria
	@Columna
	private Integer IDZONA;
	@ClavePrimaria
	@Columna
	private Integer CORDENADAX;
	@ClavePrimaria
	@Columna
	private Integer CORDENADAY;
	@ClavePrimaria
	@Columna
	private String IDUBICACION;
	@Columna
	private Integer CORDENADAXT;
	@Columna
	private Integer CORDENADAYT;
	@Columna
	private Integer ESTADOASIGNACION;
	@ClavePrimaria
	@Columna
	private String SERIECHIP;
	@Columna
	private String POSICION;
	@Columna
	private String DESCRIPCION;
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

	public void setIDASIGNACIONCHIPS(String IDASIGNACIONCHIPS) {
		this.IDASIGNACIONCHIPS = IDASIGNACIONCHIPS;
	}

	public String getIDASIGNACIONCHIPS() {
		return this.IDASIGNACIONCHIPS;
	}

	public void setIDZONA(Integer IDZONA) {
		this.IDZONA = IDZONA;
	}

	public Integer getIDZONA() {
		return this.IDZONA;
	}

	public void setCORDENADAX(Integer CORDENADAX) {
		this.CORDENADAX = CORDENADAX;
	}

	public Integer getCORDENADAX() {
		return this.CORDENADAX;
	}

	public void setCORDENADAY(Integer CORDENADAY) {
		this.CORDENADAY = CORDENADAY;
	}

	public Integer getCORDENADAY() {
		return this.CORDENADAY;
	}

	public void setIDUBICACION(String IDUBICACION) {
		this.IDUBICACION = IDUBICACION;
	}

	public String getIDUBICACION() {
		return this.IDUBICACION;
	}

	public void setCORDENADAXT(Integer CORDENADAXT) {
		this.CORDENADAXT = CORDENADAXT;
	}

	public Integer getCORDENADAXT() {
		return this.CORDENADAXT;
	}

	public void setCORDENADAYT(Integer CORDENADAYT) {
		this.CORDENADAYT = CORDENADAYT;
	}

	public Integer getCORDENADAYT() {
		return this.CORDENADAYT;
	}

	public void setESTADOASIGNACION(Integer ESTADOASIGNACION) {
		this.ESTADOASIGNACION = ESTADOASIGNACION;
	}

	public Integer getESTADOASIGNACION() {
		return this.ESTADOASIGNACION;
	}

	public void setSERIECHIP(String SERIECHIP) {
		this.SERIECHIP = SERIECHIP;
	}

	public String getSERIECHIP() {
		return this.SERIECHIP;
	}

	public void setPOSICION(String POSICION) {
		this.POSICION = POSICION;
	}

	public String getPOSICION() {
		return this.POSICION;
	}
	
	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDASIGNACIONCHIPS + ", " + (IDZONA==null?"Null":IDZONA) + ", " + CORDENADAX + ", "
				+ CORDENADAY + ", " + IDUBICACION + ", " + POSICION + ", " + (ESTADOASIGNACION==null?"Null":ESTADOASIGNACION) + ", " + FECHACREACION + ", " + POSICION
				+ (DESCRIPCION==null?"Null":DESCRIPCION) + "]";
	}
	/* Sets & Gets FK*/

	

}