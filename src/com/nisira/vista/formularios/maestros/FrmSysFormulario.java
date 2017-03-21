package com.nisira.vista.formularios.maestros;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.nisira.core.NisiraORMException;
import com.nisira.dao.SysFormularioDao;
import com.nisira.entidad.SysFormulario;
import com.nisira.utilitarios.UtilMensajes;
import com.nisira.vista.barras.PanelBarraMaestro;
import com.nisira.vista.controles.JTextFieldLimit;
import com.nisira.vista.controles.MaestroTableModel;
import com.nisira.vista.utilitarios.FormValidador;

public class FrmSysFormulario extends AbstractMaestro {

	private static final long serialVersionUID = 1L;
	
	private SysFormulario formulario;
	
	private SysFormularioDao formularioDAO = new SysFormularioDao();
	
	private List<SysFormulario> formularios = new ArrayList<SysFormulario>();
	
	private JFileChooser fc = null;
	private BufferedImage imagen;
	
	private JTable tblLista;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JLabel lblOpcin;
	private JTextField txtPaquete;
	private JLabel lblImgen;
	private JTextField txtImagen;
	private JButton btnImg = new JButton("");
	private JLabel lblClase;
	private JTextField txtClase;
	private JCheckBox chkEsLista;
	private JLabel lblPaqueteDoc;
	private JTextField txtPaqueteDoc;
	private JTextField txtClaseDoc;
	private JLabel lblClaseDoc;
	private JLabel lblDetalleDeDocumento;
	private JButton btnActualizar;

