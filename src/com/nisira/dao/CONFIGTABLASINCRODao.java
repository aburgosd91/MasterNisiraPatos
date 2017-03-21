package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.CONFIGTABLASINCRO;
import java.sql.SQLException;
import java.util.List;

public class CONFIGTABLASINCRODao extends BaseDao<CONFIGTABLASINCRO> {
	public CONFIGTABLASINCRODao() {
		super(CONFIGTABLASINCRO.class);
	}

	public CONFIGTABLASINCRO getPorClavePrimaria(Integer IDEMPRESA, Integer IDTABLASINCRO) throws SQLException, NisiraORMException {
		List<CONFIGTABLASINCRO> l = listar(1,"IDEMPRESA = ? and IDTABLASINCRO = ? ", IDEMPRESA, IDTABLASINCRO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}