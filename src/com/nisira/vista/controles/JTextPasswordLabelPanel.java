package com.nisira.vista.controles;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

import com.nisira.vista.barras.PanelBarraMaestro;
import java.awt.SystemColor;

public class JTextPasswordLabelPanel extends JPanel{
	public String id;
	public String descripcion;
	public String value;
	int fieldSize;
	public int row;
	public JLabel label;
	public JTextFieldPasswordMovil textField;
	public JTextPasswordLabelPanel(int row,String id,String descripcion,String value,int fieldSize){
		super();
		setPreferredSize(new Dimension(393, 36));
		setAlignmentY(Component.TOP_ALIGNMENT);
		setBackground(new Color(240,240,240));
		/*****************************************************/
		this.row=row;
		this.fieldSize=fieldSize;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 236, 36, 0};
		gridBagLayout.rowHeights = new int[]{32, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setLabel(new JLabel(descripcion));
		getLabel().setFont(new Font("Tahoma", Font.BOLD, 12));
		getLabel().setHorizontalAlignment(SwingConstants.CENTER);
		getLabel().setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_label.fill = GridBagConstraints.HORIZONTAL;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(getLabel(), gbc_label);
		textField = new JTextFieldPasswordMovil(){
			@Override
			public void ordenfocus(){
				ordenfocusPanel();
			}
		};
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
//		textField.setText(id);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		
		JButton btnTeclado = new JButton("");
		btnTeclado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.methodKeyboard();
				textField.requestFocus();
			}
		});
		btnTeclado.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnTeclado.setSize(new Dimension(20, 20));
		btnTeclado.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/keyboard.png")).getImage()
				.getScaledInstance(16,16, java.awt.Image.SCALE_DEFAULT)));
		
		GridBagConstraints gbc_btnTeclado = new GridBagConstraints();
		gbc_btnTeclado.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_btnTeclado.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTeclado.gridx = 2;
		gbc_btnTeclado.gridy = 0;
		add(btnTeclado, gbc_btnTeclado);
		textField.requestFocus();
//		repaint();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
	public void ordenfocusPanel(){}
}
