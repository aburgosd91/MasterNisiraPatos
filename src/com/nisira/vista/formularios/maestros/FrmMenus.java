package com.nisira.vista.formularios.maestros;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.nisira.core.NisiraORMException;
import com.nisira.dao.SysFormularioDao;
import com.nisira.dao.SysGrupoDao;
import com.nisira.dao.SysModuloDao;
import com.nisira.dao.SysOpcionDao;
import com.nisira.dao.SysTituloDao;
import com.nisira.entidad.SysFormulario;
import com.nisira.entidad.SysGrupo;
import com.nisira.entidad.SysModulo;
import com.nisira.entidad.SysOpcion;
import com.nisira.entidad.SysTitulo;
import com.nisira.utilitarios.UtilMensajes;
import com.nisira.vista.contenedores.CntSysFormulario;
import com.nisira.vista.controles.JTextFieldLimit;
import com.nisira.vista.utilitarios.FormValidador;

public class FrmMenus extends AbstractMaestro {

	private static final long serialVersionUID = 1L;
	private JFileChooser fc = null;
	private BufferedImage imagen;

	private JTree tree;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JLabel lblDescripcin;
	private JTextField txtDescripcion;
	private JLabel lblImgen;
	private JTextField txtImagen;
	private JLabel lblTamao;
	private JLabel lblFormulario;
	private JComboBox<String> cboTamanio;
	private CntSysFormulario cntSysFormulario;

	private final static int _modulo = 0;
	private final static int _titulo = 1;
	private final static int _grupo = 2;
	private final static int _opcion = 3;

	private SysModuloDao moduloDAO = new SysModuloDao();
	private SysTituloDao tituloDAO = new SysTituloDao();
	private SysGrupoDao grupoDAO = new SysGrupoDao();
	private SysOpcionDao opcionDAO = new SysOpcionDao();
	private SysFormularioDao formularioDAO = new SysFormularioDao();

	private SysModulo sysModulo;
	private SysTitulo sysTitulo;
	private SysGrupo sysGrupo;
	private SysOpcion sysOpcion;

	private int tipo;
	private JButton btnBuscar;
	private JLabel lblOpcion;

