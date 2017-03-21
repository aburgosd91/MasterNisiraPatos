package com.nisira.vista.contenedores;

import com.nisira.entidad.Resumen;
import java.awt.GridBagLayout;

public class CntResumen extends AbstractCntBuscar<Resumen> {
	private static final long serialVersionUID = 1L;

	public CntResumen() {
		super(new String[] { "Documento", "Tipo Documento", "Fecha Resumen" }, new int[] { 200, 100, 90 });
		GridBagLayout gridBagLayout = (GridBagLayout) getLayout();
		gridBagLayout.columnWidths = new int[]{119, 0, 0};
	}

	@Override
	public void cargarDatos(Resumen entity) {
		txtCodigo.setText(entity.getDocumento());
		txtDescripcion.setText(entity.getTipoEnvio());
		llenarAdicional();
	}

	@Override
	public boolean coincideBusqueda(Resumen entity, String cadena) {
		String cad = cadena.toLowerCase();
		if (entity.getDocumento().toLowerCase().contains(cad) || entity.getTipoEnvio().toLowerCase().contains(cad))
			return true;
		return false;
	}

	@Override
	public Object[] entity2Object(Resumen entity) {
		return new Object[] { entity.getDocumento(), entity.getTipoEnvio(), entity.getFechaResumen() };
	}

	@Override
	public String getEntityCode(Resumen entity) {
		return entity.getDocumento();
	}
	
	public void llenarAdicional(){
		
	}
}