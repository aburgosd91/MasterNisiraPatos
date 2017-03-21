package com.nisira.vista.formularios;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.nisira.core.NisiraORMException;
import com.nisira.dao.DGENERACIONCODIGOSDao;
import com.nisira.dao.DPACKINGLISTDao;
import com.nisira.dao.GENERACIONCODIGOSDao;
import com.nisira.dao.MOTIVODao;
import com.nisira.dao.PACKINGLISTDao;
import com.nisira.dao.PARAMETROSDao;
import com.nisira.dao.PUERTOSDESTINODao;
import com.nisira.dao.RESPONSABLEDao;
import com.nisira.entidad.DGENERACIONCODIGOS;
import com.nisira.entidad.DPACKINGLIST;
import com.nisira.entidad.DZONAGENERAL;
import com.nisira.entidad.GENERACIONCODIGOS;
import com.nisira.entidad.MOTIVO;
import com.nisira.entidad.PACKINGLIST;
import com.nisira.entidad.PARAMETROS;
import com.nisira.entidad.PUERTOSDESTINO;
import com.nisira.entidad.RESPONSABLE;
import com.nisira.utils.nisiracore.Constantes;
import com.nisira.vista.celleditor.TxtSysFormulario;
import com.nisira.vista.controles.MaestroTableModel;
import com.nisira.vista.controles.NSRTable;
import com.nisira.vista.controles.NSRTableModel;
import com.nisira.vista.formularios.FrmSysZona.BarcodeTexto;
import com.nisira.vista.formularios.FrmSysZona.EjecutarBarcode;
import com.nisira.vista.formularios.FrmSysZona.EliminarBarcode;
import com.nisira.vista.formularios.maestros.AbstractMaestro;
import com.nisira.vista.utilitarios.JTableUtils;
import test.GeneracionCodigoXml;
import core.inicio.ConfigInicial;

public class FrmPackingList extends AbstractMaestro {
	private static final long serialVersionUID = 1L;
	private PACKINGLIST pack = new PACKINGLIST();
	private PACKINGLISTDao packdao = new PACKINGLISTDao();
	private List<PACKINGLIST> lpack = new ArrayList<PACKINGLIST>();

	private DPACKINGLIST dpack = new DPACKINGLIST();
	private DPACKINGLISTDao dpackdao = new DPACKINGLISTDao();
	private List<DPACKINGLIST> ldpack = new ArrayList<DPACKINGLIST>();

	private RESPONSABLE op = new RESPONSABLE();
	private RESPONSABLEDao respdao = new RESPONSABLEDao();

	private MOTIVO mot = new MOTIVO();
	private MOTIVODao motdao = new MOTIVODao();

	private PARAMETROS par = new PARAMETROS();
	private List<PARAMETROS> lpar = new ArrayList<PARAMETROS>();
	private PARAMETROSDao pardao = new PARAMETROSDao();

	private PUERTOSDESTINO puer = new PUERTOSDESTINO();
	private PUERTOSDESTINODao puerdao = new PUERTOSDESTINODao();

