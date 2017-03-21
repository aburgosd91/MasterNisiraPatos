package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.CONFINICIO;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class ConfinicioDao extends BaseDao<CONFINICIO> {
	public ConfinicioDao() {
		super(CONFINICIO.class);
	}

	public CONFINICIO getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDCONFIG) throws NisiraORMException {
		List<CONFINICIO> l = listar(con,"t0.IDEMPRESA = ? and t0.IDSUCURSAL = ? and t0.IDCONFIG = ? ", IDEMPRESA, IDSUCURSAL, IDCONFIG);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}