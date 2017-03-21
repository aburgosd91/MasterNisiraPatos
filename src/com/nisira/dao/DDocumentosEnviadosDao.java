package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DDocumentosEnviados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DDocumentosEnviadosDao extends BaseDao<DDocumentosEnviados> {
	public DDocumentosEnviadosDao() {
		super(DDocumentosEnviados.class);
	}

	public DDocumentosEnviados getPorClavePrimaria(int con,String IdOrigen, String IdUnico, Integer Item) throws SQLException, NisiraORMException {
		List<DDocumentosEnviados> l = listar(con,"IdOrigen = ? and IdUnico = ? and Item = ? ", IdOrigen, IdUnico, Item);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	
	/*-Inicio-*/
	public void borrar (int con,String IdOrigen, String IdUnico) throws SQLException {
		String sql = "delete from DDocumentosEnviados where IdOrigen = ? and IdUnico = ?";

		Connection cn = obtenerConexion(con);

		PreparedStatement ps = cn.prepareStatement(sql);

		ps.setString(1, IdOrigen);
		ps.setString(2, IdUnico);
		
		ps.execute();
		cn.close();
	}
	/*-Fin-*/
}