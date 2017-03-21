package com.nisira.utilitarios;

import java.util.*;
//import Archivos.*;

public class Floyd implements java.io.Serializable {
	private float[][] D;
	private int[][] S;
	int x;
	final int inf = -1;
	
	public Floyd(float[][] D, int[][] S, int x) {
		this.D = D;
		this.S = S;
		this.x = x;
		
	}

	public void EscribirMatricez() {
		for (int j = 0; j < x; j++)
			System.out.print("\t[" + j + "]");
		System.out.print("\n");
		for (int i = 0; i < x; i++) {
			System.out.print("[" + i + "]\t");
			for (int j = 0; j < x; j++) {
				System.out.print(D[i][j] + "\t");
			}
			System.out.print("\n");
		}
		for (int j = 0; j < x; j++)
			System.out.print("\t[" + j + "]");
		System.out.print("\n");
		for (int i = 0; i < x; i++) {
			System.out.print("[" + i + "]\t");
			for (int j = 0; j < x; j++) {
				System.out.print(S[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}

	public int[][] retornarD() {
		rutaFloyd();
		return S;
	}

	public void rutaFloyd() {
		for (int k = 0; k < x; k++) {
			for (int i = 0; i < x; i++) {
				if (i != k && D[i][k] != inf) {
					for (int j = 0; j < x; j++) {
						if (j != k && D[k][j] != inf && i != j) {
							if (esMenor(D[i][k] + D[k][j], D[i][j])) {
								D[i][j] = D[i][k] + D[k][j];
								S[i][j] = k;
								try {
									// Archi.guardarFloyd(D, S,x);
								} catch (Exception e) {

								}
							}
						}
					}
				}
			}
		}
	}

	private boolean esMenor(float a, float b) {
		if (b != inf) {
			return a < b;
		}
		return true;
	}

	public ArrayList<Integer> solucion(int a, int b) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		String cad = a + " " + MRuta(a, b);
		System.out.println("SOLUCION: " + cad);
		for (int i = 0; i < cad.length(); i++) {
			if (cad.charAt(i) != ' ') {
				String cn = "";
				while (i < cad.length() && cad.charAt(i) != ' ') {
					cn = cn + cad.charAt(i);
					i++;
				}
				int num = Integer.parseInt(cn);
				lista.add(num);
			}
		}
		return lista;
	}

	public String MRuta(int a, int b) {
		if (S[a][b] == b) {
			return String.valueOf(b);
		} else {
			return (MRuta(a, S[a][b]) + " " + MRuta(S[a][b], b));
		}
	}
}

