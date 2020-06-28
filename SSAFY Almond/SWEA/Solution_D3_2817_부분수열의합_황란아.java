package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_2817_부분수열의합_황란아 {
	static int N, K, CNT;
	static int[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			numbers = new int[N];
			K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			CNT = 0;
			subSetSum(0, 0);

			System.out.println("#" + t + " " + CNT);
		}

	}

	private static void subSetSum(int index, int sum) {
		if (index == N) {
			if (sum == K)
				CNT++;
			return;
		} else if (sum == K) {
			CNT++;
			return;
		}
		subSetSum(index + 1, sum + numbers[index]);
		subSetSum(index + 1, sum);

	}

}
