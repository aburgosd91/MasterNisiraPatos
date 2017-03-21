package com.nisira.vista.formularios;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.alien.enterpriseRFID.discovery.*;
import com.alien.enterpriseRFID.reader.AlienReaderCommandErrorException;
import com.alien.enterpriseRFID.reader.AlienReaderConnectionException;
import com.alien.enterpriseRFID.reader.AlienReaderException;
import com.alien.enterpriseRFID.reader.AlienReaderTimeoutException;
import com.nisira.alien.ComandosRfid;
import com.nisira.alien.ReaderAlien;
import com.nisira.core.NisiraORMException;
import com.nisira.dao.COMANDOSRFIDDao;
import com.nisira.dao.DANTENADao;
import com.nisira.dao.DPUERTOCOMDao;
import com.nisira.dao.RFIDREADERDao;
import com.nisira.entidad.COMANDOSRFID;
import com.nisira.entidad.DANTENA;
import com.nisira.entidad.DPUERTOCOM;
import com.nisira.entidad.RFIDREADER;
import com.nisira.entidad.SysFormulario;
import com.nisira.entidad.TABLASINCRONIZA;
import com.nisira.thread.NotacionesThread;
import com.nisira.utils.nisiracore.Constantes;
import com.nisira.vista.controles.MaestroTableModel;
import com.nisira.vista.controles.NSRInternalFrame;
import com.nisira.vista.controles.NSRTable;
import com.nisira.vista.controles.NSRTableModel;
import com.nisira.vista.formularios.FrmConfigAlien.LecturaTagThread;
import com.nisira.vista.formularios.movil.frmComandRFID;

import core.inicio.ConfigInicial;
import core.inicio.ThreadGeneral;

import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmRFIDreader extends NSRInternalFrame implements InternalFrameListener{
	private static final long serialVersionUID = 1L;
	private RFIDREADERDao rfiDAO;
	private RFIDREADER slcrfid;
	private List<DPUERTOCOM> lstdpuert;
	private DPUERTOCOMDao dportDAO;
	private List<DANTENA> lstdant;
	private DANTENADao dantDAO;
	private List<COMANDOSRFID> lstcmdr;
	private COMANDOSRFIDDao comanDAO;
	private NSRTable tblDant;
	private NSRTable tblDport;
	private JTextField textField;
	private JTextField textField_1;
	private JScrollPane scrollPanelAnt;
	private JScrollPane scrollPanelPort;
	private boolean th;
	private JTextArea textArea;
	private String cmd;

	public FrmRFIDreader() throws PropertyVetoException {
		this.addInternalFrameListener(this);
		th = true;
		setTitle("RFID reader");
		setPreferredSize(new Dimension(757, 747));
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setSize(new Dimension(757, 593));
		lstdant = new ArrayList<DANTENA>();
		lstdpuert = new ArrayList<DPUERTOCOM>();
		rfiDAO = new RFIDREADERDao();
		dportDAO = new DPUERTOCOMDao();
		dantDAO = new DANTENADao();
		scrollPanelAnt = new JScrollPane();
		scrollPanelAnt.setAutoscrolls(true);

		scrollPanelPort = new JScrollPane();
		scrollPanelPort.setAutoscrolls(true);

		JLabel lblEstado = new JLabel("Estado");

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rda = getDetDANT().getRowCount();
				int rdp = getDetDPORT().getRowCount();
				JTable t1 = getDetDANT().getTable();
				JTable t2 = getDetDPORT().getTable();
				for (int i = 0; i < rda; i++) {
					lstdant.get(i).setACTIVO((boolean) t1.getValueAt(i, 2) ? 1 : 0);
				}
				for (int i = 0; i < rdp; i++) {
					lstdpuert.get(i).setACTIVO((boolean)t2.getValueAt(i, 2) ? 1 : 0);
				}
				for (DPUERTOCOM dp : lstdpuert) {
					try {
						dportDAO.mezclar(1, dp);
					} catch (NisiraORMException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for (DANTENA da : lstdant) {
					try {
						dantDAO.mezclar(1, da);
					} catch (NisiraORMException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				llenar_datos();
				validReader();
			}
		});

		JLabel lblNewLabel = new JLabel("Comando");

		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setEditable(false);
		textField_1.setColumns(10);

		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equalsIgnoreCase("Conectado")) {
					frmComandRFID rfrm = new frmComandRFID("Comandos");
					getDesktopPane().add(rfrm);
					rfrm.setVisible(true);
					rfrm.show();
					rfrm.addChangeListener(new ChangeListener() {
						@Override
						public void stateChanged(ChangeEvent arg0) {
							textField_1.setText(rfrm.getSlccmd().getCOMANDO());
						}
					});
				}
			}
		});
		btnSearch.setIcon(new ImageIcon(FrmRFIDreader.class.getResource("/resources/FrmAgregar.png")));

		JButton btnEjecutar = new JButton("Insertar");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				th=true;
				consoleThread ej = new consoleThread();
				int rdp = getDetDPORT().getRowCount();
				for (int i = 0; i < rdp; i++) {
					if ((boolean) getDetDPORT().getTable().getValueAt(i, 2)) {
						cmd = (String) getDetDPORT().getTable().getValueAt(i, 1);
					}
				}
