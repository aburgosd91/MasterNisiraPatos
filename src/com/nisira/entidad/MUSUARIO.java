package com.nisira.entidad;

import java.util.Date;

import com.nisira.annotation.CampoRelacionado;
import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@Tabla(nombre = "MUSUARIO")
public class MUSUARIO {
	@ClavePrimaria
	@Columna
	private String IdUsuario;
	@Columna
	private String Clave;
	@Columna
	private Integer Estado;
	@Columna
	private String Nombres;
	@Columna
	private String IdgrupoUsuario;
	@Columna
	private Date fechacreacion;
	@Columna
	private String idoperario;
	@XStreamOmitField
	@CampoRelacionado({@RelacionTabla(campo="IdgrupoUsuario",campoRelacionado="idgrupousuario")})
	private GrupoUsuario grupousuario_fk_usuario_grupousuario;


	/* Sets & Gets */
	public void setIdUsuario(String IdUsuario) {
		this.IdUsuario = IdUsuario;
	}

	public String getIdUsuario() {
		return this.IdUsuario;
	}

	public void setClave(String Clave) {
		this.Clave = Clave;
	}

	public String getClave() {
		return this.Clave;
	}

	public void setEstado(Integer Estado) {
		this.Estado = Estado;
	}

	public Integer getEstado() {
		return this.Estado;
	}

	public void setNombres(String Nombres) {
		this.Nombres = Nombres;
	}

	public String getNombres() {
		return this.Nombres;
	}

	public void setIdgrupoUsuario(String IdgrupoUsuario) {
		this.IdgrupoUsuario = IdgrupoUsuario;
	}

	public String getIdgrupoUsuario() {
		return this.IdgrupoUsuario;
	}



	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getIdoperario() {
		return idoperario;
	}

	public void setIdoperario(String idoperario) {
		this.idoperario = idoperario;
	}

	@Override
	public String toString() {
		return "[" + IdUsuario + ", " + Clave + ", " + Estado + ", " + Nombres + ", " + IdgrupoUsuario + ", "
				+ fechacreacion + ", " + (idoperario == null ? "null":idoperario) + "]";
	}

	/* Sets & Gets FK*/
	public void setGrupousuario_fk_usuario_grupousuario(GrupoUsuario grupousuario_fk_usuario_grupousuario) {
		this.grupousuario_fk_usuario_grupousuario = grupousuario_fk_usuario_grupousuario;
	}

	public GrupoUsuario getGrupousuario_fk_usuario_grupousuario() {
		return this.grupousuario_fk_usuario_grupousuario;
	}


}