package com.nisira.vista.formularios.maestros;

import static com.nisira.utilitarios.UtilMensajes.mensaje_alterta;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.FocusManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.nisira.Inicio;
import com.nisira.alien.ComandosRfid;
import com.nisira.core.NisiraORMException;
import com.nisira.dao.GuardarUsuarioDao;
import com.nisira.dao.UsuarioDao;
import com.nisira.entidad.GuardarUsuario;
import com.nisira.entidad.MUSUARIO;
import com.nisira.security.Encryption;

import core.inicio.ConfigInicial;

import com.nisira.vista.controles.JTextFieldMovil;
import com.nisira.vista.controles.JTextLabelPanel;
import com.nisira.vista.controles.JTextPasswordLabelPanel;

public class FrmLoginMovil extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioDao usuarioDAO = new UsuarioDao();
	private List<ChangeListener> listenerList = new ArrayList<ChangeListener>();
	private JCheckBox chkGuardar;
	
	private GuardarUsuarioDao gudao = new GuardarUsuarioDao();
	private InetAddress localHost;
	
	private JTextLabelPanel textLabelPanelUsuario;
	private JTextPasswordLabelPanel textLabelPanelPassword;
	public List<JPanel> listField= new ArrayList<>();
	public FrmLoginMovil() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(430, 200));
		getContentPane().setMinimumSize(new Dimension(430, 200));
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Inicio de Sesi\u00F3n");
		getContentPane().setLayout(null);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(113, 118, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					iniciarSesion();
				} catch (UnknownHostException | SQLException | NisiraORMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		getContentPane().add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(241, 118, 89, 23);
		getContentPane().add(btnCancelar);

		chkGuardar = new JCheckBox("Guardar datos");
		chkGuardar.setBounds(78, 91, 221, 20);
		getContentPane().add(chkGuardar);
		
		textLabelPanelUsuario = new JTextLabelPanel(0,"usuario", "User", "", 30){
			@Override
			public void ordenfocusPanel(){
				if(listField.size()-1== row)
					((JTextLabelPanel)listField.get(0)).textField.requestFocus();
				else
					((JTextPasswordLabelPanel)listField.get(row+1)).textField.requestFocus();
			}
		};
		textLabelPanelUsuario.setBounds(10, 11, 393, 36);
		getContentPane().add(textLabelPanelUsuario);
		listField.add(textLabelPanelUsuario);
		textLabelPanelPassword = new JTextPasswordLabelPanel(1, "password", "Clave", "", 30){
			@Override
			public void ordenfocusPanel(){
				if(listField.size()-1== row)
					((JTextLabelPanel)listField.get(0)).textField.requestFocus();
				else
					((JTextPasswordLabelPanel)listField.get(row+1)).textField.requestFocus();
			}
		};
		textLabelPanelPassword.setBounds(10, 48, 393, 36);
		getContentPane().add(textLabelPanelPassword);
		listField.add((JPanel)textLabelPanelPassword);
		listField.add(textLabelPanelPassword);
		setIconImage(new ImageIcon(
				FrmLoginMovil.class.getResource("/resources/nisiralogo.png")).getImage());

		try {
			datosGuardados();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
	}

	private void datosGuardados() throws UnknownHostException {

		localHost = InetAddress.getLocalHost();

		try {
			for (GuardarUsuario gusu : gudao.listar(1,"t0.namehost = ?", localHost.getHostName())) {
				if (gusu.getNameHost().equals(localHost.getHostName())) {
					textLabelPanelUsuario.textField.setText(gusu.getIdUsuario());
					textLabelPanelPassword.textField.setText(Encryption.decrypt(gusu.getClave()));
					chkGuardar.setSelected(true);
				}
			}
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void iniciarSesion() throws UnknownHostException, SQLException, NisiraORMException {
		Inicio.usuario = null;
		String idusuario, clave;
		idusuario = textLabelPanelUsuario.textField.getText();
		clave = new String(textLabelPanelPassword.textField.getText());

		localHost = InetAddress.getLocalHost();
		
		List<MUSUARIO> usuarios = getUsuarioDAO().listar(1,true,"UPPER(idusuario) = ? and clave = ?", idusuario.toUpperCase(), Encryption.encrypt(clave));
		
		
		if (!usuarios.isEmpty()) {
			MUSUARIO usuario = usuarios.get(0);
			
			Inicio.usuario = usuario;
			Inicio.idempresa= Integer.parseInt(ConfigInicial.LlenarConfig()[8]);
			Inicio.idsucursal= Integer.parseInt(ConfigInicial.LlenarConfig()[9]);
			Inicio.idmontacarga= Integer.parseInt(ConfigInicial.LlenarConfig()[15]);
			Inicio.validateConfigRfid = ComandosRfid.verificacionConexionServer();
			ChangeEvent ce = new ChangeEvent(this);
			for (ChangeListener listener : listenerList) {
				listener.stateChanged(ce);
			}
			GuardarUsuario gu = new GuardarUsuario();
			

			gu.setNameHost(localHost.getHostName());
			gu.setIdUsuario(usuario.getIdUsuario());
			gu.setClave(Encryption.encrypt(clave));
//
			gudao.borrarPorHostName(1,localHost.getHostName());
			if (chkGuardar.isSelected()) {
				gudao.insertar(1,gu);
			}

			this.dispose();

		} else {
			mensaje_alterta(this, "CLAVEUSUARIO_INC");
		}
	}

	public UsuarioDao getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDao usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public void addChangeListener(ChangeListener listener) {
		listenerList.add(listener);
	}
	
}
