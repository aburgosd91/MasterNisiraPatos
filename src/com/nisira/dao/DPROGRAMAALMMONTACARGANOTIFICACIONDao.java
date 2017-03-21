package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.DPROGRAMAALMMONTACARGANOTIFICACION;
import java.sql.SQLException;
import java.util.List;

public class DPROGRAMAALMMONTACARGANOTIFICACIONDao extends BaseDao<DPROGRAMAALMMONTACARGANOTIFICACION> {
	public DPROGRAMAALMMONTACARGANOTIFICACIONDao() {
		super(DPROGRAMAALMMONTACARGANOTIFICACION.class);
	}

	public DPROGRAMAALMMONTACARGANOTIFICACION getPorClavePrimaria(Integer IDEMPRESA, Integer IDPROGRAMAALM, Integer IDMONTACARGA, Integer IDNOTIFICACION) throws SQLException, NisiraORMException {
		List<DPROGRAMAALMMONTACARGANOTIFICACION> l = listar(1,"IDEMPRESA = ? and IDPROGRAMAALM = ? and IDMONTACARGA = ? and IDNOTIFICACION = ? ", IDEMPRESA, IDPROGRAMAALM, IDMONTACARGA, IDNOTIFICACION);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}