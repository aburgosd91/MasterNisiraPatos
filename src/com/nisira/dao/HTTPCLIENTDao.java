package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.HTTPCLIENT;
import java.sql.SQLException;
import java.util.List;

public class HTTPCLIENTDao extends BaseDao<HTTPCLIENT> {
	public HTTPCLIENTDao() {
		super(HTTPCLIENT.class);
	}

	public HTTPCLIENT getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDHTTP) throws SQLException, NisiraORMException {
		List<HTTPCLIENT> l = listar(con,"IDEMPRESA = ? and IDHTTP = ? ", IDEMPRESA, IDHTTP);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}