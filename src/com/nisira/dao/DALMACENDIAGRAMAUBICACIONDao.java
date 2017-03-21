package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DALMACENDIAGRAMAUBICACION;
import com.nisira.entidad.DZONADIAGRAMA;

import java.sql.SQLException;
import java.util.List;

public class DALMACENDIAGRAMAUBICACIONDao extends BaseDao<DALMACENDIAGRAMAUBICACION> {
	public DALMACENDIAGRAMAUBICACIONDao() {
		super(DALMACENDIAGRAMAUBICACION.class);
	}

	public DALMACENDIAGRAMAUBICACION getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDALMACEN, String IDDISTRIBUCION, Integer CORDENADAX, Integer CORDENADAY, String IDUBICACION) throws SQLException, NisiraORMException {
		List<DALMACENDIAGRAMAUBICACION> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDALMACEN = ? and IDDISTRIBUCION = ? and CORDENADAX = ? and CORDENADAY = ? and IDUBICACION = ? ", IDEMPRESA, IDSUCURSAL, IDALMACEN, IDDISTRIBUCION, CORDENADAX, CORDENADAY, IDUBICACION);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public List<DALMACENDIAGRAMAUBICACION> getPorClavePrimaria(int con,DZONADIAGRAMA dzd) throws SQLException, NisiraORMException {
		List<DALMACENDIAGRAMAUBICACION> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDALMACEN = ? and IDDISTRIBUCION = ? and CORDENADAX = ? and CORDENADAY = ? ", dzd.getIDEMPRESA(), dzd.getIDSUCURSAL(), dzd.getIDALMACEN() , dzd.getIDDISTRIBUCION(),dzd.getCORDENADAX(),dzd.getCORDENADAY());
		if (l.isEmpty()) {
			return null;
		} else {
			return l;
		}
	}
}