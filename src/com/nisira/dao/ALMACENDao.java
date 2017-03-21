package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.ALMACEN;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class ALMACENDao extends BaseDao<ALMACEN> {
	public ALMACENDao() {
		super(ALMACEN.class);
	}

	public ALMACEN getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDALMACEN, Integer IDSUCURSAL) throws SQLException, NisiraORMException {
		List<ALMACEN> l = listar(con,"IDEMPRESA = ? and IDALMACEN = ? and IDSUCURSAL = ? ", IDEMPRESA, IDALMACEN, IDSUCURSAL);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public List<ALMACEN> enTodo(int con,Integer IDEMPRESA,Integer IDSUCURSAL,Timestamp ini,Timestamp fin) throws SQLException, NisiraORMException{
		List<ALMACEN> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and FECHACREACION BETWEEN ? and ?",IDEMPRESA,IDSUCURSAL,ini,fin);
		return l;
	}
}