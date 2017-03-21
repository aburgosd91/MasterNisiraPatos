package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "EmpresaEnvio")
public class EmpresaEnvio {
	@ClavePrimaria
	@Columna
	private String IdEmpresa;
	@Columna
	private String Ruc;
	@Columna
	private String RazonSocial;
	@Columna
	private Integer EmpresaWS;
	@Columna
	private String ClaveWS;
	@Columna
	private String RutaArchivos;
	@Columna
	private Integer EnPrueba;
	@Columna
	private String IdUbigeo;
	@Columna
	private String Direccion;
	@Columna
	private String Departamento;
	@Columna
	private String Provincia;
	@Columna
	private String Distrito;
	@Columna
	private String CodigoPais;



	/* Sets & Gets */
	public void setIdEmpresa(String IdEmpresa) {
		this.IdEmpresa = IdEmpresa;
	}

	public String getIdEmpresa() {
		return this.IdEmpresa;
	}

	public void setRuc(String Ruc) {
		this.Ruc = Ruc;
	}

	public String getRuc() {
		return this.Ruc;
	}

	public void setRazonSocial(String RazonSocial) {
		this.RazonSocial = RazonSocial;
	}

	public String getRazonSocial() {
		return this.RazonSocial;
	}

	public void setEmpresaWS(Integer EmpresaWS) {
		this.EmpresaWS = EmpresaWS;
	}

	public Integer getEmpresaWS() {
		return this.EmpresaWS;
	}

	public void setClaveWS(String ClaveWS) {
		this.ClaveWS = ClaveWS;
	}

	public String getClaveWS() {
		return this.ClaveWS;
	}

	public void setRutaArchivos(String RutaArchivos) {
		this.RutaArchivos = RutaArchivos;
	}

	public String getRutaArchivos() {
		return this.RutaArchivos;
	}

	public void setEnPrueba(Integer EnPrueba) {
		this.EnPrueba = EnPrueba;
	}

	public Integer getEnPrueba() {
		return this.EnPrueba;
	}

	public void setIdUbigeo(String IdUbigeo) {
		this.IdUbigeo = IdUbigeo;
	}

	public String getIdUbigeo() {
		return this.IdUbigeo;
	}

	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}

	public String getDireccion() {
		return this.Direccion;
	}

	public void setDepartamento(String Departamento) {
		this.Departamento = Departamento;
	}

	public String getDepartamento() {
		return this.Departamento;
	}

	public void setProvincia(String Provincia) {
		this.Provincia = Provincia;
	}

	public String getProvincia() {
		return this.Provincia;
	}

	public void setDistrito(String Distrito) {
		this.Distrito = Distrito;
	}

	public String getDistrito() {
		return this.Distrito;
	}

	public void setCodigoPais(String CodigoPais) {
		this.CodigoPais = CodigoPais;
	}

	public String getCodigoPais() {
		return this.CodigoPais;
	}



	/* Sets & Gets FK*/

}