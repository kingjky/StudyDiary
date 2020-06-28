package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution_D4_3124_최소스패닝트리_전경윤 {
	static int V, E, input[][], parents[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			V = Integer.parseInt(str[0]);
			E = Integer.parseInt(str[1]);
			input = new int[E][3];
			for (int i = 0; i < E; i++) {
				str = br.readLine().split(" ");
				input[i][0] = Integer.parseInt(str[0]);
				input[i][1] = Integer.parseInt(str[1]);
				input[i][2] = Integer.parseInt(str[2]);
			}

			Arrays.sort(input, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});

			parents = new int[V + 1];

			long sum = 0;
			for (int i = 0; i < E; i++) {
				if (union(input[i][0], input[i][1]))
					sum += input[i][2];
			}

			System.out.printf("#%d %d\n", t, sum);
		}
	}

	private static boolean union(int a, int b) {
		// 2. find set : 자신이 속한 집합 찾기
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot) { // 3. union set : 두 노드의 집합이 다르면 합치기
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}

	private static int find(int a) {
		if (parents[a] == 0)
			return a;
		return parents[a] = find(parents[a]); // path compression
	}
}
