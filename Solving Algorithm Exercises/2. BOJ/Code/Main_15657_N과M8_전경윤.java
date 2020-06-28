package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15657_N과M8_전경윤 {
	static int N, M, input[], num[];
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
		num = new int[M];
		
		Arrays.sort(input);
		combi(0,0);

		System.out.print(sb);
	}

	private static void combi(int cur, int m) {
		if(m==M) {
			for (int i : num) {
				sb.append(i+" ");
			}
			sb.append('\n');
			return;
		}
		
		for (int i = cur; i < N; i++) {
			num[m] = input[i];
			combi(i, m+1);
		}
	}
}