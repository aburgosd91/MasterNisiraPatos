package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Tabla(nombre = "DZONADIAGRAMA")
public class DZONADIAGRAMA {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDSUCURSAL;
	@ClavePrimaria
	@Columna
	private Integer IDZONA;
	@ClavePrimaria
	@Columna
	private Integer CORDENADAX;
	@ClavePrimaria
	@Columna
	private Integer CORDENADAY;
	@Columna
	private Integer IDACCESORIO;
	@Columna
	private Integer IDALMACEN;
	@Columna
	private String IDDISTRIBUCION;
	@Columna
	private String COLORHEXADECIMAL;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer ESTADO;
	@Columna
	private Integer SINCRONIZA;
	@XStreamOmitField
	private String TIPO;
	@XStreamOmitField
	private Integer IDRACK;
	@XStreamOmitField
	private String TIPORACK;
	
	private List<DZONADIAGRAMAUBICACION> listDZONADIAGRAMAUBICACION;
	
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

	public void setIDZONA(Integer IDZONA) {
		this.IDZONA = IDZONA;
	}

	public Integer getIDZONA() {
		return this.IDZONA;
	}

	public void setCORDENADAX(Integer CORDENADAX) {
		this.CORDENADAX = CORDENADAX;
	}

	public Integer getCORDENADAX() {
		return this.CORDENADAX;
	}

	public void setCORDENADAY(Integer CORDENADAY) {
		this.CORDENADAY = CORDENADAY;
	}

	public Integer getCORDENADAY() {
		return this.CORDENADAY;
	}

	public void setIDACCESORIO(Integer IDACCESORIO) {
		this.IDACCESORIO = IDACCESORIO;
	}

	public Integer getIDACCESORIO() {
		return this.IDACCESORIO;
	}

	public void setIDALMACEN(Integer IDALMACEN) {
		this.IDALMACEN = IDALMACEN;
	}

	public Integer getIDALMACEN() {
		return this.IDALMACEN;
	}

	public void setIDDISTRIBUCION(String IDDISTRIBUCION) {
		this.IDDISTRIBUCION = IDDISTRIBUCION;
	}

	public String getIDDISTRIBUCION() {
		return this.IDDISTRIBUCION;
	}

	public void setCOLORHEXADECIMAL(String COLORHEXADECIMAL) {
		this.COLORHEXADECIMAL = COLORHEXADECIMAL;
	}

	public String getCOLORHEXADECIMAL() {
		return this.COLORHEXADECIMAL;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	public void setESTADO(Integer ESTADO) {
		this.ESTADO = ESTADO;
	}

	public Integer getESTADO() {
		return this.ESTADO;
	}

	public void setSINCRONIZA(Integer SINCRONIZA) {
		this.SINCRONIZA = SINCRONIZA;
	}

	public Integer getSINCRONIZA() {
		return this.SINCRONIZA;
	}

	public Integer getIDRACK() {
		return IDRACK;
	}

	public void setIDRACK(Integer iDRACK) {
		IDRACK = iDRACK;
	}

	public String getTIPO() {
		return TIPO;
	}

	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}

	public String getTIPORACK() {
		return TIPORACK;
	}

	public void setTIPORACK(String tIPORACK) {
		TIPORACK = tIPORACK;
	}

	public List<DZONADIAGRAMAUBICACION> getListDZONADIAGRAMAUBICACION() {
		return listDZONADIAGRAMAUBICACION;
	}

	public void setListDZONADIAGRAMAUBICACION(List<DZONADIAGRAMAUBICACION> listDZONADIAGRAMAUBICACION) {
		this.listDZONADIAGRAMAUBICACION = listDZONADIAGRAMAUBICACION;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDZONA + ", " + CORDENADAX + ", " + CORDENADAY + ", "
				+ (IDACCESORIO==null?"Null":IDACCESORIO) + ", " + (IDALMACEN==null?0:IDALMACEN) + ", " + IDDISTRIBUCION + ", " + COLORHEXADECIMAL + ", "
				+ FECHACREACION + ", " + (ESTADO==null?0:ESTADO) + ", " + (SINCRONIZA==null?0:SINCRONIZA)+"]";
	}



	/* Sets & Gets FK*/

}