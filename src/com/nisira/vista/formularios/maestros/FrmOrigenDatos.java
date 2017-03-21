package com.nisira.vista.formularios.maestros;

import java.awt.Dimension;
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
import com.nisira.dao.EmpresaEnvioDao;
import com.nisira.dao.OrigenDatoDao;
import com.nisira.entidad.OrigenDato;
import com.nisira.utilitarios.UtilMensajes;
import com.nisira.vista.contenedores.CntEmpresaEnvio;
import com.nisira.vista.controles.NSRComboBox;
import com.nisira.vista.controles.JTextFieldLimit;
import com.nisira.vista.controles.MaestroTableModel;
import com.nisira.vista.utilitarios.FormValidador;

public class FrmOrigenDatos extends AbstractMaestro {

	private static final long serialVersionUID = 1L;

	private OrigenDato origenDato;
	private OrigenDatoDao origenDatoDao = new OrigenDatoDao();
	private EmpresaEnvioDao empresaEnvioDao = new EmpresaEnvioDao();

	private List<OrigenDato> origenesDato = new ArrayList<OrigenDato>();

	private JTable tblLista;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtServidor;
	private JPasswordField txtClave;
	private JTextField txtInstancia;
	private JTextField txtUsuario;
	private NSRComboBox cboTipo;
	private CntEmpresaEnvio cntEmpresaEnvio;
	
	private List<String[]> tipos;
	private JTextField txtEmpNisira;
	private JTextField txtBaseDatos;

