package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.CONFOG;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class ConfogDao extends BaseDao<CONFOG> {
	public ConfogDao() {
		super(CONFOG.class);
	}

	public CONFOG getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDOGCONFIG) throws NisiraORMException {
		List<CONFOG> l = listar(con,"t0.IDEMPRESA = ? and t0.IDSUCURSAL = ? and t0.IDOGCONFIG = ? ", IDEMPRESA, IDSUCURSAL, IDOGCONFIG);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}