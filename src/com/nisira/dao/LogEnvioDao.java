package com.nisira.dao;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.LogEnvio;

public class LogEnvioDao extends BaseDao<LogEnvio> {
	public LogEnvioDao() {
		super(LogEnvio.class);
	}
	
	/*-Inicio-*/
	public List<LogEnvio> getDesde(int con,Date fecha) throws SQLException, NisiraORMException {
		Calendar c = Calendar.getInstance();
		c.setTime(fecha);
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.HOUR), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
		c.set(Calendar.MILLISECOND, 0);
		return listar(con,"t0.fechahora >= ?", fecha);
	}
	/*-Fin-*/
}