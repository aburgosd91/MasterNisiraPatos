package com.nisira.floy;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.nisira.entidad.CoordenadaMatriz;

public class FloydNisira {
	public List<CoordenadaMatriz> matrizGeneral;
//	public List<CoordenadaMatriz> matrizResultado;
//	public CoordenadaMatriz partida;
//	public CoordenadaMatriz llegada;
	public FloydNisira(List<CoordenadaMatriz> matrizGeneral){
		this.matrizGeneral=matrizGeneral;
	}
	public List<Integer> dondeMoverme(CoordenadaMatriz partida,CoordenadaMatriz llegada){
		List<Integer> direccionMoverme= new ArrayList<Integer>();
		/*ANALIZAR VECINOS*/
		int x1=partida.getX()+1;	/*(↓)*/
		int y1=partida.getY();		/*(↓)*/
		CoordenadaMatriz evaluar1= new CoordenadaMatriz(partida.getPosicion(), x1, y1);
		
		int x2=partida.getX()-1;	/*(↑)*/
		int y2=partida.getY();		/*(↑)*/
		CoordenadaMatriz evaluar2= new CoordenadaMatriz(partida.getPosicion(), x2, y2);
		
		int x3=partida.getX();		/*(→)*/
		int y3=partida.getY()+1;	/*(→))*/
		CoordenadaMatriz evaluar3= new CoordenadaMatriz(partida.getPosicion(), x3, y3);
		
		int x4=partida.getX();		/*(←)*/
		int y4=partida.getY()-1;	/*(←)*/
		CoordenadaMatriz evaluar4= new CoordenadaMatriz(partida.getPosicion(), x4, y4);
		
		if(buscarMatriz(evaluar1)){
			direccionMoverme.add(1);
		}if(buscarMatriz(evaluar2)){
			direccionMoverme.add(2);
		}if(buscarMatriz(evaluar3)){
			direccionMoverme.add(3);
		}if(buscarMatriz(evaluar4)){
			direccionMoverme.add(4);
		}
		return direccionMoverme;
	}
	public List<Integer> nopuedoMoverme(CoordenadaMatriz partida,CoordenadaMatriz llegada){
		List<Integer> direccionMoverme= dondeMoverme(partida,llegada);
		List<Integer> direccionNoMoverme= new ArrayList<Integer>();
		direccionNoMoverme.add(1);
		direccionNoMoverme.add(2);
		direccionNoMoverme.add(3);
		direccionNoMoverme.add(4);
		direccionNoMoverme.removeAll(direccionMoverme);
		return direccionNoMoverme;
	}
	public List<Integer> prioridadOrientacion(CoordenadaMatriz partida,CoordenadaMatriz llegada){
		List<Integer> depurando= new ArrayList<Integer>();
		/*DEPURAR POR DIRECCION*/
		if(partida.getX()<llegada.getX()){
			depurando.add(1);
		}
		if(partida.getX()>llegada.getX()){
			depurando.add(2);
		}
		if(partida.getY()<llegada.getY()){
			depurando.add(3);
		}
		if(partida.getY()>llegada.getY()){
			depurando.add(4);
		}
		return depurando;
	}
	public Integer calcularPrioridadFinal(CoordenadaMatriz ant,CoordenadaMatriz partida,CoordenadaMatriz llegada){
		
		/***************************OPERACIONES**************************/
		List<Integer> direccionMoverme= dondeMoverme(partida,llegada);
		List<Integer> direccionNoMoverme= nopuedoMoverme(partida,llegada);
		List<Integer> depurando= prioridadOrientacion(partida,llegada);
		Integer prioridad=0;
		/*CALCULO NO PUEDO VS PRIORIDAD*/
		List<Integer> vs1 = new ArrayList<Integer>();
		vs1.addAll(depurando);
		vs1.removeAll(direccionNoMoverme);
		if(ant!=null){ 
			/*******************CALCULAR PRIORIDAD DEL ANTERIOR****************/
			List<Integer> depurandoAnt = new ArrayList<Integer>();
			if(ant.getX()>partida.getX()){
				depurandoAnt.add(1);
			}
			if(ant.getX()<partida.getX()){
				depurandoAnt.add(2);
			}
			if(ant.getY()>partida.getY()){
				depurandoAnt.add(3);
			}
			if(ant.getY()<partida.getY()){
				depurandoAnt.add(4);
			}
			/*CALCULO DE ALGORITMO*/
			if(vs1.size()==0){
				vs1.addAll(direccionMoverme);
				vs1.removeAll(depurandoAnt);
				prioridad=vs1.get(0);
			}
			else{
				vs1.removeAll(depurandoAnt);
				/*************************************************************/
				if(vs1.size()==0){
					List<Integer> condicional = new ArrayList<Integer>();
					condicional.addAll(direccionMoverme);
					condicional.removeAll(depurandoAnt);
					prioridad=condicional.get(0);
				}else{
					prioridad=vs1.get(0);
				}
			}
		}
		else
			if(direccionMoverme.size()==2){
				boolean flag=true;
				for(Integer moverme : direccionMoverme){
					for(Integer priorizar : depurando){
						if(moverme==priorizar){
							prioridad=moverme;
							flag=false;
							break;
						}
					}
					if(!flag)
						break;
				}
				if(prioridad==0)
					prioridad=direccionMoverme.get(0);
			}else
				prioridad=direccionMoverme.get(0);
		
		return prioridad;
	}

