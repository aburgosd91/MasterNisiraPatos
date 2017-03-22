package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DASIGNACIONCHIPS;
import com.nisira.entidad.DZONAGENERAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DASIGNACIONCHIPSDao extends BaseDao<DASIGNACIONCHIPS> {
	public DASIGNACIONCHIPSDao() {
		super(DASIGNACIONCHIPS.class);
	}

	public DASIGNACIONCHIPS getPorClavePrimaria(Integer IDEMPRESA, Integer IDSUCURSAL, String IDASIGNACIONCHIPS, Integer IDZONA, Integer CORDENADAX, Integer CORDENADAY, String IDUBICACION, String SERIECHIP) throws SQLException, NisiraORMException {
		List<DASIGNACIONCHIPS> l = listar(1,"IDEMPRESA = ? and IDSUCURSAL = ? and IDASIGNACIONCHIPS = ? and IDZONA = ? and CORDENADAX = ? and CORDENADAY = ? and IDUBICACION = ? and SERIECHIP = ? ", IDEMPRESA, IDSUCURSAL, IDASIGNACIONCHIPS, IDZONA, CORDENADAX, CORDENADAY, IDUBICACION, SERIECHIP);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public List<DASIGNACIONCHIPS> getListAdsignacionChips(Integer IDEMPRESA, Integer IDSUCURSAL) throws SQLException, NisiraORMException {
		List<DASIGNACIONCHIPS> l = listar(1,"IDEMPRESA = ? and IDSUCURSAL = ? and ISNULL(RTRIM(LTRIM(SERIECHIP)),'') <>'' and ISNULL(RTRIM(LTRIM(POSICION)),'') <> '' ", IDEMPRESA, IDSUCURSAL);
		if (l.isEmpty()) {
			return null;
		} else {
			return l;
		}
	}
	public DASIGNACIONCHIPS getAsignacionChips(Integer IDEMPRESA, Integer IDSUCURSAL, String SERIECHIP) throws SQLException, NisiraORMException {
		List<DASIGNACIONCHIPS> l = listar(1,"IDEMPRESA = ? and IDSUCURSAL = ? and SERIECHIP = ? ", IDEMPRESA, IDSUCURSAL, SERIECHIP);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public List<DASIGNACIONCHIPS> getAsignacionChips2(Integer IDEMPRESA, Integer IDSUCURSAL, String SERIECHIP1,String SERIECHIP2) throws NisiraORMException, SQLException{
		List<DASIGNACIONCHIPS> lista = new ArrayList<DASIGNACIONCHIPS>();
        ResultSet rs = null;
        rs = execProcedure(1,"GETPOSTCHIPS",SERIECHIP1,SERIECHIP2,IDEMPRESA,IDSUCURSAL);
        DZONAGENERAL dZonaGeneral;
        while(rs.next()){
        	DASIGNACIONCHIPS d = new DASIGNACIONCHIPS();
        	d.setIDUBICACION(rs.getString("IDUBICACION"));
        	lista.add(d);
        }
        return lista;
	}
}