package com.nisira.dao;

import java.util.ArrayList;
import java.util.List;

import com.nisira.core.BaseDao;
import com.nisira.core.Consulta;
import com.nisira.core.EntityTuple;
import com.nisira.entidad.DPROGRAMACIONTAREAPARTIDA;
import com.nisira.entidad.PROGRAMACIONTAREA;
import com.nisira.core.NisiraORMException;

public class DprogramaciontareapartidaDao extends BaseDao<DPROGRAMACIONTAREAPARTIDA> {
	public DprogramaciontareapartidaDao() {
		super(DPROGRAMACIONTAREAPARTIDA.class);
	}
	public DprogramaciontareapartidaDao(boolean usaCnBase) throws NisiraORMException {
		super(1,DPROGRAMACIONTAREAPARTIDA.class, usaCnBase);
	}
	public List<DPROGRAMACIONTAREAPARTIDA> findDPROGRAMACIONTAREAPARTIDA(Integer IDEMPRESA, Integer IDSUCURSAL,
			String IDTAREA) throws NisiraORMException{
		String where= "t0.IDEMPRESA = ? AND t0.IDSUCURSAL = ? AND t0.IDPROGRAMACIONTAREA = ? ";
		Consulta c = getInstancia(1);
		c.where(where, IDEMPRESA, IDSUCURSAL, IDTAREA);
		c.orderBy("t0.ITEM");
		List<DPROGRAMACIONTAREAPARTIDA> l = (List<DPROGRAMACIONTAREAPARTIDA>) EntityTuple.getListForAlias(c.execSelect(), "t0");
		//listarOrderBy(con,"IDEMPRESA = ? and IDPROGRAMACIONLLENADO = ? and IDSUCURSAL = ? and ESTADO=? ","PRIORIDAD",IDEMPRESA, IDPROGRAMACIONLLENADO, IDSUCURSAL,ESTADO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l;
		}
	}
}