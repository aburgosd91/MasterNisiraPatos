package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "FLOYD")
public class FLOYD {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private Integer IDFLOYD;
	@Columna
	private String MATRIZ_S;
	@Columna
	private String MATRIZ_D;
	@Columna
	private Integer FLAG;
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

	public void setIDFLOYD(Integer IDFLOYD) {
		this.IDFLOYD = IDFLOYD;
	}

	public Integer getIDFLOYD() {
		return this.IDFLOYD;
	}
	
	public void setFLAG(Integer FLAG) {
		this.FLAG = FLAG;
	}

	public String getMATRIZ_S() {
		return MATRIZ_S;
	}

	public void setMATRIZ_S(String mATRIZ_S) {
		MATRIZ_S = mATRIZ_S;
	}

	public String getMATRIZ_D() {
		return MATRIZ_D;
	}

	public void setMATRIZ_D(String mATRIZ_D) {
		MATRIZ_D = mATRIZ_D;
	}

	public Integer getFLAG() {
		return this.FLAG;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}



	/* Sets & Gets FK*/

}