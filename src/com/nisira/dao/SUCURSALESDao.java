package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.SUCURSALES;
import java.sql.SQLException;
import java.util.List;

public class SUCURSALESDao extends BaseDao<SUCURSALES> {
	public SUCURSALESDao() {
		super(SUCURSALES.class);
	}

	public SUCURSALES getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDSUCURSAL) throws SQLException, NisiraORMException {
		List<SUCURSALES> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? ", IDEMPRESA, IDSUCURSAL);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}