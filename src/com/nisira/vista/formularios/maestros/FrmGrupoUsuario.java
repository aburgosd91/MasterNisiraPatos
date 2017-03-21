package com.nisira.vista.formularios.maestros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.nisira.core.NisiraORMException;
import com.nisira.dao.GrupoUsuarioDao;
import com.nisira.dao.GrupoUsuarioPrivilegioDao;
import com.nisira.dao.SysFormularioDao;
import com.nisira.entidad.GrupoUsuario;
import com.nisira.entidad.GrupoUsuarioPrivilegio;
import com.nisira.entidad.SysFormulario;
import com.nisira.vista.celleditor.TxtSysFormulario;
import com.nisira.vista.controles.NSRTable;
import com.nisira.vista.controles.NSRTableModel;
import com.nisira.vista.controles.MaestroTableModel;

public class FrmGrupoUsuario extends AbstractMaestro {

	private static final long serialVersionUID = 1L;

	private GrupoUsuario grupoUsuario;

	private GrupoUsuarioDao grupoUsuarioDao = new GrupoUsuarioDao();
	private GrupoUsuarioPrivilegioDao privilegioDao = new GrupoUsuarioPrivilegioDao();
	private SysFormularioDao formularioDao = new SysFormularioDao();
	private List<GrupoUsuario> gruposUsuario = new ArrayList<GrupoUsuario>();
	private List<GrupoUsuarioPrivilegio> privilegios = new ArrayList<GrupoUsuarioPrivilegio>();

	private JTable tblLista;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JCheckBox chkEsAdministrador;
	private NSRTable tblOpciones;
	private TxtSysFormulario txtFormulario;

	JScrollPane scrollPane2 = new JScrollPane();
	private JLabel lblIngreseOpciones;

	public FrmGrupoUsuario() {
		super("Perfil de Grupos");

		getBarra().setFormMaestro(this);

		JLabel lblCdigo = new JLabel("C\u00F3digo");

		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");

		JScrollPane scrollPane = new JScrollPane();

		tblLista = new JTable(new MaestroTableModel());
		scrollPane.setViewportView(tblLista);
		tblLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);

