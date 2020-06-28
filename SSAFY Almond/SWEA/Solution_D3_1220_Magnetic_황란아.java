package com.ssafy.swe.almonds;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1220_Magnetic_황란아 {
	static int N;
	static int[][] map;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("input_magnetic.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {

			N = Integer.parseInt(in.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int j = 0; j < N; j++) {
				int up = 0, down = N - 1;

				while (up < N) {
					if (map[up][j] == 2) {
						map[up][j] = 0;

					} else if (map[up][j] == 1) {
						break;
					}
					up++;
				}
				while (down >= 0) {
					if (map[down][j] == 1) {
						map[down][j] = 0;

					} else if (map[down][j] == 2) {
						break;
					}
					down--;
				}

			}
			int result = 0;

			for (int j = 0; j < N; j++) {

				int i = 0;
				while (i < N - 1) {
					if (map[i][j] == 1) {
						int k;
						for (k = i + 1; k < N; k++) {
							if (map[k][j] == 2) {
								i = k + 1;
								result++;
								break;
							}
						}
						if (k == N)
							i++;
					} else
						i++;

				}
			}
			System.out.println("#" + t + " " + result);

		}

	}
}
