package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.Consulta;
import com.nisira.core.EntityTuple;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DALMACENDIAGRAMA;
import java.sql.SQLException;
import java.util.List;

public class DALMACENDIAGRAMADao extends BaseDao<DALMACENDIAGRAMA> {
	public DALMACENDIAGRAMADao() {
		super(DALMACENDIAGRAMA.class);
	}

	public DALMACENDIAGRAMA getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDALMACEN, Integer CORDENADAX, Integer CORDENADAY) throws SQLException, NisiraORMException {
		List<DALMACENDIAGRAMA> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDALMACEN = ? and CORDENADAX = ? and CORDENADAY = ? ", IDEMPRESA, IDSUCURSAL, IDALMACEN, CORDENADAX, CORDENADAY);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public List<DALMACENDIAGRAMA> getPorAlmacen(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDALMACEN) throws SQLException, NisiraORMException {
		List<DALMACENDIAGRAMA> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDALMACEN = ? ", IDEMPRESA, IDSUCURSAL, IDALMACEN);
		if (l.isEmpty()) {
			return null;
		} else {
			return l;
		}
	}
	public List<DALMACENDIAGRAMA> getPorAlmacenOrderBy(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDALMACEN) throws SQLException, NisiraORMException {
		String p1="IDEMPRESA";
		String p2="IDSUCURSAL";
		String p3="IDRACK";
		String p4="CORDENADAX";
		String p5="CORDENADAY";
		String where= "t0.IDEMPRESA = ? and t0.IDSUCURSAL = ? and t0.IDALMACEN = ? ";
		/*NUEVO PROCESO*/
		Consulta c = getInstancia(con);
		c.where(where, IDEMPRESA, IDSUCURSAL, IDALMACEN);
		c.orderBy("t0.CORDENADAX,t0.CORDENADAY");
		List<DALMACENDIAGRAMA> l = (List<DALMACENDIAGRAMA>) EntityTuple.getListForAlias(c.execSelect(), "t0");
		if (l.isEmpty()) {
			return null;
		} else {
			return l;
		}
	}
}