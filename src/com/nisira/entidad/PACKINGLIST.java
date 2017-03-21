package com.nisira.entidad;

import java.sql.Timestamp;
import java.util.Date;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "PACKINGLIST")
public class PACKINGLIST {
	@ClavePrimaria
	@Columna
    private int IDEMPRESA;
	@ClavePrimaria
	@Columna
    private int IDSUCURSAL;
	@ClavePrimaria
	@Columna
    private int IDPACKING;
	@Columna
    private Date FECHA;
	@Columna
    private String CONTENEDOR;
	@Columna
    private String IDDOCUMENTO;
	@Columna
    private String SERIE;
	@Columna
    private String NUMERO;
	@Columna
    private String IDRESPONSABLE;
	@Columna
    private int ESTADO;
	@Columna
    private String IDPUERTODESTINO;
	@Columna
    private String IDMOTIVO;
	@Columna
    private String IDCLIENTE;
	@Columna   
    private Date FECHACREACION;
	public PACKINGLIST() {
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
	public Date getFECHA() {
		return FECHA;
	}
	public void setFECHA(Date fECHA) {
		FECHA = fECHA;
	}
	public String getCONTENEDOR() {
		return CONTENEDOR;
	}
	public void setCONTENEDOR(String cONTENEDOR) {
		CONTENEDOR = cONTENEDOR;
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
	public String getIDRESPONSABLE() {
		return IDRESPONSABLE;
	}
	public void setIDRESPONSABLE(String iDRESPONSABLE) {
		IDRESPONSABLE = iDRESPONSABLE;
	}
	public int getESTADO() {
		return ESTADO;
	}
	public void setESTADO(int eSTADO) {
		ESTADO = eSTADO;
	}
	public String getIDPUERTODESTINO() {
		return IDPUERTODESTINO;
	}
	public void setIDPUERTODESTINO(String iDPUERTODESTINO) {
		IDPUERTODESTINO = iDPUERTODESTINO;
	}
	public String getIDMOTIVO() {
		return IDMOTIVO;
	}
	public void setIDMOTIVO(String iDMOTIVO) {
		IDMOTIVO = iDMOTIVO;
	}
	public String getIDCLIENTE() {
		return IDCLIENTE;
	}
	public void setIDCLIENTE(String iDCLIENTE) {
		IDCLIENTE = iDCLIENTE;
	}
	public Date getFECHACREACION() {
		return FECHACREACION;
	}
	public void setFECHACREACION(Date fECHACREACION) {
		FECHACREACION = fECHACREACION;
	}
	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDPACKING + ", " + FECHA + ", " + CONTENEDOR + ", "
				+ IDDOCUMENTO + ", " + SERIE + ", " + NUMERO + ", " + IDRESPONSABLE + ", " + ESTADO + ", "
				+ IDPUERTODESTINO + ", " + IDMOTIVO + ", " + IDCLIENTE + ", " + FECHACREACION + "]";
	}
	
}
