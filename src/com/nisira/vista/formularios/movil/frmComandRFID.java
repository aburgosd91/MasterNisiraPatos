package com.nisira.vista.formularios.movil;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.nisira.core.NisiraORMException;
import com.nisira.dao.COMANDOSRFIDDao;
import com.nisira.entidad.COMANDOSRFID;
import java.awt.Dimension;

public class frmComandRFID extends AbstractWindowsMovil {
	private JScrollPane scrollPane;
	private JTable tblComand;
	private List<COMANDOSRFID> lstcmd;
	private COMANDOSRFID slccmd;
	private COMANDOSRFIDDao cmdDao;
	private List<ChangeListener> listenerList = new ArrayList<ChangeListener>();

	public frmComandRFID(String title) {
		super(title);
		setMinimumSize(new Dimension(500, 325));
		setSize(new Dimension(500, 325));
		lstcmd = new ArrayList<COMANDOSRFID>();
		slccmd = new COMANDOSRFID();
		cmdDao = new COMANDOSRFIDDao();
		scrollPane = new JScrollPane();
		try {
			lstcmd = cmdDao.listar(1);
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getPanelDataTable().add(scrollPane, BorderLayout.CENTER);

		tblComand = new JTable();
		tblComand.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblComand.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Item", "Comando", "Descripcion" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		DefaultTableModel m = (DefaultTableModel) tblComand.getModel();
		for (COMANDOSRFID co : lstcmd) {
			m.addRow(new Object[] { co.getIDCOMANDO(), co.getCOMANDO(), co.getDESCRIPCION() });
		}
		tblComand.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tblComand.getSelectedRow();
				if (selectedRow >= 0)
					setSlccmd(getLstcmd().get(selectedRow));
				else
					setSlccmd(null);
			}
		});
		scrollPane.setViewportView(tblComand);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		ChangeEvent ce = new ChangeEvent(this);
		for (ChangeListener listener : listenerList) {
			listener.stateChanged(ce);
		}
		this.dispose();
	}

	@Override
	public void actualizar() {
		try {
			lstcmd = cmdDao.listar(1);
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefaultTableModel m = (DefaultTableModel) tblComand.getModel();
		for (COMANDOSRFID co : lstcmd) {
			m.addRow(new Object[] { co.getIDCOMANDO(), co.getCOMANDO(), co.getDESCRIPCION() });
		}
	}

	@Override
	public void salir() {
		this.dispose();
	}

	public List<COMANDOSRFID> getLstcmd() {
		return lstcmd;
	}

	public void setLstcmd(List<COMANDOSRFID> lstcmd) {
		this.lstcmd = lstcmd;
	}

	public COMANDOSRFID getSlccmd() {
		return slccmd;
	}

	public void setSlccmd(COMANDOSRFID slccmd) {
		this.slccmd = slccmd;
	}

	public void addChangeListener(ChangeListener listener) {
		listenerList.add(listener);
	}

	@Override
	public void detener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void maximizar() {
		// TODO Auto-generated method stub
		
	}
}
