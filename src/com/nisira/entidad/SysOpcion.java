package com.nisira.entidad;

import java.util.Date;

import com.nisira.annotation.CampoRelacionado;
import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@Tabla(nombre = "SysOpcion")
public class SysOpcion {
	@Columna
	private Integer prioridad;
	@ClavePrimaria
	@Columna
	private String IdModulo;
	@ClavePrimaria
	@Columna
	private String IdFormulario;
	@ClavePrimaria
	@Columna
	private String IdGrupo;
	@ClavePrimaria
	@Columna
	private String IdTitulo;
	@Columna
	private Date fechacreacion;
	@XStreamOmitField
	@CampoRelacionado({
			@RelacionTabla(campo = "IdModulo", campoRelacionado = "IdModulo"),
			@RelacionTabla(campo = "IdGrupo", campoRelacionado = "IdGrupo"),
			@RelacionTabla(campo = "IdTitulo", campoRelacionado = "IdTitulo") })
	private SysGrupo sysgrupo_fk_sys_opcion_idmodulo;
	@XStreamOmitField
	@CampoRelacionado({ @RelacionTabla(campo = "IdFormulario", campoRelacionado = "IdFormulario") })
	private SysFormulario sysformulario_sys_opcionidformulario;

	/* Sets & Gets */
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public Integer getPrioridad() {
		return this.prioridad;
	}

	public void setIdModulo(String IdModulo) {
		this.IdModulo = IdModulo;
	}

	public String getIdModulo() {
		return this.IdModulo;
	}

	public void setIdFormulario(String IdFormulario) {
		this.IdFormulario = IdFormulario;
	}

	public String getIdFormulario() {
		return this.IdFormulario;
	}

	public void setIdGrupo(String IdGrupo) {
		this.IdGrupo = IdGrupo;
	}

	public String getIdGrupo() {
		return this.IdGrupo;
	}

	public void setIdTitulo(String IdTitulo) {
		this.IdTitulo = IdTitulo;
	}

	public String getIdTitulo() {
		return this.IdTitulo;
	}

	/* Sets & Gets FK */
	public void setSysgrupo_fk_sys_opcion_idmodulo(
			SysGrupo sysgrupo_fk_sys_opcion_idmodulo) {
		this.sysgrupo_fk_sys_opcion_idmodulo = sysgrupo_fk_sys_opcion_idmodulo;
	}

	public SysGrupo getSysgrupo_fk_sys_opcion_idmodulo() {
		return this.sysgrupo_fk_sys_opcion_idmodulo;
	}

	public void setSysformulario_sys_opcionidformulario(
			SysFormulario sysformulario_sys_opcionidformulario) {
		this.sysformulario_sys_opcionidformulario = sysformulario_sys_opcionidformulario;
	}

	public SysFormulario getSysformulario_sys_opcionidformulario() {
		return this.sysformulario_sys_opcionidformulario;
	}
	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	@Override
	public String toString() {
		return "[" + prioridad + ", " + IdModulo + ", " + IdFormulario + ", " + IdGrupo + ", " + IdTitulo + ", "
				+ fechacreacion + "]";
	}
	
}