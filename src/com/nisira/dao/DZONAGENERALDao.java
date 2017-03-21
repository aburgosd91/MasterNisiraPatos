package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DZONAGENERAL;
import com.nisira.entidad.ZONAGENERAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DZONAGENERALDao extends BaseDao<DZONAGENERAL> {
	public DZONAGENERALDao() {
		super(DZONAGENERAL.class);
	}

	public DZONAGENERAL getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDZONAGENERAL, Integer IDZONA, Integer CORDENADAX, Integer CORDENADAY) throws SQLException, NisiraORMException {
		List<DZONAGENERAL> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDZONAGENERAL = ? and IDZONA = ? and CORDENADAX = ? and CORDENADAY = ? ", IDEMPRESA, IDSUCURSAL, IDZONAGENERAL, IDZONA, CORDENADAX, CORDENADAY);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public List<DZONAGENERAL> getListaDZonaGeneralPosicion(int con,DZONAGENERAL DZ) throws SQLException {
		String sql= "SELECT DZ.*,Z.DESCRIPCION AS ZONA,TZ.DESCRIPCION AS TIPO,M.DESCRIPCION AS TIPORACK " 
		+"from DZONAGENERAL DZ "
		+"INNER JOIN ZONAGENERAL ZG ON ZG.IDEMPRESA=DZ.IDEMPRESA AND ZG.IDSUCURSAL=DZ.IDSUCURSAL AND ZG.IDZONAGENERAL=DZ.IDZONAGENERAL "
		+"LEFT JOIN ZONA Z ON Z.IDEMPRESA=DZ.IDEMPRESA AND DZ.IDSUCURSAL=Z.IDSUCURSAL AND DZ.IDZONA=Z.IDZONA "
		+"LEFT JOIN DALMACEN_DISTRIBUCIONUBICACION DD ON DD.IDEMPRESA=DZ.IDEMPRESA AND DD.IDSUCURSAL=CAST(SUBSTRING(DZ.IDUBICACION,2,3) AS INT) AND DD.IDALMACEN=CAST(SUBSTRING(DZ.IDUBICACION,6,3) AS INT) AND DD.ESTADO=1 "
		+"LEFT JOIN DALMACEN_RACKS DR ON DR.IDEMPRESA=DD.IDEMPRESA AND DR.IDSUCURSAL=DD.IDSUCURSAL AND DR.IDALMACEN=DD.IDALMACEN " 
		+"	AND DR.IDDISTRIBUCION=DD.IDDISTRIBUCION AND DR.IDRACK=CAST(SUBSTRING(DZ.IDUBICACION,10,3) AS INT) "
		+"LEFT JOIN MULTITABLA M ON M.IDEMPRESA=DZ.IDEMPRESA AND M.DEP_ID=7 AND M.VALOR=DR.IDTIPORACKS AND M.ESTADO=1 "
		+"LEFT JOIN TIPOZONA TZ ON TZ.IDTIPOZONA=Z.IDTIPOZONA AND TZ.ESTADO=1 "
		+"WHERE DZ.IDEMPRESA=? AND DZ.IDSUCURSAL=? AND DZ.IDZONAGENERAL=? AND DZ.IDZONA=? AND DZ.CORDENADAX=? AND DZ.CORDENADAY=?";
//		+"DZ.IDUBICACION=?"; 
		
		Connection cn = obtenerConexion(con);
		PreparedStatement ps = cn.prepareStatement(sql);
		
		ps.setInt(1, DZ.getIDEMPRESA());
		ps.setInt(2, DZ.getIDSUCURSAL());
		ps.setInt(3, DZ.getIDZONAGENERAL());
		ps.setInt(4, DZ.getIDZONA());
		ps.setInt(5, DZ.getCORDENADAX());
		ps.setInt(6, DZ.getCORDENADAY());
//		ps.setString(7, DZ.getIDUBICACION());
		
		ResultSet rs = ps.executeQuery();
		List<DZONAGENERAL> l = new ArrayList<DZONAGENERAL>(); 
		DZONAGENERAL dZonaGeneral;
		while(rs.next()){
			dZonaGeneral =new DZONAGENERAL();
			dZonaGeneral.setIDEMPRESA(rs.getInt("IDEMPRESA"));
			dZonaGeneral.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
			dZonaGeneral.setIDZONAGENERAL(rs.getInt("IDZONAGENERAL"));
			dZonaGeneral.setIDZONA(rs.getInt("IDZONA"));
			dZonaGeneral.setCORDENADAX(rs.getInt("CORDENADAX"));
			dZonaGeneral.setCORDENADAY(rs.getInt("CORDENADAY"));
			dZonaGeneral.setDCORDENADAX(rs.getInt("DCORDENADAX"));
			dZonaGeneral.setDCORDENADAY(rs.getInt("DCORDENADAY"));
			dZonaGeneral.setCOLOR(rs.getString("COLOR"));
			dZonaGeneral.setIDUBICACION(rs.getString("IDUBICACION"));
			dZonaGeneral.setFECHACREACION(rs.getDate("FECHACREACION"));
			dZonaGeneral.setSINCRONIZA(rs.getInt("SINCRONIZA"));
			dZonaGeneral.setZONA(rs.getString("ZONA"));
			dZonaGeneral.setTIPO(rs.getString("TIPO"));
			dZonaGeneral.setTIPORACKS(rs.getString("TIPORACK"));
			l.add(dZonaGeneral);
		}
		
		return l;
	}
	/************INICIO
	 * @throws NisiraORMException *************/
	public List<DZONAGENERAL> getLisDZonaGeneral(int con,ZONAGENERAL z) throws SQLException, NisiraORMException {
		List<DZONAGENERAL> l =listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDZONAGENERAL = ? ",z.getIDEMPRESA(),z.getIDSUCURSAL(),z.getIDZONAGENERAL());
		if (l.isEmpty()) {
			return null;
		} else {
			return l;
		}
	}
	public List<DZONAGENERAL> getLisDZonaGeneral_(ZONAGENERAL z) throws SQLException {
		int con=1;
		String sql= "select DZ.*,Z.DESCRIPCION AS ZONA,TZ.DESCRIPCION AS TIPO,M.DESCRIPCION AS TIPORACKS,Z.COLOR AS COLORZONA, "
				 +" ISNULL(DZD.IDALMACEN,0) AS IDALMACEN,ISNULL(DZD.IDACCESORIO,0) AS IDACCESORIO"
				 +" from DZONAGENERAL DZ"
				 +"	INNER JOIN ZONAGENERAL ZG ON ZG.IDEMPRESA=DZ.IDEMPRESA AND ZG.IDSUCURSAL=DZ.IDSUCURSAL AND ZG.IDZONAGENERAL=DZ.IDZONAGENERAL"
				 +"	LEFT JOIN ZONA Z ON Z.IDEMPRESA=DZ.IDEMPRESA AND DZ.IDSUCURSAL=Z.IDSUCURSAL AND DZ.IDZONA=Z.IDZONA"
				 +"	LEFT JOIN TIPOZONA TZ ON TZ.IDTIPOZONA=Z.IDTIPOZONA AND TZ.ESTADO=1"
				 +" LEFT JOIN DZONADIAGRAMAUBICACION DZD ON DZD.IDEMPRESA=DZD.IDEMPRESA AND DZD.IDSUCURSAL=DZD.IDSUCURSAL AND DZD.IDUBICACION=DZ.IDUBICACION"
				 +" LEFT JOIN  DALMACEN_RACKS  DR ON DR.IDEMPRESA=DZ.IDEMPRESA  AND DZ.IDSUCURSAL=DZ.IDSUCURSAL AND DR.IDALMACEN=CAST(SUBSTRING(DZ.IDUBICACION,6,3) AS INT) AND SUBSTRING(DR.IDUBICACION,1,12)=SUBSTRING(DZ.IDUBICACION,1,12) AND DR.ESTADO=1"
				 +" LEFT JOIN MULTITABLA M ON M.IDEMPRESA=DZ.IDEMPRESA AND M.DEP_ID=7 AND M.VALOR=DR.IDTIPORACKS AND M.ESTADO=1"
//				 +" where dz.IDEMPRESA=? and dz.IDSUCURSAL=? and dz.IDZONAGENERAL=? AND M.DESCRIPCION IS NOT NULL"
				 +" where dz.IDEMPRESA=? and dz.IDSUCURSAL=? and dz.IDZONAGENERAL=? "
				 +" order by DZ.CORDENADAX,DZ.CORDENADAY asc "; 
		
		Connection cn = obtenerConexion(con);
		PreparedStatement ps = cn.prepareStatement(sql);
		
		ps.setInt(1, z.getIDEMPRESA());
		ps.setInt(2, z.getIDSUCURSAL());
		ps.setInt(3, z.getIDZONAGENERAL());
		
		ResultSet rs = ps.executeQuery();
		List<DZONAGENERAL> l = new ArrayList<DZONAGENERAL>(); 
		DZONAGENERAL dZonaGeneral;
		while(rs.next()){
			dZonaGeneral =new DZONAGENERAL();
			dZonaGeneral.setIDEMPRESA(rs.getInt("IDEMPRESA"));
			dZonaGeneral.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
			dZonaGeneral.setIDZONAGENERAL(rs.getInt("IDZONAGENERAL"));
			dZonaGeneral.setIDZONA(rs.getInt("IDZONA"));
			dZonaGeneral.setCORDENADAX(rs.getInt("CORDENADAX"));
			dZonaGeneral.setCORDENADAY(rs.getInt("CORDENADAY"));
			dZonaGeneral.setDCORDENADAX(rs.getInt("DCORDENADAX"));
			dZonaGeneral.setDCORDENADAY(rs.getInt("DCORDENADAY"));
			dZonaGeneral.setCOLOR(rs.getString("COLOR"));
			dZonaGeneral.setIDUBICACION(rs.getString("IDUBICACION"));
			dZonaGeneral.setFECHACREACION(rs.getDate("FECHACREACION"));
			dZonaGeneral.setSINCRONIZA(rs.getInt("SINCRONIZA"));
			dZonaGeneral.setZONA(rs.getString("ZONA"));
			dZonaGeneral.setTIPO(rs.getString("TIPO"));
			dZonaGeneral.setTIPORACKS(rs.getString("TIPORACKS"));
			dZonaGeneral.setCOLORZONA(rs.getString("COLORZONA"));
			dZonaGeneral.setIDALMACEN(rs.getInt("IDALMACEN"));
			dZonaGeneral.setIDACCESORIO(rs.getInt("IDACCESORIO"));
			l.add(dZonaGeneral);
		}
		return l;
	}
	public List<DZONAGENERAL> getLisDZonaGeneralCalles(int con,ZONAGENERAL z) throws SQLException, NisiraORMException{
		List<DZONAGENERAL> lista = new ArrayList<DZONAGENERAL>();
        ResultSet rs = null;
        rs = execProcedure(1,"GETDZONAGENERAL","getLisDZonaGeneralCalles",z.getIDEMPRESA(),z.getIDSUCURSAL(),z.getIDZONAGENERAL());
        DZONAGENERAL dZonaGeneral;
        while(rs.next()){
			dZonaGeneral =new DZONAGENERAL();
			dZonaGeneral.setIDEMPRESA(rs.getInt("IDEMPRESA"));
			dZonaGeneral.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
			dZonaGeneral.setIDZONAGENERAL(rs.getInt("IDZONAGENERAL"));
			dZonaGeneral.setIDZONA(rs.getInt("IDZONA"));
			dZonaGeneral.setCORDENADAX(rs.getInt("CORDENADAX"));
			dZonaGeneral.setCORDENADAY(rs.getInt("CORDENADAY"));
			dZonaGeneral.setDCORDENADAX(rs.getInt("DCORDENADAX"));
			dZonaGeneral.setDCORDENADAY(rs.getInt("DCORDENADAY"));
			dZonaGeneral.setCOLOR(rs.getString("COLOR"));
			dZonaGeneral.setIDUBICACION(rs.getString("IDUBICACION"));
			dZonaGeneral.setFECHACREACION(rs.getDate("FECHACREACION"));
			dZonaGeneral.setSINCRONIZA(rs.getInt("SINCRONIZA"));
			dZonaGeneral.setZONA(rs.getString("ZONA"));
			dZonaGeneral.setTIPO(rs.getString("TIPO"));
			dZonaGeneral.setTIPORACKS(rs.getString("TIPORACKS"));
			dZonaGeneral.setIDALMACEN(rs.getInt("IDALMACEN"));
			dZonaGeneral.setIDACCESORIO(rs.getInt("IDACCESORIO"));
			lista.add(dZonaGeneral);
		}
        return lista;
    }
	public List<DZONAGENERAL> getLisDZonaGeneral_(int con,ZONAGENERAL z,String tipoZona) throws SQLException {

			String sql ="SELECT DZ.*,Z.DESCRIPCION AS ZONA,TZ.DESCRIPCION AS TIPO,M.DESCRIPCION AS TIPORACK "
						+"FROM DZONAGENERAL DZ "
						+"INNER JOIN ZONAGENERAL ZG ON ZG.IDEMPRESA=DZ.IDEMPRESA AND ZG.IDSUCURSAL=DZ.IDSUCURSAL AND ZG.IDZONAGENERAL=DZ.IDZONAGENERAL "
						+"LEFT JOIN ZONA Z ON Z.IDEMPRESA=DZ.IDEMPRESA AND DZ.IDSUCURSAL=Z.IDSUCURSAL AND DZ.IDZONA=Z.IDZONA "
						+"LEFT JOIN DALMACEN_DISTRIBUCIONUBICACION DD ON DD.IDEMPRESA=DZ.IDEMPRESA AND DD.IDSUCURSAL=CAST(SUBSTRING(DZ.IDUBICACION,2,3) AS INT) AND DD.IDALMACEN=CAST(SUBSTRING(DZ.IDUBICACION,6,3) AS INT) AND DD.ESTADO=1 "
						+"LEFT JOIN DALMACEN_RACKS DR ON DR.IDEMPRESA=DD.IDEMPRESA AND DR.IDSUCURSAL=DD.IDSUCURSAL AND DR.IDALMACEN=DD.IDALMACEN "
						+"	AND DR.IDDISTRIBUCION=DD.IDDISTRIBUCION AND DR.IDRACK=CAST(SUBSTRING(DZ.IDUBICACION,10,3) AS INT) "
						+"LEFT JOIN MULTITABLA M ON M.IDEMPRESA=DZ.IDEMPRESA AND M.DEP_ID=7 AND M.VALOR=DR.IDTIPORACKS AND M.ESTADO=1 "
						+"LEFT JOIN TIPOZONA TZ ON TZ.IDTIPOZONA=Z.IDTIPOZONA AND TZ.ESTADO=1 "
						+"WHERE DZ.IDEMPRESA=? AND DZ.IDSUCURSAL=? AND DZ.IDZONAGENERAL=? AND LTRIM(RTRIM(TZ.DESCRIPCION))=? AND DZ.IDUBICACION IS NOT NULL AND DZ.IDUBICACION <>''";
			
//			String sql=  "select DZ.*,Z.DESCRIPCION AS ZONA,TZ.DESCRIPCION AS TIPO from DZONAGENERAL DZ"
//					 +"	INNER JOIN ZONAGENERAL ZG ON ZG.IDEMPRESA=DZ.IDEMPRESA AND ZG.IDSUCURSAL=DZ.IDSUCURSAL AND ZG.IDZONAGENERAL=DZ.IDZONAGENERAL"
//					 +"	LEFT JOIN ZONA Z ON Z.IDEMPRESA=DZ.IDEMPRESA AND DZ.IDSUCURSAL=Z.IDSUCURSAL AND DZ.IDZONA=Z.IDZONA"
//					 +"	LEFT JOIN TIPOZONA TZ ON TZ.IDTIPOZONA=Z.IDTIPOZONA AND TZ.ESTADO=1"
//					 +" where dz.IDEMPRESA=? and dz.IDSUCURSAL=? and dz.IDZONAGENERAL=?"; 
			Connection cn = obtenerConexion(con);
			PreparedStatement ps = cn.prepareStatement(sql);
			
			ps.setInt(1, z.getIDEMPRESA());
			ps.setInt(2, z.getIDSUCURSAL());
			ps.setInt(3, z.getIDZONAGENERAL());
			ps.setString(4, tipoZona);
			
			ResultSet rs = ps.executeQuery();
			List<DZONAGENERAL> l = new ArrayList<DZONAGENERAL>(); 
			DZONAGENERAL dZonaGeneral;
			while(rs.next()){
				dZonaGeneral =new DZONAGENERAL();
				dZonaGeneral.setIDEMPRESA(rs.getInt("IDEMPRESA"));
				dZonaGeneral.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
				dZonaGeneral.setIDZONAGENERAL(rs.getInt("IDZONAGENERAL"));
				dZonaGeneral.setIDZONA(rs.getInt("IDZONA"));
				dZonaGeneral.setCORDENADAX(rs.getInt("CORDENADAX"));
				dZonaGeneral.setCORDENADAY(rs.getInt("CORDENADAY"));
				dZonaGeneral.setCOLOR(rs.getString("COLOR"));
				dZonaGeneral.setIDUBICACION(rs.getString("IDUBICACION"));
				dZonaGeneral.setFECHACREACION(rs.getDate("FECHACREACION"));
				dZonaGeneral.setSINCRONIZA(rs.getInt("SINCRONIZA"));
				dZonaGeneral.setZONA(rs.getString("ZONA"));
				dZonaGeneral.setTIPO(rs.getString("TIPO"));
				dZonaGeneral.setTIPORACKS(rs.getString("TIPORACK"));
				l.add(dZonaGeneral);
			}
			
			return l;
		}
		
	public List<DZONAGENERAL> getListZonas(int con,ZONAGENERAL z) throws SQLException {
			
			String sql="select DISTINCT DZ.IDZONA from DZONAGENERAL DZ"
						+" INNER JOIN ZONAGENERAL ZG ON ZG.IDEMPRESA=DZ.IDEMPRESA AND ZG.IDSUCURSAL=DZ.IDSUCURSAL AND ZG.IDZONAGENERAL=DZ.IDZONAGENERAL"
						+" LEFT JOIN ZONA Z ON Z.IDEMPRESA=DZ.IDEMPRESA AND DZ.IDSUCURSAL=Z.IDSUCURSAL AND DZ.IDZONA=Z.IDZONA"
						+" LEFT JOIN DZONAALMACEN DZAL ON DZAL.IDEMPRESA= Z.IDEMPRESA AND DZAL.IDSUCURSAL=Z.IDSUCURSAL AND DZAL.IDZONA=Z.IDZONA AND DZAL.ESTADO=1"
						+" LEFT JOIN  ALMACEN A ON A.IDEMPRESA= Z.IDEMPRESA AND A.IDSUCURSAL=Z.IDSUCURSAL AND A.IDALMACEN=DZAL.IDALMACEN AND A.ESTADO=1"
						+" LEFT JOIN DZONAACCESORIO DZAC ON DZAC.IDEMPRESA=Z.IDEMPRESA AND DZAC.IDSUCURSAL=Z.IDSUCURSAL AND DZAC.IDZONA=Z.IDZONA"
						+" LEFT JOIN MULTITABLA MALM ON MALM.DEP_ID=1 AND MALM.VALOR=A.IDTIPOALMACEN AND MALM.IDEMPRESA=Z.IDEMPRESA AND MALM.ESTADO=1"
						+" where dz.IDEMPRESA=? and dz.IDSUCURSAL=? and dz.IDZONAGENERAL=? AND ZG.ESTADO=1 AND DZ.IDZONA<>0";
	//		String sql ="select DZ.*,Z.DESCRIPCION AS ZONA from DZONAGENERAL DZ"
	//					+" INNER JOIN ZONAGENERAL ZG ON ZG.IDEMPRESA=DZ.IDEMPRESA AND ZG.IDSUCURSAL=DZ.IDSUCURSAL AND ZG.IDZONAGENERAL=DZ.IDZONAGENERAL"
	//					+" LEFT JOIN ZONA Z ON Z.IDEMPRESA=DZ.IDEMPRESA AND DZ.IDSUCURSAL=Z.IDSUCURSAL AND DZ.IDZONA=Z.IDZONA"
	//					+" where dz.IDEMPRESA=? and dz.IDSUCURSAL=? and dz.IDZONAGENERAL=? AND ZG.ESTADO=1";
	//		String sql = "select o.idorigen, o.descripcion, d.idunico,  d.documento, d.idclieprov, d.razonsocial, d.fecha, d.NombreArchivo, dd.Codigo, dd.Descripcion "
	//				+ " from DocumentosEnviados d left join DDocumentosEnviados dd on d.idorigen = dd.idorigen and d.idunico = dd.idunico "
	//				+ " left join OrigenDato o on d.IdOrigen = o.idorigen "
	//				+ " where d.fecha >= ? and d.fecha <= ?";
			
			Connection cn = obtenerConexion(con);
			PreparedStatement ps = cn.prepareStatement(sql);
			
			ps.setInt(1, z.getIDEMPRESA());
			ps.setInt(2, z.getIDSUCURSAL());
			ps.setInt(3, z.getIDZONAGENERAL());
			
			ResultSet rs = ps.executeQuery();
			List<DZONAGENERAL> l = new ArrayList<DZONAGENERAL>(); 
			DZONAGENERAL dZonaGeneral;
			while(rs.next()){
				dZonaGeneral =new DZONAGENERAL();
	//			dZonaGeneral.setIDEMPRESA(rs.getInt("IDEMPRESA"));
	//			dZonaGeneral.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
	//			dZonaGeneral.setIDZONAGENERAL(rs.getInt("IDZONAGENERAL"));
				dZonaGeneral.setIDZONA(rs.getInt("IDZONA"));
	//			dZonaGeneral.setCORDENADAX(rs.getInt("CORDENADAX"));
	//			dZonaGeneral.setCORDENADAY(rs.getInt("CORDENADAY"));
	//			dZonaGeneral.setCOLOR(rs.getString("COLOR"));
	//			dZonaGeneral.setIDUBICACION(rs.getString("IDUBICACION"));
	//			dZonaGeneral.setFECHACREACION(rs.getDate("FECHACREACION"));
	//			dZonaGeneral.setSINCRONIZA(rs.getInt("SINCRONIZA"));
	//			dZonaGeneral.setZONA(rs.getString("ZONA"));
	//			dZonaGeneral.setTIPO(rs.getString("TIPO"));
				l.add(dZonaGeneral);
			}
			
			return l;
		}
	
	public DZONAGENERAL getDZonaGeneral(Integer IDEMPRESA, Integer IDSUCURSAL,Integer CORDENADAX,Integer CORDENADAY
			,Integer DCORDENADAX,Integer DCORDENADAY,String IDUBICACION) throws SQLException, NisiraORMException {
		int con=1;
		List<DZONAGENERAL> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and CORDENADAX = ? and CORDENADAY = ? and DCORDENADAX = ? and DCORDENADAY = ? and IDUBICACION = ?", IDEMPRESA, IDSUCURSAL,CORDENADAX, CORDENADAY
				,DCORDENADAX, DCORDENADAY, IDUBICACION);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public DZONAGENERAL getDZonaGeneralprueba(Integer IDEMPRESA, Integer IDSUCURSAL,Integer IDZONAGENERAL,Integer IDZONA
			,Integer DCORDENADAX,Integer DCORDENADAY,String IDUBICACION) throws SQLException, NisiraORMException {
		int con=1;
		List<DZONAGENERAL> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and CORDENADAX = ? and CORDENADAY = ? and DCORDENADAX = ? and DCORDENADAY = ? and IDUBICACION = ?", IDEMPRESA, IDSUCURSAL,IDZONAGENERAL, IDZONA
				,DCORDENADAX, DCORDENADAY, IDUBICACION);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public DZONAGENERAL getDZonaGeneralxTarea(Integer IDEMPRESA, Integer IDSUCURSAL,
			String IDUBICACION) throws SQLException, NisiraORMException {
		int con=1;
		List<DZONAGENERAL> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ?  and IDUBICACION = ?", IDEMPRESA, IDSUCURSAL, IDUBICACION);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	/************FIN****************/
}