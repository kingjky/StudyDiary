package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author JKY
 * 01:50:30
 * M : 14008 KB
 * T : 172 ms
 */
public class Main_2178_미로탐색_전경윤 {
	static int[][] arr;
	static int[][] minArr;
	static int[] pR = { 0, 1, 0, -1 };
	static int[] pC = { 1, 0, -1, 0 };
	static int N, M;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		minArr = new int[N][M];

		for (int i = 0; i < N; i++) {
			int j = 0;
			for (char c : br.readLine().toCharArray()) {
				arr[i][j++] = c - '0';
			}
		}
		// end of input

		min = Integer.MAX_VALUE;
		search(0, 0, 1);
		
		System.out.println(min);
	}

	static void search(int r, int c, int cost) {
		if(minArr[r][c] != 0 && minArr[r][c] <= cost)
			return;
		
		minArr[r][c] = cost;
		if (cost < min) {
			if (r == N - 1 && c == M - 1) {
				if (cost < min)
					min = cost;
				return;
			} else {
				for (int i = 0; i < 4; i++) {
					int newR = r + pR[i], newC = c + pC[i];
					if (newR >= 0 && newR < N && newC >= 0 && newC < M) {
						if (arr[newR][newC] == 1) {
							search(newR, newC, cost + 1);
						}
					}
				}
			}
		}
	}
}