	public FrmOrigenDatos() {
		super("Origenes de Datos");
		setSize(new Dimension(629, 418));
		setPreferredSize(new Dimension(630, 370));

		getBarra().setFormMaestro(this);

		JLabel lblCdigo = new JLabel("C\u00F3digo");

		txtCodigo = new JTextField();
		txtCodigo.setName("Código");
		txtCodigo.setColumns(10);

		txtCodigo.setDocument(new JTextFieldLimit(3, true));

		JLabel lblDescripcion = new JLabel("Descripcion");

		JScrollPane scrollPane = new JScrollPane();

		tblLista = new JTable(new MaestroTableModel());
		scrollPane.setViewportView(tblLista);
		tblLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		txtDescripcion = new JTextField();
		txtDescripcion.setName("Descripción");
		txtDescripcion.setColumns(20);

		txtDescripcion.setDocument(new JTextFieldLimit(200, true));

		JLabel lblTipo = new JLabel("Tipo");

		JLabel lblServidor = new JLabel("Servidor");

		txtServidor = new JTextField();
		txtServidor.setName("Servidor");
		txtServidor.setColumns(10);

		txtServidor.setDocument(new JTextFieldLimit(200, true));

		JLabel lblInstancia = new JLabel("Instancia");

		txtClave = new JPasswordField();
		txtClave.setName("Clave");

		txtClave.setDocument(new JTextFieldLimit(200));

		JLabel lblUsuario = new JLabel("Usuario");

		txtInstancia = new JTextField();
		txtInstancia.setName("Instancia");
		txtInstancia.setColumns(10);
		txtInstancia.setDocument(new JTextFieldLimit(200));

		txtUsuario = new JTextField();
		txtUsuario.setName("Usuario");
		txtUsuario.setColumns(10);
		txtUsuario.setDocument(new JTextFieldLimit(200));

		JLabel lblClave = new JLabel("Clave");

		tipos = new ArrayList<String[]>();
		
		//tipos.add(new String[] { "0", "Nisira EDOC" });
		tipos.add(new String[] { "1", "Nisira ERP" });
		tipos.add(new String[] { "2", "MS Excel" });
		tipos.add(new String[] { "3", "CSV" });
		tipos.add(new String[] { "4", "TXT" });

		cboTipo = new NSRComboBox(tipos, 0, 1);
		cboTipo.setName("Tipo");
		
		cntEmpresaEnvio = new CntEmpresaEnvio();
		
		try {
			cntEmpresaEnvio.setData(empresaEnvioDao.listar(1));
		} catch (NisiraORMException e1) {
			e1.printStackTrace();
		}
		
		JLabel label = new JLabel("Empresa Envio");
		label.setName("Empresa Envio");
		
		JLabel lblCodEmpNisira = new JLabel("Cód. Emp. Nisira");
		
		txtEmpNisira = new JTextField();
		txtEmpNisira.setName("Usuario");
		txtEmpNisira.setColumns(10);
		txtEmpNisira.setDocument(new JTextFieldLimit(3, true));
		
		JLabel lblBD = new JLabel("Base de Datos");
		
		txtBaseDatos = new JTextField();
		txtBaseDatos.setName("Usuario");
		txtBaseDatos.setColumns(10);
		txtBaseDatos.setDocument(new JTextFieldLimit(200, true));

		GroupLayout groupLayout = new GroupLayout(pnlContenido);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblBD, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtBaseDatos, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblDescripcion)
											.addGroup(groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblCdigo))
											.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
											.addComponent(label, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
										.addGap(10)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(cntEmpresaEnvio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(txtCodigo, 96, 96, 96)
														.addGap(101))
													.addComponent(txtDescripcion, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
												.addGap(45))
											.addComponent(cboTipo, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblServidor, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblClave, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblUsuario)
											.addComponent(lblInstancia, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(txtInstancia, Alignment.LEADING)
												.addComponent(txtServidor, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
											.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtClave, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))))
								.addGap(0))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblCodEmpNisira, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtEmpNisira, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCdigo)
							.addGap(10)
							.addComponent(lblDescripcion)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTipo)
								.addComponent(cboTipo, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(29)))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(cntEmpresaEnvio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblServidor)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtServidor, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtInstancia, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInstancia))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsuario))
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtClave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblClave))))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBD)
						.addComponent(txtBaseDatos, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodEmpNisira)
						.addComponent(txtEmpNisira, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
		);
		pnlContenido.setLayout(groupLayout);

		tblLista.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						int selectedRow = tblLista.getSelectedRow();
						if (selectedRow >= 0)
							origenDato = origenesDato.get(selectedRow);
						else
							origenDato = null;
						llenar_datos();
					}
				});
		iniciar();
		// getDetalleTM().setEditar(true);

	}

	@Override
	public void nuevo() {
		origenDato = new OrigenDato();

		txtCodigo.requestFocus();
	}

	@Override
	public void grabar() {
		try {
			origenDatoDao.mezclar(1,origenDato);
		} catch (NisiraORMException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void llenarDesdeVista() {
		origenDato.setIdorigen(txtCodigo.getText());
		origenDato.setDescripcion(txtDescripcion.getText());
		origenDato.setServidor(txtServidor.getText());
		origenDato.setInstancia(txtInstancia.getText());
		origenDato.setUsuario(txtUsuario.getText());
		//origenDato.setTipo(((String[]) cboTipo.getSelectedItem())[0]);
		origenDato.setTipo(cboTipo.getSelectedID());
		origenDato.setIdempresa(cntEmpresaEnvio.getSeleccionado().getIdEmpresa());
		origenDato.setEmpresaenvio_odempresaenvio(cntEmpresaEnvio.getSeleccionado());
		origenDato.setIdEmpresaExt(txtEmpNisira.getText());
		origenDato.setBaseDatos(txtBaseDatos.getText());
		origenDato.setClave(com.nisira.security.Encryption
				.pss_encrypt(new String(txtClave.getPassword())));
	};

	@Override
	public void eliminar() {
		if (origenDato != null) {
			try {
				origenDatoDao.borrar(1,origenDato);
			} catch ( NisiraORMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void llenar_datos() {
		limpiarVista();
		if (origenDato != null) {
			txtCodigo.setText(origenDato.getIdorigen());
			txtDescripcion.setText(origenDato.getDescripcion());
			txtServidor.setText(origenDato.getServidor());
			txtInstancia.setText(origenDato.getInstancia());
			txtUsuario.setText(origenDato.getUsuario());
			txtEmpNisira.setText(origenDato.getIdEmpresaExt());
			for (String [] t : tipos) {
				if (t[0].equalsIgnoreCase(origenDato.getTipo())) {
					cboTipo.setSelectedItem(t);
					break;
				}
			}
			cboTipo.repaint();
			cntEmpresaEnvio.setSeleccionado(origenDato.getEmpresaenvio_odempresaenvio());
			
			txtBaseDatos.setText(origenDato.getBaseDatos());
			
			if (origenDato.getClave() != null) {
				txtClave.setText(com.nisira.security.Encryption
						.pss_decrypt(origenDato.getClave()));
			} else {
				txtClave.setText("");
			}
		}

	}

	@Override
	public void llenar_lista() {

		tblLista.setFillsViewportHeight(true);

		MaestroTableModel model = (MaestroTableModel) tblLista.getModel();
		model.limpiar();
		for (OrigenDato obj : origenesDato) {
			model.addRow(new Object[] { obj.getIdorigen(), obj.getDescripcion() });
		}
		if (origenesDato.size() > 0) {
			origenDato = origenesDato.get(0);
			tblLista.setRowSelectionInterval(0, 0);
		}
	}

	@Override
	public void llenar_tablas() {
		try {
			origenesDato = origenDatoDao.listar(1);
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void vista_edicion() {
		if (getEstado().equals(NUEVO))
			txtCodigo.setEditable(true);

		FormValidador.TextFieldsEdicion(true, txtDescripcion, txtServidor,
				txtInstancia, txtClave, txtUsuario, txtEmpNisira, txtBaseDatos);
		FormValidador.CntEdicion(true, cntEmpresaEnvio);
		cboTipo.setEnabled(true);
	}

	@Override
	public void vista_noedicion() {
		FormValidador.TextFieldsEdicion(false, txtCodigo, txtDescripcion,
				txtServidor, txtInstancia, txtClave, txtUsuario, txtEmpNisira, txtBaseDatos);
		FormValidador.CntEdicion(false, cntEmpresaEnvio);
		cboTipo.setEnabled(false);
	}

	@Override
	public void anular() {
		// TODO Auto-generated method stub

	}

	@Override
	public void limpiarDetalle() {
	}

	@Override
	public void limpiarVista() {
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtServidor.setText("");
		txtInstancia.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
		txtBaseDatos.setText("");

	}

	@Override
	public boolean isValidaVista() {
		FormValidador.TextFieldObligatorios(txtCodigo, txtDescripcion);
		FormValidador.CntObligatorios(cntEmpresaEnvio);
		if (cboTipo.getSelectedIndex() < 0) {
			UtilMensajes.mensaje_alterta("DATO_REQUERIDO", cboTipo.getName());
			cboTipo.requestFocus();
			return false;
		}
		return true;
	}

	@Override
	public void llenarPorId(Object id) {
		// TODO Auto-generated method stub
		
	}
}