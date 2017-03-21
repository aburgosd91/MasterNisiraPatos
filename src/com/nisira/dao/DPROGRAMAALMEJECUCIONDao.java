package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.Consulta;
import com.nisira.core.EntityTuple;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DALMACENDIAGRAMA;
import com.nisira.entidad.DPROGRAMAALMEJECUCION;
import java.sql.SQLException;
import java.util.List;

public class DPROGRAMAALMEJECUCIONDao extends BaseDao<DPROGRAMAALMEJECUCION> {
	public DPROGRAMAALMEJECUCIONDao() {
		super(DPROGRAMAALMEJECUCION.class);
	}

	public DPROGRAMAALMEJECUCION getPorClavePrimaria(int con,Integer IDEMPRESA, String IDPROGRAMACIONLLENADO, Integer IDSUCURSAL, Integer IDALMACEN, Integer IDRACK, String IDDISTRIBUCION, Integer IDPISO, Integer IDFILA, Integer IDCOLUMNA) throws SQLException, NisiraORMException {
		List<DPROGRAMAALMEJECUCION> l = listar(con,"IDEMPRESA = ? and IDPROGRAMACIONLLENADO = ? and IDSUCURSAL = ? and IDALMACEN = ? and IDRACK = ? and IDDISTRIBUCION = ? and IDPISO = ? and IDFILA = ? and IDCOLUMNA = ? ", IDEMPRESA, IDPROGRAMACIONLLENADO, IDSUCURSAL, IDALMACEN, IDRACK, IDDISTRIBUCION, IDPISO, IDFILA, IDCOLUMNA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public List<DPROGRAMAALMEJECUCION> getListDPROGRAMAALMEJECUCION(Integer IDEMPRESA,Integer IDSUCURSAL, 
			String IDPROGRAMACIONLLENADO,String ESTADO) throws SQLException, NisiraORMException {
		int con=1;
		String where= "t0.IDEMPRESA = ? and t0.IDPROGRAMACIONLLENADO = ? and t0.IDSUCURSAL = ? and t0.ESTADO=? ";
		/*NUEVO PROCESO*/
		Consulta c = getInstancia(con);
		c.where(where, IDEMPRESA, IDPROGRAMACIONLLENADO, IDSUCURSAL,ESTADO);
		c.orderBy("t0.PRIORIDAD");
		List<DPROGRAMAALMEJECUCION> l = (List<DPROGRAMAALMEJECUCION>) EntityTuple.getListForAlias(c.execSelect(), "t0");
		//listarOrderBy(con,"IDEMPRESA = ? and IDPROGRAMACIONLLENADO = ? and IDSUCURSAL = ? and ESTADO=? ","PRIORIDAD",IDEMPRESA, IDPROGRAMACIONLLENADO, IDSUCURSAL,ESTADO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l;
		}
	}
}