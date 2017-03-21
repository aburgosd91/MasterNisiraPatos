package com.nisira.vista.formularios;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JWindow;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.TableCellRenderer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.nisira.Inicio;
import com.nisira.clientservice.SignService;
import com.nisira.clientservice.SignServiceException_Exception;
import com.nisira.clientservice.SignServicePortType;
import com.nisira.core.NisiraORMException;
import com.nisira.dao.DDocumentosEnviadosDao;
import com.nisira.dao.DocumentosEnviadosDao;
import com.nisira.dao.EmpresaEnvioDao;
import com.nisira.dao.LogEnvioDao;
import com.nisira.dao.NumEnvioDao;
import com.nisira.dao.ODDatoDao;
import com.nisira.dao.OrigenDatoDao;
import com.nisira.dao.ResumenDao;
import com.nisira.entidad.EmpresaEnvio;
import com.nisira.entidad.LogEnvio;
import com.nisira.entidad.NumEnvio;
import com.nisira.entidad.OrigenDato;
import com.nisira.entidad.Resumen;
import com.nisira.utilitarios.RespuestaNCDR;
import com.nisira.utilitarios.UtilMensajes;
import com.nisira.vista.controles.NSRComboBox;
import com.nisira.vista.controles.NSRDatePicker;
import com.nisira.vista.controles.NSRInternalFrame;
import com.nisira.vista.controles.NSRTable;
import com.nisira.vista.controles.NSRTableModel;
import com.nisira.vista.contenedores.CntEmpresaEnvio;
import com.nisira.vista.contenedores.CntResumen;

