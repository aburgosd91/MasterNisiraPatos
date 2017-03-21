package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.EMPRESAS;

import java.sql.SQLException;
import java.util.List;

public class EMPRESASDao extends BaseDao<EMPRESAS> {
	public EMPRESASDao() {
		super(EMPRESAS.class);
	}

	public EMPRESAS getPorClavePrimaria(Integer IDEMPRESA) throws SQLException, NisiraORMException {
		List<EMPRESAS> l = listar(1,"IDEMPRESA = ? ", IDEMPRESA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}