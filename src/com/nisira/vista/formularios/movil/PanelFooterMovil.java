package com.nisira.vista.formularios.movil;

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

public class PanelFooterMovil extends JPanel{

	private static final long serialVersionUID = 1L;
	public JPanel panelFooter;
	private JLabel lblEstado;
	private AbstractWindowsMovil formMaestro;
	public PanelFooterMovil(String descripcion,AbstractWindowsMovil formMaestro) {
		super();
		/*CABECERA*/
		this.formMaestro=formMaestro;
		setPreferredSize(new Dimension(450, 18));
		/*************** DESIGN ***************/
		setSize(new Dimension(450, 18));
		setMinimumSize(new Dimension(450, 18));
		setLayout(new BorderLayout(0, 0));
		
		panelFooter = new JPanel();
		panelFooter.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.add(panelFooter);
		panelFooter.setLayout(new BorderLayout(0, 0));
		
		lblEstado = new JLabel("..::: Estado :::..");
		panelFooter.add(lblEstado);
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
