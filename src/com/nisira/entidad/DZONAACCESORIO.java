package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.sql.Timestamp;
import java.util.Date;

@Tabla(nombre = "DZONAACCESORIO")
public class DZONAACCESORIO {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDZONA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private Integer IDACCESORIO;
	@Columna
	private String DESCRIPCION;
	@Columna
	private String IDUBICACION;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer ESTADO;
	@Columna
	private Integer SINCRONIZA;
	@Columna 
	private Integer IDTIPOACCESORIO;


	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDZONA(Integer IDZONA) {
		this.IDZONA = IDZONA;
	}

	public Integer getIDZONA() {
		return this.IDZONA;
	}

	public void setIDSUCURSAL(Integer IDSUCURSAL) {
		this.IDSUCURSAL = IDSUCURSAL;
	}

	public Integer getIDSUCURSAL() {
		return this.IDSUCURSAL;
	}

	public void setIDACCESORIO(Integer IDACCESORIO) {
		this.IDACCESORIO = IDACCESORIO;
	}

	public Integer getIDACCESORIO() {
		return this.IDACCESORIO;
	}

	public void setDESCRIPCION(String DESCRIPCION) {
		this.DESCRIPCION = DESCRIPCION;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
	}

	public void setIDUBICACION(String IDUBICACION) {
		this.IDUBICACION = IDUBICACION;
	}

	public String getIDUBICACION() {
		return this.IDUBICACION;
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

	public void setSINCRONIZA(Integer SINCRONIZA) {
		this.SINCRONIZA = SINCRONIZA;
	}

	public Integer getSINCRONIZA() {
		return this.SINCRONIZA;
	}

	public Integer getIDTIPOACCESORIO() {
		return IDTIPOACCESORIO;
	}

	public void setIDTIPOACCESORIO(Integer iDTIPOACCESORIO) {
		IDTIPOACCESORIO = iDTIPOACCESORIO;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDZONA + ", " + IDSUCURSAL + ", " + IDACCESORIO + ", " + DESCRIPCION + ", "
				+ IDUBICACION + ", " + FECHACREACION + ", " + (ESTADO==null?0:ESTADO) + ", " + (SINCRONIZA==null?"Null":SINCRONIZA) + ", " + (IDTIPOACCESORIO==null?"Null":IDTIPOACCESORIO) + "]";
	}



	/* Sets & Gets FK*/

}