package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DALMACEN_DISTRIBUCIONUBICACION;
import java.sql.SQLException;
import java.util.List;

public class DALMACEN_DISTRIBUCIONUBICACIONDao extends BaseDao<DALMACEN_DISTRIBUCIONUBICACION> {
	public DALMACEN_DISTRIBUCIONUBICACIONDao() {
		super(DALMACEN_DISTRIBUCIONUBICACION.class);
	}

	public DALMACEN_DISTRIBUCIONUBICACION getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDALMACEN, String IDDISTRIBUCION) throws SQLException, NisiraORMException {
		List<DALMACEN_DISTRIBUCIONUBICACION> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDALMACEN = ? and IDDISTRIBUCION = ? ", IDEMPRESA, IDSUCURSAL, IDALMACEN, IDDISTRIBUCION);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}