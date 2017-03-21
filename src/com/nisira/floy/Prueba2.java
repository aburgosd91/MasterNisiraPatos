package com.nisira.floy;

import java.util.ArrayList;
import java.util.List;

public class Prueba2 {
	public static void main(String[] args) {
		int x = 6;
		int[][] m = new int[6][6];

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				m[i][j] = 0;
				if (i == 0 || i == 5 || j == 0 || j == 5 || i == 3) {
					m[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < x; i++) {
			System.out.print("[" + i + "]\t");
			for (int j = 0; j < x; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.print("\n");
		}

		List<int[]> nodos = new ArrayList<int[]>();

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				if (m[i][j] == 1) {
					nodos.add(new int[] { nodos.size(), i, j });
				}
			}
		}

		for (int[] n : nodos) {
			System.out.println(n[0] + " " + n[1] + " " + n[2]);
		}

		x = nodos.size();

		float[][] D = new float[x][x];
		int[][] S = new int[x][x];

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
		
		
		for (int i = 0; i < x; i++) {
			System.out.print("[" + i + "]\t");
			for (int j = 0; j < x; j++) {
				System.out.print(D[i][j] + "\t");
			}
			System.out.print("\n");
		}
		
		Floyd f = new Floyd(D,S,x);
		
		f.rutaFloyd();
		
		System.out.println(f.MRuta(2, 12));
		
		f.EscribirMatricez();
		
		
		
	}

}
