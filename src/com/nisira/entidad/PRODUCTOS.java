package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "PRODUCTOS")
public class PRODUCTOS {
	@ClavePrimaria
	@Columna
	private String IDEMPRESA;
	@ClavePrimaria
	@Columna
	private String IDPRODUCTO;
	@Columna
	private String ARANCELES;
	@Columna
	private Float EN_MAQUINA;
	@Columna
	private Float ES_DESCARTE;
	@Columna
	private Float ES_TERMINADO;
	@Columna
	private String IDTERMINADO;
	@Columna
	private String IDSUBGRUPO;
	@Columna
	private String IDGRUPO;
	@Columna
	private String IDALGORITMO;
	@Columna
	private Float PARA_EXPORTACION;
	@Columna
	private Float PARA_VENTA;
	@Columna
	private Float PARA_CONSERVA;
	@Columna
	private Float PIDE_LOTE;
	@Columna
	private Float PIDE_SERIE;
	@Columna
	private Float ES_AFECTO;
	@Columna
	private Float TIEMPOREPOSICION;
	@Columna
	private String CARACTERISTICAS;
	@Columna
	private Float ES_COMPUESTO;
	@Columna
	private String DESCRIPCION;
	@Columna
	private String DESCRIPCION1;
	@Columna
	private Float ES_EXONERADO;
	@Columna
	private String FOTO;
	@Columna
	private String IDMEDIDA;
	@Columna
	private Float PESO;
	@Columna
	private Float REGIMEN_AGRARIO;
	@Columna
	private Float VOLUMEN;
	@Columna
	private String LONGITUD;
	@Columna
	private String TIPO_PUNTA;
	@Columna
	private String DIAMETRO;
	@Columna
	private Float ES_APROVECHABLE;
	@Columna
	private String NOMBRE_COMERCIAL;
	@Columna
	private String IDMARCA;
	@Columna
	private String IDPARTIDA;
	@Columna
	private String IDCOLOR;
	@Columna
	private String IDINSUMO;
	@Columna
	private Float PIDE_ESTADO;
	@Columna
	private String IDPRODUCTO2;
	@Columna
	private Float ESTADO;
	@Columna
	private String SINCRONIZA;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Float REVISADO;
	@Columna
	private String IDMODELO;
	@Columna
	private Float GENERA_SERIE;
	@Columna
	private Float ES_SERVICIO;
	@Columna
	private Float HORAS_STD;
	@Columna
	private String IDDESCUENTO;
	@Columna
	private Float FACTORREPOSICION;
	@Columna
	private String IDUBICACION;
	@Columna
	private Float ES_NEUMATICO;
	@Columna
	private Float PROF_COCADA;
	@Columna
	private Float PRES_MONTAJE;
	@Columna
	private String IDTIPOPRODUCTO;
	@Columna
	private Float ES_TERCERO;
	@Columna
	private Float ES_KIT;
	@Columna
	private Float ES_MERMA;
	@Columna
	private Float ES_ENSAMBLADO;
	@Columna
	private String CODIGOSAP;
	@Columna
	private Float es_ganado;
	@Columna
	private Float ES_PProceso;
	@Columna
	private Float ES_MATPRIMA;
	@Columna
	private Float ES_Congelado;
	@Columna
	private Float Es_Fresco;
	@Columna
	private String IDTALLA;
	@Columna
	private Float UGG;
	@Columna
	private String IDCCOSTO_GANADO;
	@Columna
	private String IDCLASECCOSTO;
	@Columna
	private Float ES_ACTIVO;
	@Columna
	private String IDTIPOACTIVO;
	@Columna
	private String IDCCOSTO_ACTIVO;
	@Columna
	private String IDCTA_ACTIVO;
	@Columna
	private String IDCTA_DEPREC;
	@Columna
	private Float ES_DETRACCION;
	@Columna
	private String IDTIPODETRA;
	@Columna
	private Float ES_DRAWBACK;
	@Columna
	private String IDNOMENCLATURA;
	@Columna
	private Float PARA_FRESCO;
	@Columna
	private String IDCULTIVO;
	@Columna
	private String IDVARIEDAD;
	@Columna
	private Float ES_INDDRAWBACK;
	@Columna
	private Float PESONETO;
	@Columna
	private Float TIPO_ISC;
	@Columna
	private Float VALOR_ISC;
	@Columna
	private Float EQUIV_ISC;
	@Columna
	private Float KG_CAJAS;
	@Columna
	private Float PIDE_LOTE_CCOSTO;
	@Columna
	private String IDMEDIDA2;
	@Columna
	private Float EXIGE_U2;
	@Columna
	private Float FACTOR_U2;
	@Columna
	private Float PORCEN_MERMA;
	@Columna
	private Float AFECTO_PERCEPCION;
	@Columna
	private String IDCONDICION;
	@Columna
	private Integer UAC;
	@Columna
	private Float UM2_FORMULA;
	@Columna
	private String TIPO_PROCESO;
	@Columna
	private String idtiporet;
	@Columna
	private Float afecto_retencion;
	@Columna
	private String TIPOPRODUCTO;
	@Columna
	private String TIPO_PROCESO_ORIGEN;
	@Columna
	private String IDPRODUCTO_EQUIV;
	@Columna
	private Float cestandar_mof;
	@Columna
	private Float cestandar_mex;
	@Columna
	private Float factorcosto;
	@Columna
	private Float es_vehiculo;
	@Columna
	private String retiqueta;
	@Columna
	private String rtecnica;
	@Columna
	private String rseguridad;
	@Columna
	private String rcalidad;
	@Columna
	private Float etiqueta;
	@Columna
	private Float tecnica;
	@Columna
	private Float seguridad;
	@Columna
	private Float calidad;
	@Columna
	private Float prohibido;
	@Columna
	private String descripcion2;
	@Columna
	private Float PESO_TARA;
	@Columna
	private Float es_herramienta;
	@Columna
	private Float regla_ot;
	@Columna
	private Float IMPORTADO_EXTERNO;
	@Columna
	private String IDTIPOCATALOGO;
	@Columna
	private Float es_conversion_glp;
	@Columna
	private Float NO_DECLARA_LE;
	@Columna
	private Float PARA_DECLARACION;
	@Columna
	private String Calibremm;
	@Columna
	private String Idpresentacion;
	@Columna
	private String Largo;
	@Columna
	private Integer PORCENT_PESO_PERMITIDO;
	@Columna
	private Integer Undxphl;
	@Columna
	private Float ES_GENERICO;
	@Columna
	private String COD_EQUIVALENTE;
	@Columna
	private Float FACTORCE;
	@Columna
	private String COD_GTIN;
	@Columna
	private String IDCCOSTO_PT;
	@Columna
	private String IDGRUPO2;
	@Columna
	private Float es_accesorio;
	@Columna
	private Integer valoriza_resultado;
	@Columna
	private String IDCATALOGO_UNICO;
	@Columna
	private String idproducto_spring;
	@Columna
	private Float ES_PRODUCCION_CC;
	@Columna
	private String IDCONSUMIDOR;
	@Columna
	private Float es_hojafresca;
	@Columna
	private Float es_plantafresca;
	@Columna
	private String partnumber;



