package com.ssafy.ex;

import java.util.Scanner;

public class Solution_D4_4301_콩많이심기_전경윤 {
	static int[] dR = {0, -2};
	static int[] dC = {-2, 0};
	static int N, M;
	static boolean[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			arr = new boolean[M][N];
			int result=0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(check(i, j)) {
						result++;
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,result);
		}
	}
	private static boolean check(int r, int c) {
		int newR, newC;
		for (int k = 0; k < 2; k++) {
			newR = r+dR[k];
			newC = c+dC[k];
			
			if(newR>=0 && newR<M && newC>=0 && newC<N) {
				if(arr[newR][newC]) {
					return false;
				}
			}
		}
		arr[r][c] = true;
		return true;
	}

}