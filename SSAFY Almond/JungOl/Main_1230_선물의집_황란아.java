package com.ssafy.day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1230_선물의집_황란아 {
	static int N, MAX;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }; // 남, 동, 북, 서

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		miro(0, 0, 0);
		System.out.println(MAX);
	}

	public static void miro(int row, int col, int cnt) {
		visited[row][col] = true;
		int nextCnt = cnt;
		if (map[row][col] == 2)
			nextCnt = cnt + 1;
		if (row == N - 1 && col == N - 1) {
			if (nextCnt > MAX)
				MAX = nextCnt;
			return;
		}

		// 나의 현재 정점 row, col
		for (int i = 0; i < 4; i++) {
			int newRow = row + dir[i][0];
			int newCol = col + dir[i][1];

			if (newRow >= N || newRow < 0 || newCol >= N || newCol < 0) {
				continue;
			}

			if (map[newRow][newCol] != 1 && !visited[newRow][newCol]) {
				miro(newRow, newCol, nextCnt);
				visited[newRow][newCol] = false;
			}
		}
	}

}
