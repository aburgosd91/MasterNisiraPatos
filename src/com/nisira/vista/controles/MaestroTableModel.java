package com.nisira.vista.controles;

import java.lang.reflect.Field;

import javax.swing.table.DefaultTableModel;

public class MaestroTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public MaestroTableModel() {
		addColumn("Código");
		addColumn("Descripción");
	}
	public MaestroTableModel(Field[] f){
		for (Field field : f) {
			addColumn(field.getName());
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public void limpiar() {
		while (getRowCount() != 0) {
			removeRow(0);
		}
	}
}