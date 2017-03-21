package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "NUMEMISOR")
public class NUMEMISOR {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private String IDDOCUMENTO;
	@Columna
	private String ITEM;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private String SERIE;
	@Columna
	private String NUMERO;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer ESTADO;



	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDDOCUMENTO(String IDDOCUMENTO) {
		this.IDDOCUMENTO = IDDOCUMENTO;
	}

	public String getIDDOCUMENTO() {
		return this.IDDOCUMENTO;
	}

	public void setITEM(String ITEM) {
		this.ITEM = ITEM;
	}

	public String getITEM() {
		return this.ITEM;
	}

	public void setIDSUCURSAL(Integer IDSUCURSAL) {
		this.IDSUCURSAL = IDSUCURSAL;
	}

	public Integer getIDSUCURSAL() {
		return this.IDSUCURSAL;
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

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDDOCUMENTO + ", " + ITEM + ", " + IDSUCURSAL + ", " + SERIE + ", " + NUMERO
				+ ", " + FECHACREACION + ", " + (ESTADO==null?"Null":ESTADO) + "]";
	}



	/* Sets & Gets FK*/

}