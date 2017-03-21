package core.inicio;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.nisira.core.Conexion;
import com.nisira.core.EConexion;

public class ConectionManager {

	public static boolean isConexionOK(EConexion cfgInicio, JFrame frame) {

		Conexion con = new Conexion();
		Connection cnn = null;
		try {
			cnn = con.obtenerConexion(cfgInicio);
			if (!cnn.isClosed()) {
				cnn.close();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Error al conectar con el servidor");
			JOptionPane.showMessageDialog(frame, e.getMessage());
			return false;
		} finally {
			try {
				if (!cnn.isClosed()) {
					cnn.close();
				}
			} catch (SQLException e) {
			}
		}

		return true;
	}

}