	/* Sets & Gets */
	public void setIDEMPRESA(String IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public String getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDPRODUCTO(String IDPRODUCTO) {
		this.IDPRODUCTO = IDPRODUCTO;
	}

	public String getIDPRODUCTO() {
		return this.IDPRODUCTO;
	}

	public void setARANCELES(String ARANCELES) {
		this.ARANCELES = ARANCELES;
	}

	public String getARANCELES() {
		return this.ARANCELES;
	}

	public void setEN_MAQUINA(Float EN_MAQUINA) {
		this.EN_MAQUINA = EN_MAQUINA;
	}

	public Float getEN_MAQUINA() {
		return this.EN_MAQUINA;
	}

	public void setES_DESCARTE(Float ES_DESCARTE) {
		this.ES_DESCARTE = ES_DESCARTE;
	}

	public Float getES_DESCARTE() {
		return this.ES_DESCARTE;
	}

	public void setES_TERMINADO(Float ES_TERMINADO) {
		this.ES_TERMINADO = ES_TERMINADO;
	}

	public Float getES_TERMINADO() {
		return this.ES_TERMINADO;
	}

	public void setIDTERMINADO(String IDTERMINADO) {
		this.IDTERMINADO = IDTERMINADO;
	}

	public String getIDTERMINADO() {
		return this.IDTERMINADO;
	}

	public void setIDSUBGRUPO(String IDSUBGRUPO) {
		this.IDSUBGRUPO = IDSUBGRUPO;
	}

	public String getIDSUBGRUPO() {
		return this.IDSUBGRUPO;
	}

	public void setIDGRUPO(String IDGRUPO) {
		this.IDGRUPO = IDGRUPO;
	}

	public String getIDGRUPO() {
		return this.IDGRUPO;
	}

	public void setIDALGORITMO(String IDALGORITMO) {
		this.IDALGORITMO = IDALGORITMO;
	}

	public String getIDALGORITMO() {
		return this.IDALGORITMO;
	}

	public void setPARA_EXPORTACION(Float PARA_EXPORTACION) {
		this.PARA_EXPORTACION = PARA_EXPORTACION;
	}

	public Float getPARA_EXPORTACION() {
		return this.PARA_EXPORTACION;
	}

	public void setPARA_VENTA(Float PARA_VENTA) {
		this.PARA_VENTA = PARA_VENTA;
	}

	public Float getPARA_VENTA() {
		return this.PARA_VENTA;
	}

	public void setPARA_CONSERVA(Float PARA_CONSERVA) {
		this.PARA_CONSERVA = PARA_CONSERVA;
	}

	public Float getPARA_CONSERVA() {
		return this.PARA_CONSERVA;
	}

	public void setPIDE_LOTE(Float PIDE_LOTE) {
		this.PIDE_LOTE = PIDE_LOTE;
	}

	public Float getPIDE_LOTE() {
		return this.PIDE_LOTE;
	}

	public void setPIDE_SERIE(Float PIDE_SERIE) {
		this.PIDE_SERIE = PIDE_SERIE;
	}

	public Float getPIDE_SERIE() {
		return this.PIDE_SERIE;
	}

	public void setES_AFECTO(Float ES_AFECTO) {
		this.ES_AFECTO = ES_AFECTO;
	}

	public Float getES_AFECTO() {
		return this.ES_AFECTO;
	}

	public void setTIEMPOREPOSICION(Float TIEMPOREPOSICION) {
		this.TIEMPOREPOSICION = TIEMPOREPOSICION;
	}

	public Float getTIEMPOREPOSICION() {
		return this.TIEMPOREPOSICION;
	}

	public void setCARACTERISTICAS(String CARACTERISTICAS) {
		this.CARACTERISTICAS = CARACTERISTICAS;
	}

	public String getCARACTERISTICAS() {
		return this.CARACTERISTICAS;
	}

	public void setES_COMPUESTO(Float ES_COMPUESTO) {
		this.ES_COMPUESTO = ES_COMPUESTO;
	}

	public Float getES_COMPUESTO() {
		return this.ES_COMPUESTO;
	}

	public void setDESCRIPCION(String DESCRIPCION) {
		this.DESCRIPCION = DESCRIPCION;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
	}

	public void setDESCRIPCION1(String DESCRIPCION1) {
		this.DESCRIPCION1 = DESCRIPCION1;
	}

	public String getDESCRIPCION1() {
		return this.DESCRIPCION1;
	}

	public void setES_EXONERADO(Float ES_EXONERADO) {
		this.ES_EXONERADO = ES_EXONERADO;
	}

	public Float getES_EXONERADO() {
		return this.ES_EXONERADO;
	}

	public void setFOTO(String FOTO) {
		this.FOTO = FOTO;
	}

	public String getFOTO() {
		return this.FOTO;
	}

	public void setIDMEDIDA(String IDMEDIDA) {
		this.IDMEDIDA = IDMEDIDA;
	}

	public String getIDMEDIDA() {
		return this.IDMEDIDA;
	}

	public void setPESO(Float PESO) {
		this.PESO = PESO;
	}

	public Float getPESO() {
		return this.PESO;
	}

	public void setREGIMEN_AGRARIO(Float REGIMEN_AGRARIO) {
		this.REGIMEN_AGRARIO = REGIMEN_AGRARIO;
	}

	public Float getREGIMEN_AGRARIO() {
		return this.REGIMEN_AGRARIO;
	}

	public void setVOLUMEN(Float VOLUMEN) {
		this.VOLUMEN = VOLUMEN;
	}

	public Float getVOLUMEN() {
		return this.VOLUMEN;
	}

	public void setLONGITUD(String LONGITUD) {
		this.LONGITUD = LONGITUD;
	}

	public String getLONGITUD() {
		return this.LONGITUD;
	}

	public void setTIPO_PUNTA(String TIPO_PUNTA) {
		this.TIPO_PUNTA = TIPO_PUNTA;
	}

	public String getTIPO_PUNTA() {
		return this.TIPO_PUNTA;
	}

	public void setDIAMETRO(String DIAMETRO) {
		this.DIAMETRO = DIAMETRO;
	}

	public String getDIAMETRO() {
		return this.DIAMETRO;
	}

	public void setES_APROVECHABLE(Float ES_APROVECHABLE) {
		this.ES_APROVECHABLE = ES_APROVECHABLE;
	}

	public Float getES_APROVECHABLE() {
		return this.ES_APROVECHABLE;
	}

	public void setNOMBRE_COMERCIAL(String NOMBRE_COMERCIAL) {
		this.NOMBRE_COMERCIAL = NOMBRE_COMERCIAL;
	}

	public String getNOMBRE_COMERCIAL() {
		return this.NOMBRE_COMERCIAL;
	}

	public void setIDMARCA(String IDMARCA) {
		this.IDMARCA = IDMARCA;
	}

	public String getIDMARCA() {
		return this.IDMARCA;
	}

	public void setIDPARTIDA(String IDPARTIDA) {
		this.IDPARTIDA = IDPARTIDA;
	}

	public String getIDPARTIDA() {
		return this.IDPARTIDA;
	}

	public void setIDCOLOR(String IDCOLOR) {
		this.IDCOLOR = IDCOLOR;
	}

	public String getIDCOLOR() {
		return this.IDCOLOR;
	}

	public void setIDINSUMO(String IDINSUMO) {
		this.IDINSUMO = IDINSUMO;
	}

	public String getIDINSUMO() {
		return this.IDINSUMO;
	}

	public void setPIDE_ESTADO(Float PIDE_ESTADO) {
		this.PIDE_ESTADO = PIDE_ESTADO;
	}

	public Float getPIDE_ESTADO() {
		return this.PIDE_ESTADO;
	}

	public void setIDPRODUCTO2(String IDPRODUCTO2) {
		this.IDPRODUCTO2 = IDPRODUCTO2;
	}

	public String getIDPRODUCTO2() {
		return this.IDPRODUCTO2;
	}

	public void setESTADO(Float ESTADO) {
		this.ESTADO = ESTADO;
	}

	public Float getESTADO() {
		return this.ESTADO;
	}

	public void setSINCRONIZA(String SINCRONIZA) {
		this.SINCRONIZA = SINCRONIZA;
	}

	public String getSINCRONIZA() {
		return this.SINCRONIZA;
	}

	public void setFECHACREACION(Date FECHACREACION) {
		this.FECHACREACION = FECHACREACION;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}

	public void setREVISADO(Float REVISADO) {
		this.REVISADO = REVISADO;
	}

	public Float getREVISADO() {
		return this.REVISADO;
	}

	public void setIDMODELO(String IDMODELO) {
		this.IDMODELO = IDMODELO;
	}

	public String getIDMODELO() {
		return this.IDMODELO;
	}

	public void setGENERA_SERIE(Float GENERA_SERIE) {
		this.GENERA_SERIE = GENERA_SERIE;
	}

	public Float getGENERA_SERIE() {
		return this.GENERA_SERIE;
	}

	public void setES_SERVICIO(Float ES_SERVICIO) {
		this.ES_SERVICIO = ES_SERVICIO;
	}

	public Float getES_SERVICIO() {
		return this.ES_SERVICIO;
	}

	public void setHORAS_STD(Float HORAS_STD) {
		this.HORAS_STD = HORAS_STD;
	}

	public Float getHORAS_STD() {
		return this.HORAS_STD;
	}

	public void setIDDESCUENTO(String IDDESCUENTO) {
		this.IDDESCUENTO = IDDESCUENTO;
	}

	public String getIDDESCUENTO() {
		return this.IDDESCUENTO;
	}

	public void setFACTORREPOSICION(Float FACTORREPOSICION) {
		this.FACTORREPOSICION = FACTORREPOSICION;
	}

	public Float getFACTORREPOSICION() {
		return this.FACTORREPOSICION;
	}

	public void setIDUBICACION(String IDUBICACION) {
		this.IDUBICACION = IDUBICACION;
	}

	public String getIDUBICACION() {
		return this.IDUBICACION;
	}

	public void setES_NEUMATICO(Float ES_NEUMATICO) {
		this.ES_NEUMATICO = ES_NEUMATICO;
	}

	public Float getES_NEUMATICO() {
		return this.ES_NEUMATICO;
	}

	public void setPROF_COCADA(Float PROF_COCADA) {
		this.PROF_COCADA = PROF_COCADA;
	}

	public Float getPROF_COCADA() {
		return this.PROF_COCADA;
	}

	public void setPRES_MONTAJE(Float PRES_MONTAJE) {
		this.PRES_MONTAJE = PRES_MONTAJE;
	}

	public Float getPRES_MONTAJE() {
		return this.PRES_MONTAJE;
	}

	public void setIDTIPOPRODUCTO(String IDTIPOPRODUCTO) {
		this.IDTIPOPRODUCTO = IDTIPOPRODUCTO;
	}

	public String getIDTIPOPRODUCTO() {
		return this.IDTIPOPRODUCTO;
	}

	public void setES_TERCERO(Float ES_TERCERO) {
		this.ES_TERCERO = ES_TERCERO;
	}

	public Float getES_TERCERO() {
		return this.ES_TERCERO;
	}

	public void setES_KIT(Float ES_KIT) {
		this.ES_KIT = ES_KIT;
	}

	public Float getES_KIT() {
		return this.ES_KIT;
	}

	public void setES_MERMA(Float ES_MERMA) {
		this.ES_MERMA = ES_MERMA;
	}

	public Float getES_MERMA() {
		return this.ES_MERMA;
	}

	public void setES_ENSAMBLADO(Float ES_ENSAMBLADO) {
		this.ES_ENSAMBLADO = ES_ENSAMBLADO;
	}

	public Float getES_ENSAMBLADO() {
		return this.ES_ENSAMBLADO;
	}

	public void setCODIGOSAP(String CODIGOSAP) {
		this.CODIGOSAP = CODIGOSAP;
	}

	public String getCODIGOSAP() {
		return this.CODIGOSAP;
	}

	public void setEs_ganado(Float es_ganado) {
		this.es_ganado = es_ganado;
	}

	public Float getEs_ganado() {
		return this.es_ganado;
	}

	public void setES_PProceso(Float ES_PProceso) {
		this.ES_PProceso = ES_PProceso;
	}

	public Float getES_PProceso() {
		return this.ES_PProceso;
	}

	public void setES_MATPRIMA(Float ES_MATPRIMA) {
		this.ES_MATPRIMA = ES_MATPRIMA;
	}

	public Float getES_MATPRIMA() {
		return this.ES_MATPRIMA;
	}

	public void setES_Congelado(Float ES_Congelado) {
		this.ES_Congelado = ES_Congelado;
	}

	public Float getES_Congelado() {
		return this.ES_Congelado;
	}

	public void setEs_Fresco(Float Es_Fresco) {
		this.Es_Fresco = Es_Fresco;
	}

	public Float getEs_Fresco() {
		return this.Es_Fresco;
	}

	public void setIDTALLA(String IDTALLA) {
		this.IDTALLA = IDTALLA;
	}

	public String getIDTALLA() {
		return this.IDTALLA;
	}

	public void setUGG(Float UGG) {
		this.UGG = UGG;
	}

	public Float getUGG() {
		return this.UGG;
	}

	public void setIDCCOSTO_GANADO(String IDCCOSTO_GANADO) {
		this.IDCCOSTO_GANADO = IDCCOSTO_GANADO;
	}

	public String getIDCCOSTO_GANADO() {
		return this.IDCCOSTO_GANADO;
	}

	public void setIDCLASECCOSTO(String IDCLASECCOSTO) {
		this.IDCLASECCOSTO = IDCLASECCOSTO;
	}

	public String getIDCLASECCOSTO() {
		return this.IDCLASECCOSTO;
	}

	public void setES_ACTIVO(Float ES_ACTIVO) {
		this.ES_ACTIVO = ES_ACTIVO;
	}

	public Float getES_ACTIVO() {
		return this.ES_ACTIVO;
	}

	public void setIDTIPOACTIVO(String IDTIPOACTIVO) {
		this.IDTIPOACTIVO = IDTIPOACTIVO;
	}

	public String getIDTIPOACTIVO() {
		return this.IDTIPOACTIVO;
	}

	public void setIDCCOSTO_ACTIVO(String IDCCOSTO_ACTIVO) {
		this.IDCCOSTO_ACTIVO = IDCCOSTO_ACTIVO;
	}

	public String getIDCCOSTO_ACTIVO() {
		return this.IDCCOSTO_ACTIVO;
	}

	public void setIDCTA_ACTIVO(String IDCTA_ACTIVO) {
		this.IDCTA_ACTIVO = IDCTA_ACTIVO;
	}

	public String getIDCTA_ACTIVO() {
		return this.IDCTA_ACTIVO;
	}

	public void setIDCTA_DEPREC(String IDCTA_DEPREC) {
		this.IDCTA_DEPREC = IDCTA_DEPREC;
	}

	public String getIDCTA_DEPREC() {
		return this.IDCTA_DEPREC;
	}

	public void setES_DETRACCION(Float ES_DETRACCION) {
		this.ES_DETRACCION = ES_DETRACCION;
	}

	public Float getES_DETRACCION() {
		return this.ES_DETRACCION;
	}

	public void setIDTIPODETRA(String IDTIPODETRA) {
		this.IDTIPODETRA = IDTIPODETRA;
	}

	public String getIDTIPODETRA() {
		return this.IDTIPODETRA;
	}

	public void setES_DRAWBACK(Float ES_DRAWBACK) {
		this.ES_DRAWBACK = ES_DRAWBACK;
	}

	public Float getES_DRAWBACK() {
		return this.ES_DRAWBACK;
	}

	public void setIDNOMENCLATURA(String IDNOMENCLATURA) {
		this.IDNOMENCLATURA = IDNOMENCLATURA;
	}

	public String getIDNOMENCLATURA() {
		return this.IDNOMENCLATURA;
	}

	public void setPARA_FRESCO(Float PARA_FRESCO) {
		this.PARA_FRESCO = PARA_FRESCO;
	}

	public Float getPARA_FRESCO() {
		return this.PARA_FRESCO;
	}

	public void setIDCULTIVO(String IDCULTIVO) {
		this.IDCULTIVO = IDCULTIVO;
	}

	public String getIDCULTIVO() {
		return this.IDCULTIVO;
	}

	public void setIDVARIEDAD(String IDVARIEDAD) {
		this.IDVARIEDAD = IDVARIEDAD;
	}

	public String getIDVARIEDAD() {
		return this.IDVARIEDAD;
	}

	public void setES_INDDRAWBACK(Float ES_INDDRAWBACK) {
		this.ES_INDDRAWBACK = ES_INDDRAWBACK;
	}

	public Float getES_INDDRAWBACK() {
		return this.ES_INDDRAWBACK;
	}

	public void setPESONETO(Float PESONETO) {
		this.PESONETO = PESONETO;
	}

	public Float getPESONETO() {
		return this.PESONETO;
	}

	public void setTIPO_ISC(Float TIPO_ISC) {
		this.TIPO_ISC = TIPO_ISC;
	}

	public Float getTIPO_ISC() {
		return this.TIPO_ISC;
	}

	public void setVALOR_ISC(Float VALOR_ISC) {
		this.VALOR_ISC = VALOR_ISC;
	}

	public Float getVALOR_ISC() {
		return this.VALOR_ISC;
	}

	public void setEQUIV_ISC(Float EQUIV_ISC) {
		this.EQUIV_ISC = EQUIV_ISC;
	}

	public Float getEQUIV_ISC() {
		return this.EQUIV_ISC;
	}

	public void setKG_CAJAS(Float KG_CAJAS) {
		this.KG_CAJAS = KG_CAJAS;
	}

	public Float getKG_CAJAS() {
		return this.KG_CAJAS;
	}

	public void setPIDE_LOTE_CCOSTO(Float PIDE_LOTE_CCOSTO) {
		this.PIDE_LOTE_CCOSTO = PIDE_LOTE_CCOSTO;
	}

	public Float getPIDE_LOTE_CCOSTO() {
		return this.PIDE_LOTE_CCOSTO;
	}

	public void setIDMEDIDA2(String IDMEDIDA2) {
		this.IDMEDIDA2 = IDMEDIDA2;
	}

	public String getIDMEDIDA2() {
		return this.IDMEDIDA2;
	}

	public void setEXIGE_U2(Float EXIGE_U2) {
		this.EXIGE_U2 = EXIGE_U2;
	}

	public Float getEXIGE_U2() {
		return this.EXIGE_U2;
	}

	public void setFACTOR_U2(Float FACTOR_U2) {
		this.FACTOR_U2 = FACTOR_U2;
	}

	public Float getFACTOR_U2() {
		return this.FACTOR_U2;
	}

	public void setPORCEN_MERMA(Float PORCEN_MERMA) {
		this.PORCEN_MERMA = PORCEN_MERMA;
	}

	public Float getPORCEN_MERMA() {
		return this.PORCEN_MERMA;
	}

	public void setAFECTO_PERCEPCION(Float AFECTO_PERCEPCION) {
		this.AFECTO_PERCEPCION = AFECTO_PERCEPCION;
	}

	public Float getAFECTO_PERCEPCION() {
		return this.AFECTO_PERCEPCION;
	}

	public void setIDCONDICION(String IDCONDICION) {
		this.IDCONDICION = IDCONDICION;
	}

	public String getIDCONDICION() {
		return this.IDCONDICION;
	}

	public void setUAC(Integer UAC) {
		this.UAC = UAC;
	}

	public Integer getUAC() {
		return this.UAC;
	}

	public void setUM2_FORMULA(Float UM2_FORMULA) {
		this.UM2_FORMULA = UM2_FORMULA;
	}

	public Float getUM2_FORMULA() {
		return this.UM2_FORMULA;
	}

	public void setTIPO_PROCESO(String TIPO_PROCESO) {
		this.TIPO_PROCESO = TIPO_PROCESO;
	}

	public String getTIPO_PROCESO() {
		return this.TIPO_PROCESO;
	}

	public void setIdtiporet(String idtiporet) {
		this.idtiporet = idtiporet;
	}

	public String getIdtiporet() {
		return this.idtiporet;
	}

	public void setAfecto_retencion(Float afecto_retencion) {
		this.afecto_retencion = afecto_retencion;
	}

	public Float getAfecto_retencion() {
		return this.afecto_retencion;
	}

	public void setTIPOPRODUCTO(String TIPOPRODUCTO) {
		this.TIPOPRODUCTO = TIPOPRODUCTO;
	}

	public String getTIPOPRODUCTO() {
		return this.TIPOPRODUCTO;
	}

	public void setTIPO_PROCESO_ORIGEN(String TIPO_PROCESO_ORIGEN) {
		this.TIPO_PROCESO_ORIGEN = TIPO_PROCESO_ORIGEN;
	}

	public String getTIPO_PROCESO_ORIGEN() {
		return this.TIPO_PROCESO_ORIGEN;
	}

	public void setIDPRODUCTO_EQUIV(String IDPRODUCTO_EQUIV) {
		this.IDPRODUCTO_EQUIV = IDPRODUCTO_EQUIV;
	}

	public String getIDPRODUCTO_EQUIV() {
		return this.IDPRODUCTO_EQUIV;
	}

	public void setCestandar_mof(Float cestandar_mof) {
		this.cestandar_mof = cestandar_mof;
	}

	public Float getCestandar_mof() {
		return this.cestandar_mof;
	}

	public void setCestandar_mex(Float cestandar_mex) {
		this.cestandar_mex = cestandar_mex;
	}

	public Float getCestandar_mex() {
		return this.cestandar_mex;
	}

	public void setFactorcosto(Float factorcosto) {
		this.factorcosto = factorcosto;
	}

	public Float getFactorcosto() {
		return this.factorcosto;
	}

	public void setEs_vehiculo(Float es_vehiculo) {
		this.es_vehiculo = es_vehiculo;
	}

	public Float getEs_vehiculo() {
		return this.es_vehiculo;
	}

	public void setRetiqueta(String retiqueta) {
		this.retiqueta = retiqueta;
	}

	public String getRetiqueta() {
		return this.retiqueta;
	}

	public void setRtecnica(String rtecnica) {
		this.rtecnica = rtecnica;
	}

	public String getRtecnica() {
		return this.rtecnica;
	}

	public void setRseguridad(String rseguridad) {
		this.rseguridad = rseguridad;
	}

	public String getRseguridad() {
		return this.rseguridad;
	}

	public void setRcalidad(String rcalidad) {
		this.rcalidad = rcalidad;
	}

	public String getRcalidad() {
		return this.rcalidad;
	}

	public void setEtiqueta(Float etiqueta) {
		this.etiqueta = etiqueta;
	}

	public Float getEtiqueta() {
		return this.etiqueta;
	}

	public void setTecnica(Float tecnica) {
		this.tecnica = tecnica;
	}

	public Float getTecnica() {
		return this.tecnica;
	}

	public void setSeguridad(Float seguridad) {
		this.seguridad = seguridad;
	}

	public Float getSeguridad() {
		return this.seguridad;
	}

	public void setCalidad(Float calidad) {
		this.calidad = calidad;
	}

	public Float getCalidad() {
		return this.calidad;
	}

	public void setProhibido(Float prohibido) {
		this.prohibido = prohibido;
	}

	public Float getProhibido() {
		return this.prohibido;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}

	public String getDescripcion2() {
		return this.descripcion2;
	}

	public void setPESO_TARA(Float PESO_TARA) {
		this.PESO_TARA = PESO_TARA;
	}

	public Float getPESO_TARA() {
		return this.PESO_TARA;
	}

	public void setEs_herramienta(Float es_herramienta) {
		this.es_herramienta = es_herramienta;
	}

	public Float getEs_herramienta() {
		return this.es_herramienta;
	}

	public void setRegla_ot(Float regla_ot) {
		this.regla_ot = regla_ot;
	}

	public Float getRegla_ot() {
		return this.regla_ot;
	}

	public void setIMPORTADO_EXTERNO(Float IMPORTADO_EXTERNO) {
		this.IMPORTADO_EXTERNO = IMPORTADO_EXTERNO;
	}

	public Float getIMPORTADO_EXTERNO() {
		return this.IMPORTADO_EXTERNO;
	}

	public void setIDTIPOCATALOGO(String IDTIPOCATALOGO) {
		this.IDTIPOCATALOGO = IDTIPOCATALOGO;
	}

	public String getIDTIPOCATALOGO() {
		return this.IDTIPOCATALOGO;
	}

	public void setEs_conversion_glp(Float es_conversion_glp) {
		this.es_conversion_glp = es_conversion_glp;
	}

	public Float getEs_conversion_glp() {
		return this.es_conversion_glp;
	}

	public void setNO_DECLARA_LE(Float NO_DECLARA_LE) {
		this.NO_DECLARA_LE = NO_DECLARA_LE;
	}

	public Float getNO_DECLARA_LE() {
		return this.NO_DECLARA_LE;
	}

	public void setPARA_DECLARACION(Float PARA_DECLARACION) {
		this.PARA_DECLARACION = PARA_DECLARACION;
	}

	public Float getPARA_DECLARACION() {
		return this.PARA_DECLARACION;
	}

	public void setCalibremm(String Calibremm) {
		this.Calibremm = Calibremm;
	}

	public String getCalibremm() {
		return this.Calibremm;
	}

	public void setIdpresentacion(String Idpresentacion) {
		this.Idpresentacion = Idpresentacion;
	}

	public String getIdpresentacion() {
		return this.Idpresentacion;
	}

	public void setLargo(String Largo) {
		this.Largo = Largo;
	}

	public String getLargo() {
		return this.Largo;
	}

	public void setPORCENT_PESO_PERMITIDO(Integer PORCENT_PESO_PERMITIDO) {
		this.PORCENT_PESO_PERMITIDO = PORCENT_PESO_PERMITIDO;
	}

	public Integer getPORCENT_PESO_PERMITIDO() {
		return this.PORCENT_PESO_PERMITIDO;
	}

	public void setUndxphl(Integer Undxphl) {
		this.Undxphl = Undxphl;
	}

	public Integer getUndxphl() {
		return this.Undxphl;
	}

	public void setES_GENERICO(Float ES_GENERICO) {
		this.ES_GENERICO = ES_GENERICO;
	}

	public Float getES_GENERICO() {
		return this.ES_GENERICO;
	}

	public void setCOD_EQUIVALENTE(String COD_EQUIVALENTE) {
		this.COD_EQUIVALENTE = COD_EQUIVALENTE;
	}

	public String getCOD_EQUIVALENTE() {
		return this.COD_EQUIVALENTE;
	}

	public void setFACTORCE(Float FACTORCE) {
		this.FACTORCE = FACTORCE;
	}

	public Float getFACTORCE() {
		return this.FACTORCE;
	}

	public void setCOD_GTIN(String COD_GTIN) {
		this.COD_GTIN = COD_GTIN;
	}

	public String getCOD_GTIN() {
		return this.COD_GTIN;
	}

	public void setIDCCOSTO_PT(String IDCCOSTO_PT) {
		this.IDCCOSTO_PT = IDCCOSTO_PT;
	}

	public String getIDCCOSTO_PT() {
		return this.IDCCOSTO_PT;
	}

	public void setIDGRUPO2(String IDGRUPO2) {
		this.IDGRUPO2 = IDGRUPO2;
	}

	public String getIDGRUPO2() {
		return this.IDGRUPO2;
	}

	public void setEs_accesorio(Float es_accesorio) {
		this.es_accesorio = es_accesorio;
	}

	public Float getEs_accesorio() {
		return this.es_accesorio;
	}

	public void setValoriza_resultado(Integer valoriza_resultado) {
		this.valoriza_resultado = valoriza_resultado;
	}

	public Integer getValoriza_resultado() {
		return this.valoriza_resultado;
	}

	public void setIDCATALOGO_UNICO(String IDCATALOGO_UNICO) {
		this.IDCATALOGO_UNICO = IDCATALOGO_UNICO;
	}

	public String getIDCATALOGO_UNICO() {
		return this.IDCATALOGO_UNICO;
	}

	public void setIdproducto_spring(String idproducto_spring) {
		this.idproducto_spring = idproducto_spring;
	}

	public String getIdproducto_spring() {
		return this.idproducto_spring;
	}

	public void setES_PRODUCCION_CC(Float ES_PRODUCCION_CC) {
		this.ES_PRODUCCION_CC = ES_PRODUCCION_CC;
	}

	public Float getES_PRODUCCION_CC() {
		return this.ES_PRODUCCION_CC;
	}

	public void setIDCONSUMIDOR(String IDCONSUMIDOR) {
		this.IDCONSUMIDOR = IDCONSUMIDOR;
	}

	public String getIDCONSUMIDOR() {
		return this.IDCONSUMIDOR;
	}

	public void setEs_hojafresca(Float es_hojafresca) {
		this.es_hojafresca = es_hojafresca;
	}

	public Float getEs_hojafresca() {
		return this.es_hojafresca;
	}

	public void setEs_plantafresca(Float es_plantafresca) {
		this.es_plantafresca = es_plantafresca;
	}

	public Float getEs_plantafresca() {
		return this.es_plantafresca;
	}

	public void setPartnumber(String partnumber) {
		this.partnumber = partnumber;
	}

	public String getPartnumber() {
		return this.partnumber;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDPRODUCTO + ", " + ARANCELES + ", " + EN_MAQUINA + ", " + ES_DESCARTE + ", "
				+ ES_TERMINADO + ", " + IDTERMINADO + ", " + IDSUBGRUPO + ", " + IDGRUPO + ", " + IDALGORITMO + ", "
				+ PARA_EXPORTACION + ", " + PARA_VENTA + ", " + PARA_CONSERVA + ", " + PIDE_LOTE + ", " + PIDE_SERIE
				+ ", " + ES_AFECTO + ", " + TIEMPOREPOSICION + ", " + CARACTERISTICAS + ", " + ES_COMPUESTO + ", "
				+ DESCRIPCION + ", " + DESCRIPCION1 + ", " + ES_EXONERADO + ", " + FOTO + ", " + IDMEDIDA + ", " + PESO
				+ ", " + REGIMEN_AGRARIO + ", " + VOLUMEN + ", " + LONGITUD + ", " + TIPO_PUNTA + ", " + DIAMETRO + ", "
				+ ES_APROVECHABLE + ", " + NOMBRE_COMERCIAL + ", " + IDMARCA + ", " + IDPARTIDA + ", " + IDCOLOR + ", "
				+ IDINSUMO + ", " + PIDE_ESTADO + ", " + IDPRODUCTO2 + ", " + ESTADO + ", " + SINCRONIZA + ", "
				+ FECHACREACION + ", " + REVISADO + ", " + IDMODELO + ", " + GENERA_SERIE + ", " + ES_SERVICIO + ", "
				+ HORAS_STD + ", " + IDDESCUENTO + ", " + FACTORREPOSICION + ", " + IDUBICACION + ", " + ES_NEUMATICO
				+ ", " + PROF_COCADA + ", " + PRES_MONTAJE + ", " + IDTIPOPRODUCTO + ", " + ES_TERCERO + ", " + ES_KIT
				+ ", " + ES_MERMA + ", " + ES_ENSAMBLADO + ", " + CODIGOSAP + ", " + es_ganado + ", " + ES_PProceso
				+ ", " + ES_MATPRIMA + ", " + ES_Congelado + ", " + Es_Fresco + ", " + IDTALLA + ", " + UGG + ", "
				+ IDCCOSTO_GANADO + ", " + IDCLASECCOSTO + ", " + ES_ACTIVO + ", " + IDTIPOACTIVO + ", "
				+ IDCCOSTO_ACTIVO + ", " + IDCTA_ACTIVO + ", " + IDCTA_DEPREC + ", " + ES_DETRACCION + ", "
				+ IDTIPODETRA + ", " + ES_DRAWBACK + ", " + IDNOMENCLATURA + ", " + PARA_FRESCO + ", " + IDCULTIVO
				+ ", " + IDVARIEDAD + ", " + ES_INDDRAWBACK + ", " + PESONETO + ", " + TIPO_ISC + ", " + VALOR_ISC
				+ ", " + EQUIV_ISC + ", " + KG_CAJAS + ", " + PIDE_LOTE_CCOSTO + ", " + IDMEDIDA2 + ", " + EXIGE_U2
				+ ", " + FACTOR_U2 + ", " + PORCEN_MERMA + ", " + AFECTO_PERCEPCION + ", " + IDCONDICION + ", " + UAC
				+ ", " + UM2_FORMULA + ", " + TIPO_PROCESO + ", " + idtiporet + ", " + afecto_retencion + ", "
				+ TIPOPRODUCTO + ", " + TIPO_PROCESO_ORIGEN + ", " + IDPRODUCTO_EQUIV + ", " + cestandar_mof + ", "
				+ cestandar_mex + ", " + factorcosto + ", " + es_vehiculo + ", " + retiqueta + ", " + rtecnica + ", "
				+ rseguridad + ", " + rcalidad + ", " + etiqueta + ", " + tecnica + ", " + seguridad + ", " + calidad
				+ ", " + prohibido + ", " + descripcion2 + ", " + PESO_TARA + ", " + es_herramienta + ", " + regla_ot
				+ ", " + IMPORTADO_EXTERNO + ", " + IDTIPOCATALOGO + ", " + es_conversion_glp + ", " + NO_DECLARA_LE
				+ ", " + PARA_DECLARACION + ", " + Calibremm + ", " + Idpresentacion + ", " + Largo + ", "
				+ PORCENT_PESO_PERMITIDO + ", " + Undxphl + ", " + ES_GENERICO + ", " + COD_EQUIVALENTE + ", "
				+ FACTORCE + ", " + COD_GTIN + ", " + IDCCOSTO_PT + ", " + IDGRUPO2 + ", " + es_accesorio + ", "
				+ valoriza_resultado + ", " + IDCATALOGO_UNICO + ", " + idproducto_spring + ", " + ES_PRODUCCION_CC
				+ ", " + IDCONSUMIDOR + ", " + es_hojafresca + ", " + es_plantafresca + ", " + partnumber + "]";
	}



	/* Sets & Gets FK*/

}