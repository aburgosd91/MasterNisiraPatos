package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.Consulta;
import com.nisira.core.EntityTuple;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DACCIONES;
import com.nisira.entidad.GrupoUsuarioPrivilegio;
import com.nisira.entidad.SysOpcion;

import java.sql.SQLException;
import java.util.List;

public class DACCIONESDao extends BaseDao<DACCIONES> {
	public DACCIONESDao() {
		super(DACCIONES.class);
	}

	public DACCIONES getPorClavePrimaria(Integer IDEMPRESA, Integer IDACCION, Integer IDACTIVIDADES) throws SQLException, NisiraORMException {
		List<DACCIONES> l = listar(1,"IDEMPRESA = ? and IDACCION = ? and IDACTIVIDADES = ? ", IDEMPRESA, IDACCION, IDACTIVIDADES);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public List<DACCIONES> findDAcciones(Integer idempresa, String vista) throws SQLException, NisiraORMException {
		Consulta c = getInstancia(1);
		c.join("inner", DACCIONES.class, "t1", "t0.idempresa = t1.idempresa and t0.idaccion=t1.idaccion");
		c.where("t0.idempresa=? and t1.vista=?",idempresa,vista);
		List<DACCIONES> l = (List<DACCIONES>) EntityTuple.getListForAlias(c.execSelect(), "t0");
		
		if (l.isEmpty()) {
			return null;
		} else {
			return l;
		}
	}
}