	public FrmMenus() {
		super("Menus");

		setSize(664, 433);

		this.tree = new JTree();

		tree.addTreeSelectionListener(new OidSelectionListener());

		this.lblOpcion = new JLabel("C\u00F3digo");
		this.lblOpcion.setFont(new Font("Tahoma", Font.BOLD, 16));

		this.lblCdigo = new JLabel("C\u00F3digo");

		this.txtCodigo = new JTextField();
		this.txtCodigo.setColumns(10);
		this.txtCodigo.setDocument(new JTextFieldLimit(10, true));

		this.lblDescripcin = new JLabel("Descripci\u00F3n");

		this.txtDescripcion = new JTextField();
		this.txtDescripcion.setColumns(10);
		this.txtDescripcion.setDocument(new JTextFieldLimit(50, true));

		this.btnBuscar = new JButton("Buscar");
		this.btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					cargarImagen();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		this.txtImagen = new JTextField();
		this.txtImagen.setColumns(10);
		this.txtImagen.setEditable(false);

		this.lblImgen = new JLabel("Im\u00E1gen");

		this.lblFormulario = new JLabel("Formulario");

		this.cntSysFormulario = new CntSysFormulario();
		try {
			cntSysFormulario.setData(formularioDAO.listar(1));
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.lblTamao = new JLabel("Tama\u00F1o");

		this.cboTamanio = new JComboBox<String>();
		this.cboTamanio.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Grande", "Mediano", "Peque\u00F1o" }));
		GroupLayout groupLayout = new GroupLayout(pnlContenido);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(tree,
												GroupLayout.PREFERRED_SIZE,
												273, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblOpcion,
																GroupLayout.PREFERRED_SIZE,
																341,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblCdigo,
																				GroupLayout.PREFERRED_SIZE,
																				41,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(5)
																		.addComponent(
																				txtCodigo)
																		.addGap(209))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblDescripcin,
																				GroupLayout.PREFERRED_SIZE,
																				71,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(5)
																		.addComponent(
																				txtDescripcion)
																		.addGap(179))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblImgen,
																								GroupLayout.PREFERRED_SIZE,
																								41,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								txtImagen,
																								GroupLayout.DEFAULT_SIZE,
																								225,
																								Short.MAX_VALUE))
																		.addGap(5)
																		.addComponent(
																				btnBuscar,
																				GroupLayout.PREFERRED_SIZE,
																				111,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(69)
																		.addComponent(
																				cntSysFormulario,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addComponent(
																lblFormulario,
																GroupLayout.PREFERRED_SIZE,
																71,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblTamao,
																				GroupLayout.PREFERRED_SIZE,
																				41,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(5)
																		.addComponent(
																				cboTamanio,
																				0,
																				179,
																				Short.MAX_VALUE)
																		.addGap(116)))
										.addGap(18)));
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
																		.addGap(17)
																		.addComponent(
																				lblOpcion)
																		.addGap(5)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(3)
																										.addComponent(
																												lblCdigo))
																						.addComponent(
																								txtCodigo,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(5)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(3)
																										.addComponent(
																												lblDescripcin))
																						.addComponent(
																								txtDescripcion,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(5)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(1)
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																groupLayout
																																		.createSequentialGroup()
																																		.addGap(3)
																																		.addComponent(
																																				lblImgen))
																														.addComponent(
																																txtImagen,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)))
																						.addComponent(
																								btnBuscar))
																		.addGap(39)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								cntSysFormulario,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(4)
																										.addComponent(
																												lblFormulario)))
																		.addGap(5)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblTamao)
																						.addComponent(
																								cboTamanio,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				tree,
																				GroupLayout.DEFAULT_SIZE,
																				338,
																				Short.MAX_VALUE)))
										.addGap(17)));
		pnlContenido.setLayout(groupLayout);

		iniciar();
	}

	@Override
	public void nuevo() {
		tipo++;
		limpiarVista();
		llenarTitulo();
	}

	class OidSelectionListener implements TreeSelectionListener {
		@Override
		public void valueChanged(TreeSelectionEvent e) {
			sysModulo = null;
			sysTitulo = null;
			sysGrupo = null;
			sysOpcion = null;
			limpiarVista();

			TreePath path = e.getPath();
			Object[] nodes = path.getPath();
			int finalPath = nodes.length - 2;
			tipo = nodes.length - 2;
			for (int k = 0; k < nodes.length; k++) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) nodes[k];
				MenuNode nd = (MenuNode) node.getUserObject();

				// Nivel Modulo
				if (nd.getTipo() == _modulo) {
					sysModulo = (SysModulo) nd.getNodo();
				}
				// Nivel Titulo
				if (nd.getTipo() == _titulo) {
					sysTitulo = (SysTitulo) nd.getNodo();
				}

				// Nivel Grupo
				if (nd.getTipo() == _grupo) {
					sysGrupo = (SysGrupo) nd.getNodo();
				}

				// Nivel Opcion
				if (nd.getTipo() == _opcion) {
					sysOpcion = (SysOpcion) nd.getNodo();
				}
			}

			if (finalPath == _modulo) {
				txtCodigo.setText(sysModulo.getIdModulo());
				txtDescripcion.setText(sysModulo.getDescripcion());
				txtImagen.setText(sysModulo.getImagen());
			}

			if (finalPath == _titulo) {
				txtCodigo.setText(sysTitulo.getIdTitulo());
				txtDescripcion.setText(sysTitulo.getDescripcion());
				txtImagen.setText(sysTitulo.getImagen());
			}

			if (finalPath == _grupo) {
				txtCodigo.setText(sysGrupo.getIdGrupo());
				txtDescripcion.setText(sysGrupo.getDescripcion());
				txtImagen.setText(sysGrupo.getImagen());
			}

			if (finalPath == _opcion) {
				cntSysFormulario.setText(sysOpcion.getIdFormulario());
				cntSysFormulario.llenar();
				cboTamanio.setSelectedIndex(sysOpcion.getPrioridad());
			}
			llenarTitulo();
		}

	}

	class MenuNode {
		private String descripcion;
		private int tipo;
		private Object nodo;

		public MenuNode(String descripcion, int tipo, Object nodo) {
			this.descripcion = descripcion;
			this.tipo = tipo;
			this.nodo = nodo;
		}

		@Override
		public String toString() {
			return descripcion;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public int getTipo() {
			return tipo;
		}

		public void setTipo(int tipo) {
			this.tipo = tipo;
		}

		public Object getNodo() {
			return nodo;
		}

		public void setNodo(Object nodo) {
			this.nodo = nodo;
		}

	}

	@Override
	public void anular() {
		// TODO Auto-generated method stub

	}

	@Override
	public void grabar() {
		try {
			if (this.tipo == _modulo) {
				grabar_modulo();
			}

			if (this.tipo == _titulo) {
				grabar_titulo();
			}

			if (this.tipo == _grupo) {
				grabar_grupo();
			}

			if (this.tipo == _opcion) {
				grabar_opcion();
			}
		} catch (SQLException | NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void grabar_modulo() throws SQLException, NisiraORMException {
		String idmodulo, descripcion, imagen;
		idmodulo = this.txtCodigo.getText();
		descripcion = this.txtDescripcion.getText();
		imagen = this.txtImagen.getText();
		SysModulo m = new SysModulo();
		m.setIdModulo(idmodulo);
		m.setDescripcion(descripcion);
		m.setImagen(imagen);
		moduloDAO.mezclar(1,m);
	}

	private void grabar_titulo() throws SQLException, NisiraORMException {
		String idtitulo, descripcion, imagen;
		idtitulo = this.txtCodigo.getText();
		descripcion = this.txtDescripcion.getText();
		imagen = this.txtImagen.getText();

		SysTitulo t = new SysTitulo();

		t.setIdModulo(sysModulo.getIdModulo());
		t.setIdTitulo(idtitulo);
		t.setDescripcion(descripcion);
		t.setImagen(imagen);

		tituloDAO.mezclar(1,t);
	}

	private void grabar_grupo() throws SQLException, NisiraORMException {
		String idgrupo, descripcion, imagen;

		idgrupo = this.txtCodigo.getText();
		descripcion = this.txtDescripcion.getText();
		imagen = this.txtImagen.getText();
		SysGrupo g = new SysGrupo();

		g.setIdModulo(sysModulo.getIdModulo());
		g.setIdTitulo(sysTitulo.getIdTitulo());
		g.setIdGrupo(idgrupo);

		g.setDescripcion(descripcion);
		g.setImagen(imagen);

		grupoDAO.mezclar(1,g);
	}

	private void grabar_opcion() throws SQLException, NisiraORMException {
		String idformulario;

		idformulario = cntSysFormulario.getSeleccionado().getIdFormulario();

		SysOpcion o = new SysOpcion();

		o.setIdModulo(sysModulo.getIdModulo());
		o.setIdTitulo(sysTitulo.getIdTitulo());
		o.setIdGrupo(sysGrupo.getIdGrupo());
		o.setIdFormulario(idformulario);
		o.setPrioridad(cboTamanio.getSelectedIndex());

		opcionDAO.mezclar(1,o);
	}

	@Override
	public void eliminar() {
		try {
			if (tipo == 3) {
				opcionDAO.borrar(1,sysOpcion);

			}

			if (tipo == 2) {
				for (SysOpcion so : opcionDAO.getPorGrupo(sysGrupo)) {
					opcionDAO.borrar(1,so);
				}
				grupoDAO.borrar(1,sysGrupo);
			}

			if (tipo == 1) {
				for (SysGrupo sg : grupoDAO.getPorTitulo(1,sysTitulo)) {
					for (SysOpcion so : opcionDAO.getPorGrupo(sg)) {
						opcionDAO.borrar(1,so);
					}
					grupoDAO.borrar(1,sg);
				}
				tituloDAO.borrar(1,sysTitulo);
			}

			if (tipo == 0) {
				for (SysTitulo st : tituloDAO.getPorModulo(1,sysModulo)) {
					for (SysGrupo sg : grupoDAO.getPorTitulo(1,st)) {
						for (SysOpcion so : opcionDAO.getPorGrupo(sg)) {
							opcionDAO.borrar(1,so);
						}
						grupoDAO.borrar(1,sg);
					}
					tituloDAO.borrar(1,st);
				}
				moduloDAO.borrar(1,sysModulo);
			}
		} catch (SQLException | NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sysModulo = null;
		sysTitulo = null;
		sysGrupo = null;
		sysOpcion = null;
	}

	@Override
	public void llenar_datos() {
		// TODO Auto-generated method stub

	}

	@Override
	public void llenar_lista() {
		System.out.println("Llenar");
		try {
			DefaultMutableTreeNode inicio = new DefaultMutableTreeNode(
					new MenuNode("Nisira", -1, null));
			DefaultTreeModel modelo = new DefaultTreeModel(inicio);

			List<SysModulo> modulos;

			modulos = moduloDAO.listar(1);

			for (SysModulo modulo : modulos) {
				DefaultMutableTreeNode mNode = new DefaultMutableTreeNode(
						new MenuNode(modulo.getIdModulo() + " - "
								+ modulo.getDescripcion(), _modulo, modulo));
				modelo.insertNodeInto(mNode, inicio, inicio.getChildCount());
				// tituos
				List<SysTitulo> titulos = tituloDAO.getPorModulo(1,modulo);
				for (SysTitulo titulo : titulos) {
					DefaultMutableTreeNode mNodeT = new DefaultMutableTreeNode(
							new MenuNode(titulo.getIdTitulo() + " - "
									+ titulo.getDescripcion(), _titulo, titulo));
					modelo.insertNodeInto(mNodeT, mNode, mNode.getChildCount());

					// grupos

					List<SysGrupo> grupos = grupoDAO.getPorTitulo(1,titulo);
					for (SysGrupo grupo : grupos) {
						DefaultMutableTreeNode mNodeG = new DefaultMutableTreeNode(
								new MenuNode(grupo.getIdGrupo() + " - "
										+ grupo.getDescripcion(), _grupo, grupo));
						modelo.insertNodeInto(mNodeG, mNodeT,
								mNodeT.getChildCount());

						// Opciones
						List<SysOpcion> opciones = opcionDAO.getPorGrupo(grupo);
						for (SysOpcion opcion : opciones) {
							SysFormulario formulario = formularioDAO
									.porClavePrimaria(1,opcion.getIdFormulario());
							DefaultMutableTreeNode mNodeO = new DefaultMutableTreeNode(
									new MenuNode(opcion.getIdFormulario()
											+ " - "
											+ formulario.getDescripcion(),
											_opcion, opcion));
							modelo.insertNodeInto(mNodeO, mNodeG,
									mNodeG.getChildCount());
						}
					}
				}
			}

			tree.setModel(modelo);
		} catch (SQLException | NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void llenar_tablas() {
		// TODO Auto-generated method stub

	}

	@Override
	public void vista_edicion() {

		if (tipo == 3) {
			FormValidador.CntEdicion(true, cntSysFormulario);
			cboTamanio.setEnabled(true);
		} else {
			if (getEstado().equals(NUEVO))
				FormValidador.TextFieldsEdicion(true, txtCodigo);
			FormValidador.TextFieldsEdicion(true, txtDescripcion);
			btnBuscar.setEnabled(true);
		}
		tree.setEnabled(false);
	}

	@Override
	public void vista_noedicion() {
		FormValidador.TextFieldsEdicion(false, txtCodigo, txtDescripcion);
		FormValidador.CntEdicion(false, cntSysFormulario);
		cboTamanio.setEnabled(false);
		btnBuscar.setEnabled(false);
		tree.setEnabled(true);
	}

	@Override
	public void llenarDesdeVista() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValidaVista() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void limpiarVista() {
		txtCodigo.setText("");
		txtDescripcion.setText("");
		cntSysFormulario.setText("");
		cntSysFormulario.llenar();
		cboTamanio.setSelectedIndex(-1);
	}

	@SuppressWarnings("deprecation")
	public void cargarImagen() throws IOException {

		fc = new JFileChooser();

		int r = fc.showOpenDialog(null);

		if (r == JFileChooser.APPROVE_OPTION) {
			imagen = ImageIO.read(fc.getSelectedFile().toURL());

			String url = CargarURL(fc.getSelectedFile().toURL().toString());
			String extension = url.substring(url.length() - 3).trim();

			if (extension.equals("jpg") || extension.equals("png")) {
				txtImagen.setText(url);
			} else {
				fc = null;
				UtilMensajes.mensaje_error("IMAGEN_ERROR");
			}
		}
	}

	public void guardarImg() throws MalformedURLException, IOException {

		@SuppressWarnings("deprecation")
		String url = CargarURL(fc.getSelectedFile().toURL().toString());
		String extension = url.substring(url.length() - 3);

		ImageIO.write(imagen, extension, new File("src//main/resources/iconos/"
				+ url));

	}

	private void llenarTitulo() {
		if (getEstado().equals(NUEVO)) {
			switch (this.tipo) {
			case _modulo:
				lblOpcion.setText("NUEVO MÓDULO");
				break;

			case _titulo:
				lblOpcion.setText("NUEVO TITULO");
				break;
			case _grupo:
				lblOpcion.setText("NUEVO GRUPO");
				break;
			case _opcion:
				lblOpcion.setText("NUEVA OPCIÓN");
				break;
			}
		} else {
			switch (this.tipo) {
			case _modulo:
				lblOpcion
						.setText("MÓDULO: ".concat(sysModulo.getDescripcion()));
				break;

			case _titulo:
				lblOpcion
						.setText("TITULO: ".concat(sysTitulo.getDescripcion()));
				break;
			case _grupo:
				lblOpcion.setText("GRUPO: ".concat(sysGrupo.getDescripcion()));
				break;
			case _opcion:
				// SysFormulario f = formularioDAO.find(sysOpcion.getId()
				// .getIdformulario());
				// lblOpcion.setText("OPCIÓN: ".concat(f.getDescripcion()));
				break;
			}
		}
	}

	public static String CargarURL(String url) {
		for (int i = url.length() - 1; i <= url.length(); i--) {
			if (url.charAt(i) == '/') {
				url = url.substring(i + 1, url.length());
				break;
			}
		}

		return url;
	}

	@Override
	public void llenarPorId(Object id) {
		// TODO Auto-generated method stub
		
	}
}