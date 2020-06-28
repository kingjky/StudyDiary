package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 10MB	1785ms	
 */
public class Main_1230_선물의집_이병훈 {
	static int N, max;
	static int map[][];
	static int dir[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static boolean visited[][];
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
//				if (map[i][j] == 1)
//					visited[i][j] = true;
			}
		}

		visited[0][0] = true;
		if (map[0][0] == 2) {
			dfs(0, 0, 1);
		} else {
			dfs(0, 0, 0);
		}

		System.out.println(max);
	}

	private static void dfs(int x, int y, int count) {
		int dx, dy;

		if (x == N - 1 && y == N - 1) {
			if (max < count)
				max = count;
		}

		for (int i = 0, len = dir.length; i < len; ++i) {
			dx = x + dir[i][0];
			dy = y + dir[i][1];
			if (dx >= 0 & dx < N & dy >= 0 && dy < N 
					&& !visited[dx][dy] && map[dx][dy] != 1) {
				visited[dx][dy] = true;
				
				if (map[dx][dy] == 2) dfs(dx, dy, count + 1);
				else dfs(dx, dy, count);
				
				visited[dx][dy] = false;
			}

		}
	}
}
