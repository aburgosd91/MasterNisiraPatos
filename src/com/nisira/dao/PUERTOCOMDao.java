package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.PUERTOCOM;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class PUERTOCOMDao extends BaseDao<PUERTOCOM> {
	public PUERTOCOMDao() {
		super(PUERTOCOM.class);
	}
	public PUERTOCOMDao(boolean usaCnBase) throws NisiraORMException {
		super(PUERTOCOM.class);
	}

	public PUERTOCOM getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDPUERTOCOM) throws NisiraORMException {
		List<PUERTOCOM> l = listar(con,"t0.IDEMPRESA = ? and t0.IDPUERTOCOM = ? ", IDEMPRESA, IDPUERTOCOM);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}