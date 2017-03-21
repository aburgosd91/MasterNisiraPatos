package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "EMPRESAS")
public class EMPRESAS {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@Columna
	private String RAZON_SOCIAL;
	@Columna
	private String RUC;
	@Columna
	private String DIRECCION;
	@Columna
	private String REPRESENTANTE;
	@Columna
	private String DOCIDENTIDAD;
	@Columna
	private String E_MAIL;
	@Columna
	private String TELEFONO;
	@Columna
	private String FAX;
	@Columna
	private Float ESTADO;
	@Columna
	private String RUTAREPORTES;
	@Columna
	private Date FECHACREACION;
	@Columna
	private String RUTAPRODUCTOS;
	@Columna
	private String RUTAEMPLEADOS;
	@Columna
	private String RUTADOCUMENTOS;
	@Columna
	private String SERVIDORBD;
	@Columna
	private String BASEDATOS;
	@Columna
	private String IDTIPOESTABLECIMIENTO;
	@Columna
	private String CODESTABLECIMIENTO;
	@Columna
	private Float DOMICILIOFISCAL;
	@Columna
	private String IDCONDICIONESTABLECIMIENTO;
	@Columna
	private String IDVIA;
	@Columna
	private Float NUMERO;
	@Columna
	private Float INTERIOR;
	@Columna
	private String IDZONA;
	@Columna
	private String NOMBREZONA;
	@Columna
	private String REFERENCIA;
	@Columna
	private String IDUBIGEO;
	@Columna
	private String DOCIDENTIDAD2;
	@Columna
	private String REPRESENTANTE2;
	@Columna
	private String IDCLIEPROV;
	@Columna
	private Float CON_SENATI;
	@Columna
	private String RUTABACKUP;
	@Columna
	private String USUARIOFTP;
	@Columna
	private String PASSFTP;
	@Columna
	private String RUTARELOJ;
	@Columna
	private String RUTAGANADO;
	@Columna
	private String BDWEBSERVICE;
	@Columna
	private String IDBASEDATOS;
	@Columna
	private Float usa_tareomovil;
	@Columna
	private Float usa_cismovil;
	@Columna
	private String USUARIO_SOL;
	@Columna
	private String cod_empresa;
	@Columna
	private String nombre_corto;
	@Columna
	private String part_electronica;
	@Columna
	private String iddocidentidad;
	@Columna
	private String iddocidentidad2;
	@Columna
	private Float usa_zktime;
	@Columna
	private String linckserver_zktime;
	@Columna
	private String linckserver_zktime_nisira;
	@Columna
	private String RUTASERVICIOWS;
	@Columna
	private String RUTADOCELECTRONICOS;
	@Columna
	private String idempresa_spring;
	@Columna
	private String RUTA_EXPORTAR;
	@Columna
	private String RUTA_REPORTES;



	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setRAZON_SOCIAL(String RAZON_SOCIAL) {
		this.RAZON_SOCIAL = RAZON_SOCIAL;
	}

	public String getRAZON_SOCIAL() {
		return this.RAZON_SOCIAL;
	}

	public void setRUC(String RUC) {
		this.RUC = RUC;
	}

	public String getRUC() {
		return this.RUC;
	}

	public void setDIRECCION(String DIRECCION) {
		this.DIRECCION = DIRECCION;
	}

	public String getDIRECCION() {
		return this.DIRECCION;
	}

	public void setREPRESENTANTE(String REPRESENTANTE) {
		this.REPRESENTANTE = REPRESENTANTE;
	}

	public String getREPRESENTANTE() {
		return this.REPRESENTANTE;
	}

	public void setDOCIDENTIDAD(String DOCIDENTIDAD) {
		this.DOCIDENTIDAD = DOCIDENTIDAD;
	}

	public String getDOCIDENTIDAD() {
		return this.DOCIDENTIDAD;
	}

	public void setE_MAIL(String E_MAIL) {
		this.E_MAIL = E_MAIL;
	}

	public String getE_MAIL() {
		return this.E_MAIL;
	}

