package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DZONADIAGRAMAUBICACION;
import java.sql.SQLException;
import java.util.List;

public class DZONADIAGRAMAUBICACIONDao extends BaseDao<DZONADIAGRAMAUBICACION> {
	public DZONADIAGRAMAUBICACIONDao() {
		super(DZONADIAGRAMAUBICACION.class);
	}

	public DZONADIAGRAMAUBICACION getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDZONA, Integer IDSUCURSAL, Integer CORDENADAX, Integer CORDENADAY, String IDUBICACION) throws SQLException, NisiraORMException {
		List<DZONADIAGRAMAUBICACION> l = listar(con,"IDEMPRESA = ? and IDZONA = ? and IDSUCURSAL = ? and CORDENADAX = ? and CORDENADAY = ? and IDUBICACION = ? ", IDEMPRESA, IDZONA, IDSUCURSAL, CORDENADAX, CORDENADAY, IDUBICACION);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	/*TEMPORAL : SOLO ALMACENES*/
	public List<DZONADIAGRAMAUBICACION> getListarDZonaDiagrama(int con,Integer IDEMPRESA, Integer IDSUCURSAL,Integer IDALMACEN) throws SQLException, NisiraORMException {
		List<DZONADIAGRAMAUBICACION> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDALMACEN = ? ", IDEMPRESA, IDSUCURSAL,IDALMACEN);
		if (l.isEmpty()) {
			return null;
		} else {
			return l;
		}
	}
}