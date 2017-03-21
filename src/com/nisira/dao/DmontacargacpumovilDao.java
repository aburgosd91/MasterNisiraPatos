package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.DMONTACARGACPUMOVIL;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class DmontacargacpumovilDao extends BaseDao<DMONTACARGACPUMOVIL> {
	public DmontacargacpumovilDao() {
		super(DMONTACARGACPUMOVIL.class);
	}
	public DmontacargacpumovilDao(boolean usaCnBase) throws NisiraORMException {
		super(1,DMONTACARGACPUMOVIL.class, usaCnBase);
	}

	public DMONTACARGACPUMOVIL getPorClavePrimaria(Integer IDEMPRESA, Integer IDMONTACARGA, Integer IDCPUMOVIL) throws NisiraORMException {
		List<DMONTACARGACPUMOVIL> l = listar(1,"t0.IDEMPRESA = ? and t0.IDMONTACARGA = ? and t0.IDCPUMOVIL = ? ", IDEMPRESA, IDMONTACARGA, IDCPUMOVIL);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}