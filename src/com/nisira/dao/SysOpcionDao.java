package com.nisira.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.nisira.core.BaseDao;
import com.nisira.core.Consulta;
import com.nisira.core.EntityTuple;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.GrupoUsuario;
import com.nisira.entidad.GrupoUsuarioPrivilegio;
import com.nisira.entidad.SysGrupo;
import com.nisira.entidad.SysOpcion;
import com.nisira.entidad.MUSUARIO;

public class SysOpcionDao extends BaseDao<SysOpcion> {
	public SysOpcionDao() {
		super(SysOpcion.class);
	}
	
	/*-Inicio-*/
	public List<SysOpcion> getPorGrupo(SysGrupo grupo) throws NisiraORMException {
		return listar(1,"t0.idmodulo = ? and t0.idtitulo = ? and t0.idgrupo = ?", grupo.getIdModulo(),
				grupo.getIdTitulo(), grupo.getIdGrupo());
	}

	@SuppressWarnings("unchecked")
	public List<SysOpcion> getPorGrupo(SysGrupo grupo, MUSUARIO usuario) throws NisiraORMException {
		
		Consulta c = getInstancia(1);
		
		c.join("inner", GrupoUsuarioPrivilegio.class, "t1", "t0.IdFormulario = t1.idFormulario");
		c.join("inner", GrupoUsuario.class, "t2", "t2 on t1.idgrupousuario = t2.idgrupousuario");
		c.join("inner", MUSUARIO.class, "t3", "t2 on t2.idgrupousuario = t3.IdgrupoUsuario");
		c.where("t1.ver = 1 and t0.idmodulo = ?", grupo.getIdModulo(), grupo.getIdTitulo(), grupo.getIdGrupo(), 
				usuario.getIdUsuario());
		
		List<SysOpcion> l = (List<SysOpcion>) EntityTuple.getListForAlias(c.execSelect(), "t0");

		return l;
	}
	
	public void borrarPorGrupo(int con,SysGrupo grupo) throws SQLException {
		String sql = "delete from SysOpcion where idmodulo = ? and idtitulo = ? and and idgrupo = ?";

		Connection cn = obtenerConexion(con);

		PreparedStatement ps = cn.prepareStatement(sql);

		ps.setString(1, grupo.getIdModulo());
		ps.setString(2, grupo.getIdTitulo());
		ps.setString(3, grupo.getIdGrupo());

		ps.execute();
		cn.close();

	}
	/*-Fin-*/
}