	public List<CoordenadaMatriz> calcularResultado(int prioridad,CoordenadaMatriz ant,CoordenadaMatriz partida,CoordenadaMatriz llegada,List<CoordenadaMatriz> matrizResultado){
		/*BUSCAR POSICIÓN INICIAL*/
		if(!(partida.getX()==llegada.getX() & partida.getY()==llegada.getY())){
			CoordenadaMatriz dato;
			/* PREFERENCIA PRIORIDAD	*/
			prioridad=calcularPrioridadFinal(ant,partida,llegada);
			ant= new CoordenadaMatriz(partida.getPosicion(), partida.getX(), partida.getY());
			/*CALCULAR ORIENTACIÓN*/
			switch(prioridad){
				case 1: 
					dato= new CoordenadaMatriz(partida.getPosicion(), partida.getX()+1, partida.getY());
					matrizResultado.add(dato);
					System.out.print("\nRecorrido:("+dato.getX()+","+dato.getY()+")");
					calcularResultado(prioridad,ant,dato,llegada,matrizResultado);
					;break;
				case 2:
					dato= new CoordenadaMatriz(partida.getPosicion(), partida.getX()-1, partida.getY());
					matrizResultado.add(dato);
					System.out.print("\nRecorrido:("+dato.getX()+","+dato.getY()+")");
					calcularResultado(prioridad,ant,dato,llegada,matrizResultado);
					;break;
				case 3:
					dato= new CoordenadaMatriz(partida.getPosicion(), partida.getX(), partida.getY()+1);
					matrizResultado.add(dato);
					System.out.print("\nRecorrido:("+dato.getX()+","+dato.getY()+")");
					calcularResultado(prioridad,ant,dato,llegada,matrizResultado);
					;break;
				case 4:
					dato= new CoordenadaMatriz(partida.getPosicion(), partida.getX(), partida.getY()-1);
					matrizResultado.add(dato);
					System.out.print("\nRecorrido:("+dato.getX()+","+dato.getY()+")");
					calcularResultado(prioridad,ant,dato,llegada,matrizResultado);
					;break;
			}
		}
		return matrizResultado;
	}
	
	public Boolean buscarMatriz(CoordenadaMatriz eval){
		Boolean dato=false;
		CoordenadaMatriz xcor=null;
		for(int i=0;i<this.matrizGeneral.size();i++){
			xcor=this.matrizGeneral.get(i);
			if(xcor.getX()==eval.getX() && xcor.getY()==eval.getY()){
				dato=true;
				break;
			}
		}
		return dato;
	}
}


