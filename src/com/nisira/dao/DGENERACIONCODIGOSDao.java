package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DGENERACIONCODIGOS;
import com.nisira.entidad.GENERACIONCODIGOS;
import com.nisira.entidad.GrupoUsuario;
import com.nisira.entidad.GrupoUsuarioPrivilegio;

import java.sql.SQLException;
import java.util.List;

public class DGENERACIONCODIGOSDao extends BaseDao<DGENERACIONCODIGOS> {
	public DGENERACIONCODIGOSDao() {
		super(DGENERACIONCODIGOS.class);
	}

	public DGENERACIONCODIGOS getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDGENERACION, Integer IDREGISTROCODIGO) throws SQLException, NisiraORMException {
		List<DGENERACIONCODIGOS> l = listar(con,"IDEMPRESA = ? and IDGENERACION = ? and IDREGISTROCODIGO = ? ", IDEMPRESA, IDGENERACION, IDREGISTROCODIGO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	/*-Inicio-*/

	public List<DGENERACIONCODIGOS> getPorGeneracionCodigo(int con,
			GENERACIONCODIGOS generacionCodigo) throws SQLException, NisiraORMException {
		return listar(con,"IDEMPRESA = ? and IDGENERACION = ? ", generacionCodigo.getIDEMPRESA(), generacionCodigo.getIDGENERACION());
	}

	/*-Fin-*/
}