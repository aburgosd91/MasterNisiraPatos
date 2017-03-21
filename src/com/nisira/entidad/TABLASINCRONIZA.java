package com.nisira.entidad;

public class TABLASINCRONIZA {
	private Boolean SELECTED;
	private String TABLA;
	private Integer PENDIENTES;
	private String TIPOSINC;
	public String getTABLA() {
		return TABLA;
	}
	public void setTABLA(String tABLA) {
		TABLA = tABLA;
	}
	public Integer getPENDIENTES() {
		return PENDIENTES;
	}
	public void setPENDIENTES(Integer pENDIENTES) {
		PENDIENTES = pENDIENTES;
	}
	
	public String getTIPOSINC() {
		return TIPOSINC;
	}
	public void setTIPOSINC(String tIPOSINC) {
		TIPOSINC = tIPOSINC;
	}
	public Boolean getSELECTED() {
		return SELECTED;
	}
	public void setSELECTED(Boolean sELECTED) {
		SELECTED = sELECTED;
	}
	
}
