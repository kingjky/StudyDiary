package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BaekJoon
 */
public class Main_17070_파이프옮기기1_전경윤 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][N];
		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		int[][][] memo = new int[N][N][3]; // 0:가로 1:세로 2:대각
		memo[0][1][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]>0)continue;
				if(j-1>=0) memo[i][j][0] += memo[i][j-1][0] + memo[i][j-1][2];
				if(i-1>=0) memo[i][j][1] += memo[i-1][j][1] + memo[i-1][j][2];
				if(j-1>=0 && i-1>=0) {
					memo[i][j][2] += (map[i-1][j]+map[i][j-1])<1?memo[i-1][j-1][0]:0;
					memo[i][j][2] +=  (map[i-1][j]+map[i][j-1])<1?memo[i-1][j-1][1]:0;
					memo[i][j][2] += (map[i-1][j]+map[i][j-1])<1?memo[i-1][j-1][2]:0;
				}
			}
		}
		System.out.println(memo[N-1][N-1][0]+memo[N-1][N-1][1]+memo[N-1][N-1][2]);
	}
}
