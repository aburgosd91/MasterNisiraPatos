package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.Consulta;
import com.nisira.core.EntityTuple;
import com.nisira.entidad.ANTENA;
import com.nisira.entidad.CPUMOVIL;
import com.nisira.entidad.DANTENA;
import com.nisira.entidad.EQUIPO;
import com.nisira.entidad.RFIDREADER;
import com.nisira.core.NisiraORMException;

import java.util.ArrayList;
import java.util.List;

public class DANTENADao extends BaseDao<DANTENA> {
	public DANTENADao() {
		super(DANTENA.class);
	}
	public DANTENADao(boolean usaCnBase) throws NisiraORMException {
		super(DANTENA.class);
	}

	public DANTENA getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDEQUIPOREADER, Integer IDANTENA) throws NisiraORMException {
		List<DANTENA> l = listar(con,"t0.IDEMPRESA = ? and t0.IDEQUIPOREADER = ? and t0.IDANTENA = ? ", IDEMPRESA, IDEQUIPOREADER, IDANTENA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	
	public List<DANTENA> listaDesc(int con,int idemp,int idcpumovil) throws NisiraORMException {
		List<DANTENA> l = new ArrayList<DANTENA>();
		Consulta c = getInstancia(con);
		c.join("inner", ANTENA.class, "t3","t3.IDEMPRESA = t0.IDEMPRESA and t3.IDANTENA=t0.IDANTENA");
		c.join("inner", RFIDREADER.class, "t1", "t0.IDEMPRESA = t1.IDEMPRESA and t0.IDEQUIPOREADER = t1.IDEQUIPOREADER");
		c.join("inner", CPUMOVIL.class, "t2", "t2.IDEMPRESA = t1.IDEMPRESA and t2.IDCPUMOVIL = t1.IDCPUMOVIL");
		c.where("t0.IDEMPRESA = ? AND t2.IDCPUMOVIL = ?",idemp,idcpumovil);		
		List<EntityTuple> lista = c.execSelect();
		
		for (EntityTuple e : lista) {
			DANTENA _a = (DANTENA) e.get("t0");
			ANTENA _e = (ANTENA) e.get("t3");
			_a.setDescripcion(_e.getDescripcion());
			l.add(_a);
		}
		return l;
	}
}