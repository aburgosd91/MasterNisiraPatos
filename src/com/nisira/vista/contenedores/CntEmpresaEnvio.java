package com.nisira.vista.contenedores;

import com.nisira.entidad.EmpresaEnvio;


public class CntEmpresaEnvio extends AbstractCntBuscar<EmpresaEnvio> {
	private static final long serialVersionUID = 1L;

	public CntEmpresaEnvio() {
		super();
	}

	@Override
	public void cargarDatos(EmpresaEnvio entity) {
		txtCodigo.setText(entity.getIdEmpresa());
		txtDescripcion.setText(entity.getRazonSocial());
		llenarAdicional();
	}

	@Override
	public boolean coincideBusqueda(EmpresaEnvio entity, String cadena) {
		String cad = cadena.toLowerCase();
		if (entity.getIdEmpresa().toLowerCase().startsWith(cad)
				|| entity.getRazonSocial().toLowerCase().startsWith(cad))
			return true;
		return false;
	}

	@Override
	public Object[] entity2Object(EmpresaEnvio entity) {
		return new Object[] { entity.getIdEmpresa(), entity.getRazonSocial() };
	}

	@Override
	public String getEntityCode(EmpresaEnvio entity) {
		return entity.getIdEmpresa();
	}
	
	public void llenarAdicional(){
		
	}
}