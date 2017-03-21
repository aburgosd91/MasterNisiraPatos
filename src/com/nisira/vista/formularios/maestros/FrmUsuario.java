package com.nisira.vista.formularios.maestros;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.nisira.core.NisiraORMException;
import com.nisira.dao.GrupoUsuarioDao;
import com.nisira.dao.UsuarioDao;
import com.nisira.entidad.MUSUARIO;
import com.nisira.security.Encryption;
import com.nisira.vista.contenedores.CntGrupoUsuario;
import com.nisira.vista.controles.MaestroTableModel;

public class FrmUsuario extends AbstractMaestro {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MUSUARIO usuario = new MUSUARIO();
	private UsuarioDao usuarioDao = new UsuarioDao();

	private List<MUSUARIO> usuarios = new ArrayList<MUSUARIO>();

	private JTextField txtidUsuario = new JTextField();
	private JTextField txtNombres = new JTextField();
	private JPasswordField txtClave = new JPasswordField();

	JLabel lblId = new JLabel("Cod. Usuario:");
	JLabel lblUsuario = new JLabel("Nombre:");
	JLabel lblCLave = new JLabel("Clave:");

	private JTable tblLista = new JTable(new MaestroTableModel());
	JScrollPane scrollPane = new JScrollPane();
	private JPasswordField txtClaveR;
	protected CntGrupoUsuario cntGrupoUsuario;

