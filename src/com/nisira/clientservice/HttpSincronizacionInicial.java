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
import com.nisira.entidad.SincronizacionInicial;
import com.nisira.httpclient.ConexionHttp;
import com.nisira.httpclient.ParametrosHttp;
import com.nisira.utils.nisiracore.Constantes;
import com.thoughtworks.xstream.XStream;

import core.inicio.ConfigInicial;

public class HttpSincronizacionInicial{ 

	public SincronizacionInicial bajar(String... strings) {
		/***************************VARIABLES*******************************/
		String trama="";
		SincronizacionInicial sincro =new SincronizacionInicial();
		ParametrosHttp.URL_SERVER=ConfigInicial.LlenarConfig()[6];//Configurar Servidor
		ConexionHttp.pageConsulta(strings[1]);
		ConexionHttp.addVariables("idempresa","1");/*AGREGAR PARAMETROS*/
		
		if(ConfigInicial.LlenarConfig()[7].equals("1")){//XML
			trama = ConexionHttp.Jsoup_Xml();
			/*ALIAS DE LAS FILAS*/
			XStream xStream= new XStream();
			xStream.alias("sincronizacioninicial", SincronizacionInicial.class);
			xStream.aliasField("generacioncodigoencode", String.class, "GeneracionCodigoEncode");
			xStream.aliasField("dgeneracioncodigoencode", String.class, "DGeneracionCodigoEncode");	
			sincro=(SincronizacionInicial)xStream.fromXML(trama);
			
		}else if(ConfigInicial.LlenarConfig()[7]=="2"){//JSON
			trama = ConexionHttp.Jsoup_Json();
			Type listType = new TypeToken<SincronizacionInicial>() {}.getType();
			sincro = new Gson().fromJson(trama,listType);
		}
		return sincro;
	}
    	
	public SincronizacionInicial subir(String... strings) {
		// TODO Auto-generated method stub
		return null;
	}


}
