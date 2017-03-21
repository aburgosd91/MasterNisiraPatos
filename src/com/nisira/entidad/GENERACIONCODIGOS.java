package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.sql.Timestamp;
import java.util.Date;

@Tabla(nombre = "GENERACIONCODIGOS")
public class GENERACIONCODIGOS {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDGENERACION;
	@Columna
	private Integer TIPO;
	@Columna
	private String DESCRIPCION;
	@Columna
	private Integer NUMDIGITOTOTAL;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer ESTADO;
	@Columna
	private Integer SINCRONIZADO;
	@Columna
	private String PARAMETRO;
	@Columna
	private Integer IDPROCESO;


	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDGENERACION(Integer IDGENERACION) {
		this.IDGENERACION = IDGENERACION;
	}

	public Integer getIDGENERACION() {
		return this.IDGENERACION;
	}

	public void setTIPO(Integer TIPO) {
		this.TIPO = TIPO;
	}

	public Integer getTIPO() {
		return this.TIPO;
	}

	public void setDESCRIPCION(String DESCRIPCION) {
		this.DESCRIPCION = DESCRIPCION;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
	}

	public void setNUMDIGITOTOTAL(Integer NUMDIGITOTOTAL) {
		this.NUMDIGITOTOTAL = NUMDIGITOTOTAL;
	}

	public Integer getNUMDIGITOTOTAL() {
		return this.NUMDIGITOTOTAL;
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

	public void setSINCRONIZADO(Integer SINCRONIZADO) {
		this.SINCRONIZADO = SINCRONIZADO;
	}

	public Integer getSINCRONIZADO() {
		return this.SINCRONIZADO;
	}

	public String getPARAMETRO() {
		return PARAMETRO;
	}

	public void setPARAMETRO(String pARAMETRO) {
		PARAMETRO = pARAMETRO;
	}
	public Integer getIDPROCESO() {
		return IDPROCESO;
	}

	public void setIDPROCESO(Integer iDPROCESO) {
		IDPROCESO = iDPROCESO;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDGENERACION + ", " + (TIPO==null?"Null":TIPO) + ", " + DESCRIPCION + ", " + (NUMDIGITOTOTAL==null?"Null":NUMDIGITOTOTAL) + ", "
				+ FECHACREACION + ", " + (ESTADO==null?"Null":ESTADO) + ", " + (SINCRONIZADO==null?"Null":SINCRONIZADO) + ", " + PARAMETRO + ","+IDPROCESO+"]";
	}

	


	/* Sets & Gets FK*/

}