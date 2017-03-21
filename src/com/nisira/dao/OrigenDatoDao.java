package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.EmpresaEnvio;
import com.nisira.entidad.OrigenDato;
import java.sql.SQLException;
import java.util.List;

public class OrigenDatoDao extends BaseDao<OrigenDato> {
	public OrigenDatoDao() {
		super(OrigenDato.class);
	}

	public OrigenDato getPorClavePrimaria(int con,String idorigen) throws SQLException, NisiraORMException {
		List<OrigenDato> l = listar(con,"t0.idorigen = ? ", idorigen);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	
	/*-Inicio-*/
	
	public List<OrigenDato> getPorClaveIdEmpresaEnvio(int con,String idEmpresa) throws SQLException, NisiraORMException {
		List<OrigenDato> l = listar(con,"t0.idempresa = ? ", idEmpresa);
		return l;
	}
	
	/*-Fin-*/
}