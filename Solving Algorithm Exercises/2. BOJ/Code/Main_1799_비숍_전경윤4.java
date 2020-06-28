package ssafy.baekjoon.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1799_비숍_전경윤4 {
	static int N;
	static int[][] map;
	static int[][] bishop;
	static boolean[][] sel;
	static int Num = 0;
	static int Num2 = 0;
	static int Max = 0;
	static int Max2 = 0;
	static int result = 0;

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

		// start of Algorithm

		// Print
		search();
		System.out.println(Max + Max2);
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

	static void search() {
		Num = 0;
		
		out1: for (int i = 0; i < N; i++) {
			for (int j = i % 2; j < N; j += 2) {
				if (map[i][j] == 0) {
					select(i, j);
				}
			}
		}

		result += Max;
		Num = 0;
		
		out2: for (int i = 0; i < N; i++) {
			for (int j = (i % 2) ^ 1; j < N; j += 2) {
				if (map[i][j] == 0) {
					select(i, j);
				}
			}
		}

		result += Max2;

	}

	static void select(int r, int c) {
		Num++;
		sel[r][c] = true;
		calPlus(r, c);
		int i = r, j = c;
		for (; i < N; i++) {
			for (; j < N; j += 2) {
				if (map[i][j] == 0 && !sel[i][j] && bishop[i][j] == 0) {
					select(i, j);
				}
			}
			j = (r + c) % 2 == 0 ? (i + 1) % 2 : i % 2;
		}
		
		if((r + c) % 2 == 0) {
			if(Max < Num) {
				Max = Num;
//				print(2);
			}
		} else {
			if(Max2 < Num) {
				Max2 = Num;
//				print(2);
			}
		}
		
		calMinus(r, c);
		sel[r][c] = false;
		Num--;
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
					System.out.print((sel[i][j] ? 1 : 0) + " ");
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
