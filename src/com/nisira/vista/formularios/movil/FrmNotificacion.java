package com.nisira.vista.formularios.movil;

import java.awt.Color;
import java.awt.Component;
import static com.nisira.utils.NisiraUtils.isNull;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.beans.PropertyVetoException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import org.oxbow.swingbits.table.filter.TableRowFilterSupport;

import com.nisira.Inicio;
import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.core.NisiraORMException;
import com.nisira.dao.NOTIFICACIONDao;
import com.nisira.entidad.NOTIFICACION;
import com.nisira.utils.NisiraUtils;
import com.nisira.utils.nisiracore.Constantes;
import com.nisira.vista.barras.PanelBarraMaestro;
import com.nisira.vista.controles.NSRTable;
import com.nisira.vista.controles.NSRTableModel;
import com.sun.nio.sctp.Notification;

import controlador.MensajesDialog;

public class FrmNotificacion extends AbstractWindowsMovil{
	private static final int cellHeight=40;
	private static final Font styleCell= new Font("Tahoma", Font.BOLD, 18);
	private JLabel lImagen;
	/**
	 * (1)PENDIENTE
	 * (2)EJECUCIÓN
	 * (3)
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblDatatable;
	private ModelNotificacion modelNotificacion;
	private List<NOTIFICACION> listNotificacion;
	private NOTIFICACIONDao notificacionesDao;
	private NOTIFICACION selectNotificacion;
	public FrmNotificacion(String title) throws NisiraORMException {
		super(title);
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setVisible(true);
		setResizable(true);
		setName("FrmNotificacion");
		setTitle(title);
		setSize(new Dimension(888, 450));
		setPreferredSize(new Dimension(888, 418));
		/******************** DEFINICIONES *****************/
		notificacionesDao = new NOTIFICACIONDao(true);
		listNotificacion = new ArrayList<NOTIFICACION>();
		/**************************************************/
		// TODO Auto-generated constructor stub
		JScrollPane scrlImportar = new JScrollPane();
		/*DATOS AL CARGAR*/
		cargarNotificaciones();
		modelNotificacion = new ModelNotificacion();
		tblDatatable = new JTable(modelNotificacion){
			private static final long serialVersionUID = 1L;
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {
				Component component = super.prepareRenderer(renderer, rowIndex, columnIndex);
				component.setFont(styleCell);
				int rowModel = tblDatatable.convertRowIndexToModel(rowIndex);
				int columnModel = tblDatatable.convertColumnIndexToModel(columnIndex);
				if (isCellSelected(rowIndex, columnIndex)) {
					// comp.setForeground(Color.YELLOW);
				} else{
					if(columnModel==1){
						int estado = listNotificacion.get(rowModel).getMESTADO();
//						lImagen = new JLabel();
						switch (estado) {
							case 1:/*PENDIENTE*/
								component.setBackground(new Color(65,242,78));
//								lImagen.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
//										.getResource("/resources/montacarga/PENDIENTE-ESTADO.png")).getImage()
//										.getScaledInstance(200,cellHeight, java.awt.Image.SCALE_DEFAULT)));
//								component=lImagen;
								break;
							case 2:/*EJECUCIÓN*/
								component.setBackground(new Color(248,205,4));
//								lImagen.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
//										.getResource("/resources/montacarga/EJECUCION-ESTADO.png")).getImage()
//										.getScaledInstance(200,cellHeight, java.awt.Image.SCALE_DEFAULT)));
//								component=lImagen;
								break;
							case 3:/*TERMINADO*/
								component.setBackground(new Color(255 ,252,0));
//								lImagen.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
//										.getResource("/resources/montacarga/TERMINADO-ESTADO.png")).getImage()
//										.getScaledInstance(200,cellHeight, java.awt.Image.SCALE_DEFAULT)));
//								component=lImagen;
								break;
								
							case 4:/*OBSERVADO*/
								component.setBackground(new Color(253,107,26));
//								lImagen.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
//										.getResource("/resources/montacarga/OBSERVADO-ESTADO.png")).getImage()
//										.getScaledInstance(200,cellHeight, java.awt.Image.SCALE_DEFAULT)));
//								component=lImagen;
								break;
							default:
								component.setBackground(new Color(65,242,78));
//								component.setBackground(new Color(65,242,78));
//								lImagen.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
//										.getResource("/resources/montacarga/PENDIENTE-ESTADO.png")).getImage()
//										.getScaledInstance(200,cellHeight, java.awt.Image.SCALE_DEFAULT)));
//								component=lImagen;
								break;
						}
					}else{
						component.setBackground(Color.WHITE);
					}
				}
				return component;
			}
			@Override
			public Component prepareEditor(TableCellEditor cell, int rowIndex, int columnIndex) {
				Component component = super.prepareEditor(cell, rowIndex, columnIndex);
				component.setFont(styleCell);
				int rowModel = tblDatatable.convertRowIndexToModel(rowIndex);
				int columnModel = tblDatatable.convertColumnIndexToModel(columnIndex);
				if (isCellSelected(rowIndex, columnIndex)) {
					// comp.setForeground(Color.YELLOW);
				} else{
					if(columnModel==1){
						int estado = listNotificacion.get(rowModel).getMESTADO();
//						lImagen = new JLabel();
						switch (estado) {
							case 1:/*PENDIENTE*/
								component.setBackground(new Color(65,242,78));
//								lImagen.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
//										.getResource("/resources/montacarga/PENDIENTE-ESTADO.png")).getImage()
//										.getScaledInstance(200,cellHeight, java.awt.Image.SCALE_DEFAULT)));
//								component=lImagen;
								break;
							case 2:/*EJECUCIÓN*/
								component.setBackground(new Color(248,205,4));
//								lImagen.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
//										.getResource("/resources/montacarga/EJECUCION-ESTADO.png")).getImage()
//										.getScaledInstance(200,cellHeight, java.awt.Image.SCALE_DEFAULT)));
//								component=lImagen;
								break;
							case 3:/*TERMINADO*/
								component.setBackground(new Color(255 ,252,0));
//								lImagen.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
//										.getResource("/resources/montacarga/TERMINADO-ESTADO.png")).getImage()
//										.getScaledInstance(200,cellHeight, java.awt.Image.SCALE_DEFAULT)));
//								component=lImagen;
								break;
								
							case 4:/*OBSERVADO*/
								component.setBackground(new Color(253,107,26));
//								lImagen.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
//										.getResource("/resources/montacarga/OBSERVADO-ESTADO.png")).getImage()
//										.getScaledInstance(200,cellHeight, java.awt.Image.SCALE_DEFAULT)));
//								component=lImagen;
								break;
							default:
								component.setBackground(new Color(65,242,78));
//								component.setBackground(new Color(65,242,78));
//								lImagen.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
//										.getResource("/resources/montacarga/PENDIENTE-ESTADO.png")).getImage()
//										.getScaledInstance(200,cellHeight, java.awt.Image.SCALE_DEFAULT)));
//								component=lImagen;
								break;
						}
					}else{
						component.setBackground(Color.WHITE);
					}
				}
				return component;
			}
		
		};
		/******** ESTILO DE ROWS **********/
		tblDatatable.setRowHeight(40);

