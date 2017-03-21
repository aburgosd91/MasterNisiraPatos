package com.nisira.dao;

import java.sql.SQLException;
import java.util.List;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.SysFormulario;

public class SysFormularioDao extends BaseDao<SysFormulario> {
	public SysFormularioDao() {
		super(SysFormulario.class);
	}
	
	public SysFormulario porClavePrimaria(int con,String idformulario) throws SQLException, NisiraORMException {
		List<SysFormulario> l = listar(con,"idformulario = ?", idformulario);

		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}