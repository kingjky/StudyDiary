package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15663_N과M9_전경윤 {
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
		visit = new boolean[N];

		combi(0);

		System.out.print(sb);
	}

	private static void combi(int m) {
		if (m == M) {
			for (int i : num) {
				sb.append(i + " ");
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				if (num[m] == input[i])
					continue;
				visit[i] = true;
				num[m] = input[i];
				combi(m + 1);
				visit[i] = false;
			}
		}
		num[m] = 0;
	}
}