	private JTable tblLista;
	private NSRTable tblOpciones;
	private TxtSysFormulario txtFormulario;
	private Map<String,String> mapaGen;
	JScrollPane scrollPane2 = new JScrollPane();
	private JLabel lblIngreseOpciones;
	private JTextField txtCodPack;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel lblCodDocumento;
	private JTextField txtIddoc;
	private JLabel lblSerie;
	private JTextField txtSerie;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JLabel lblNewLabel;
	private JTextField txtCliente;
	private JLabel lblMotivo;
	private JTextField textMotivo;
	private JLabel lblPuertoDestino;
	private JTextField txtPuerto;
	public Thread hilo;
	public final String hiloUbicacion = "threadAlertaUbicacion";
	public final String hiloUbicacionToca = "threadAlertaUbicacionToca";
	public final int timer=500;
	public Process process;
	private List<GENERACIONCODIGOS> listGeneracionCodigo;
	public void cargarDatos(){
		try {
			listGeneracionCodigo =(new GENERACIONCODIGOSDao()).listar(1,"IDEMPRESA=? AND PARAMETRO=? AND ESTADO=?",ConfigInicial.LlenarConfig()[8],"FrmPackingList",1);
			/*RECONSTRUCCIÓN DE XML*/
			if(listGeneracionCodigo.size()>0)
				GeneracionCodigoXml.reconstruccionXML(listGeneracionCodigo);
		} catch (SQLException | NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public FrmPackingList() {
		super("Packing List");
		setPreferredSize(new Dimension(555, 425));
		setSize(new Dimension(1148, 590));

		getBarra().setFormMaestro(this);

		JButton btnSincronizar = new JButton("Sincronizar");
		btnSincronizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					for (PACKINGLIST pK : getLpack()) {
						List<DPACKINGLIST> tempL = new ArrayList<DPACKINGLIST>();
						tempL = dpackdao.getPorGeneracionCodigo(1, pK);
						packdao.mezclar(2,pK);
						for (DPACKINGLIST dgc : tempL) {
							dpackdao.mezclar(2,dgc);

						}
					}
				} catch (SQLException | NisiraORMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		getBarra().add(btnSincronizar);
		mapaGen = new HashMap<String, String>();
		JScrollPane scrollPane = new JScrollPane();
		Field[] fi = PACKINGLIST.class.getDeclaredFields();
		tblLista = new JTable(new MaestroTableModel(fi));
		scrollPane.setViewportView(tblLista);
		tblLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tblOpciones = new NSRTable(new NSRTableModel(
				new String[] { "IDEMPRESA", "IDSUCURSAL", "IDPACKING", "ITEM", "NROPALETA", "IDPRODUCTO", "DESCRIPCION",
						"IDLOTEP", "IDMEDIDA", "IDTALLA", "CANTIDAD", "PESO", "PERSOTARA" }) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean evaluaEdicion(int row, int column) {
				if (column <4)
					return false;
				return getEditar();
			}

			@Override
			public void addRow() {
					// ina
			}

			@Override
			public Class<?> getColumnClass(int column) {
				// TODO Auto-generated method stub
				return super.getColumnClass(column);
			}
			
			@Override
			protected void refrescarRowHeader() {
				if (getScrollPane() != null && getTable() != null) {
					getScrollPane().setRowHeaderView(
							JTableUtils.buildRowHeader(getTable(), this));
					JButton boton;
					getScrollPane().setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER,
							boton = new JButton() {
								private static final long serialVersionUID = 1L;

								{

									addActionListener(new ActionListener() {
										@Override
										public void actionPerformed(ActionEvent e) {
											if (getEditar() && isValidaAgregar()){
												EjecutarBar();
												addRow();
											}												
										}
									});
								}
							});
					boton.setIcon(new ImageIcon(new ImageIcon(NSRTableModel.class
							.getResource("/resources/mas.png")).getImage()
							.getScaledInstance(12, 12, java.awt.Image.SCALE_DEFAULT)));

					InputMap inputMap = getTable().getInputMap(
							JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
					//inputMap.put(insertarKey, "insertar");
					//inputMap.put(borrarKey, "borrar");

					getTable().getActionMap().put("insertar", new AbstractAction() {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						@Override
						public void actionPerformed(ActionEvent evt) {
							if (getEditar())
								addRow();
						}
					});

					getTable().getActionMap().put("borrar", new AbstractAction() {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						@Override
						public void actionPerformed(ActionEvent evt) {
							int row = getTable().getSelectedRow();
							if (getEditar() && row > -1)
								remRow(row);
						}
					});

				}
			}

		});
		// tblOpciones.setTreeTableModel(mttm);
		tblOpciones.setFillsViewportHeight(true);
		scrollPane2.setViewportView(tblOpciones);
		tblOpciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		getDetalleTM().setNombre_detalle("Detalle PackingList Formulario");

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

		JLabel lblCodPacking = new JLabel("Cod Packing");

		txtCodPack = new JTextField();
		txtCodPack.setEditable(false);
		txtCodPack.setColumns(10);

		lblFecha = new JLabel("Fecha");

		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);

		lblCodDocumento = new JLabel("Cod Documento");

		txtIddoc = new JTextField();
		txtIddoc.setEditable(false);
		txtIddoc.setColumns(10);

		lblSerie = new JLabel("Serie");

		txtSerie = new JTextField();
		txtSerie.setEditable(false);
		txtSerie.setColumns(10);

		lblNumero = new JLabel("Numero");

		txtNumero = new JTextField();
		txtNumero.setEditable(false);
		txtNumero.setColumns(10);

		lblNewLabel = new JLabel("Cod Cliente");

		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setColumns(10);

		lblMotivo = new JLabel("Motivo");

		textMotivo = new JTextField();
		textMotivo.setEditable(false);
		textMotivo.setColumns(10);

		lblPuertoDestino = new JLabel("Puerto Destino");

		txtPuerto = new JTextField();
		txtPuerto.setEditable(false);
		txtPuerto.setColumns(10);
		
		JButton btnCapturarDpacking = new JButton("Capturar DPacking");
		btnCapturarDpacking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EjecutarBar();
			}
		});
		GroupLayout groupLayout = new GroupLayout(pnlContenido);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCodPacking)
								.addComponent(lblFecha)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtCodPack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblCodDocumento))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textMotivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(lblPuertoDestino))
								.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblMotivo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtIddoc, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblSerie)
							.addGap(17)
							.addComponent(txtSerie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNumero)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtPuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnCapturarDpacking, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(409, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(lblIngreseOpciones, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 1112, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1112, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCodPacking)
							.addComponent(txtCodPack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCodDocumento)
							.addComponent(txtIddoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblSerie)
							.addComponent(txtSerie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNumero)
							.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFecha)
								.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(txtCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMotivo)
								.addComponent(textMotivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPuertoDestino)
								.addComponent(txtPuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblIngreseOpciones))
						.addComponent(btnCapturarDpacking, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
		);
		pnlContenido.setLayout(groupLayout);

		tblLista.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tblLista.getSelectedRow();
				if (selectedRow >= 0)
					setPack(getLpack().get(selectedRow));
				// setGrupoUsuario(getGruposUsuario().get(selectedRow));
				else
					setPack(null);
				// setGrupoUsuario(null);
				llenar_datos();
			}
		});
		iniciar();
		// getDetalleTM().setEditar(true);

	}

	public NSRTableModel getDetalleTM() {
		return ((NSRTableModel) tblOpciones.getModel());
	}

	@Override
	public void nuevo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void anular() {
		// TODO Auto-generated method stub

	}

	@Override
	public void grabar() {
		try {
			packdao.mezclar(1,getPack());
			for (DPACKINGLIST dgc : getLdpack()) {
				dpackdao.mezclar(1,dgc);
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
	public void eliminar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void llenar_datos() {
		limpiarVista();
		try {
			if (getPack() != null) {
				txtCodPack.setText(String.valueOf(getPack().getIDPACKING()));
				txtFecha.setText(getPack().getFECHA().toGMTString());
				txtIddoc.setText(String.valueOf(getPack().getIDDOCUMENTO()));
				txtSerie.setText(String.valueOf(getPack().getSERIE()));
				txtNumero.setText(String.valueOf(getPack().getNUMERO()));
				txtCliente.setText(String.valueOf(getPack().getIDCLIENTE()));
				textMotivo.setText(String.valueOf(getPack().getIDMOTIVO()));
				txtPuerto.setText(String.valueOf(getPack().getIDPUERTODESTINO()));

				setLdpack(dpackdao.getPorGeneracionCodigo(1, getPack()));

				for (DPACKINGLIST dgc : getLdpack()) {
					getDetalleTM().addRow(new Object[] { dgc.getIDEMPRESA(), dgc.getIDSUCURSAL(), dgc.getIDPACKING(),
							dgc.getITEM(), dgc.getNROPALETA(), dgc.getIDPRODUCTO(), dgc.getDESCRIPCION(),
							dgc.getIDLOTEP(), dgc.getIDMEDIDA(), dgc.getIDTALLA(), dgc.getCANTIDAD(), dgc.getPESO(),
							dgc.getPERSOTARA() });
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
		for (PACKINGLIST pl : getLpack()) {
			model.addRow(new Object[] { pl.getIDEMPRESA(), pl.getIDSUCURSAL(), pl.getIDPACKING(), pl.getFECHA(),
					pl.getCONTENEDOR(), pl.getIDDOCUMENTO(), pl.getSERIE(), pl.getNUMERO(), pl.getIDRESPONSABLE(),
					pl.getESTADO() == 1 ? "Activo" : "Inactivo", pl.getIDPUERTODESTINO(), pl.getIDMOTIVO(),
					pl.getIDCLIENTE(), pl.getFECHACREACION() });
		}
		if (getLpack().size() > 0) {
			System.out.println(getLpack().get(0));
			setPack(getLpack().get(0));
			tblLista.setRowSelectionInterval(0, 0);
		}
	}

	@Override
	public void llenar_tablas() {
		try {
			setLpack(packdao.listar(1));
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void vista_edicion() {
		getDetalleTM().setEditar(true);

	}

	@Override
	public void vista_noedicion() {
		tblLista.setEnabled(true);
		getDetalleTM().setEditar(false);

	}

	@Override
	public void llenarDesdeVista() {
		ldpack = new ArrayList<DPACKINGLIST>();
		int rows = tblOpciones.getRowCount();
		for (int i = 0; i < rows; i++) {
			DPACKINGLIST dpacking = new DPACKINGLIST();
			dpacking.setIDEMPRESA(Integer.valueOf(getDetalleTM().getValueAt(i, 0).toString()));
			dpacking.setIDSUCURSAL(Integer.valueOf(getDetalleTM().getValueAt(i, 1).toString()));
			dpacking.setIDPACKING(Integer.valueOf(getDetalleTM().getValueAt(i, 2).toString()));
			dpacking.setITEM(Integer.valueOf(getDetalleTM().getValueAt(i, 3).toString()));
			dpacking.setNROPALETA(getDetalleTM().getValueAt(i, 4).toString());
			dpacking.setIDPRODUCTO(getDetalleTM().getValueAt(i, 5).toString());
			dpacking.setDESCRIPCION(getDetalleTM().getValueAt(i, 6).toString());
			dpacking.setIDLOTEP(getDetalleTM().getValueAt(i, 7).toString());
			dpacking.setIDMEDIDA(getDetalleTM().getValueAt(i, 8).toString());
			dpacking.setIDTALLA(getDetalleTM().getValueAt(i, 9).toString());
			dpacking.setCANTIDAD(Double.valueOf(getDetalleTM().getValueAt(i, 10).toString()));
			dpacking.setPESO(Double.valueOf(getDetalleTM().getValueAt(i, 11).toString()));
			dpacking.setPERSOTARA(Double.valueOf(getDetalleTM().getValueAt(i, 12).toString()));
			// dGeneracionCodigos.setIDGENERACION(getPack().getIDGENERACION());
			// dGeneracionCodigos.setIDREGISTROCODIGO(Integer.parseInt(getDetalleTM().getValueAt(i,
			// 0).toString()));
			// dGeneracionCodigos.setPARAMETRO(getDetalleTM().getValueAt(i,
			// 1).toString());
			// dGeneracionCodigos.setNUMDIGITO(Integer.parseInt(getDetalleTM().getValueAt(i,
			// 2).toString()));
			// dGeneracionCodigos.setNUMDIGITOTOTAL(Integer.parseInt(getDetalleTM().getValueAt(i,
			// 3).toString()));
			// dGeneracionCodigos.setSINCRONIZADO(((boolean)
			// getDetalleTM().getValueAt(i, 4)) ? 1 : 0);
			ldpack.add(dpacking);
		}
	}

	@Override
	public void limpiarDetalle() {
		getDetalleTM().limpiar();
	}

	@Override
	public void limpiarVista() {
		getDetalleTM().limpiar();
		txtCodPack.setText("");
		txtFecha.setText("");
		txtIddoc.setText("");
		txtSerie.setText("");
		txtNumero.setText("");
		txtCliente.setText("");
		textMotivo.setText("");
		txtPuerto.setText("");

	}

	@Override
	public boolean isValidaVista() {
		return true;
	}
	//nuevo codigo
	private void EjecutarBar() {
		EjecutarBarcode ej = new EjecutarBarcode(process,(NSRTableModel) tblOpciones.getModel());
        new Thread(ej).start();
//        new Thread(ej).wait(timeout);
    }
    private void EliminarBar() {
    	EliminarBarcode el = new EliminarBarcode(process);
        new Thread(el).start();

    }
    class EliminarBarcode implements Runnable {
        public Process process;

        public EliminarBarcode(Process process) {
            this.process = process;
        }
        
        @Override
        public void run() {
            String archivo="WindowsApplication.exe";
            try{
                  Runtime.getRuntime().exec("TASKKILL /F /IM "+archivo);
            }
            catch(Exception e){
            	System.out.println(e.getMessage());
            }
        }
    }
    class EjecutarBarcode implements Runnable {
        public Process process;
        private NSRTableModel tabla;
        public EjecutarBarcode(Process process, NSRTableModel tabla) {
            this.process = process;
            this.tabla=tabla;
        }
        @Override
        public void run() {
                String archivo=ConfigInicial.LlenarConfig()[10]; //Ruta_Proyecto HALCON 12
            try{
            	String console="";
                process = Runtime.getRuntime().exec(archivo);
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    console+=line;
                }
//                CARGARCODIGO(console,"@~", "~@");
                CARGARCODIGO(console,ConfigInicial.LlenarConfig()[11], ConfigInicial.LlenarConfig()[12],tabla);
                reader.close();
            }
            catch(Exception e){
            	System.out.println(e.getMessage());
            }
        }
    }
    public void CARGARCODIGO(String console,String charI,String charF,NSRTableModel t){
		//List<GENERACIONCODIGOS> listGeneracionCodigo =new ArrayList<GENERACIONCODIGOS>();
		List<DGENERACIONCODIGOS> listDGeneracionCodigo =new ArrayList<DGENERACIONCODIGOS>();
		Map<String,String> mapa;
		int j=0;
		String codigo="";
		/*LIMPIAR PANEL*/
		try{
			//listGeneracionCodigo 	=	(new GENERACIONCODIGOSDao()).listar(1,"IDEMPRESA = ? and PARAMETRO = ?",ConfigInicial.LlenarConfig()[8].toString(),"FrmPackingList");
//			listDGeneracionCodigo 	=	(new DGENERACIONCODIGOSDao()).listar();
			/*****************************TRAER DATOS DE CONSOLE*************************/
			ArrayList<String> listcodigo=new ArrayList<String>();
			for(int x=1;x<=listGeneracionCodigo.size();x++){
				listcodigo.add(codigo=Constantes.buscarFragmentoTexto(console,charI,charF,x));
			}
			/**************************RECORRER CABECERA********************************/
			for(GENERACIONCODIGOS gc : listGeneracionCodigo){
				mapa= new HashMap<String,String>();
				listDGeneracionCodigo 	=	(new DGENERACIONCODIGOSDao()).listar(1,"IDEMPRESA = ? and IDGENERACION = ?",gc.getIDEMPRESA(),gc.getIDGENERACION());
				/*BUSCAR CÓDIGO CON LONGITUD REQUERIDA*/
				codigo=buscarCadenaxLongitud(listcodigo,gc.getNUMDIGITOTOTAL());
				j=0;
				for(DGENERACIONCODIGOS dgc : listDGeneracionCodigo){
					mapa.put(dgc.getPARAMETRO(), codigo.substring(j,j+dgc.getNUMDIGITO()));
					j+=dgc.getNUMDIGITO();
				}
				/**********************************LLENAR DATOS**************************************/
				mapaGen = mapa;
				t.addRow(new Object[] { getPack().getIDEMPRESA(), getPack().getIDSUCURSAL(), getPack().getIDPACKING(),
						getDetalleTM().getRowCount() + 1, mapaGen.get("NROPALETA"),mapaGen.get("IDPRODCUTO"), "",mapaGen.get("IDLOTEP"), "", "", 0.0, 0.0, 0.0 });
					mapaGen = new HashMap<String,String>();
			}
		}catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			Constantes.log.warn(e.getMessage());
			e.printStackTrace();
		}
	}
    public List<DPACKINGLIST> generarListaDP(Map<String,String> claveValor){
    	
		return ldpack;    	
    }
    class BarcodeTexto extends JLabel{
    	private static final long serialVersionUID = 1L;
    	public BarcodeTexto(Map<String,String> claveValor){
//    		super(parametrosHtml(claveValor));
    		this.setText("<html><p style=\"line-height: 150%;font-size:20;\">"+parametrosHtml(claveValor)+"</p></html>");
    		this.setVisible(true);
    		this.setSize(60, 200);
    		this.setFont(new Font(null, Font.PLAIN, 12));
//	        this.setOpaque(true);
//	        this.setForeground(Color.BLACK);
//	        this.setFont(new Font("Tahoma", Font.PLAIN, 12));
    		//this.name =new JLabel(name);
    	}
    }
    public String buscarCadenaxLongitud(ArrayList<String> lista,int tamanio){
		String cadena="";
		for(String str : lista){
			if(str.length()==tamanio){
				cadena=str;
				break;
			}
		}
		return cadena;
	}
    public String parametrosHtml(Map<String,String> claveValor){
    	String html="";
    	Iterator it = claveValor.entrySet().iterator();
    	Map.Entry e;
		while(it.hasNext()) {
			e = (Map.Entry)it.next();
			html+=Constantes.claveValorHtml(e.getKey().toString(),e.getValue().toString());
			System.out.println(e.getKey() + " " + e.getValue());
		}
    	return html;
    }
    //fin del nuevo codigo
	public PACKINGLIST getPack() {
		return pack;
	}

	public void setPack(PACKINGLIST pack) {
		this.pack = pack;
	}

	public List<PACKINGLIST> getLpack() {
		return lpack;
	}

	public void setLpack(List<PACKINGLIST> lpack) {
		this.lpack = lpack;
	}

	public DPACKINGLIST getDpack() {
		return dpack;
	}

	public void setDpack(DPACKINGLIST dpack) {
		this.dpack = dpack;
	}

	public List<DPACKINGLIST> getLdpack() {
		return ldpack;
	}

	public void setLdpack(List<DPACKINGLIST> ldpack) {
		this.ldpack = ldpack;
	}

	public RESPONSABLE getOp() {
		return op;
	}

	public void setOp(RESPONSABLE op) {
		this.op = op;
	}

	public RESPONSABLEDao getRespdao() {
		return respdao;
	}

	public void setRespdao(RESPONSABLEDao respdao) {
		this.respdao = respdao;
	}

	public MOTIVO getMot() {
		return mot;
	}

	public void setMot(MOTIVO mot) {
		this.mot = mot;
	}

	public PARAMETROS getPar() {
		return par;
	}

	public void setPar(PARAMETROS par) {
		this.par = par;
	}

	public List<PARAMETROS> getLpar() {
		return lpar;
	}

	public void setLpar(List<PARAMETROS> lpar) {
		this.lpar = lpar;
	}

	public PUERTOSDESTINO getPuer() {
		return puer;
	}

	public void setPuer(PUERTOSDESTINO puer) {
		this.puer = puer;
	}
	@Override
	public void llenarPorId(Object id) {
		// TODO Auto-generated method stub
		
	}
}
