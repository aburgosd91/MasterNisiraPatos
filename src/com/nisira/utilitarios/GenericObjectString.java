package com.nisira.utilitarios;

public class GenericObjectString<E> {
	
	public GenericObjectString(Class<E> entityClass) {
		// TODO Auto-generated constructor stub
	}

	public String GenString(E entidad){		
		return entidad.toString();
	}
}
