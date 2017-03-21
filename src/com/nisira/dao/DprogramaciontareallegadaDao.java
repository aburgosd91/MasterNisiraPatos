package com.nisira.dao;

import java.util.List;

import com.nisira.core.BaseDao;
import com.nisira.core.Consulta;
import com.nisira.core.EntityTuple;
import com.nisira.entidad.DPROGRAMACIONTAREALLEGADA;
import com.nisira.core.NisiraORMException;

public class DprogramaciontareallegadaDao extends BaseDao<DPROGRAMACIONTAREALLEGADA> {
	public DprogramaciontareallegadaDao() {
		super(DPROGRAMACIONTAREALLEGADA.class);
	}
	public DprogramaciontareallegadaDao(boolean usaCnBase) throws NisiraORMException {
		super(1,DPROGRAMACIONTAREALLEGADA.class, usaCnBase);
	}
	public List<DPROGRAMACIONTAREALLEGADA> findDPROGRAMACIONTAREALLEGADA(Integer IDEMPRESA, Integer IDSUCURSAL,
			String IDTAREA) throws NisiraORMException{
		String where= "t0.IDEMPRESA = ? AND t0.IDSUCURSAL = ? AND t0.IDPROGRAMACIONTAREA = ? ";
		Consulta c = getInstancia(1);
		c.where(where, IDEMPRESA, IDSUCURSAL, IDTAREA);
		c.orderBy("t0.ITEM");
		List<DPROGRAMACIONTAREALLEGADA> l = (List<DPROGRAMACIONTAREALLEGADA>) EntityTuple.getListForAlias(c.execSelect(), "t0");
		//listarOrderBy(con,"IDEMPRESA = ? and IDPROGRAMACIONLLENADO = ? and IDSUCURSAL = ? and ESTADO=? ","PRIORIDAD",IDEMPRESA, IDPROGRAMACIONLLENADO, IDSUCURSAL,ESTADO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l;
		}
	}
}