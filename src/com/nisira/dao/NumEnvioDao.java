package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.NumEnvio;
import java.sql.SQLException;
import java.util.List;

public class NumEnvioDao extends BaseDao<NumEnvio> {
	public NumEnvioDao() {
		super(NumEnvio.class);
	}

	public NumEnvio getPorClavePrimaria(int con,String TipoDocumento, String Fecha) throws SQLException, NisiraORMException {
		List<NumEnvio> l = listar(con,"TipoDocumento = ? and Fecha = ? ", TipoDocumento, Fecha);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}