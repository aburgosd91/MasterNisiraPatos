package com.nisira.vista.controles;

import java.util.Calendar;

import javax.swing.ImageIcon;

import com.nisira.MainFrame;
import com.scrollabledesktop.BaseInternalFrame;

public class NSRInternalFrame extends BaseInternalFrame {
	
	public static final String EDICION = "EDICION";
	public static final String VISTA = "VISTA";
	public static final String NUEVO = "NUEVO";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NSRInternalFrame() {
		super();
		setFrameIcon(new ImageIcon(
				MainFrame.class.getResource("/resources/nisiralogo.png")));
	}
	
	public static String MostrarFecha(NSRDatePicker dpFecha,int tipo){
		int anio,mes,dia;
		Calendar fecha = Calendar.getInstance();
		if (dpFecha.getDate() == null) {
			anio = 0;
			mes = 0;
			dia = 0;
			return null;
		} else {
			fecha.setTime(dpFecha.getDate());
			anio = fecha.get(Calendar.YEAR);
			mes = fecha.get(Calendar.MONTH) + 1;
			dia = fecha.get(Calendar.DAY_OF_MONTH);
			String stringFecha="";
			switch(tipo){
				case 1:stringFecha=""+anio+"-"+(mes<10?"0"+mes:mes)+"-"+(dia<10?"0"+dia:dia)+"";break;/*ANIO-MES-DIA*/
				case 2:stringFecha=""+(dia<10?"0"+dia:dia)+"-"+(mes<10?"0"+mes:mes)+"-"+anio+"";break;/*DIA-MES-ANIO*/
			}
			return stringFecha;
		}
		
	}
}
