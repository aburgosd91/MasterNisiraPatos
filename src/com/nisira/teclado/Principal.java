package com.nisira.teclado;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Principal extends JFrame{

	JTextField txtusu=new JTextField(10);
	JPasswordField txtclave=new JPasswordField(10);
	JPopupMenu pop;
	JKeyboardPane teclado;
	
	public Principal(){
		
		colocarSkin();
		
		JPanel pafuera=new JPanel();
		pafuera.setPreferredSize(new Dimension(200,30));
		getContentPane().add(pafuera);
		GridBagLayout gbl_pafuera = new GridBagLayout();
		gbl_pafuera.columnWidths = new int[]{85, 43, 135, 34, 86, 0};
		gbl_pafuera.rowHeights = new int[]{20, 0, 0, 0, 0};
		gbl_pafuera.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pafuera.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pafuera.setLayout(gbl_pafuera);
		JLabel label = new JLabel("Usuario: ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		pafuera.add(label, gbc_label);
		GridBagConstraints gbc_txtusu = new GridBagConstraints();
		gbc_txtusu.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtusu.insets = new Insets(0, 0, 5, 5);
		gbc_txtusu.gridx = 2;
		gbc_txtusu.gridy = 1;
		txtusu.setPreferredSize(new Dimension(100, 20));
		pafuera.add(txtusu, gbc_txtusu);
		JLabel label_1 = new JLabel("Clave: ");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 3;
		pafuera.add(label_1, gbc_label_1);
		GridBagConstraints gbc_txtclave = new GridBagConstraints();
		gbc_txtclave.insets = new Insets(0, 0, 0, 5);
		gbc_txtclave.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtclave.gridx = 2;
		gbc_txtclave.gridy = 3;
		pafuera.add(txtclave, gbc_txtclave);
		
		txtclave.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				pop = new JPopupMenu();
				teclado=new JKeyboardPane(txtclave,pop);
				pop.add(teclado);
				pop.setVisible(true);
				pop.setLocation(txtclave.getLocationOnScreen().x+112, txtclave.getLocationOnScreen().y-1);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				pop.setVisible(false);
			}
			
		});
		txtusu.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				pop = new JPopupMenu();
				teclado=new JKeyboardPane(txtusu,pop);
				pop.add(teclado);
				pop.setVisible(true);
				pop.setLocation(txtclave.getLocationOnScreen().x+112, txtclave.getLocationOnScreen().y-1);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				pop.setVisible(false);
			}
			
		});
		
	}
	
	public void colocarSkin(){
		try {
			 UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException e) {
			 e.printStackTrace();
			} catch (InstantiationException e) {
			 e.printStackTrace();
			} catch (IllegalAccessException e) {
			 e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
			 e.printStackTrace();
			}
	}
	
	public static void main(String arg[]){
		Principal p=new Principal();
		p.setVisible(true);
		p.setBounds(0, 0, 300, 200);
		p.setLocationRelativeTo(null);
		p.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
