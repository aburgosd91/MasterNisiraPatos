package com.nisira.dao;

import java.sql.SQLException;
import java.util.List;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.SysModulo;

public class SysModuloDao extends BaseDao<SysModulo> {
	public SysModuloDao() {
		super(SysModulo.class);
	}

	public SysModulo porClavePrimaria(int con,String idmodulo) throws SQLException, NisiraORMException {
		List<SysModulo> l = listar(con,"idmodulo = ?", idmodulo);

		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}