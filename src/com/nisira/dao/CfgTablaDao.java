package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.CfgTabla;
import java.sql.SQLException;
import java.util.List;

public class CfgTablaDao extends BaseDao<CfgTabla> {
	public CfgTablaDao() {
		super(CfgTabla.class);
	}

	public CfgTabla getPorClavePrimaria(int con,String IdUsuario, String ventana) throws SQLException, NisiraORMException {
		List<CfgTabla> l = listar(con,"t0.IdUsuario = ? and t0.ventana = ? ", IdUsuario, ventana);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}