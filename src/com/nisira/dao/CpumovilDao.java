package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.CPUMOVIL;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class CpumovilDao extends BaseDao<CPUMOVIL> {
	public CpumovilDao() {
		super(CPUMOVIL.class);
	}
	public CpumovilDao(boolean usaCnBase) throws NisiraORMException {
		super(1,CPUMOVIL.class, usaCnBase);
	}

	public CPUMOVIL getPorClavePrimaria(Integer IDEMPRESA, Integer IDCPUMOVIL) throws NisiraORMException {
		List<CPUMOVIL> l = listar(1,"t0.IDEMPRESA = ? and t0.IDCPUMOVIL = ? ", IDEMPRESA, IDCPUMOVIL);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}