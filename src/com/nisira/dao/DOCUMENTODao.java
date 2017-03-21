package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DOCUMENTO;
import java.sql.SQLException;
import java.util.List;

public class DOCUMENTODao extends BaseDao<DOCUMENTO> {
	public DOCUMENTODao() {
		super(DOCUMENTO.class);
	}

	public DOCUMENTO getPorClavePrimaria(Integer IDEMPRESA, String IDDOCUMENTO) throws SQLException, NisiraORMException {
		List<DOCUMENTO> l = listar(1,"IDEMPRESA = ? and IDDOCUMENTO = ? ", IDEMPRESA, IDDOCUMENTO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}