	public void setTELEFONO(String TELEFONO) {
		this.TELEFONO = TELEFONO;
	}

	public String getTELEFONO() {
		return this.TELEFONO;
	}

	public void setFAX(String FAX) {
		this.FAX = FAX;
	}

	public String getFAX() {
		return this.FAX;
	}

	public void setESTADO(Float ESTADO) {
		this.ESTADO = ESTADO;
	}

	public Float getESTADO() {
		return this.ESTADO;
	}

	public void setRUTAREPORTES(String RUTAREPORTES) {
		this.RUTAREPORTES = RUTAREPORTES;
	}

	public String getRUTAREPORTES() {
		return this.RUTAREPORTES;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	public void setRUTAPRODUCTOS(String RUTAPRODUCTOS) {
		this.RUTAPRODUCTOS = RUTAPRODUCTOS;
	}

	public String getRUTAPRODUCTOS() {
		return this.RUTAPRODUCTOS;
	}

	public void setRUTAEMPLEADOS(String RUTAEMPLEADOS) {
		this.RUTAEMPLEADOS = RUTAEMPLEADOS;
	}

	public String getRUTAEMPLEADOS() {
		return this.RUTAEMPLEADOS;
	}

	public void setRUTADOCUMENTOS(String RUTADOCUMENTOS) {
		this.RUTADOCUMENTOS = RUTADOCUMENTOS;
	}

	public String getRUTADOCUMENTOS() {
		return this.RUTADOCUMENTOS;
	}

	public void setSERVIDORBD(String SERVIDORBD) {
		this.SERVIDORBD = SERVIDORBD;
	}

	public String getSERVIDORBD() {
		return this.SERVIDORBD;
	}

	public void setBASEDATOS(String BASEDATOS) {
		this.BASEDATOS = BASEDATOS;
	}

	public String getBASEDATOS() {
		return this.BASEDATOS;
	}

	public void setIDTIPOESTABLECIMIENTO(String IDTIPOESTABLECIMIENTO) {
		this.IDTIPOESTABLECIMIENTO = IDTIPOESTABLECIMIENTO;
	}

	public String getIDTIPOESTABLECIMIENTO() {
		return this.IDTIPOESTABLECIMIENTO;
	}

	public void setCODESTABLECIMIENTO(String CODESTABLECIMIENTO) {
		this.CODESTABLECIMIENTO = CODESTABLECIMIENTO;
	}

	public String getCODESTABLECIMIENTO() {
		return this.CODESTABLECIMIENTO;
	}

	public void setDOMICILIOFISCAL(Float DOMICILIOFISCAL) {
		this.DOMICILIOFISCAL = DOMICILIOFISCAL;
	}

	public Float getDOMICILIOFISCAL() {
		return this.DOMICILIOFISCAL;
	}

	public void setIDCONDICIONESTABLECIMIENTO(String IDCONDICIONESTABLECIMIENTO) {
		this.IDCONDICIONESTABLECIMIENTO = IDCONDICIONESTABLECIMIENTO;
	}

	public String getIDCONDICIONESTABLECIMIENTO() {
		return this.IDCONDICIONESTABLECIMIENTO;
	}

	public void setIDVIA(String IDVIA) {
		this.IDVIA = IDVIA;
	}

	public String getIDVIA() {
		return this.IDVIA;
	}

	public void setNUMERO(Float NUMERO) {
		this.NUMERO = NUMERO;
	}

	public Float getNUMERO() {
		return this.NUMERO;
	}

	public void setINTERIOR(Float INTERIOR) {
		this.INTERIOR = INTERIOR;
	}

	public Float getINTERIOR() {
		return this.INTERIOR;
	}

	public void setIDZONA(String IDZONA) {
		this.IDZONA = IDZONA;
	}

	public String getIDZONA() {
		return this.IDZONA;
	}

	public void setNOMBREZONA(String NOMBREZONA) {
		this.NOMBREZONA = NOMBREZONA;
	}

	public String getNOMBREZONA() {
		return this.NOMBREZONA;
	}

	public void setREFERENCIA(String REFERENCIA) {
		this.REFERENCIA = REFERENCIA;
	}

	public String getREFERENCIA() {
		return this.REFERENCIA;
	}

	public void setIDUBIGEO(String IDUBIGEO) {
		this.IDUBIGEO = IDUBIGEO;
	}

	public String getIDUBIGEO() {
		return this.IDUBIGEO;
	}

	public void setDOCIDENTIDAD2(String DOCIDENTIDAD2) {
		this.DOCIDENTIDAD2 = DOCIDENTIDAD2;
	}

	public String getDOCIDENTIDAD2() {
		return this.DOCIDENTIDAD2;
	}

	public void setREPRESENTANTE2(String REPRESENTANTE2) {
		this.REPRESENTANTE2 = REPRESENTANTE2;
	}

	public String getREPRESENTANTE2() {
		return this.REPRESENTANTE2;
	}

	public void setIDCLIEPROV(String IDCLIEPROV) {
		this.IDCLIEPROV = IDCLIEPROV;
	}

	public String getIDCLIEPROV() {
		return this.IDCLIEPROV;
	}

	public void setCON_SENATI(Float CON_SENATI) {
		this.CON_SENATI = CON_SENATI;
	}

	public Float getCON_SENATI() {
		return this.CON_SENATI;
	}

	public void setRUTABACKUP(String RUTABACKUP) {
		this.RUTABACKUP = RUTABACKUP;
	}

	public String getRUTABACKUP() {
		return this.RUTABACKUP;
	}

	public void setUSUARIOFTP(String USUARIOFTP) {
		this.USUARIOFTP = USUARIOFTP;
	}

	public String getUSUARIOFTP() {
		return this.USUARIOFTP;
	}

	public void setPASSFTP(String PASSFTP) {
		this.PASSFTP = PASSFTP;
	}

	public String getPASSFTP() {
		return this.PASSFTP;
	}

	public void setRUTARELOJ(String RUTARELOJ) {
		this.RUTARELOJ = RUTARELOJ;
	}

	public String getRUTARELOJ() {
		return this.RUTARELOJ;
	}

	public void setRUTAGANADO(String RUTAGANADO) {
		this.RUTAGANADO = RUTAGANADO;
	}

	public String getRUTAGANADO() {
		return this.RUTAGANADO;
	}

	public void setBDWEBSERVICE(String BDWEBSERVICE) {
		this.BDWEBSERVICE = BDWEBSERVICE;
	}

	public String getBDWEBSERVICE() {
		return this.BDWEBSERVICE;
	}

	public void setIDBASEDATOS(String IDBASEDATOS) {
		this.IDBASEDATOS = IDBASEDATOS;
	}

	public String getIDBASEDATOS() {
		return this.IDBASEDATOS;
	}

	public void setUsa_tareomovil(Float usa_tareomovil) {
		this.usa_tareomovil = usa_tareomovil;
	}

	public Float getUsa_tareomovil() {
		return this.usa_tareomovil;
	}

	public void setUsa_cismovil(Float usa_cismovil) {
		this.usa_cismovil = usa_cismovil;
	}

	public Float getUsa_cismovil() {
		return this.usa_cismovil;
	}

	public void setUSUARIO_SOL(String USUARIO_SOL) {
		this.USUARIO_SOL = USUARIO_SOL;
	}

	public String getUSUARIO_SOL() {
		return this.USUARIO_SOL;
	}

	public void setCod_empresa(String cod_empresa) {
		this.cod_empresa = cod_empresa;
	}

	public String getCod_empresa() {
		return this.cod_empresa;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getNombre_corto() {
		return this.nombre_corto;
	}

	public void setPart_electronica(String part_electronica) {
		this.part_electronica = part_electronica;
	}

	public String getPart_electronica() {
		return this.part_electronica;
	}

	public void setIddocidentidad(String iddocidentidad) {
		this.iddocidentidad = iddocidentidad;
	}

	public String getIddocidentidad() {
		return this.iddocidentidad;
	}

	public void setIddocidentidad2(String iddocidentidad2) {
		this.iddocidentidad2 = iddocidentidad2;
	}

	public String getIddocidentidad2() {
		return this.iddocidentidad2;
	}

	public void setUsa_zktime(Float usa_zktime) {
		this.usa_zktime = usa_zktime;
	}

	public Float getUsa_zktime() {
		return this.usa_zktime;
	}

	public void setLinckserver_zktime(String linckserver_zktime) {
		this.linckserver_zktime = linckserver_zktime;
	}

	public String getLinckserver_zktime() {
		return this.linckserver_zktime;
	}

	public void setLinckserver_zktime_nisira(String linckserver_zktime_nisira) {
		this.linckserver_zktime_nisira = linckserver_zktime_nisira;
	}

	public String getLinckserver_zktime_nisira() {
		return this.linckserver_zktime_nisira;
	}

	public void setRUTASERVICIOWS(String RUTASERVICIOWS) {
		this.RUTASERVICIOWS = RUTASERVICIOWS;
	}

	public String getRUTASERVICIOWS() {
		return this.RUTASERVICIOWS;
	}

	public void setRUTADOCELECTRONICOS(String RUTADOCELECTRONICOS) {
		this.RUTADOCELECTRONICOS = RUTADOCELECTRONICOS;
	}

	public String getRUTADOCELECTRONICOS() {
		return this.RUTADOCELECTRONICOS;
	}

	public void setIdempresa_spring(String idempresa_spring) {
		this.idempresa_spring = idempresa_spring;
	}

	public String getIdempresa_spring() {
		return this.idempresa_spring;
	}

	public void setRUTA_EXPORTAR(String RUTA_EXPORTAR) {
		this.RUTA_EXPORTAR = RUTA_EXPORTAR;
	}

	public String getRUTA_EXPORTAR() {
		return this.RUTA_EXPORTAR;
	}

	public void setRUTA_REPORTES(String RUTA_REPORTES) {
		this.RUTA_REPORTES = RUTA_REPORTES;
	}

	public String getRUTA_REPORTES() {
		return this.RUTA_REPORTES;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + RAZON_SOCIAL + ", " + RUC + ", " + DIRECCION + ", " + REPRESENTANTE + ", "
				+ DOCIDENTIDAD + ", " + E_MAIL + ", " + TELEFONO + ", " + FAX + ", " + ESTADO + ", " + RUTAREPORTES
				+ ", " + FECHACREACION + ", " + RUTAPRODUCTOS + ", " + RUTAEMPLEADOS + ", " + RUTADOCUMENTOS + ", "
				+ SERVIDORBD + ", " + BASEDATOS + ", " + IDTIPOESTABLECIMIENTO + ", " + CODESTABLECIMIENTO + ", "
				+ DOMICILIOFISCAL + ", " + IDCONDICIONESTABLECIMIENTO + ", " + IDVIA + ", " + NUMERO + ", " + INTERIOR
				+ ", " + IDZONA + ", " + NOMBREZONA + ", " + REFERENCIA + ", " + IDUBIGEO + ", " + DOCIDENTIDAD2 + ", "
				+ REPRESENTANTE2 + ", " + IDCLIEPROV + ", " + CON_SENATI + ", " + RUTABACKUP + ", " + USUARIOFTP + ", "
				+ PASSFTP + ", " + RUTARELOJ + ", " + RUTAGANADO + ", " + BDWEBSERVICE + ", " + IDBASEDATOS + ", "
				+ usa_tareomovil + ", " + usa_cismovil + ", " + USUARIO_SOL + ", " + cod_empresa + ", " + nombre_corto
				+ ", " + part_electronica + ", " + iddocidentidad + ", " + iddocidentidad2 + ", " + usa_zktime + ", "
				+ linckserver_zktime + ", " + linckserver_zktime_nisira + ", " + RUTASERVICIOWS + ", "
				+ RUTADOCELECTRONICOS + ", " + idempresa_spring + ", " + RUTA_EXPORTAR + ", " + RUTA_REPORTES + "]";
	}



	/* Sets & Gets FK*/

}