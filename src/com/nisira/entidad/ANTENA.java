package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "ANTENA")
public class ANTENA {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDANTENA;
	@Columna
	private String DESCRIPCION;
	@Columna
	private String NROSERIE;
	@Columna
	private String MODELO;
	@Columna
	private String MARCA;
	@Columna
	private String FRECUENCIA;
	@Columna
	private Integer ESTADO;
	@Columna
	private Date FECHACREACION;



	/* Sets & Gets */
	public void setIdempresa(Integer idempresa) {
		this.IDEMPRESA = idempresa;
	}

	public Integer getIdempresa() {
		return this.IDEMPRESA;
	}

	public void setIdantena(Integer idantena) {
		this.IDANTENA = idantena;
	}

	public Integer getIdantena() {
		return this.IDANTENA;
	}

	public void setDescripcion(String descripcion) {
		this.DESCRIPCION = descripcion;
	}

	public String getDescripcion() {
		return this.DESCRIPCION;
	}

	public void setNroserie(String nroserie) {
		this.NROSERIE = nroserie;
	}

	public String getNroserie() {
		return this.NROSERIE;
	}

	public void setModelo(String modelo) {
		this.MODELO = modelo;
	}

	public String getModelo() {
		return this.MODELO;
	}

	public void setMarca(String marca) {
		this.MARCA = marca;
	}

	public String getMarca() {
		return this.MARCA;
	}

	public void setFrecuencia(String frecuencia) {
		this.FRECUENCIA = frecuencia;
	}

	public String getFrecuencia() {
		return this.FRECUENCIA;
	}

	public void setEstado(Integer estado) {
		this.ESTADO = estado;
	}

	public Integer getEstado() {
		return this.ESTADO;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.FECHACREACION = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.FECHACREACION;
	}



	/* Sets & Gets FK*/

}