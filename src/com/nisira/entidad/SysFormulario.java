package com.nisira.entidad;

import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "SysFormulario")
public class SysFormulario {
	@ClavePrimaria
	@Columna
	private String IdFormulario;
	@Columna
	private String Clase;
	@Columna
	private String ClaseDoc;
	@Columna
	private String Descripcion;
	@Columna
	private Integer EsLista;
	@Columna
	private String Imagen;
	@Columna
	private String Paquete;
	@Columna
	private String PaqueteDoc;
	@Columna
	private String Opcion;
	@Columna
	private Date fechacreacion;


	/* Sets & Gets */
	public void setIdFormulario(String IdFormulario) {
		this.IdFormulario = IdFormulario;
	}

	public String getIdFormulario() {
		return this.IdFormulario;
	}

	public void setClase(String Clase) {
		this.Clase = Clase;
	}

	public String getClase() {
		return this.Clase;
	}

	public void setClaseDoc(String ClaseDoc) {
		this.ClaseDoc = ClaseDoc;
	}

	public String getClaseDoc() {
		return this.ClaseDoc;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}

	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setEsLista(Integer EsLista) {
		this.EsLista = EsLista;
	}

	public Integer getEsLista() {
		return this.EsLista;
	}

	public void setImagen(String Imagen) {
		this.Imagen = Imagen;
	}

	public String getImagen() {
		return this.Imagen;
	}

	public void setPaquete(String Paquete) {
		this.Paquete = Paquete;
	}

	public String getPaquete() {
		return this.Paquete;
	}

	public void setPaqueteDoc(String PaqueteDoc) {
		this.PaqueteDoc = PaqueteDoc;
	}

	public String getPaqueteDoc() {
		return this.PaqueteDoc;
	}

	public void setOpcion(String Opcion) {
		this.Opcion = Opcion;
	}

	public String getOpcion() {
		return this.Opcion;
	}
	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	@Override
	public String toString() {
		return "[" + IdFormulario + ", " + Clase + ", " + ClaseDoc + ", " + Descripcion + ", " + EsLista + ", " + Imagen
				+ ", " + Paquete + ", " + PaqueteDoc + ", " + Opcion + ", " + fechacreacion + "]";
	}


	/* Sets & Gets FK*/

}