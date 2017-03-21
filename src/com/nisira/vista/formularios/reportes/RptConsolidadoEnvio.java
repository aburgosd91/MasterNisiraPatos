package com.nisira.vista.formularios.reportes;

import com.nisira.dao.DocumentosEnviadosDao;
import com.nisira.vista.controles.NSRDatePicker;
import com.nisira.vista.controles.NSRTable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class RptConsolidadoEnvio extends AbstractReporte {

	private NSRDatePicker dpDesde;
	private NSRDatePicker dpHasta;

	DocumentosEnviadosDao deDAO = new DocumentosEnviadosDao();

	public RptConsolidadoEnvio() {
		pnlFiltro.setPreferredSize(new Dimension(10, 35));
		setTitle("Consolidado de Envios");
		setName("RptConsolidadoEnvio");
		
		dpDesde = new NSRDatePicker();
		dpDesde.setBounds(66, 7, 104, 22);
		pnlFiltro.add(dpDesde);

		dpHasta = new NSRDatePicker();
		dpHasta.setBounds(236, 7, 104, 22);
		pnlFiltro.add(dpHasta);

		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(10, 11, 46, 14);
		pnlFiltro.add(lblDesde);

		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(180, 11, 46, 14);
		pnlFiltro.add(lblHasta);

		dpDesde.setDate(new Date());

		dpHasta.setDate(new Date());
	}

	@Override
	public List<Object[]> getData() {
		Date desde, hasta;

		desde = dpDesde.getDate();
		hasta = dpHasta.getDate();
		
		List<Object[]> consolidado = new ArrayList<Object[]>();
		
		try {
			List<Object[]> lista = deDAO.getRPTConsolidado(1,desde, hasta);

			if (!lista.isEmpty()) {
				
				for (int i = 0; i < lista.size(); i++) {
					Object[] row = null;
					Object[] cc = lista.get(i);
					
					String idorigen = cc[0].toString().trim();
					String idunico = cc[2].toString().trim();
					
					for (Object[] o : consolidado) {
						if (o[0].toString().equalsIgnoreCase(idorigen) && o[2].toString().equalsIgnoreCase(idunico)) {
							row = o;
							break;
						}
					}
					
					String descripcion = "";
					
					if (cc[9] != null) {
						descripcion = cc[9].toString().trim();
					}
					
					if (row == null) {
						row = new Object[9];
						row[0] = cc[0];
						row[1] = cc[1];
						row[2] = cc[2];
						row[3] = cc[3];
						row[4] = cc[4];
						row[5] = cc[5];
						row[6] = cc[6];
						row[7] = cc[7];
						row[8] = "";
						//row[8] = descripcion;
						consolidado.add(row);
					}
					
					if (!descripcion.isEmpty()) {
						row[8] = row[8].toString() + (row[8].toString().isEmpty()? "" : ", ") + descripcion;
					}
				}
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return consolidado;
	}

	@Override
	public String[] getCabeceras() {
		return new String[] {"Cód. Origen", "Origen", "Cód Unico", "Documento", "Cód. Cliente", "Razon Social", "Fecha", "Nombre Archivo", "Mensajes"};
	}

	@Override
	public boolean isFiltrosValidos() {
		return true;
	}
	
	@Override
	public NSRTable[] getTablasConfigurar() {
		return new NSRTable[] {tblDatos};
	}
}
