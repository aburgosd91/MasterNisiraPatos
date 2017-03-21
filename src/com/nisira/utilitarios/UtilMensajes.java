package com.nisira.utilitarios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.nisira.Inicio;


public class UtilMensajes {
	private static String titulo = "NISIRA EDoc";

	public static String getMensaje(String mensaje) {
		try {
			return Inicio.mensajes.getProperty(mensaje);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Los Mensajes no cargaron correctamente, comunique con al Administrador del Sistema!", titulo,
					JOptionPane.ERROR_MESSAGE);
			return "";
		}
	}

	public static void mensaje_error(String mensaje) {

		JOptionPane.showMessageDialog(null, getMensaje(mensaje), titulo, JOptionPane.ERROR_MESSAGE);
	}

	public static void logMensajeError(String mensaje, Exception e) {
		DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String convertido = fechaHora.format(new Date());

		String rpta = getMensaje(mensaje);
		rpta = rpta.concat(" ").concat(e.getMessage()).concat(" (").concat(convertido).concat(")");
		JOptionPane.showMessageDialog(null, rpta, titulo, JOptionPane.ERROR_MESSAGE);
		
		Inicio.LOGGER.debug("ERROR", e);
	}

	public static String getFormated(String mensaje, String... params) {
		Object[] a_params = params;
		String msj = "";
		try {
			msj = Inicio.mensajes.getProperty(mensaje);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Los Mensajes no cargaron correctamente, comunique con al Administrador del Sistema!", titulo,
					JOptionPane.ERROR_MESSAGE);
			msj = "";
		}

		return String.format(msj, a_params);
	}

	public static void mensaje_error(String mensaje, String... params) {
		String grandTotal = getFormated(mensaje, params);
		JOptionPane.showMessageDialog(null, grandTotal, titulo, JOptionPane.ERROR_MESSAGE);
	}

	public static void mensaje_alterta(String mensaje) {
		JOptionPane.showMessageDialog(null, getMensaje(mensaje), titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void mensaje_alterta(JFrame frame, String mensaje) {
		JOptionPane.showMessageDialog(frame, getMensaje(mensaje), titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void mensaje_alterta(String mensaje, String... params) {
		String grandTotal = getFormated(mensaje, params);
		JOptionPane.showMessageDialog(null, grandTotal, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public static int mensaje_sino(String mensaje) {
		int seleccion = JOptionPane.showOptionDialog(null, getMensaje(mensaje), titulo, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No" }, "Si");

		return seleccion;
	}

	public static int mensaje_sino(String mensaje, String... params) {
		String grandTotal = getFormated(mensaje, params);

		int seleccion = JOptionPane.showOptionDialog(null, grandTotal, titulo, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No" }, "Si");

		return seleccion;
	}

	public static int msj_error(String mensaje) {
		int seleccion = JOptionPane.showOptionDialog(null, getMensaje(mensaje), titulo, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No" }, "Si");

		return seleccion;
	}
}
