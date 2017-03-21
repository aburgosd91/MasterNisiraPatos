package com.nisira.vista.movil.map;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nisira.core.NisiraORMException;
import com.nisira.dao.DZONAGENERALDao;
import com.nisira.dao.ZONAGENERALDao;
import com.nisira.entidad.CoordenadaMatriz;
import com.nisira.entidad.DZONAGENERAL;
import com.nisira.entidad.ZONAGENERAL;
import com.nisira.floy.Floyd;

public class MatrizRutas {
	public static int tfil;
	public static int tcol;
	/********************************************************/
	/*DATOS PARA REVISION*/
	public static List<CoordenadaMatriz> matriz;
	public static int matrizRecorrido[][];
	public static List<CoordenadaMatriz> caminoRecorrido;
	public static float[][] D;
	public static int[][] S;
	public static List<int[]> nodos;
	public static Floyd f;
	public static List<int[]> listObstaculos;
	public MatrizRutas(){
		matriz =new ArrayList<CoordenadaMatriz>();
    	caminoRecorrido =new ArrayList<CoordenadaMatriz>();
    	f= new Floyd();
	}
	/*METODOS*/
	public static void cargarMatriz(ZONAGENERAL zonaGeneral,List<DZONAGENERAL> listDzonaGeneralCalles){
		int item=0;
		try{
			matrizRecorrido= new int[zonaGeneral.getLARGO()][zonaGeneral.getANCHO()];
			/*******************************LLENAR CON CEROS LA MATRIZ********************************/
			//zonaGeneral.getANCHO() -> fila
			//zonaGeneral.getLARGO() -> columna
			for(int i=0;i<zonaGeneral.getLARGO();i++){
				for(int j=0;j<zonaGeneral.getANCHO();j++){
					matrizRecorrido[i][j]=0;
				}
			}
			/******************************************LLENAR CALLES***********************************************/
			for(DZONAGENERAL obj:listDzonaGeneralCalles){
				matrizRecorrido[obj.getCORDENADAX()][obj.getCORDENADAY()]=1;
			}
			for(int i=0;i<matrizRecorrido.length;i++){
				for(int j=0; j<matrizRecorrido[0].length;j++){
					System.out.print(matrizRecorrido[i][j]+" ");
				}
				System.out.println("");
			}
			/******************************************ALGORITMO***********************************************/
			int x,y;
			x = matrizRecorrido.length;/*58*/
			y = matrizRecorrido[0].length;/*167*/
			/*****************************************************************************************************/
			nodos = new ArrayList<int[]>();
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if (matrizRecorrido[i][j] == 1) {
						nodos.add(new int[] { nodos.size(), i, j });
					}
				}
			}
			for (int[] n : nodos) {
				System.out.println(n[0] + " " + n[1] + " " + n[2]);
			}
			x = nodos.size();
			D = new float[x][x];
			S = new int[x][x];
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < x; j++) {
					if (i == j) {
						D[i][j] = -2;
						S[i][j] = -2;
					} else {
						D[i][j] = -1;
						S[i][j] = j;
					}
				}
			}
			for (int i = 0; i < nodos.size(); i++) {
				int[] o = nodos.get(i);
				for (int j = 0; j < nodos.size(); j++) {
					int[] d = nodos.get(j);
					
					int dx = Math.abs(o[1] - d[1]);
					int dy = Math.abs(o[2] - d[2]);
					//if (dx == 1 && dy == 1) {
					//	D[i][j] = 1;
					//}
					if (dx == 1 && dy == 0) {
						D[i][j] = 1;
					}
					if (dx == 0 && dy == 1) {
						D[i][j] = 1;
					}
				}
			}
			f = new Floyd(D,S,x);
			f.rutaFloyd();
		}catch(Exception ex){
			System.out.println("Item "+item);
			System.out.println("Exepcion <MatrizRutas> "+ex.getMessage()+"\n"+ex.getLocalizedMessage());
		}
	}
	public static void cargarMatriz_sinfloyd(ZONAGENERAL zonaGeneral,List<DZONAGENERAL> listDzonaGeneralCalles){
		int item=0;
		nodos = new ArrayList<>();
		try{
			matrizRecorrido= new int[zonaGeneral.getLARGO()][zonaGeneral.getANCHO()];
			System.out.println("ANCHO: "+zonaGeneral.getANCHO()+" LARGO: " + zonaGeneral.getLARGO());
			/*******************************LLENAR CON CEROS LA MATRIZ********************************/
			//zonaGeneral.getANCHO() -> fila
			//zonaGeneral.getLARGO() -> columna
			for(int i=0;i<zonaGeneral.getLARGO();i++){
				for(int j=0;j<zonaGeneral.getANCHO();j++){
					matrizRecorrido[i][j]=0;
				}
			}
			/******************************************LLENAR CALLES***********************************************/
			for(DZONAGENERAL obj:listDzonaGeneralCalles){
				matrizRecorrido[obj.getCORDENADAX()][obj.getCORDENADAY()]=1;
			}
//			for(int i=0;i<matrizRecorrido.length;i++){
//				for(int j=0; j<matrizRecorrido[0].length;j++){
//					System.out.print(matrizRecorrido[i][j]+" ");
//				}
//				System.out.println("");
//			}
			/******************************************ALGORITMO***********************************************/
			int x,y;
			x = matrizRecorrido.length;/*58*/
			y = matrizRecorrido[0].length;/*167*/
			/*****************************************************************************************************/

			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if (matrizRecorrido[i][j] == 1) {
						nodos.add(new int[] { nodos.size(), i, j });
					}
				}
			}
			for (int[] n : nodos) {
				System.out.println(n[0] + " " + n[1] + " " + n[2]);
			}
			x = nodos.size();
			D = new float[x][x];
			S = new int[x][x];
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < x; j++) {
					if (i == j) {
						D[i][j] = -2;
						S[i][j] = -2;
					} else {
						D[i][j] = -1;
						S[i][j] = j;
					}
				}
			}
			for (int i = 0; i < nodos.size(); i++) {
				int[] o = nodos.get(i);
				for (int j = 0; j < nodos.size(); j++) {
					int[] d = nodos.get(j);
					
					int dx = Math.abs(o[1] - d[1]);
					int dy = Math.abs(o[2] - d[2]);
					//if (dx == 1 && dy == 1) {
					//	D[i][j] = 1;
					//}
					if (dx == 1 && dy == 0) {
						D[i][j] = 1;
					}
					if (dx == 0 && dy == 1) {
						D[i][j] = 1;
					}
				}
			}
			f = new Floyd(D,S,x);
			//f.rutaFloyd();
		}catch(Exception ex){
			System.out.println("Item "+item);
			ex.printStackTrace();
			System.out.println("Exepcion <MatrizRutas> "+ex.getMessage()+"\n"+ex.getLocalizedMessage());
		}
	}
	
	public CoordenadaMatriz buscarCoordenadaMatriz(int x,int y){
		CoordenadaMatriz response=null;
		for(CoordenadaMatriz m:matriz){
			if(m.getX()==x & m.getY()==y){
				response=m;
				break;
			}
		}
		return response;
	}
	
	public static int[] posicionMatrizRecorridoCoordenada(int pos){
		int coordenada[]=new int[2];
		for (int[] n : nodos) {
			if(n[0]==pos){
				System.out.println(n[0] + " " + n[1] + " " + n[2]);
				coordenada[0]=n[1];
				coordenada[1]=n[2];
				break;
			}
		}
		return coordenada;
	}
	public static int posicionMatrizRecorrido(int x,int y){
		int pos=0;
		for (int[] n : nodos) {
			if(n[1]==x & n[2]==y){
				System.out.println(n[0] + " " + n[1] + " " + n[2]);
				pos=n[0];
				break;
			}
		}
		return pos;
	}
	public static void mostrarMatrizCoordenada(){
		for(int i=0;i<matriz.size();i++){
			System.out.println("Matriz["+i+"]: ("+matriz.get(i).getX()+","+matriz.get(i).getY()+")");
		}
	}
	public static void configuracionRutas(ZONAGENERAL zonaGeneral,List<DZONAGENERAL> listDzonaGeneralCalles){
		matrizRecorrido= new int[zonaGeneral.getLARGO()][zonaGeneral.getANCHO()];
		/*******************************LLENAR CON CEROS LA MATRIZ********************************/
		for(int i=0;i<zonaGeneral.getLARGO();i++){
			for(int j=0;j<zonaGeneral.getANCHO();j++){
				matrizRecorrido[i][j]=0;
			}
		}
//		MatrizRutas.mostrarMatrizCoordenada();
		/******************************************LLENAR CALLES***********************************************/
		for(DZONAGENERAL obj:listDzonaGeneralCalles){
			matrizRecorrido[obj.getCORDENADAX()][obj.getCORDENADAY()]=1;
		}
		/******************************************ALGORITMO***********************************************/
		int x,y;
		x = matrizRecorrido.length;
		y = matrizRecorrido[0].length;
		/*****************************************************************************************************/
		nodos = new ArrayList<int[]>();
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (matrizRecorrido[i][j] == 1) {
					nodos.add(new int[] { nodos.size(), i, j });
				}
			}
		}
		for (int[] n : nodos) {
			System.out.println(n[0] + " " + n[1] + " " + n[2]);
		}
		x = nodos.size();
		D = new float[x][x];
		S = new int[x][x];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				if (i == j) {
					D[i][j] = -2;
					S[i][j] = -2;
				} else {
					D[i][j] = -1;
					S[i][j] = j;
				}
			}
		}
		for (int i = 0; i < nodos.size(); i++) {
			int[] o = nodos.get(i);
			for (int j = 0; j < nodos.size(); j++) {
				int[] d = nodos.get(j);
				
				int dx = Math.abs(o[1] - d[1]);
				int dy = Math.abs(o[2] - d[2]);
				
				//if (dx == 1 && dy == 1) {
				//	D[i][j] = 1;
				//}
				if (dx == 1 && dy == 0) {
					D[i][j] = 1;
				}
				if (dx == 0 && dy == 1) {
					D[i][j] = 1;
				}
			}
		}
		f = new Floyd(D,S,x);
		f.rutaFloyd();
