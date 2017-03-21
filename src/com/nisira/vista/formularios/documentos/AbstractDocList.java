package com.nisira.vista.formularios.documentos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.nisira.utilitarios.UtilMensajes;
import com.nisira.utils.NisiraUtils;

//import vista.formularios.listas.NSRTableList;
//import vista.formularios.listas.NSRTableModelList;

import com.nisira.vista.controles.NSRDatePicker;
import com.nisira.vista.controles.NSRInternalFrame;
import com.nisira.vista.controles.NSRTableList;
import com.nisira.vista.controles.NSRTableModelList;
import com.nisira.vista.controles.NSRTextField;
import com.nisira.vista.controles.NSRTextFieldCorrelativo;

import vista.combobox.ComboBox;

public abstract class AbstractDocList extends NSRInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ComboBox cboDocumento;// = new ComboBox();
	protected NSRTextFieldCorrelativo txtSerie;
	protected NSRTextFieldCorrelativo txtSerie1;
	private NSRDatePicker txtDesde;
	private NSRDatePicker txtHasta;
	protected JScrollPane pnlDocumentos = new JScrollPane();
	protected NSRTableList tblDocumentos;
	protected NSRTableModelList modelo_lista;

	private static final int _ancho = 20;
	private static final int _alto = 20;

	protected String[] cabeceras;
	protected Object[][] data;
	protected JLabel lblDocumento;
	private NSRTextField txtNumero;
	private JLabel label;
	protected String instancia;

	/**
	 * Crea la lista del documento con los filtros por defecto.
	 */
	public AbstractDocList(String titulo) {
		setPreferredSize(new Dimension(800, 450));
		setMinimumSize(new Dimension(600, 400));
		setSize(new Dimension(800, 450));
		setTitle(titulo);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setVisible(true);
		setResizable(true);
		getContentPane().add(pnlDocumentos, BorderLayout.CENTER);
		JPanel pnlFiltros = new JPanel();

		pnlFiltros.setPreferredSize(new Dimension(0, 70));

		pnlFiltros.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(pnlFiltros, BorderLayout.NORTH);

		JLabel lblDesde = new JLabel("Desde");

		txtDesde = new NSRDatePicker();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DAY_OF_MONTH, 1);
		txtDesde.setDate(c.getTime());

		JLabel lblHasta = new JLabel("Hasta");

		txtHasta = new NSRDatePicker();
		txtHasta.setDate(new Date());

		lblDocumento = new JLabel("Documento");
		cboDocumento = new ComboBox(new ArrayList<>(), 0);

		JLabel lblNmero = new JLabel("Correlativo");
		txtSerie1 = new NSRTextFieldCorrelativo(4);
		txtNumero = new NSRTextFieldCorrelativo(8);
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				llenarLista();
			}
		});

		GroupLayout gl_pnlFiltros = new GroupLayout(pnlFiltros);
		gl_pnlFiltros.setHorizontalGroup(gl_pnlFiltros.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlFiltros
				.createSequentialGroup().addGap(22)
				.addGroup(gl_pnlFiltros.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDesde, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDesde, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
				.addGap(26)
				.addGroup(gl_pnlFiltros.createParallelGroup(Alignment.LEADING)
						.addComponent(txtHasta, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHasta, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
				.addGap(36)
				.addGroup(gl_pnlFiltros.createParallelGroup(Alignment.LEADING).addComponent(lblDocumento)
						.addComponent(cboDocumento, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
				.addGap(12)
				.addGroup(gl_pnlFiltros.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNmero, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSerie1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_pnlFiltros.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlFiltros.createSequentialGroup().addGap(9).addComponent(txtNumero,
								GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addComponent(getLabel(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGap(57).addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)));
		gl_pnlFiltros.setVerticalGroup(gl_pnlFiltros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlFiltros.createSequentialGroup().addContainerGap().addComponent(lblNmero)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnlFiltros.createParallelGroup(Alignment.LEADING)
								.addComponent(txtSerie1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGap(11))
				.addGroup(Alignment.TRAILING,
						gl_pnlFiltros.createSequentialGroup().addContainerGap(31, Short.MAX_VALUE)
								.addComponent(btnActualizar).addGap(13))
				.addGroup(gl_pnlFiltros.createSequentialGroup().addGap(13).addComponent(lblDesde)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtDesde, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE).addGap(11))
				.addGroup(gl_pnlFiltros.createSequentialGroup().addGap(11)
						.addGroup(gl_pnlFiltros.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pnlFiltros.createSequentialGroup().addComponent(lblHasta)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtHasta,
												GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlFiltros.createSequentialGroup().addComponent(lblDocumento).addGap(7)
										.addComponent(cboDocumento, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(12))
				.addGroup(gl_pnlFiltros.createSequentialGroup().addGap(35).addComponent(getLabel()).addGap(18)));
		pnlFiltros.setLayout(gl_pnlFiltros);

		JPanel pnlOpciones = new JPanel();
		pnlOpciones.setPreferredSize(new Dimension(120, 0));
		pnlOpciones.setBorder(new TitledBorder(null, "Opciones", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		getContentPane().add(pnlOpciones, BorderLayout.WEST);
		GridBagLayout gbl_pnlOpciones = new GridBagLayout();
		gbl_pnlOpciones.columnWidths = new int[] { 106, 0 };
		gbl_pnlOpciones.rowHeights = new int[] { 29, 31, 29, 29, 0 };
		gbl_pnlOpciones.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_pnlOpciones.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlOpciones.setLayout(gbl_pnlOpciones);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(AbstractDocList.class.getResource("/resources/editar_lista3.png")));
		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});

		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevo();
			}
		});
		GridBagConstraints gbc_btnCrear = new GridBagConstraints();
		gbc_btnCrear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCrear.anchor = GridBagConstraints.NORTH;
		gbc_btnCrear.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrear.gridx = 0;
		gbc_btnCrear.gridy = 0;
		pnlOpciones.add(btnCrear, gbc_btnCrear);

		btnCrear.setIcon(new ImageIcon(new ImageIcon(AbstractDocList.class.getResource("/resources/nuevo.png"))
				.getImage().getScaledInstance(_ancho, _alto, java.awt.Image.SCALE_DEFAULT)));
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditar.anchor = GridBagConstraints.NORTH;
		gbc_btnEditar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditar.gridx = 0;
		gbc_btnEditar.gridy = 1;
		pnlOpciones.add(btnEditar, gbc_btnEditar);
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnImprimir.setIcon(new ImageIcon(new ImageIcon(AbstractDocList.class.getResource("/resources/printer.png"))
				.getImage().getScaledInstance(_ancho, _alto, java.awt.Image.SCALE_DEFAULT)));

		GridBagConstraints gbc_btnImprimir = new GridBagConstraints();
		gbc_btnImprimir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnImprimir.anchor = GridBagConstraints.NORTH;
		gbc_btnImprimir.insets = new Insets(0, 0, 5, 0);
		gbc_btnImprimir.gridx = 0;
		gbc_btnImprimir.gridy = 2;
		pnlOpciones.add(btnImprimir, gbc_btnImprimir);

		JButton btnVer = new JButton("Abrir");
		GridBagConstraints gbc_btnVer = new GridBagConstraints();
		gbc_btnVer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVer.anchor = GridBagConstraints.NORTH;
		gbc_btnVer.gridx = 0;
		gbc_btnVer.gridy = 3;
		pnlOpciones.add(btnVer, gbc_btnVer);

		btnVer.setIcon(new ImageIcon(new ImageIcon(AbstractDocList.class.getResource("/resources/abrir.png")).getImage()
				.getScaledInstance(_ancho, _alto, java.awt.Image.SCALE_DEFAULT)));
		btnVer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ver();
			}
		});
		setBounds(100, 100, 818, 465);
	}

	public void llenarLista() {
		int inumero = 0;

		String serie = this.txtSerie1.getText().trim().length() == 0 ? "" : this.txtSerie1.getText().trim();
		if (this.txtNumero.getText().trim().length() > 0)
			inumero = Integer.parseInt(this.txtNumero.getText().trim());
		modelo_lista.limpiar();
		for (Object[] data : getData(NisiraUtils.getHoraInicial(txtDesde.getDate()),
				NisiraUtils.getHoraFinal(txtHasta.getDate()), serie, inumero)) {
			modelo_lista.addRow(data);
		}
	}

	public abstract Object getPK();

	private AbstractDocForm nuevaInstancia()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String urlClase = this.instancia;
		AbstractDocForm frame = (AbstractDocForm) Class.forName(urlClase).newInstance();
		frame.setVisible(true);
		com.nisira.Inicio.desktoppane.add(frame);
		try {
			frame.setSelected(true);
			frame.moveToFront();
		} catch (PropertyVetoException e) {
			frame = null;
			e.printStackTrace();
		}
		return frame;
	}

	public abstract Object[][] getData(Date desde, Date hasta, String serie, int numero);

	public void nuevo() {
		try {
			AbstractDocForm form = nuevaInstancia();
			form.DoNuevo();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void editar() {
		Object pk = getPK();

		if (pk != null) {
			try {
				AbstractDocForm form = nuevaInstancia();
				form.llenarPorId(pk);
				form.editar();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			UtilMensajes.mensaje_alterta("SEL_DOC_ABRIR");
		}
	}

	public void ver() {
		Object pk = getPK();
		if (pk != null) {
			try {
				AbstractDocForm form = nuevaInstancia();
				form.llenarPorId(pk);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			UtilMensajes.mensaje_alterta("SEL_DOC_ABRIR");
		}
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("-");
		}
		return label;
	}

	public String getInstancia() {
		return instancia;
	}

	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}

}