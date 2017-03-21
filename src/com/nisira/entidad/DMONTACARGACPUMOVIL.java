package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.CampoRelacionado;

@Tabla(nombre = "DMONTACARGACPUMOVIL")
public class DMONTACARGACPUMOVIL {
	@ClavePrimaria
	@Columna
	private Integer idempresa;
	@ClavePrimaria
	@Columna
	private Integer idmontacarga;
	@ClavePrimaria
	@Columna
	private Integer idcpumovil;
	@Columna
	private Date fechacreacion;
	@Columna
	private Integer estado;
	@Columna
	private String codigoequivalente;

	@CampoRelacionado({@RelacionTabla(campo="IDEMPRESA",campoRelacionado="IDEMPRESA"), @RelacionTabla(campo="IDCPUMOVIL",campoRelacionado="IDCPUMOVIL")})
	private CPUMOVIL cpumovil_fk__dmontacargacpumo__1de63fd0;
	@CampoRelacionado({@RelacionTabla(campo="IDEMPRESA",campoRelacionado="IDEMPRESA"), @RelacionTabla(campo="IDMONTACARGA",campoRelacionado="IDMONTACARGA")})
	private MONTACARGA montacarga_fk__dmontacargacpumo__1eda6409;


	/* Sets & Gets */
	public void setIdempresa(Integer idempresa) {
		this.idempresa = idempresa;
	}

	public Integer getIdempresa() {
		return this.idempresa;
	}

	public void setIdmontacarga(Integer idmontacarga) {
		this.idmontacarga = idmontacarga;
	}

	public Integer getIdmontacarga() {
		return this.idmontacarga;
	}

	public void setIdcpumovil(Integer idcpumovil) {
		this.idcpumovil = idcpumovil;
	}

	public Integer getIdcpumovil() {
		return this.idcpumovil;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setCodigoequivalente(String codigoequivalente) {
		this.codigoequivalente = codigoequivalente;
	}

	public String getCodigoequivalente() {
		return this.codigoequivalente;
	}



	/* Sets & Gets FK*/
	public void setCpumovil_fk__dmontacargacpumo__1de63fd0(CPUMOVIL cpumovil_fk__dmontacargacpumo__1de63fd0) {
		this.cpumovil_fk__dmontacargacpumo__1de63fd0 = cpumovil_fk__dmontacargacpumo__1de63fd0;
	}

	public CPUMOVIL getCpumovil_fk__dmontacargacpumo__1de63fd0() {
		return this.cpumovil_fk__dmontacargacpumo__1de63fd0;
	}

	public void setMontacarga_fk__dmontacargacpumo__1eda6409(MONTACARGA montacarga_fk__dmontacargacpumo__1eda6409) {
		this.montacarga_fk__dmontacargacpumo__1eda6409 = montacarga_fk__dmontacargacpumo__1eda6409;
	}

	public MONTACARGA getMontacarga_fk__dmontacargacpumo__1eda6409() {
		return this.montacarga_fk__dmontacargacpumo__1eda6409;
	}


}