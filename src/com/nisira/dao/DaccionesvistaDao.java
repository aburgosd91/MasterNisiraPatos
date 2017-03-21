package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.DACCIONESVISTA;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class DaccionesvistaDao extends BaseDao<DACCIONESVISTA> {
	public DaccionesvistaDao() {
		super(DACCIONESVISTA.class);
	}
	public DaccionesvistaDao(boolean usaCnBase) throws NisiraORMException {
		super(1,DACCIONESVISTA.class, usaCnBase);
	}

	public DACCIONESVISTA getPorClavePrimaria(Integer IDEMPRESA, Integer IDACCION, String VISTA) throws NisiraORMException {
		List<DACCIONESVISTA> l = listar(1,"t0.IDEMPRESA = ? and t0.IDACCION = ? and t0.VISTA = ? ", IDEMPRESA, IDACCION, VISTA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public List<DACCIONESVISTA> findAllVista(Integer IDEMPRESA,String VISTA) throws NisiraORMException{
		List<DACCIONESVISTA> l = listar(1,"t0.IDEMPRESA = ? and t0.VISTA = ? ", IDEMPRESA, VISTA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l;
		}
	}
}