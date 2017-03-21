package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.CampoRelacionado;

@Tabla(nombre = "CfgTabla")
public class CfgTabla {
	@ClavePrimaria
	@Columna
	private String ventana;
	@ClavePrimaria
	@Columna
	private String IdUsuario;
	@Columna
	private String configuracion;

	@CampoRelacionado({@RelacionTabla(campo="IdUsuario",campoRelacionado="IdUsuario")})
	private MUSUARIO usuario_fk_cfgtabla_usuario;


	/* Sets & Gets */
	public void setVentana(String ventana) {
		this.ventana = ventana;
	}

	public String getVentana() {
		return this.ventana;
	}

	public void setIdUsuario(String IdUsuario) {
		this.IdUsuario = IdUsuario;
	}

	public String getIdUsuario() {
		return this.IdUsuario;
	}

	public void setConfiguracion(String configuracion) {
		this.configuracion = configuracion;
	}

	public String getConfiguracion() {
		return this.configuracion;
	}



	/* Sets & Gets FK*/
	public void setUsuario_fk_cfgtabla_usuario(MUSUARIO usuario_fk_cfgtabla_usuario) {
		this.usuario_fk_cfgtabla_usuario = usuario_fk_cfgtabla_usuario;
	}

	public MUSUARIO getUsuario_fk_cfgtabla_usuario() {
		return this.usuario_fk_cfgtabla_usuario;
	}


}