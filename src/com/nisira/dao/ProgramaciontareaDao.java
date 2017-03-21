package com.nisira.dao;

import java.util.List;

import com.nisira.core.BaseDao;
import com.nisira.core.Consulta;
import com.nisira.core.EntityTuple;
import com.nisira.entidad.DPROGRAMAALMEJECUCION;
import com.nisira.entidad.PROGRAMACIONTAREA;
import com.nisira.core.NisiraORMException;

public class ProgramaciontareaDao extends BaseDao<PROGRAMACIONTAREA> {
	public ProgramaciontareaDao() {
		super(PROGRAMACIONTAREA.class);
	}
	public ProgramaciontareaDao(boolean usaCnBase) throws NisiraORMException {
		super(1,PROGRAMACIONTAREA.class, usaCnBase);
	}
	public PROGRAMACIONTAREA findProgramacionTarea(int IDEMPRESA,int IDSUCURSAL, String toquenNotificacion,
			int IDMONTACARGA,int estado) throws NisiraORMException{
		/*
		 * PENDIENTE(1) 
		 * EJECUTADO(2)
		 * CANCELADO(3)
		 * */
		String where= "t0.IDEMPRESA = ? AND t0.IDSUCURSAL = ? AND t0.IDPROGRAMACIONTAREA = ? "
				+ " AND t0.IDMONTACARGA=? and t0.ESTADO=? ";
		/*NUEVO PROCESO*/
		Consulta c = getInstancia(1);
		c.where(where, IDEMPRESA, IDSUCURSAL, toquenNotificacion,IDMONTACARGA,estado);
		c.orderBy("t0.FECHAPROGRAMACION");
		List<PROGRAMACIONTAREA> l = (List<PROGRAMACIONTAREA>) EntityTuple.getListForAlias(c.execSelect(), "t0");
		//listarOrderBy(con,"IDEMPRESA = ? and IDPROGRAMACIONLLENADO = ? and IDSUCURSAL = ? and ESTADO=? ","PRIORIDAD",IDEMPRESA, IDPROGRAMACIONLLENADO, IDSUCURSAL,ESTADO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}