	public FrmSysFormulario() {
		super("Formularios");
		
		setSize(new Dimension(600, 375));

		JLabel lblCdigo = new JLabel("C\u00F3digo");

		txtCodigo = new JTextField();
		this.txtCodigo.setName("C\u00F3digo");
		txtCodigo.setColumns(10);
		txtCodigo.setDocument(new JTextFieldLimit(50, true));

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");

		JScrollPane scrollPane = new JScrollPane();

		tblLista = new JTable(new MaestroTableModel());
		scrollPane.setViewportView(tblLista);
		tblLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		txtDescripcion = new JTextField();
		this.txtDescripcion.setName("Descripci\u00F3n");
		txtDescripcion.setColumns(200);
		txtDescripcion.setDocument(new JTextFieldLimit(75, false));

		this.lblOpcin = new JLabel("Paquete");

		this.txtPaquete = new JTextField();
		this.txtPaquete.setName("Descripci\u00F3n");
		this.txtPaquete.setColumns(10);

		this.lblImgen = new JLabel("Imagen");

		this.txtImagen = new JTextField();
		this.txtImagen.setName("Descripci\u00F3n");
		this.txtImagen.setColumns(10);

		btnImg.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
				.getResource("/resources/find.png")).getImage()
				.getScaledInstance(18, 18, java.awt.Image.SCALE_DEFAULT)));

		btnImg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					cargarImagen();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		this.lblClase = new JLabel("Clase");

		this.txtClase = new JTextField();
		this.txtClase.setName("Clase");
		this.txtClase.setColumns(10);

		this.chkEsLista = new JCheckBox("Es lista");
		this.chkEsLista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chkEsLista.isSelected()) {
					lblDetalleDeDocumento.setVisible(true);
					txtPaqueteDoc.setVisible(true);
					txtClaseDoc.setVisible(true);
					lblPaqueteDoc.setVisible(true);
					lblClaseDoc.setVisible(true);
				} else {
					lblDetalleDeDocumento.setVisible(false);
					txtPaqueteDoc.setVisible(false);
					txtClaseDoc.setVisible(false);
					lblPaqueteDoc.setVisible(false);
					lblClaseDoc.setVisible(false);
				}
			}
		});

		this.lblPaqueteDoc = new JLabel("Paquete");

		this.txtPaqueteDoc = new JTextField();
		this.txtPaqueteDoc.setName("Descripci\u00F3n");
		this.txtPaqueteDoc.setColumns(10);

		this.txtClaseDoc = new JTextField();
		this.txtClaseDoc.setName("Clase");
		this.txtClaseDoc.setColumns(10);

		this.lblClaseDoc = new JLabel("Clase");

		this.lblDetalleDeDocumento = new JLabel("Formulario de Lista");

		this.btnActualizar = new JButton("Llenar desde Web");
		this.btnActualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				llenarDesdeWeb();
			}
		});
		GroupLayout groupLayout = new GroupLayout(pnlContenido);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(10)
										.addComponent(scrollPane,
												GroupLayout.DEFAULT_SIZE, 232,
												Short.MAX_VALUE)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(10)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												this.lblClase,
																												GroupLayout.PREFERRED_SIZE,
																												54,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(5)
																										.addComponent(
																												this.txtClase,
																												GroupLayout.PREFERRED_SIZE,
																												110,
																												GroupLayout.PREFERRED_SIZE)
																										.addContainerGap())
																						.addGroup(
																								groupLayout
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addGroup(
																												groupLayout
																														.createSequentialGroup()
																														.addGroup(
																																groupLayout
																																		.createParallelGroup(
																																				Alignment.LEADING)
																																		.addComponent(
																																				lblCdigo)
																																		.addComponent(
																																				lblDescripcin)
																																		.addComponent(
																																				this.lblOpcin,
																																				GroupLayout.PREFERRED_SIZE,
																																				54,
																																				GroupLayout.PREFERRED_SIZE))
																														.addGap(5)
																														.addGroup(
																																groupLayout
																																		.createParallelGroup(
																																				Alignment.TRAILING)
																																		.addComponent(
																																				this.txtDescripcion,
																																				GroupLayout.DEFAULT_SIZE,
																																				263,
																																				Short.MAX_VALUE)
																																		.addComponent(
																																				this.txtPaquete,
																																				GroupLayout.DEFAULT_SIZE,
																																				263,
																																				Short.MAX_VALUE)
																																		.addGroup(
																																				groupLayout
																																						.createSequentialGroup()
																																						.addComponent(
																																								this.txtCodigo,
																																								GroupLayout.DEFAULT_SIZE,
																																								129,
																																								Short.MAX_VALUE)
																																						.addPreferredGap(
																																								ComponentPlacement.RELATED)
																																						.addComponent(
																																								this.btnActualizar,
																																								GroupLayout.PREFERRED_SIZE,
																																								128,
																																								GroupLayout.PREFERRED_SIZE)
																																						.addPreferredGap(
																																								ComponentPlacement.RELATED)))
																														.addGap(10))
																										.addGroup(
																												groupLayout
																														.createSequentialGroup()
																														.addComponent(
																																this.lblImgen,
																																GroupLayout.PREFERRED_SIZE,
																																54,
																																GroupLayout.PREFERRED_SIZE)
																														.addGap(5)
																														.addGroup(
																																groupLayout
																																		.createParallelGroup(
																																				Alignment.LEADING)
																																		.addComponent(
																																				this.txtImagen,
																																				GroupLayout.PREFERRED_SIZE,
																																				164,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addGroup(
																																				groupLayout
																																						.createSequentialGroup()
																																						.addGap(162)
																																						.addComponent(
																																								btnImg,
																																								GroupLayout.PREFERRED_SIZE,
																																								31,
																																								GroupLayout.PREFERRED_SIZE)))
																														.addContainerGap()))))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				this.chkEsLista)
																		.addContainerGap())
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												this.lblPaqueteDoc,
																												GroupLayout.PREFERRED_SIZE,
																												54,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												this.txtPaqueteDoc,
																												GroupLayout.DEFAULT_SIZE,
																												264,
																												Short.MAX_VALUE))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												this.lblClaseDoc,
																												GroupLayout.PREFERRED_SIZE,
																												54,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(5)
																										.addComponent(
																												this.txtClaseDoc,
																												GroupLayout.PREFERRED_SIZE,
																												137,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								this.lblDetalleDeDocumento,
																								GroupLayout.PREFERRED_SIZE,
																								131,
																								GroupLayout.PREFERRED_SIZE))
																		.addContainerGap()))));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																Alignment.LEADING,
																groupLayout
																		.createSequentialGroup()
																		.addGap(26)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												lblCdigo)
																										.addGap(16)
																										.addComponent(
																												lblDescripcin)
																										.addGap(19)
																										.addComponent(
																												this.lblOpcin))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.BASELINE)
																														.addComponent(
																																this.txtCodigo,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																this.btnActualizar,
																																GroupLayout.PREFERRED_SIZE,
																																22,
																																GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												this.txtDescripcion,
																												GroupLayout.PREFERRED_SIZE,
																												22,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(11)
																										.addComponent(
																												this.txtPaquete,
																												GroupLayout.PREFERRED_SIZE,
																												22,
																												GroupLayout.PREFERRED_SIZE)))
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(9)
																										.addComponent(
																												this.lblClase))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(5)
																										.addComponent(
																												this.txtClase,
																												GroupLayout.PREFERRED_SIZE,
																												22,
																												GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(4)
																										.addComponent(
																												this.lblImgen))
																						.addComponent(
																								this.txtImagen,
																								GroupLayout.PREFERRED_SIZE,
																								22,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btnImg,
																								GroupLayout.PREFERRED_SIZE,
																								22,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(18)
																		.addComponent(
																				this.chkEsLista)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				this.lblDetalleDeDocumento)
																		.addGap(4)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								this.txtPaqueteDoc,
																								GroupLayout.PREFERRED_SIZE,
																								22,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								this.lblPaqueteDoc))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								this.txtClaseDoc,
																								GroupLayout.PREFERRED_SIZE,
																								22,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								this.lblClaseDoc)))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(11)
																		.addComponent(
																				scrollPane,
																				GroupLayout.DEFAULT_SIZE,
																				286,
																				Short.MAX_VALUE)))
										.addGap(11)));
		pnlContenido.setLayout(groupLayout);

		tblLista.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						int selectedRow = tblLista.getSelectedRow();
						if (selectedRow >= 0)
							setFormulario(getFormularios().get(selectedRow));
						else
							setFormulario(null);
						llenar_datos();
					}
				});
		iniciar();
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

	@SuppressWarnings("deprecation")
	public void guardarImg() throws MalformedURLException, IOException {

		String url = CargarURL(fc.getSelectedFile().toURL().toString());
		String extension = url.substring(url.length() - 3);

		ImageIO.write(imagen, extension, new File("src//resources/"
				+ url));

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
	public void nuevo() {
		setFormulario(new SysFormulario());
		getFormulario().setEsLista(0);
		txtCodigo.requestFocus();
	}

	@Override
	public void anular() {
		vista_noedicion();
	}

	@Override
	public void grabar() {
		try {
			formularioDAO.mezclar(1,getFormulario());
		} catch (NisiraORMException e1) {
			e1.printStackTrace();
		}

		try {
			if (!(fc == null)) {
				guardarImg();
				fc = null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void eliminar() {
		if (getFormulario() != null) {
			try {
				formularioDAO.borrar(1,getFormulario());
			} catch ( NisiraORMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void llenar_datos() {
		limpiarVista();
		if (getFormulario() != null) {
			txtCodigo.setText(formulario.getIdFormulario());
			txtDescripcion.setText(formulario.getDescripcion());
			txtPaquete.setText(formulario.getPaquete());
			txtClase.setText(formulario.getClase());
			txtImagen.setText(formulario.getImagen());

			txtPaqueteDoc.setText(formulario.getPaqueteDoc());
			txtClaseDoc.setText(formulario.getClaseDoc());

			chkEsLista.setSelected(formulario.getEsLista() == 1);

			if (chkEsLista.isSelected()) {
				lblDetalleDeDocumento.setVisible(true);
				txtPaqueteDoc.setVisible(true);
				txtClaseDoc.setVisible(true);
				lblPaqueteDoc.setVisible(true);
				lblClaseDoc.setVisible(true);
			}
		}
	}

	@Override
	public void limpiarVista() {
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtPaquete.setText("");
		txtClase.setText("");
		txtPaqueteDoc.setText("");
		txtClaseDoc.setText("");
		txtImagen.setText("");
		chkEsLista.setSelected(false);

		lblDetalleDeDocumento.setVisible(false);
		txtPaqueteDoc.setVisible(false);
		txtClaseDoc.setVisible(false);
		lblPaqueteDoc.setVisible(false);
		lblClaseDoc.setVisible(false);
	}

	@Override
	public void llenar_lista() {
		tblLista.setFillsViewportHeight(true);

		MaestroTableModel model = (MaestroTableModel) tblLista.getModel();
		model.limpiar();
		for (SysFormulario ob : getFormularios()) {
			model.addRow(new Object[] { ob.getIdFormulario(),
					ob.getDescripcion() });
		}
		if (getFormularios().size() > 0) {
			setFormulario(getFormularios().get(0));
			tblLista.setRowSelectionInterval(0, 0);
		}
	}

	@Override
	public void llenar_tablas() {
		try {
			setFormularios(formularioDAO.listar(1));
		} catch ( NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void vista_edicion() {
		System.out.println("Entre XD!");
		if (getEstado().equals(NUEVO))
			txtCodigo.setEditable(true);
		TextFieldsEdicion(true, txtDescripcion, txtPaquete, txtClase,
				txtPaqueteDoc, txtClaseDoc);
		chkEsLista.setEnabled(true);
		tblLista.setEnabled(false);
		btnImg.setEnabled(true);
	}

	@Override
	public void vista_noedicion() {
		TextFieldsEdicion(false, txtCodigo, txtDescripcion, txtImagen,
				txtPaquete, txtClase, txtPaqueteDoc, txtClaseDoc);
		chkEsLista.setEnabled(false);
		tblLista.setEnabled(true);
		btnImg.setEnabled(false);
	}

	@Override
	public void llenarDesdeVista() {
		formulario.setIdFormulario(txtCodigo.getText());
		formulario.setDescripcion(txtDescripcion.getText());
		formulario.setPaquete(txtPaquete.getText());
		formulario.setClase(txtClase.getText());
		formulario.setImagen(txtImagen.getText());
		formulario.setEsLista(chkEsLista.isSelected() ? 1 : 0);
		formulario.setPaqueteDoc(txtPaqueteDoc.getText());
		formulario.setClaseDoc(txtClaseDoc.getText());
	}

	@Override
	public boolean isValidaVista() {

		if (!FormValidador.TextFieldObligatorios(txtCodigo, txtDescripcion,
				txtPaquete, txtClase))
			return false;

		if (chkEsLista.isSelected()) {
			if (!FormValidador
					.TextFieldObligatorios(txtPaqueteDoc, txtClaseDoc))
				return false;
		}

		if (getEstado().equals(NUEVO)) {
			try {
				if (formularioDAO.porClavePrimaria(1,this.txtCodigo.getText().trim()) != null) {
					UtilMensajes.mensaje_alterta("CODIGO_EXISTE");
					this.txtCodigo.requestFocus();
					return false;
				}
			} catch (SQLException | NisiraORMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;
	}

	private void llenarDesdeWeb() {
		String https_url = "https://docs.google.com/spreadsheets/d/18-IUrGOooDv9fn92v4hCcNyleszjelILFu6Oz68f7C4/pubhtml?gid=0&single=true";
		
		URL url;
		try {

			// Create a context that doesn't check certificates.
			SSLContext ssl_ctx = SSLContext.getInstance("TLS");
			TrustManager[] trust_mgr = get_trust_mgr();
			ssl_ctx.init(null, // key manager
					trust_mgr, // trust manager
					new SecureRandom()); // random number generator
			HttpsURLConnection.setDefaultSSLSocketFactory(ssl_ctx
					.getSocketFactory());

			url = new URL(https_url);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

			con.setHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String host, SSLSession sess) {
					if (host.equals("localhost"))
						return true;
					else
						return false;
				}
			});

			print_https_cert(con);
			Connection cone = Jsoup.connect(https_url);
			cone.timeout(1000000);
			Document res = cone.get();

			Elements cuerpo = res.body().select("div[id*=sheets-viewport")
					.select("tbody").select("tr");
			boolean band = false;
			for (Element e : cuerpo) {
				if (band) {
					String idformulario = e.child(1).text();
					String descripcion = e.child(2).text();
					String imagen = e.child(3).text();
					String paquete = e.child(4).text();
					String clase = e.child(5).text();
					
					int es_lista = Integer.parseInt(e.child(6).text());
					String paquete_doc = "", clase_doc = "";
					if (es_lista == 1) {
						paquete_doc = e.child(7).text();
						clase_doc = e.child(8).text();
					}

					SysFormulario f = new SysFormulario();

					f.setIdFormulario(idformulario);
					f.setDescripcion(descripcion);
					f.setImagen(imagen);
					f.setPaquete(paquete);
					f.setClase(clase);
					f.setEsLista(es_lista);
					f.setPaqueteDoc(paquete_doc);
					f.setClaseDoc(clase_doc);
					f.setOpcion("");
					System.out.println("Actualizando: " + idformulario);
					formularioDAO.mezclar(1,f);
					System.out.println("Actualizado: " + idformulario);
				}
				band = true;
			}

			iniciar();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NisiraORMException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void limpiarDetalle() {
		// TODO Auto-generated method stub

	}

	public SysFormulario getFormulario() {
		return formulario;
	}

	public void setFormulario(SysFormulario formulario) {
		this.formulario = formulario;
	}

	public List<SysFormulario> getFormularios() {
		return formularios;
	}

	public void setFormularios(List<SysFormulario> formularios) {
		this.formularios = formularios;
	}

	private void print_https_cert(HttpsURLConnection con) {
		if (con != null) {

			try {

				System.out.println("Response Code : " + con.getResponseCode());
				System.out.println("Cipher Suite : " + con.getCipherSuite());
				System.out.println("\n");

				Certificate[] certs = con.getServerCertificates();
				for (Certificate cert : certs) {
					System.out.println("Cert Type : " + cert.getType());
					System.out.println("Cert Hash Code : " + cert.hashCode());
					System.out.println("Cert Public Key Algorithm : "
							+ cert.getPublicKey().getAlgorithm());
					System.out.println("Cert Public Key Format : "
							+ cert.getPublicKey().getFormat());
					System.out.println("\n");
				}

			} catch (SSLPeerUnverifiedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private TrustManager[] get_trust_mgr() {
		TrustManager[] certs = new TrustManager[] { new X509TrustManager() {
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkClientTrusted(X509Certificate[] certs, String t) {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] certs, String t) {
			}
		} };
		return certs;
	}

	@Override
	public void llenarPorId(Object id) {
		// TODO Auto-generated method stub
		
	}
}