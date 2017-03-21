package com.nisira;

import com.nisira.core.CoreUtil;
import com.nisira.core.EConexion;
import com.nisira.generator.FrmGeneraEntidades;
public class RunGenerador {

	public static void main(String[] args) {
		EConexion e = new EConexion();
		e.BASE_DATOS = "MASTEREDOC_MOVIL";
		e.CLAVE = "amadeus2010";
		e.INSTANCIA = "patos";
		e.USUARIO = "sa";
		e.SERVIDOR = "192.168.0.90";
		e.TIPO = "MSSQL";
		
		CoreUtil.conexiones.put("default", e);
		new FrmGeneraEntidades(e.TIPO).setVisible(true);
	}

}
