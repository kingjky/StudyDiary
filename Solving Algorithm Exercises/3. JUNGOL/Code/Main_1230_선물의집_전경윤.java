package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * JungOl
 *	00:34:44
 *	M : 9 MB
 *	T : 1689 ms
 */
public class Main_1230_선물의집_전경윤 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] dR = { 0, 1, 0, -1 };
	static int[] dC = { 1, 0, -1, 0 };
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		// end of Input

		// start of Algorithm
		visit = new boolean[N][N];
		visit[0][0] = true;
		dfs(0, 0, 0);

		System.out.println(max);
	}

	static void dfs(int r, int c, int n) {
		int newR, newC;
		int way = 0;
		int sum = n;
		if (map[r][c] == 2)
			sum++;
		for (int i = 0; i < 4; i++) {
			newR = r + dR[i];
			newC = c + dC[i];
			if (newR >= 0 && newR < N && newC >= 0 && newC < N && !visit[newR][newC] && map[newR][newC] != 1) {
				way++;
				visit[newR][newC] = true;
				dfs(newR, newC, sum);
				visit[newR][newC] = false;
			}
		}
		if ((r == N - 1) && (c == N - 1)) {
			if (max < sum) {
				max = sum;
			}
		} else {
			if (way == 0)
				return;
		}
	}

}
