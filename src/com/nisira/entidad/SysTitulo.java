package com.nisira.entidad;

import java.util.Date;
import java.util.List;

import com.nisira.annotation.CampoRelacionado;
import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@Tabla(nombre = "SysTitulo")
public class SysTitulo {
	@Columna
	private String Descripcion;
	@Columna
	private String Imagen;
	@ClavePrimaria
	@Columna
	private String IdModulo;
	@ClavePrimaria
	@Columna
	private String IdTitulo;
	@Columna
	private Date fechacreacion;
	@XStreamOmitField
	@CampoRelacionado({@RelacionTabla(campo="IdModulo",campoRelacionado="IdModulo")})
	private SysModulo sysmodulo_fk_sys_titulo_idmodulo;


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

	public void setIdTitulo(String IdTitulo) {
		this.IdTitulo = IdTitulo;
	}

	public String getIdTitulo() {
		return this.IdTitulo;
	}



	/* Sets & Gets FK*/
	public void setSysmodulo_fk_sys_titulo_idmodulo(SysModulo sysmodulo_fk_sys_titulo_idmodulo) {
		this.sysmodulo_fk_sys_titulo_idmodulo = sysmodulo_fk_sys_titulo_idmodulo;
	}

	public SysModulo getSysmodulo_fk_sys_titulo_idmodulo() {
		return this.sysmodulo_fk_sys_titulo_idmodulo;
	}
	/*-Inicio-*/
	
	private List<SysGrupo> grupos;


	public List<SysGrupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<SysGrupo> grupos) {
		this.grupos = grupos;
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
		return "[" + Descripcion + ", " + Imagen + ", " + IdModulo + ", " + IdTitulo + ", " + fechacreacion + "]";
	}
	

}