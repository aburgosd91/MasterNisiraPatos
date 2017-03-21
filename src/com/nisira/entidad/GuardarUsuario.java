package com.nisira.entidad;

import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "GuardarUsuario")
public class GuardarUsuario {
	@Columna
	private String Clave;
	@ClavePrimaria
	@Columna
	private String NameHost;
	@ClavePrimaria
	@Columna
	private String IdUsuario;
	@Columna
	private Date fechacreacion;


	/* Sets & Gets */
	public void setClave(String Clave) {
		this.Clave = Clave;
	}

	public String getClave() {
		return this.Clave;
	}

	public void setNameHost(String NameHost) {
		this.NameHost = NameHost;
	}

	public String getNameHost() {
		return this.NameHost;
	}

	public void setIdUsuario(String IdUsuario) {
		this.IdUsuario = IdUsuario;
	}

	public String getIdUsuario() {
		return this.IdUsuario;
	}
	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	@Override
	public String toString() {
		return "[" + Clave + ", " + NameHost + ", " + IdUsuario + ", " + fechacreacion + "]";
	}


	/* Sets & Gets FK*/

}