package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 16348 KB
 * 164 ms
 */
public class Main_1149_RGB거리_전경윤2 {
	static int N, cost[][], memo[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		memo = new int[N];
		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++)
				cost[n][i] = Integer.parseInt(st.nextToken());
		}
		int min = RGB(0, 0, -1);
		System.out.println(min);
	}

	private static int RGB(int num, int total, int prev_color) {
		if(num==N) return total;
		int min = Integer.MAX_VALUE;
		if(memo[num] != 0 && memo[num] < total) return Integer.MAX_VALUE;
		else memo[num] = total;
		//red
		if(prev_color != 0) {
			min = Math.min(min, RGB(num+1, total+cost[num][0], 0));
		}
		//green
		if(prev_color != 1) {
			min = Math.min(min, RGB(num+1, total+cost[num][1], 1));
		}
		//blue
		if(prev_color != 2) {
			min = Math.min(min, RGB(num+1, total+cost[num][2], 2));
		}
		
		return min;
	}
}
