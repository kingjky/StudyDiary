package BAEKJOON;

import java.util.Scanner;

public class Main_15649_N과M1_전경윤 {
	static int N, M, nums[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[M];
		
		permutation(0, 0);
	}
	private static void permutation(int n, int flag) {
		if(n == M) {
			for (int i : nums) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((flag & 1<<i) > 0) continue;
				nums[n] = (i+1);
				permutation(n+1, flag | 1<<i);
		}
	}
}
