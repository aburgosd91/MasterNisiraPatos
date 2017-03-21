package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DMONTACARGAEQUIPO;
import java.sql.SQLException;
import java.util.List;

public class DMONTACARGAEQUIPODao extends BaseDao<DMONTACARGAEQUIPO> {
	public DMONTACARGAEQUIPODao() {
		super(DMONTACARGAEQUIPO.class);
	}

	public DMONTACARGAEQUIPO getPorClavePrimaria(Integer IDEMPRESA, Integer IDMONTACARGA, Integer IDEQUIPO) throws SQLException, NisiraORMException {
		List<DMONTACARGAEQUIPO> l = listar(1,"IDEMPRESA = ? and IDMONTACARGA = ? and IDEQUIPO = ? ", IDEMPRESA, IDMONTACARGA, IDEQUIPO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}