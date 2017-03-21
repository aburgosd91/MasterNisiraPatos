package com.nisira.clientservice;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.javatuples.Pair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nisira.Inicio;
import com.nisira.core.CoreUtil;
import com.nisira.entidad.CONFIGTABLASINCRO;
import com.nisira.entidad.GENERACIONCODIGOS;
import com.nisira.entidad.TABLASINCRONIZA;
import com.nisira.httpclient.ConexionHttp;
import com.nisira.httpclient.ParametrosHttp;
import com.nisira.security.Encryption;
import com.nisira.utilitarios.UtilDatetimeConverter;
import com.nisira.utils.nisiracore.Constantes;
import com.thoughtworks.xstream.XStream;

import core.inicio.ConfigInicial;

public class HttpTablaSincroniza extends HttpComponents<CONFIGTABLASINCRO>{
	@Override
	public List<CONFIGTABLASINCRO> bajarServidor(String... strings) {
		/***************************VARIABLES*******************************/
		String trama="";
		List<CONFIGTABLASINCRO> listTablaSincroniza = new ArrayList<CONFIGTABLASINCRO>();
		// TODO Auto-generated method stub
		ParametrosHttp.URL_SERVER=ConfigInicial.LlenarConfig()[6];//Configurar Servidor
		ConexionHttp.pageConsulta(strings[1]);
		/*******************AGREGAR VALIDACION DE USUARIO*************************/
		ConexionHttp.addVariableTask("usuario",URLEncoder.encode(Encryption.encrypt(Inicio.usuario.getIdUsuario())));/*AGREGAR IDEMPRESA*/
		ConexionHttp.addVariables("password",URLEncoder.encode(Inicio.usuario.getClave()));/*AGREGAR IDEMPRESAS*/
		
		/*************************************************************************/
		ConexionHttp.addVariables("idempresa",URLEncoder.encode(Encryption.encrypt(strings[2])));/*AGREGAR IDEMPRESA*/
		ConexionHttp.addVariables("idsucursal",URLEncoder.encode(Encryption.encrypt(strings[3])));/*AGREGAR IDSUCURSAL*/
		ConexionHttp.addVariables("desde",URLEncoder.encode(Encryption.encrypt(strings[4])));/*AGREGAR DESDE*/
		ConexionHttp.addVariables("hasta",URLEncoder.encode(Encryption.encrypt(strings[5])));/*AGREGAR HASTA*/
		ConexionHttp.addVariables("tabla",URLEncoder.encode(Encryption.encrypt(strings[6])));/*AGREGAR TABLA*/
		if(ConfigInicial.LlenarConfig()[7].equals("1")){//XML
			trama = ConexionHttp.Jsoup_Xml();
			/*ALIAS DE LAS FILAS*/
			XStream xStream= new XStream();
			UtilDatetimeConverter dateConverter = new UtilDatetimeConverter();
			xStream.alias("CONFIGTABLASINCRO", CONFIGTABLASINCRO.class);			
			xStream.registerConverter(dateConverter);
			listTablaSincroniza=(List<CONFIGTABLASINCRO>)xStream.fromXML(trama);
		}else if(ConfigInicial.LlenarConfig()[7]=="2"){//JSON
			trama = ConexionHttp.Jsoup_Json();
			Type listType = new TypeToken<ArrayList<GENERACIONCODIGOS>>() {}.getType();
			listTablaSincroniza = new Gson().fromJson(trama,listType);
		}
		return listTablaSincroniza;
	}
    	
