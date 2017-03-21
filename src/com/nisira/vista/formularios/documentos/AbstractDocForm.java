package com.nisira.vista.formularios.documentos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.nisira.Inicio;
import com.nisira.MainFrame;
import com.nisira.utilitarios.UtilMensajes;
import com.nisira.vista.barras.IFormDocumento;
import com.nisira.vista.barras.PanelBarraDocumento;
import com.nisira.vista.controles.NSRInternalFrame;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.view.JasperViewer;

public abstract class AbstractDocForm extends NSRInternalFrame implements IFormDocumento, InternalFrameListener {
	private static final long serialVersionUID = 1L;
	protected PanelBarraDocumento barra;
	protected JPanel pnlPrincipal;
	protected String estado;

	public AbstractDocForm(String titulo) {
		setTitle(titulo);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addInternalFrameListener(this);
		initBarra();
		int AnchoCabecera = 850;

		pnlPrincipal = new JPanel();
		pnlPrincipal.setMinimumSize(new Dimension(AnchoCabecera, 500));
		pnlPrincipal.setPreferredSize(new Dimension(AnchoCabecera, 500));
		pnlPrincipal.setBounds(0, 40, AnchoCabecera, 70);

		getContentPane().add(pnlPrincipal);

		setEstado(VISTA);
		setBounds(100, 100, 854, 465);

		this.pnlPrincipal.setLayout(null);
	}

	public void initBarra() {
		int AnchoCabecera = 850;
		barra = new PanelBarraDocumento();
		barra.setMinimumSize(new Dimension(AnchoCabecera, 40));
		barra.setPreferredSize(new Dimension(AnchoCabecera, 40));
		barra.setBounds(0, 0, AnchoCabecera, 42);
		barra.setFormMaestro(this);
		FlowLayout flowLayout = (FlowLayout) barra.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(barra, BorderLayout.NORTH);
	}

	public void iniciar() {
		llenar_tablas();
		llenar_datos();
		getBarra().enVista();
		vista_noedicion();
	}

	public abstract void nuevo();

	public void editar() {
		if (isEditable()) {
			setEstado(EDICION);
			getBarra().enEdicion();
			vista_edicion();
		}
	}

	public abstract void anular();

	public abstract void grabar();

	public abstract void eliminar();

	public abstract void llenar_datos();

	public abstract void llenar_tablas();

	public abstract void vista_edicion();

	public abstract void vista_noedicion();

	public abstract void llenarPorId(Object id);

	public abstract boolean isEditable();

	public void cancelar() {
		llenar_tablas();
		llenar_datos();
		setEstado(VISTA);
		vista_noedicion();
		getBarra().enVista();
	}

	public void DoGrabar() {
		boolean esVistaValido;
		esVistaValido = isValidaVista();
		if (esVistaValido) {
			llenarDesdeVista();
			grabar();
			setEstado(VISTA);
			getBarra().enVista();
			vista_noedicion();
			llenar_tablas();
			llenar_datos();
		}
	}

	public void DoNuevo() {
		nuevo();
		setEstado(NUEVO);
		getBarra().enEdicion();
		llenar_datos();
		vista_edicion();
	}

	public void DoEliminar() {
		int opcion = UtilMensajes.mensaje_sino("DESEA_ELIMINAR_DOC");
		if (opcion == 0) {
			eliminar();
			setEstado(VISTA);
			getBarra().enVista();
			vista_noedicion();
			llenarPorId(null);
			llenar_datos();
		}
	}

	public abstract void llenarDesdeVista();

	public abstract boolean isValidaVista();

	public void doVerAsiento() {

	}

	public void doSalir() {
		if (!estado.equalsIgnoreCase(VISTA)) {
			int seleccion = UtilMensajes.mensaje_sino("CERRAR_DOCUMENTO");
			if (seleccion == 0) {
				this.dispose();
			}
		} else {
			this.dispose();
		}
	}

