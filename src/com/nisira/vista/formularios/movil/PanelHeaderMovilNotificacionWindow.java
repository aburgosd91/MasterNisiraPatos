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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JWindow;
import javax.swing.border.EtchedBorder;

import com.nisira.vista.barras.PanelBarraMaestro;
import com.nisira.vista.controles.JTextLabelPanel;
import com.nisira.vista.formularios.AbstractFrmWindowMovil;
import com.nisira.vista.formularios.maestros.AbstractMaestro;

public class PanelHeaderMovilNotificacionWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	public List<JTextLabelPanel> listField;
	/*PARAMETROS DE DISEÑO*/
	JButton btnStart;
	JButton btnActualizar;
	JButton btnCancelar;
	public JPanel panelHeader;
	private JPanel panelBotones;
	private JPanel panelTitulo;
	private JLabel lblCabecera;
	private JLabel lblIcon;
	private static final int _ancho = 48;
	private static final int _alto = 48;
	private AbstractWindowsMovil formMaestro;
	public PanelHeaderMovilNotificacionWindow(String title) {
		super();
		setPreferredSize(new Dimension(450, 94));
		listField=new ArrayList<JTextLabelPanel>() ;
		/*************** DESIGN ***************/
		setSize(new Dimension(450, 94));
		setMinimumSize(new Dimension(450, 94));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{93, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
		panelHeader = new JPanel();
		panelHeader.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelHeader.setBackground(new Color(171, 196, 223));
		GridBagConstraints gbc_panelHeader = new GridBagConstraints();
		gbc_panelHeader.fill = GridBagConstraints.BOTH;
		gbc_panelHeader.gridx = 0;
		gbc_panelHeader.gridy = 0;
		this.add(panelHeader, gbc_panelHeader);
		panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.Y_AXIS));
		
		panelTitulo = new JPanel();
		panelHeader.add(panelTitulo);
		GridBagLayout gbl_panelTitulo = new GridBagLayout();
		gbl_panelTitulo.columnWidths = new int[]{25, 419, 0};
		gbl_panelTitulo.rowHeights = new int[]{13, 0};
		gbl_panelTitulo.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelTitulo.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTitulo.setLayout(gbl_panelTitulo);
		
		lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/nisiralogo.png")).getImage()
				.getScaledInstance(16,16, java.awt.Image.SCALE_DEFAULT)));
		GridBagConstraints gbc_lblIcon = new GridBagConstraints();
		gbc_lblIcon.fill = GridBagConstraints.BOTH;
		gbc_lblIcon.insets = new Insets(0, 0, 0, 5);
		gbc_lblIcon.gridx = 0;
		gbc_lblIcon.gridy = 0;
		panelTitulo.add(lblIcon, gbc_lblIcon);
		
		lblCabecera = new JLabel("Formulario : ..:: <dynamic> ::.");
		GridBagConstraints gbc_lblCabecera = new GridBagConstraints();
		gbc_lblCabecera.fill = GridBagConstraints.BOTH;
		gbc_lblCabecera.gridx = 1;
		gbc_lblCabecera.gridy = 0;
		panelTitulo.add(lblCabecera, gbc_lblCabecera);
		
		panelBotones = new JPanel();
		panelBotones.setBorder(null);
		panelBotones.setBackground(new Color(171, 196, 223));
		panelHeader.add(panelBotones);
		
		btnStart = new JButton("");
		panelBotones.add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formMaestro.ejecutar();
			}
		});
		btnStart.setToolTipText("Ejecutar");
		btnStart.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/start.png")).getImage()
				.getScaledInstance(_ancho,_alto, java.awt.Image.SCALE_DEFAULT)));
		
		btnActualizar = new JButton("");
		panelBotones.add(btnActualizar);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formMaestro.actualizar();
			}
		});
		btnActualizar.setToolTipText("Save");
		btnActualizar.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/actualizar.png")).getImage()
				.getScaledInstance(_ancho,_alto, java.awt.Image.SCALE_DEFAULT)));
		
		btnCancelar = new JButton("");
		panelBotones.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formMaestro.salir();
			}
		});
		btnCancelar.setToolTipText("Cancel");
		btnCancelar.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/close.png")).getImage()
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
