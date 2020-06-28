package BAEKJOON;

import java.util.Scanner;

public class Main_15650_N과M2_전경윤 {
	static int N, M, nums[], nums2[];
	static boolean select[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[M];
		select = new boolean[N];
		
		combination(0, 0);
	}
	private static boolean nextPer() {
		int i, j;
		i = j = N-1;
		while(i>0) {
			if(nums2[i-1] < nums2[i]) break;
			i--;
		}
		if(i==0) return false;
		
		while(nums2[i-1] >= nums2[j]) j--;
		swap(i-1,j);
		j = N-1;
		while(i<j) {
			swap(i++, j--);
		}
		return true;
	}
	private static void swap(int i, int j) {
		int tmp = nums2[i];
		nums2[i] = nums2[j];
		nums2[j] = tmp;
	}
	private static void combination(int cur, int m) {
		if(m==M) {
			for (int i : nums) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = cur; i < N; i++) {
			nums[m] = (i+1);
			combination(i+1, m+1);
		}
		
	}
	private static void permutation(int n) {
		if(n==M) {
			for (int i : nums) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!select[i]) {
				select[i] = true;
				nums[n] = (i+1);
				permutation(n+1);
				select[i] = false;
			}
		}
		
	}
	
}
