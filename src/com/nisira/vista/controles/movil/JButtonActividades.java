package com.nisira.vista.controles.movil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.nisira.entidad.ACTIVIDADES;
import com.nisira.vista.barras.PanelBarraMaestro;

public abstract class JButtonActividades extends JButton implements ActionListener{
	private ACTIVIDADES actividades;
	public JButtonActividades(ACTIVIDADES actividades,int _ancho,int _alto){
		super();
		this.actividades=actividades;
		setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/"+actividades.getICONO())).getImage()
				.getScaledInstance(_ancho, _alto, java.awt.Image.SCALE_DEFAULT)));
		addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		actionMethod_(actividades);
	}
	public abstract void actionMethod_(ACTIVIDADES actividades);
}
