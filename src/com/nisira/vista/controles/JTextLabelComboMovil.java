package com.nisira.vista.controles;

import javax.swing.JPanel;

import com.nisira.entidad.CONFIGACTIVIDADES;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;

public class JTextLabelComboMovil  extends JPanel{
	String id;
	String value;
	int fieldSize;
	public int row;
	public JTextLabelComboMovil(CONFIGACTIVIDADES ca) {
		setSize(new Dimension(450, 25));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{20, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(450, 25));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(100);
		flowLayout.setAlignOnBaseline(true);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText(ca.getDESCRIPCION());
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Automatico", "Manual"}));
		comboBox.setSelectedIndex(ca.getTIPO());
		panel.add(comboBox);
	}

}
