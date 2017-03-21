package com.nisira.entidad;

import com.nisira.annotation.CampoRelacionado;
import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "OrigenDato")
public class OrigenDato {
	@ClavePrimaria
	@Columna
	private String idorigen;
	@Columna
	private String descripcion;
	@Columna
	private String idempresa;
	@Columna
	private String tipo;
	@Columna
	private String servidor;
	@Columna
	private String instancia;
	@Columna
	private String usuario;
	@Columna
	private String clave;
	@Columna
	private String IdEmpresaExt;
	@Columna
	private String BaseDatos;

	@CampoRelacionado({@RelacionTabla(campo="idempresa",campoRelacionado="IdEmpresa")})
	private EmpresaEnvio empresaenvio_odempresaenvio;


	/* Sets & Gets */
	public void setIdorigen(String idorigen) {
		this.idorigen = idorigen;
	}

	public String getIdorigen() {
		return this.idorigen;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public String getServidor() {
		return this.servidor;
	}

	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}

	public String getInstancia() {
		return this.instancia;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getClave() {
		return this.clave;
	}

	public void setIdEmpresaExt(String IdEmpresaExt) {
		this.IdEmpresaExt = IdEmpresaExt;
	}

	public String getIdEmpresaExt() {
		return this.IdEmpresaExt;
	}

	public void setBaseDatos(String BaseDatos) {
		this.BaseDatos = BaseDatos;
	}

	public String getBaseDatos() {
		return this.BaseDatos;
	}



	/* Sets & Gets FK*/
	public void setEmpresaenvio_odempresaenvio(EmpresaEnvio empresaenvio_odempresaenvio) {
		this.empresaenvio_odempresaenvio = empresaenvio_odempresaenvio;
	}

	public EmpresaEnvio getEmpresaenvio_odempresaenvio() {
		return this.empresaenvio_odempresaenvio;
	}

	/*-Inicio-*/
	@Override
	public String toString() {
		return this.idorigen + " - " + this.descripcion;
	}
	/*-Fin-*/
}