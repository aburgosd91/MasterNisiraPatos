package com.nisira.clientservice;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.javatuples.Pair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nisira.core.CoreUtil;
import com.nisira.entidad.GENERACIONCODIGOS;
import com.nisira.httpclient.ConexionHttp;
import com.nisira.httpclient.ParametrosHttp;
import com.nisira.utils.nisiracore.Constantes;
import com.thoughtworks.xstream.XStream;

import core.inicio.ConfigInicial;

public class HttpGENERACIONCODIGO extends HttpComponents<GENERACIONCODIGOS>{
	@Override
	public List<GENERACIONCODIGOS> bajarServidor(String... strings) {
		/***************************VARIABLES*******************************/
		String trama="";
		List<GENERACIONCODIGOS> listMGENERACION_CODIGOS = new ArrayList<GENERACIONCODIGOS>();
		// TODO Auto-generated method stub
		ParametrosHttp.URL_SERVER=ConfigInicial.LlenarConfig()[6];//Configurar Servidor
		ConexionHttp.pageConsulta(strings[1]);
		ConexionHttp.addVariableTask("idempresa","1");/*AGREGAR IDEMPRESA*/
		if(ConfigInicial.LlenarConfig()[7].equals("1")){//XML
			trama = ConexionHttp.Jsoup_Xml();
			/*ALIAS DE LAS FILAS*/
			XStream xStream= new XStream();
			xStream.alias("GENERACIONCODIGOS", GENERACIONCODIGOS.class);
//			xStream.aliasField("idempresa", GENERACIONCODIGOS.class, "IDEMPRESA");
//			xStream.aliasField("idgeneracion", GENERACIONCODIGOS.class, "IDGENERACION");
//			xStream.aliasField("tipo", GENERACIONCODIGOS.class, "TIPO");
//			xStream.aliasField("descripcion", GENERACIONCODIGOS.class, "DESCRIPCION");
//			xStream.aliasField("numdigitototal", GENERACIONCODIGOS.class, "NUMDIGITOTOTAL");
//			xStream.aliasField("fechacreacion", GENERACIONCODIGOS.class, "FECHACREACION");
//			xStream.aliasField("estado", GENERACIONCODIGOS.class, "ESTADO");
			
			listMGENERACION_CODIGOS=(List<GENERACIONCODIGOS>)xStream.fromXML(trama);
			
		}else if(ConfigInicial.LlenarConfig()[7]=="2"){//JSON
			trama = ConexionHttp.Jsoup_Json();
			Type listType = new TypeToken<ArrayList<GENERACIONCODIGOS>>() {}.getType();
			listMGENERACION_CODIGOS = new Gson().fromJson(trama,listType);
		}
		return listMGENERACION_CODIGOS;
	}
    	
	@Override
	public List<GENERACIONCODIGOS> subirServidor(String... strings) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GENERACIONCODIGOS> listaLocal(String... strings) {
		/***************************VARIABLES*******************************/
		String trama="";
		List<GENERACIONCODIGOS> listMGENERACION_CODIGOS = new ArrayList<GENERACIONCODIGOS>();
		// TODO Auto-generated method stub
		ParametrosHttp.URL_SERVER=ConfigInicial.LlenarConfig()[6];//Configurar Servidor
		ConexionHttp.pageConsulta(strings[1]);
//		ConexionHttp.addVariableTask("idempresa","1");/*AGREGAR PARAMETROS*/
		if(ConfigInicial.LlenarConfig()[7].equals("1")){//XML
			trama = ConexionHttp.Jsoup_Xml();
			/*ALIAS DE LAS FILAS*/
			XStream xStream= new XStream();
			xStream.alias("generacioncodigos", GENERACIONCODIGOS.class);
			xStream.aliasField("idempresa", GENERACIONCODIGOS.class, "IDEMPRESA");
			xStream.aliasField("idgeneracion", GENERACIONCODIGOS.class, "IDGENERACION");
			xStream.aliasField("tipo", GENERACIONCODIGOS.class, "TIPO");
			xStream.aliasField("descripcion", GENERACIONCODIGOS.class, "DESCRIPCION");
			xStream.aliasField("numdigitototal", GENERACIONCODIGOS.class, "NUMDIGITOTOTAL");
			xStream.aliasField("fechacreacion", GENERACIONCODIGOS.class, "FECHACREACION");
			xStream.aliasField("estado", GENERACIONCODIGOS.class, "ESTADO");
			xStream.aliasField("sincronizado", GENERACIONCODIGOS.class, "SINCRONIZADO");
			listMGENERACION_CODIGOS=(List<GENERACIONCODIGOS>)xStream.fromXML(trama);
			
		}else if(ConfigInicial.LlenarConfig()[7]=="2"){//JSON
			trama = ConexionHttp.Jsoup_Json();
			Type listType = new TypeToken<ArrayList<GENERACIONCODIGOS>>() {}.getType();
			listMGENERACION_CODIGOS = new Gson().fromJson(trama,listType);
		}
		return listMGENERACION_CODIGOS;
	}



}
