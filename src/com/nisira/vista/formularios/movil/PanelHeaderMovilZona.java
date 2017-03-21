package com.nisira.vista.formularios.movil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JWindow;
import javax.swing.border.EtchedBorder;

import com.nisira.core.NisiraORMException;
import com.nisira.dao.ACTIVIDADESDao;
import com.nisira.entidad.ACTIVIDADES;
import com.nisira.vista.barras.PanelBarraMaestro;
import com.nisira.vista.controles.JTextLabelPanel;
import com.nisira.vista.controles.movil.JButtonActividades;
import com.nisira.vista.formularios.AbstractFrmWindowMovil;
import com.nisira.vista.formularios.maestros.AbstractMaestro;

public abstract class PanelHeaderMovilZona extends JPanel{
	private static final long serialVersionUID = 1L;
	public List<JTextLabelPanel> listField;
	public JPanel panelHeader;
	private JPanel panelBotones;
	private static final int _ancho = 48;
	private static final int _alto = 48;
	public PanelHeaderMovilZona(List<ACTIVIDADES> listaACTIVIDADES,int width,int height) {
		super();
		/*CABECERA*/
		setPreferredSize(new Dimension(width, height));
		listField=new ArrayList<JTextLabelPanel>() ;
		/*************** DESIGN ***************/
		setSize(new Dimension(width, height));
		setMinimumSize(new Dimension(width, height));
		setLayout(new BorderLayout(0, 0));
		
		panelHeader = new JPanel();
		panelHeader.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelHeader.setBackground(new Color(171, 196, 223));
		this.add(panelHeader);
		panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.Y_AXIS));
		
		panelBotones = new JPanel();
		panelBotones.setBorder(null);
		panelBotones.setBackground(new Color(171, 196, 223));
		/* BOTONES POR ACTIVIDADES */
		JButtonActividades btnObj;
		for(ACTIVIDADES actividades:listaACTIVIDADES){
			btnObj = new JButtonActividades(actividades, _ancho, _alto){
				@Override
				public void actionMethod_(ACTIVIDADES actividades) {
					// TODO Auto-generated method stub
					actionMethod(actividades);
				}
			};
			panelBotones.add(btnObj);
		}
		panelHeader.add(panelBotones);
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		try {
//			List<ACTIVIDADES> listACTIVIDADES =(new ACTIVIDADESDao()).listar(1);
//			JFrame windows = new JFrame();
//			windows.setPreferredSize(new Dimension(500, 500));
//			PanelHeaderMovilZona panelbtn= new PanelHeaderMovilZona(listACTIVIDADES, 300, 200);
//			windows.add(panelbtn);
//			windows.show();
//		} catch (NisiraORMException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	public abstract void actionMethod(ACTIVIDADES actividades);	
}
