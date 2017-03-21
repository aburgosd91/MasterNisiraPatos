package com.nisira.dao;

import java.sql.SQLException;
import java.util.List;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.GrupoUsuario;
import com.nisira.entidad.GrupoUsuarioPrivilegio;

public class GrupoUsuarioPrivilegioDao extends BaseDao<GrupoUsuarioPrivilegio> {
	public GrupoUsuarioPrivilegioDao() {
		super(GrupoUsuarioPrivilegio.class);
	}

	/*-Inicio-*/

	public List<GrupoUsuarioPrivilegio> getPorGrupoUsuario(int con,
			GrupoUsuario grupousuario) throws SQLException, NisiraORMException {
		return listar(con,"t0.idgrupousuario = ?", grupousuario.getIdgrupousuario());
	}

	/*-Fin-*/
}