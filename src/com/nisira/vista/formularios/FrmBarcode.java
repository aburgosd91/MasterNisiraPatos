package com.nisira.vista.formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
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

import com.nisira.clientservice.HttpDGENERACIONCODIGO;
import com.nisira.clientservice.HttpGENERACIONCODIGO;
import com.nisira.core.NisiraORMException;
import com.nisira.dao.DGENERACIONCODIGOSDao;
import com.nisira.dao.GENERACIONCODIGOSDao;
import com.nisira.dao.GrupoUsuarioDao;
import com.nisira.dao.GrupoUsuarioPrivilegioDao;
import com.nisira.dao.SysFormularioDao;
import com.nisira.entidad.BarcodeXML;
import com.nisira.entidad.BarcodeXML.Digitos;
import com.nisira.entidad.DGENERACIONCODIGOS;
import com.nisira.entidad.GENERACIONCODIGOS;
import com.nisira.entidad.GrupoUsuario;
import com.nisira.entidad.GrupoUsuarioPrivilegio;
import com.nisira.entidad.SysFormulario;
import com.nisira.utils.nisiracore.Constantes;
import com.nisira.vista.celleditor.TxtSysFormulario;
import com.nisira.vista.controles.NSRTable;
import com.nisira.vista.controles.NSRTableModel;
import com.nisira.vista.formularios.maestros.AbstractMaestro;
import com.nisira.vista.controles.MaestroTableModel;
import javax.swing.JButton;
import java.awt.Dimension;

public class FrmBarcode extends AbstractMaestro {

	private static final long serialVersionUID = 1L;
	/***************************** CABECERA ***********************/
	private GENERACIONCODIGOS generacionCodigos;
	private GENERACIONCODIGOSDao generacionCodigosDao = new GENERACIONCODIGOSDao();
	private List<GENERACIONCODIGOS> listGeneracionCodigos = new ArrayList<GENERACIONCODIGOS>();
	/****************************** DETALLE ************************/
	private DGENERACIONCODIGOS dGeneracionCodigos;
	private DGENERACIONCODIGOSDao dGeneracionCodigosDao = new DGENERACIONCODIGOSDao();
	private List<DGENERACIONCODIGOS> listDGeneracionCodigos = new ArrayList<DGENERACIONCODIGOS>();

	// private GrupoUsuario grupoUsuario;
	//
	// private GrupoUsuarioDao grupoUsuarioDao = new GrupoUsuarioDao();
	// private GrupoUsuarioPrivilegioDao privilegioDao = new
	// GrupoUsuarioPrivilegioDao();
	// private SysFormularioDao formularioDao = new SysFormularioDao();
	// private List<GrupoUsuario> gruposUsuario = new ArrayList<GrupoUsuario>();
	// private List<GrupoUsuarioPrivilegio> privilegios = new
	// ArrayList<GrupoUsuarioPrivilegio>();

	private JTable tblLista;
	private JTextField txtIdGeneracion;
	private JTextField txtDescripcion;
	private JCheckBox chkSincronizado;
	private NSRTable tblOpciones;
	private TxtSysFormulario txtFormulario;

	JScrollPane scrollPane2 = new JScrollPane();
	private JLabel lblIngreseOpciones;
	private JButton btnActualizar;
	private JTextField txtTotalDigito;
	private JTextField txtFecha;

	public FrmBarcode() {
		super("Sincronizar Códigos");
		setPreferredSize(new Dimension(555, 425));
		setSize(new Dimension(555, 425));

		getBarra().setFormMaestro(this);

		JLabel lblCdigo = new JLabel("C\u00F3digo");

		txtIdGeneracion = new JTextField();
		txtIdGeneracion.setColumns(10);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");

		JScrollPane scrollPane = new JScrollPane();

		tblLista = new JTable(new MaestroTableModel());
		scrollPane.setViewportView(tblLista);
		tblLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);

