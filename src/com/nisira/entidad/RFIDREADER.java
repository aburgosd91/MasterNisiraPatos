package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.CampoRelacionado;

@Tabla(nombre = "RFIDREADER")
public class RFIDREADER {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private Integer IDEQUIPOREADER;
	@Columna
	private Integer IDCPUMOVIL;
	@Columna
	private String NROSERIE;
	@Columna
	private String OBSERVACION;
	@Columna
	private Integer ESTADO;
	@Columna
	private Date FECHACREACION;

	@CampoRelacionado({@RelacionTabla(campo="IDEMPRESA",campoRelacionado="IDEMPRESA"), @RelacionTabla(campo="IDCPUMOVIL",campoRelacionado="IDCPUMOVIL")})
	private CPUMOVIL cpumovil_fk__rfidreader__239f1926;


	/* Sets & Gets */
	public void setIDEMPRESA(Integer idempresa) {
		this.IDEMPRESA = idempresa;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDEQUIPOREADER(Integer idequiporeader) {
		this.IDEQUIPOREADER = idequiporeader;
	}

	public Integer getIDEQUIPOREADER() {
		return this.IDEQUIPOREADER;
	}

	public void setIDCPUMOVIL(Integer idcpumovil) {
		this.IDCPUMOVIL = idcpumovil;
	}

	public Integer getIDCPUMOVIL() {
		return this.IDCPUMOVIL;
	}

	public void setNROSERIE(String nroserie) {
		this.NROSERIE = nroserie;
	}

	public String getNROSERIE() {
		return this.NROSERIE;
	}

	public void setOBSERVACION(String observacion) {
		this.OBSERVACION = observacion;
	}

	public String getOBSERVACION() {
		return this.OBSERVACION;
	}

	public void setESTADO(Integer estado) {
		this.ESTADO = estado;
	}

	public Integer getESTADO() {
		return this.ESTADO;
	}

	public void setFECHACREACION(Date fechacreacion) {
		this.FECHACREACION = fechacreacion;
	}

	public Date getFECHACREACION() {
		return this.FECHACREACION;
	}



	/* Sets & Gets FK*/
	public void setCpumovil_fk__rfidreader__239f1926(CPUMOVIL cpumovil_fk__rfidreader__239f1926) {
		this.cpumovil_fk__rfidreader__239f1926 = cpumovil_fk__rfidreader__239f1926;
	}

	public CPUMOVIL getCpumovil_fk__rfidreader__239f1926() {
		return this.cpumovil_fk__rfidreader__239f1926;
	}


}