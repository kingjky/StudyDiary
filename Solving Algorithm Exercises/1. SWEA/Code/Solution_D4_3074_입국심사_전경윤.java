package com.ssafy.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_3074_입국심사_전경윤 {
	static int N, M, tk[];
	static long result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);

			tk = new int[N];
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				tk[i] = Integer.parseInt(br.readLine());
				if(tk[i] < min) min = tk[i];
			}
			long end = min*M;
			result = -1;
			search(1, end);
			System.out.printf("#%d %d\n",t,result);
		} // end of TC
	}

	private static void search(long start, long end) {
		if(end-start == 1) {
			return;
		}
		long middle = (start + end) / 2;
		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (middle / tk[i]);
		}
		if(sum >= M) { 
			result = middle;
			if(start==middle) return;
			search(start, middle);
		}
		else if(sum < M) search(middle, end);
	}
}
