package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1954_달팽이숫자_황란아 {
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 우 하 좌 상

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			int dirIdx = 0, r = 0, c = 0;
			for (int n = 1; n <= N * N; n++) {
				map[r][c] = n;
				int newR = r + dir[dirIdx % 4][0];
				int newC = c + dir[dirIdx % 4][1];
				if (newR < 0 || newR >= N || newC < 0 || newC >= N || map[newR][newC] != 0) {
					++dirIdx;
					newR = r + dir[dirIdx % 4][0];
					newC = c + dir[dirIdx % 4][1];
				}
				r = newR;
				c = newC;
			}
			for (int i = 0; i < N; i++) {
				sb.append("\n");
				for (int j = 0; j < N; j++)
					sb.append(map[i][j] + " ");
			}
			System.out.println("#" + t + sb);

		}
	}
}