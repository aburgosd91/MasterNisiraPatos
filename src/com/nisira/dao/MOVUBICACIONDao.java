package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.MOVUBICACION;
import com.nisira.core.NisiraORMException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MOVUBICACIONDao extends BaseDao<MOVUBICACION> {
	public MOVUBICACIONDao() {
		super(MOVUBICACION.class);
	}
	public MOVUBICACIONDao(boolean usaCnBase) throws NisiraORMException {
		super(1,MOVUBICACION.class, usaCnBase);
	}

	public MOVUBICACION getPorClavePrimaria(Integer IDMOVUBICACION) throws NisiraORMException {
		List<MOVUBICACION> l = listar(1,"t0.IDMOVUBICACION = ? ", IDMOVUBICACION);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public List<MOVUBICACION> listUbicacionContenido(Integer IDEMPRESA,Integer IDSUCURSAL,Integer IDZONA) throws SQLException{
		String sql = "SP_MOVUBICACION_MOVIL";
		Connection cn = obtenerConexion(1);
        CallableStatement cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
        cl.setObject(1, IDEMPRESA);
        cl.setObject(2, IDSUCURSAL);
        cl.setObject(3, IDZONA);
        ResultSet rs = null;
        rs = cl.executeQuery();
        List<MOVUBICACION> l = new ArrayList<>();
		MOVUBICACION obj;
		while(rs.next()){
			obj = new MOVUBICACION();
			obj.setIDEMPRESA(rs.getInt("IDEMPRESA"));
			obj.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
			obj.setIDZONA(rs.getInt("IDZONA"));
			obj.setIDALMACEN(rs.getInt("IDALMACEN"));
			obj.setIDACCESORIO(rs.getInt("IDACCESORIO"));
			obj.setIDPALETA(rs.getString("IDPALETA"));
			obj.setIDUBICACION(rs.getString("IDUBICACION"));
			obj.setFACTOR(rs.getInt("FACTOR"));
			obj.setIDPROGRAMACIONTAREA(rs.getString("IDPROGRAMACIONTAREA"));
			obj.setFECHACREACION(rs.getDate("FECHACREACION"));
			obj.setOBSERVACION(rs.getString("OBSERVACION"));
			obj.setUSRCREACION(rs.getString("USRCREACION"));
			obj.setTIPOUBICACION(rs.getInt("TIPOUBICACION"));
			obj.setIDTIPOPALETA(rs.getInt("IDTIPOPALETA"));
			obj.setDIVISIONPALETA(rs.getInt("DIVISIONPALETA"));
			obj.setIDPRODUCTO(rs.getString("IDPRODUCTO"));
			obj.setCANTIDAD(rs.getFloat("CANTIDAD"));
			obj.setIDENVASE(rs.getString("IDENVASE"));
			obj.setIDPRODUCTOR(rs.getString("IDPRODUCTOR"));
			obj.setIDLOTEP(rs.getString("IDLOTEP"));
			obj.setIDCLIENTE(rs.getString("IDCLIENTE"));
			obj.setIDMOTIVO(rs.getString("IDMOTIVO"));
			obj.setCORDENADAX(rs.getInt("CORDENADAX"));
			obj.setCORDENADAY(rs.getInt("CORDENADAY"));
			obj.setZONA(rs.getString("ZONA"));
			obj.setTIPOZONA(rs.getString("TIPOZONA"));
			l.add(obj);
		}
		if (l.isEmpty()) {
			return null;
		} else {
			return l;
		}
	}
	
	public MOVUBICACION addMovubicacion(MOVUBICACION entidad) throws NisiraORMException {
		mezclar(1, entidad);
		return null;
	}
	public MOVUBICACION getUbicacionContenido(Integer IDEMPRESA,Integer IDSUCURSAL,
			Integer IDMOVUBICACION) throws NisiraORMException, SQLException {
		
		String sql =" SELECT * FROM( "+
			"SELECT TOP(1) * FROM MOVUBICACION "+
				"WHERE IDEMPRESA=? AND IDSUCURSAL=? AND "+ 
				"IDUBICACION=?"+
			"ORDER BY IDMOVUBICACION DESC "+
			") AS DATOS "+
		"WHERE DATOS.FACTOR=?";
		Connection cn = obtenerConexion(1);
		PreparedStatement ps = cn.prepareStatement(sql);
		
		ps.setInt(1, IDEMPRESA);
		ps.setInt(2, IDSUCURSAL);
		ps.setInt(3, IDMOVUBICACION);
		ps.setInt(4, 1);
		ResultSet rs = ps.executeQuery();
		List<MOVUBICACION> l = new ArrayList<>();
		MOVUBICACION obj;
		while(rs.next()){
			obj = new MOVUBICACION();
			obj.setIDEMPRESA(rs.getInt("IDEMPRESA"));
			obj.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
			obj.setIDZONA(rs.getInt("IDZONA"));
			obj.setIDALMACEN(rs.getInt("IDALMACEN"));
			obj.setIDACCESORIO(rs.getInt("IDACCESORIO"));
			obj.setIDPALETA(rs.getString("IDPALETA"));
			obj.setIDUBICACION(rs.getString("IDUBICACION"));
			obj.setFACTOR(rs.getInt("FACTOR"));
			obj.setIDPROGRAMACIONTAREA(rs.getString("IDPROGRAMACIONTAREA"));
			obj.setFECHACREACION(rs.getDate("FECHACREACION"));
			obj.setOBSERVACION(rs.getString("OBSERVACION"));
			obj.setUSRCREACION(rs.getString("USRCREACION"));
			obj.setTIPOUBICACION(rs.getInt("TIPOUBICACION"));
			obj.setIDTIPOPALETA(rs.getInt("IDTIPOPALETA"));
			obj.setDIVISIONPALETA(rs.getInt("DIVISIONPALETA"));
			obj.setIDPRODUCTO(rs.getString("IDPRODUCTO"));
			obj.setCANTIDAD(rs.getFloat("CANTIDAD"));
			obj.setIDENVASE(rs.getString("IDENVASE"));
			obj.setIDPRODUCTOR(rs.getString("IDPRODUCTOR"));
			obj.setIDLOTEP(rs.getString("IDLOTEP"));
			obj.setIDCLIENTE(rs.getString("IDCLIENTE"));
			obj.setIDMOTIVO(rs.getString("IDMOTIVO"));
			l.add(obj);
		}
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}