		/**********************************/
		tblDatatable.setModel(modelNotificacion);
		/******** ESTILO DE ROWS **********/
		tblDatatable.getColumnModel().getColumn(0).setMaxWidth(45);
		tblDatatable.getColumnModel().getColumn(2).setMinWidth(300);
		
		TableRowFilterSupport.forTable(tblDatatable).searchable(true).apply();

		tblDatatable.setRowSelectionAllowed(true);
		tblDatatable.setColumnSelectionAllowed(false);
//		tblDatatable.setColumnControlVisible(true);
		tblDatatable.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = tblDatatable.rowAtPoint(evt.getPoint());
				int col = tblDatatable.columnAtPoint(evt.getPoint());
//				System.out.println("(row,col) :"+row+" , "+col);
				if (row >= 0 && col >= 0) {
					int rowModel = tblDatatable.convertRowIndexToModel(row);
					int columnModel = tblDatatable.convertColumnIndexToModel(col);
//					System.out.println("(rowModel,columnModel) :"+rowModel+" , "+columnModel);
					NOTIFICACION notificacion=listNotificacion.get(rowModel);
					if(notificacion!=null){
						selectNotificacion = notificacion;
					}
				}
			}
		});

		scrlImportar.setViewportView(tblDatatable);
		/****************************** DATOS *******************************/
		getPanelDataTable().add(scrlImportar);
		cargaGrilla();
	}
	
	public void cargarNotificaciones(){
		try {
			listNotificacion = notificacionesDao.verNotificacionxMontacarga(Inicio.idempresa, Inicio.idmontacarga);
		} catch (NisiraORMException | SQLException e) {
			// TODO Auto-generated catch block
			Constantes.log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	public void cargaGrilla(){
		try {
			if(listNotificacion.size()>0){
				modelNotificacion.list.clear();
				modelNotificacion.fireTableDataChanged();
				for(NOTIFICACION nt : listNotificacion){
//					this.tblDatatable.addRow();
					modelNotificacion.addElement(nt);
				}
//				modelNotificacion.fireTableDataChanged();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Constantes.log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		for(int i=0;i<listNotificacion.size();i++){
			//System.out.println(listNotificacion.get(i).getMESTADO());
			if(listNotificacion.get(i).getMESTADO()==2){
				MensajesDialog.mostrarMensaje(this, "Solo puede haber una tarea en Ejecución", 2);
				return;
			}
		}
		
		try {
			if(selectNotificacion!=null){
				if(isSelectionNotificacion(selectNotificacion, 1)){
					selectNotificacion.setMESTADO(2);
					ModelNotificacion model=(ModelNotificacion)tblDatatable.getModel();
					model.fireTableDataChanged();
					Inicio.notificacion=selectNotificacion;
					/*Actualizar*/
					notificacionesDao.actualizar(1,selectNotificacion);
				}
			}else{
				MensajesDialog.mostrarMensaje(this, "Deberá seleccionar un registro", 2);
			}
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		try {
			listNotificacion = notificacionesDao.verNotificacionxMontacarga(Inicio.idempresa, Inicio.idmontacarga);
			cargaGrilla();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void salir() {
		this.dispose();
		// TODO Auto-generated method stub
		
	}
	@Override
	public void detener() {
		// TODO Auto-generated method stub
		try {
			if(selectNotificacion!=null){
				if(isSelectionNotificacion(selectNotificacion, 2)){
					selectNotificacion.setMESTADO(1);
					ModelNotificacion model=(ModelNotificacion)tblDatatable.getModel();
					model.fireTableDataChanged();
					Inicio.notificacion=selectNotificacion;
					/*Actualizar*/
					notificacionesDao.actualizar(1,selectNotificacion);
				}
			}else{
				MensajesDialog.mostrarMensaje(this, "Deberá seleccionar un registro", 2);
			}
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void maximizar() {
		// TODO Auto-generated method stub
		try {
			this.setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void cambioEstadoBase(int estado){
		
	}
 	public NOTIFICACION getSelectNotificacion() {
		return selectNotificacion;
	}

	public void setSelectNotificacion(NOTIFICACION selectNotificacion) {
		this.selectNotificacion = selectNotificacion;
	}
	/*
	 * (1)PARA EJECUTAR
	 * (2)ANULAR
	 * */
	public boolean isSelectionNotificacion(NOTIFICACION selectNotificacion,int tipo){
		switch (tipo) {
		case 1:/*VALIDAR EJECUCIÓN*/
			if(selectNotificacion.getMESTADO()==1){/*Estado debe ser pendiente*/
				return true;
			}
			else{
				MensajesDialog.mostrarMensaje(this, "Registro deberá estar pendiente", 3);
				return false;
			}
		case 2:/*VALIDAR ANULAR*/
			if(selectNotificacion.getMESTADO()==1 || selectNotificacion.getMESTADO()==2){/*Estado debe ser pendiente O ejecutado*/
				return true;
			}
			else{
				MensajesDialog.mostrarMensaje(this, "Registro deberá estar pendiente o ejecución", 3);
				return false;
			}
		default:
			return false;
		}
	}
	
}
class ModelNotificacion extends AbstractTableModel{

	private static final String[] columnNames = { "ID","ESTADO","MENSAJE", "TOQUEN"
			, "FECHA","PRIORIDAD","MODO"};
	private static final Class[] columnType = { Integer.class, Integer.class,String.class,String.class
			,Date.class,Integer.class, String.class};
	public LinkedList<NOTIFICACION> list;
	
	public ModelNotificacion(){
		list= new LinkedList<NOTIFICACION>();
	}
	public void addElement(NOTIFICACION e) {
		// Adds the element in the last position in the list
		list.add(e);
		fireTableDataChanged();
		//fireTableRowsInserted(list.size() - 1, list.size() - 1);
	}
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isCellEditable(int row, int column) {
//		if(column==0){
//			return true;
//		}
		return false;
	}

	@Override
	public Class getColumnClass(int col) {
		return columnType[col];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		NOTIFICACION item = list.get(rowIndex);
		switch (columnIndex) {
		case 0:
			item.setMESTADO((Integer)aValue);
			break;
		}
	};

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex < list.size()) {
			NOTIFICACION item = list.get(rowIndex);
			switch (columnIndex) {
				case 0:
					return item.getIDNOTIFICACION();
//				case 1:
//					return item.getIDEMPRESA();
				case 1:
					switch (item.getMESTADO()) {
					case 1:/*PENDIENTE*/
						return "PENDIENTE";
					case 2:/*EJECUCIÓN*/
						return "EJECUCIÓN";
					case 3:/*TERMINADO*/
						return "TERMINADO";
					case 4:/*OBSERVADO*/
						return "OBSERVADO";
					default:
						return "PENDIENTE";
				}
				case 2:
					return item.getMENSAJE();
				case 3:
					return item.getTOQUEN();
				case 4:
					return item.getFECHACREACION();
				case 5:
					return item.getPRIORIDAD();
//				case 7:
//					return item.getESTADO();
				case 6:
					return item.getMODO().equals("ma")?"MANUAL":"AUTOMÁTICO";
			}
//			JOptionPane.showMessageDialog(null, "Coordenada ["+rowIndex+","+columnIndex+"]");
		}
		return null;
	}
	
}
//@Override
//public Component prepareEditor(TableCellEditor cell, int rowIndex, int columnIndex) {
//	Component component = super.prepareEditor(cell, rowIndex, columnIndex);
//	component.setFont(styleCell);
//	if(columnIndex==0){
//		int estado = listNotificacion.get(rowIndex).getMESTADO();
//		lImagen = new JLabel();
//		
//		switch (estado) {
//			case 1:/*PENDIENTE*/
//				lImagen.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
//						.getResource("/resources/montacarga/PENDIENTE-ESTADO.png")).getImage()
//						.getScaledInstance(200,cellHeight, java.awt.Image.SCALE_DEFAULT)));
//				component=lImagen;
//				break;
//			case 2:/*EJECUCIÓN*/
//				lImagen.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
//						.getResource("/resources/montacarga/EJECUCION-ESTADO.png")).getImage()
//						.getScaledInstance(200,cellHeight, java.awt.Image.SCALE_DEFAULT)));
//				component=lImagen;
//				break;
//			case 3:/*TERMINADO*/
//				lImagen.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
//						.getResource("/resources/montacarga/TERMINADO-ESTADO.png")).getImage()
//						.getScaledInstance(200,cellHeight, java.awt.Image.SCALE_DEFAULT)));
//				component=lImagen;
//				break;
//				
//			case 4:/*OBSERVADO*/
//				lImagen.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
//						.getResource("/resources/montacarga/OBSERVADO-ESTADO.png")).getImage()
//						.getScaledInstance(200,cellHeight, java.awt.Image.SCALE_DEFAULT)));
//				component=lImagen;
//				break;
//			default:
//				lImagen.setIcon(new ImageIcon(new ImageIcon(PanelBarraMaestro.class
//						.getResource("/resources/montacarga/PENDIENTE-ESTADO.png")).getImage()
//						.getScaledInstance(200,cellHeight, java.awt.Image.SCALE_DEFAULT)));
//				component=lImagen;
//				break;
//		}
//	} 
//	return component;
//}