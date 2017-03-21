package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.Serializable;
import java.util.Date;

@Tabla(nombre = "DZONAGENERAL")
public class DZONAGENERAL implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4301545248036636499L;
	@Columna
	private Integer IDEMPRESA;
	@Columna
	private Integer IDSUCURSAL;
	@Columna
	private Integer IDZONAGENERAL;
	@Columna
	private Integer IDZONA;
	@Columna
	private Integer CORDENADAX;
	@Columna
	private Integer CORDENADAY;
	@Columna
	private Integer DCORDENADAX;
	@Columna
	private Integer DCORDENADAY;
	@Columna
	private String COLOR;
	@Columna
	private String IDUBICACION;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer SINCRONIZA;
	@Columna
	private Integer PUERTA;
	@XStreamOmitField
	private String ZONA;
	@XStreamOmitField
	private String TIPO;
	@XStreamOmitField
	private String TIPORACKS;
	
	@XStreamOmitField
	private String COLORZONA;
	@XStreamOmitField
	private Integer IDALMACEN;
	@XStreamOmitField
	private Integer IDACCESORIO;
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

	public void setIDZONAGENERAL(Integer IDZONAGENERAL) {
		this.IDZONAGENERAL = IDZONAGENERAL;
	}

	public Integer getIDZONAGENERAL() {
		return this.IDZONAGENERAL;
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

	public void setCOLOR(String COLOR) {
		this.COLOR = COLOR;
	}

	public String getCOLOR() {
		return this.COLOR;
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

	public void setSINCRONIZA(Integer SINCRONIZA) {
		this.SINCRONIZA = SINCRONIZA;
	}

	public Integer getSINCRONIZA() {
		return this.SINCRONIZA;
	}

	public String getZONA() {
		return ZONA;
	}

	public void setZONA(String zONA) {
		ZONA = zONA;
	}

	public String getTIPO() {
		return TIPO;
	}

	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}

	public String getTIPORACKS() {
		return TIPORACKS;
	}

	public void setTIPORACKS(String tIPORACKS) {
		TIPORACKS = tIPORACKS;
	}

	public Integer getDCORDENADAX() {
		return DCORDENADAX;
	}

	public void setDCORDENADAX(Integer dCORDENADAX) {
		DCORDENADAX = dCORDENADAX;
	}

	public Integer getDCORDENADAY() {
		return DCORDENADAY;
	}

	public void setDCORDENADAY(Integer dCORDENADAY) {
		DCORDENADAY = dCORDENADAY;
	}

	public Integer getPUERTA() {
		return PUERTA;
	}

	public void setPUERTA(Integer pUERTA) {
		PUERTA = pUERTA;
	}

	public String getCOLORZONA() {
		return COLORZONA;
	}

	public void setCOLORZONA(String cOLORZONA) {
		COLORZONA = cOLORZONA;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDSUCURSAL + ", " + IDZONAGENERAL + ", " + IDZONA + ", " + CORDENADAX + ", "
				+ CORDENADAY + ", " + DCORDENADAX + ", " + DCORDENADAY + ", " + COLOR + ", " + IDUBICACION + ", "
				+ FECHACREACION + ", " + SINCRONIZA + ", " + (PUERTA==null?0:PUERTA)+ "]";
	}

	public Integer getIDALMACEN() {
		return IDALMACEN;
	}

	public void setIDALMACEN(Integer iDALMACEN) {
		IDALMACEN = iDALMACEN;
	}

	public Integer getIDACCESORIO() {
		return IDACCESORIO;
	}

	public void setIDACCESORIO(Integer iDACCESORIO) {
		IDACCESORIO = iDACCESORIO;
	}



	/* Sets & Gets FK*/

}