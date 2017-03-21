package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "CONFOG")
public class CONFOG {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private Integer IDOGCONFIG;
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
	private String TIPO;
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
	public Integer getIDOGCONFIG() {
		return IDOGCONFIG;
	}
	public void setIDOGCONFIG(Integer iDOGCONFIG) {
		IDOGCONFIG = iDOGCONFIG;
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
	public String getTIPO() {
		return TIPO;
	}
	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}
	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDOGCONFIG + ", " + GESTOR + ", " + SERVIDOR + ", "
				+ INSTANCIA + ", " + USUARIO + ", " + CLAVE + ", " + BASEDATOS + ", " + URL + ", " + TIPO + "]";
	}



	/* Sets & Gets */




	/* Sets & Gets FK*/

}