//		matriz=matriz.subList(0,600);
	}
	public static void configuracionRutas_sinFloyd(ZONAGENERAL zonaGeneral,List<DZONAGENERAL> listDzonaGeneralCalles){
		matrizRecorrido= new int[zonaGeneral.getLARGO()][zonaGeneral.getANCHO()];
		/*******************************LLENAR CON CEROS LA MATRIZ********************************/
		for(int i=0;i<zonaGeneral.getLARGO();i++){
			for(int j=0;j<zonaGeneral.getANCHO();j++){
				matrizRecorrido[i][j]=0;
			}
		}
//		MatrizRutas.mostrarMatrizCoordenada();
		/******************************************LLENAR CALLES***********************************************/
		for(DZONAGENERAL obj:listDzonaGeneralCalles){
			matrizRecorrido[obj.getCORDENADAX()][obj.getCORDENADAY()]=1;
		}
		/******************************************ALGORITMO***********************************************/
		int x,y;
		x = matrizRecorrido.length;
		y = matrizRecorrido[0].length;
		/*****************************************************************************************************/
		nodos = new ArrayList<int[]>();
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (matrizRecorrido[i][j] == 1) {
					nodos.add(new int[] { nodos.size(), i, j });
				}
			}
		}
		for (int[] n : nodos) {
			System.out.println(n[0] + " " + n[1] + " " + n[2]);
		}
		x = nodos.size();
		D = new float[x][x];
		S = new int[x][x];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				if (i == j) {
					D[i][j] = -2;
					S[i][j] = -2;
				} else {
					D[i][j] = -1;
					S[i][j] = j;
				}
			}
		}
		for (int i = 0; i < nodos.size(); i++) {
			int[] o = nodos.get(i);
			for (int j = 0; j < nodos.size(); j++) {
				int[] d = nodos.get(j);
				
				int dx = Math.abs(o[1] - d[1]);
				int dy = Math.abs(o[2] - d[2]);
				
				//if (dx == 1 && dy == 1) {
				//	D[i][j] = 1;
				//}
				if (dx == 1 && dy == 0) {
					D[i][j] = 1;
				}
				if (dx == 0 && dy == 1) {
					D[i][j] = 1;
				}
			}
		}
		f = new Floyd(D,S,x);
		//f.rutaFloyd();
