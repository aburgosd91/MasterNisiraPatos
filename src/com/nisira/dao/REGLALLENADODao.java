package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.REGLALLENADO;
import java.sql.SQLException;
import java.util.List;

public class REGLALLENADODao extends BaseDao<REGLALLENADO> {
	public REGLALLENADODao() {
		super(REGLALLENADO.class);
	}

	public REGLALLENADO getPorClavePrimaria(Integer IDEMPRESA, Integer IDSUCURSAL, String IDREGLAS) throws SQLException, NisiraORMException {
		List<REGLALLENADO> l = listar(1,"IDEMPRESA = ? and IDSUCURSAL = ? and IDREGLAS = ? ", IDEMPRESA, IDSUCURSAL, IDREGLAS);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}