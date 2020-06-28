package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기_전경윤 {

	private static int N, W, H, min;
	private static int[] dR = {0,1,0,-1}, dC = {1,0,-1,0};
	private static int[][] copy[], map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			copy = new int[N+1][H][W];
			map = new int[H][W];
			for (int h = 0; h < H; h++) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; w++) {
					copy[0][h][w] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			dfs(0);
			System.out.printf("#%d %d\n", t, min);
		}
	}
	private static void dfs(int n) {
		if(n>=N) {
			int num = check();
			if(min > num) min = num;
			return;
		}
		for (int w = 0; w < W; w++) {
			copyFrom(n);
			shoot(w);
			copyTo(n+1);
			dfs(n+1);
		}		
	}
	private static int check() {
		int cnt = 0;
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				if(copy[N][h][w] > 0) cnt++; 
			}
		}
		return cnt;
	}
	private static void shoot(int w) {
		int h = 0;
		while(h < H && map[h][w] == 0) h++;
		if(h==H) return;
		destroy(h,w);
		for (int c = 0; c < W; c++) {
			drop(c);
		}
	}

	private static void drop(int c) {
		Stack<Integer> stack = new Stack<>();
		for (int r = 0; r < H; r++) {
			if(map[r][c] > 0) {
				stack.push(map[r][c]);
				map[r][c] = 0;
			}
		}
		int r = H-1;
		while(!stack.isEmpty()) {
			map[r--][c] = stack.pop();
		}
	}
	private static void destroy(int h, int w) {
		int power = map[h][w]-1;
		map[h][w] = 0;
		int newR, newC;
		for (int k = 0; k < 4; k++) {
			newR = h;
			newC = w;
			int t = 0;
			while(t++<power) {
				newR += dR[k];
				newC += dC[k];
				if(newR<0 || newR >=H || newC<0 || newC >=W) break;
				if(map[newR][newC] > 0) destroy(newR, newC);
			}
		}
	}
	private static void copyFrom(int n) {
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				map[h][w] = copy[n][h][w];
			}
		}
	}
	private static void copyTo(int n) {
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				copy[n][h][w] = map[h][w];
			}
		}
	}
}
