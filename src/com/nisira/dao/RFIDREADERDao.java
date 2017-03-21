package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.RFIDREADER;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class RFIDREADERDao extends BaseDao<RFIDREADER> {
	public RFIDREADERDao() {
		super(RFIDREADER.class);
	}
	public RFIDREADERDao(boolean usaCnBase) throws NisiraORMException {
		super(1,RFIDREADER.class, usaCnBase);
	}

	public RFIDREADER getPorClavePrimaria(Integer IDEMPRESA, Integer IDEQUIPOREADER, Integer IDCPUMOVIL) throws NisiraORMException {
		List<RFIDREADER> l = listar(1,"t0.IDEMPRESA = ? and t0.IDEQUIPOREADER = ? and t0.IDCPUMOVIL = ? ", IDEMPRESA, IDEQUIPOREADER);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}