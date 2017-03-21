package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DZONAACCESORIO;
import java.sql.SQLException;
import java.util.List;

public class DZONAACCESORIODao extends BaseDao<DZONAACCESORIO> {
	public DZONAACCESORIODao() {
		super(DZONAACCESORIO.class);
	}

	public DZONAACCESORIO getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDZONA, Integer IDSUCURSAL, Integer IDACCESORIO) throws SQLException, NisiraORMException {
		List<DZONAACCESORIO> l = listar(con,"IDEMPRESA = ? and IDZONA = ? and IDSUCURSAL = ? and IDACCESORIO = ? ", IDEMPRESA, IDZONA, IDSUCURSAL, IDACCESORIO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}