//		matriz=matriz.subList(0,600);
	}	
	public static void configuracionRutasObstaculo(List<int[]> trafigo,ZONAGENERAL zonaGeneral,List<DZONAGENERAL> listDzonaGeneralCalles){
		matrizRecorrido= new int[zonaGeneral.getLARGO()][zonaGeneral.getANCHO()];
		/*******************************LLENAR CON CEROS LA MATRIZ********************************/
		for(int i=0;i<zonaGeneral.getLARGO();i++){
			for(int j=0;j<zonaGeneral.getANCHO();j++){
				matrizRecorrido[i][j]=0;
			}
		}
		/******************************************LLENAR CALLES***********************************************/
		for(DZONAGENERAL obj:listDzonaGeneralCalles){
			matrizRecorrido[obj.getCORDENADAX()][obj.getCORDENADAY()]=1;
		}
		/******************************************LLENAR OBSTACULOS***********************************************/
		for(int[] obj : trafigo){//Trafico Peso 2
			matrizRecorrido[obj[0]][obj[1]]=2;
		}
		/******************************************ALGORITMO***********************************************/
		int x,y;
		x = matrizRecorrido.length;
		y = matrizRecorrido[0].length;
		/*****************************************************************************************************/
		nodos = new ArrayList<int[]>();
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (matrizRecorrido[i][j] == 1) {
					nodos.add(new int[] { nodos.size(), i, j });
				}
			}
		}
		for (int[] n : nodos) {
			System.out.println(n[0] + " " + n[1] + " " + n[2]);
		}
		x = nodos.size();
		D = new float[x][x];
		S = new int[x][x];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				if (i == j) {
					D[i][j] = -2;
					S[i][j] = -2;
				} else {
					D[i][j] = -1;
					S[i][j] = j;
				}
			}
		}
		for (int i = 0; i < nodos.size(); i++) {
			int[] o = nodos.get(i);
			for (int j = 0; j < nodos.size(); j++) {
				int[] d = nodos.get(j);
				
				int dx = Math.abs(o[1] - d[1]);
				int dy = Math.abs(o[2] - d[2]);
				
				//if (dx == 1 && dy == 1) {
				//	D[i][j] = 1;
				//}
				if (dx == 1 && dy == 0) {
					D[i][j] = 1;
				}
				if (dx == 0 && dy == 1) {
					D[i][j] = 1;
				}
			}
		}
		f = new Floyd(D,S,x);
		f.rutaFloyd();
