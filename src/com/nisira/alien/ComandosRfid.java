package com.nisira.alien;

import java.awt.Color;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.comm.CommPortIdentifier;

import com.alien.enterpriseRFID.discovery.AlienDiscoverySerialException;
import com.alien.enterpriseRFID.discovery.DiscoveryItem;
import com.alien.enterpriseRFID.discovery.SerialDiscoveryListenerService;
import com.alien.enterpriseRFID.reader.AlienClass1Reader;
import com.alien.enterpriseRFID.reader.AlienReaderCommandErrorException;
import com.alien.enterpriseRFID.reader.AlienReaderConnectionException;
import com.alien.enterpriseRFID.reader.AlienReaderException;
import com.alien.enterpriseRFID.reader.AlienReaderNotValidException;
import com.alien.enterpriseRFID.reader.AlienReaderTimeoutException;
import com.nisira.Inicio;
import com.nisira.core.NisiraORMException;
import com.nisira.dao.AntenaDao;
import com.nisira.dao.DANTENADao;
import com.nisira.dao.DPUERTOCOMDao;
import com.nisira.dao.RFIDREADERDao;
import com.nisira.entidad.ANTENA;
import com.nisira.entidad.DANTENA;
import com.nisira.entidad.DPUERTOCOM;
import com.nisira.entidad.RFIDREADER;
import com.nisira.utils.nisiracore.Constantes;

import core.inicio.ConfigInicial;

