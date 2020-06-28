package com.ssafy.day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이_황란아 {
	static int[][] map;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		map = new int[100][100];

		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()); // x
			int y = Integer.parseInt(st.nextToken()); // y
			for (int row = y; row < y + 10; row++) {
				for (int col = x; col < x + 10; col++) {
					map[row][col] = 1;
				}
			}

		}
		for (int row = 0; row < 100; row++) {
			for (int col = 0; col < 100; col++) {
				if (map[row][col] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);

	}

}
