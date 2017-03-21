package core.inicio;

import static com.nisira.security.Encryption.decrypt;
import static com.nisira.security.Encryption.encrypt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.nisira.Inicio;
import com.nisira.core.EConexion;

public class ConfigInicial {

	public static String cfg_servidor;
	public static String cfg_basedatos;
	public static String cfg_urlsincro;
	public static String cfg_usuario;
	public static String cfg_clave;
	public static String cfg_tiposincro;

	public static String[] LlenarConfig() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");

			prop.load(input);

			String servidor = prop.getProperty("Servidor", "");							/*0*/
			String baseDatos = prop.getProperty("BaseDatos", "");						/*1*/
			String clave = prop.getProperty("Clave", "");								/*2*/
			String usuario = prop.getProperty("Usuario", "");							/*3*/
			String gestor = prop.getProperty("SGBD", "");								/*4*/
			String instancia = prop.getProperty("Instancia", "");						/*5*/
			String urlsincro = prop.getProperty("Urlsincro", "");						/*6*/
			String tiposincro = prop.getProperty("Tiposincro", "").trim();				/*7*/
			String idempresa = prop.getProperty("idempresa", "");						/*8*/
			String isucursal = prop.getProperty("isucursal", "");						/*9*/
			String rutaproy = prop.getProperty("Ruta_Proyecto", "");					/*10*/
			String rutaini = prop.getProperty("Ruta_Ini", "");							/*11*/
			String rutafin = prop.getProperty("Ruta_fin", "");							/*12*/
			String rutaerrIni = prop.getProperty("RutaErr_ini", "");					/*13*/
			String rutaerrFin = prop.getProperty("RutaErr_fin", "");					/*14*/
			String idmontacarga = prop.getProperty("idmontacarga", "");					/*15*/
			String puertocom = prop.getProperty("puertocom", "");						/*16*/
			String readerMAC = prop.getProperty("readerMAC", "");						/*17*/
			String idcpumovil = prop.getProperty("idcpumovil", "");						/*18*/
			if (servidor.equals("") || baseDatos.equals("") || usuario.equals("")) {
				return null;
			} else {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				usuario = decrypt(usuario);
				clave = decrypt(clave);
				return new String[] { servidor, baseDatos, usuario, clave, gestor, instancia, urlsincro, tiposincro,
						idempresa, isucursal, rutaproy, rutaini, rutafin, rutaerrIni, rutaerrFin,idmontacarga,puertocom,readerMAC,idcpumovil};
			}

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static String[] LlenarConfigServerWeb() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("og.properties");

			prop.load(input);

			String servidor = prop.getProperty("OServidor", "");
			String baseDatos = prop.getProperty("OBaseDatos", "");
			String clave = prop.getProperty("OClave", "");
			String usuario = prop.getProperty("OUsuario", "");
			String gestor = prop.getProperty("OSGBD", "");
			String instancia = prop.getProperty("OInstancia", "");
			String urlsincro = prop.getProperty("OUrlsincro", "");
			String tiposincro = prop.getProperty("OTiposincro", "").trim();
			String idempresa = prop.getProperty("Oidempresa", "");
			String isucursal = prop.getProperty("Oisucursal", "");
			if (servidor.equals("") || baseDatos.equals("") || usuario.equals("")) {
				return null;
			} else {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				usuario = decrypt(usuario);
				clave = decrypt(clave);
				return new String[] { servidor, baseDatos, usuario, clave, gestor, instancia, urlsincro, tiposincro,
						idempresa, isucursal };
			}

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static void CrearConfig(EConexion cfgInicio) {
		Properties prop = new Properties();
		OutputStream output = null;
		try {
			output = new FileOutputStream(Inicio.SYS_CONFIG);
			prop.setProperty("Servidor", cfgInicio.SERVIDOR);
			prop.setProperty("BaseDatos", cfgInicio.BASE_DATOS);
			prop.setProperty("Usuario", encrypt(cfgInicio.USUARIO));
			prop.setProperty("Clave", encrypt(cfgInicio.CLAVE));
			prop.setProperty("SGBD", cfgInicio.TIPO);
			prop.setProperty("Instancia", cfgInicio.INSTANCIA);
			prop.setProperty("Urlsincro", cfgInicio.URLSINCRO);
			prop.setProperty("Tiposincro", cfgInicio.TIPOSINCRO);
			prop.setProperty("idempresa", cfgInicio.IDEMPRESA);
			prop.setProperty("isucursal", cfgInicio.IDSUCURSAL);
			prop.setProperty("Ruta_Proyecto", cfgInicio.RUTAPROYECTO);
			prop.setProperty("Ruta_Ini", cfgInicio.RUTAINICIO);
			prop.setProperty("Ruta_fin", cfgInicio.RUTAFIN);
			prop.setProperty("RutaErr_ini", cfgInicio.RUTAERRINICIO);
			prop.setProperty("RutaErr_fin", cfgInicio.RUTAERRFIN);
			prop.setProperty("idmontacarga", cfgInicio.IDMONTACARGA);
			prop.setProperty("puertocom", cfgInicio.PUERTOCOM);
			prop.setProperty("readerMAC", cfgInicio.READERMAC);
			prop.setProperty("idcpumovil", cfgInicio.IDCPUMOVIL);
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void CrearConfigOrgien(EConexion cfgInicio) {
		Properties prop = new Properties();
		OutputStream output = null;
		try {
			output = new FileOutputStream(Inicio.OG_CONFIG);
			prop.setProperty("OServidor", cfgInicio.SERVIDOR);
			prop.setProperty("OBaseDatos", cfgInicio.BASE_DATOS);
			prop.setProperty("OUsuario", encrypt(cfgInicio.USUARIO));
			prop.setProperty("OClave", encrypt(cfgInicio.CLAVE));
			prop.setProperty("OSGBD", cfgInicio.TIPO);
			prop.setProperty("OInstancia", cfgInicio.INSTANCIA);
			prop.setProperty("OUrlsincro", cfgInicio.URLSINCRO);
			prop.setProperty("OTiposincro", cfgInicio.TIPOSINCRO);
			prop.setProperty("Oidempresa", cfgInicio.IDEMPRESA);
			prop.setProperty("Oisucursal", cfgInicio.IDSUCURSAL);
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void main(String[] args) {
		
	}

}
