package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.CONFIGACTIVIDADES;
import java.sql.SQLException;
import java.util.List;

public class CONFIGACTIVIDADESDao extends BaseDao<CONFIGACTIVIDADES> {
	public CONFIGACTIVIDADESDao() {
		super(CONFIGACTIVIDADES.class);
	}

	public CONFIGACTIVIDADES getPorClavePrimaria(Integer IDACTIVIDADES, Integer IDCONFIGURACION) throws SQLException, NisiraORMException {
		List<CONFIGACTIVIDADES> l = listar(1,"IDACTIVIDADES = ? and IDCONFIGURACION = ? ", IDACTIVIDADES, IDCONFIGURACION);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public CONFIGACTIVIDADES getConfigxActividades(Integer IDACTIVIDADES) throws SQLException, NisiraORMException {
		List<CONFIGACTIVIDADES> l = listar(1,"IDACTIVIDADES = ?", IDACTIVIDADES);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}