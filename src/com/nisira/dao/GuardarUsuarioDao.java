package com.nisira.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nisira.core.BaseDao;
import com.nisira.entidad.GuardarUsuario;

public class GuardarUsuarioDao extends BaseDao<GuardarUsuario> {
	public GuardarUsuarioDao() {
		super(GuardarUsuario.class);
	}
	
	/*-Inicio-*/
	public void borrarPorHostName(int con,String hostname) throws SQLException {
		String sql = "delete from GuardarUsuario where namehost = ?";

		Connection cn = obtenerConexion(con);

		PreparedStatement ps = cn.prepareStatement(sql);

		ps.setString(1, hostname);
		
		ps.execute();
		cn.close();
	}
	/*-Fin-*/
}