package com.nisira.vista.controles;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class NSRComboBox extends JComboBox<String[]> {

	private static final long serialVersionUID = 1L;

	private int posDescripcion;
	private int posID;
	private boolean layingOut = false;

	@SuppressWarnings("unchecked")
	public NSRComboBox(List<String[]> content, int posID, int posDescripcion) {
		super(new ArrayListComboBoxModel(content));
		this.posDescripcion = posDescripcion;
		this.posID = posID;
		setRenderer(new BasicComboBoxRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getListCellRendererComponent(@SuppressWarnings("rawtypes") JList list, Object value,
					int index, boolean isSelected, boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value != null) {
					String[] item = (String[]) value;
					setText(item[NSRComboBox.this.posDescripcion]);
					return this;
				}
				setText("Seleccione Uno");
				return this;
			}
		});
	}

	public void setListContent(List<String[]> lista) {
		setModel(new ArrayListComboBoxModel(lista));
	}

	public String getSelectedID() {

		Object r = getSelectedItem();

		if (r == null) {
			return null;
		} else {
			String[] sr = (String[]) r;
			return sr[posID];
		}
	}

	@Override
	public Dimension getSize() {
		Dimension dim = super.getSize();
		if (!layingOut)
			dim.width = Math.max(dim.width, getPreferredSize().width);
		return dim;
	}

	@Override
	public void doLayout() {
		try {
			layingOut = true;
			super.doLayout();
		} finally {
			layingOut = false;
		}
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame("ArrayListComboBoxModel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		List<String[]> lista = new ArrayList<>();

		lista.add(new String[] { "01", "aesc" });

		lista.add(new String[] { "02", "Desc2" });

		lista.add(new String[] { "03", "zesc3 zesc3 zesc3 zesc3zesc3 zesc3 zesc3 zesc3 zesc3zesc3zesc3 zesc3" });

		NSRComboBox comboBox = new NSRComboBox(lista, 0, 1);

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, comboBox.getSelectedID());
			}
		});

		Container contentPane = frame.getContentPane();
		contentPane.add(comboBox, BorderLayout.NORTH);
		frame.setSize(300, 225);
		frame.setVisible(true);
	}

}