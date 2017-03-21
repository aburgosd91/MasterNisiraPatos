package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.FLOYD;
import com.nisira.core.NisiraORMException;

import java.util.Date;
import java.util.List;

public class FLOYDDao extends BaseDao<FLOYD> {
	public FLOYDDao() {
		super(FLOYD.class);
	}
	public FLOYDDao(boolean usaCnBase) throws NisiraORMException {
		super(1,FLOYD.class, usaCnBase);
	}

	public FLOYD getPorClavePrimaria(Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDFLOYD) throws NisiraORMException {
		List<FLOYD> l = listar(1,"t0.IDEMPRESA = ? and t0.IDSUCURSAL = ? and t0.IDFLOYD = ? ", IDEMPRESA, IDSUCURSAL, IDFLOYD);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public void setPorClavePrimaria(Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDFLOYD,String MATRIZ_S,String MATRIZ_D) throws NisiraORMException {
		FLOYD f = new FLOYD();
		f.setIDEMPRESA(IDEMPRESA);
		f.setIDSUCURSAL(IDSUCURSAL);
		f.setIDFLOYD(1);
		f.setMATRIZ_S(MATRIZ_S);
		f.setMATRIZ_D(MATRIZ_D);
		f.setFECHACREACION(new Date());
		mezclar(1, f);
		
	}
	
}