		chkSincronizado = new JCheckBox("Sincronizado");
		chkSincronizado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (chkSincronizado.isSelected()) {
					getDetalleTM().setEditar(false);
				}
			}
		});

		tblOpciones = new NSRTable(
				new NSRTableModel(new String[] { "IdRegistro", "Parametro", "Digito", "Total", "Sincronizado" }) {

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
						addRow(new Object[] { "", "", "", "", true });
					}

					@Override
					public Class<?> getColumnClass(int column) {
						// TODO Auto-generated method stub
						if (column >= 4) {
							return Boolean.class;
						}
						return super.getColumnClass(column);
					}

				});

		// tblOpciones.setTreeTableModel(mttm);
		tblOpciones.setFillsViewportHeight(true);
		scrollPane2.setViewportView(tblOpciones);
		tblOpciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		getDetalleTM().setNombre_detalle("Detalle Generacion Código Formulario");

		getDetalleTM().setObligatorios(0, 1);
		getDetalleTM().setRepetidos(0);
		getDetalleTM().setScrollAndTable(scrollPane2, tblOpciones);

		// txtFormulario = new TxtSysFormulario(tblOpciones, 0) {
		// private static final long serialVersionUID = 1L;
		//
		// @Override
		// public void cargaDatos(SysFormulario entity) {
		// int row = tblOpciones.getSelectedRow();
		// if (entity == null) {
		// getDetalleTM().setValueAt("", row, 0);
		// getDetalleTM().setValueAt("", row, 1);
		// } else {
		// setText(entity.getIdFormulario());
		// getDetalleTM().setValueAt(entity.getIdFormulario(), row, 0);
		// getDetalleTM().setValueAt(entity.getDescripcion(), row, 1);
		// }
		// setSeleccionado(null);
		// }
		// };

		// txtFormulario.updateCellEditor();

		// try {
		// txtFormulario.setData(new SysFormularioDao().listar());
		// } catch (SQLException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }

		lblIngreseOpciones = new JLabel("Ingrese Opciones");

		btnActualizar = new JButton("Sincronizar - Web");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				llenarDesdeWeb();
			}
		});

		txtTotalDigito = new JTextField();
		txtTotalDigito.setName("Descripción");
		txtTotalDigito.setColumns(10);

		JLabel label = new JLabel("Digitos");

		JLabel label_1 = new JLabel("Fecha");

		txtFecha = new JTextField();
		txtFecha.setName("Clase");
		txtFecha.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(pnlContenido);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(6)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(lblCdigo)
												.addGap(26)
												.addComponent(txtIdGeneracion, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 116,
												GroupLayout.PREFERRED_SIZE).addContainerGap())
								.addGroup(groupLayout.createSequentialGroup().addGap(4)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(label, GroupLayout.PREFERRED_SIZE, 54,
																GroupLayout.PREFERRED_SIZE)
														.addGap(5).addComponent(txtTotalDigito,
																GroupLayout.PREFERRED_SIZE, 62,
																GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 54,
														GroupLayout.PREFERRED_SIZE)
												.addGap(5).addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 110,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblDescripcin)
												.addGap(5).addComponent(txtDescripcion, GroupLayout.DEFAULT_SIZE, 208,
														Short.MAX_VALUE)))
										.addContainerGap())))
						.addGroup(groupLayout.createSequentialGroup().addGap(10)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblIngreseOpciones, GroupLayout.PREFERRED_SIZE, 101,
												GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
								.addContainerGap()))
						.addGroup(groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(chkSincronizado).addContainerGap()))));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(
												scrollPane, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(26)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblCdigo)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(txtIdGeneracion, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 22,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(10)
														.addComponent(lblDescripcin))
												.addGroup(groupLayout.createSequentialGroup().addGap(6).addComponent(
														txtDescripcion, GroupLayout.PREFERRED_SIZE, 22,
														GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup().addGap(78)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(2)
														.addComponent(label))
												.addComponent(txtTotalDigito, GroupLayout.PREFERRED_SIZE, 22,
														GroupLayout.PREFERRED_SIZE))
										.addGap(5)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(4)
														.addComponent(label_1))
												.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 22,
														GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(chkSincronizado)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblIngreseOpciones).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 175,
										GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
		pnlContenido.setLayout(groupLayout);

		tblLista.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tblLista.getSelectedRow();
				if (selectedRow >= 0)
					setGeneracionCodigos(getListGeneracionCodigos().get(selectedRow));
				// setGrupoUsuario(getGruposUsuario().get(selectedRow));
				else
					setGeneracionCodigos(null);
				// setGrupoUsuario(null);
				llenar_datos();
			}
		});
		MaestroTableModel model = (MaestroTableModel) tblLista.getModel();
		model.addColumn("Total");
		iniciar();
		// getDetalleTM().setEditar(true);

	}

	private void llenarDesdeWeb() {
		/*************************************
		 * CONECTAR A SERVIDOR
		 *************************************************/
		try {
			generarXML();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		iniciar();
	}

	private void generarXML() throws SQLException, NisiraORMException {
		BarcodeXML barcode;
		List<BarcodeXML> listBarcode = new ArrayList<BarcodeXML>();
		// barcode.setCantidad(listGeneracionCodigos.get(0).getNUMDIGITOTOTAL());
		for (GENERACIONCODIGOS gc : listGeneracionCodigos) {
			if (gc.getPARAMETRO().equalsIgnoreCase(generacionCodigos.getPARAMETRO())) {
				barcode = new BarcodeXML();
				barcode.setInicio("@~");
				barcode.setFin("~@");
				barcode.setTotal(gc.getNUMDIGITOTOTAL());
				barcode.setDig(new ArrayList<Digitos>());
				listDGeneracionCodigos = getdGeneracionCodigosDao().listar(1, "IDEMPRESA = ? and IDGENERACION = ?",
						gc.getIDEMPRESA(), gc.getIDGENERACION());
				for (DGENERACIONCODIGOS dgc : listDGeneracionCodigos)
					barcode.agregarDigito(dgc.getPARAMETRO(), dgc.getNUMDIGITO());
				listBarcode.add(barcode);
			}
		}

		try {
			Constantes.crearXML("com.nisira.entidad.BarcodeXML", listBarcode, "c:\\SOLUTION\\WEB\\solution.xml");
		} catch (FileNotFoundException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			Constantes.log.warn(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void nuevo() {
		setGeneracionCodigos(new GENERACIONCODIGOS());
		// setGrupoUsuario(new GrupoUsuario());
		txtIdGeneracion.requestFocus();
	}

	@Override
	public void grabar() {
		try {
			getGeneracionCodigosDao().mezclar(1,getGeneracionCodigos());
			for (DGENERACIONCODIGOS dgc : getListDGeneracionCodigos()) {
				getdGeneracionCodigosDao().mezclar(1,dgc);
			}
			// getGrupoUsuarioDao().mezclar(getGrupoUsuario());
			// for (GrupoUsuarioPrivilegio p : getPrivilegios()) {
			// privilegioDao.mezclar(p);
			// }
		} catch (NisiraORMException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void llenarDesdeVista() {
		/* MODIFICADO */
		String idIdgeneracion = txtIdGeneracion.getText();
		getGeneracionCodigos().setIDGENERACION(Integer.parseInt(idIdgeneracion));
		getGeneracionCodigos().setDESCRIPCION(txtDescripcion.getText());
		getGeneracionCodigos().setNUMDIGITOTOTAL(Integer.parseInt(txtTotalDigito.getText()));
		getGeneracionCodigos().setSINCRONIZADO(chkSincronizado.isSelected() ? 1 : 0);

		// String idgrupo = txtIdGeneracion.getText();
		// getGrupoUsuario().setIdgrupousuario(idgrupo);
		// getGrupoUsuario().setDescripcion(txtDescripcion.getText());
		// getGrupoUsuario().setEs_administrador(
		// chkSincronizado.isSelected() ? 1 : 0);
		int rows = tblOpciones.getRowCount();
		listDGeneracionCodigos = new ArrayList<DGENERACIONCODIGOS>();
		for (int i = 0; i < rows; i++) {
			DGENERACIONCODIGOS dGeneracionCodigos = new DGENERACIONCODIGOS();
			dGeneracionCodigos.setIDEMPRESA(getGeneracionCodigos().getIDEMPRESA());
			dGeneracionCodigos.setIDGENERACION(getGeneracionCodigos().getIDGENERACION());
			dGeneracionCodigos.setIDREGISTROCODIGO(Integer.parseInt(getDetalleTM().getValueAt(i, 0).toString()));
			dGeneracionCodigos.setPARAMETRO(getDetalleTM().getValueAt(i, 1).toString());
			dGeneracionCodigos.setNUMDIGITO(Integer.parseInt(getDetalleTM().getValueAt(i, 2).toString()));
			dGeneracionCodigos.setNUMDIGITOTOTAL(Integer.parseInt(getDetalleTM().getValueAt(i, 3).toString()));
			dGeneracionCodigos.setSINCRONIZADO(((boolean) getDetalleTM().getValueAt(i, 4)) ? 1 : 0);
			listDGeneracionCodigos.add(dGeneracionCodigos);
		}
		// privilegios = new ArrayList<GrupoUsuarioPrivilegio>();
		// for (int i = 0; i < rows; i++) {
		// GrupoUsuarioPrivilegio p = new GrupoUsuarioPrivilegio();
		//
		// p.setIdgrupousuario(idgrupo);
		// p.setIdFormulario(getDetalleTM().getValueAt(i, 0).toString());
		// p.setVer(((boolean) getDetalleTM().getValueAt(i, 2)) ? 1 : 0);
		// p.setCrear(((boolean) getDetalleTM().getValueAt(i, 3)) ? 1 : 0);
		// p.setModificar(((boolean) getDetalleTM().getValueAt(i, 4)) ? 1 : 0);
		// p.setEliminar(((boolean) getDetalleTM().getValueAt(i, 5)) ? 1 : 0);
		// privilegios.add(p);
		// }
	};

	@Override
	public void eliminar() {
		if (getGeneracionCodigos() != null) {
			try {
				getGeneracionCodigosDao().borrar(1,getGeneracionCodigos());
			} catch (NisiraORMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// if (getGrupoUsuario() != null) {
		// try {
		// getGrupoUsuarioDao().borrar(getGrupoUsuario());
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
	}

	@Override
	public void llenar_datos() {
		limpiarVista();
		try {
			if (getGeneracionCodigos() != null) {
				txtIdGeneracion.setText(Constantes.llenarCerosDigitosTres(getGeneracionCodigos().getIDGENERACION()));
				txtDescripcion.setText(getGeneracionCodigos().getDESCRIPCION());
				txtTotalDigito.setText(Constantes.llenarCerosDigitosTres(generacionCodigos.getNUMDIGITOTOTAL()));
				txtFecha.setText(generacionCodigos.getFECHACREACION() != null
						? generacionCodigos.getFECHACREACION().toGMTString() : "");
				if (generacionCodigos.getSINCRONIZADO() == null) {
					chkSincronizado.setSelected(false);
				} else {
					chkSincronizado.setSelected(generacionCodigos.getSINCRONIZADO() == 1);
				}
				setListDGeneracionCodigos(dGeneracionCodigosDao.getPorGeneracionCodigo(1, getGeneracionCodigos()));

				for (DGENERACIONCODIGOS dgc : getListDGeneracionCodigos()) {
					boolean sincronizar;
					sincronizar = (dgc.getSINCRONIZADO() == 1);
					getDetalleTM().addRow(new Object[] { dgc.getIDREGISTROCODIGO().toString(), dgc.getPARAMETRO(),
							dgc.getNUMDIGITO().toString(), dgc.getNUMDIGITOTOTAL().toString(),
							dgc.getSINCRONIZADO() == 1 });
				}
			}
			// if (getGrupoUsuario() != null) {
			// txtIdGeneracion.setText(getGrupoUsuario().getIdgrupousuario());
			// txtDescripcion.setText(getGrupoUsuario().getDescripcion());
			// if (generacionCodigos.getSINCRONIZADO() == null) {
			// chkSincronizado.setSelected(false);
			// } else {
			// chkSincronizado.setSelected(generacionCodigos.getSINCRONIZADO()
			// == 1);
			// }
			//
			// setListDGeneracionCodigos(dGeneracionCodigosDao.getPorGeneracionCodigo(getGeneracionCodigos()));
			//
			// for(DGENERACIONCODIGOS dgc: getListDGeneracionCodigos()){
			// boolean sincronizar;
			// sincronizar = (dgc.getSINCRONIZADO()==1);
			// getDetalleTM().addRow(
			// new Object[] {
			// dgc.getIDREGISTROCODIGO().toString(),dgc.getPARAMETRO(),dgc.getNUMDIGITO().toString(),
			// dgc.getNUMDIGITOTOTAL().toString(),dgc.getSINCRONIZADO()==1});
			// }
			// setPrivilegios(privilegioDao.getPorGrupoUsuario(getGrupoUsuario()));
			// for (GrupoUsuarioPrivilegio obj : getPrivilegios()) {
			// boolean ver, crear, modificar, eliminar;
			// ver = (obj.getVer() == 1);
			// crear = (obj.getCrear() == 1);
			// modificar = (obj.getModificar() == 1);
			// eliminar = (obj.getEliminar() == 1);
			// SysFormulario formulario = formularioDao
			// .porClavePrimaria(obj.getIdFormulario());
			// getDetalleTM().addRow(
			// new Object[] { formulario.getIdFormulario(),
			// formulario.getDescripcion(), ver, crear,
			// modificar, eliminar });
			// }
			// }
		} catch (SQLException | NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void llenar_lista() {

		tblLista.setFillsViewportHeight(true);

		MaestroTableModel model = (MaestroTableModel) tblLista.getModel();
		// if(model.getRowCount()<2)
		// model.addColumn("Total");
		model.limpiar();

		for (GENERACIONCODIGOS gc : getListGeneracionCodigos()) {
			model.addRow(new Object[] { gc.getIDGENERACION(), gc.getDESCRIPCION(), gc.getNUMDIGITOTOTAL() });

		}
		if (getListGeneracionCodigos().size() > 0) {
			System.out.println(getListGeneracionCodigos().get(0));
			setGeneracionCodigos(getListGeneracionCodigos().get(0));
			tblLista.setRowSelectionInterval(0, 0);
		}

		// MaestroTableModel model = (MaestroTableModel) tblLista.getModel();
		// model.limpiar();
		// for (GrupoUsuario obj : getGruposUsuario()) {
		// model.addRow(new Object[] { obj.getIdgrupousuario(),
		// obj.getDescripcion() });
		// }
		// if (getGruposUsuario().size() > 0) {
		// setGrupoUsuario(getGruposUsuario().get(0));
		// tblLista.setRowSelectionInterval(0, 0);
		// }
	}

	@Override
	public void llenar_tablas() {
		try {
			setListGeneracionCodigos(getGeneracionCodigosDao().listar(1));
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void vista_edicion() {
		if (getEstado().equals(NUEVO))
			txtIdGeneracion.setEditable(true);
		txtDescripcion.setEditable(true);
		chkSincronizado.setEnabled(true);
		tblLista.setEnabled(false);
		getDetalleTM().setEditar(true);
	}

	@Override
	public void vista_noedicion() {
		txtIdGeneracion.setEditable(false);
		txtDescripcion.setEditable(false);
		chkSincronizado.setEnabled(false);
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
		txtIdGeneracion.setText("");
		txtDescripcion.setText("");
		chkSincronizado.setSelected(false);
	}

	@Override
	public boolean isValidaVista() {
		if (txtIdGeneracion.getText().trim().isEmpty())
			return false;
		if (txtDescripcion.getText().trim().isEmpty())
			return false;
		if (!getDetalleTM().esValido())
			return false;
		return true;
	}

	public NSRTableModel getDetalleTM() {
		return ((NSRTableModel) tblOpciones.getModel());
	}

	public GENERACIONCODIGOS getGeneracionCodigos() {
		return generacionCodigos;
	}

	public void setGeneracionCodigos(GENERACIONCODIGOS generacionCodigos) {
		this.generacionCodigos = generacionCodigos;
	}

	public GENERACIONCODIGOSDao getGeneracionCodigosDao() {
		return generacionCodigosDao;
	}

	public void setGeneracionCodigosDao(GENERACIONCODIGOSDao generacionCodigosDao) {
		this.generacionCodigosDao = generacionCodigosDao;
	}

	public List<GENERACIONCODIGOS> getListGeneracionCodigos() {
		return listGeneracionCodigos;
	}

	public void setListGeneracionCodigos(List<GENERACIONCODIGOS> listGeneracionCodigos) {
		this.listGeneracionCodigos = listGeneracionCodigos;
	}

	public DGENERACIONCODIGOS getdGeneracionCodigos() {
		return dGeneracionCodigos;
	}

	public void setdGeneracionCodigos(DGENERACIONCODIGOS dGeneracionCodigos) {
		this.dGeneracionCodigos = dGeneracionCodigos;
	}

	public DGENERACIONCODIGOSDao getdGeneracionCodigosDao() {
		return dGeneracionCodigosDao;
	}

	public void setdGeneracionCodigosDao(DGENERACIONCODIGOSDao dGeneracionCodigosDao) {
		this.dGeneracionCodigosDao = dGeneracionCodigosDao;
	}

	public List<DGENERACIONCODIGOS> getListDGeneracionCodigos() {
		return listDGeneracionCodigos;
	}

	public void setListDGeneracionCodigos(List<DGENERACIONCODIGOS> listDGeneracionCodigos) {
		this.listDGeneracionCodigos = listDGeneracionCodigos;
	}

	@Override
	public void llenarPorId(Object id) {
		// TODO Auto-generated method stub
		
	}
}