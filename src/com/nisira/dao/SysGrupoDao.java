package com.nisira.dao;

import java.sql.SQLException;
import java.util.List;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.SysGrupo;
import com.nisira.entidad.SysTitulo;

public class SysGrupoDao extends BaseDao<SysGrupo> {
	public SysGrupoDao() {
		super(SysGrupo.class);
	}
	
	public List<SysGrupo> getPorTitulo (int con,SysTitulo titulo) throws SQLException, NisiraORMException {
		return listar(con,"t0.idmodulo = ? and t0.idtitulo = ?", titulo.getIdModulo(), titulo.getIdTitulo());
	}
}