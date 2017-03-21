package com.nisira.clientservice;

import java.net.URLEncoder;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.nisira.Inicio;
import com.nisira.core.NisiraORMException;
import com.nisira.dao.ALMACENDao;
import com.nisira.dao.GenericDAO;
import com.nisira.entidad.ALMACEN;
import com.nisira.entidad.TABLASINCRONIZA;
import com.nisira.httpclient.ConexionHttp;
import com.nisira.httpclient.ParametrosHttp;
import com.nisira.security.Encryption;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import core.inicio.ConfigInicial;

public class HttpTest extends HttpComponents<Object>{

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Object> synCentral(int con,String... strings) throws NumberFormatException, SQLException, ParseException, ClassNotFoundException, NisiraORMException{
		String dini = strings[3].replace("/", "-");
		String dfni = strings[4].replace("/", "-");;	
		List<Object> al = (List<Object>) (new GenericDAO<>(Class.forName("com.nisira.entidad."+strings[0]))).enTodo(con,Integer.parseInt(strings[1]), Integer.parseInt(strings[2].toString()),dini,dfni);
		return al;
	}
	
	@Override
	public List<Object> bajarServidor(String... strings) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> subirServidor(String... strings) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> listaLocal(String... strings) {
		// TODO Auto-generated method stub
		return null;
	}
}
