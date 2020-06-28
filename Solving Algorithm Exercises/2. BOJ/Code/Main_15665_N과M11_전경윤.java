package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15665_N과M11_전경윤 {
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
		method(0);
		System.out.print(sb);
	}

	private static void method(int size) {
		if(size==M) {
			for (int i : num) {
				sb.append(i+" ");
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(num[size] == input[i]) continue;
			num[size] = input[i];
			method(size+1);
		}
	}
}