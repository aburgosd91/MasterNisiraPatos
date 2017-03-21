package com.nisira.vista.formularios.movil;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;

import com.nisira.MainFrame;
import com.nisira.vista.barras.PanelBarraMaestro;
import com.nisira.vista.controles.NSRDatePicker;
import com.scrollabledesktop.BaseInternalFrame;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.SwingConstants;

public class FrmDialogMessage extends JDialog{
	private static final Font styleCell= new Font("Tahoma", Font.BOLD, 18);
	private static final int sizeIcon=64;
	private JLabel lblIconInformation;
	private JLabel lblInformation;
	public FrmDialogMessage(String message,int tipo) {
		super();
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(400, 220));
		setPreferredSize(new Dimension(400, 300));
		setIconImage((new ImageIcon(
				MainFrame.class.getResource("/resources/nisiralogo.png")).getImage()));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 120, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 105, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panelIcon = new JPanel();
		GridBagConstraints gbc_panelIcon = new GridBagConstraints();
		gbc_panelIcon.fill = GridBagConstraints.BOTH;
		gbc_panelIcon.insets = new Insets(0, 0, 5, 5);
		gbc_panelIcon.gridx = 1;
		gbc_panelIcon.gridy = 1;
		getContentPane().add(panelIcon, gbc_panelIcon);
		
		lblIconInformation = new JLabel("");
		lblIconInformation.setPreferredSize(new Dimension(sizeIcon, sizeIcon));
		this.setTitle("MENSAJE");
		/****************configuracion tipo*****************/
		switch (tipo) {
		case 1:/*INFORMATION*/
			lblIconInformation.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
					.getResource("/resources/alert_information.png")).getImage()
					.getScaledInstance(sizeIcon,sizeIcon, java.awt.Image.SCALE_DEFAULT)));
			
			break;
		case 2:/*QUESTION*/
			lblIconInformation.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
					.getResource("/resources/alert_question.png")).getImage()
					.getScaledInstance(sizeIcon,sizeIcon, java.awt.Image.SCALE_DEFAULT)));
			this.setTitle("Información");
			break;
		case 3:/*ERROR*/
			lblIconInformation.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
					.getResource("/resources/alert_error.png")).getImage()
					.getScaledInstance(sizeIcon,sizeIcon, java.awt.Image.SCALE_DEFAULT)));
			break;
		case 4:/*WARNING*/
			lblIconInformation.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
					.getResource("/resources/alert_warning.png")).getImage()
					.getScaledInstance(sizeIcon,sizeIcon, java.awt.Image.SCALE_DEFAULT)));
			break;
		default:
			lblIconInformation.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
					.getResource("/resources/alert.png")).getImage()
					.getScaledInstance(sizeIcon,sizeIcon, java.awt.Image.SCALE_DEFAULT)));
			break;
		}
		panelIcon.add(lblIconInformation);
		
		JPanel panelInformacion = new JPanel();
		GridBagConstraints gbc_panelInformacion = new GridBagConstraints();
		gbc_panelInformacion.insets = new Insets(0, 0, 5, 5);
		gbc_panelInformacion.fill = GridBagConstraints.BOTH;
		gbc_panelInformacion.gridx = 2;
		gbc_panelInformacion.gridy = 1;
		getContentPane().add(panelInformacion, gbc_panelInformacion);
		panelInformacion.setLayout(new BorderLayout(0, 0));
		
		lblInformation = new JLabel("Información");
		lblInformation.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInformation.setHorizontalAlignment(SwingConstants.LEFT);
		panelInformacion.add(lblInformation, BorderLayout.CENTER);
		lblInformation.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblInformation.setFont(styleCell);
		/*MENSAJE*/
		if(message!=null)
			if(!message.trim().equals(""))
				lblInformation.setText(message);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrar();
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 2;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		setLocationRelativeTo(null);
	}
	/*SOBRESCRIBIR*/
	public void cerrar(){
		
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
