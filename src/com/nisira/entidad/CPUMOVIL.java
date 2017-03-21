package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "CPUMOVIL")
public class CPUMOVIL {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDCPUMOVIL;
	@Columna
	private String DESCRIPCION;
	@Columna
	private String MODELO;
	@Columna
	private String MARCA;
	@Columna
	private Integer PROCESADOR;
	@Columna
	private Integer RAM;
	@Columna
	private String SO;
	@Columna
	private Integer estado;
	@Columna
	private Date fechacreacion;



	/* Sets & Gets */
	public void setIdempresa(Integer idempresa) {
		this.IDEMPRESA = idempresa;
	}

	public Integer getIdempresa() {
		return this.IDEMPRESA;
	}

	public void setIdcpumovil(Integer idcpumovil) {
		this.IDCPUMOVIL = idcpumovil;
	}

	public Integer getIdcpumovil() {
		return this.IDCPUMOVIL;
	}

	public void setDescripcion(String descripcion) {
		this.DESCRIPCION = descripcion;
	}

	public String getDescripcion() {
		return this.DESCRIPCION;
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

	public void setProcesador(Integer procesador) {
		this.PROCESADOR = procesador;
	}

	public Integer getProcesador() {
		return this.PROCESADOR;
	}

	public void setRam(Integer ram) {
		this.RAM = ram;
	}

	public Integer getRam() {
		return this.RAM;
	}

	public void setSo(String so) {
		this.SO = so;
	}

	public String getSo() {
		return this.SO;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	/* Sets & Gets FK*/

}