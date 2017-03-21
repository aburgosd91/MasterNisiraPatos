package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "DPACKINGLIST")
public class DPACKINGLIST {
	@ClavePrimaria
	@Columna
    private int IDEMPRESA;
	@ClavePrimaria
	@Columna
    private int IDSUCURSAL;
	@ClavePrimaria
	@Columna
    private int IDPACKING;
	@ClavePrimaria
	@Columna
    private int ITEM;
	@Columna
    private String NROPALETA;
	@Columna
    private String IDPRODUCTO;
	@Columna
    private String DESCRIPCION;
	@Columna
    private String IDLOTEP;
	@Columna
    private String IDMEDIDA;
	@Columna
    private String IDTALLA;
	@Columna
    private double CANTIDAD;
	@Columna
    private double PESO;
	@Columna
    private double PERSOTARA;
	public DPACKINGLIST() {
	}
	public int getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public int getIDSUCURSAL() {
		return IDSUCURSAL;
	}
	public void setIDSUCURSAL(int iDSUCURSAL) {
		IDSUCURSAL = iDSUCURSAL;
	}
	public int getIDPACKING() {
		return IDPACKING;
	}
	public void setIDPACKING(int iDPACKING) {
		IDPACKING = iDPACKING;
	}
	public int getITEM() {
		return ITEM;
	}
	public void setITEM(int iTEM) {
		ITEM = iTEM;
	}
	public String getNROPALETA() {
		return NROPALETA;
	}
	public void setNROPALETA(String nROPALETA) {
		NROPALETA = nROPALETA;
	}
	public String getIDPRODUCTO() {
		return IDPRODUCTO;
	}
	public void setIDPRODUCTO(String iDPRODUCTO) {
		IDPRODUCTO = iDPRODUCTO;
	}
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	public String getIDLOTEP() {
		return IDLOTEP;
	}
	public void setIDLOTEP(String iDLOTEP) {
		IDLOTEP = iDLOTEP;
	}
	public String getIDMEDIDA() {
		return IDMEDIDA;
	}
	public void setIDMEDIDA(String iDMEDIDA) {
		IDMEDIDA = iDMEDIDA;
	}
	public String getIDTALLA() {
		return IDTALLA;
	}
	public void setIDTALLA(String iDTALLA) {
		IDTALLA = iDTALLA;
	}
	public double getCANTIDAD() {
		return CANTIDAD;
	}
	public void setCANTIDAD(double cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}
	public double getPESO() {
		return PESO;
	}
	public void setPESO(double pESO) {
		PESO = pESO;
	}
	public double getPERSOTARA() {
		return PERSOTARA;
	}
	public void setPERSOTARA(double pERSOTARA) {
		PERSOTARA = pERSOTARA;
	}
}
