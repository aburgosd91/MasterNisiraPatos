package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DALMACEN_RACKS;
import java.sql.SQLException;
import java.util.List;

public class DALMACEN_RACKSDao extends BaseDao<DALMACEN_RACKS> {
	public DALMACEN_RACKSDao() {
		super(DALMACEN_RACKS.class);
	}

	public DALMACEN_RACKS getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDALMACEN, String IDDISTRIBUCION, Integer IDRACK) throws SQLException, NisiraORMException {
		List<DALMACEN_RACKS> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDALMACEN = ? and IDDISTRIBUCION = ? and IDRACK = ? ", IDEMPRESA, IDSUCURSAL, IDALMACEN, IDDISTRIBUCION, IDRACK);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}