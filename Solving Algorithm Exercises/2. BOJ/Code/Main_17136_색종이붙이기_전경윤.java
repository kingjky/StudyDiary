package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기_전경윤 {
	static int copy[][], arr[][], count[], Min, numbers[] = { 1, 2, 3, 4, 5 };
	static final int N = 10;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[N][N];
		copy = new int[N][N];

		StringTokenizer st;
		count = new int[5];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Min = Integer.MAX_VALUE;

		go(0, 0, 0);

		if (Min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(Min);

	}

	private static void go(int r, int c, int papers) {
		if (cal() == 0) {
			if (Min > papers)
				Min = papers;
			return;
		} else if (papers >= Min) {
			return;
		}
		
		int i = r, j = c;
		if(j>N-1) {
			i++;
			if(i>=N) return;
			j = 0;
		}

		if (arr[i][j] == 1) {
			for (int s = 5; s > 0; s--) {
				if (count[s - 1] < 5) {
					if ((i + s - 1) < N && (j + s - 1) < N && check(i, j, s)) {
						count[s - 1]++;
						put(i, j, s);
						go(i, j + s - 1, papers + 1);
						count[s - 1]--;
						take(i, j, s);
					}
				} else {
					continue;
				}
			}
			return;
		}
		go(i, j + 1, papers);

	}

	private static boolean check(int r, int c, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (arr[r + i][c + j] == 0)
					return false;
			}
		}
		return true;
	}

	private static void put(int r, int c, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				arr[r + i][c + j] = 0;
			}
		}
	}

	private static void take(int r, int c, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				arr[r + i][c + j] = 1;
			}
		}
	}

	private static void rollback() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				arr[i][j] = copy[i][j];
	}

	private static int cal() {
		int sum = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				sum += arr[i][j];
		return sum;
	}
}
