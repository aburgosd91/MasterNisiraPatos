package com.nisira.vista.formularios.maestros;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.nisira.utilitarios.UtilMensajes;
import com.nisira.vista.controles.NSRInternalFrame;
import com.nisira.vista.controles.NSRTableList;
import com.nisira.vista.controles.NSRTableModelList;
import com.nisira.vista.controles.NSRTextFieldCorrelativo;

public abstract class AbstractMaestroList extends NSRInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected NSRTextFieldCorrelativo txtSerie;
	protected JScrollPane pnlDocumentos = new JScrollPane();
	protected NSRTableList tblDocumentos;
	protected NSRTableModelList modelo_lista;

	private static final int _ancho = 20;
	private static final int _alto = 20;

	protected String[] cabeceras;
	protected Object[][] data;
	protected String instancia;
	
	/**
	 * Crea la lista del documento con los filtros por defecto.
	 */
	public AbstractMaestroList(String titulo) {
		setTitle(titulo);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setVisible(true);
		setResizable(true);
		getContentPane().add(pnlDocumentos, BorderLayout.CENTER);
		JPanel pnlFiltros = new JPanel();

		pnlFiltros.setPreferredSize(new Dimension(0, 50));

		pnlFiltros.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(pnlFiltros, BorderLayout.NORTH);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DAY_OF_MONTH, 1);
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				llenarLista();
			}
		});

		GroupLayout gl_pnlFiltros = new GroupLayout(pnlFiltros);
		gl_pnlFiltros.setHorizontalGroup(
			gl_pnlFiltros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlFiltros.createSequentialGroup()
					.addGap(640)
					.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlFiltros.setVerticalGroup(
			gl_pnlFiltros.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlFiltros.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnActualizar)
					.addGap(13))
		);
		pnlFiltros.setLayout(gl_pnlFiltros);

		JPanel pnlOpciones = new JPanel();
		pnlOpciones.setPreferredSize(new Dimension(120, 0));
		pnlOpciones.setBorder(new TitledBorder(null, "Opciones", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		getContentPane().add(pnlOpciones, BorderLayout.WEST);
		GridBagLayout gbl_pnlOpciones = new GridBagLayout();
		gbl_pnlOpciones.columnWidths = new int[]{106, 0};
		gbl_pnlOpciones.rowHeights = new int[]{29, 31, 29, 29, 0};
		gbl_pnlOpciones.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlOpciones.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlOpciones.setLayout(gbl_pnlOpciones);
		
				JButton btnEditar = new JButton("Editar");
				btnEditar.setIcon(new ImageIcon(AbstractMaestroList.class.getResource("/resources/editar_lista3.png")));
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
						
								btnCrear.setIcon(
										new ImageIcon(new ImageIcon(AbstractMaestroList.class.getResource("/resources/nuevo.png"))
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
				btnImprimir.setIcon(
						new ImageIcon(new ImageIcon(AbstractMaestroList.class.getResource("/resources/printer.png"))
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
				
						btnVer.setIcon(
								new ImageIcon(new ImageIcon(AbstractMaestroList.class.getResource("/resources/abrir.png"))
										.getImage().getScaledInstance(_ancho, _alto, java.awt.Image.SCALE_DEFAULT)));
						btnVer.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								ver();
							}
						});
		setBounds(100, 100, 763, 325);
	}

	public void llenarLista() {
		modelo_lista.limpiar();
		for (Object[] data : getData()) {
			modelo_lista.addRow(data);
		}
	}

	public abstract Object getPK();

	private AbstractMaestro nuevaInstancia()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String urlClase = this.instancia;
		AbstractMaestro frame = (AbstractMaestro) Class.forName(urlClase).newInstance();
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

	public abstract Object[][] getData();

	public void nuevo() {
		try {
			AbstractMaestro form = nuevaInstancia();
			form.DoNuevo();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void editar() {
		Object pk = getPK();
		
		if (pk != null) {
			try {
				AbstractMaestro form = nuevaInstancia();
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
				AbstractMaestro form = nuevaInstancia();
				form.llenarPorId(pk);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			UtilMensajes.mensaje_alterta("SEL_DOC_ABRIR");
		}
	}

	public String getInstancia() {
		return instancia;
	}

	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}
	
}