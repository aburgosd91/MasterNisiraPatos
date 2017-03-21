package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.MUSUARIO;

public class UsuarioDao extends BaseDao<MUSUARIO> {
	public UsuarioDao() {
		super(MUSUARIO.class);
	}
}