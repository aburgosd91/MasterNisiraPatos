package com.nisira.entidad;

import java.sql.Timestamp;
import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "PROGRAMAALM")
public class PROGRAMAALM {
	@ClavePrimaria
	@Columna
	private int IDEMPRESA;
	@ClavePrimaria
	@Columna
	private int IDPROGRAMAALM;
	@Columna
	private int IDSUCURSAL;
	@Columna
	private int IDTIPOALMACEN;
	@Columna
	private String IDDOCUMENTO;
	@Columna
	private String SERIE;
	@Columna
	private String NUMERO;
	@Columna
	private String IDESTADO;
	@Columna
	private int IDRESPONSABLE;
	@Columna
	private Date FECHAPROGRAMACION;
	@Columna
	private Date FECHAEJECUCION;
	@Columna
	private Date FECHAFINALIZACION;
	@Columna
	private String VENTANA;
	@Columna
	private Date FECHACREACION;

	public PROGRAMAALM() {

	}

	public int getIDEMPRESA() {
		return IDEMPRESA;
	}

	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}

	public int getIDPROGRAMAALM() {
		return IDPROGRAMAALM;
	}

	public void setIDPROGRAMAALM(int iDPROGRAMAALM) {
		IDPROGRAMAALM = iDPROGRAMAALM;
	}

	public int getIDSUCURSAL() {
		return IDSUCURSAL;
	}

	public void setIDSUCURSAL(int iDSUCURSAL) {
		IDSUCURSAL = iDSUCURSAL;
	}

	public int getIDTIPOALMACEN() {
		return IDTIPOALMACEN;
	}

	public void setIDTIPOALMACEN(int iDTIPOALMACEN) {
		IDTIPOALMACEN = iDTIPOALMACEN;
	}

	public String getIDDOCUMENTO() {
		return IDDOCUMENTO;
	}

	public void setIDDOCUMENTO(String iDDOCUMENTO) {
		IDDOCUMENTO = iDDOCUMENTO;
	}

	public String getSERIE() {
		return SERIE;
	}

	public void setSERIE(String sERIE) {
		SERIE = sERIE;
	}

	public String getNUMERO() {
		return NUMERO;
	}

	public void setNUMERO(String nUMERO) {
		NUMERO = nUMERO;
	}

	public String getIDESTADO() {
		return IDESTADO;
	}

	public void setIDESTADO(String iDESTADO) {
		IDESTADO = iDESTADO;
	}

	public int getIDRESPONSABLE() {
		return IDRESPONSABLE;
	}

	public void setIDRESPONSABLE(int iDRESPONSABLE) {
		IDRESPONSABLE = iDRESPONSABLE;
	}

	public Date getFECHAPROGRAMACION() {
		return FECHAPROGRAMACION;
	}

	public void setFECHAPROGRAMACION(Date fECHAPROGRAMACION) {
		FECHAPROGRAMACION = fECHAPROGRAMACION;
	}

	public Date getFECHAEJECUCION() {
		return FECHAEJECUCION;
	}

	public void setFECHAEJECUCION(Date fECHAEJECUCION) {
		FECHAEJECUCION = fECHAEJECUCION;
	}

	public Date getFECHAFINALIZACION() {
		return FECHAFINALIZACION;
	}

	public void setFECHAFINALIZACION(Date fECHAFINALIZACION) {
		FECHAFINALIZACION = fECHAFINALIZACION;
	}

	public String getVENTANA() {
		return VENTANA;
	}

	public void setVENTANA(String vENTANA) {
		VENTANA = vENTANA;
	}

	public Date getFECHACREACION() {
		return FECHACREACION;
	}

	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDPROGRAMAALM + ", " + IDSUCURSAL + ", " + IDTIPOALMACEN + ", " + IDDOCUMENTO
				+ ", " + SERIE + ", " + NUMERO + ", " + IDESTADO + ", " + IDRESPONSABLE + ", " + (FECHAPROGRAMACION==null?"Null":FECHAPROGRAMACION)
				+ ", " + (FECHAEJECUCION==null?"Null":FECHAEJECUCION) + ", " + (FECHAFINALIZACION==null?"Null":FECHAFINALIZACION) + ", " + VENTANA + ", " + FECHACREACION + "]";
	}


}
