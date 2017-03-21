package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.PROCESOS;
import java.sql.SQLException;
import java.util.List;

public class PROCESOSDao extends BaseDao<PROCESOS> {
	public PROCESOSDao() {
		super(PROCESOS.class);
	}

	public PROCESOS getPorClavePrimaria(Integer IDEMPRESA, Integer IDPROCESO) throws SQLException, NisiraORMException {
		List<PROCESOS> l = listar(1,"IDEMPRESA = ? and IDPROCESO = ? ", IDEMPRESA, IDPROCESO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}