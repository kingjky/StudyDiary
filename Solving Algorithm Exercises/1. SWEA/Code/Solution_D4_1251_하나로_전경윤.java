package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *	M : 119876 kb
 *	T : 597 ms
 */
public class Solution_D4_1251_하나로_전경윤 {
	static List<double[]> list;
	static int N, island[][];
	static double E;
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			island = new int[N][2];
			for (int i = 0; i < 2; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					island[j][i] = Integer.parseInt(str[j]);
				}
			}
			E = Double.parseDouble(br.readLine());
			// end of input
			
			// 환경부담금 : E x L^2
			list = new ArrayList<>();
			parents = new int [N];
			Arrays.fill(parents, -1);
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					list.add(new double[] {i,j,ExLength2(island[i][0], island[i][1], island[j][0], island[j][1])});
				}
			}
			
			Collections.sort(list, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					boolean b = (o1[2] - o2[2]<0);
					if(b)
						return -1;
					else
						return 1;
				}
			});
			
			double sum = 0;
			for (int i = 0, end = N*(N-1)/2; i < end; i++) {
				if (union((int)list.get(i)[0], (int)list.get(i)[1]))
					sum += list.get(i)[2];
			}
			
			System.out.printf("#%d %d\n", t, Math.round(sum));
		}
	}

	private static double ExLength2(int a_X, int a_Y, int b_X, int b_Y) {
		double result = ( Math.pow((a_X - b_X), 2) + Math.pow((a_Y - b_Y), 2));
		result *= E;
		return result;
	}
	
	private static boolean union(int a, int b) {
		//2. find set : 자신이 속한 집합 찾기
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot) {		//3. union set : 두 노드의 집합이 다르면 합치기
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}
	private static int find(int a) {
		if(parents[a]<0) return a;	//루트노드이면 자신의 번호 리턴
		// 루트노드가 아니면 부모노드 따라가서 루트노드 알아온다.
		return parents[a] = find(parents[a]); // path compression :  루트 노드를 리턴받아 자신의 부모노드로 등록
	}

}
