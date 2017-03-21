package test;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nisira.core.NisiraORMException;
import com.nisira.dao.DGENERACIONCODIGOSDao;
import com.nisira.entidad.BarcodeXML;
import com.nisira.entidad.DGENERACIONCODIGOS;
import com.nisira.entidad.GENERACIONCODIGOS;
import com.nisira.entidad.BarcodeXML.Digitos;
import com.nisira.utils.nisiracore.Constantes;

import core.inicio.ConfigInicial;

public class GeneracionCodigoXml {
	public static void reconstruccionXML(List<GENERACIONCODIGOS> listGeneracionCodigos) throws SQLException, NisiraORMException{
		BarcodeXML barcode;
		List<BarcodeXML> listBarcode=new ArrayList<BarcodeXML>();
		List<DGENERACIONCODIGOS> listDGeneracionCodigos=new ArrayList<DGENERACIONCODIGOS>();
//		barcode.setCantidad(listGeneracionCodigos.get(0).getNUMDIGITOTOTAL());
		for(GENERACIONCODIGOS gc :listGeneracionCodigos){
			barcode=new BarcodeXML();
			barcode.setInicio(ConfigInicial.LlenarConfig()[11]);
			barcode.setFin(ConfigInicial.LlenarConfig()[12]);
			barcode.setTotal(gc.getNUMDIGITOTOTAL());
			barcode.setDig(new ArrayList<Digitos>());
			listDGeneracionCodigos=(new DGENERACIONCODIGOSDao()).listar(1,"IDEMPRESA = ? AND IDGENERACION = ?",ConfigInicial.LlenarConfig()[8],gc.getIDGENERACION());
			for(DGENERACIONCODIGOS dgc: listDGeneracionCodigos){
				barcode.agregarDigito(dgc.getPARAMETRO(),dgc.getNUMDIGITO());
				listBarcode.add(barcode);
			}
		}
		try {
			Constantes.crearXML("com.nisira.entidad.BarcodeXML", listBarcode,"c:\\SOLUTION\\WEB\\solution.xml");
		} catch (FileNotFoundException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			Constantes.log.warn(e.getMessage());
			e.printStackTrace();
		}
	}
}
