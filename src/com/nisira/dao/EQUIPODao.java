package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.EQUIPO;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class EQUIPODao extends BaseDao<EQUIPO> {
	public EQUIPODao() {
		super(EQUIPO.class);
	}
	public EQUIPODao(boolean usaCnBase) throws NisiraORMException {
		super(EQUIPO.class);
	}

	public EQUIPO getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDEQUIPO) throws NisiraORMException {
		List<EQUIPO> l = listar(con,"t0.IDEMPRESA = ? and t0.IDEQUIPO = ? ", IDEMPRESA, IDEQUIPO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}