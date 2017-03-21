package com.nisira.utilitarios;

import java.util.ArrayList;
import java.util.List;

public class ListCreator<E> {

	public ListCreator(Class<E> entityClass) {
		// TODO Auto-generated constructor stub
	}
	public  List<E> genList(List<Object> tl,Class a){
		List<E> l = new ArrayList<E>();
		for(Object o: tl){
			l.add((E) o);
		}
		return l;
		
	}
}
