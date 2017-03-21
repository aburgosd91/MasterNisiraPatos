package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "DocumentosEnviados")
public class DocumentosEnviados {
	@ClavePrimaria
	@Columna
	private String IdOrigen;
	@ClavePrimaria
	@Columna
	private String IdUnico;
	@Columna
	private String Documento;
	@Columna
	private String IdClieprov;
	@Columna
	private String RazonSocial;
	@Columna
	private Date Fecha;
	@Columna
	private String NombreArchivo;
	@Columna
	private String DocXML;



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

	public void setDocumento(String Documento) {
		this.Documento = Documento;
	}

	public String getDocumento() {
		return this.Documento;
	}

	public void setIdClieprov(String IdClieprov) {
		this.IdClieprov = IdClieprov;
	}

	public String getIdClieprov() {
		return this.IdClieprov;
	}

	public void setRazonSocial(String RazonSocial) {
		this.RazonSocial = RazonSocial;
	}

	public String getRazonSocial() {
		return this.RazonSocial;
	}

	public void setFecha(Date Fecha) {
		this.Fecha = Fecha;
	}

	public Date getFecha() {
		return this.Fecha;
	}

	public void setNombreArchivo(String NombreArchivo) {
		this.NombreArchivo = NombreArchivo;
	}

	public String getNombreArchivo() {
		return this.NombreArchivo;
	}

	public void setDocXML(String DocXML) {
		this.DocXML = DocXML;
	}

	public String getDocXML() {
		return this.DocXML;
	}



	/* Sets & Gets FK*/

}