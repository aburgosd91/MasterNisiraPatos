package com.nisira.vista.utilitarios;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import com.nisira.utilitarios.UtilMensajes;
import com.nisira.vista.contenedores.AbstractCntBuscar;


public class FormValidador {
	public static void TextFieldsEdicion(boolean band, JTextField... texts) {
		for (JTextField text : texts) {
			text.setEditable(band);
		}
	}
	
	public static void ChekBoxFieldsEdicion(boolean band, JCheckBox... texts) {
		for (JCheckBox text : texts) {
			text.setEnabled(band);
		}
	}
	

	public static boolean TextFieldObligatorios(JTextField... texts) {
		for (JTextField text : texts) {
			if (text.getText().trim().isEmpty()) {
				UtilMensajes.mensaje_alterta("DATO_REQUERIDO", text.getName());
				text.requestFocus();
				return false;
			}
		}
		return true;
	}

	public static void CntEdicion(boolean band, AbstractCntBuscar<?>... cnts) {
		for (AbstractCntBuscar<?> cnt : cnts) {
			cnt.setEditable(band);
		}
	}
	
	public static boolean CntObligatorios(AbstractCntBuscar<?>... cnts) {
		for (AbstractCntBuscar<?> cnt : cnts) {
			if (cnt.getSeleccionado() == null) {
				UtilMensajes.mensaje_alterta("DATO_REQUERIDO", cnt.getCntName());
				cnt.txtCodigo.requestFocus();
				return false;
			}
		}
		return true;
	}
}
