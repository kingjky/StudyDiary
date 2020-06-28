package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15654_N과M5_전경윤 {
	static int N, M, input[], num[];
	static boolean visit[];
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();

		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		Arrays.sort(input);

		num = new int[M];

		combi(-1, 0);

		System.out.print(sb);
	}

	private static void combi(int cur, int m) {
		if (m == M) {
			for (int n : num) {
				sb.append(n + " ");
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {
			num[m] = i;
			if (i == cur)
				continue;
			combi(i, m + 1);
		}
	}
}