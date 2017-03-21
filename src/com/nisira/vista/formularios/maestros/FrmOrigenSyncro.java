package com.nisira.vista.formularios.maestros;

import java.awt.Dimension;
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

import core.inicio.ConectionManager;
import vista.combobox.ComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmOrigenSyncro extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtServidor;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JTextField txtBD;
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
	public FrmOrigenSyncro() {
		setAlwaysOnTop(true);
		setMinimumSize(new Dimension(350, 350));
		getContentPane().setMinimumSize(new Dimension(800, 800));
		
		setIconImage(new ImageIcon(
				FrmLogin.class.getResource("/resources/nisiralogo.png")).getImage());
		
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
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isValido()){
					ChangeEvent ce = new ChangeEvent(this);
					for (ChangeListener listener : listenerList) {
						listener.stateChanged(ce);
					}
					cerrar();
				}
			}
		});
		btnAceptar.setBounds(24, 299, 94, 23);
		
		JLabel lblBaseDeDatos = new JLabel("Base de Datos");
		lblBaseDeDatos.setBounds(24, 148, 80, 24);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
		btnCancelar.setBounds(197, 299, 94, 23);
		
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
		
		optionList.add(new String[]{Constantes.MSSQL,"SQL Server"});
		optionList.add(new String[]{Constantes.POSTGRESQL,"Postgres"});
		comboBox = new ComboBox(optionList,1); 
		
		this.comboBox.setBounds(109, 11, 132, 20);
		getContentPane().add(this.comboBox);
		
		optionList_.add(new String[]{"1","Xml"});
		optionList_.add(new String[]{"2","Json"});
		cboTipo = new ComboBox(optionList_,1);
		
		this.cboTipo.setBounds(109, 268, 132, 20);
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
		lblTipoDato.setBounds(24, 266, 57, 24);
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
	}
		private boolean isCamposValidos() {
		
		if (comboBox.getSelectedIndex()==-1) {
			return false;
		}
		if (cboTipo.getSelectedIndex()==-1) {
			return false;
		}
		if (txtServidor.getText().trim().isEmpty()) {
			return false;
		}
		if (txtUsuario.getText().trim().isEmpty()) {
			return false;
		}
		
		if (txtUsuario.getText().trim().isEmpty()) {
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
		cfgOrigne = new EConexion();
		
		cfgOrigne.SERVIDOR = txtServidor.getText().trim();
		cfgOrigne.INSTANCIA = txtInstancia.getText().trim();
		cfgOrigne.BASE_DATOS = txtBD.getText().trim();
		cfgOrigne.USUARIO = txtUsuario.getText().trim();
		cfgOrigne.CLAVE = new String(txtClave.getPassword());
		cfgOrigne.TIPO = gestor;
		cfgOrigne.URLSINCRO="http://"+textSincronizarUrl.getText().trim()+"/";
		cfgOrigne.TIPOSINCRO = gestor_;
		cfgOrigne.IDEMPRESA = textEmpresa.getText().trim();
		cfgOrigne.IDSUCURSAL = textSucursal.getText().trim();
		cfgOrigne.RUTAPROYECTO = "0";
		cfgOrigne.RUTAINICIO = "0";
		cfgOrigne.RUTAFIN = "0";
		cfgOrigne.RUTAERRINICIO = "0";
		cfgOrigne.RUTAERRFIN = "0";
		System.out.println(cfgOrigne);
		if (!ConectionManager.isConexionOK(cfgOrigne, this)) {
			return false;
		}

		return true;
	}
	public void addChangeListener(ChangeListener listener) {
		listenerList.add(listener);
	}
	
	private void cerrar(){
		this.dispose();
	}
}