//		matriz=matriz.subList(0,600);
	}
	/*SOBRESCRIBIR*/
	public void marcarRecorrido(){
		/*
		mostrarMatrizCoordenada();
		
		int cPartida=puntosExtremos_.get(0);
		int cLlegada=puntosExtremos_.get(1);
		this.caminoRecorrido= new ArrayList<CoordenadaMatriz>();
		List<Integer> l = this.f.MRutaList(cPartida,cLlegada);
		for (int i = 0; i< l.size(); i++) {
			for(int[] a : this.nodos) {
				if (l.get(i) == a[0]) {
					System.out.println(a[1]+ " " + a[2]);
				}
			}
		}
		List<Integer> porcion=new ArrayList<Integer>();
		System.out.println(f.MRuta(cPartida,cLlegada));
		
		boolean t=true;
		int i;
		if(l.size()>0){
			l.add(0, cPartida);
			getPanelZona().dibujarRutaMatriz(l,Color.GREEN,this.getTamanio());
			getPanelZona().repaint();
		}
		puntosExtremos_.clear();
		*/
	}
	public static void probarRuta(){
		long inicio=0;
		ZONAGENERAL zonageneral= new ZONAGENERAL();
		List<DZONAGENERAL> listDzonaGeneralCalles = new ArrayList<>();
		try {
			zonageneral = (new ZONAGENERALDao()).getPorClavePrimaria(1, 1,1, 1);
			listDzonaGeneralCalles = (new DZONAGENERALDao()).getLisDZonaGeneralCalles(1,zonageneral);
			System.out.println("-------Base :"+((System.currentTimeMillis()-inicio)));
			inicio=System.currentTimeMillis();
			//MatrizRutas.cargarMatriz(zonageneral, listDzonaGeneralCalles);
			System.out.println("-----ruta :"+((System.currentTimeMillis()-inicio)));
			/*PUNTO*/
			DZONAGENERAL dzI=listDzonaGeneralCalles.get(0);
			DZONAGENERAL dzF=listDzonaGeneralCalles.get(10);
			int pos1=MatrizRutas.posicionMatrizRecorrido(dzI.getCORDENADAX(), dzI.getCORDENADAY());
			int pos2=MatrizRutas.posicionMatrizRecorrido(dzF.getCORDENADAX(), dzF.getCORDENADAY());
			List<Integer> l = f.MRutaList(pos1,pos2);
			for (int i = 0; i< l.size(); i++) {
				for(int[] a : nodos) {
					if (l.get(i) == a[0]) {
						System.out.println(a[1]+ " " + a[2]);
					}
				}
			}
			System.out.println(f.MRuta(pos1,pos2));  	
		} catch (SQLException | NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void RutaFloyd(DZONAGENERAL inicio, DZONAGENERAL fin){
		try{
		DZONAGENERAL dzI = inicio;
		DZONAGENERAL dzF = fin;
		int pos1=MatrizRutas.posicionMatrizRecorrido(dzI.getCORDENADAX(), dzI.getCORDENADAY());
		int pos2=MatrizRutas.posicionMatrizRecorrido(dzF.getCORDENADAX(), dzF.getCORDENADAY());
		List<Integer> l = f.MRutaList(pos1,pos2);
		for (int i = 0; i< l.size(); i++) {
			for(int[] a : nodos) {
				if (l.get(i) == a[0]) {
					System.out.println(a[1]+ " " + a[2]);
				}
			}
		}
		System.out.println(f.MRuta(pos1,pos2));  
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
