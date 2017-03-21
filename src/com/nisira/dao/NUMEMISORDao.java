package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.NUMEMISOR;
import java.sql.SQLException;
import java.util.List;

public class NUMEMISORDao extends BaseDao<NUMEMISOR> {
	public NUMEMISORDao() {
		super(NUMEMISOR.class);
	}

	public NUMEMISOR getPorClavePrimaria(Integer IDEMPRESA, String IDDOCUMENTO, Integer IDSUCURSAL, String SERIE) throws SQLException, NisiraORMException {
		List<NUMEMISOR> l = listar(1,"IDEMPRESA = ? and IDDOCUMENTO = ? and IDSUCURSAL = ? and SERIE = ? ", IDEMPRESA, IDDOCUMENTO, IDSUCURSAL, SERIE);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}