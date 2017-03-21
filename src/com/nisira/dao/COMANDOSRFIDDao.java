package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.COMANDOSRFID;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class COMANDOSRFIDDao extends BaseDao<COMANDOSRFID> {
	public COMANDOSRFIDDao() {
		super(COMANDOSRFID.class);
	}
	public COMANDOSRFIDDao(boolean usaCnBase) throws NisiraORMException {
		super(COMANDOSRFID.class);
	}

	public COMANDOSRFID getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDCOMANDO) throws NisiraORMException {
		List<COMANDOSRFID> l = listar(con,"t0.IDEMPRESA = ? and t0.IDCOMANDO = ? ", IDEMPRESA, IDCOMANDO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}