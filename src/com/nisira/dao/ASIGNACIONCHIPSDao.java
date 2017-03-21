package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.ASIGNACIONCHIPS;
import java.sql.SQLException;
import java.util.List;

public class ASIGNACIONCHIPSDao extends BaseDao<ASIGNACIONCHIPS> {
	public ASIGNACIONCHIPSDao() {
		super(ASIGNACIONCHIPS.class);
	}

	public ASIGNACIONCHIPS getPorClavePrimaria(Integer IDEMPRESA, Integer IDSUCURSAL, String IDASIGNACIONCHIPS) throws SQLException, NisiraORMException {
		List<ASIGNACIONCHIPS> l = listar(1,"IDEMPRESA = ? and IDSUCURSAL = ? and IDASIGNACIONCHIPS = ? ", IDEMPRESA, IDSUCURSAL, IDASIGNACIONCHIPS);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}