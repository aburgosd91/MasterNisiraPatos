package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.TIPOZONA;
import java.sql.SQLException;
import java.util.List;

public class TIPOZONADao extends BaseDao<TIPOZONA> {
	public TIPOZONADao() {
		super(TIPOZONA.class);
	}

	public TIPOZONA getPorClavePrimaria(Integer IDEMPRESA, Integer IDTIPOZONA) throws SQLException, NisiraORMException {
		List<TIPOZONA> l = listar(1,"IDEMPRESA = ? and IDTIPOZONA = ? ", IDEMPRESA, IDTIPOZONA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}