package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.PRODUCTOS;
import java.sql.SQLException;
import java.util.List;

public class PRODUCTOSDao extends BaseDao<PRODUCTOS> {
	public PRODUCTOSDao() {
		super(PRODUCTOS.class);
	}

	public PRODUCTOS getPorClavePrimaria(String IDEMPRESA, String IDPRODUCTO) throws SQLException, NisiraORMException {
		List<PRODUCTOS> l = listar(1,"IDEMPRESA = ? and IDPRODUCTO = ? ", IDEMPRESA, IDPRODUCTO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}