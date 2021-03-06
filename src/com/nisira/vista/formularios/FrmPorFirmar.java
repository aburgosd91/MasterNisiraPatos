package com.nisira.vista.formularios;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JWindow;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.TableCellRenderer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.nisira.Inicio;
import com.nisira.clientservice.SignService;
import com.nisira.clientservice.SignServiceException_Exception;
import com.nisira.clientservice.SignServicePortType;
import com.nisira.core.NisiraORMException;
import com.nisira.dao.DDocumentosEnviadosDao;
import com.nisira.dao.DocumentosEnviadosDao;
import com.nisira.dao.LogEnvioDao;
import com.nisira.dao.ODDatoDao;
import com.nisira.dao.OrigenDatoDao;
import com.nisira.entidad.DDocumentosEnviados;
import com.nisira.entidad.DocumentosEnviados;
import com.nisira.entidad.EmpresaEnvio;
import com.nisira.entidad.LogEnvio;
import com.nisira.entidad.OrigenDato;
import com.nisira.utilitarios.RespuestaNCDR;
import com.nisira.utilitarios.UtilMensajes;
import com.nisira.vista.controles.NSRDatePicker;
import com.nisira.vista.controles.NSRInternalFrame;
import com.nisira.vista.controles.NSRTable;
import com.nisira.vista.controles.NSRTableModel;
import java.awt.Font;

public class FrmPorFirmar extends NSRInternalFrame {

	private NSRDatePicker dpDesde;
	private NSRDatePicker dpHasta;

	private NSRTable table;
	private JButton btnMostrar;
	private JButton btnEnviar;
	private JProgressBar pb;

	private JWindow errorPopUpWindow = null;

	// Errores
	private JButton btnErrores;

	// private Thread hAutomatico;

	private Automatico automatico = new Automatico();

	private LogEnvioDao logenvioDao = new LogEnvioDao();
	private PnlErrores pnlErrores;

	private JToggleButton btnAutomatico;

	private LogEnvioDao logEnvioDao = new LogEnvioDao();

	private boolean selTodos = true;
	
	
	private DocumentosEnviadosDao doceDao = new DocumentosEnviadosDao();
	private DDocumentosEnviadosDao dDoceDao = new DDocumentosEnviadosDao();
	
