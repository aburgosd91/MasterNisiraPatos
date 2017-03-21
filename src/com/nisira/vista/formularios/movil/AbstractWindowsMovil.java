package com.nisira.vista.formularios.movil;

import java.awt.Window;
import java.util.Calendar;

import javax.swing.JWindow;

import com.nisira.MainFrame;
import com.nisira.vista.controles.NSRDatePicker;
import com.scrollabledesktop.BaseInternalFrame;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public abstract class AbstractWindowsMovil extends BaseInternalFrame {
	private PanelHeaderMovilNotificacion panelHeaderMovilNotificacion;
	private PanelFooterMovil panelFooterMovil;
	private JPanel panelDataTable;
	public AbstractWindowsMovil(String title) {
		super();
		setFrameIcon(new ImageIcon(
				MainFrame.class.getResource("/resources/nisiralogo.png")));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{28, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		panelHeaderMovilNotificacion = new PanelHeaderMovilNotificacion((String) null,this);
		GridBagConstraints gbc_panelHeaderMovilNotificacion = new GridBagConstraints();
		gbc_panelHeaderMovilNotificacion.anchor = GridBagConstraints.NORTH;
		gbc_panelHeaderMovilNotificacion.insets = new Insets(0, 0, 5, 0);
		gbc_panelHeaderMovilNotificacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelHeaderMovilNotificacion.gridx = 0;
		gbc_panelHeaderMovilNotificacion.gridy = 0;
		getContentPane().add(panelHeaderMovilNotificacion, gbc_panelHeaderMovilNotificacion);
		
		setPanelDataTable(new JPanel());
		GridBagConstraints gbc_panelDataTable = new GridBagConstraints();
		gbc_panelDataTable.insets = new Insets(0, 0, 5, 0);
		gbc_panelDataTable.fill = GridBagConstraints.BOTH;
		gbc_panelDataTable.gridx = 0;
		gbc_panelDataTable.gridy = 1;
		getContentPane().add(getPanelDataTable(), gbc_panelDataTable);
		panelDataTable.setLayout(new BorderLayout(0, 0));
		
		panelFooterMovil = new PanelFooterMovil((String) null,this);
		GridBagConstraints gbc_panelFooterMovil = new GridBagConstraints();
		gbc_panelFooterMovil.anchor = GridBagConstraints.SOUTH;
		gbc_panelFooterMovil.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelFooterMovil.gridx = 0;
		gbc_panelFooterMovil.gridy = 2;
		getContentPane().add(panelFooterMovil, gbc_panelFooterMovil);
		
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

	public PanelHeaderMovilNotificacion getPanelHeaderMovilNotificacion() {
		return panelHeaderMovilNotificacion;
	}
	public void setPanelHeaderMovilNotificacion(PanelHeaderMovilNotificacion panelHeaderMovilNotificacion) {
		this.panelHeaderMovilNotificacion = panelHeaderMovilNotificacion;
	}
	public PanelFooterMovil getPanelFooterMovil() {
		return panelFooterMovil;
	}
	public void setPanelFooterMovil(PanelFooterMovil panelFooterMovil) {
		this.panelFooterMovil = panelFooterMovil;
	}
	public abstract void ejecutar();
	public abstract void actualizar();
	public abstract void salir();
	public abstract void detener();
	public abstract void maximizar();
	public JPanel getPanelDataTable() {
		return panelDataTable;
	}
	public void setPanelDataTable(JPanel panelDataTable) {
		this.panelDataTable = panelDataTable;
	}
}
