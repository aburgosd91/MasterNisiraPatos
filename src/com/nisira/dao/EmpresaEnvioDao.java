package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.EmpresaEnvio;
import java.sql.SQLException;
import java.util.List;

public class EmpresaEnvioDao extends BaseDao<EmpresaEnvio> {
	public EmpresaEnvioDao() {
		super(EmpresaEnvio.class);
	}

	public EmpresaEnvio getPorClavePrimaria(int con,String IdEmpresa) throws SQLException, NisiraORMException {
		List<EmpresaEnvio> l = listar(con,"IdEmpresa = ? ", IdEmpresa);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}