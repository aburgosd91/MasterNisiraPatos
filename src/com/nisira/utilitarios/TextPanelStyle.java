package com.nisira.utilitarios;

import com.nisira.Inicio;
import com.nisira.core.Constants;

public class TextPanelStyle {
	static final String fontFamily="Arial";
	static final String design=""+
	"<html>"+  
    "<head>"+
        "<meta charset=\"utf8\"/>"+
        "<style type=\"text/css\">"+
        ".tg  {border-collapse:collapse;border-spacing:0;margin:0px auto;}"+
//        ".tg td{padding:5px 2px;overflow:hidden;}"+
//        ".tg th{padding:5px 2px;overflow:hidden;}"+
        ".tg .tg-yw4l{vertical-align:top}"+
        "</style>"+
    "</head>"+
    "<body>"+
        "<table class=\"tg\">"+
            "<tbody>"+
            	"<tr>"+
                    "<td>"+
                        "<p style=\"text-shadow:2px 0px 7px rgba(184,180,178,0.3);"+
                            "font-weight:bold;color:#240FDB;letter-spacing:1pt;"+
                            "word-spacing:2pt;font-size:16px;text-align:left;"+
                            "font-family:"+fontFamily+", courier, monospace;line-height:1;\">"+
                            "%s"+/*"Recepción de Materia Prima"+*/
                        "</p>"+                                
                    "</td>"+
                    "<td>"+
                    "<p style=\"text-shadow:2px 1px 7px rgba(115,112,111,0.3);font-weight:bold;"+
                        "color:#000000;letter-spacing:1pt;word-spacing:2pt;"+
                        "font-size:10px;text-align:left;font-family:"+fontFamily+", courier,"+ 
                        "monospace;line-height:1;\">%s</p>"+/*Fecha : 19/09/2016*/
                    "</td>"+
                "</tr>"+
                "<tr>"+
                    "<td>"+
                        "<p style=\"text-shadow:10px 1px 7px rgba(115,112,111,0.3);font-weight:bold;color:#000000;letter-spacing:1pt;"+
                        "word-spacing:2pt;font-size:12px;text-align:left;font-family:"+fontFamily+", courier, monospace;line-height:1;\">"+
                        "%s</p>"+  /*Zona : Almacen de Materia Prima*/                             
                    "</td>"+
                    "<td>"+
                        "<p style=\"text-shadow:10px 1px 7px rgba(115,112,111,0.3);font-weight:bold;color:#000000;letter-spacing:1pt;"+
                        "word-spacing:2pt;font-size:10px;text-align:left;font-family:"+fontFamily+", courier, monospace;line-height:1;\">"+
                        "%s</p>"+/*Hora: 05 :30 pm*/                               
                    "</td>"+
                "</tr>"+
                "<tr>"+
                    "<td>"+
                        "<p style=\"text-shadow:10px 1px 7px rgba(115,112,111,0.3);font-weight:bold;color:#000000;letter-spacing:1pt;"+
                        "word-spacing:2pt;font-size:12px;text-align:left;font-family:"+fontFamily+", courier, monospace;line-height:1;\">"+
                        "%s</p>"+/*Ubicación : S001-A001-R001-P001-F001-C001*/                                
                    "</td>"+
                "</tr>"+
                "<tr>"+
                    "<td>"+
                        "<p style=\"text-shadow:10px 1px 7px rgba(115,112,111,0.3);font-weight:bold;color:#000000;letter-spacing:1pt;"+
                        "word-spacing:2pt;font-size:12px;text-align:left;font-family:"+fontFamily+", courier, monospace;line-height:1;\">"+
                        "%s</p>"+/*Operario: GUSTAVO GONZALES CRUZ*/                               
                    "</td>"+
                "</tr>"+
            "</tbody>"+
        "</table>"+
    "</body>"+
    "</html>";
	
	public static String estructuracionTexto(String ...item){
		String[] items= new String[item.length];
		items[0] = (item[0]==null?"":item[0]);
		items[1] = "Fecha : " + Constants.fechaActual();
		items[2] = ("Zona : ") + (item[2]==null?"":item[2]);
		items[3] = "Hora : " + Constants.timeActual();
		items[4] = ("Ubicación : ")+(item[4]==null?"":item[4]);
		items[5] = "Operario : "+ Inicio.usuario.getNombres();
//		System.out.println(html);
		return String.format(design,items);
	}

	public static void main(String[] args) {
		String[] datos={
				"Recepción de Materia Prima",
				"Fecha : 19/09/2016",
				"Zona : Almacen de Materia Prima",
				"Hora: 05 :30 pm",
				"Ubicación : S001-A001-R001-P001-F001-C001",
				"Operario: GUSTAVO GONZALES CRUZ"};
		System.out.println(estructuracionTexto(datos));
	}
	
}
