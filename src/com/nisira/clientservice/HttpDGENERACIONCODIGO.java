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
import com.nisira.entidad.DGENERACIONCODIGOS;
import com.nisira.entidad.GENERACIONCODIGOS;
import com.nisira.httpclient.ConexionHttp;
import com.nisira.httpclient.ParametrosHttp;
import com.nisira.utils.nisiracore.Constantes;
import com.thoughtworks.xstream.XStream;

import core.inicio.ConfigInicial;

public class HttpDGENERACIONCODIGO extends HttpComponents<DGENERACIONCODIGOS>{
	@Override
	public List<DGENERACIONCODIGOS> bajarServidor(String... strings) {
		/***************************VARIABLES*******************************/
		String trama="";
		List<DGENERACIONCODIGOS> listDGENERACION_CODIGOS = new ArrayList<DGENERACIONCODIGOS>();
		// TODO Auto-generated method stub
		ParametrosHttp.URL_SERVER=ConfigInicial.LlenarConfig()[6];//Configurar Servidor
		ConexionHttp.pageConsulta(strings[1]);
		ConexionHttp.addVariableTask("idempresa","1");/*AGREGAR IDEMPRESA*/
		if(ConfigInicial.LlenarConfig()[7].equals("1")){//XML
			trama = ConexionHttp.Jsoup_Xml();
			/*ALIAS DE LAS FILAS*/
			XStream xStream= new XStream();
			xStream.alias("DGENERACIONCODIGOS", DGENERACIONCODIGOS.class);
//			xStream.aliasField("idempresa", DGENERACIONCODIGOS.class, "IDEMPRESA");
//			xStream.aliasField("idgeneracion", DGENERACIONCODIGOS.class, "IDGENERACION");
//			xStream.aliasField("idregistrocodigo", DGENERACIONCODIGOS.class, "IDREGISTROCODIGO");
//			xStream.aliasField("idparametro", DGENERACIONCODIGOS.class, "IDPARAMETRO");
//			xStream.aliasField("numdigitototal", DGENERACIONCODIGOS.class, "NUMDIGITOTOTAL");
//			xStream.aliasField("numdigito", DGENERACIONCODIGOS.class, "NUMDIGITO");
//			xStream.aliasField("sincronizado", DGENERACIONCODIGOS.class, "SINCRONIZADO");
//			xStream.aliasField("parametro", DGENERACIONCODIGOS.class, "PARAMETRO");
//			xStream.aliasField("PARAMETRO", GENERACIONCODIGOS.class, "DATO");
			listDGENERACION_CODIGOS=(List<DGENERACIONCODIGOS>)xStream.fromXML(trama);
			
		}else if(ConfigInicial.LlenarConfig()[7]=="2"){//JSON
			trama = ConexionHttp.Jsoup_Json();
			Type listType = new TypeToken<ArrayList<DGENERACIONCODIGOS>>() {}.getType();
			listDGENERACION_CODIGOS = new Gson().fromJson(trama,listType);
		}
		return listDGENERACION_CODIGOS;
	}
    	
	@Override
	public List<DGENERACIONCODIGOS> subirServidor(String... strings) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DGENERACIONCODIGOS> listaLocal(String... strings) {
		// TODO Auto-generated method stub
		return null;
	}



}