public class FrmResumenDiario extends NSRInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NSRDatePicker dpHasta;

	private NSRTable table;
	private JButton btnMostrar;
	private JButton btnEnviar;
	private JProgressBar pb;

	private JWindow errorPopUpWindow = null;

	private LogEnvioDao logenvioDao = new LogEnvioDao();
	
	private PnlErrores pnlErrores;

	private LogEnvioDao logEnvioDao = new LogEnvioDao();

	private boolean selTodos = true;

	private ResumenDao resumenDao = new ResumenDao();

	private EmpresaEnvioDao empresaEnvioDao = new EmpresaEnvioDao();

	private NumEnvioDao numEnvioDao = new NumEnvioDao();

	// Contenedores

	private CntEmpresaEnvio cntEmpresaEnvio;
	private CntResumen cntResumen;
	// ListaCombos
	private NSRComboBox cboDocumentos;
	private NSRComboBox cboTipo;
	List<String[]> tipo = new ArrayList<String[]>();
	List<String[]> documentos = new ArrayList<String[]>();

	// Resumen

	String[] cabecerasResumen = new String[] { "Elegir", "Oriden Datos", "Id", "T.D.", "Serie", "Número",
			"Cód. Cliente", "Razón Social", "Correlativo", "V. Venta", "Importe", "IGV", "ISC" };

	public FrmResumenDiario() {
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setVisible(true);
		setResizable(true);
		setName("FrmPorFirmar");
		setTitle("Panel de Control Envío");

		setSize(new Dimension(888, 458));
		setPreferredSize(new Dimension(888, 418));

		JScrollPane scrollPane = new JScrollPane();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);

		tipo.add(new String[] { "0", "Resumen Diario" });
		tipo.add(new String[] { "1", "Comunicado de Baja" });

		JLabel lblHasta = new JLabel("Tipo Envio");

		dpHasta = new NSRDatePicker();
		dpHasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarResumenes();
			}
		});
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

		cboTipo = new NSRComboBox(tipo, 0, 1);

		cboTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cboTipo.getSelectedID() != null) {
					actualizaDocumentos(cboTipo.getSelectedID());
				}
			}
		});
		JLabel lblDocumento = new JLabel("Documento");

		cntEmpresaEnvio = new CntEmpresaEnvio() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void llenarAdicional() {				
				actualizarResumenes();
			}
		};

		try {
			cntEmpresaEnvio.setData(empresaEnvioDao.listar(1));
		} catch (NisiraORMException e1) {
			e1.printStackTrace();
		}

		JLabel lblEmpresa = new JLabel("Empresa");

		cntResumen = new CntResumen();
		
		JLabel lblFecha = new JLabel("De la Fecha");
		
		JLabel lblEnvoAReemplazar = new JLabel("Envío a Reemplazar");
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:64px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("left:123px:grow"),
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("11px"),
				ColumnSpec.decode("left:69px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:36px:grow"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("left:109px:grow"),
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("left:53px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("left:230px:grow"),
				ColumnSpec.decode("12px"),
				ColumnSpec.decode("center:95px"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("top:23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("top:23px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("fill:311px:grow"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("bottom:30px"),}));
		
				cboDocumentos = new NSRComboBox(new ArrayList<String[]>(), 0, 1);
				getContentPane().add(cboDocumentos, "9, 2, 3, 1, fill, top");

		table = new NSRTable(new NSRTableModel(cabecerasResumen) {

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
		getContentPane().add(scrollPane, "2, 6, 16, 1, fill, fill");
		getContentPane().add(pb, "2, 8, 14, 1, fill, center");
		getContentPane().add(btnEnviar, "17, 8, center, center");
		getContentPane().add(lblHasta, "2, 2, fill, center");
		getContentPane().add(cboTipo, "4, 2, fill, top");
		getContentPane().add(lblDocumento, "7, 2, left, center");
		getContentPane().add(lblEmpresa, "13, 2, fill, center");
		getContentPane().add(cntEmpresaEnvio, "15, 2, fill, top");
		getContentPane().add(btnMostrar, "17, 2, center, top");
		getContentPane().add(lblFecha, "2, 4, left, top");
		getContentPane().add(dpHasta, "4, 4, left, top");
		getContentPane().add(lblEnvoAReemplazar, "7, 4, 3, 1, left, top");
		getContentPane().add(cntResumen, "11, 4, 5, 1, fill, top");

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

	private void actualizaDocumentos(String tipo) {

		List<String[]> lista = new ArrayList<String[]>();
		switch (tipo) {
		case "0":
			lista.add(new String[] { "0", "Boletas" });
			// lista.add(new String[] { "1", "Retenciones" });
			// lista.add(new String[] { "2", "Percepciones" });
			// lista.add(new String[] { "3", "Notas de Crédito" });
			// lista.add(new String[] { "4", "Notas de Débito" });
			break;

		case "1":
			lista.add(new String[] { "0", "Todos" });
			break;
		}

		cboDocumentos.setListContent(lista);
		
		if (cboDocumentos.getItemCount() > 0) {
			cboDocumentos.setSelectedIndex(0);
		}
	}

	private void mostrar() {
		EmpresaEnvio empresaEnvio;

		empresaEnvio = cntEmpresaEnvio.getSeleccionado();

		String tipo, documento;

		tipo = cboTipo.getSelectedID();

		documento = cboDocumentos.getSelectedID();

		int anio, mes, dia, fecha;

		Calendar hasta = Calendar.getInstance();

		if (dpHasta.getDate() == null) {
			anio = 0;
			mes = 0;
			dia = 0;
		} else {
			hasta.setTime(dpHasta.getDate());
			anio = hasta.get(Calendar.YEAR);
			mes = hasta.get(Calendar.MONTH) + 1;
			dia = hasta.get(Calendar.DAY_OF_MONTH);
		}
		fecha = (anio * 10000) + (mes * 100) + dia;

		getTablaTM().limpiar();

		if (empresaEnvio != null && tipo != null && documento != null) {
			MostrarResumen m = new MostrarResumen(tipo, documento, String.valueOf(fecha), empresaEnvio.getIdEmpresa(),
					getTablaTM());
			new Thread(m).run();
		}
	}

	private NumEnvio getCorrelativo(String tipo, String fecha) {

		NumEnvio envio = null;

		try {
			envio = numEnvioDao.getPorClavePrimaria(1,tipo, fecha);

			if (envio == null) {
				envio = new NumEnvio();
				envio.setTipoDocumento(tipo);
				envio.setFecha(fecha);
				envio.setCorrelativo(0);
			}
		} catch (SQLException | NisiraORMException e) {
			e.printStackTrace();
		}

		return envio;
	}

	@SuppressWarnings("restriction")
	private void enviar() {

		Date fecha = dpHasta.getDate();

		try {

			int row = getTablaTM().getRowCount();

			String tipoSeleccionado = cboTipo.getSelectedID();

			List<SummaryDocumentsLine> summaryResult = new ArrayList<SummaryDocumentsLine>();
			List<VoidedDocumentsLine> voideResult = new ArrayList<VoidedDocumentsLine>();

			String fechaEnvio = new SimpleDateFormat("yyyyMMdd").format(new Date());
			String id;
			String sufijo, correlativo;

			String documento = ((String[]) cboDocumentos.getSelectedItem())[1];

			sufijo = getSufujiID();

			EmpresaEnvio empresaEnvio = cntEmpresaEnvio.getSeleccionado();
			
			NumEnvio numEnvio = getCorrelativo(sufijo, fechaEnvio);
			numEnvio.setCorrelativo(numEnvio.getCorrelativo() + 1);

			Formatter fmt = new Formatter();
			correlativo = fmt.format("%03d", numEnvio.getCorrelativo()).toString();

			id = sufijo + "-" + fechaEnvio + "-" + correlativo;
			
			Resumen enviado = cntResumen.getSeleccionado();
			
			if (enviado != null) {
				id = enviado.getDocumento();
			}
			
			Document document = getDocument();

			Element docElement = document.getDocumentElement();

			addNamespaces(document, docElement);

			addElement(document, docElement, "ext:UBLExtensions", "\n");
			addElement(document, docElement, "cbc:UBLVersionID", "2.0");
			addElement(document, docElement, "cbc:CustomizationID", "1.0");
			addElement(document, docElement, "cbc:ID", id);
			addElement(document, docElement, "cbc:ReferenceDate", new SimpleDateFormat("yyyy-MM-dd").format(fecha));
			addElement(document, docElement, "cbc:IssueDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

			addSignature(empresaEnvio, document, docElement);
			addAccountingSupplierParty(empresaEnvio, document, docElement);

			switch (tipoSeleccionado) {
			case "0":
				String currencyID = "PEN";
				for (int i = 0; i < row; i++) {
					boolean elegido = (boolean) getTablaTM().getValueAt(i, 0);
					if (elegido) {
						String serie;
						int numero;
						BigDecimal importe, vventa, igv, isc;

						serie = getTablaTM().getValueAt(i, 4).toString().trim();

						numero = Integer.valueOf(getTablaTM().getValueAt(i, 5).toString().trim());

						importe = new BigDecimal(getTablaTM().getValueAt(i, 10).toString());

						vventa = new BigDecimal(getTablaTM().getValueAt(i, 9).toString());

						igv = new BigDecimal(getTablaTM().getValueAt(i, 11).toString());

						isc = new BigDecimal(getTablaTM().getValueAt(i, 12).toString());

						SummaryDocumentsLine linea = null;

						for (SummaryDocumentsLine r : summaryResult) {
							if (r.documentSerialID.equalsIgnoreCase(serie)) {
								linea = r;
								break;
							}
						}

						if (linea == null) {
							linea = new SummaryDocumentsLine();
							linea.lineID = summaryResult.size() + 1;
							linea.documentTypeCode = "03";
							linea.documentSerialID = serie;
							linea.startDocumentNumberID = numero;
							linea.endDocumentNumberID = numero;
							linea.totalAmount = new BigDecimal("0.00");
							linea.currencyID = currencyID;

							linea.allowanceChargeIndicator = true;
							linea.allowanceChargeAmount = new BigDecimal("0.00");
							summaryResult.add(linea);
						}

						linea.totalAmount = linea.totalAmount.add(importe);

						if (linea.startDocumentNumberID > numero) {
							linea.startDocumentNumberID = numero;
						}

						if (linea.endDocumentNumberID < numero) {
							linea.endDocumentNumberID = numero;
						}

						BillingPayment b = linea.getBillingPayment("01");
						b.paidAmount = b.paidAmount.add(vventa);

						linea.getBillingPayment("02");
						linea.getBillingPayment("03");

						TaxTotal totalIsc = linea.getTaxTotal("2000");
						TaxTotal totalIgv = linea.getTaxTotal("1000");

						totalIgv.taxAmount = totalIgv.taxAmount.add(igv);
						totalIsc.taxAmount = totalIsc.taxAmount.add(isc);
					}
				}

				for (SummaryDocumentsLine r : summaryResult) {
					docElement.appendChild(r.getElement(document));
				}
				break;

			case "1":
				for (int i = 0; i < row; i++) {

					String serie, td;
					int numero;

					td = getTablaTM().getValueAt(i, 3).toString().trim();

					serie = getTablaTM().getValueAt(i, 4).toString().trim();

					numero = Integer.valueOf(getTablaTM().getValueAt(i, 5).toString().trim());

					VoidedDocumentsLine linea = new VoidedDocumentsLine();
					linea.lineID = voideResult.size() + 1;
					linea.documentTypeCode = td;
					linea.documentSerialID = serie;
					linea.documentNumberID = numero;
					linea.voidReasonDescription = "CANCELACION";
					voideResult.add(linea);
				}

				for (VoidedDocumentsLine r : voideResult) {
					docElement.appendChild(r.getElement(document));
				}

				break;
			}

			String xmlString = getXML(document);

			numEnvioDao.mezclar(1,numEnvio);

			String base64=null;

			SignService ss = new SignService();

			SignServicePortType sp = ss.getSignServiceHttpSoap11Endpoint();

			try {
				base64 = sp.sign(empresaEnvio.getRuc().concat("-").concat(id), xmlString, empresaEnvio.getEmpresaWS(),
						empresaEnvio.getClaveWS(), empresaEnvio.getRuc(), empresaEnvio.getClaveWS(), "");
			} catch (SignServiceException_Exception e1) {
				e1.printStackTrace();
			}

			numEnvioDao.mezclar(1,numEnvio);

			try {
				byte[] bytes = new sun.misc.BASE64Decoder().decodeBuffer(base64);
				String archivo = empresaEnvio.getRutaArchivos().concat("/T")
						.concat(empresaEnvio.getRuc().concat("-").concat(id)).concat(".zip");
				FileOutputStream fileOuputStream = new FileOutputStream(archivo);
				fileOuputStream.write(bytes);
				fileOuputStream.close();

			} catch (IOException e) {
				e.printStackTrace();
				// appendToPane("E", e.getMessage());
			}

			String rutaNCDR = null;
			try {

				byte[] de64 = new sun.misc.BASE64Decoder().decodeBuffer(base64);

				ZipInputStream zipStream = new ZipInputStream(new ByteArrayInputStream(de64));
				ZipEntry entry = null;
				while ((entry = zipStream.getNextEntry()) != null) {

					String entryName = entry.getName();

					if (entryName.endsWith(".ncdr") || entryName.endsWith(".pdf")) {

						String path = (entryName.endsWith(".ncdr") ? "\\" : "\\PDF\\");

						if (entryName.endsWith(".ncdr")) {
							rutaNCDR = empresaEnvio.getRutaArchivos().concat(path).concat(entryName);
						}

						FileOutputStream out = new FileOutputStream(
								empresaEnvio.getRutaArchivos().concat(path).concat(entryName));

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

			if (rutaNCDR != null) {
				String nombre, nroTicket = "NOT FOUND";
				File file = new File(rutaNCDR);

				nombre = id;//file.getName().substring(beginIndex);

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

					String codigo = code.getTextContent().trim();
					String descripcion = desc.getTextContent().trim();
					if (codigo.equalsIgnoreCase("TCKT")) {
						nroTicket = descripcion;
					}
					respuestas.add(new RespuestaNCDR(codigo, descripcion));
				}

				Integer prueba = empresaEnvio.getEnPrueba(); // od.getEmpresaenvio_odempresaenvio().getEnPrueba();

				if (prueba == null) {
					prueba = 0;
				}

				Resumen resumen = new Resumen();
				resumen.setIdEmpresa(empresaEnvio.getIdEmpresa());
				resumen.setDocumento(empresaEnvio.getRuc().concat("-").concat(stripExtension(nombre)));
				resumen.setDocXML(xmlString);
				resumen.setFechaGeneracion(new Date());
				resumen.setFechaResumen(fecha);
				resumen.setIdEstado("CT");
				resumen.setTipoDocumento(sufijo);
				resumen.setTicket(nroTicket);
				resumen.setTipoEnvio(documento);

				resumenDao.mezclar(1,resumen);

			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}  catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void habilitaFormulario(boolean band) {
		btnMostrar.setEnabled(band);
		btnEnviar.setEnabled(band);
		dpHasta.setEnabled(band);
	}

	public NSRTableModel getTablaTM() {
		return ((NSRTableModel) table.getModel());
	}

	private void appendToPane(String tipo, String msg, String error) {
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

	private void addSignature(EmpresaEnvio empresaEnvio, Document document, Element docElement) {
		Element signature = document.createElement("cac:Signature");
		docElement.appendChild(signature);

		addElement(document, signature, "cbc:ID", "sign".concat(empresaEnvio.getRuc()));

		Element party = document.createElement("cac:SignatoryParty");
		signature.appendChild(party);

		Element partyidentification = document.createElement("cac:PartyIdentification");
		party.appendChild(partyidentification);

		addElement(document, partyidentification, "cbc:ID", empresaEnvio.getRuc());

		Element partyName = document.createElement("cac:PartyName");
		party.appendChild(partyName);

		addElement(document, partyName, "cbc:Name", empresaEnvio.getRazonSocial());

		Element sigAttach = document.createElement("cac:DigitalSignatureAttachment");
		signature.appendChild(sigAttach);

		Element extRef = document.createElement("cac:ExternalReference");
		sigAttach.appendChild(extRef);

		addElement(document, extRef, "cbc:URI", "#sign".concat(empresaEnvio.getRuc()));
	}

	private void addAccountingSupplierParty(EmpresaEnvio empresaEnvio, Document document, Element docElement) {
		Element supplier = document.createElement("cac:AccountingSupplierParty");
		docElement.appendChild(supplier);

		addElement(document, supplier, "cbc:CustomerAssignedAccountID", empresaEnvio.getRuc());

		addElement(document, supplier, "cbc:AdditionalAccountID", "6");

		Element supplierParty = document.createElement("cac:Party");
		supplier.appendChild(supplierParty);

		Element supplierPartyName = document.createElement("cac:PartyName");
		supplierParty.appendChild(supplierPartyName);

		addElement(document, supplierPartyName, "cbc:Name", empresaEnvio.getRazonSocial());

		Element postalAddress = document.createElement("cac:PostalAddress");
		supplierParty.appendChild(postalAddress);
		addElement(document, postalAddress, "cbc:ID", empresaEnvio.getIdUbigeo());
		addElement(document, postalAddress, "cbc:StreetName", empresaEnvio.getDireccion());
		addElement(document, postalAddress, "cbc:CityName", empresaEnvio.getDepartamento());
		addElement(document, postalAddress, "cbc:CountrySubentity", empresaEnvio.getProvincia());
		addElement(document, postalAddress, "cbc:District", empresaEnvio.getDistrito());

		Element country = document.createElement("cac:Country");
		postalAddress.appendChild(country);
		addElement(document, country, "cbc:IdentificationCode", empresaEnvio.getCodigoPais());

		Element legalEntity = document.createElement("cac:PartyLegalEntity");
		supplierParty.appendChild(legalEntity);

		addElement(document, legalEntity, "cbc:RegistrationName", empresaEnvio.getRazonSocial());
	}

	private void addNamespaces(Document document, Element docElement) {
		docElement.setAttribute("xmlns:cac",
				"urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2");
		docElement.setAttribute("xmlns:cbc", "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2");
		docElement.setAttribute("xmlns:ds", "http://www.w3.org/2000/09/xmldsig#");
		docElement.setAttribute("xmlns:ext",
				"urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2");
		docElement.setAttribute("xmlns:sac",
				"urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1");
		docElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
	}

	private String getXML(Document document) throws TransformerException {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
		transformer.setOutputProperty(OutputKeys.STANDALONE, "no");

		StringWriter sw = new StringWriter();
		StreamResult resultXML = new StreamResult(sw);
		DOMSource source = new DOMSource(document);
		transformer.transform(source, resultXML);
		return sw.toString();
	}

	private Document getDocument() throws ParserConfigurationException {

		String tipo = cboTipo.getSelectedID();

		String xmlns = "", tag = "";
		switch (tipo) {
		case "0":
			xmlns = "urn:sunat:names:specification:ubl:peru:schema:xsd:SummaryDocuments-1";
			tag = "SummaryDocuments";
			break;
		case "1":
			xmlns = "urn:sunat:names:specification:ubl:peru:schema:xsd:VoidedDocuments-1";
			tag = "VoidedDocuments";
			break;
		}

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		builder = factory.newDocumentBuilder();

		DOMImplementation implementation = builder.getDOMImplementation();
		Document document = implementation.createDocument(xmlns, tag, null);
		document.setXmlVersion("1.0");
		document.setXmlStandalone(true);

		return document;
	}

	private String getSufujiID() {
		String tipo = cboTipo.getSelectedID();
		switch (tipo) {
		case "0":
			return "RC";
		case "1":
			return "RA";
		default:
			return "";
		}

	}

	@Override
	public void dispose() {
		super.dispose();
	}

	/**
	 * 
	 */

	class MostrarResumen implements Runnable {

		private String fecha;
		private NSRTableModel tabla;
		private String idempresa;
		private String tipo;
		private String documento;

		private OrigenDatoDao odao = new OrigenDatoDao();
		private ODDatoDao oddao = new ODDatoDao();

		public MostrarResumen(String tipo, String documento, String fecha, String idempresa, NSRTableModel tabla) {
			this.tipo = tipo;
			this.documento = documento;
			this.fecha = fecha;
			this.tabla = tabla;
			this.idempresa = idempresa;
		}

		@Override
		public void run() {
			pb.setVisible(true);
			habilitaFormulario(false);

			List<OrigenDato> ods = null;
			try {
				ods = odao.getPorClaveIdEmpresaEnvio(1,idempresa);
			} catch (SQLException | NisiraORMException e) {
				appendToPane("E", UtilMensajes.getMensaje("ERR_TRAER_ODATOS"), e.getMessage());
				e.printStackTrace();
			}

			float rango = 100 / (float) ods.size();
			pb.setString("");
			pb.setValue(0);

			for (OrigenDato od : ods) {
				pb.setValue((int) (pb.getValue() + rango));
				pb.setString("Consultando origen de Datos: " + od.getDescripcion().trim().toUpperCase());
				try {
					switch (tipo) {
					case "0":
						switch (documento) {
						case "0":
							mostrarResumenBoletas(od);
							break;
						}
						break;

					case "1":
						switch (documento) {
						case "0":
							mostrarBajasTodos(od);
							break;
						}
						break;
					}

				} catch (Exception e) {
					appendToPane("E", UtilMensajes.getFormated("ERR_TRAER_PENDIENTES_ODATOS", od.getDescripcion()),
							e.getMessage());
					e.printStackTrace();
				}

			}
			pb.setVisible(false);
			pb.setValue(0);
			habilitaFormulario(true);

		}

		private void mostrarResumenBoletas(OrigenDato od) throws SQLException, NisiraORMException {
			List<Object[]> pendientes = oddao.getBoletas(od, fecha);

			for (Object[] r : pendientes) {
				Object[] row = new Object[13];
				row[0] = true;

				row[1] = r[0];
				row[2] = r[1];
				row[3] = r[2];
				row[4] = r[3];
				row[5] = r[4];
				row[6] = r[5];
				row[7] = r[6];
				row[8] = r[7];
				row[9] = r[8];
				row[10] = r[9];
				row[11] = r[10];
				row[12] = r[11];

				tabla.addRow(row);
			}
		}

		private void mostrarBajasTodos(OrigenDato od) throws SQLException, NisiraORMException {
			List<Object[]> pendientes = oddao.getBajasTodos(od, fecha);

			for (Object[] r : pendientes) {
				Object[] row = new Object[13];
				row[0] = true;

				row[1] = r[0];
				row[2] = r[1];
				row[3] = r[2];
				row[4] = r[3];
				row[5] = r[4];
				row[6] = r[5];
				row[7] = r[6];
				row[8] = r[7];
				row[9] = r[8];
				row[10] = r[9];
				row[11] = r[10];
				row[12] = r[11];
				tabla.addRow(row);
			}
		}

	}

	public static Element addElement(Document doc, Element element, String tagName, String tagValue) {
		Element tag = doc.createElement(tagName);
		tag.setTextContent(tagValue);
		element.appendChild(tag);
		return tag;
	}

	public Element addElement(Document doc, Element element, String tagName, String tagValue, String atrName,
			String atrValue) {
		Element tag = doc.createElement(tagName);
		tag.setTextContent(tagValue);
		tag.setAttribute(atrName, atrValue);
		element.appendChild(tag);

		return tag;
	}

	class VoidedDocumentsLine {
		public int lineID;
		public String documentTypeCode;
		public String documentSerialID;
		public int documentNumberID;
		public String voidReasonDescription;

		public Element getElement(Document doc) {
			Element e = doc.createElement("sac:VoidedDocumentsLine");
			addElement(doc, e, "cbc:LineID", String.valueOf(lineID));
			addElement(doc, e, "cbc:DocumentTypeCode", documentTypeCode);
			addElement(doc, e, "sac:DocumentSerialID", documentSerialID);
			addElement(doc, e, "sac:DocumentNumberID", String.valueOf(documentNumberID));
			addElement(doc, e, "VoidReasonDescription", voidReasonDescription);
			return e;
		}
	}

	class SummaryDocumentsLine {
		public int lineID;
		public String documentTypeCode;
		public String documentSerialID;
		public int startDocumentNumberID;
		public int endDocumentNumberID;
		public BigDecimal totalAmount;
		public String currencyID;

		public List<BillingPayment> billingPayments = new ArrayList<BillingPayment>();

		public boolean allowanceChargeIndicator = true;
		public BigDecimal allowanceChargeAmount = new BigDecimal("0.00");;

		public List<TaxTotal> taxTotals = new ArrayList<TaxTotal>();

		public Element getElement(Document doc) {
			Element e = doc.createElement("sac:SummaryDocumentsLine");

			addElement(doc, e, "cbc:LineID", String.valueOf(lineID));
			addElement(doc, e, "cbc:DocumentTypeCode", documentTypeCode);
			addElement(doc, e, "sac:DocumentSerialID", documentSerialID);
			addElement(doc, e, "sac:StartDocumentNumberID", String.valueOf(startDocumentNumberID));
			addElement(doc, e, "sac:EndDocumentNumberID", String.valueOf(endDocumentNumberID));
			addElement(doc, e, "sac:TotalAmount", totalAmount.toString(), "currencyID", currencyID);

			for (BillingPayment b : billingPayments) {
				e.appendChild(b.getElement(doc));
			}

			Element allowance = doc.createElement("cac:AllowanceCharge");

			addElement(doc, allowance, "cbc:ChargeIndicator", "true");
			addElement(doc, allowance, "cbc:Amount", allowanceChargeAmount.toString(), "currencyID", currencyID);

			e.appendChild(allowance);

			for (TaxTotal t : taxTotals) {
				e.appendChild(t.getElement(doc));
			}

			return e;
		}

		public BillingPayment getBillingPayment(String instructionID) {
			BillingPayment ret = null;

			for (BillingPayment b : billingPayments) {
				if (b.instructionID.equalsIgnoreCase(instructionID)) {
					ret = b;
					break;
				}
			}

			if (ret == null) {
				ret = new BillingPayment();
				ret.currencyID = currencyID;
				ret.instructionID = instructionID;
				ret.paidAmount = new BigDecimal("0.00");
				billingPayments.add(ret);
			}

			return ret;
		}

		public TaxTotal getTaxTotal(String schemeID) {
			TaxTotal ret = null;

			for (TaxTotal b : taxTotals) {
				if (b.TaxSchemeID.equalsIgnoreCase(schemeID)) {
					ret = b;
					break;
				}
			}

			if (ret == null) {
				ret = new TaxTotal();
				ret.TaxSchemeID = schemeID;
				ret.TaxSchemeName = (schemeID == "1000") ? "IGV" : "ISC";
				ret.TaxSchemeTaxTypeCode = (schemeID == "1000") ? "VAT" : "EXC";
				ret.taxAmount = new BigDecimal("0.00");
				ret.currencyID = currencyID;
				taxTotals.add(ret);
			}

			return ret;
		}

	}

	class BillingPayment {
		public BigDecimal paidAmount;
		public String instructionID;
		public String currencyID;

		public Element getElement(Document doc) {
			Element e = doc.createElement("sac:BillingPayment");
			addElement(doc, e, "cbc:PaidAmount", paidAmount.toString(), "currencyID", currencyID);
			addElement(doc, e, "cbc:InstructionID", instructionID);
			return e;
		}
	}

	class TaxTotal {
		public BigDecimal taxAmount;
		public String currencyID;
		public String TaxSchemeID;
		public String TaxSchemeName;
		public String TaxSchemeTaxTypeCode;

		public Element getElement(Document doc) {
			Element e = doc.createElement("cac:TaxTotal");
			addElement(doc, e, "cbc:TaxAmount", taxAmount.toString(), "currencyID", currencyID);

			Element taxSubTotal = doc.createElement("cac:TaxSubtotal");
			e.appendChild(taxSubTotal);

			addElement(doc, taxSubTotal, "cbc:TaxAmount", taxAmount.toString(), "currencyID", currencyID);

			Element taxCategory = doc.createElement("cac:TaxCategory");
			taxSubTotal.appendChild(taxCategory);

			Element taxScheme = doc.createElement("cac:TaxScheme");

			taxCategory.appendChild(taxScheme);

			addElement(doc, taxScheme, "cbc:ID", TaxSchemeID);
			addElement(doc, taxScheme, "cbc:Name", TaxSchemeName);
			addElement(doc, taxScheme, "cbc:TaxTypeCode", TaxSchemeTaxTypeCode);

			return e;
		}
	}
	
	private void actualizarResumenes() {
		String idempresa = cntEmpresaEnvio.txtCodigo.getText();
		Date fecha = dpHasta.getDate();
		
		if (idempresa != null && fecha != null) {
			try {
				cntResumen.setData(resumenDao.getPorIdEmpresaFechaResumen(1,idempresa, fecha));
			} catch (SQLException | NisiraORMException e) {
				e.printStackTrace();
			}
		} else {
			cntResumen.setData(new ArrayList<Resumen>());
		}
		
		cntResumen.llenar();
	}
	
	static String stripExtension(String str) {
		if (str == null)
			return null;
		int pos = str.lastIndexOf(".");
		if (pos == -1)
			return str;
		return str.substring(0, pos);
	}
}
