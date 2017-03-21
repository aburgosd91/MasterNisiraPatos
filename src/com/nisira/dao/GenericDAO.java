package com.nisira.dao;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.javatuples.Pair;

import com.nisira.annotation.EColumna;
import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.ALMACEN;

public class GenericDAO<E> extends BaseDao<E> {

	public GenericDAO(Class<E> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	public List<E> enTodo(int con, Integer IDEMPRESA, Integer IDSUCURSAL, String ini, String fin)
			throws SQLException, NisiraORMException {
		int ca = 0;
		List<E> l = null;
		List<Pair<Field, EColumna>> cam = this.propiedades.getCampos();
		for (Pair<Field, EColumna> c : cam) {
			if (c.getValue1().getNombre().equalsIgnoreCase("IDEMPRESA")) {
				ca = 1;
			}
			if (c.getValue1().getNombre().equalsIgnoreCase("IDSUCURSAL")) {
				ca = 2;
			}
		}
		switch (ca) {
		case 1:
			l = listar(con, "IDEMPRESA = ?  and CONVERT(varchar(10),FECHACREACION,120)  BETWEEN ? and ?", IDEMPRESA,
					ini, fin);
			break;
		case 2:
			l = listar(con,
					"IDEMPRESA = ? and IDSUCURSAL = ? and CONVERT(varchar(10),FECHACREACION,120)  BETWEEN ? and ?",
					IDEMPRESA, IDSUCURSAL, ini, fin);
			break;
		default:
			l = listar(con, "CONVERT(varchar(10),FECHACREACION,120)  BETWEEN ? and ?", ini, fin);
			break;
		}
		return l;

	}

}
