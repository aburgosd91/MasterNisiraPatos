package com.nisira.entidad;

import java.util.Date;
import java.util.List;

import com.nisira.annotation.CampoRelacionado;
import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@Tabla(nombre = "SysGrupo")
public class SysGrupo {
	@Columna
	private String Descripcion;
	@Columna
	private String Imagen;
	@ClavePrimaria
	@Columna
	private String IdModulo;
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
			@RelacionTabla(campo = "IdTitulo", campoRelacionado = "IdTitulo") })
	private SysTitulo systitulo_fk_sys_grupo_idmodulo;

	/* Sets & Gets */
	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}

	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setImagen(String Imagen) {
		this.Imagen = Imagen;
	}

	public String getImagen() {
		return this.Imagen;
	}

	public void setIdModulo(String IdModulo) {
		this.IdModulo = IdModulo;
	}

	public String getIdModulo() {
		return this.IdModulo;
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
	public void setSystitulo_fk_sys_grupo_idmodulo(
			SysTitulo systitulo_fk_sys_grupo_idmodulo) {
		this.systitulo_fk_sys_grupo_idmodulo = systitulo_fk_sys_grupo_idmodulo;
	}

	public SysTitulo getSystitulo_fk_sys_grupo_idmodulo() {
		return this.systitulo_fk_sys_grupo_idmodulo;
	}
	
	/*-Inicio-*/
	private List<SysOpcion> opciones;

	public List<SysOpcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<SysOpcion> opciones) {
		this.opciones = opciones;
	}
	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	/*-Fin-*/

	@Override
	public String toString() {
		return "[" + Descripcion + ", " + Imagen + ", " + IdModulo + ", " + IdGrupo + ", " + IdTitulo + ", "
				+ fechacreacion + "]";
	}
	
}