package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DALMACEN_PISOS;
import java.sql.SQLException;
import java.util.List;

public class DALMACEN_PISOSDao extends BaseDao<DALMACEN_PISOS> {
	public DALMACEN_PISOSDao() {
		super(DALMACEN_PISOS.class);
	}

	public DALMACEN_PISOS getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDALMACEN, String IDDISTRIBUCION, Integer IDRACK, Integer IDPISO) throws SQLException, NisiraORMException {
		List<DALMACEN_PISOS> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDALMACEN = ? and IDDISTRIBUCION = ? and IDRACK = ? and IDPISO = ? ", IDEMPRESA, IDSUCURSAL, IDALMACEN, IDDISTRIBUCION, IDRACK, IDPISO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}