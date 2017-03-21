package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.ZONAGENERAL;
import java.sql.SQLException;
import java.util.List;

public class ZONAGENERALDao extends BaseDao<ZONAGENERAL> {
	public ZONAGENERALDao() {
		super(ZONAGENERAL.class);
	}

	public ZONAGENERAL getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDZONAGENERAL) throws SQLException, NisiraORMException {
		List<ZONAGENERAL> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDZONAGENERAL = ? ", IDEMPRESA, IDSUCURSAL, IDZONAGENERAL);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public ZONAGENERAL getZonaGeneralPrincipal(Integer IDEMPRESA, Integer IDSUCURSAL) throws NisiraORMException{
		List<ZONAGENERAL> l = listar(1,"IDEMPRESA = ? and IDSUCURSAL = ?", IDEMPRESA, IDSUCURSAL);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}