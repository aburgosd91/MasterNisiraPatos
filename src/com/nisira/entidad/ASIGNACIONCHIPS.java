package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "ASIGNACIONCHIPS")
public class ASIGNACIONCHIPS {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private String IDASIGNACIONCHIPS;
	@Columna
	private Integer IDZONA;
	@Columna
	private String GINICIO;
	@Columna
	private String GFIN;
	@Columna
	private Float NUMTAG;
	@Columna
	private String OBSERVACION;
	@Columna
	private Integer ESTADO;
	@Columna
	private Date FECHACREACION;
	@Columna
	private String USRCREACION;



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

	public void setGINICIO(String GINICIO) {
		this.GINICIO = GINICIO;
	}

	public String getGINICIO() {
		return this.GINICIO;
	}

	public void setGFIN(String GFIN) {
		this.GFIN = GFIN;
	}

	public String getGFIN() {
		return this.GFIN;
	}

	public void setNUMTAG(Float NUMTAG) {
		this.NUMTAG = NUMTAG;
	}

	public Float getNUMTAG() {
		return this.NUMTAG;
	}

	public void setOBSERVACION(String OBSERVACION) {
		this.OBSERVACION = OBSERVACION;
	}

	public String getOBSERVACION() {
		return this.OBSERVACION;
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

	public void setUSRCREACION(String USRCREACION) {
		this.USRCREACION = USRCREACION;
	}

	public String getUSRCREACION() {
		return this.USRCREACION;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDASIGNACIONCHIPS + ", " + (IDZONA==null?"Null":IDZONA) + ", " + GINICIO + ", "
				+ GFIN + ", " + NUMTAG + ", " + OBSERVACION + ", " + (ESTADO==null?"Null":ESTADO) + ", " + FECHACREACION + ", " + USRCREACION
				+ "]";
	}
	



	/* Sets & Gets FK*/

}