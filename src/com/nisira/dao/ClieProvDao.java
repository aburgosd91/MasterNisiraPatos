package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.ClieProv;
import java.sql.SQLException;
import java.util.List;

public class ClieProvDao extends BaseDao<ClieProv> {
	public ClieProvDao() {
		super(ClieProv.class);
	}

	public ClieProv getPorClavePrimaria(int con,String IdClieprov) throws SQLException, NisiraORMException {
		List<ClieProv> l = listar(con,"IdClieprov = ? ", IdClieprov);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}