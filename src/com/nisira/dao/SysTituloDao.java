package com.nisira.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.SysModulo;
import com.nisira.entidad.SysTitulo;

public class SysTituloDao extends BaseDao<SysTitulo> {
	public SysTituloDao() {
		super(SysTitulo.class);
	}
	
	public List<SysTitulo> getPorModulo (int con,SysModulo modulo) throws SQLException, NisiraORMException {
		return listar(con,"t0.idmodulo = ?", modulo.getIdModulo());
	}
	
	public List<SysTitulo> aEliminar(int con,SysModulo modulo, List<SysTitulo> titulos)
			throws SQLException, NisiraORMException {
		List<SysTitulo> eliminar = new ArrayList<SysTitulo>();
		for (SysTitulo o1 : getPorModulo(con,modulo)) {
			boolean existe = false;
			salir: for (SysTitulo o2 : titulos) {
				if (o1.getIdTitulo().equals(o2.getIdTitulo())
						&& o1.getIdModulo().equals(o2.getIdModulo())) {
					existe = true;
					break salir;
				}
			}
			if (!existe)
				eliminar.add(o1);
		}
		return eliminar;
	}

	public void borrarPorModulo(int con,SysModulo modulo) throws SQLException {
		String sql = "delete from SysTitulo where idmodulo = ?";
		
		Connection cn = obtenerConexion(con);

		PreparedStatement ps = cn.prepareStatement(sql);
		
		ps.setString(1, modulo.getIdModulo());
		
		ps.execute();
		cn.close();
	}
}