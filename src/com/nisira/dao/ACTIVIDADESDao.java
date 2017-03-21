package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.Conexion;
import com.nisira.core.Consulta;
import com.nisira.core.EntityTuple;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.ACTIVIDADES;
import com.nisira.entidad.CONFIGACTIVIDADES;
import com.nisira.entidad.DACCIONES;
import com.nisira.entidad.DACCIONESVISTA;
import com.nisira.entidad.DZONAGENERAL;
import com.nisira.entidad.ENVIONOTIFICACION;
import com.nisira.entidad.NOTIFICACION;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ACTIVIDADESDao extends BaseDao<ACTIVIDADES> {
	public ACTIVIDADESDao() {
		super(ACTIVIDADES.class);
	}

	public ACTIVIDADES getPorClavePrimaria(Integer IDEMPRESA, Integer IDACTIVIDADES) throws SQLException, NisiraORMException {
		List<ACTIVIDADES> l = listar(1,"IDEMPRESA = ? and IDACTIVIDADES = ? ", IDEMPRESA, IDACTIVIDADES);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public List<ACTIVIDADES> findAllActividadesVista(Integer IDEMPRESA, String VISTA) throws NisiraORMException, SQLException{
		String sql= "SELECT DISTINCT ATV.*,CF.TIPO FROM ACTIVIDADES ATV"
				+ " INNER JOIN DACCIONES DA ON DA.IDEMPRESA=ATV.IDEMPRESA AND DA.IDACTIVIDADES=ATV.IDACTIVIDADES"
				+ " INNER JOIN DACCIONESVISTA DAV ON DAV.IDEMPRESA=ATV.IDEMPRESA AND DAV.IDACCION=DA.IDACCION"
				+ " INNER JOIN CONFIGACTIVIDADES CF ON CF.IDEMPRESA=ATV.IDEMPRESA AND CF.IDACTIVIDADES=ATV.IDACTIVIDADES" 
				+ " WHERE ATV.IDEMPRESA=? AND DAV.VISTA=?";
				
				Connection cn = obtenerConexion(1);
				PreparedStatement ps = cn.prepareStatement(sql);
				
				ps.setInt(1, IDEMPRESA);
				ps.setString(2, VISTA);
				
				ResultSet rs = ps.executeQuery();
				List<ACTIVIDADES> listActividades = new ArrayList<>(); 
				ACTIVIDADES obj = null;
				while(rs.next()){
					obj =new ACTIVIDADES();
					obj.setIDEMPRESA(rs.getInt("IDEMPRESA"));
					obj.setIDACTIVIDADES(rs.getInt("IDACTIVIDADES"));
					obj.setDESCRIPCION(rs.getString("DESCRIPCION"));
					obj.setFECHACREACION(rs.getDate("FECHACREACION"));
					obj.setESTADO(rs.getInt("ESTADO"));
					obj.setICONO(rs.getString("ICONO"));
					obj.setTIPO(rs.getString("TIPO"));
					listActividades.add(obj);
				}

		return listActividades;
	}
}