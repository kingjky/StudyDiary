package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2193_이친수_전경윤 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long memo[][] = new long[N+1][2];
		memo[1][0] = 0;
		memo[1][1] = 1;
		for (int i = 2; i <= N; i++) {
			memo[i][0] = memo[i-1][1]+memo[i-1][0];
			memo[i][1] = memo[i-1][0];
		}
		System.out.println(memo[N][0]+memo[N][1]);
	}
}
