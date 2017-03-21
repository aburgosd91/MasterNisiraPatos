package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.Consulta;
import com.nisira.core.EntityTuple;
import com.nisira.entidad.CPUMOVIL;
import com.nisira.entidad.DANTENA;
import com.nisira.entidad.DPUERTOCOM;
import com.nisira.entidad.PUERTOCOM;
import com.nisira.entidad.RFIDREADER;
import com.nisira.core.NisiraORMException;

import java.util.ArrayList;
import java.util.List;

public class DPUERTOCOMDao extends BaseDao<DPUERTOCOM> {
	public DPUERTOCOMDao() {
		super(DPUERTOCOM.class);
	}
	public DPUERTOCOMDao(boolean usaCnBase) throws NisiraORMException {
		super(DPUERTOCOM.class);
	}

	public DPUERTOCOM getPorClavePrimaria(int con,Integer IDEMPRESA, Integer IDEQUIPOREADER, Integer IDPUERTOCOM) throws NisiraORMException {
		List<DPUERTOCOM> l = listar(con,"t0.IDEMPRESA = ? and t0.IDEQUIPOREADER = ? and t0.IDPUERTOCOM = ? ", IDEMPRESA, IDEQUIPOREADER, IDPUERTOCOM);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
	public List<DPUERTOCOM> listaDesc(int con,int idemp,int idcpumovil) throws NisiraORMException {
		List<DPUERTOCOM> l = new ArrayList<DPUERTOCOM>();

		Consulta c = getInstancia(con);
		c.join("left", PUERTOCOM.class, "t1", "t0.IDEMPRESA = t1.IDEMPRESA and t0.IDPUERTOCOM = t1.IDPUERTOCOM");
		c.join("inner", RFIDREADER.class, "t2", "t0.IDEMPRESA = t2.IDEMPRESA and t0.IDEQUIPOREADER = t2.IDEQUIPOREADER");
		c.join("inner", CPUMOVIL.class, "t3", "t3.IDEMPRESA = t2.IDEMPRESA and t3.IDCPUMOVIL = t2.IDCPUMOVIL");
		c.where("t0.IDEMPRESA = ? AND t3.IDCPUMOVIL = ?",idemp,idcpumovil);		
		List<EntityTuple> lista = c.execSelect();
		for (EntityTuple e : lista) {
			DPUERTOCOM _a = (DPUERTOCOM) e.get("t0");
			PUERTOCOM _e = (PUERTOCOM) e.get("t1");
			_a.setDescripcion(_e.getDESCRIPCION());
			l.add(_a);
		}
		return l;
	}
	public List<DPUERTOCOM> listaDescActivo(int con,int idemp,int idcpumovil) throws NisiraORMException {
		List<DPUERTOCOM> l = new ArrayList<DPUERTOCOM>();

		Consulta c = getInstancia(con);
		c.join("left", PUERTOCOM.class, "t1", "t0.IDEMPRESA = t1.IDEMPRESA and t0.IDPUERTOCOM = t1.IDPUERTOCOM");
		c.join("inner", RFIDREADER.class, "t2", "t0.IDEMPRESA = t2.IDEMPRESA and t0.IDEQUIPOREADER = t2.IDEQUIPOREADER");
		c.join("inner", CPUMOVIL.class, "t3", "t3.IDEMPRESA = t2.IDEMPRESA and t3.IDCPUMOVIL = t2.IDCPUMOVIL");
		c.where("t0.IDEMPRESA = ? AND t3.IDCPUMOVIL = ? AND t0.ACTIVO = ?",idemp,idcpumovil,1);		
		List<EntityTuple> lista = c.execSelect();
		for (EntityTuple e : lista) {
			DPUERTOCOM _a = (DPUERTOCOM) e.get("t0");
			PUERTOCOM _e = (PUERTOCOM) e.get("t1");
			_a.setDescripcion(_e.getDESCRIPCION());
			l.add(_a);
		}
		return l;
	}
}