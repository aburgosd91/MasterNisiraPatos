package com.nisira.vista.formularios.maestros;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.nisira.core.EConexion;
import com.nisira.utils.nisiracore.Constantes;

import vista.combobox.ComboBox;
import core.inicio.ConectionManager;
import core.inicio.ConfigInicial;

public class FrmSysConfig extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtServidor;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JTextField txtBD;
	public EConexion cfgInicio = new EConexion();
	public EConexion cfgOrigne = new EConexion();
	private List<ChangeListener> listenerList = new ArrayList<ChangeListener>();
	private JLabel lblBaseDeDatos_1;
	private ComboBox comboBox;
	private ComboBox cboTipo;
	private List<String[]> optionList = new ArrayList<String[]>();
	private List<String[]> optionList_ = new ArrayList<String[]>();
	private JTextField txtInstancia;
	private JTextField textSincronizarUrl;
	private JTextField textEmpresa;
	private JTextField textSucursal;
	private JLabel lblNewLabel;
	private JTextField textProute;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textParIni;
	private JTextField textParFin;
	private JTextField textErrIni;
	private JTextField textErrFin;
	private FrmOrigenSyncro frmo;

	/**
	 * Create the frame.
	 */
	public FrmSysConfig() {
		setAlwaysOnTop(true);
		setMinimumSize(new Dimension(350, 500));
		getContentPane().setMinimumSize(new Dimension(800, 800));

		setIconImage(new ImageIcon(FrmLogin.class.getResource("/resources/nisiralogo.png")).getImage());
		frmo = new FrmOrigenSyncro();
		setResizable(false);
		setTitle("Configuraci\u00F3n Inicial");

		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setBounds(24, 42, 46, 14);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(24, 98, 46, 14);

		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(24, 127, 46, 14);

		txtServidor = new JTextField();
		txtServidor.setBounds(109, 39, 225, 20);
		txtServidor.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(109, 95, 149, 20);
		txtUsuario.setColumns(10);

		txtClave = new JPasswordField();
		txtClave.setBounds(109, 124, 149, 20);

		JButton btnAceptar = new JButton("Agregar");
		btnAceptar.setBounds(10, 429, 94, 23);
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (isValido()) {
					ChangeEvent ce = new ChangeEvent(this);
					for (ChangeListener listener : listenerList) {
						listener.stateChanged(ce);
					}
				} else {
					System.out.println("Error al conectar con la base de datos");
				}
			}
		});

		JLabel lblBaseDeDatos = new JLabel("Base de Datos");
		lblBaseDeDatos.setBounds(24, 148, 80, 24);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(240, 429, 94, 23);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cerrar();
			}
		});

		txtBD = new JTextField();
		txtBD.setBounds(108, 150, 106, 20);
		txtBD.setColumns(10);
		getContentPane().setLayout(null);
		getContentPane().add(lblServidor);
		getContentPane().add(txtServidor);
		getContentPane().add(btnAceptar);
		getContentPane().add(btnCancelar);
		getContentPane().add(lblBaseDeDatos);
		getContentPane().add(txtBD);
		getContentPane().add(lblUsuario);
		getContentPane().add(lblClave);
		getContentPane().add(txtClave);
		getContentPane().add(txtUsuario);

		this.lblBaseDeDatos_1 = new JLabel("Gestor de BD");
		this.lblBaseDeDatos_1.setBounds(24, 14, 80, 14);
		getContentPane().add(this.lblBaseDeDatos_1);

		optionList.add(new String[] { Constantes.MSSQL, "SQL Server" });
		optionList.add(new String[] { Constantes.POSTGRESQL, "Postgres" });
		comboBox = new ComboBox(optionList, 1);

		this.comboBox.setBounds(109, 11, 132, 20);
		getContentPane().add(this.comboBox);

		optionList_.add(new String[] { "1", "Xml" });
		optionList_.add(new String[] { "2", "Json" });
		cboTipo = new ComboBox(optionList_, 1);

		this.cboTipo.setBounds(109, 396, 132, 20);
		getContentPane().add(this.cboTipo);

		JLabel lblInstancia = new JLabel("Instancia");
		lblInstancia.setBounds(24, 70, 66, 14);
		getContentPane().add(lblInstancia);

		txtInstancia = new JTextField();
		txtInstancia.setColumns(10);
		txtInstancia.setBounds(109, 67, 174, 20);
		getContentPane().add(txtInstancia);

		textSincronizarUrl = new JTextField();
		textSincronizarUrl.setColumns(10);
		textSincronizarUrl.setBounds(108, 183, 226, 20);
		getContentPane().add(textSincronizarUrl);

		JLabel lblUrl = new JLabel("Sincronizar(Url)");
		lblUrl.setBounds(24, 181, 80, 24);
		getContentPane().add(lblUrl);

		JLabel lblTipoDato = new JLabel("Tipo Dato");
		lblTipoDato.setBounds(24, 394, 57, 24);
		getContentPane().add(lblTipoDato);

		JLabel lblIdEmpresa = new JLabel("Id Empresa");
		lblIdEmpresa.setBounds(24, 216, 73, 14);
		getContentPane().add(lblIdEmpresa);

		textEmpresa = new JTextField();
		textEmpresa.setBounds(109, 214, 30, 20);
		getContentPane().add(textEmpresa);
		textEmpresa.setColumns(10);

		JLabel lblIdSucursal = new JLabel("Id Sucursal");
		lblIdSucursal.setBounds(24, 241, 66, 14);
		getContentPane().add(lblIdSucursal);

		textSucursal = new JTextField();
		textSucursal.setBounds(109, 238, 30, 20);
		getContentPane().add(textSucursal);
		textSucursal.setColumns(10);

		lblNewLabel = new JLabel("Ruta de Proyecto");
		lblNewLabel.setBounds(24, 266, 94, 14);
		getContentPane().add(lblNewLabel);

		textProute = new JTextField();
		textProute.setBounds(109, 263, 225, 20);
		getContentPane().add(textProute);
		textProute.setColumns(10);

		lblNewLabel_1 = new JLabel("Parametro Inicio");
		lblNewLabel_1.setBounds(24, 291, 86, 14);
		getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Parametro Fin");
		lblNewLabel_2.setBounds(24, 316, 80, 14);
		getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Parametro Error Inicio");
		lblNewLabel_3.setBounds(24, 341, 115, 14);
		getContentPane().add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Parametro Error Fin");
		lblNewLabel_4.setBounds(24, 369, 106, 14);
		getContentPane().add(lblNewLabel_4);

		textParIni = new JTextField();
		textParIni.setBounds(109, 288, 225, 20);
		getContentPane().add(textParIni);
		textParIni.setColumns(10);

		textParFin = new JTextField();
		textParFin.setBounds(109, 313, 225, 20);
		getContentPane().add(textParFin);
		textParFin.setColumns(10);

		textErrIni = new JTextField();
		textErrIni.setBounds(128, 338, 206, 20);
		getContentPane().add(textErrIni);
		textErrIni.setColumns(10);

		textErrFin = new JTextField();
		textErrFin.setBounds(128, 365, 206, 20);
		getContentPane().add(textErrFin);
		textErrFin.setColumns(10);

		JButton btnNewButton = new JButton("Conf Sync Origen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmo.addChangeListener(new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent arg0) {
						cfgOrigne = frmo.cfgOrigne;
					}
				});
				frmo.setVisible(true);
			}
		});
		btnNewButton.setBounds(109, 429, 121, 23);
		getContentPane().add(btnNewButton);
		// getContentPane().setFocusTraversalPolicy(new
		// FocusTraversalOnArray(new Component[]{lblServidor, txtServidor,
		// lblUsuario, txtUsuario, lblClave, txtClave, lblBaseDeDatos, txtBD,
		// btnAceptar, btnCancelar}));
	}

	private boolean isCamposValidos() {

		if (comboBox.getSelectedIndex() == -1) {
			return false;
		}
		if (cboTipo.getSelectedIndex() == -1) {
			return false;
		}
		if (txtServidor.getText().trim().isEmpty()) {
			return false;
		}
		if (txtUsuario.getText().trim().isEmpty()) {
			return false;
		}

		if (textEmpresa.getText().trim().isEmpty()) {
			return false;
		}
		if (textSucursal.getText().trim().isEmpty()) {
			return false;
		}
		if (textProute.getText().trim().isEmpty()) {
			return false;
		}
		if (textParIni.getText().trim().isEmpty()) {
			return false;
		}
		if (textParFin.getText().trim().isEmpty()) {
			return false;
		}
		if (textErrIni.getText().trim().isEmpty()) {
			return false;
		}
		if (textErrFin.getText().trim().isEmpty()) {
			return false;
		}
		if (cfgOrigne==null){
			return false;
		}
		return true;
	}

	private boolean isValido() {
		if (!isCamposValidos()) {
			return false;
		}
		String gestor = optionList.get(comboBox.getSelectedIndex())[0].toString();
		String gestor_ = optionList_.get(cboTipo.getSelectedIndex())[0].toString();
		cfgInicio = new EConexion();

		cfgInicio.SERVIDOR = txtServidor.getText().trim();
		cfgInicio.INSTANCIA = txtInstancia.getText().trim();
		cfgInicio.BASE_DATOS = txtBD.getText().trim();
		cfgInicio.USUARIO = txtUsuario.getText().trim();
		cfgInicio.CLAVE = new String(txtClave.getPassword());
		cfgInicio.TIPO = gestor;
		cfgInicio.URLSINCRO = "http://" + textSincronizarUrl.getText().trim() + "/";
		cfgInicio.TIPOSINCRO = gestor_;
		cfgInicio.IDEMPRESA = textEmpresa.getText().trim();
		cfgInicio.IDSUCURSAL = textSucursal.getText().trim();
		cfgInicio.RUTAPROYECTO = textProute.getText().trim();
		cfgInicio.RUTAINICIO = textParIni.getText().trim();
		cfgInicio.RUTAFIN = textParFin.getText().trim();
		cfgInicio.RUTAERRINICIO = textErrIni.getText().trim();
		cfgInicio.RUTAERRFIN = textErrIni.getText().trim();
		System.out.println(cfgInicio);
		if (!ConectionManager.isConexionOK(cfgInicio, this)) {
			return false;
		}

		return true;
	}

	public void addChangeListener(ChangeListener listener) {
		listenerList.add(listener);
	}

	private void cerrar() {
		this.dispose();
	}
}
