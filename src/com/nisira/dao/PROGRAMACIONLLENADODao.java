package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.PROGRAMACIONLLENADO;
import java.sql.SQLException;
import java.util.List;

public class PROGRAMACIONLLENADODao extends BaseDao<PROGRAMACIONLLENADO> {
	public PROGRAMACIONLLENADODao() {
		super(PROGRAMACIONLLENADO.class);
	}

	public PROGRAMACIONLLENADO getPorClavePrimaria(Integer IDEMPRESA, Integer IDSUCURSAL, String IDPROGRAMACIONLLENADO) throws SQLException, NisiraORMException {
		List<PROGRAMACIONLLENADO> l = listar(1,"IDEMPRESA = ? and IDSUCURSAL = ? and IDPROGRAMACIONLLENADO = ? ", IDEMPRESA, IDSUCURSAL, IDPROGRAMACIONLLENADO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}