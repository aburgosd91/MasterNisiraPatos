package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.Consulta;
import com.nisira.core.EntityTuple;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.ACCIONES;
import com.nisira.entidad.DACCIONES;
import com.nisira.entidad.DACCIONESVISTA;

import java.sql.SQLException;
import java.util.List;

public class ACCIONESDao extends BaseDao<ACCIONES> {
	public ACCIONESDao() {
		super(ACCIONES.class);
	}

	public ACCIONES getPorClavePrimaria(Integer IDEMPRESA, Integer IDACCION) throws SQLException, NisiraORMException {
		List<ACCIONES> l = listar(1,"IDEMPRESA = ? and IDACCION = ? ", IDEMPRESA, IDACCION);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public List<ACCIONES> findAccionesXVista(Integer IDEMPRESA, String Vista) throws SQLException, NisiraORMException {
		Consulta c = getInstancia(1);
		c.join("inner", DACCIONESVISTA.class, "t1", "t0.idempresa = t1.idempresa and t0.idaccion=t1.idaccion");
		c.where("t0.idempresa=? and t1.vista=?",IDEMPRESA,Vista);
		c.orderBy("t1.orden");
		List<ACCIONES> l =(List<ACCIONES>)EntityTuple.getListForAlias(c.execSelect(), "t0");
		if (l.isEmpty()) {
			return null;
		} else {
			return l;
		}
	}
}