package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.Resumen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ResumenDao extends BaseDao<Resumen> {
	public ResumenDao() {
		super(Resumen.class);
	}

	public Resumen getPorClavePrimaria(int con,String IdEmpresa, String Documento) throws SQLException, NisiraORMException {
		List<Resumen> l = listar(con,"IdEmpresa = ? and Documento = ? ", IdEmpresa, Documento);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	
	public List<Resumen> getPorIdEmpresaFechaResumen(int con,String IdEmpresa, Date fecha) throws SQLException, NisiraORMException {
		return listar(con,"t0.IdEmpresa = ? and t0.fecharesumen = ?", IdEmpresa, fecha);
	}
	
	public List<Resumen> getTicketsPendiente(int con,String IdEmpresa, Date fechaInicio,Date fechaFin) throws SQLException, NisiraORMException {
		return listar(con,"t0.IdEmpresa = ? and t0.fecharesumen between ? and ? ", IdEmpresa, fechaInicio,fechaFin);
	}
	
	/*-Inicio-*/
	public void actualizarEstado (int con,String IdEmpresa, String Documento,String idEstado) throws SQLException {
		String sql = "update resumen set idestado=? where idempresa = ? and documento = ? ";

		Connection cn = obtenerConexion(con);

		PreparedStatement ps = cn.prepareStatement(sql);

		ps.setString(1, idEstado);
		ps.setString(2, IdEmpresa);
		ps.setString(3, Documento);
		
		ps.execute();
		cn.close();
	}
	/*-Fin-*/
	
}