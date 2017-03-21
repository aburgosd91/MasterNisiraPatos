package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.ENVIONOTIFICACION;
import com.nisira.core.NisiraORMException;

public class EnvionotificacionDao extends BaseDao<ENVIONOTIFICACION> {
	public EnvionotificacionDao() {
		super(ENVIONOTIFICACION.class);
	}
	public EnvionotificacionDao(boolean usaCnBase) throws NisiraORMException {
		super(1,ENVIONOTIFICACION.class, usaCnBase);
	}

}