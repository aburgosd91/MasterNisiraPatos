package com.nisira.vista.formularios.movil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JWindow;
import javax.swing.border.EtchedBorder;

import com.nisira.vista.barras.PanelBarraMaestro;
import com.nisira.vista.controles.JTextLabelPanel;
import com.nisira.vista.formularios.AbstractFrmWindowMovil;
import com.nisira.vista.formularios.maestros.AbstractMaestro;
import java.awt.SystemColor;

public class PanelHeaderMovilNotificacion extends JPanel{
	private static final long serialVersionUID = 1L;
	public List<JTextLabelPanel> listField;
	/*PARAMETROS DE DISEÑO*/
	JButton btnStart;
	JButton btnActualizar;
	JButton btnCancelar;
	public JPanel panelHeader;
	private JPanel panelBotones;
	private static final int _ancho = 48;
	private static final int _alto = 48;
	private AbstractWindowsMovil formMaestro;
	private JButton btnStop;
	private JButton btnMax;
	public PanelHeaderMovilNotificacion(String title,AbstractWindowsMovil formMaestro) {
		super();
		/*CABECERA*/
		this.formMaestro=formMaestro;
		setPreferredSize(new Dimension(450, 70));
		listField=new ArrayList<JTextLabelPanel>() ;
		/*************** DESIGN ***************/
		setSize(new Dimension(450, 70));
		setMinimumSize(new Dimension(450, 70));
		setLayout(new BorderLayout(0, 0));
		
		panelHeader = new JPanel();
		panelHeader.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelHeader.setBackground(new Color(171, 196, 223));
		this.add(panelHeader);
		panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.Y_AXIS));
		
		panelBotones = new JPanel();
		panelBotones.setBorder(null);
		panelBotones.setBackground(new Color(171, 196, 223));
		panelHeader.add(panelBotones);
		
		btnStart = new JButton("");
		btnStart.setBackground(SystemColor.controlDkShadow);
		btnStart.setContentAreaFilled(false);
		btnStart.setOpaque(true);
		panelBotones.add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formMaestro.ejecutar();
			}
		});
		btnStart.setToolTipText("Ejecutar");
		
		btnStart.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/ic_play_arrow_white_48dp_1x.png")).getImage()
				.getScaledInstance(_ancho,_alto, java.awt.Image.SCALE_DEFAULT)));
		
		btnStop = new JButton("");
		btnStop.setToolTipText("Detener");
		btnStop.setContentAreaFilled(false);
		btnStop.setOpaque(true);
		btnStop.setBackground(SystemColor.controlDkShadow);
		panelBotones.add(btnStop);
		btnStop.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/ic_stop_white_48dp_1x.png")).getImage()
				.getScaledInstance(_ancho,_alto, java.awt.Image.SCALE_DEFAULT)));
		btnStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				formMaestro.detener();
			}
		});
		
		btnActualizar = new JButton("");
		btnActualizar.setBackground(SystemColor.controlDkShadow);
		panelBotones.add(btnActualizar);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				formMaestro.actualizar();
			}
		});
		btnActualizar.setToolTipText("Save");
		btnActualizar.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/ic_refresh_white_48dp_1x.png")).getImage()
				.getScaledInstance(_ancho,_alto, java.awt.Image.SCALE_DEFAULT)));
		btnActualizar.setContentAreaFilled(false);
		btnActualizar.setOpaque(true);
		
		btnMax = new JButton("");
		btnMax.setToolTipText("Maximizar");
		btnMax.setContentAreaFilled(false);
		btnMax.setOpaque(true);
		btnMax.setBackground(SystemColor.controlDkShadow);
		btnMax.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/ic_zoom_out_map_white_48dp_1x.png")).getImage()
				.getScaledInstance(_ancho,_alto, java.awt.Image.SCALE_DEFAULT)));
		btnMax.addActionListener(new  ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				formMaestro.maximizar();
			}
		});
		panelBotones.add(btnMax);
		
		btnCancelar = new JButton("");
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setOpaque(true);
		panelBotones.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formMaestro.salir();
			}
		});
		btnCancelar.setBackground(SystemColor.controlDkShadow);
		btnCancelar.setToolTipText("Cancel");
		btnCancelar.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/ic_close_white_48dp_1x.png")).getImage()
				.getScaledInstance(_ancho,_alto, java.awt.Image.SCALE_DEFAULT)));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public AbstractWindowsMovil getFormMaestro() {
		return formMaestro;
	}
	public void setFormMaestro(AbstractWindowsMovil formMaestro) {
		this.formMaestro = formMaestro;
	}
}