//public List<Integer> calcularPrioridad(CoordenadaMatriz partida,CoordenadaMatriz llegada){
//	/*PRIORIDAD*/
//	List<Integer> prioridadesInicial= new ArrayList<Integer>();
//	/*
//	 * (↓) PRIORIDAD 1
//	 * (↑) PRIORIDAD 2
//	 * (→) PRIORIDAD 3
//	 * (←) PRIORIDAD 4
//	 * */
//	/*ANALIZAR VECINOS*/
//	int x1=partida.getX()+1;	/*(↓)*/
//	int y1=partida.getY();		/*(↓)*/
//	CoordenadaMatriz evaluar1= new CoordenadaMatriz(partida.getPosicion(), x1, y1);
//	
//	int x2=partida.getX()-1;	/*(↑)*/
//	int y2=partida.getY();		/*(↑)*/
//	CoordenadaMatriz evaluar2= new CoordenadaMatriz(partida.getPosicion(), x2, y2);
//	
//	int x3=partida.getX();		/*(→)*/
//	int y3=partida.getY()+1;	/*(→))*/
//	CoordenadaMatriz evaluar3= new CoordenadaMatriz(partida.getPosicion(), x3, y3);
//	
//	int x4=partida.getX();		/*(←)*/
//	int y4=partida.getY()-1;	/*(←)*/
//	CoordenadaMatriz evaluar4= new CoordenadaMatriz(partida.getPosicion(), x4, y4);
//	
//	if(buscarMatriz(evaluar1)){
//		prioridadesInicial.add(1);
//	}if(buscarMatriz(evaluar2)){
//		prioridadesInicial.add(2);
//	}if(buscarMatriz(evaluar3)){
//		prioridadesInicial.add(3);
//	}if(buscarMatriz(evaluar4)){/*partida.getY()>llegada.getY()*/
//		prioridadesInicial.add(4);
//	}
//	/*CASOS DE ESTUDIO*/
//	List<Integer> depurando= new ArrayList<Integer>();
//	List<Integer> prioridades= new ArrayList<Integer>();
//	/*VALIDAR QUE TENGA UN SENTIDO*/
//	if(prioridadesInicial.size()==2){
//		int pos0=prioridadesInicial.get(0);
//		int pos1=prioridadesInicial.get(1);
//		if((pos0==3 & pos1==4)|(pos0==4 & pos1==3))
//			prioridades.addAll(prioridadesInicial);
//		else if((pos0==1 & pos1==2)|(pos0==2 & pos1==1))
//			prioridades.addAll(prioridadesInicial);
//		
//	}else if(prioridadesInicial.size()==3){
//		int pos0=prioridadesInicial.get(0);
//		int pos1=prioridadesInicial.get(1);
//		int pos2=prioridadesInicial.get(2);
//		if(pos0==1 & pos1==3 & pos2==4){
//			prioridades.addAll(prioridadesInicial);
//		}
//		else if(pos0==2 & pos1==3 & pos2==4){
//			prioridades.addAll(prioridadesInicial);
//		}
//		else if(pos0==1 & pos1==2 & pos2==3){
//			prioridades.addAll(prioridadesInicial);
//		}
//		else if(pos0==1 & pos1==2 & pos2==4){
//			prioridades.addAll(prioridadesInicial);
//		}
//	}else{
//		/*DEPURAR POR DIRECCION*/
//		if(partida.getX()<llegada.getX()){
//			depurando.add(1);
//		}
//		if(partida.getX()>llegada.getX()){
//			depurando.add(2);
//		}
//		if(partida.getY()<llegada.getY()){
//			depurando.add(3);
//		}
//		if(partida.getY()>llegada.getY()){
//			depurando.add(4);
//		}
//		/*****************************************************/
//		for(Integer dep : depurando){
//			for(Integer dato : prioridadesInicial)
//				if(dep.intValue()==dato.intValue()){
//					prioridades.add(dep);
//				}
//		}
//	}
//	/*****************************************************/
//	return prioridades;
//}

//public int analizarPreferencia(List<Integer> prioridades,Boolean flag){
//	int prioridad=0;
//	int pos0,pos1,pos2,pos4=0;
//	/*
//	 * (↓) PRIORIDAD 1
//	 * (↑) PRIORIDAD 2
//	 * (→) PRIORIDAD 3
//	 * (←) PRIORIDAD 4
//	 * */
//	if(prioridades.size()>0){
//		switch (prioridades.size()) {
//		case 1:
//			prioridad=prioridades.get(0);
//			break;
//		case 2:
//			pos0=prioridades.get(0);
//			pos1=prioridades.get(1);
//			prioridad=(pos0==3 | pos0==4)?pos0:pos1;
//			break;
//		case 3:
//			pos0=prioridades.get(0);
//			pos1=prioridades.get(1);
//			pos2=prioridades.get(2);
//			if(pos0==1 & pos1==3 & pos2==4){
//				prioridad = pos0;
//			}
//			else if(pos0==2 & pos1==3 & pos2==4){
//				prioridad = pos0;
//			}
//			else if(pos0==1 & pos1==2 & pos2==3){
//				prioridad = pos2;
//			}
//			else if(pos0==1 & pos1==2 & pos2==4){
//				prioridad = pos2;
//			}
//			
//			break;
//		case 4:
//			
//			break;
//		default:
//			break;
//		}
//	}
//	return prioridad;
//}


