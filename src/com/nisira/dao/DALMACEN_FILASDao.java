package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DALMACEN_FILAS;
import java.sql.SQLException;
import java.util.List;

public class DALMACEN_FILASDao extends BaseDao<DALMACEN_FILAS> {
	public DALMACEN_FILASDao() {
		super(DALMACEN_FILAS.class);
	}

	public DALMACEN_FILAS getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDALMACEN, String IDDISTRIBUCION, Integer IDRACK, Integer IDPISO, Integer IDFILA) throws SQLException, NisiraORMException {
		List<DALMACEN_FILAS> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDALMACEN = ? and IDDISTRIBUCION = ? and IDRACK = ? and IDPISO = ? and IDFILA = ? ", IDEMPRESA, IDSUCURSAL, IDALMACEN, IDDISTRIBUCION, IDRACK, IDPISO, IDFILA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}