package com.nisira.clientservice;

import java.util.List;

public abstract class HttpComponents<E>{
	/*
	 * strings[0] -> tabla
	 * strings[1] -> page
	 * strings[2]...[n] -> variable
	 * */
	public abstract List<E> bajarServidor(String ...strings);
    public abstract List<E> subirServidor(String ...strings);
    public abstract List<E> listaLocal(String ...strings);
}
