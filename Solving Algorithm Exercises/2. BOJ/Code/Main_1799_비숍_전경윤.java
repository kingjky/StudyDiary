package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1799_비숍_전경윤 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[][] bishop;
	static int Num;
	static int Max = 0;
	static int count = 0;

	static int[] pR = { 1, 1, -1, -1 };
	static int[] pC = { 1, -1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		bishop = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		} // end of input

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
//				if (map[i][j] == 1) {
					Num = 0;
					check(i, j);
				}
			}
		}

		System.out.println(count);
		System.out.println(Max);
		
		br.readLine();
	}

	static void check(int r, int c) {
		boolean ok = true;
		int newR, newC;
		for (int k = 0; k < 4; k++) {
			newR = r;
			newC = c;
			while (newR >= 0 && newR < N && newC >= 0 && newC < N) {
				if (bishop[newR][newC] == 1)
					ok = false;
				newR += pR[k];
				newC += pC[k];
			}
		}
		if (ok) {
			bishop[r][c] = 1;
			visit[r][c] = true;
			Num++;
		} else {
			return;
		}

		int i = r;
		int j = c + 1;
		for (; i < N; i++) {
			for (; j < N; j++) {
//				if (!visit[i][j] && map[i][j] == 1 && bishop[i][j] == 0) {
				if (map[i][j] == 1 && bishop[i][j] == 0) {
					check(i, j);
				}
			}
			j = 0;
		}
//		System.out.println("Num: "+Num);
//		System.out.println();
//			System.out.println();
//			for (int[] js : bishop) {
//				System.out.println(Arrays.toString(js));
//			}
		count++;
		if (Max <= Num) {
			Max = Num;
		}
		if (ok) {
			bishop[r][c] = 0;
			Num--;
		}
	}
}
