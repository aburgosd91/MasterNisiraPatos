package com.nisira.alien;

import com.alien.enterpriseRFID.reader.AlienReaderCommandErrorException;
import com.alien.enterpriseRFID.reader.AlienReaderConnectionException;
import com.alien.enterpriseRFID.reader.AlienReaderException;
import com.alien.enterpriseRFID.reader.AlienReaderTimeoutException;
import com.nisira.utils.nisiracore.Constantes;

public class WriterAlien extends AlienRfid{
	public static String escrituraRfid(String tagId, String configAntena){
		/*F2 01 9A 50 80 03 0A F0 00 00 41 55*/
		String console=null;
		try {
			ComandosRfid.openConsoleComand();
			/*********************CONFIGURACION INICIAL******************************/
			ComandosRfid.reader.doReaderCommand(ComandosRfid.comandParametro(ComandosRfid.comandoTagProgramCommands[0],configAntena));//Configurar Antena que Escribirá
			/************************************************************************/
//			console= ComandosRfid.reader.doReaderCommand(ComandosRfid.comandoTagProgram[0]);
			console= ComandosRfid.reader.doReaderCommand(ComandosRfid.comandParametro(ComandosRfid.comandoTagProgram[0],WriterAlien.formatoData(tagId)));
			Constantes.messageLog("Write Rfid ", console);
			return console;
		} catch (AlienReaderTimeoutException | AlienReaderConnectionException | AlienReaderCommandErrorException e) {
			// TODO Auto-generated catch block
			Constantes.messageLog("Error class WriterAlien : ", e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean escrituraRfidMejora1(String tagId, String configAntena) throws AlienReaderException{
		/*F2 01 9A 50 80 03 0A F0 00 00 41 55*/
		try {
			ComandosRfid.openConsoleComand();
			/*********************CONFIGURACION INICIAL******************************/
			ComandosRfid.reader.doReaderCommand(ComandosRfid.comandParametro(ComandosRfid.comandoTagProgramCommands[0],configAntena));//Configurar Antena que Escribirá
			String code=WriterAlien.formatoData(tagId);
			ComandosRfid.reader.programTag(code);
			/************************************************************************/
//			console= ComandosRfid.reader.doReaderCommand(ComandosRfid.comandoTagProgram[0]);
//			console= ComandosRfid.reader.doReaderCommand(ComandosRfid.comandParametro(ComandosRfid.comandoTagProgram[0],WriterAlien.formatoData(tagId)));
			Constantes.messageLog("Write Rfid ", WriterAlien.formatoData(tagId));
			return true;
		} catch (AlienReaderTimeoutException | AlienReaderConnectionException | AlienReaderCommandErrorException e) {
			// TODO Auto-generated catch block
			Constantes.messageLog("Error class WriterAlien : ", e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public static String formatoData(String dato){
		dato=dato.replace("-","").replace(" ","").trim();
		if(dato.length()>0){
			dato=dato.trim(); /*ELIMINAR ESPACIOS DE EXTREMOS*/
			int tamanio= dato.length();
			int cant=0;
			for(int i=0;i<tamanio;i++){
				if(cant==2){
					dato= dato.substring(0,i)+" "+ dato.substring(i,tamanio);
					tamanio=dato.length();
					cant=0;
				}else{
					cant++;
				}
			}
		}
		return dato;
	}
	
	public static void main(String[] args) throws InterruptedException, AlienReaderException {
		// TODO Auto-generated method stub
//		do{
//			WriterAlien.escrituraRfid();
//			Thread.sleep(500);
//		}while(true);
		/*F2 01 9A 50 80 03 0A F0 00 00 41 55*/
		System.out.println(WriterAlien.formatoData("F201-9A50-8003-0AF0-0000-4155"));
	}

}
