package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "MOVUBICACION")
public class MOVUBICACION {
	@ClavePrimaria
	@Columna
	private Integer IDMOVUBICACION;
	@Columna
	private Integer IDEMPRESA;
	@Columna
	private Integer IDSUCURSAL;
	@Columna
	private Integer IDZONA;
	@Columna
	private Integer IDALMACEN;
	@Columna
	private Integer IDACCESORIO;
	@Columna
	private String IDPALETA;
	@Columna
	private String NROPALETA;
	@Columna
	private String IDUBICACION;
	@Columna
	private Integer FACTOR;
	@Columna
	private String IDPROGRAMACIONTAREA;
	@Columna
	private Date FECHACREACION;
	@Columna
	private String OBSERVACION;
	@Columna
	private String USRCREACION;
	@Columna
	private Integer TIPOUBICACION;
	@Columna
	private Integer IDTIPOPALETA;
	@Columna
	private Integer DIVISIONPALETA;
	@Columna
	private String IDPRODUCTO;
	@Columna
	private Float CANTIDAD;
	@Columna
	private String IDENVASE;
	@Columna
	private String IDPRODUCTOR;
	@Columna
	private String IDLOTEP;
	@Columna
	private String IDCLIENTE;
	@Columna
	private String IDMOTIVO;
	private Integer CORDENADAX;
	private Integer CORDENADAY;
	
	private String ZONA;
	
	private String TIPOZONA;


	/* Sets & Gets */
	public void setIDMOVUBICACION(Integer IDMOVUBICACION) {
		this.IDMOVUBICACION = IDMOVUBICACION;
	}

	public Integer getIDMOVUBICACION() {
		return this.IDMOVUBICACION;
	}

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

	public void setNROPALETA(String NROPALETA) {
		this.NROPALETA = NROPALETA;
	}

	public String getNROPALETA() {
		return this.NROPALETA;
	}

	public void setIDUBICACION(String IDUBICACION) {
		this.IDUBICACION = IDUBICACION;
	}

	public String getIDUBICACION() {
		return this.IDUBICACION;
	}

	public void setFACTOR(Integer FACTOR) {
		this.FACTOR = FACTOR;
	}

	public Integer getFACTOR() {
		return this.FACTOR;
	}

	public void setIDPROGRAMACIONTAREA(String IDPROGRAMACIONTAREA) {
		this.IDPROGRAMACIONTAREA = IDPROGRAMACIONTAREA;
	}

	public String getIDPROGRAMACIONTAREA() {
		return this.IDPROGRAMACIONTAREA;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	public void setOBSERVACION(String OBSERVACION) {
		this.OBSERVACION = OBSERVACION;
	}

	public String getOBSERVACION() {
		return this.OBSERVACION;
	}

	public void setUSRCREACION(String USRCREACION) {
		this.USRCREACION = USRCREACION;
	}

	public String getUSRCREACION() {
		return this.USRCREACION;
	}

	public void setTIPOUBICACION(Integer TIPOUBICACION) {
		this.TIPOUBICACION = TIPOUBICACION;
	}

	public Integer getTIPOUBICACION() {
		return this.TIPOUBICACION;
	}

	public void setIDTIPOPALETA(Integer IDTIPOPALETA) {
		this.IDTIPOPALETA = IDTIPOPALETA;
	}

	public Integer getIDTIPOPALETA() {
		return this.IDTIPOPALETA;
	}

	public void setDIVISIONPALETA(Integer DIVISIONPALETA) {
		this.DIVISIONPALETA = DIVISIONPALETA;
	}

	public Integer getDIVISIONPALETA() {
		return this.DIVISIONPALETA;
	}

	public void setIDPRODUCTO(String IDPRODUCTO) {
		this.IDPRODUCTO = IDPRODUCTO;
	}

	public String getIDPRODUCTO() {
		return this.IDPRODUCTO;
	}

	public void setCANTIDAD(Float CANTIDAD) {
		this.CANTIDAD = CANTIDAD;
	}

	public Float getCANTIDAD() {
		return this.CANTIDAD;
	}

	public void setIDENVASE(String IDENVASE) {
		this.IDENVASE = IDENVASE;
	}

	public String getIDENVASE() {
		return this.IDENVASE;
	}

	public void setIDPRODUCTOR(String IDPRODUCTOR) {
		this.IDPRODUCTOR = IDPRODUCTOR;
	}

	public String getIDPRODUCTOR() {
		return this.IDPRODUCTOR;
	}

	public void setIDLOTEP(String IDLOTEP) {
		this.IDLOTEP = IDLOTEP;
	}

	public String getIDLOTEP() {
		return this.IDLOTEP;
	}

	public void setIDCLIENTE(String IDCLIENTE) {
		this.IDCLIENTE = IDCLIENTE;
	}

	public String getIDCLIENTE() {
		return this.IDCLIENTE;
	}

	public void setIDMOTIVO(String IDMOTIVO) {
		this.IDMOTIVO = IDMOTIVO;
	}

	public String getIDMOTIVO() {
		return this.IDMOTIVO;
	}

	public Integer getCORDENADAX() {
		return CORDENADAX;
	}

	public void setCORDENADAX(Integer cORDENADAX) {
		CORDENADAX = cORDENADAX;
	}

	public Integer getCORDENADAY() {
		return CORDENADAY;
	}

	public void setCORDENADAY(Integer cORDENADAY) {
		CORDENADAY = cORDENADAY;
	}

	public String getZONA() {
		return ZONA;
	}

	public void setZONA(String zONA) {
		ZONA = zONA;
	}

	public String getTIPOZONA() {
		return TIPOZONA;
	}

	public void setTIPOZONA(String TIPOZONA) {
		TIPOZONA = TIPOZONA;
	}

	/* Sets & Gets FK*/

}