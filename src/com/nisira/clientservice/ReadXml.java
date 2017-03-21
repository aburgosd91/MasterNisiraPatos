package com.nisira.clientservice;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.Document;

public class ReadXml {
	public static final String  srcLocal="C://SOLUTION//WEB//solution.xml";
	
	public static List<Object> readearXMLXCodigoBarra(){
		//Se crea un SAXBuilder para poder parsear el archivo
	    SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(srcLocal);
		//Se crea el documento a traves del archivo
        Document document;
		try {
			document = (Document) builder.build( xmlFile );
			//Se obtiene la raiz 'tables'
	        Element rootNode = document.getRootElement();
	        //Se obtiene la lista de hijos de la raiz 'barcode'
	        List list = rootNode.getChildren( "barcode" );
	        //Se recorre la lista de hijos de 'tables'
	        if(list!=null){
	        	for ( int i = 0; i < list.size(); i++ )
		        {
		            //Se obtiene el elemento 'tabla'
		            
		            if(list.get(i)!=null){
		            	Element tabla = (Element) list.get(i);
		            	/*LISTAR ELEMENTOS DE NIVEL 1*/
			            //Se obtiene el atributo 'inicio' que esta en el tag 'barcode'
			            String inicio=tabla.getChildTextTrim("inicio");
			            String fin=tabla.getChildTextTrim("fin");
			            String total=tabla.getChildTextTrim("total");
			            //Se obtiene la lista de hijos del tag 'tabla'
			            List lista_campos = tabla.getChildren("digitos");
			 
			            System.out.println( "\tCABECERA: \t\t"+inicio+"\t\t"+fin+"\t\t"+total );
			            if(lista_campos!=null & lista_campos.size()>0){
			            	/*NIVEL TRES*/
				            Element datos = (Element)lista_campos.get(0);
				            List lista_dbarcode= datos.getChildren("dbarcode");
				            for(int y=0;y<lista_dbarcode.size();y++){
				            	Element item = (Element)lista_dbarcode.get(y);
				            	String numdigito=item.getChildTextTrim("numdigito");
				            	String parametro=item.getChildTextTrim("parametro");
				            	System.out.println( "\t"+"DBARCODE N° "+(y+1)+"\t\t"+numdigito+"\t\t"+parametro);
				            }
			            }
		            }
		        }
	        }
	        
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadXml.readearXMLXCodigoBarra();
	}

}
