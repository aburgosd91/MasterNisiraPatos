package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DResumen;
import java.sql.SQLException;
import java.util.List;

public class DResumenDao extends BaseDao<DResumen> {
	public DResumenDao() {
		super(DResumen.class);
	}

	public DResumen getPorClavePrimaria(int con,String idOrigen, String documento, Integer item) throws SQLException, NisiraORMException {
		List<DResumen> l = listar(con,"idOrigen = ? and documento = ? and item = ? ", idOrigen, documento, item);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}