package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "DOCUMENTO")
public class DOCUMENTO {
	@ClavePrimaria
	@Columna
	private Integer IDEMPRESA;
	@ClavePrimaria
	@Columna
	private String IDDOCUMENTO;
	@Columna
	private String DESCRIPCION;
	@Columna
	private Date FECHACREACION;
	@Columna
	private Integer ESTADO;
	@Columna
	private String VENTANA;
	@Columna
	private Integer IDPROCESO;



	/* Sets & Gets */
	public void setIDEMPRESA(Integer IDEMPRESA) {
		this.IDEMPRESA = IDEMPRESA;
	}

	public Integer getIDEMPRESA() {
		return this.IDEMPRESA;
	}

	public void setIDDOCUMENTO(String IDDOCUMENTO) {
		this.IDDOCUMENTO = IDDOCUMENTO;
	}

	public String getIDDOCUMENTO() {
		return this.IDDOCUMENTO;
	}

	public void setDESCRIPCION(String DESCRIPCION) {
		this.DESCRIPCION = DESCRIPCION;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
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

	public void setVENTANA(String VENTANA) {
		this.VENTANA = VENTANA;
	}

	public String getVENTANA() {
		return this.VENTANA;
	}

	public void setIDPROCESO(Integer IDPROCESO) {
		this.IDPROCESO = IDPROCESO;
	}

	public Integer getIDPROCESO() {
		return this.IDPROCESO;
	}

	@Override
	public String toString() {
		return "[" + IDEMPRESA + ", " + IDDOCUMENTO + ", " + DESCRIPCION + ", " + FECHACREACION + ", " + (ESTADO==null?"Null":ESTADO) + ", "
				+ VENTANA + ", " + (IDPROCESO==null?"Null":IDPROCESO) + "]";
	}
	


	/* Sets & Gets FK*/

}