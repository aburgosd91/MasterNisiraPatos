package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DocumentosEnviados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class DocumentosEnviadosDao extends BaseDao<DocumentosEnviados> {
	public DocumentosEnviadosDao() {
		super(DocumentosEnviados.class);
	}

	public DocumentosEnviados getPorClavePrimaria(int con,String IdOrigen, String IdUnico) throws SQLException, NisiraORMException {
		List<DocumentosEnviados> l = listar(con,"IdOrigen = ? and IdUnico = ? ", IdOrigen, IdUnico);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	
	/*-Inicio-*/
	public List<Object[]> getRPTConsolidado(int con,java.util.Date desde, java.util.Date hasta) throws SQLException {
		
		Calendar c = Calendar.getInstance();
		
		c.setTime(hasta);
		
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		
		hasta = c.getTime();
		
		java.sql.Timestamp tdesde, thasta;
		
		tdesde = new java.sql.Timestamp(desde.getTime());
		thasta = new java.sql.Timestamp(hasta.getTime());
		
		String sql = "select o.idorigen, o.descripcion, d.idunico,  d.documento, d.idclieprov, d.razonsocial, d.fecha, d.NombreArchivo, dd.Codigo, dd.Descripcion "
				+ " from DocumentosEnviados d left join DDocumentosEnviados dd on d.idorigen = dd.idorigen and d.idunico = dd.idunico "
				+ " left join OrigenDato o on d.IdOrigen = o.idorigen "
				+ " where d.fecha >= ? and d.fecha <= ?";
		
		
		Connection cn = obtenerConexion(con);
		PreparedStatement ps = cn.prepareStatement(sql);

		ps.setTimestamp(1, tdesde);
		ps.setTimestamp(2, thasta);
		
		ResultSet rs = ps.executeQuery();
		
		return rsToObjectArray(rs);
	}
	/*-Fin-*/
}