//				Thread hilo = new Thread(ej, ThreadGeneral.hilo_FrmRFIDREADER_CMD);
				Thread hilo = new Thread(ej, NotacionesThread.tFrmRFIDreader_CMD);
				hilo.start();
				Constantes.log.info(hilo.getName());
			}
		});

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});

		JButton btnStop = new JButton("Parar");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				killHilo();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblEstado)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
									.addGap(56)
									.addComponent(btnGuardar))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnSearch))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnEjecutar)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnLimpiar)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnStop))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(scrollPanelAnt, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
									.addGap(40)))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnActualizar)
									.addGap(255))
								.addComponent(scrollPanelPort, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(btnGuardar)
						.addComponent(btnActualizar)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPanelPort, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPanelAnt, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEjecutar)
						.addComponent(btnLimpiar)
						.addComponent(btnStop))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addGap(157))
		);
		
				textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
		tblDant = new NSRTable(new NSRTableModel(new String[] { "#Item", "Antena", "Estado" }) {
			/*************************************************/
			private static final long serialVersionUID = 1L;

			@Override
			public boolean evaluaEdicion(int row, int column) {
				if (column == 2)
					return true;
				return getEditar();
			}

			@Override
			public void addRow() {
				addRow(new Object[] { "", "", false });
			}

			@Override
			public Class<?> getColumnClass(int column) {
				// TODO Auto-generated method stub
				if (column == 2) {
					return Boolean.class;
				}
				return super.getColumnClass(column);
			}

		});
		tblDant.setFillsViewportHeight(true);
		scrollPanelAnt.setViewportView(tblDant);
		tblDant.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getDetDANT().setNombre_detalle("Antenas");

		getDetDANT().setObligatorios(0, 1);
		getDetDANT().setRepetidos(0);
		getDetDANT().setScrollAndTable(scrollPanelAnt, tblDant);
		try {
			if (!rfiDAO.listar(1, "IDEMPRESA = ? and NROSERIE = ? and IDCPUMOVIL = ?", ConfigInicial.LlenarConfig()[8],
					ConfigInicial.LlenarConfig()[17],ConfigInicial.LlenarConfig()[18]).isEmpty()){
				slcrfid = rfiDAO.listar(1, "IDEMPRESA = ? and NROSERIE = ? and IDCPUMOVIL = ?", ConfigInicial.LlenarConfig()[8],
						ConfigInicial.LlenarConfig()[17],ConfigInicial.LlenarConfig()[18]).get(0);
			}
			
		} catch (NisiraORMException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tblDport = new NSRTable(new NSRTableModel(new String[] { "#Item", "Puerto", "Estado" }) {
			/*************************************************/
			private static final long serialVersionUID = 1L;

			@Override
			public boolean evaluaEdicion(int row, int column) {
				if (column == 2)
					return true;
				return getEditar();
			}

			@Override
			public void addRow() {
				addRow(new Object[] { "", "", false });
			}

			@Override
			public Class<?> getColumnClass(int column) {
				// TODO Auto-generated method stub
				if (column == 2) {
					return Boolean.class;
				}
				return super.getColumnClass(column);
			}
		});
		tblDport.setFillsViewportHeight(true);
		scrollPanelPort.setViewportView(tblDport);
		tblDport.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getDetDPORT().setNombre_detalle("Puertos");

		getDetDPORT().setObligatorios(0, 1);
		getDetDPORT().setRepetidos(0);
		getDetDPORT().setScrollAndTable(scrollPanelPort, tblDport);
		getContentPane().setLayout(groupLayout);
		llenar_datos();
		validReader();
	}

	public void llenar_datos() {
		limpiarVista();
		if (getSlcrfid() != null) {
			try {
				lstdant = dantDAO.listaDesc(1, getSlcrfid().getIDEMPRESA(), getSlcrfid().getIDCPUMOVIL());
				lstdpuert = dportDAO.listaDesc(1, getSlcrfid().getIDEMPRESA(), getSlcrfid().getIDCPUMOVIL());
//				lstdpuert =(new DPUERTOCOMDao()).listaDescActivo(1, getSlcrfid().getIDEMPRESA(), getSlcrfid().getIDCPUMOVIL());
			} catch (NisiraORMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i =1;
			for (DANTENA da : lstdant) {
				getDetDANT().addRow(
						new Object[] {i, da.getDescripcion(), (da.getACTIVO() == 1 ? true : false) });
				i++;
			}
			for (DPUERTOCOM da : lstdpuert) {
				getDetDPORT().addRow(
						new Object[] { da.getORDEN(), da.getDescripcion(), (da.getACTIVO() == 1 ? true : false) });
			}
		}
	}

	public void validReader() {
		DiscoveryItem[] d = null;
		try {
			SerialDiscoveryListenerService service = new SerialDiscoveryListenerService();
			service.run();
			 d = service.getDiscoveryItems();
			service.stopService();
		} catch (AlienDiscoverySerialException e1) {
			// TODO Auto-generated catch block
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			textArea.append("D = "+d.length);
			textArea.append(sw.getBuffer().toString());
		}
			String MAC = null;
			if (d.length != 0 || lstdpuert ==null) {
				boolean f = false;
				for (DiscoveryItem da : d) {
					for(DPUERTOCOM puerto :lstdpuert){
						if (da.getReaderAddress().equalsIgnoreCase(puerto.getDescripcion())) {
							if (puerto.getACTIVO()==1) {
								MAC = da.getReaderMACAddress();
								f = true;
								break;
							}
						}
					}
				}
				if (f) {
					if (MAC.trim().equalsIgnoreCase(slcrfid.getNROSERIE().trim())) {
						textField.setText("Conectado");
						textField.setBackground(new Color(0, 153, 51));
					} else {
						textField.setText("No coincide la Direccion MAC");
						textField.setBackground(new Color(255, 0, 0));
					}

				} else {
					String cadenaCOM = "(";
					for(DPUERTOCOM puerto :lstdpuert)
						cadenaCOM+= " "+puerto.getDescripcion()+" ";
					cadenaCOM += ")";
					textField.setText("No disponible en puerto " + cadenaCOM);
					textField.setBackground(new Color(255, 255, 0));
				}
			} else {
				textField.setText("Desconectado");
				textField.setBackground(new Color(255, 0, 0));
			}
			textArea.append("D = "+d.length);
		
	}

	public void limpiarVista() {
		getDetDANT().limpiar();
		getDetDPORT().limpiar();
	}

	class consoleThread implements Runnable {
		@Override
		public void run() {
			textArea.setText("");
			ReaderAlien.ClearConsole();
			int rda = getDetDANT().getRowCount();
			JTable t1 = getDetDANT().getTable();
			List<String> ant =new ArrayList<String>();
			for (int i = 0; i < rda; i++) {
				if((boolean) t1.getValueAt(i, 2)){
					ant.add(String.valueOf(i));
				}
			}
			// TODO Auto-generated method stub
			try {
				while (th) {
					if (textField_1.getText().equalsIgnoreCase("t")) {
					ReaderAlien.exectComando(textField_1.getText(),cmd,ant);
					} else {
						ReaderAlien.exectComando(textField_1.getText(),cmd,ant);
						th = false;
					}
					System.out.println(ReaderAlien.getMensajeConsole());
					textArea.append(ReaderAlien.getMensajeConsole());
				}
			} catch (AlienReaderException e) {
				ReaderAlien.addConsole(e.getMessage());
				// textConsole.setText(ReaderAlien.getMensajeConsole());
				textArea.append(ReaderAlien.getMensajeConsole());
				// ComandosRfid.closeConsole();
				e.printStackTrace();
			}
			if (!th) {
				killHilo();
			}
		}
	}

	public void killHilo() {
		th=false;
		ComandosRfid.closeConsole();
		System.out.println("killHilo");
		NotacionesThread.stopThreadClass("FrmRFIDreader");
	}

	public RFIDREADER getSlcrfid() {
		return slcrfid;
	}

	public void setSlcrfid(RFIDREADER slcrfid) {
		this.slcrfid = slcrfid;
	}

	public List<DPUERTOCOM> getLstdpuert() {
		return lstdpuert;
	}

	public void setLstdpuert(List<DPUERTOCOM> lstdpuert) {
		this.lstdpuert = lstdpuert;
	}

	public List<DANTENA> getLstdant() {
		return lstdant;
	}

	public void setLstdant(List<DANTENA> lstdant) {
		this.lstdant = lstdant;
	}

	public List<COMANDOSRFID> getLstcmdr() {
		return lstcmdr;
	}

	public void setLstcmdr(List<COMANDOSRFID> lstcmdr) {
		this.lstcmdr = lstcmdr;
	}

	public NSRTableModel getDetDANT() {
		return ((NSRTableModel) tblDant.getModel());
	}

	public NSRTableModel getDetDPORT() {
		return ((NSRTableModel) tblDport.getModel());
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		killHilo();
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		killHilo();
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
