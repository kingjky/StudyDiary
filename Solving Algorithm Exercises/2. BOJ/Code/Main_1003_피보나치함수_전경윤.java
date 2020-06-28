package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_피보나치함수_전경윤 {
	static int memo[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			memo = new int[N+2][2];
			memo[0][0] = 1;
			memo[0][1] = 0;
			memo[1][0] = 0;
			memo[1][1] = 1;
			for (int i = 2; i <= N; i++) {
				memo[i][0] = memo[i-1][0]+memo[i-2][0];
				memo[i][1] = memo[i-1][1]+memo[i-2][1];
			}
			System.out.println(memo[N][0]+" "+memo[N][1]);
		}
	}
}
