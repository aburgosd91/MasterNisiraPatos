package com.nisira.entidad;

import java.util.Date;

import com.nisira.annotation.CampoRelacionado;
import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@Tabla(nombre = "GrupoUsuarioPrivilegio")
public class GrupoUsuarioPrivilegio {
	@Columna
	private Integer Crear;
	@Columna
	private Integer Eliminar;
	@Columna
	private Integer Modificar;
	@Columna
	private Integer Ver;
	@ClavePrimaria
	@Columna
	private String Idgrupousuario;
	@ClavePrimaria
	@Columna
	private String IdFormulario;
	@Columna
	private Date fechacreacion;
	@XStreamOmitField
	@CampoRelacionado({@RelacionTabla(campo="IdFormulario",campoRelacionado="IdFormulario")})
	private SysFormulario sysformulario_grpsrprivilegiodfrmlro;
	@XStreamOmitField
	@CampoRelacionado({@RelacionTabla(campo="Idgrupousuario",campoRelacionado="idgrupousuario")})
	private GrupoUsuario grupousuario_grpsrprivilegiodgrpsro;


	/* Sets & Gets */
	public void setCrear(Integer Crear) {
		this.Crear = Crear;
	}

	public Integer getCrear() {
		return this.Crear;
	}

	public void setEliminar(Integer Eliminar) {
		this.Eliminar = Eliminar;
	}

	public Integer getEliminar() {
		return this.Eliminar;
	}

	public void setModificar(Integer Modificar) {
		this.Modificar = Modificar;
	}

	public Integer getModificar() {
		return this.Modificar;
	}

	public void setVer(Integer Ver) {
		this.Ver = Ver;
	}

	public Integer getVer() {
		return this.Ver;
	}

	public void setIdgrupousuario(String Idgrupousuario) {
		this.Idgrupousuario = Idgrupousuario;
	}

	public String getIdgrupousuario() {
		return this.Idgrupousuario;
	}

	public void setIdFormulario(String IdFormulario) {
		this.IdFormulario = IdFormulario;
	}

	public String getIdFormulario() {
		return this.IdFormulario;
	}



	/* Sets & Gets FK*/
	public void setSysformulario_grpsrprivilegiodfrmlro(SysFormulario sysformulario_grpsrprivilegiodfrmlro) {
		this.sysformulario_grpsrprivilegiodfrmlro = sysformulario_grpsrprivilegiodfrmlro;
	}

	public SysFormulario getSysformulario_grpsrprivilegiodfrmlro() {
		return this.sysformulario_grpsrprivilegiodfrmlro;
	}

	public void setGrupousuario_grpsrprivilegiodgrpsro(GrupoUsuario grupousuario_grpsrprivilegiodgrpsro) {
		this.grupousuario_grpsrprivilegiodgrpsro = grupousuario_grpsrprivilegiodgrpsro;
	}

	public GrupoUsuario getGrupousuario_grpsrprivilegiodgrpsro() {
		return this.grupousuario_grpsrprivilegiodgrpsro;
	}
	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	@Override
	public String toString() {
		return "[" + Crear + ", " + Eliminar + ", " + Modificar + ", " + Ver + ", " + Idgrupousuario + ", "
				+ IdFormulario + ", " + fechacreacion + "]";
	}

}