	private JasperPrint getPrintReport() {
		String reporte = Inicio.empresa.getRUTA_EXPORTAR() + "\\" + getNombreReporte() + ".jrxml";

		String reporte_compilado = Inicio.empresa.getRUTA_EXPORTAR() + "\\" + getNombreReporte() + ".jasper";

		try {
			File f = new File(reporte_compilado);
			if (!f.isFile()) {
				JasperCompileManager.compileReportToFile(reporte, reporte_compilado);
			}

			// final JasperReport report =
			// JasperCompileManager.compileReport(reporte);

			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte_compilado, getParamsReport(),
					getDataSourceReport());
			jasperPrint.setName(getNombreArchivo());
			return jasperPrint;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(Inicio.mainF, "No se pudo abrir el archivo: " + reporte);
			return null;
		}
	}

	private File getPathSaveFile(String ext, String dsc_ext) {
		FileNameExtensionFilter filtro = new FileNameExtensionFilter(ext, dsc_ext);

		JFileChooser chooser = new JFileChooser();
		chooser.setDialogType(JFileChooser.SAVE_DIALOG);

		chooser.setSelectedFile(new File(getNombreArchivo() + ext));
		chooser.setFileFilter(filtro);

		String destinationFileName;
		if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			boolean doExport = true;

			boolean overrideExistingFile = false;

			File destinationFile = new File(chooser.getSelectedFile().getAbsolutePath());

			destinationFileName = destinationFile.getAbsolutePath();

			if (!destinationFileName.endsWith(ext)) {
				destinationFile = new File(destinationFileName + ext);
			}
			while (doExport && destinationFile.exists() && !overrideExistingFile) {

				overrideExistingFile = (UtilMensajes.mensaje_sino("REEMPLAZAR_ARCHIVO") == 0);

				if (!overrideExistingFile) {
					if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
						destinationFile = new File(chooser.getSelectedFile().getAbsolutePath());
						destinationFileName = destinationFile.getAbsolutePath();
						if (!destinationFileName.endsWith(ext)) {
							destinationFile = new File(destinationFileName + ext);
						}
					} else {
						doExport = false;
					}
				}
			}

			if (doExport) {
				return destinationFile;
			}
		}
		return null;

	}

	public void doExportaExcel() {

		File file = getPathSaveFile(".xlsx", "xlsx");
		if (file != null) {
			JasperPrint print = getPrintReport();

			if (print != null) {

				JRXlsxExporter exporter = new JRXlsxExporter();

				exporter.setExporterInput(new SimpleExporterInput(print));
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file));
				try {
					exporter.exportReport();
				} catch (JRException e) {
					e.printStackTrace();
				}
			}
		}

	};

	public void doExportaPDF() {
		File file = getPathSaveFile(".pdf", "pdf");

		JasperPrint print = getPrintReport();

		if (print != null && file != null) {
			// final String target = getExportar() + ".pdf";
			try {
				JasperExportManager.exportReportToPdfFile(print, file.getAbsolutePath());
			} catch (JRException e) {
				e.printStackTrace();
			}
		}
	};

	public void doExportaOdt() {

		JasperPrint print = getPrintReport();

		// File doc = new File(getExportar() + ".odt");
		File file = getPathSaveFile(".odt", "odt");

		if (print != null && file != null) {

			JROdtExporter exporter = new JROdtExporter();
			exporter.setExporterInput(new SimpleExporterInput(print));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file.getAbsolutePath()));
			try {
				exporter.exportReport();
			} catch (JRException e) {
				e.printStackTrace();
			}
		}
	};

	public void doExportaOds() {

		JasperPrint print = getPrintReport();
		File file = getPathSaveFile(".ods", "ods");
		if (print != null && file != null) {
			// File doc = new File(getExportar() + ".ods");

			JROdsExporter exporter = new JROdsExporter();
			exporter.setExporterInput(new SimpleExporterInput(print));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file));
			try {
				exporter.exportReport();
			} catch (JRException e) {
				e.printStackTrace();
			}
		}
	};

	public void doExportaWord() {
		JasperPrint print = getPrintReport();

		File file = getPathSaveFile(".docx", "docx");

		if (print != null) {
			// File doc = new File(getExportar() + ".docx");

			JRDocxExporter exporter = new JRDocxExporter();
			exporter.setExporterInput(new SimpleExporterInput(print));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file));
			try {
				exporter.exportReport();
			} catch (JRException e) {
				e.printStackTrace();
			}
		}
	};

	@Override
	public void doPrevio() {
		JasperPrint print = getPrintReport();

		if (print != null) {
			JasperViewer jv = new JasperViewer(print, false);
			jv.setTitle("Vista Previa de " + getNombreArchivo());
			jv.setIconImage(new ImageIcon(MainFrame.class.getResource("/resources/nisiralogo.png")).getImage());
			jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jv.setVisible(true);
		}
	}

	@Override
	public void doImprimir() {
		JasperPrint print = getPrintReport();

		if (print != null) {
			try {
				JasperPrintManager.printReport(print, true);
			} catch (JRException e) {
				e.printStackTrace();
			}
		}
	}

	protected JRDataSource getDataSourceReport() {
		JOptionPane.showMessageDialog(null,
				"Sobreescribir el metodo getDataSourceReport(); - Data source enviado al formato de impresión");
		return new JREmptyDataSource();
	}

	protected Map<String, Object> getParamsReport() {
		JOptionPane.showMessageDialog(null,
				"Sobreescribir el metodo getParamsReport(); - Parametros enviado al formato de impresión");
		return new HashMap<String, Object>();
	}

	protected String getNombreArchivo() {
		JOptionPane.showMessageDialog(null,
				"Sobreescribir el metodo getNombreArchivo(); - Nombre del Archivo que se va a generar (Sin Extension)");
		return "Documento";
	}

	protected String getNombreReporte() {
		JOptionPane.showMessageDialog(null,
				"Sobreescribir el metodo getNombreReporte(); - Nombre del Archivo jasperreport sin compilar <.jasper> (SinExtension - Puede usar carpetas '\\')");
		return "Documento";
	}

	protected abstract void limpiarVista();

	public PanelBarraDocumento getBarra() {
		return barra;
	}

	public void setBarra(PanelBarraDocumento barra) {
		this.barra = barra;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		doSalir();
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
	}
}