	@Override
	public List<CONFIGTABLASINCRO> subirServidor(String... strings) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<? extends Object> fall(String... strings) throws ClassNotFoundException{
    	String trama="";
		List<? extends Object> listTablaSincroniza= new ArrayList<Object>();
		ParametrosHttp.URL_SERVER=ConfigInicial.LlenarConfig()[6];//Configurar Servidor
		ConexionHttp.pageConsulta(strings[1]);
		/*******************AGREGAR VALIDACION DE USUARIO*************************/
		ConexionHttp.addVariableTask("usuario",URLEncoder.encode(Encryption.encrypt(Inicio.usuario.getIdUsuario())));/*AGREGAR IDEMPRESA*/
		ConexionHttp.addVariables("password",URLEncoder.encode(Inicio.usuario.getClave()));/*AGREGAR IDEMPRESAS*/
		/*************************************************************************/
		
		ConexionHttp.addVariables("idempresa",URLEncoder.encode(Encryption.encrypt(strings[2])));/*AGREGAR IDEMPRESA*/
		ConexionHttp.addVariables("idsucursal",URLEncoder.encode(Encryption.encrypt(strings[3])));/*AGREGAR IDSUCURSAL*/
		ConexionHttp.addVariables("idmontacarga",URLEncoder.encode(Encryption.encrypt(strings[7])));
		ConexionHttp.addVariables("desde",URLEncoder.encode(Encryption.encrypt(strings[4])));/*AGREGAR DESDE*/
		ConexionHttp.addVariables("hasta",URLEncoder.encode(Encryption.encrypt(strings[5])));/*AGREGAR HASTA*/
		ConexionHttp.addVariables("tabla",URLEncoder.encode(Encryption.encrypt(strings[6])));/*AGREGAR TABLA NUMERICO*/
		ConexionHttp.addVariables("nametabla",URLEncoder.encode(Encryption.encrypt(strings[8])));/*AGREGAR NOMBRE TABLA*/
		if(ConfigInicial.LlenarConfig()[7].equals("1")){
			trama = ConexionHttp.Jsoup_Xml();
			UtilDatetimeConverter dateConverter = new UtilDatetimeConverter();
			
			XStream xStream= new XStream();
			xStream.alias(strings[0].toString(), Class.forName("com.nisira.entidad."+strings[0].toString()));
			xStream.registerConverter(dateConverter);
			if(!trama.equalsIgnoreCase("")){
				listTablaSincroniza=(List<? extends Object>)xStream.fromXML(trama);
			}
			
		}else if(ConfigInicial.LlenarConfig()[7]=="2"){//JSON

		}
		return listTablaSincroniza;
    	
    }
	@Override
	public List<CONFIGTABLASINCRO> listaLocal(String... strings) {
		/***************************VARIABLES*******************************/
		String trama="";
		List<CONFIGTABLASINCRO> listTablaSincroniza = new ArrayList<CONFIGTABLASINCRO>();
		// TODO Auto-generated method stub
		ParametrosHttp.URL_SERVER=ConfigInicial.LlenarConfig()[6];//Configurar Servidor
		ConexionHttp.pageConsulta(strings[1]);
		/*******************AGREGAR VALIDACION DE USUARIO*************************/
		ConexionHttp.addVariableTask("usuario",Encryption.encrypt(Inicio.usuario.getIdUsuario()));/*AGREGAR IDEMPRESA*/
		ConexionHttp.addVariables("password",Inicio.usuario.getClave());/*AGREGAR IDEMPRESA*/
		/*************************************************************************/
//		ConexionHttp.addVariableTask("idempresa","1");/*AGREGAR PARAMETROS*/
		if(ConfigInicial.LlenarConfig()[7].equals("1")){//XML
			trama = ConexionHttp.Jsoup_Xml();
			/*ALIAS DE LAS FILAS*/
			XStream xStream= new XStream();
			xStream.alias("tablasincroniza", CONFIGTABLASINCRO.class);
			xStream.aliasField("tabla", CONFIGTABLASINCRO.class, "TABLA");
			xStream.aliasField("pendientes", CONFIGTABLASINCRO.class, "PENDIENTES");
			xStream.aliasField("afectados", CONFIGTABLASINCRO.class, "AFECTADOS");
			listTablaSincroniza=(List<CONFIGTABLASINCRO>)xStream.fromXML(trama);
			
		}else if(ConfigInicial.LlenarConfig()[7]=="2"){//JSON
			trama = ConexionHttp.Jsoup_Json();
			Type listType = new TypeToken<ArrayList<CONFIGTABLASINCRO>>() {}.getType();
			listTablaSincroniza = new Gson().fromJson(trama,listType);
		}
		return listTablaSincroniza;
	}



}
