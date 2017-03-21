package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "CONFINICIO")
public class CONFINICIO {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private Integer IDCONFIG;
	@Columna
	private String GESTOR;
	@Columna
	private String SERVIDOR;
	@Columna
	private String INSTANCIA;
	@Columna
	private String USUARIO;
	@Columna
	private String CLAVE;
	@Columna
	private String BASEDATOS;
	@Columna
	private String URL;
	@Columna
	private String RUTPRO;
	@Columna
	private String PARAMINI;
	@Columna
	private String PARAMFIN;
	@Columna
	private String PARAMERRINI;
	@Columna
	private String PARAMERRFIN;
	@Columna
	private String TIPO;
	@Columna
	private Integer IDMONTACARGA;
	@Columna
	private String PUERTOCM;
	@Columna
	private String MAC;
	public Integer getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(Integer iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public Integer getIDSUCURSAL() {
		return IDSUCURSAL;
	}
	public void setIDSUCURSAL(Integer iDSUCURSAL) {
		IDSUCURSAL = iDSUCURSAL;
	}
	public Integer getIDCONFIG() {
		return IDCONFIG;
	}
	public void setIDCONFIG(Integer iDCONFIG) {
		IDCONFIG = iDCONFIG;
	}
	public String getGESTOR() {
		return GESTOR;
	}
	public void setGESTOR(String gESTOR) {
		GESTOR = gESTOR;
	}
	public String getSERVIDOR() {
		return SERVIDOR;
	}
	public void setSERVIDOR(String sERVIDOR) {
		SERVIDOR = sERVIDOR;
	}
	public String getINSTANCIA() {
		return INSTANCIA;
	}
	public void setINSTANCIA(String iNSTANCIA) {
		INSTANCIA = iNSTANCIA;
	}
	public String getUSUARIO() {
		return USUARIO;
	}
	public void setUSUARIO(String uSUARIO) {
		USUARIO = uSUARIO;
	}
	public String getCLAVE() {
		return CLAVE;
	}
	public void setCLAVE(String cLAVE) {
		CLAVE = cLAVE;
	}
	public String getBASEDATOS() {
		return BASEDATOS;
	}
	public void setBASEDATOS(String bASEDATOS) {
		BASEDATOS = bASEDATOS;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getRUTPRO() {
		return RUTPRO;
	}
	public void setRUTPRO(String rUTPRO) {
		RUTPRO = rUTPRO;
	}
	public String getPARAMINI() {
		return PARAMINI;
	}
	public void setPARAMINI(String pARAMINI) {
		PARAMINI = pARAMINI;
	}
	public String getPARAMFIN() {
		return PARAMFIN;
	}
	public void setPARAMFIN(String pARAMFIN) {
		PARAMFIN = pARAMFIN;
	}
	public String getPARAMERRINI() {
		return PARAMERRINI;
	}
	public void setPARAMERRINI(String pARAMERRINI) {
		PARAMERRINI = pARAMERRINI;
	}
	public String getPARAMERRFIN() {
		return PARAMERRFIN;
	}
	public void setPARAMERRFIN(String pARAMERRFIN) {
		PARAMERRFIN = pARAMERRFIN;
	}
	public String getTIPO() {
		return TIPO;
	}
	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}
	public Integer getIDMONTACARGA() {
		return IDMONTACARGA;
	}
	public void setIDMONTACARGA(Integer iDMONTACARGA) {
		IDMONTACARGA = iDMONTACARGA;
	}
	public String getPUERTOCM() {
		return PUERTOCM;
	}
	public void setPUERTOCM(String pUERTOCM) {
		PUERTOCM = pUERTOCM;
	}
	public String getMAC() {
		return MAC;
	}
	public void setMAC(String mAC) {
		MAC = mAC;
	}
	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDCONFIG + ", " + GESTOR + ", " + SERVIDOR + ", "
				+ INSTANCIA + ", " + USUARIO + ", " + CLAVE + ", " + BASEDATOS + ", " + URL + ", " + RUTPRO + ", "
				+ PARAMINI + ", " + PARAMFIN + ", " + PARAMERRINI + ", " + PARAMERRFIN + ", " + TIPO + ", "
				+ IDMONTACARGA + ", " + PUERTOCM + ", " + MAC + "]";
	}


}