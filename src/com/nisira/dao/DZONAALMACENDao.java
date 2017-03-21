package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DZONAALMACEN;
import java.sql.SQLException;
import java.util.List;

public class DZONAALMACENDao extends BaseDao<DZONAALMACEN> {
	public DZONAALMACENDao() {
		super(DZONAALMACEN.class);
	}

	public DZONAALMACEN getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDZONA, Integer IDALMACEN) throws SQLException, NisiraORMException {
		List<DZONAALMACEN> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDZONA = ? and IDALMACEN = ? ", IDEMPRESA, IDSUCURSAL, IDZONA, IDALMACEN);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public List<DZONAALMACEN> getPorZona(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDZONA) throws SQLException, NisiraORMException {
		List<DZONAALMACEN> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDZONA = ? ", IDEMPRESA, IDSUCURSAL, IDZONA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l;
		}
	}
}