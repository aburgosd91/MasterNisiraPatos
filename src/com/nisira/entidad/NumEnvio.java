package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "NumEnvio")
public class NumEnvio {
	@ClavePrimaria
	@Columna
	private String TipoDocumento;
	@ClavePrimaria
	@Columna
	private String Fecha;
	@Columna
	private Integer Correlativo;



	/* Sets & Gets */
	public void setTipoDocumento(String TipoDocumento) {
		this.TipoDocumento = TipoDocumento;
	}

	public String getTipoDocumento() {
		return this.TipoDocumento;
	}

	public void setFecha(String Fecha) {
		this.Fecha = Fecha;
	}

	public String getFecha() {
		return this.Fecha;
	}

	public void setCorrelativo(Integer Correlativo) {
		this.Correlativo = Correlativo;
	}

	public Integer getCorrelativo() {
		return this.Correlativo;
	}



	/* Sets & Gets FK*/

}