package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2293_동전1 {
	static int arr[], memo[][], N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		memo = new int[K+1][N];
		memo[0][0] = 1;
		for (int i = 1; i <= K; i++) {
			for (int j = 0; j < N; j++) {
				int sum = 0;
				int coin = arr[j];
				if(i >= coin) {
					for (int k = 0; k <= j; k++) {
						sum+=memo[i-coin][k];
					}
					memo[i][j]=sum;
				} else break;
			}
		}
		int result=0;
		for(int i : memo[K]) {
			result+=i;
		}
		System.out.println(result);
	}
}
