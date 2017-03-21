package controlador;

import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.nisira.vista.barras.PanelBarraMaestro;

public class MensajesDialog {
	private static final Font styleCell= new Font("Tahoma", Font.BOLD, 18);
	private static final int sizeIcon=64;
	public static void mostrarMensaje(Component obj,String message, int tipo){
		switch (tipo) {
		case 1:/*INFORMATION*/
			JOptionPane.showMessageDialog(
					obj,
					message, //Mensaje
					"INFORMACIÓN", //Título
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(new ImageIcon(PanelBarraMaestro.class
							.getResource("/resources/alert_information.png")).getImage()
							.getScaledInstance(sizeIcon,sizeIcon, java.awt.Image.SCALE_DEFAULT))); //Tipo de mensaje
			break;
		case 2:/*QUESTION*/
			JOptionPane.showMessageDialog(
					obj,
					message, //Mensaje
					"INFORMACIÓN", //Título
					JOptionPane.QUESTION_MESSAGE,
					new ImageIcon(new ImageIcon(PanelBarraMaestro.class
							.getResource("/resources/alert_question.png")).getImage()
							.getScaledInstance(sizeIcon,sizeIcon, java.awt.Image.SCALE_DEFAULT))); //Tipo de mensaje
			break;
		case 3:/*ERROR*/
			JOptionPane.showMessageDialog(
					obj,
					message, //Mensaje
					"INFORMACIÓN", //Título
					JOptionPane.ERROR_MESSAGE,
					new ImageIcon(new ImageIcon(PanelBarraMaestro.class
							.getResource("/resources/alert_error.png")).getImage()
							.getScaledInstance(sizeIcon,sizeIcon, java.awt.Image.SCALE_DEFAULT)));
			break;
		case 4:/*WARNING*/
			JOptionPane.showMessageDialog(
					obj,
					message, //Mensaje
					"INFORMACIÓN", //Título
					JOptionPane.WARNING_MESSAGE,
					new ImageIcon(new ImageIcon(PanelBarraMaestro.class
							.getResource("/resources/alert_warning.png")).getImage()
							.getScaledInstance(sizeIcon,sizeIcon, java.awt.Image.SCALE_DEFAULT)));
			break;
		default:
			JOptionPane.showMessageDialog(
					obj,
					message, //Mensaje
					"INFORMACIÓN", //Título
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(new ImageIcon(PanelBarraMaestro.class
							.getResource("/resources/alert_information.png")).getImage()
							.getScaledInstance(sizeIcon,sizeIcon, java.awt.Image.SCALE_DEFAULT)));
			break;
		}
	}
}
