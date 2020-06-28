          package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 13496 KB
 * 84 ms
 */
public class Main_1149_RGB거리_전경윤 {
	static int N, cost[][], memo[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		memo = new int[3];
		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++)
				cost[n][i] = Integer.parseInt(st.nextToken());
		}
		
		int r, g, b;
		for (int i = 0; i < N; i++) {
			r = cost[i][0] + Math.min(memo[1], memo[2]);
			g = cost[i][1] + Math.min(memo[0], memo[2]);
			b = cost[i][2] + Math.min(memo[0], memo[1]);
			
			memo[0] = r;
			memo[1] = g;
			memo[2] = b;
		}
		System.out.println(Math.min(memo[0], Math.min(memo[1], memo[2])));
	}
}