	public FrmUsuario() {
		super("Usuarios");
		getBarra().setBounds(0, 0, 0, 0);

		scrollPane.setViewportView(tblLista);
		tblLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JLabel lblGrupoUsuario = new JLabel("Grupo Usuario");

		txtClaveR = new JPasswordField();

		JLabel lblRepitaLaClave = new JLabel("Repita Clave:");

		this.cntGrupoUsuario = new CntGrupoUsuario();
		GroupLayout groupLayout = new GroupLayout(pnlContenido);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(scrollPane,
												GroupLayout.PREFERRED_SIZE,
												263, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblId,
																GroupLayout.PREFERRED_SIZE,
																73,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblUsuario,
																GroupLayout.PREFERRED_SIZE,
																62,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblCLave,
																GroupLayout.PREFERRED_SIZE,
																42,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblRepitaLaClave,
																GroupLayout.PREFERRED_SIZE,
																73,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblGrupoUsuario,
																GroupLayout.PREFERRED_SIZE,
																80,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																Alignment.TRAILING,
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								this.txtClaveR,
																								GroupLayout.DEFAULT_SIZE,
																								104,
																								Short.MAX_VALUE)
																						.addComponent(
																								txtClave,
																								GroupLayout.DEFAULT_SIZE,
																								104,
																								Short.MAX_VALUE))
																		.addGap(109))
														.addComponent(
																txtNombres,
																Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE,
																213,
																Short.MAX_VALUE)
														.addComponent(
																txtidUsuario,
																GroupLayout.PREFERRED_SIZE,
																152,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																this.cntGrupoUsuario,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(16)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblId)
																						.addComponent(
																								txtidUsuario,
																								GroupLayout.PREFERRED_SIZE,
																								22,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(18)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblUsuario)
																						.addComponent(
																								txtNombres,
																								GroupLayout.PREFERRED_SIZE,
																								22,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(18)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblCLave)
																						.addComponent(
																								txtClave,
																								GroupLayout.PREFERRED_SIZE,
																								22,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(18)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblRepitaLaClave)
																						.addComponent(
																								this.txtClaveR,
																								GroupLayout.PREFERRED_SIZE,
																								22,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(18)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblGrupoUsuario)
																						.addComponent(
																								this.cntGrupoUsuario,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				scrollPane,
																				GroupLayout.DEFAULT_SIZE,
																				234,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		pnlContenido.setLayout(groupLayout);
		// pnlContenido.setFocusTraversalPolicy(new FocusTraversalOnArray(
		// new Component[] { scrollPane, tblLista, lblId, txtidUsuario,
		// lblUsuario, txtClave, lblCLave, txtNombres, lblGrupoUsuario,
		// txtidgrupo }));

		tblLista.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						int selectedRow = tblLista.getSelectedRow();
						if (selectedRow >= 0)
							setusuario(getusuarios().get(selectedRow));
						else
							setusuario(null);
						llenar_datos();
					}
				});
		iniciar();
	}

	@Override
	public void nuevo() {
		setusuario(new MUSUARIO());
		getusuario().setClave("");
		usuario.setEstado(1);
	}

	@Override
	public void anular() {

	}

	@Override
	public void grabar() {
		try {
			getusuarioDao().mezclar(1,getusuario());
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void llenar_datos() {
		limpiarVista();
		if (getusuario() != null) {
			txtidUsuario.setText(getusuario().getIdUsuario());
			txtNombres.setText(getusuario().getNombres());
			cntGrupoUsuario.txtCodigo.setText((getusuario()
					.getGrupousuario_fk_usuario_grupousuario() == null) ? ""
					: getusuario().getGrupousuario_fk_usuario_grupousuario()
							.getIdgrupousuario());
			cntGrupoUsuario.llenar();
			txtClave.setText(Encryption.decrypt(getusuario().getClave()));
			txtClaveR.setText(Encryption.decrypt(getusuario().getClave()));

		}
	}

	@Override
	public void llenar_lista() {

		tblLista.setFillsViewportHeight(true);

		MaestroTableModel model = (MaestroTableModel) tblLista.getModel();
		model.limpiar();
		for (MUSUARIO obj : getusuarios()) {
			model.addRow(new Object[] { obj.getIdUsuario(), obj.getNombres() });
		}
		if (getusuarios().size() > 0) {
			setusuario(getusuarios().get(0));
			tblLista.setRowSelectionInterval(0, 0);
		}
	}

	@Override
	public void llenar_tablas() {
		try {
			setusuarios(getusuarioDao().listar(1));
			cntGrupoUsuario.setData(new GrupoUsuarioDao().listar(1));
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<MUSUARIO> getusuarios() {
		return usuarios;
	}

	public void setusuarios(List<MUSUARIO> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public void vista_edicion() {
		if (getEstado().equals(NUEVO))
			txtidUsuario.setEditable(true);
		TextFieldsEdicion(true, txtNombres, txtClave, txtClaveR,
				cntGrupoUsuario.txtCodigo);
		tblLista.setEnabled(false);
	}

	@Override
	public void vista_noedicion() {
		TextFieldsEdicion(false, txtidUsuario, txtNombres, txtClave, txtClaveR,
				cntGrupoUsuario.txtCodigo);
		tblLista.setEnabled(true);
	}

	@Override
	public void limpiarVista() {
		txtidUsuario.setText("");
		txtNombres.setText("");
		txtClave.setText("");
		cntGrupoUsuario.setSeleccionado(null);
	}

	@Override
	public void llenarDesdeVista() {
		// GrupoUsuario u = new GrupoUsuario();
		// u.setIdgrupoUsuario(txtidgrupo.getText());

		getusuario().setIdUsuario(txtidUsuario.getText());
		getusuario().setClave(
				Encryption.encrypt(new String(txtClave.getPassword())));
		getusuario().setNombres(txtNombres.getText());
		getusuario()
				.setIdgrupoUsuario(
						(cntGrupoUsuario.getSeleccionado() == null) ? null
								: cntGrupoUsuario.getSeleccionado()
										.getIdgrupousuario());
		getusuario().setGrupousuario_fk_usuario_grupousuario(
				cntGrupoUsuario.getSeleccionado());
	}

	@Override
	public boolean isValidaVista() {
		if (txtidUsuario.getText().trim().isEmpty()) {
			return false;
		}

		if (new String(txtClave.getPassword()).isEmpty()) {
			return false;
		}

		if (!TextFieldObligatorios(txtNombres, cntGrupoUsuario.txtCodigo)) {
			return false;
		}
		return true;
	}

	@Override
	public void eliminar() {
		if (getusuario() != null) {
			try {
				getusuarioDao().borrar(1,getusuario());
			} catch ( NisiraORMException e) {
				e.printStackTrace();
			}
		}
	}

	public MUSUARIO getusuario() {
		return usuario;
	}

	public void setusuario(MUSUARIO usuario) {
		this.usuario = usuario;
	}

	public UsuarioDao getusuarioDao() {
		return usuarioDao;
	}

	public void setusuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public void llenarPorId(Object id) {
		// TODO Auto-generated method stub
		
	}
}