package com.nisira.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nisira.core.BaseDao;
import com.nisira.core.Consulta;
import com.nisira.core.EntityTuple;
import com.nisira.core.NisiraORMException;
import com.nisira.entidad.ENVIONOTIFICACION;
import com.nisira.entidad.NOTIFICACION;
import com.nisira.entidad.NotitficaSP;
import com.nisira.utilitarios.UtilDatetimeConverter;
import com.sun.nio.sctp.Notification;

public class NOTIFICACIONDao extends BaseDao<NOTIFICACION>{

	public NOTIFICACIONDao(){
		super(NOTIFICACION.class);
		// TODO Auto-generated constructor stub
	}
	public NOTIFICACIONDao(boolean t) throws NisiraORMException {
		super(1,NOTIFICACION.class,t);
		// TODO Auto-generated constructor stub
	}
	public List<NOTIFICACION> verNotifO(int con,Object e, Object n){
		List<NOTIFICACION> lno = new ArrayList<NOTIFICACION>();
        try {
            String sql = "SP_Notificacion_Ver";
            Connection cn = obtenerConexion(con);
            CallableStatement cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1, e);
            cl.setObject(2, n);
            ResultSet rs = null;
            rs = cl.executeQuery();
            while (rs.next()) {
            	NOTIFICACION no = new NOTIFICACION();
                no.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                no.setIDNOTIFICACION(rs.getInt("IDNOTIFICACION"));
                no.setMENSAJE(rs.getString("MENSAJE"));
                UtilDatetimeConverter dateConverter = new UtilDatetimeConverter();
                no.setFECHACREACION((Date)dateConverter.fromString(rs.getString("FECHACREACION")));
                no.setTOQUEN(rs.getString("TOQUEN"));
                no.setPRIORIDAD(rs.getInt("PRIORIDAD"));
                no.setESTADO(rs.getBoolean("ESTADO") ? 1 : 0);
                lno.add(no);
            }
            
        } catch(Exception e1){
        	
        }
        return lno;
    }
	public List<NotitficaSP> verNotif(int con,Object e, Object n){
		List<NotitficaSP> lno = new ArrayList<NotitficaSP>();
        try {
            String sql = "SP_Notificacion_Ver";
            Connection cn = obtenerConexion(con);
            CallableStatement cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1, e);
            cl.setObject(2, n);
            ResultSet rs = null;
            rs = cl.executeQuery();
            while (rs.next()) {
            	NotitficaSP no = new NotitficaSP();
                no.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                no.setIDNOTIFICACION(rs.getInt("IDNOTIFICACION"));
                no.setMENSAJE(rs.getString("MENSAJE"));
                no.setFECHACREACION(rs.getTimestamp("FECHACREACION"));
                no.setFECHAENVIO(rs.getTimestamp("FECHAENVIO"));
                no.setPRIORIDAD(rs.getInt("PRIORIDAD"));
                no.setESTADO(rs.getBoolean("ESTADO") ? 1 : 0);
                no.setIDPROGRAMAALM(rs.getInt("IDPROGRAMAALM"));
                lno.add(no);
            }
            
        } catch(Exception e1){
        	
        }
        return lno;
    }
	public void actualizarEstado (int con,int IdEmpresa,int IDPROGRAMAALM,int IDMONTACARGA,int IDNOTIFICACION) throws SQLException {
		String sql = "update DPROGRAMAALMMONTACARGANOTIFICACION set FECHALECTURA=GETDATE() where IDEMPRESA = ? and IDPROGRAMAALM = ? and IDMONTACARGA = ? and IDNOTIFICACION = ?";

		Connection cn = obtenerConexion(con);

		PreparedStatement ps = cn.prepareStatement(sql);

		ps.setInt(1, IdEmpresa);
		ps.setInt(2, IDPROGRAMAALM);
		ps.setInt(3, IDMONTACARGA);
		ps.setInt(4, IDNOTIFICACION);
		ps.execute();
		cn.close();
	}
	public List<NOTIFICACION> verNotificacionxMontacarga(int idempresa,int idmontacarga) throws SQLException, NisiraORMException{
		Consulta c = getInstancia(1);
		c.join("inner",ENVIONOTIFICACION.class, "t1", "t0.idempresa=t1.idempresa and t0.idnotificacion=t1.idnotificacion");
		c.where("t0.idempresa = ? and t1.idmontacarga =  ?", idempresa,idmontacarga);
		List<NOTIFICACION> listNotificacion = (List<NOTIFICACION>) EntityTuple.getListForAlias(c.execSelect(), "t0");
		return listNotificacion;
	}
}
