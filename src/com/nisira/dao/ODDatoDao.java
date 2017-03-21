package com.nisira.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nisira.core.BaseDao;
import com.nisira.core.EConexion;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.OrigenDato;
import com.nisira.utilitarios.RespuestaNCDR;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ODDatoDao extends BaseDao<Object> {
	public ODDatoDao() {
		super(Object.class);
	}

	public List<Object[]> getPendientes(OrigenDato od, String desde, String hasta) throws SQLException, NisiraORMException {
		List<Object[]> lista = new ArrayList<Object[]>();

		switch (od.getTipo()) {
		case "1":
			EConexion ecnn = new EConexion();
			ecnn.TIPO = com.nisira.utils.nisiracore.Constantes.MSSQL;
			ecnn.SERVIDOR = od.getServidor();
			ecnn.INSTANCIA = od.getInstancia();
			ecnn.USUARIO = od.getUsuario();
			ecnn.CLAVE = com.nisira.security.Encryption.pss_decrypt(od.getClave());
			ecnn.BASE_DATOS = od.getBaseDatos();

			ResultSet rs = execProcedure(ecnn, "Nsp_Return_Doc_Firmar", od.getIdEmpresaExt(), desde, hasta);

			while (rs.next()) {
				Object[] reg = new Object[9];
				reg[0] = od;
				for (int i = 0; i < 8; i++) {

					switch (rs.getMetaData().getColumnType(i + 1)) {
					case java.sql.Types.CHAR:
					case java.sql.Types.VARCHAR:
					case java.sql.Types.CLOB:
						reg[i + 1] = rs.getString(i + 1);
						break;

					default:
						reg[i + 1] = rs.getObject(i + 1);
						break;
					}

				}
				lista.add(reg);
			}
			return lista;

		default:
			return lista;
		}
	}

	public void actualizaEstadoSunat(OrigenDato od, String documento_idorigen, List<RespuestaNCDR> respuesta)
			throws SQLException {
		String xml;

		XStream xstream = new XStream(new DomDriver());

		xstream.alias("respuesta", RespuestaNCDR.class);

		xml = "<?xml version = \"1.0\" encoding=\"Windows-1252\" standalone=\"yes\"?>".concat(xstream.toXML(respuesta));

		switch (od.getTipo()) {
		case "1":
			EConexion ecnn = new EConexion();
			ecnn.TIPO = com.nisira.utils.nisiracore.Constantes.MSSQL;
			ecnn.SERVIDOR = od.getServidor();
			ecnn.INSTANCIA = od.getInstancia();
			ecnn.USUARIO = od.getUsuario();
			ecnn.CLAVE = com.nisira.security.Encryption.pss_decrypt(od.getClave());
			ecnn.BASE_DATOS = od.getBaseDatos();

			execUpdateProcedure(ecnn, "Nsp_actualizaEstadoSunat", od.getIdEmpresaExt(), documento_idorigen, xml);

			break;

		default:
			break;
		}
	}

	public List<Object[]> actualizaEstadoSunat(OrigenDato od, String documento_idorigen, String codigo,
			String descripcion) throws SQLException, NisiraORMException {
		List<Object[]> lista = new ArrayList<Object[]>();

		switch (od.getTipo()) {
		case "1":
			EConexion ecnn = new EConexion();
			ecnn.TIPO = com.nisira.utils.nisiracore.Constantes.MSSQL;
			ecnn.SERVIDOR = od.getServidor();
			ecnn.INSTANCIA = od.getInstancia();
			ecnn.USUARIO = od.getUsuario();
			ecnn.CLAVE = com.nisira.security.Encryption.pss_decrypt(od.getClave());
			ecnn.BASE_DATOS = od.getBaseDatos();

			ResultSet rs = execProcedure(ecnn, "Nsp_actualizaEstadoSunat", od.getIdEmpresaExt(), documento_idorigen,
					codigo, descripcion);

			ResultSetMetaData rm = rs.getMetaData();
			int numCols = rm.getColumnCount();

			while (rs.next()) {
				Object[] reg = new Object[numCols];

				for (int i = 0; i < numCols; i++) {

					switch (rs.getMetaData().getColumnType(i + 1)) {
					case java.sql.Types.CHAR:
					case java.sql.Types.VARCHAR:
					case java.sql.Types.CLOB:
						reg[i] = rs.getString(i + 1);
						break;

					default:
						reg[i] = rs.getObject(i + 1);
						break;
					}

				}
				lista.add(reg);
			}
			return lista;

		default:
			return lista;
		}
	}

	
	public List<Object[]> getBoletas (OrigenDato od, String fecha) throws SQLException, NisiraORMException {
		List<Object[]> lista = new ArrayList<Object[]>();
		
		switch (od.getTipo()) {
		case "1":
			EConexion ecnn = new EConexion();
			ecnn.TIPO = com.nisira.utils.nisiracore.Constantes.MSSQL;
			ecnn.SERVIDOR = od.getServidor();
			ecnn.INSTANCIA = od.getInstancia();
			ecnn.USUARIO = od.getUsuario();
			ecnn.CLAVE = com.nisira.security.Encryption.pss_decrypt(od.getClave());
			ecnn.BASE_DATOS = od.getBaseDatos();
			
			ResultSet rs = execProcedure(ecnn, "NSP_RETURN_BOLETAS_EDOC", od.getIdEmpresaExt(), fecha);
			
			while (rs.next()) {
				Object[] reg = new Object[12];
				reg[0] = od;
				
				for (int i = 0; i < 11; i++) {

					switch (rs.getMetaData().getColumnType(i + 1)) {
					case java.sql.Types.CHAR:
					case java.sql.Types.VARCHAR:
					case java.sql.Types.CLOB:
						reg[i + 1] = rs.getString(i + 1);
						break;

					default:
						reg[i + 1] = rs.getObject(i + 1);
						break;
					}

				}
				
				lista.add(reg);
			}
			break;
		default:
			break;
		}
		
		return lista;
	}
	
	public List<Object[]> getBajasTodos (OrigenDato od, String fecha) throws SQLException, NisiraORMException {
		List<Object[]> lista = new ArrayList<Object[]>();
		
		switch (od.getTipo()) {
		case "1":
			EConexion ecnn = new EConexion();
			ecnn.TIPO = com.nisira.utils.nisiracore.Constantes.MSSQL ;
			ecnn.SERVIDOR = od.getServidor();
			ecnn.INSTANCIA = od.getInstancia();
			ecnn.USUARIO = od.getUsuario();
			ecnn.CLAVE = com.nisira.security.Encryption.pss_decrypt(od.getClave());
			ecnn.BASE_DATOS = od.getBaseDatos();
			
			ResultSet rs = execProcedure(ecnn, "NSP_RETURN_BAJAS_EDOC", od.getIdEmpresaExt(), fecha);
			
			while (rs.next()) {
				Object[] reg = new Object[12];
				reg[0] = od;
				
				for (int i = 0; i < 11; i++) {

					switch (rs.getMetaData().getColumnType(i + 1)) {
					case java.sql.Types.CHAR:
					case java.sql.Types.VARCHAR:
					case java.sql.Types.CLOB:
						reg[i + 1] = rs.getString(i + 1);
						break;

					default:
						reg[i + 1] = rs.getObject(i + 1);
						break;
					}

				}
				
				lista.add(reg);
			}
			break;
		default:
			break;
		}
		
		return lista;
	}
	
	
}
