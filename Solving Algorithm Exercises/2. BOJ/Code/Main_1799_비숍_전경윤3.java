package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1799_비숍_전경윤3 {
	static int N;
	static int[][] map;
	static int[][] bishop;
	static boolean[][] sel;
	static int Num;
	static int Max = 0;
	static int count = 0;

	static int[] pR = { 1, 1, -1, -1 };
	static int[] pC = { 1, -1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		bishop = new int[N][N];
		sel = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]) == 1 ? 0 : 1;
			}
		} // end of input

		System.out.println();
		// start of Algorithm
//		calPlus(0,0);
//		select(0,0);
//		calMinus(0,0);
//		for (int i = 0; i < N; i++) {
//			calPlus(0, i);
//		}
//		Num = N;
		select(0, 0);

		// Print
		System.out.println(count);
		System.out.println(Max);

//		br.readLine();
	}

	static void calPlus(int r, int c) {
		int newR, newC;
		bishop[r][c] += 1;
		for (int k = 0; k < 4; k++) {
			newR = r;
			newC = c;
			newR += pR[k];
			newC += pC[k];
			while (newR >= 0 && newR < N && newC >= 0 && newC < N) {
				bishop[newR][newC] += 1;
				newR += pR[k];
				newC += pC[k];
			}
		}
	}

	static void calMinus(int r, int c) {
		int newR, newC;
		bishop[r][c] -= 1;
		for (int k = 0; k < 4; k++) {
			newR = r;
			newC = c;
			newR += pR[k];
			newC += pC[k];
			while (newR >= 0 && newR < N && newC >= 0 && newC < N) {
				bishop[newR][newC] -= 1;
				newR += pR[k];
				newC += pC[k];
			}
		}
	}

	static void select(int r, int c) {
		int j = c;
		Num++;
		calPlus(r, c);
		sel[r][c] = true;
//		print(0);
		for (int i = r; i < N; i++) {
			for (; j < N; j++) {
				if (map[i][j] + bishop[i][j] == 0) {
//				if (!sel[r][c] && map[i][j] + bishop[i][j] == 0) {
					select(i, j);
				}
			}
			j = 0;
		}
		count++;
//		System.out.println(count+" ");
		if (Max < Num) {
			Max = Num;
//			System.out.println("Max : " + Max);
//			print(2);
		}
//		System.out.println();
		calMinus(r, c);
//		print(1);
		Num--;
		sel[r][c] = false;
	}

	static void print(int s) {
		if (s == 0)
			System.out.println(Num + " 번째 비숍 더하기");
		else if (s == 1)
			System.out.println(Num + " 번째 비숍 빼기");

		System.out.println();

		if (s == 2) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print((sel[i][j]?1:0)+" ");
				}
				System.out.println();
			}
		} else {

			for (int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(bishop[i]) + " ");
			}
		}
		System.out.println();
	}
}
