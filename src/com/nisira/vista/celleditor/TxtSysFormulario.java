package com.nisira.vista.celleditor;

import javax.swing.JTable;

import com.nisira.entidad.SysFormulario;


public abstract class TxtSysFormulario extends JXTableTextField<SysFormulario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TxtSysFormulario(JTable tabla, int ubicacion) {
		super(new String[] { "Formulario", "Descripción", "Opción" },
				new int[] { 50, 130, 90 }, tabla, ubicacion);
	}

	@Override
	public boolean coincideBusqueda(SysFormulario entity, String cadena) {
		cadena = cadena.trim().toLowerCase();
		return entity.getIdFormulario().toLowerCase().startsWith(cadena)
				|| entity.getDescripcion().toLowerCase().startsWith(cadena);
	}

	@Override
	public Object[] entity2Object(SysFormulario entity) {
		return new Object[] { entity.getIdFormulario(),
				entity.getDescripcion(), entity.getOpcion() };
	}

	@Override
	public String getEntityCode(SysFormulario entity) {
		return entity.getIdFormulario();
	}
}
