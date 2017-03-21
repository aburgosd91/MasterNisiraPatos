package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "DResumen")
public class DResumen {
	@ClavePrimaria
	@Columna
	private String idOrigen;
	@ClavePrimaria
	@Columna
	private String documento;
	@ClavePrimaria
	@Columna
	private Integer item;
	@Columna
	private String serie;
	@Columna
	private String numero;
	@Columna
	private String motivoBaja;
	@Columna
	private String numInicio;
	@Columna
	private String numFin;
	@Columna
	private Float gravadas;
	@Columna
	private Float inafectas;
	@Columna
	private Float exoneradas;
	@Columna
	private Float gratuitas;
	@Columna
	private Float otros;
	@Columna
	private Float igv;
	@Columna
	private Float isc;
	@Columna
	private Float imp_otros;
	@Columna
	private String idmoneda;



	/* Sets & Gets */
	public void setIdOrigen(String idOrigen) {
		this.idOrigen = idOrigen;
	}

	public String getIdOrigen() {
		return this.idOrigen;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public Integer getItem() {
		return this.item;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setMotivoBaja(String motivoBaja) {
		this.motivoBaja = motivoBaja;
	}

	public String getMotivoBaja() {
		return this.motivoBaja;
	}

	public void setNumInicio(String numInicio) {
		this.numInicio = numInicio;
	}

	public String getNumInicio() {
		return this.numInicio;
	}

	public void setNumFin(String numFin) {
		this.numFin = numFin;
	}

	public String getNumFin() {
		return this.numFin;
	}

	public void setGravadas(Float gravadas) {
		this.gravadas = gravadas;
	}

	public Float getGravadas() {
		return this.gravadas;
	}

	public void setInafectas(Float inafectas) {
		this.inafectas = inafectas;
	}

	public Float getInafectas() {
		return this.inafectas;
	}

	public void setExoneradas(Float exoneradas) {
		this.exoneradas = exoneradas;
	}

	public Float getExoneradas() {
		return this.exoneradas;
	}

	public void setGratuitas(Float gratuitas) {
		this.gratuitas = gratuitas;
	}

	public Float getGratuitas() {
		return this.gratuitas;
	}

	public void setOtros(Float otros) {
		this.otros = otros;
	}

	public Float getOtros() {
		return this.otros;
	}

	public void setIgv(Float igv) {
		this.igv = igv;
	}

	public Float getIgv() {
		return this.igv;
	}

	public void setIsc(Float isc) {
		this.isc = isc;
	}

	public Float getIsc() {
		return this.isc;
	}

	public void setImp_otros(Float imp_otros) {
		this.imp_otros = imp_otros;
	}

	public Float getImp_otros() {
		return this.imp_otros;
	}

	public void setIdmoneda(String idmoneda) {
		this.idmoneda = idmoneda;
	}

	public String getIdmoneda() {
		return this.idmoneda;
	}



	/* Sets & Gets FK*/

}