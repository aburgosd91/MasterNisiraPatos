package com.nisira.vista.controles;

import java.awt.Color;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class FormatStyleText {
	
	public static Style heading2Style;
	public static final StyleContext sc = new StyleContext();
	public static final DefaultStyledDocument documento= new DefaultStyledDocument(sc);
	public static final String[] escape={"\n","\t","\b"};
	public static Style h1_Format_BlackArialSize16Bold(){
		heading2Style = sc.addStyle("Heading2", null);
        heading2Style.addAttribute(StyleConstants.Foreground, Color.BLACK);
        heading2Style.addAttribute(StyleConstants.FontSize, new Integer(16));
        heading2Style.addAttribute(StyleConstants.FontFamily, "Arial");
        heading2Style.addAttribute(StyleConstants.Alignment, new Integer(3));
        /**
         ALIGN_LEFT 	(0)
		 ALIGN_RIGHT 	(1)
		 ALIGN_CENTER 	(2)
		 ALIGN_JUSTIFED (3)
         **/
        heading2Style.addAttribute(StyleConstants.Bold, new Boolean(true));
		return heading2Style;
	}
	public static Style h1_Format_BluekArialSize16Bold(){
		heading2Style = sc.addStyle("Heading2", null);
        heading2Style.addAttribute(StyleConstants.Foreground, Color.BLUE);
        heading2Style.addAttribute(StyleConstants.FontSize, new Integer(18));
        heading2Style.addAttribute(StyleConstants.FontFamily, "Arial");
        heading2Style.addAttribute(StyleConstants.Bold, new Boolean(true));
		return heading2Style;
	}
	public static Style p1_Format_BlackArialSize13(){
		heading2Style = sc.addStyle("Heading2", null);
        heading2Style.addAttribute(StyleConstants.Foreground, Color.black);
        heading2Style.addAttribute(StyleConstants.FontSize, new Integer(13));
        heading2Style.addAttribute(StyleConstants.FontFamily, "Calibri");
        heading2Style.addAttribute(StyleConstants.Alignment, new Integer(3));
//        heading2Style.addAttribute(StyleConstants.Bold, new Boolean(true));
		return heading2Style;
	}
	/*************************METODOS ESCAPE*****************************/
	public static String salto(int cant){
		return ejecucionComando(0,cant);
	}
	public static String tab(int cant){
		return ejecucionComando(1,cant);
	}
	public static String backspace(int cant){
		return ejecucionComando(2,cant);
	}
	public static String ejecucionComando(int comand,int cant){
		String cadena="";
		for(int i=0;i<cant;i++)
			cadena+=escape[comand];
		return cadena;
	}
}
