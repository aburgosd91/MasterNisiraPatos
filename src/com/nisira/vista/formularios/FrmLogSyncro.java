package com.nisira.vista.formularios;

import com.scrollabledesktop.BaseInternalFrame;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.Dimension;
import java.awt.BorderLayout;

public class FrmLogSyncro extends BaseInternalFrame {
	public FrmLogSyncro(String Log) {
		setMinimumSize(new Dimension(300, 300));
		setPreferredSize(new Dimension(300, 300));
		setSize(new Dimension(484, 288));
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setVisible(true);
		setResizable(true);
		setName("FrmLogSyncro");
		setTitle("Log");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scroll);
		textArea.setText(Log);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
