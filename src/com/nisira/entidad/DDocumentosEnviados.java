package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "DDocumentosEnviados")
public class DDocumentosEnviados {
	@ClavePrimaria
	@Columna
	private String IdOrigen;
	@ClavePrimaria
	@Columna
	private String IdUnico;
	@ClavePrimaria
	@Columna
	private Integer Item;
	@Columna
	private String Codigo;
	@Columna
	private String Descripcion;



	/* Sets & Gets */
	public void setIdOrigen(String IdOrigen) {
		this.IdOrigen = IdOrigen;
	}

	public String getIdOrigen() {
		return this.IdOrigen;
	}

	public void setIdUnico(String IdUnico) {
		this.IdUnico = IdUnico;
	}

	public String getIdUnico() {
		return this.IdUnico;
	}

	public void setItem(Integer Item) {
		this.Item = Item;
	}

	public Integer getItem() {
		return this.Item;
	}

	public void setCodigo(String Codigo) {
		this.Codigo = Codigo;
	}

	public String getCodigo() {
		return this.Codigo;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}

	public String getDescripcion() {
		return this.Descripcion;
	}



	/* Sets & Gets FK*/

}