public class ComandosRfid {
	/* NUEVO */
	public static List<DPUERTOCOM> lstPuertos;
	public static RFIDREADER rfidreader;
	public static List<DANTENA> lstDAntena;
	public static List<String> lstAntena_String = new ArrayList<>();
	public static List<ANTENA> lstAntena = new ArrayList<>();
	public static String puertoCom;/*PUERTO COM*/
	/* PARAMETROS */
	public static RFIDREADER decoderRFID;
	public static Boolean isConexionRfid(){
		Boolean flag=false;
		/*TRAER PUERTOS COM CONFIGURADOS EN SISTEMA*/
		try {
			List<DPUERTOCOM> lstPuertoCom = (new DPUERTOCOMDao()).listaDesc(1, Inicio.idempresa,Inicio.idmontacarga);
			decoderRFID =(new RFIDREADERDao(true)).getPorClavePrimaria(1, Inicio.idempresa, Inicio.idmontacarga);
			if(lstPuertoCom!=null){
				if(lstPuertoCom.size()>0){
					/*OBTENER PUERTOS DISPONIBLES EN EQUIPO*/
					SerialDiscoveryListenerService service = new SerialDiscoveryListenerService();
					service.run();
					DiscoveryItem[] d = service.getDiscoveryItems();
					service.stopService();
				}
			}
		} catch (NisiraORMException | AlienDiscoverySerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public static Boolean isConexionAlien(){
		try{
			Boolean flag=false;
			List<String> lista = listarPuertoCom();
			puertoCom=ConfigInicial.LlenarConfig()[16];/*PUERTO COM*/
			for(String puerto : lista){
				if(puertoCom.equalsIgnoreCase(puerto)){
					flag=true;
					break;
				}
			}
			if(flag)
				if(Inicio.consolesRfid)Constantes.messageLog("Info", "Conexion Success");
			else
				if(Inicio.consolesRfid)Constantes.messageLog("Info", "Conexion Failure");
			return flag;
		}catch (Exception e) {
			if(Inicio.consolesRfid)Constantes.messageLog("Info", "Conexion Failure");
			if(Inicio.consolesRfid)Constantes.messageLog("Error Conexión", e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	public static boolean openConsoleComand(){
		try {
			Inicio.validateConfigRfid = verificacionConexionServer();
//			Inicio.validateConfigRfid=true;
			if(Inicio.validateConfigRfid){/*VERIFICAR <COM> DISPONIBLE BASE<->READER*/
				if(reader==null){
//					puertoCom=ConfigInicial.LlenarConfig()[16];/*PUERTO COM*/
					reader = new AlienClass1Reader(puertoCom); // Create reader object
					if(Inicio.consolesRfid)Constantes.messageLog("Info", "Create Instance AlienClass1Reader");
				}
				if(!reader.isOpen()){
					reader.open();
					if(Inicio.consolesRfid)Constantes.messageLog("Info", "Open Reader");
				}
				return true;
			}else{
				return false;
			}
		} catch (AlienReaderNotValidException | AlienReaderTimeoutException | AlienReaderConnectionException e) {
			// TODO Auto-generated catch block
			if(Inicio.consolesRfid)Constantes.messageLog("Error class ComandosRfid", e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	public static void openConsoleComand(String p){
		try {
			if(reader==null){
				reader = new AlienClass1Reader(p); // Create reader object
				if(Inicio.consolesRfid)Constantes.messageLog("Info", "Create Instance AlienClass1Reader");
			}
			if(!reader.isOpen()){
				reader.open();
				if(Inicio.consolesRfid)Constantes.messageLog("Info", "Open Reader");
			}
			/*EJECUTAR COMANDO*/
		} catch (AlienReaderNotValidException | AlienReaderTimeoutException | AlienReaderConnectionException e) {
			// TODO Auto-generated catch block
			if(Inicio.consolesRfid)Constantes.messageLog("Error class ComandosRfid", e.getMessage());
			e.printStackTrace();
		} // Open the reader connection
	}
	public static void closeConsole(){
		try {
			if(reader!=null)
				if(reader.isOpen()){
					reader.close();
					Constantes.messageLog("Info", "Close Reader");
				}
//			if(Inicio.consolesRfid)Constantes.messageLog("Info", "Close Reader");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(Inicio.consolesRfid)Constantes.messageLog("Error class ComandosRfid", e.getMessage());
			e.printStackTrace();
		}
	}
	public static String comandParametro(String ... params){
		/*
		 * strings[0] -> comando
		 * strings[1]...[n] -> parametros
		 * */
		String parametroComand="";
		if(params!=null)
			if(params.length>0){
				/*COMANDO*/
				parametroComand+=params[0]+" =";
				/*PARAMETROS*/
				for(int i=1;i<params.length;i++){
					if(i != params.length-1)
						parametroComand+=params[i]+",";
					else
						parametroComand+=params[i];
				}
			}
		return parametroComand;
	}
	public static String comandParametro(String cmd,List<String> ant){
		String parametroComand="";
		if(!ant.isEmpty())
			if(ant.size()>0){
				/*COMANDO*/
				parametroComand+=cmd+" =";
				/*PARAMETROS*/
				for(int i=0;i<ant.size();i++){
					if(i != ant.size()-1)
						parametroComand+=ant.get(i)+",";
					else
						parametroComand+=ant.get(i);
				}
			}
		return parametroComand;
	}
	public static String comandParametro_object(String cmd,String ant){
		String parametroComand="";
		if(!ant.isEmpty()){
			/*COMANDO*/
			parametroComand+=cmd+" =";
			parametroComand+=ant;
		}
		return parametroComand;
	}
	public static void ListaPuertos(){
		Enumeration listaPort;
		CommPortIdentifier idPort;
		listaPort=CommPortIdentifier.getPortIdentifiers();
		String lista="";
		lista +="Los puertos disponibles son:";
		while (listaPort.hasMoreElements())
		{
			idPort = (CommPortIdentifier) listaPort.nextElement();
			lista +="PUERTO: " + idPort.getName() + " ";
	
			if (idPort.getPortType() == CommPortIdentifier.PORT_SERIAL){
				lista +="RS-232 (" + idPort.getPortType() + ")";
			} else if (idPort.getPortType() == CommPortIdentifier.PORT_PARALLEL){
				lista +="IEEE 1284 (" + idPort.getPortType() + ")";
			} else 
				lista +="Tipo de puerto desconocido";
	
			// Describimos si esta disponible.
			if (idPort.isCurrentlyOwned())
				lista +="OCUPADO por: " + idPort.getCurrentOwner();
			else
				lista +="DISPONIBLE";
		
			lista +="\n---------------------------------------------\n";
		}
		if(Inicio.consolesRfid)System.out.println(lista);
	
		}
	public static List<String> listarPuertoCom(){
		List<String> listaPuertosCom=new ArrayList<String>();
		Enumeration listaPort=CommPortIdentifier.getPortIdentifiers();
		CommPortIdentifier idPort;
		while (listaPort.hasMoreElements()){
			idPort = (CommPortIdentifier) listaPort.nextElement();
			if (idPort.getPortType() == CommPortIdentifier.PORT_SERIAL){
				if (!idPort.isCurrentlyOwned())
					listaPuertosCom.add(idPort.getName());
			}
		}
		return listaPuertosCom;
	}
	public static void main(String[] args) throws InterruptedException, AlienReaderException {
		// TODO Auto-generated method stub
		while(true){
			ComandosRfid.ListaPuertos();
			Thread.sleep(1000);
		}     
	}
	/* ANALISIS DE SENSOR -> ASIGNAMOS PUERTO <COM?>*/
	public static boolean verificacionConexionServer(){
		boolean flag = false;
		DiscoveryItem[] d = null;
		List<String> ant = new ArrayList<>();
		try {
			SerialDiscoveryListenerService service = new SerialDiscoveryListenerService();
			service.run();
			d = service.getDiscoveryItems();
			service.stopService();
			String MAC = null;
			lstPuertos = new ArrayList<>();
			lstDAntena = new ArrayList<>();
			rfidreader = (new RFIDREADERDao()).listar(1, "IDEMPRESA = ? and NROSERIE = ? and IDCPUMOVIL = ?", ConfigInicial.LlenarConfig()[8],
					ConfigInicial.LlenarConfig()[17],ConfigInicial.LlenarConfig()[18]).get(0); /*TOMAR EN READER ASIGNADO A UN CPU |<NROSERIE>,<IDCPUMOVIL>|*/
			lstPuertos =(new DPUERTOCOMDao()).listaDescActivo(1, rfidreader.getIDEMPRESA(), rfidreader.getIDCPUMOVIL());
			lstDAntena = (new DANTENADao()).listaDesc(1, rfidreader.getIDEMPRESA(), rfidreader.getIDCPUMOVIL());
			/*CARGAR DATOS DE ANTENA*/
			if(lstDAntena!=null){
				lstAntena_String.clear();
				lstAntena.clear();
				for(DANTENA dante :lstDAntena){
					ANTENA obj =(new AntenaDao()).getPorClavePrimaria(dante.getIDEMPRESA(), dante.getIDANTENA());
					if(dante.getACTIVO()==1){
						lstAntena_String.add(String.valueOf((dante.getIDANTENA()-1)));
						ant.add(String.valueOf(dante.getIDANTENA()-1));
						lstAntena.add(obj);
					}
				}
				
			}
			if (d.length != 0 || lstPuertos ==null) {
				for (DiscoveryItem da : d) {
					for(DPUERTOCOM puerto :lstPuertos){
						if (da.getReaderAddress().equalsIgnoreCase(puerto.getDescripcion())) {
							MAC = da.getReaderMACAddress();
							flag = true;
							puertoCom=puerto.getDescripcion();/*ASIGNAR */
							break;
						}
					}
				}
				if (flag) {
					if (MAC.trim().equalsIgnoreCase(rfidreader.getNROSERIE().trim())) {
						System.out.println("Conectado Rfid");
						ComandosRfid.reader= new AlienClass1Reader(puertoCom);
						/*CONFIGURAR ANTENAS*/
//						ComandosRfid.reader.doReaderCommand(ComandosRfid.comandParametro(ComandosRfid.comandoGeneralCommands[0],ant));//Configurar Antena que Leerá
					} else {
						System.out.println("No coincide la Direccion MAC");
					}
				} else {
					System.out.println("No disponible en puerto " + lstPuertos.get(0).getDescripcion());
				}
			}else {
				System.out.println("Desconectado");
			}
		} catch (AlienDiscoverySerialException | NisiraORMException e1) {
			// TODO Auto-generated catch block
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
//			textArea.append("D = "+d.length);
//			textArea.append(sw.getBuffer().toString());
		}	
		return flag;
	}
	/*VERSION ANTIGUA*/
	/*ENVIO*/
	public final static String[] comandoGeneralCommand={"info","help"};
	public final static String[] comandoTaglist={"t","to"};	
	public final static String[] comandoTagProgram={"ProgramEPC"};
	/*ENVIO CON PARAMETROS*/
	public final static String[] comandoGeneralCommands={"AntennaSequence"};
	public final static String[] comandoTagProgramCommands={"ProgAntenna"};
	/* RESTRICCIONES */
	public final static String[] comandoRestricciones={"(No Tags)"}; 
	public static AlienClass1Reader reader;
}
