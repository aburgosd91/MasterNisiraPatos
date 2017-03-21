package com.nisira.alien;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.joda.time.DateTime;

import com.alien.enterpriseRFID.reader.AlienReaderCommandErrorException;
import com.alien.enterpriseRFID.reader.AlienReaderConnectionException;
import com.alien.enterpriseRFID.reader.AlienReaderException;
import com.alien.enterpriseRFID.reader.AlienReaderTimeoutException;
import com.alien.enterpriseRFID.tags.Tag;
import com.nisira.Inicio;
import com.nisira.entidad.ANTENA;

public class ReaderAlien extends AlienRfid{
	
	public static List<Tag> lecturaRfid() throws AlienReaderException{
		String console="";
		List<Tag> chips=new ArrayList();
		String datosConsole[];
		Tag tag;
		ComandosRfid.openConsoleComand();
		/*********************CONFIGURACION INICIAL******************************/
		ComandosRfid.reader.doReaderCommand(ComandosRfid.comandParametro(ComandosRfid.comandoGeneralCommands[0],"2","1"));//Configurar Antena que Leerá
		/************************************************************************/
		StringTokenizer tokens;
		console=ComandosRfid.reader.doReaderCommand(ComandosRfid.comandoTaglist[0]).trim();
//		System.out.println("Console:"+console);
//		addConsole("Console:"+console);
		if(console!=null){
			if(!console.equalsIgnoreCase(ComandosRfid.comandoRestricciones[0])){// Result = (No Tags)
				tokens = new StringTokenizer(console,"\n");
				while(tokens.hasMoreTokens()){
					datosConsole=tokens.nextToken().split(",");
					tag=new Tag(datosConsole[0].split(":")[1]);//Id
//					tag.setDiscoverTime(new DateTime(datosConsole[1].split(":")[1]).getMillis());
//					tag.setRenewTime(new DateTime(datosConsole[2].split(":")[1]).getMillis());
					tag.setRenewCount(Integer.parseInt(datosConsole[3].split(":")[1]));
					tag.setAntenna(Integer.parseInt(datosConsole[4].split(":")[1]));
//					tag.setProtocol(Integer.parseInt(datosConsole[5].split(":")[1])); 
					chips.add(tag);
				}
			}
			ReaderAlien.response(chips);
			//System.out.println("\nAntena: "+ComandosRfid.reader.getAntennaSequence());
			//addConsole("Antena: "+ComandosRfid.reader.getAntennaSequence());
		}
		ComandosRfid.closeConsole();
		return chips;
	}
	public static List<Tag> lecturaRfidMejora1() throws AlienReaderException{
		List<Tag> chips=new ArrayList();
		Tag tag=null;
		if(ComandosRfid.openConsoleComand()){
			/*<COM> -> ASIGNADO*/
			/******************CODIGO MEJORADO********************/
			Tag tagList[] = ComandosRfid.reader.getTagList();
			  if (tagList == null) {
			    System.out.println("No Tags Found");
			  } else {
			    System.out.println("Tag(s) found:");
			    for (int i=0; i<tagList.length; i++) {
			      tag = tagList[i];
//			      System.out.println("ID:" + tag.getTagID() +
//			                         ", Discovered:" + tag.getDiscoverTime() +
//			                         ", Last Seen:" + tag.getRenewTime() +
//			                         ", Antenna:" + tag.getAntenna() +
//			                         ", Reads:" + tag.getRenewCount()
//			                         );
			      if(tag!=null)
			    	  chips.add(tag);
			    }
			    ReaderAlien.response(chips);
			  }
			ComandosRfid.closeConsole();
		}
		return chips;
	}
	public static List<Tag> lecturaRfidAntena(List<String> ant) throws AlienReaderException{
		String console="";
		boolean solountag;
		List<Tag> chips=new ArrayList();
		String datosConsole[];
		Tag tag;
//		ComandosRfid.closeConsole();
		if(ComandosRfid.openConsoleComand()){
			for(String a : ant){
				ComandosRfid.reader.doReaderCommand(ComandosRfid.comandParametro_object(ComandosRfid.comandoGeneralCommands[0],a));
				StringTokenizer tokens;
				console=ComandosRfid.reader.doReaderCommand(ComandosRfid.comandoTaglist[0]).trim();
				if(console!=null){
					if(!console.equalsIgnoreCase(ComandosRfid.comandoRestricciones[0])){// Result = (No Tags)
						tokens = new StringTokenizer(console,"\n");
						solountag=true;
						while(tokens.hasMoreTokens() & solountag){
							datosConsole=tokens.nextToken().split(",");
							tag=new Tag(datosConsole[0].split(":")[1]);//Id
//								tag.setDiscoverTime(new DateTime(datosConsole[1].split(":")[1]).getMillis());
//								tag.setRenewTime(new DateTime(datosConsole[2].split(":")[1]).getMillis());
							tag.setRenewCount(Integer.parseInt(datosConsole[3].split(":")[1]));
							tag.setAntenna(Integer.parseInt(datosConsole[4].split(":")[1]));
//								tag.setProtocol(Integer.parseInt(datosConsole[5].split(":")[1])); 
							chips.add(tag);
							solountag=false;
						}
					}
				}
			}
		}
		if(Inicio.consolesRfid){
			System.out.println(" TEST ");
			ReaderAlien.response(chips);}
		ComandosRfid.closeConsole();
		return chips;
	}
	public static void response(List result){
		System.out.println("\nTotal Tag: "+result.size());
		for(int i=0;i<result.size();i++){
			System.out.println("ID:" + ((Tag)result.get(i)).getTagID() +
                    ", Discovered:" + ((Tag)result.get(i)).getDiscoverTime() +
                    ", Last Seen:" + ((Tag)result.get(i)).getRenewTime() +
                    ", Antenna:" + ((Tag)result.get(i)).getAntenna() +
                    ", Reads:" + ((Tag)result.get(i)).getRenewCount()
            );
		}
	}
	/*
	public static void response(List result){
		System.out.println("\nTotal Tag: "+result.size());
		for(int i=0;i<result.size();i++){
			System.out.println("N°"+(i+1)+" Tag: "+((Tag)result.get(i)).getTagID());
			addConsole("N°"+(i+1)+" Tag: "+((Tag)result.get(i)).getTagID());
		}
	}
	*/
	public static List<TagsRfid> getDatosTag() throws AlienReaderException{
		List<TagsRfid> listTag = new ArrayList<>();
		for(ANTENA an : ComandosRfid.lstAntena)
			listTag.add(new TagsRfid(an));
		List<Tag> lTag=lecturaRfidAntena(ComandosRfid.lstAntena_String);
		for(int i=0;i<listTag.size();i++){/*POR NUMERO DE ANTENA*/
			Tag x = deleteSoloUnoPorAntena(lTag,listTag.get(i).getAntena().getIdantena()-1);
			listTag.get(i).setTag(x);
		}
		return listTag;
	}
	public static Tag deleteSoloUnoPorAntena(List<Tag> lTag,int antena){
		Tag tg = null;
		for(Tag obj:lTag){
			if(obj.getAntenna()==antena){
				tg=obj;
				break;
			}
		}
		return tg;
	}
	public static boolean validarListTagsRfid(List<TagsRfid> listTag){
		boolean flag =false;
		for(TagsRfid obj :listTag){
			if(obj.getTag()==null){
				flag=true;
				break;
			}
		}
		return flag;
	}
	public static void main(String[] args) throws InterruptedException, AlienReaderException {
		// TODO Auto-generated method stub
		do{
			ReaderAlien.lecturaRfidMejora1(); 
			Thread.sleep(100);
		}while(true);
	}
	public static void exectComando(String cmd,String port,List<String> ant) throws AlienReaderException{
		ComandosRfid.openConsoleComand(port);
		String console;
		/*********************CONFIGURACION INICIAL******************************/
		ComandosRfid.reader.doReaderCommand(ComandosRfid.comandParametro(ComandosRfid.comandoGeneralCommands[0],ant));//Configurar Antena que Leerá
		/************************************************************************/
		console=ComandosRfid.reader.doReaderCommand(cmd.trim());
		if(Inicio.consolesRfid)addConsole(console);
	}
	public static void executeComando(String cmd) throws AlienReaderException{
		ComandosRfid.openConsoleComand(ComandosRfid.puertoCom);
		String console;
		/*********************CONFIGURACION INICIAL******************************/
		ComandosRfid.reader.doReaderCommand(ComandosRfid.comandParametro(ComandosRfid.comandoGeneralCommands[0],ComandosRfid.lstAntena_String));//Configurar Antena que Leerá
		/************************************************************************/
		console=ComandosRfid.reader.doReaderCommand(cmd.trim());
		if(Inicio.consolesRfid)addConsole(console);
	}
}
