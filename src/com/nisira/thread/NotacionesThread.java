package com.nisira.thread;

import java.awt.event.ActionEvent;
import java.util.logging.Logger;

import com.nisira.utils.nisiracore.Constantes;

public class NotacionesThread {
	public static Thread hilo;
	public static final int time_MainFrame_Notificacion=300;
	/*NOMENCLATURA DE THREAD*/
	/*
	 * <NOMBRE DE CLASE DONDE ES CREADA> + _ +<DESCRIPCION>
	 *  
	 * */
	public static final String tMaintFrame_Notifiacion ="MainFrame_Notifiacion";
	public static final String tMaintFrame_Actualizacion ="MainFrame_Actualizacion";
	public static final String tFrmSysZona_AlertaUbicacion="FrmSysZona_AlertaUbicacion";
	public static final String tFrmSysZona_AlertaUbicacionToca="FrmSysZona_AlertaUbicacionToca";
	public static final String tFrmSysZona_AlertStreetView="FrmSysZona_AlertStreetView";
	public static final String tFrmSysZona_CargarDatosInicial="FrmSysZona_CargarDatosInicial";
	public static final String tFrmSysZona_MostrarRecorrido="FrmSysZona_MostrarRecorrido";
	public static final String tFrmSysZona_CargarRutas="FrmSysZona_CargarRutas";
	public static final String tFrmSysZona_Rfid="FrmSysZona_Rfid";
	
	public final static String tFrmRFIDreader_LecturaRfid ="FrmRFIDreader_LecturaRfid";
	public final static String tFrmRFIDreader_ValidarConexion ="FrmRFIDreader_ValidarConexion";
	public final static String tFrmRFIDreader_CMD="FrmRFIDreader_CMD";
	
	public static void stopThreadName(String nameHilo) {
		ThreadGroup threadGroup = Thread.currentThread ().getThreadGroup ();
		Thread [] listaHilo= new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(listaHilo, true);
		for(int i=0;i<listaHilo.length;i++){
			if(listaHilo[i].getName().equalsIgnoreCase(nameHilo)){
				Constantes.log.info(listaHilo[i].getName());
				listaHilo[i].stop();
			}
		}
	}
	public static void stopThreadClass(String clase) {
		ThreadGroup threadGroup = Thread.currentThread ().getThreadGroup ();
		Thread [] listaHilo= new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(listaHilo, true);
		for(int i=0;i<listaHilo.length;i++){
			if(listaHilo[i].getName().contains(clase)){
				Constantes.log.info(listaHilo[i].getName());
				listaHilo[i].stop();
			}
		}
	}
	public static void stopThreadTotal() {
		try{
			ThreadGroup threadGroup = Thread.currentThread ().getThreadGroup ();
			Thread [] listaHilo= new Thread[threadGroup.activeCount()];
			threadGroup.enumerate(listaHilo, true);
			for(int i=0;i<listaHilo.length;i++){
				Constantes.log.info(listaHilo[i].getName());
				if(listaHilo[i].isAlive()){
					listaHilo[i].interrupt();
				}
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}
