package com.nisira.entidad;

import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "GrupoUsuario")
public class GrupoUsuario {
	@ClavePrimaria
	@Columna
	private String idgrupousuario;
	@Columna
	private String descripcion;
	@Columna
	private Integer es_administrador;
	@Columna
	private Date fechacreacion;


	/* Sets & Gets */
	public void setIdgrupousuario(String idgrupousuario) {
		this.idgrupousuario = idgrupousuario;
	}

	public String getIdgrupousuario() {
		return this.idgrupousuario;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setEs_administrador(Integer es_administrador) {
		this.es_administrador = es_administrador;
	}

	public Integer getEs_administrador() {
		return this.es_administrador;
	}
	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	@Override
	public String toString() {
		return "[" + idgrupousuario + ", " + descripcion + ", " + es_administrador + ", " + fechacreacion + "]";
	}


	/* Sets & Gets FK*/

}