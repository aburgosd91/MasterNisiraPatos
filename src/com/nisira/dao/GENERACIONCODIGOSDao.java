package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.GENERACIONCODIGOS;
import java.sql.SQLException;
import java.util.List;

public class GENERACIONCODIGOSDao extends BaseDao<GENERACIONCODIGOS> {
	public GENERACIONCODIGOSDao() {
		super(GENERACIONCODIGOS.class);
	}

	public GENERACIONCODIGOS getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDGENERACION) throws SQLException, NisiraORMException {
		List<GENERACIONCODIGOS> l = listar(con,"IDEMPRESA = ? and IDGENERACION = ? ", IDEMPRESA, IDGENERACION);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}