package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "DPROGRAMACIONTAREAPARTIDA")
public class DPROGRAMACIONTAREAPARTIDA {
	@Columna
	private Integer IDEMPRESA;
	@Columna
	private Integer IDSUCURSAL;
	@Columna
	private String IDPROGRAMACIONTAREA;
	@Columna
	private Integer ITEM;
	@Columna
	private Integer IDPROCESO;
	@Columna
	private Integer IDZONA;
	@Columna
	private Integer IDALMACEN;
	@Columna
	private Integer IDACCESORIO;
	@Columna
	private String IDPALETA;
	@Columna
	private String IDUBICACION;
	@Columna
	private Date FECHACREACION;



	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDSUCURSAL(Integer IDSUCURSAL) {
		this.IDSUCURSAL = IDSUCURSAL;
	}

	public Integer getIDSUCURSAL() {
		return this.IDSUCURSAL;
	}

	public void setIDPROGRAMACIONTAREA(String IDPROGRAMACIONTAREA) {
		this.IDPROGRAMACIONTAREA = IDPROGRAMACIONTAREA;
	}

	public String getIDPROGRAMACIONTAREA() {
		return this.IDPROGRAMACIONTAREA;
	}

	public void setITEM(Integer ITEM) {
		this.ITEM = ITEM;
	}

	public Integer getITEM() {
		return this.ITEM;
	}

	public void setIDPROCESO(Integer IDPROCESO) {
		this.IDPROCESO = IDPROCESO;
	}

	public Integer getIDPROCESO() {
		return this.IDPROCESO;
	}

	public void setIDZONA(Integer IDZONA) {
		this.IDZONA = IDZONA;
	}

	public Integer getIDZONA() {
		return this.IDZONA;
	}

	public void setIDALMACEN(Integer IDALMACEN) {
		this.IDALMACEN = IDALMACEN;
	}

	public Integer getIDALMACEN() {
		return this.IDALMACEN;
	}

	public void setIDACCESORIO(Integer IDACCESORIO) {
		this.IDACCESORIO = IDACCESORIO;
	}

	public Integer getIDACCESORIO() {
		return this.IDACCESORIO;
	}

	public void setIDPALETA(String IDPALETA) {
		this.IDPALETA = IDPALETA;
	}

	public String getIDPALETA() {
		return this.IDPALETA;
	}

	public void setIDUBICACION(String IDUBICACION) {
		this.IDUBICACION = IDUBICACION;
	}

	public String getIDUBICACION() {
		return this.IDUBICACION;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}



	/* Sets & Gets FK*/

}