		chkEsAdministrador = new JCheckBox("Es Administrador");
		chkEsAdministrador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (chkEsAdministrador.isSelected()) {
					getDetalleTM().setEditar(false);
				}
			}
		});

		tblOpciones = new NSRTable(new NSRTableModel(new String[] { "Código",
				"Descripción", "Ver", "Crear", "Modificar", "Eliminar" }) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean evaluaEdicion(int row, int column) {
				if (column == 1)
					return false;
				return getEditar();
			}

			@Override
			public void addRow() {
				addRow(new Object[] { "", "", true, true, true, true });
			}

			@Override
			public Class<?> getColumnClass(int column) {
				// TODO Auto-generated method stub
				if (column >= 2) {
					return Boolean.class;
				}
				return super.getColumnClass(column);
			}

		});
		
		
		// tblOpciones.setTreeTableModel(mttm);
		tblOpciones.setFillsViewportHeight(true);
		scrollPane2.setViewportView(tblOpciones);
		tblOpciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		getDetalleTM().setNombre_detalle("Privilegios Formulario");
		
		getDetalleTM().setObligatorios(0, 1);
		getDetalleTM().setRepetidos(0);
		getDetalleTM().setScrollAndTable(scrollPane2, tblOpciones);

		txtFormulario = new TxtSysFormulario(tblOpciones, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public void cargaDatos(SysFormulario entity) {
				int row = tblOpciones.getSelectedRow();
				if (entity == null) {
					getDetalleTM().setValueAt("", row, 0);
					getDetalleTM().setValueAt("", row, 1);
				} else {
					setText(entity.getIdFormulario());
					getDetalleTM().setValueAt(entity.getIdFormulario(), row, 0);
					getDetalleTM().setValueAt(entity.getDescripcion(), row, 1);
				}
				setSeleccionado(null);
			}
		};

		txtFormulario.updateCellEditor();

		try {
			txtFormulario.setData(new SysFormularioDao().listar(1));
		} catch (NisiraORMException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		lblIngreseOpciones = new JLabel("Ingrese Opciones");
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
												251, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(6)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(4)
																										.addComponent(
																												lblCdigo)
																										.addGap(26)
																										.addComponent(
																												this.txtCodigo,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(4)
																										.addComponent(
																												lblDescripcin)
																										.addGap(5)
																										.addComponent(
																												this.txtDescripcion,
																												GroupLayout.DEFAULT_SIZE,
																												353,
																												Short.MAX_VALUE)
																										.addContainerGap())
																						.addComponent(
																								this.chkEsAdministrador)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(4)
																										.addComponent(
																												this.lblIngreseOpciones,
																												GroupLayout.PREFERRED_SIZE,
																												101,
																												GroupLayout.PREFERRED_SIZE))))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(10)
																		.addComponent(
																				scrollPane2,
																				GroupLayout.DEFAULT_SIZE,
																				412,
																				Short.MAX_VALUE)
																		.addContainerGap()))));
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
																		.addGap(26)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblCdigo)
																						.addComponent(
																								this.txtCodigo,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(10)
																										.addComponent(
																												lblDescripcin))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(6)
																										.addComponent(
																												this.txtDescripcion,
																												GroupLayout.PREFERRED_SIZE,
																												22,
																												GroupLayout.PREFERRED_SIZE)))
																		.addGap(7)
																		.addComponent(
																				this.chkEsAdministrador)
																		.addGap(7)
																		.addComponent(
																				this.lblIngreseOpciones)
																		.addGap(3)
																		.addComponent(
																				scrollPane2,
																				GroupLayout.DEFAULT_SIZE,
																				141,
																				Short.MAX_VALUE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				scrollPane,
																				GroupLayout.DEFAULT_SIZE,
																				298,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		pnlContenido.setLayout(groupLayout);

		tblLista.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						int selectedRow = tblLista.getSelectedRow();
						if (selectedRow >= 0)
							setGrupoUsuario(getGruposUsuario().get(selectedRow));
						else
							setGrupoUsuario(null);
						llenar_datos();
					}
				});
		iniciar();
		// getDetalleTM().setEditar(true);

	}

	@Override
	public void nuevo() {
		setGrupoUsuario(new GrupoUsuario());
		txtCodigo.requestFocus();
	}

	@Override
	public void grabar() {
		try {
			getGrupoUsuarioDao().mezclar(1,getGrupoUsuario());
			for (GrupoUsuarioPrivilegio p : getPrivilegios()) {
				privilegioDao.mezclar(1,p);
			}
		} catch (NisiraORMException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void llenarDesdeVista() {
		String idgrupo = txtCodigo.getText();
		getGrupoUsuario().setIdgrupousuario(idgrupo);
		getGrupoUsuario().setDescripcion(txtDescripcion.getText());
		getGrupoUsuario().setEs_administrador(
				chkEsAdministrador.isSelected() ? 1 : 0);
		int rows = tblOpciones.getRowCount();
		privilegios = new ArrayList<GrupoUsuarioPrivilegio>();
		for (int i = 0; i < rows; i++) {
			GrupoUsuarioPrivilegio p = new GrupoUsuarioPrivilegio();

			p.setIdgrupousuario(idgrupo);
			p.setIdFormulario(getDetalleTM().getValueAt(i, 0).toString());
			p.setVer(((boolean) getDetalleTM().getValueAt(i, 2)) ? 1 : 0);
			p.setCrear(((boolean) getDetalleTM().getValueAt(i, 3)) ? 1 : 0);
			p.setModificar(((boolean) getDetalleTM().getValueAt(i, 4)) ? 1 : 0);
			p.setEliminar(((boolean) getDetalleTM().getValueAt(i, 5)) ? 1 : 0);
			privilegios.add(p);
		}
	};

	@Override
	public void eliminar() {
		if (getGrupoUsuario() != null) {
			try {
				getGrupoUsuarioDao().borrar(1,getGrupoUsuario());
			} catch (NisiraORMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void llenar_datos() {
		limpiarVista();
		try {
			if (getGrupoUsuario() != null) {
				txtCodigo.setText(getGrupoUsuario().getIdgrupousuario());
				txtDescripcion.setText(getGrupoUsuario().getDescripcion());
				if (getGrupoUsuario().getEs_administrador() == null) {
					chkEsAdministrador.setSelected(false);
				} else {
					chkEsAdministrador.setSelected(getGrupoUsuario()
							.getEs_administrador() == 1);
				}

				setPrivilegios(privilegioDao
						.getPorGrupoUsuario(1,getGrupoUsuario()));

				for (GrupoUsuarioPrivilegio obj : getPrivilegios()) {
					boolean ver, crear, modificar, eliminar;
					ver = (obj.getVer() == 1);
					crear = (obj.getCrear() == 1);
					modificar = (obj.getModificar() == 1);
					eliminar = (obj.getEliminar() == 1);
					SysFormulario formulario = formularioDao
							.porClavePrimaria(1,obj.getIdFormulario());
					getDetalleTM().addRow(
							new Object[] { formulario.getIdFormulario(),
									formulario.getDescripcion(), ver, crear,
									modificar, eliminar });
				}
			}
		} catch (SQLException | NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void llenar_lista() {

		tblLista.setFillsViewportHeight(true);

		MaestroTableModel model = (MaestroTableModel) tblLista.getModel();
		model.limpiar();
		for (GrupoUsuario obj : getGruposUsuario()) {
			model.addRow(new Object[] { obj.getIdgrupousuario(),
					obj.getDescripcion() });
		}
		if (getGruposUsuario().size() > 0) {
			setGrupoUsuario(getGruposUsuario().get(0));
			tblLista.setRowSelectionInterval(0, 0);
		}
	}

	@Override
	public void llenar_tablas() {
		try {
			setGruposUsuario(getGrupoUsuarioDao().listar(1));
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void vista_edicion() {
		if (getEstado().equals(NUEVO))
			txtCodigo.setEditable(true);
		txtDescripcion.setEditable(true);
		chkEsAdministrador.setEnabled(true);
		tblLista.setEnabled(false);
		getDetalleTM().setEditar(true);
	}

	@Override
	public void vista_noedicion() {
		txtCodigo.setEditable(false);
		txtDescripcion.setEditable(false);
		chkEsAdministrador.setEnabled(false);
		tblLista.setEnabled(true);
		getDetalleTM().setEditar(false);
	}

	@Override
	public void anular() {
		// TODO Auto-generated method stub

	}

	@Override
	public void limpiarDetalle() {
		getDetalleTM().limpiar();
	}

	@Override
	public void limpiarVista() {
		getDetalleTM().limpiar();
		txtCodigo.setText("");
		txtDescripcion.setText("");
		chkEsAdministrador.setSelected(false);
	}

	@Override
	public boolean isValidaVista() {
		if (txtCodigo.getText().trim().isEmpty())
			return false;
		if (txtDescripcion.getText().trim().isEmpty())
			return false;
		if (!getDetalleTM().esValido())
			return false;
		return true;
	}

	public GrupoUsuario getGrupoUsuario() {
		return grupoUsuario;
	}

	public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
		this.grupoUsuario = grupoUsuario;
	}

	public GrupoUsuarioDao getGrupoUsuarioDao() {
		return grupoUsuarioDao;
	}

	public void setGrupoUsuarioDao(GrupoUsuarioDao grupoUsuarioDao) {
		this.grupoUsuarioDao = grupoUsuarioDao;
	}

	public List<GrupoUsuario> getGruposUsuario() {
		return gruposUsuario;
	}

	public void setGruposUsuario(List<GrupoUsuario> gruposUsuario) {
		this.gruposUsuario = gruposUsuario;
	}

	public NSRTableModel getDetalleTM() {
		return ((NSRTableModel) tblOpciones.getModel());
	}

	public List<GrupoUsuarioPrivilegio> getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(List<GrupoUsuarioPrivilegio> privilegios) {
		this.privilegios = privilegios;
	}

	@Override
	public void llenarPorId(Object id) {
		// TODO Auto-generated method stub
		
	}

}