	public FrmPorFirmar() {
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setVisible(true);
		setResizable(true);
		setName("FrmPorFirmar");
		setTitle("Panel de Control Envío");

		setSize(new Dimension(888, 450));
		setPreferredSize(new Dimension(888, 418));

		JScrollPane scrollPane = new JScrollPane();

		dpDesde = new NSRDatePicker();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		dpDesde.setDate(cal.getTime());

		JLabel lblDesde = new JLabel("Desde");

		JLabel lblHasta = new JLabel("Hasta");
		
		// JLabel lblServidor = new JLabel("Servidor destino: ");

		dpHasta = new NSRDatePicker();
		dpHasta.setDate(new Date());

		btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mostrar();
			}
		});

		btnEnviar = new JButton("Enviar");
		btnEnviar.setEnabled(true);

		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				enviar();
			}
		});

		pb = new JProgressBar();
		pb.setStringPainted(true);
		pb.setString("");
		pb.setVisible(false);
		btnErrores = new JButton("Errores");
		btnErrores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showErrores();
			}
		});

		btnAutomatico = new JToggleButton("Iniciar Automático");
		btnAutomatico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				automatico();
			}
		});

		pnlErrores = new PnlErrores() {
			private static final long serialVersionUID = 1L;

			@Override
			public void consultar() {
				SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

				List<LogEnvio> log;
				try {
					log = logEnvioDao.getDesde(1,this.datePicker.getDate());
					while (this.model.getRowCount() != 0) {
						this.model.removeRow(0);
					}

					for (LogEnvio l : log) {
						model.addRow(new Object[] { dt.format(l.getFechaHora()), l.getMensaje() });
					}
				} catch (SQLException | NisiraORMException e) {
					e.printStackTrace();
				}

			}
		};

		pnlErrores.datePicker.setDate(new java.util.Date());

		errorPopUpWindow = new JWindow(Inicio.mainF);
		errorPopUpWindow.setOpacity(0.95f);
		errorPopUpWindow.getContentPane().add(pnlErrores);
		errorPopUpWindow.pack();

		ListenerError listenerError = new ListenerError();

		pnlErrores.table.addFocusListener(listenerError);
		btnErrores.addFocusListener(listenerError);

		JButton button = new JButton("Seleccionar Todos");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < getTablaTM().getRowCount(); i++) {
					getTablaTM().setValueAt(selTodos, i, 0);
				}
				selTodos = !selTodos;

				button.setText(selTodos ? "Seleccionar Todos" : "Deseleccionar Todos");
			}
		});
		
		JLabel lblServidor = new JLabel("Servidor Destino: ");
		lblServidor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblServidor.setForeground(Color.BLUE);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAutomatico)
							.addGap(18)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
							.addComponent(btnErrores)
							.addGap(70)
							.addComponent(lblDesde, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dpDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblHasta, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dpHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnMostrar, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(pb, GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
									.addGap(18))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblServidor)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(btnEnviar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnMostrar)
								.addComponent(dpHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHasta)
								.addComponent(dpDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDesde)
								.addComponent(btnAutomatico)
								.addComponent(btnErrores)
								.addComponent(button))
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnEnviar)
								.addComponent(pb, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(374)
							.addComponent(lblServidor)))
					.addContainerGap())
		);

		String[] cabeceras = new String[] { "Elegir", "Oriden Datos", "Id", "Documento", "Código", "Razón Social",
				"Fecha", "Archivo", "Xml","Destino" };

		table = new NSRTable(new NSRTableModel(cabeceras) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean evaluaEdicion(int row, int column) {
				if (column == 0)
					return true;
				return false;
			}

			@Override
			public void addRow() {

			}

			@Override
			public Class<?> getColumnClass(int column) {
				// TODO Auto-generated method stub
				if (column == 0) {
					return Boolean.class;
				}
				return super.getColumnClass(column);
			}

		}) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {
				Component comp = super.prepareRenderer(renderer, rowIndex, columnIndex);
				// even index, selected or not selected
				if (isCellSelected(rowIndex, columnIndex)) {
					// comp.setForeground(Color.YELLOW);
				} else {
					if (rowIndex % 2 == 0) {
						comp.setBackground(new Color(220, 220, 220));
					} else {
						comp.setBackground(Color.WHITE);
					}
				}
				return comp;
			}
		};
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);

		scrollPane.setViewportView(table);
		table.setColumnControlVisible(true);

		getContentPane().setLayout(groupLayout);

		// setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);

		/* Veririca si hay otro form abierto */

		// for (JInternalFrame frm : Inicio.desktoppane.getDesktopMediator()
		// .getAllFrames()) {
		// if (frm instanceof FrmPorFirmar) {
		// UtilMensajes.mensaje_alterta("SOLO_UN_FORMULARIO");
		// this.setClosable(true);
		// try {
		// this.setClosed(true);
		// } catch (PropertyVetoException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// dispose();
		// cerrar();
		// }
		// }
	}

	private void mostrar() {
		// try {
		int anio_hasta, mes_hasta, dia_hasta, idesde;
		int anio_desde, mes_desde, dia_desde, ihasta;

		Calendar desde = Calendar.getInstance();
		if (dpDesde.getDate() == null) {
			anio_desde = 0;
			mes_desde = 0;
			dia_desde = 0;
		} else {
			desde.setTime(dpDesde.getDate());
			anio_desde = desde.get(Calendar.YEAR);
			mes_desde = desde.get(Calendar.MONTH) + 1;
			dia_desde = desde.get(Calendar.DAY_OF_MONTH);
		}

		Calendar hasta = Calendar.getInstance();

		if (dpHasta.getDate() == null) {
			anio_hasta = 0;
			mes_hasta = 0;
			dia_hasta = 0;
		} else {
			hasta.setTime(dpHasta.getDate());
			anio_hasta = hasta.get(Calendar.YEAR);
			mes_hasta = hasta.get(Calendar.MONTH) + 1;
			dia_hasta = hasta.get(Calendar.DAY_OF_MONTH);
		}
		idesde = (anio_desde * 10000) + (mes_desde * 100) + dia_desde;
		ihasta = (anio_hasta * 10000) + (mes_hasta * 100) + dia_hasta;

		getTablaTM().limpiar();
		// datos.clear();

		Mostrar m = new Mostrar(String.valueOf(idesde), String.valueOf(ihasta), getTablaTM());

		new Thread(m).start();

	}

	private void enviar() {
		Enviar m = new Enviar();

		new Thread(m).start();

	}

	private void habilitaFormulario(boolean band) {
		btnMostrar.setEnabled(band);
		btnEnviar.setEnabled(band);
		dpDesde.setEnabled(band);
		dpHasta.setEnabled(band);
	}

	private void automatico() {
		if (btnAutomatico.isSelected()) {
			habilitaFormulario(false);
			automatico.continuar = true;
			automatico.init();
		} else {
			automatico.continuar = false;
		}
	}

	public NSRTableModel getTablaTM() {
		return ((NSRTableModel) table.getModel());
	}

	private void showErrores() {

		if (errorPopUpWindow.isVisible()) {
			errorPopUpWindow.setVisible(false);
		} else {

			int windowX = btnErrores.getLocationOnScreen().x;
			int windowY = btnErrores.getLocationOnScreen().y + btnErrores.getHeight();
			errorPopUpWindow.pack();
			errorPopUpWindow.setLocation(windowX, windowY);
			errorPopUpWindow.setAutoRequestFocus(false);
			errorPopUpWindow.setVisible(true);
		}
	}

	private void appendToPane(String tipo, String msg) {
		LogEnvio log = new LogEnvio();
		log.setFechaHora(new Date());
		log.setTipo(tipo);
		log.setFormulario(this.getName());
		log.setMensaje(msg);

		try {
			logenvioDao.insertar(1,log);
		} catch (NisiraORMException e) {
			UtilMensajes.mensaje_error("ERROR_SQL", e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void dispose() {
		automatico.continuar = false;
		super.dispose();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	class Automatico implements Runnable {
		public Thread t;

		public boolean continuar;

		public Automatico() {
			this.continuar = false;
		}

		public void init() {
			t = new Thread(this);
			t.start();
		}

		public void stop() {
			t.interrupt();
		}

		@Override
		public void run() {
			while (continuar) {
				int anio_hasta, mes_hasta, dia_hasta, idesde;
				int anio_desde, mes_desde, dia_desde, ihasta;

				Calendar desde = Calendar.getInstance();
				if (dpDesde.getDate() == null) {
					anio_desde = 0;
					mes_desde = 0;
					dia_desde = 0;
				} else {
					desde.setTime(dpDesde.getDate());
					anio_desde = desde.get(Calendar.YEAR);
					mes_desde = desde.get(Calendar.MONTH) + 1;
					dia_desde = desde.get(Calendar.DAY_OF_MONTH);
				}

				Calendar hasta = Calendar.getInstance();

				if (dpHasta.getDate() == null) {
					anio_hasta = 0;
					mes_hasta = 0;
					dia_hasta = 0;
				} else {
					hasta.setTime(dpHasta.getDate());
					anio_hasta = hasta.get(Calendar.YEAR);
					mes_hasta = hasta.get(Calendar.MONTH) + 1;
					dia_hasta = hasta.get(Calendar.DAY_OF_MONTH);
				}
				idesde = (anio_desde * 10000) + (mes_desde * 100) + dia_desde;
				ihasta = (anio_hasta * 10000) + (mes_hasta * 100) + dia_hasta;

				getTablaTM().limpiar();

				new Mostrar(String.valueOf(idesde), String.valueOf(ihasta), getTablaTM(), 1).run();
				new Enviar(1).run();
			}
			stop();
			habilitaFormulario(true);
		}
	}

	class Mostrar implements Runnable {

		private String desde;
		private String hasta;
		private NSRTableModel tabla;
		private int tipo_proceso;

		public Mostrar(String desde, String hasta, NSRTableModel tabla) {
			this.desde = desde;
			this.hasta = hasta;
			this.tabla = tabla;
			this.tipo_proceso = 0;
		}

		public Mostrar(String desde, String hasta, NSRTableModel tabla, int tipo_proceso) {
			this.desde = desde;
			this.hasta = hasta;
			this.tabla = tabla;
			this.tipo_proceso = tipo_proceso;
		}

		@Override
		public void run() {
			if (this.tipo_proceso == 0) {
				pb.setVisible(true);
				habilitaFormulario(false);
			}
			OrigenDatoDao odao = new OrigenDatoDao();
			ODDatoDao oddao = new ODDatoDao();
			List<OrigenDato> ods = null;
			try {
				ods = odao.listar(1);
			} catch (NisiraORMException e) {
				appendToPane("E", UtilMensajes.getMensaje("ERR_TRAER_ODATOS"));
			}

			float rango = 100 / (float) ods.size();
			pb.setString("");
			pb.setValue(0);

			for (OrigenDato od : ods) {
				pb.setValue((int) (pb.getValue() + rango));
				pb.setString("Consultando origen de Datos: " + od.getDescripcion().trim().toUpperCase());
				try {
					List<Object[]> pendientes = oddao.getPendientes(od, desde, hasta);
					for (Object[] r : pendientes) {
						Object[] row = new Object[11];
						if (this.tipo_proceso == 0) {
							row[0] = false;
						} else {
							row[0] = true;
						}
						row[1] = r[0];
						row[2] = r[1];
						row[3] = r[2];
						row[4] = r[3];
						row[5] = r[4];
						row[6] = r[5];
						row[7] = r[6];
						row[8] = r[7];
						
						String xml = "";
								
						if (r[8] != null) {
							xml = r[8].toString();
						}
						
						//row[9] = xml;
						//row[10] = od.getEmpresaenvio_odempresaenvio().getEnPrueba().equals(1)?"PRUEBAS":"SUNAT";

						row[9] = od.getEmpresaenvio_odempresaenvio().getEnPrueba().equals(1)?"PRUEBAS":"SUNAT";
						
						if (!xml.isEmpty()) {

							DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
							dbf.setNamespaceAware(true);

							Document doc = null;

							try {
								doc = dbf.newDocumentBuilder()
										.parse(new ByteArrayInputStream(row[8].toString().getBytes()));

								StringWriter writer = new StringWriter();

								Source source = new DOMSource(doc);
								// Indicamos donde lo queremos almacenar
								StreamResult result = new StreamResult(writer);
								Transformer transformer;

								TransformerFactory transformerFactory = TransformerFactory.newInstance();
								transformerFactory.setAttribute("indent-number", 4);

								transformer = transformerFactory.newTransformer();
								transformer.setOutputProperty(OutputKeys.INDENT, "yes");

								transformer.transform(source, result);

							//	row[9] = writer.toString();

							} catch (SAXException | IOException | ParserConfigurationException
									| TransformerException e) {
								e.printStackTrace();
							}
						}

						tabla.addRow(row);
					}
				} catch (NisiraORMException | SQLException e) {
					appendToPane("E", UtilMensajes.getFormated("ERR_TRAER_PENDIENTES_ODATOS", od.getDescripcion()));
				}

			}
			if (this.tipo_proceso == 0) {
				pb.setVisible(false);
				pb.setValue(0);
				habilitaFormulario(true);
			}
		}

	}

	class ListenerError implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			boolean band = false;
			if (e.getComponent() == table) {
				band = true;
			}
			if (!band) {
				errorPopUpWindow.setVisible(false);
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			boolean band = false;
			if ((e.getComponent() == pnlErrores.table && e.getOppositeComponent() == btnErrores)
					|| (e.getComponent() == btnErrores && e.getOppositeComponent() == pnlErrores.table)) {
				band = true;
			}
			if (!band) {
				errorPopUpWindow.setVisible(false);
			}
		}

	}

	class Enviar implements Runnable {
		int tipoProceso;

		public Enviar() {
			tipoProceso = 0;
		}

		public Enviar(int tipoProceso) {
			this.tipoProceso = tipoProceso;
		}

		@SuppressWarnings("restriction")
		@Override
		public void run() {

			if (tipoProceso == 0)
				habilitaFormulario(false);

			pb.setVisible(true);

			SignService ss = new SignService();

			SignServicePortType sp = ss.getSignServiceHttpSoap11Endpoint();

			float rango = 100 / (float) getTablaTM().getRowCount();
			pb.setString("");
			pb.setValue(0);

			for (int i = 0; i < getTablaTM().getRowCount(); i++) {
				pb.setValue((int) (pb.getValue() + rango));
				if ((boolean) getTablaTM().getValueAt(i, 0)) {

					String servidor_destino = ((String) getTablaTM().getValueAt(i, 9)).substring(0, 1);
					String xml = (String) getTablaTM().getValueAt(i, 8);
					String documento = (String) getTablaTM().getValueAt(i, 7);
					String documento_aux = (String) getTablaTM().getValueAt(i, 3);
					
					String documento_idorigen = (String) getTablaTM().getValueAt(i, 2);
					
					String idclieprov = (String) getTablaTM().getValueAt(i, 4);
					String razonSocial = (String) getTablaTM().getValueAt(i, 5);
					
					documento = ((documento == null) ? "" : documento).trim();
					documento_aux = ((documento_aux == null) ? "" : documento_aux).trim();

					documento_aux = documento.isEmpty() ? documento_aux : documento;

					pb.setString("Enviando Documento: " + documento_aux);

					OrigenDato od = (OrigenDato) getTablaTM().getValueAt(i, 1);
					xml = (xml == null) ? "" : xml;
					if (xml.isEmpty()) {
						appendToPane("E", UtilMensajes.getFormated("NO_HAY_XML_EDOC", documento_aux));
						continue;
					}
					String base64 = null;
					EmpresaEnvio ev = od.getEmpresaenvio_odempresaenvio();

					try {
						base64 = sp.sign(documento, xml, ev.getEmpresaWS(), ev.getClaveWS(), ev.getRuc(), ev.getClaveWS(), servidor_destino);
					} catch (SignServiceException_Exception e1) {
						e1.printStackTrace();
					}

					try {
						byte[] bytes = new sun.misc.BASE64Decoder().decodeBuffer(base64);
						String archivo = ev.getRutaArchivos().concat("/R").concat(documento).concat(".zip");
						FileOutputStream fileOuputStream = new FileOutputStream(archivo);
						fileOuputStream.write(bytes);
						fileOuputStream.close();

					} catch (IOException e) {
						appendToPane("E", e.getMessage());
					}

					try {

						byte[] de64 = new sun.misc.BASE64Decoder().decodeBuffer(base64);

						ZipInputStream zipStream = new ZipInputStream(new ByteArrayInputStream(de64));
						ZipEntry entry = null;
						while ((entry = zipStream.getNextEntry()) != null) {

							String entryName = entry.getName();

							if (entryName.endsWith(".ncdr") || entryName.endsWith(".pdf")) {

								String path = (entryName.endsWith(".ncdr") ? "\\" : "\\PDF\\");

								FileOutputStream out = new FileOutputStream(
										ev.getRutaArchivos().concat(path).concat(entryName));

								byte[] byteBuff = new byte[4096];
								int bytesRead = 0;
								while ((bytesRead = zipStream.read(byteBuff)) != -1) {
									out.write(byteBuff, 0, bytesRead);
								}

								out.close();
								zipStream.closeEntry();
							}
						}
						zipStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					ODDatoDao oddao = new ODDatoDao();
					try {

						File file = new File(ev.getRutaArchivos().concat("\\").concat(documento).concat(".ncdr"));

						DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
						DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
						Document doc = dBuilder.parse(file);

						doc.getDocumentElement().normalize();

						Element appResp = (Element) doc.getElementsByTagName("ApplicationResponse").item(0);

						Element docResponse = (Element) appResp.getElementsByTagName("DocumentResponse").item(0);

						NodeList responses = docResponse.getElementsByTagName("Response");

						List<RespuestaNCDR> respuestas = new ArrayList<RespuestaNCDR>();

						for (int ii = 0; ii < responses.getLength(); ii++) {
							Element response = (Element) responses.item(ii);
							Element code = (Element) response.getElementsByTagName("ResponseCode").item(0);
							Element desc = (Element) response.getElementsByTagName("ResponseDescription").item(0);

							String codigo = code.getTextContent();
							String descripcion = desc.getTextContent();

							respuestas.add(new RespuestaNCDR(codigo, descripcion));
						}

						Integer prueba = od.getEmpresaenvio_odempresaenvio().getEnPrueba();

						if (prueba == null) {
							prueba = 0;
						}
						
						DocumentosEnviados de = new DocumentosEnviados();
						
						de.setIdOrigen(od.getIdorigen());
						de.setIdUnico(documento_idorigen);
						de.setDocumento(documento_aux);
						de.setDocXML(xml);
						de.setFecha(new Date());
						de.setIdClieprov(idclieprov);
						de.setRazonSocial(razonSocial);
						de.setNombreArchivo(documento);
						//doceDao
						
						doceDao.mezclar(1,de);
						
						dDoceDao.borrar(1,od.getIdorigen(), documento_idorigen);
						
						int item = 0;
						for (RespuestaNCDR r : respuestas) {
							item++;
							DDocumentosEnviados dde = new DDocumentosEnviados();
							dde.setIdOrigen(od.getIdorigen());
							dde.setIdUnico(documento_idorigen);
							dde.setItem(item);
							dde.setCodigo(r.codigo);
							dde.setDescripcion(r.descripcion);
							dDoceDao.insertar(1,dde);
						}
						
						if (prueba == 0) {
							oddao.actualizaEstadoSunat(od, documento_idorigen, respuestas);
						}
					} catch (ParserConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SAXException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NisiraORMException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			pb.setVisible(false);
			pb.setValue(0);
			if (tipoProceso == 0) {
				habilitaFormulario(true);
			}
			
			mostrar();
		}

		private void habilitaFormulario(boolean band) {
			btnMostrar.setEnabled(band);
			btnEnviar.setEnabled(band);
			dpDesde.setEnabled(band);
			dpHasta.setEnabled(band);
		}
	}
}
