package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DALMACEN_COLUMNAS;
import java.sql.SQLException;
import java.util.List;

public class DALMACEN_COLUMNASDao extends BaseDao<DALMACEN_COLUMNAS> {
	public DALMACEN_COLUMNASDao() {
		super(DALMACEN_COLUMNAS.class);
	}

	public DALMACEN_COLUMNAS getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDALMACEN, String IDDISTRIBUCION, String IDRACK, String IDPISO, String IDFILA, String IDCOLUMNA) throws SQLException, NisiraORMException {
		List<DALMACEN_COLUMNAS> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDALMACEN = ? and IDDISTRIBUCION = ? and IDRACK = ? and IDPISO = ? and IDFILA = ? and IDCOLUMNA = ? ", IDEMPRESA, IDSUCURSAL, IDALMACEN, IDDISTRIBUCION, IDRACK, IDPISO, IDFILA, IDCOLUMNA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}