package com.nisira.entidad;

import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "SysModulo")
public class SysModulo {
	@ClavePrimaria
	@Columna
	private String IdModulo;
	@Columna
	private String Descripcion;
	@Columna
	private String Imagen;
	@Columna
	private Date fechacreacion;


	/* Sets & Gets */
	public void setIdModulo(String IdModulo) {
		this.IdModulo = IdModulo;
	}

	public String getIdModulo() {
		return this.IdModulo;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}

	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setImagen(String Imagen) {
		this.Imagen = Imagen;
	}

	public String getImagen() {
		return this.Imagen;
	}

	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	@Override
	public String toString() {
		return "[" + IdModulo + ", " + Descripcion + ", " + Imagen + ", " + fechacreacion + "]";
	}



	/* Sets & Gets FK*/

}