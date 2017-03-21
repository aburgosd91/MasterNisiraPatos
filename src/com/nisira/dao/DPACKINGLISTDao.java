package com.nisira.dao;

import java.sql.SQLException;
import java.util.List;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DPACKINGLIST;
import com.nisira.entidad.PACKINGLIST;
public class DPACKINGLISTDao extends BaseDao<DPACKINGLIST>{

	public DPACKINGLISTDao() {
		super(DPACKINGLIST.class);
		// TODO Auto-generated constructor stub
	}
	public List<DPACKINGLIST> getPorGeneracionCodigo(int con,
			PACKINGLIST generacionCodigo) throws SQLException, NisiraORMException {
		return listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDPACKING=?", generacionCodigo.getIDEMPRESA(), generacionCodigo.getIDSUCURSAL(),generacionCodigo.getIDPACKING());
	}
}
