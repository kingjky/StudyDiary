package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;
/*
 * M : 15128KB
 * T : 140 ms
 */
public class Main_2579_계단오르기 {
	static int N, memo[][], score[], cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		score = new int[N + 1];
		memo = new int[2][N + 1];
		
		for (int i = 1; i <= N; i++)
			score[i] = sc.nextInt();
		
		Arrays.fill(memo[0], -1);
		Arrays.fill(memo[1], -1);
		cnt = 0;
		int tmp = down(N, 0, 0);
		System.out.printf("%d, %d\n", tmp, cnt);
	}	
	private static int down(int i, int j, int k) { // 위치, 연속 수, 점수
		cnt++;
		if(i<=1)
			return memo[j][i] = score[i]+k;
		
		if(memo[j][i] > k)
			return -1;
		else
			memo[j][i] = k;
		
		int max = -1;
		if(j<1) 
			max = Math.max(max, down(i-1, j+1, score[i]+k));
		max = Math.max(max, down(i-2, 0, score[i]+k));
		return max;
	}	
}