package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

import java.util.Date;

@Tabla(nombre = "LogEnvio")
public class LogEnvio {
	@ClavePrimaria
	@Columna(noInsertar = true)
	private Integer IdLogEnvio;
	@Columna
	private String Tipo;
	@Columna
	private Date FechaHora;
	@Columna
	private String Mensaje;
	@Columna
	private String Formulario;

	/* Sets & Gets */
	public void setIdLogEnvio(Integer IdLogEnvio) {
		this.IdLogEnvio = IdLogEnvio;
	}

	public Integer getIdLogEnvio() {
		return this.IdLogEnvio;
	}

	public void setTipo(String Tipo) {
		this.Tipo = Tipo;
	}

	public String getTipo() {
		return this.Tipo;
	}

	public void setFechaHora(Date FechaHora) {
		this.FechaHora = FechaHora;
	}

	public Date getFechaHora() {
		return this.FechaHora;
	}

	public void setMensaje(String Mensaje) {
		this.Mensaje = Mensaje;
	}

	public String getMensaje() {
		return this.Mensaje;
	}

	public void setFormulario(String Formulario) {
		this.Formulario = Formulario;
	}

	public String getFormulario() {
		return this.Formulario;
	}

	/* Sets & Gets FK */

}