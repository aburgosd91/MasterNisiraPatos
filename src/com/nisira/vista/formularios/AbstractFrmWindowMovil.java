package com.nisira.vista.formularios;

import javax.swing.JWindow;

import org.jdesktop.swingx.border.DropShadowBorder;

import com.nisira.vista.barras.PanelBarraMaestro;
import com.nisira.vista.controles.JTextFieldMovil;
import com.nisira.vista.controles.JTextLabelPanel;
import com.sun.xml.internal.ws.Closeable;

import sun.awt.WindowClosingListener;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EtchedBorder;

public abstract class AbstractFrmWindowMovil extends JWindow{

	private static final long serialVersionUID = 1L;
	public List<JTextLabelPanel> listField;
	/*PARAMETROS DE DISEÑO*/
	JButton btnReset;
	JButton btnGuardar;
	JButton btnCancelar;
	public JScrollPane panelBodyScroll;
	public JPanel panelHeader;
	public JPanel panelBody;
	public JPanel panelFooter;
	private JPanel panelBotones;
	private JPanel panelTitulo;
	private JLabel lblCabecera;
	private JLabel lblEstado;
	private JLabel lblIcon;
	public AbstractFrmWindowMovil(Window mainWindow,String title) {
		super(mainWindow);
		setPreferredSize(new Dimension(450, 290));
		setAutoRequestFocus(false);
		listField=new ArrayList<JTextLabelPanel>() ;
		/*************** DESIGN ***************/
		setSize(new Dimension(450, 270));
		setMinimumSize(new Dimension(450, 290));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{93, 176, 16, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		panelHeader = new JPanel();
		panelHeader.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelHeader.setBackground(new Color(171, 196, 223));
		GridBagConstraints gbc_panelHeader = new GridBagConstraints();
		gbc_panelHeader.fill = GridBagConstraints.BOTH;
		gbc_panelHeader.insets = new Insets(0, 0, 5, 0);
		gbc_panelHeader.gridx = 0;
		gbc_panelHeader.gridy = 0;
		getContentPane().add(panelHeader, gbc_panelHeader);
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
		
		lblCabecera = new JLabel("Operación Manual : ..:: "+title+" ::.");
		GridBagConstraints gbc_lblCabecera = new GridBagConstraints();
		gbc_lblCabecera.fill = GridBagConstraints.BOTH;
		gbc_lblCabecera.gridx = 1;
		gbc_lblCabecera.gridy = 0;
		panelTitulo.add(lblCabecera, gbc_lblCabecera);
		
		panelBotones = new JPanel();
		panelBotones.setBorder(null);
		panelBotones.setBackground(new Color(171, 196, 223));
		panelHeader.add(panelBotones);
		
		btnReset = new JButton("");
		panelBotones.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setToolTipText("Reset");
		btnReset.setIcon(new ImageIcon(AbstractFrmWindowMovil.class.getResource("/resources/return1.png")));
		
		
		btnGuardar = new JButton("");
		panelBotones.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnGuardar.setToolTipText("Save");
		btnGuardar.setIcon(new ImageIcon(AbstractFrmWindowMovil.class.getResource("/resources/grabar.png")));
		
		btnCancelar = new JButton("");
		panelBotones.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		btnCancelar.setToolTipText("Cancel");
		btnCancelar.setIcon(new ImageIcon(AbstractFrmWindowMovil.class.getResource("/resources/close.png")));
		
		panelBodyScroll = new JScrollPane();
		panelBodyScroll.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelBodyScroll.setAlignmentY(Component.TOP_ALIGNMENT);
		GridBagConstraints gbc_panelBodyScroll = new GridBagConstraints();
		gbc_panelBodyScroll.fill = GridBagConstraints.BOTH;
		gbc_panelBodyScroll.insets = new Insets(0, 0, 5, 0);
		gbc_panelBodyScroll.gridx = 0;
		gbc_panelBodyScroll.gridy = 1;
		getContentPane().add(panelBodyScroll, gbc_panelBodyScroll);
		
		panelBody = new JPanel();
		panelBody.setAlignmentY(Component.TOP_ALIGNMENT);
		panelBodyScroll.setViewportView(panelBody);
		panelBody.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelFooter = new JPanel();
		panelFooter.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panelFooter = new GridBagConstraints();
		gbc_panelFooter.fill = GridBagConstraints.BOTH;
		gbc_panelFooter.gridx = 0;
		gbc_panelFooter.gridy = 2;
		getContentPane().add(panelFooter, gbc_panelFooter);
		panelFooter.setLayout(new BorderLayout(0, 0));
		
		lblEstado = new JLabel("..::: Estado :::..");
		panelFooter.add(lblEstado);
	}
	public abstract void save();
	public abstract void reset();
	public abstract void cancel();
	public void cargarRow(){
		if(listField!=null){
//			panelBody.removeAll();
			for(JTextLabelPanel obj:listField){
				panelBody.add(obj);
			}
			listField.get(0).textField.requestFocus();
//			panelBody.repaint();
//			panelBodyScroll.repaint();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
