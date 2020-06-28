package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15664_N과M10_전경윤 {
	static int N, M, input[], num[];
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();

		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N];
		num = new int[M];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		Arrays.sort(input);
		method(0,0);
		System.out.print(sb);
	}

	private static void method(int cur, int m) {
		if(m == M) {
			for (int i : num) {
				sb.append(i+" ");
			}
			sb.append('\n');
			return;
		}
		
		for (int i = cur; i < N; i++) {
			if(num[m] == input[i]) continue;
			num[m] = input[i];
			method(i+1, m+1);
		}
		num[m] = 0;
	}
}