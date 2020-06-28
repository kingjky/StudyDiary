package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4_전경윤 {
	static int totalCount = 0;
	static int[] numbers;
	static int N, M, K, Arr[][], Copy[][], R[][], Min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Arr = new int[N][M];
		Copy = new int[N][M];
		R = new int[K][3];
		numbers = new int[K];
		for (int i = 0; i < K; i++) {
			numbers[i] = i;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Copy[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				R[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// end of input

		Min = Integer.MAX_VALUE;
		do {
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					Arr[i][j] = Copy[i][j];

			for (int i = 0; i < K; i++) {
				int cur = numbers[i];
				rotation(R[cur][0] - 1, R[cur][1] - 1, R[cur][2]);
			}

			int Value = cal();
			if (Value < Min)
				Min = Value;
		} while (nextPermutation());

		System.out.println(Min);
	}

	private static int cal() {
		int sums[] = new int[N];
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += Arr[i][j];
			}
			sums[i] = sum;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < sums.length; i++) {
			if (sums[i] < min)
				min = sums[i];
		}
		return min;
	}

	private static void rotation(int r, int c, int s) {
		for (int k = 1; k <= s; k++) {
			int temp = Arr[r - k][c + k];

			for (int i = 0; i < 2 * k; i++) {
				Arr[r - k][c + k - i] = Arr[r - k][c + k - i - 1];
			}

			for (int i = 0; i < 2 * k; i++) {
				Arr[r - k + i][c - k] = Arr[r - k + i + 1][c - k];
			}
			for (int i = 0; i < 2 * k; i++) {
				Arr[r + k][c - k + i] = Arr[r + k][c - k + i + 1];
			}
			for (int i = 0; i < 2 * k - 1; i++) {
				Arr[r + k - i][c + k] = Arr[r + k - i - 1][c + k];
			}
			Arr[r - k + 1][c + k] = temp;
		}
	}

	private static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	private static boolean nextPermutation() {
		totalCount++;
		int i = K - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;
		if (i == 0)
			return false;
		int j = K - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;
		swap(i - 1, j);
		j = K - 1;
		while (i < j) {
			swap(i++, j--);
		}
		return true;
	}
}
