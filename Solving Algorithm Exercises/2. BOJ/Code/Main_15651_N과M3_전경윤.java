package BAEKJOON;

import java.io.IOException;
import java.util.Scanner;

public class Main_15651_N과M3_전경윤 {
	static int N, M, nums[], nums2[];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[M];
		
		overlapCombination(0);
		System.out.println(sb);
	}
	private static void overlapCombination(int m) throws IOException {
		if(m==M) {
			for (int i : nums) {
				sb.append(i+" ");
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			nums[m] = (i+1);
			overlapCombination(m+1);
		}
	}
}