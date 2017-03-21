package com.nisira.vista.formularios.reportes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.TableColumn;

import org.javatuples.Pair;
import org.jdesktop.swingx.table.TableColumnExt;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nisira.Inicio;
import com.nisira.core.NisiraORMException;
import com.nisira.dao.CfgTablaDao;
import com.nisira.entidad.CfgTabla;
import com.nisira.vista.barras.IFormReporte;
import com.nisira.vista.barras.PanelBarraReporte;
import com.nisira.vista.controles.NSRInternalFrame;
import com.nisira.vista.controles.NSRTable;
import com.nisira.vista.controles.NSRTableModelReporte;

public abstract class AbstractReporte extends NSRInternalFrame implements IFormReporte, InternalFrameListener {
	private static final long serialVersionUID = 1L;
	private PanelBarraReporte panelBarraReporte;
	protected JPanel pnlContenido;
	protected JPanel pnlFiltro;
	protected JPanel pnlDatos;
	protected JScrollPane srclDatos;
	protected NSRTable tblDatos;
	protected boolean conDatos;
	private Object data[][];
	private NSRTableModelReporte model;

	public AbstractReporte() {
		getContentPane().setLayout(new BorderLayout(0, 0));

		this.panelBarraReporte = new PanelBarraReporte();
		FlowLayout flowLayout = (FlowLayout) this.panelBarraReporte.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(this.panelBarraReporte, BorderLayout.NORTH);

		panelBarraReporte.setFrmReporte(this);

		this.pnlContenido = new JPanel();
		getContentPane().add(this.pnlContenido, BorderLayout.CENTER);
		this.pnlContenido.setLayout(new BorderLayout(0, 0));

		this.pnlFiltro = new JPanel();
		this.pnlFiltro.setPreferredSize(new Dimension(10, 60));
		this.pnlFiltro.setMinimumSize(new Dimension(10, 50));
		this.pnlContenido.add(this.pnlFiltro, BorderLayout.NORTH);
		this.pnlFiltro.setLayout(null);

		this.pnlDatos = new JPanel();
		this.pnlContenido.add(this.pnlDatos, BorderLayout.CENTER);
		this.pnlDatos.setLayout(new BorderLayout(0, 0));

		this.srclDatos = new JScrollPane();
		this.pnlDatos.add(this.srclDatos, BorderLayout.CENTER);
		model = new NSRTableModelReporte();
		this.tblDatos = new NSRTable(model);
		this.tblDatos.setName("tblDatos");
		this.srclDatos.setViewportView(this.tblDatos);

		tblDatos.setColumnControlVisible(true);

		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setVisible(true);
		setResizable(true);
		setBounds(100, 100, 810, 451);
		addInternalFrameListener(this);
	}

	public NSRTableModelReporte getModel() {
		return model;
	}

	public abstract List<Object[]> getData();

	public abstract String[] getCabeceras();

	public abstract boolean isFiltrosValidos();

	@Override
	public void doVistaPrevia() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doImprimir() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doExportar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSalir() {
		this.dispose();
	}

	@Override
	public void doConsultar() {
		if (isFiltrosValidos()) {
			model = new NSRTableModelReporte(getCabeceras());

			List<Object[]> lista = getData();

			if (lista.isEmpty()) {
				conDatos = false;
			} else {
				conDatos = true;
				this.data = new Object[lista.size()][lista.get(0).length];

				for (int i = 0; i < lista.size(); i++) {
					this.data[i] = lista.get(i);
				}

				for (Object[] rowData : this.data) {
					model.addRow(rowData);
				}
			}
			tblDatos.setModel(model);
			recuperarEstadoTabla();
		}
	}

	public void grabarEstadoTabla() {
		List<EstadoTabla> estados = new ArrayList<EstadoTabla>();

		Gson gson = new Gson();
		System.out.println(getTablasConfigurar());
		for (NSRTable tabla : getTablasConfigurar()) {
			EstadoTabla et = new EstadoTabla(tabla.getName());
			estados.add(et);
			// int i = 0;

			for (TableColumn col : tabla.getColumns(true)) {
				TableColumnExt colEx = (TableColumnExt) col;
				int ordenMostrar = 0;
				boolean encontrado = false;
				int orden = colEx.getModelIndex();

				for (TableColumn colaux : tabla.getColumns()) {
					if (colaux == col && !encontrado) {
						encontrado = true;
						break;
					}
					ordenMostrar++;
				}

				DEstadoTabla det = new DEstadoTabla();
				det.orden = orden;
				det.ordenMostrar = (encontrado) ? ordenMostrar : 0;
				det.visible = colEx.isVisible();
				det.ancho = colEx.getWidth();
				et.dEstadoTabla.add(det);
			}
		}
		CfgTabla cfg = new CfgTabla();
		String json = gson.toJson(estados);
		cfg.setVentana(getName());
		cfg.setIdUsuario(Inicio.usuario.getIdUsuario());
		cfg.setConfiguracion(json);

		try {
			cfgTablaDao.mezclar(1,cfg);
		} catch (NisiraORMException e) {
			e.printStackTrace();
		}
	}

