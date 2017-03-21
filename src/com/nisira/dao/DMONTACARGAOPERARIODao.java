package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DMONTACARGAOPERARIO;
import java.sql.SQLException;
import java.util.List;

public class DMONTACARGAOPERARIODao extends BaseDao<DMONTACARGAOPERARIO> {
	public DMONTACARGAOPERARIODao() {
		super(DMONTACARGAOPERARIO.class);
	}

	public DMONTACARGAOPERARIO getPorClavePrimaria(Integer IDEMPRESA, Integer IDMONTACARGA, String IDOPERARIO) throws SQLException, NisiraORMException {
		List<DMONTACARGAOPERARIO> l = listar(1,"IDEMPRESA = ? and IDMONTACARGA = ? and IDOPERARIO = ? ", IDEMPRESA, IDMONTACARGA, IDOPERARIO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}