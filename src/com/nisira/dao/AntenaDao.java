package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.ANTENA;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class AntenaDao extends BaseDao<ANTENA> {
	public AntenaDao() {
		super(ANTENA.class);
	}
	public AntenaDao(boolean usaCnBase) throws NisiraORMException {
		super(1,ANTENA.class, usaCnBase);
	}

	public ANTENA getPorClavePrimaria(Integer IDEMPRESA, Integer IDANTENA) throws NisiraORMException {
		List<ANTENA> l = listar(1,"t0.IDEMPRESA = ? and t0.IDANTENA = ? ", IDEMPRESA, IDANTENA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}