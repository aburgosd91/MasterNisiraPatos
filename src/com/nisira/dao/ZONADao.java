package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DZONAGENERAL;
import com.nisira.entidad.ZONA;
import com.nisira.entidad.ZONAGENERAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZONADao extends BaseDao<ZONA> {
	public ZONADao() {
		super(ZONA.class);
	}

	public ZONA getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDZONA) throws SQLException, NisiraORMException {
		List<ZONA> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDZONA = ? ", IDEMPRESA, IDSUCURSAL, IDZONA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	
	public List<ZONA> getLisZona(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDZONA) throws SQLException {
		String sql= "select Z.*,(CASE WHEN DZAL.IDZONA IS NOT NULL THEN MALM.DESCRIPCION ELSE Z.DESCRIPCION END) AS TIPO from ZONA Z"
					+" LEFT JOIN DZONAALMACEN DZAL ON DZAL.IDEMPRESA= Z.IDEMPRESA AND DZAL.IDSUCURSAL=Z.IDSUCURSAL AND DZAL.IDZONA=Z.IDZONA AND DZAL.ESTADO=1"
					+" LEFT JOIN  ALMACEN A ON A.IDEMPRESA= Z.IDEMPRESA AND A.IDSUCURSAL=Z.IDSUCURSAL AND A.IDALMACEN=DZAL.IDALMACEN AND A.ESTADO=1"
					+" LEFT JOIN DZONAACCESORIO DZAC ON DZAC.IDEMPRESA=Z.IDEMPRESA AND DZAC.IDSUCURSAL=Z.IDSUCURSAL AND DZAC.IDZONA=Z.IDZONA"
					+" LEFT JOIN MULTITABLA MALM ON MALM.DEP_ID=1 AND MALM.VALOR=A.IDTIPOALMACEN AND MALM.IDEMPRESA=Z.IDEMPRESA AND MALM.ESTADO=1"
					+" WHERE Z.IDEMPRESA=1 and Z.IDSUCURSAL=6 and Z.IDZONA=1 AND Z.ESTADO=1"
					+" GROUP BY Z.IDEMPRESA,Z.IDSUCURSAL,Z.IDZONA,DZAL.IDZONA,MALM.DESCRIPCION,"
					+" Z.DESCRIPCION,Z.IDTIPOZONA,Z.IDUNIDADMEDIDA,Z.AREA,Z.AREAUNIDADDIAGRAMA,"
					+" Z.LARGOUNIDADDIAGRAMA,Z.ANCHOUNIDADDIAGRAMA,Z.FECHACREACION,Z.ESTADO,Z.SINCRONIZA";
	
		Connection cn = obtenerConexion(con);
		PreparedStatement ps = cn.prepareStatement(sql);
		
		ps.setInt(1, IDEMPRESA);
		ps.setInt(2, IDSUCURSAL);
		ps.setInt(3, IDZONA);
		
		ResultSet rs = ps.executeQuery();
		List<ZONA> l = new ArrayList<ZONA>(); 
		ZONA zona;
		while(rs.next()){
			zona =new ZONA();
			zona.setIDEMPRESA(rs.getInt("IDEMPRESA"));
			zona.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
			zona.setIDZONA(rs.getInt("IDZONA"));
			zona.setDESCRIPCION(rs.getString("DESCRIPCION"));
			zona.setIDTIPOZONA(rs.getInt("IDTIPOZONA"));
			zona.setIDUNIDADMEDIDA(rs.getInt(rs.getInt("IDUNIDADMEDIDA")));
			zona.setAREA(rs.getFloat("AREA"));
			zona.setAREAUNIDADDIAGRAMA(rs.getInt("AREAUNIDADDIAGRAMA"));
			zona.setLARGOUNIDADDIAGRAMA(rs.getInt("LARGOUNIDADDIAGRAMA"));
			zona.setANCHOUNIDADDIAGRAMA(rs.getInt("ANCHOUNIDADDIAGRAMA"));
			zona.setFECHACREACION(rs.getTimestamp("FECHACREACION"));
			zona.setESTADO(rs.getInt("ESTADO"));
			zona.setSINCRONIZA(rs.getInt("SINCRONIZA"));
			l.add(zona);
		}
		
		return l;
	}

}