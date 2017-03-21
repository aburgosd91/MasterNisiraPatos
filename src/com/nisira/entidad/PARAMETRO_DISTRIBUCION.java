package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "PARAMETRO_DISTRIBUCION")
public class PARAMETRO_DISTRIBUCION {
	@ClavePrimaria
	@Columna
	private String IDEMPRESA;
	@ClavePrimaria
	@Columna
	private String IDPARAMETRO;
	@Columna
	private String NOMBRE;
	@Columna
	private Integer TIPO;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Date FECHA_DETALLE;
	@Columna
	private Float ESTADO;



	/* Sets & Gets */
	public void setIDEMPRESA(String IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public String getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDPARAMETRO(String IDPARAMETRO) {
		this.IDPARAMETRO = IDPARAMETRO;
	}

	public String getIDPARAMETRO() {
		return this.IDPARAMETRO;
	}

	public void setNOMBRE(String NOMBRE) {
		this.NOMBRE = NOMBRE;
	}

	public String getNOMBRE() {
		return this.NOMBRE;
	}

	public void setTIPO(Integer TIPO) {
		this.TIPO = TIPO;
	}

	public Integer getTIPO() {
		return this.TIPO;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	public void setFECHA_DETALLE(Date FECHA_DETALLE) {
		this.FECHA_DETALLE = FECHA_DETALLE;
	}

	public Date getFECHA_DETALLE() {
		return this.FECHA_DETALLE;
	}

	public void setESTADO(Float ESTADO) {
		this.ESTADO = ESTADO;
	}

	public Float getESTADO() {
		return this.ESTADO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ESTADO == null) ? 0 : ESTADO.hashCode());
		result = prime * result + ((FECHACREACION == null) ? 0 : FECHACREACION.hashCode());
		result = prime * result + ((FECHA_DETALLE == null) ? 0 : FECHA_DETALLE.hashCode());
		result = prime * result + ((IDEMPRESA == null) ? 0 : IDEMPRESA.hashCode());
		result = prime * result + ((IDPARAMETRO == null) ? 0 : IDPARAMETRO.hashCode());
		result = prime * result + ((NOMBRE == null) ? 0 : NOMBRE.hashCode());
		result = prime * result + ((TIPO == null) ? 0 : TIPO.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PARAMETRO_DISTRIBUCION other = (PARAMETRO_DISTRIBUCION) obj;
		if (ESTADO == null) {
			if (other.ESTADO != null)
				return false;
		} else if (!ESTADO.equals(other.ESTADO))
			return false;
		if (FECHACREACION == null) {
			if (other.FECHACREACION != null)
				return false;
		} else if (!FECHACREACION.equals(other.FECHACREACION))
			return false;
		if (FECHA_DETALLE == null) {
			if (other.FECHA_DETALLE != null)
				return false;
		} else if (!FECHA_DETALLE.equals(other.FECHA_DETALLE))
			return false;
		if (IDEMPRESA == null) {
			if (other.IDEMPRESA != null)
				return false;
		} else if (!IDEMPRESA.equals(other.IDEMPRESA))
			return false;
		if (IDPARAMETRO == null) {
			if (other.IDPARAMETRO != null)
				return false;
		} else if (!IDPARAMETRO.equals(other.IDPARAMETRO))
			return false;
		if (NOMBRE == null) {
			if (other.NOMBRE != null)
				return false;
		} else if (!NOMBRE.equals(other.NOMBRE))
			return false;
		if (TIPO == null) {
			if (other.TIPO != null)
				return false;
		} else if (!TIPO.equals(other.TIPO))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDPARAMETRO + ", " + NOMBRE + ", " + (TIPO==null?"Null":TIPO) + ", " + FECHACREACION + ", "
				+ FECHA_DETALLE + ", " + ESTADO + "]";
	}



	/* Sets & Gets FK*/

}