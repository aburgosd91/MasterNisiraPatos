package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.CampoRelacionado;

@Tabla(nombre = "Resumen")
public class Resumen {
	@ClavePrimaria
	@Columna
	private String IdEmpresa;
	@ClavePrimaria
	@Columna
	private String Documento;
	@Columna
	private Date fechaGeneracion;
	@Columna
	private Date fechaResumen;
	@Columna
	private String idEstado;
	@Columna
	private String DocXML;
	@Columna
	private String TipoDocumento;
	@Columna
	private String Ticket;
	@Columna
	private String TipoEnvio;

	@CampoRelacionado({@RelacionTabla(campo="IdEmpresa",campoRelacionado="IdEmpresa")})
	private EmpresaEnvio empresaenvio_fk_resumen_empresaenvio;


	/* Sets & Gets */
	public void setIdEmpresa(String IdEmpresa) {
		this.IdEmpresa = IdEmpresa;
	}

	public String getIdEmpresa() {
		return this.IdEmpresa;
	}

	public void setDocumento(String Documento) {
		this.Documento = Documento;
	}

	public String getDocumento() {
		return this.Documento;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public Date getFechaGeneracion() {
		return this.fechaGeneracion;
	}

	public void setFechaResumen(Date fechaResumen) {
		this.fechaResumen = fechaResumen;
	}

	public Date getFechaResumen() {
		return this.fechaResumen;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	public String getIdEstado() {
		return this.idEstado;
	}

	public void setDocXML(String DocXML) {
		this.DocXML = DocXML;
	}

	public String getDocXML() {
		return this.DocXML;
	}

	public void setTipoDocumento(String TipoDocumento) {
		this.TipoDocumento = TipoDocumento;
	}

	public String getTipoDocumento() {
		return this.TipoDocumento;
	}

	public void setTicket(String Ticket) {
		this.Ticket = Ticket;
	}

	public String getTicket() {
		return this.Ticket;
	}

	public void setTipoEnvio(String TipoEnvio) {
		this.TipoEnvio = TipoEnvio;
	}

	public String getTipoEnvio() {
		return this.TipoEnvio;
	}



	/* Sets & Gets FK*/
	public void setEmpresaenvio_fk_resumen_empresaenvio(EmpresaEnvio empresaenvio_fk_resumen_empresaenvio) {
		this.empresaenvio_fk_resumen_empresaenvio = empresaenvio_fk_resumen_empresaenvio;
	}

	public EmpresaEnvio getEmpresaenvio_fk_resumen_empresaenvio() {
		return this.empresaenvio_fk_resumen_empresaenvio;
	}


}