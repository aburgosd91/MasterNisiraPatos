package com.nisira.alien;

public abstract class AlienRfid {
	public static String mensajeConsole;
	public static void ClearConsole(){
		mensajeConsole="";
	}
	public static void addConsole(String dato){
		if(mensajeConsole==null)
			mensajeConsole="";
		mensajeConsole+="\n"+dato;
	}
	public static String getMensajeConsole(){
		return mensajeConsole;
	}
}
