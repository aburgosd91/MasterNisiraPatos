package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.PARAMETRO_DISTRIBUCION;
import java.sql.SQLException;
import java.util.List;

public class PARAMETRO_DISTRIBUCIONDao extends BaseDao<PARAMETRO_DISTRIBUCION> {
	public PARAMETRO_DISTRIBUCIONDao() {
		super(PARAMETRO_DISTRIBUCION.class);
	}

	public PARAMETRO_DISTRIBUCION getPorClavePrimaria(String IDEMPRESA, String IDPARAMETRO) throws SQLException, NisiraORMException {
		List<PARAMETRO_DISTRIBUCION> l = listar(1,"IDEMPRESA = ? and IDPARAMETRO = ? ", IDEMPRESA, IDPARAMETRO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}