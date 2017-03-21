package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.SINCRONIZA;
import com.nisira.utilitarios.UtilDatetimeConverter;
import com.thoughtworks.xstream.XStream;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SINCRONIZADao extends BaseDao<SINCRONIZA> {
	public SINCRONIZADao() {
		super(SINCRONIZA.class);
	}

	public SINCRONIZA getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDSUCURSAL, Integer IDSINCRONIZA, String IDUSUARIO) throws SQLException, NisiraORMException {
		List<SINCRONIZA> l = listar(con,"IDEMPRESA = ? and IDSUCURSAL = ? and IDSINCRONIZA = ? and IDUSUARIO = ? ", IDEMPRESA, IDSUCURSAL, IDSINCRONIZA, IDUSUARIO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}

	public void grabarLog(Object idempresa,Object idsuc,SINCRONIZA a,Timestamp fini,Timestamp ffin) {
		List<SINCRONIZA> ln = new ArrayList<SINCRONIZA>();
		try {
			ln.add(a);
			String xmlNot = "";
			String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
			XStream xStream = new XStream();
			xStream.processAnnotations(SINCRONIZA.class);
			xmlNot = xml + xStream.toXML(ln);
			String ini = fini.toString().replace(" ", "T");
			String fin = ffin.toString().replace(" ", "T");
			execUpdateProcedure(1,"SP_SINCRO_GRABAR_ERR", idempresa,idsuc,xmlNot,ini,fin);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}