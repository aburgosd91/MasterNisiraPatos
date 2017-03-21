package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.MONTACARGA;
import java.sql.SQLException;
import java.util.List;

public class MONTACARGADao extends BaseDao<MONTACARGA> {
	public MONTACARGADao() {
		super(MONTACARGA.class);
	}

	public MONTACARGA getPorClavePrimaria(Integer IDEMPRESA, Integer IDMONTACARGA) throws SQLException, NisiraORMException {
		List<MONTACARGA> l = listar(1,"IDEMPRESA = ? and IDMONTACARGA = ? ", IDEMPRESA, IDMONTACARGA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}