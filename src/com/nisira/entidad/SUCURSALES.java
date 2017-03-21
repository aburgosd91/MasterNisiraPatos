package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "SUCURSALES")
public class SUCURSALES {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@Columna
	private Float DISTRIBUIR;
	@Columna
	private String E_MAIL;
	@Columna
	private String DIRECCION;
	@Columna
	private String DESCRIPCION;
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

	public void setIDSUCURSAL(Integer IDSUCURSAL) {
		this.IDSUCURSAL = IDSUCURSAL;
	}

	public Integer getIDSUCURSAL() {
		return this.IDSUCURSAL;
	}

	public void setDISTRIBUIR(Float DISTRIBUIR) {
		this.DISTRIBUIR = DISTRIBUIR;
	}

	public Float getDISTRIBUIR() {
		return this.DISTRIBUIR;
	}

	public void setE_MAIL(String E_MAIL) {
		this.E_MAIL = E_MAIL;
	}

	public String getE_MAIL() {
		return this.E_MAIL;
	}

	public void setDIRECCION(String DIRECCION) {
		this.DIRECCION = DIRECCION;
	}

	public String getDIRECCION() {
		return this.DIRECCION;
	}

	public void setDESCRIPCION(String DESCRIPCION) {
		this.DESCRIPCION = DESCRIPCION;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
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
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + (DISTRIBUIR==null?"Null":DISTRIBUIR) + ", " + E_MAIL + ", " + DIRECCION + ", "
				+ DESCRIPCION + ", " + (ESTADO==null?"Null":ESTADO) + ", " + (SINCRONIZA==null?"Null":SINCRONIZA) + ", " + FECHACREACION + "]";
	}



	/* Sets & Gets FK*/

}