	public void recuperarEstadoTabla() {

		CfgTabla cfg;
		List<Pair<TableColumnExt, Integer>> anchos = new ArrayList<Pair<TableColumnExt, Integer>>();

		try {
			cfg = cfgTablaDao.getPorClavePrimaria(1,Inicio.usuario.getIdUsuario(), getName());

			if (cfg != null) {
				String json = cfg.getConfiguracion();

				if (json == null) {
					json = "";
				}
				if (!json.isEmpty()) {

					Type listType = new TypeToken<ArrayList<EstadoTabla>>() {
					}.getType();

					List<EstadoTabla> lista = new Gson().fromJson(json, listType);

					for (NSRTable tabla : getTablasConfigurar()) {
						if (tabla != null) {

							for (EstadoTabla e : lista) {
								if (tabla.getName().equalsIgnoreCase(e.tabla)) {

									e.dEstadoTabla.sort(new Comparator<DEstadoTabla>() {
										@Override
										public int compare(DEstadoTabla o1, DEstadoTabla o2) {
											return Integer.compare(o1.ordenMostrar, o2.ordenMostrar);
										}
									});

									List<int[]> movidos = new ArrayList<int[]>();

									List<TableColumnExt> invisibles = new ArrayList<TableColumnExt>();
									for (int i = 0; i < e.dEstadoTabla.size() - 1; i++) {
										DEstadoTabla aux = e.dEstadoTabla.get(i);

										int orden = aux.orden;
										for (int v[] : movidos) {
											if (v[0] > orden && v[1] < orden) {
												orden++;
											}
										}

										movidos.add(new int[] { orden, aux.ordenMostrar });

										tabla.moveColumn(orden, aux.ordenMostrar);
										tabla.getColumn(aux.ordenMostrar).setPreferredWidth(aux.ancho);
										// tabla.getColumn(aux.ordenMostrar).setWidth(aux.ancho);
										

										if (!aux.visible) {
											invisibles.add((TableColumnExt) tabla.getColumn(aux.ordenMostrar));
										} else {
											Pair<TableColumnExt, Integer> d = Pair
													.with((TableColumnExt) tabla.getColumn(aux.ordenMostrar), aux.ancho);
											anchos.add(d);
										}
									}

									for (TableColumnExt in : invisibles) {
										in.setVisible(false);
									}

									for (Pair<TableColumnExt, Integer> p : anchos) {
										p.getValue0().setWidth(p.getValue1());
									}
								}
							}
						}
					}
				}
			}

		} catch (SQLException | NisiraORMException e1) {
			e1.printStackTrace();
		}
	}

	public abstract NSRTable[] getTablasConfigurar();

	protected CfgTablaDao cfgTablaDao = new CfgTablaDao();

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {

	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {/* al cerrar */
		grabarEstadoTabla();
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

}

class EstadoTabla {
	public String tabla;
	public List<DEstadoTabla> dEstadoTabla;

	public EstadoTabla(String tabla) {
		this.tabla = tabla;
		dEstadoTabla = new ArrayList<DEstadoTabla>();
	}
}

class DEstadoTabla {
	public int orden;
	public int ordenMostrar;
	public boolean visible;
	public int ancho;

}

//
// class ReporteInternalFrameListener implements InternalFrameListener {
//
// private AbstractReporte formulario;
// public ReporteInternalFrameListener(AbstractReporte formulario) {
// this.formulario = formulario;
// }
//
//
// @Override
// public void internalFrameOpened(InternalFrameEvent e) {
// this.formulario.recuperarEstadoTabla();
// }
//
// @Override
// public void internalFrameClosing(InternalFrameEvent e) {
//
// }
//
// @Override
// public void internalFrameClosed(InternalFrameEvent e) {
// // TODO Auto-generated method stub
//
// }
//
// @Override
// public void internalFrameIconified(InternalFrameEvent e) {
// // TODO Auto-generated method stub
//
// }
//
// @Override
// public void internalFrameDeiconified(InternalFrameEvent e) {
// // TODO Auto-generated method stub
//
// }
//
// @Override
// public void internalFrameActivated(InternalFrameEvent e) {
// // TODO Auto-generated method stub
//
// }
//
// @Override
// public void internalFrameDeactivated(InternalFrameEvent e) {
// // TODO Auto-generated method stub
//
// }
//
// }