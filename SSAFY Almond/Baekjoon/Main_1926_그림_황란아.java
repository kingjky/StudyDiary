package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1926_그림_황란아 {
	static int N, M, CNT, SIZE;
	static int[][] picture;
	static boolean[][] visited;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int[] x_dir = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] y_dir = { 0, 0, -1, 1 }; // 상 하 좌 우

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		picture = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			{
				for (int j = 0; j < M; j++)
					picture[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!visited[r][c] && picture[r][c] == 1) {
					SIZE = 1;
					dfs(r, c);
					CNT++;
					list.add(SIZE);

				}
			}
		}

		System.out.println(CNT);
		if (SIZE > 0)
			System.out.println(Collections.max(list));
		else
			System.out.println(0);

	}

	static void dfs(int rStart, int cStart) {
		visited[rStart][cStart] = true;

		for (int i = 0; i < 4; i++) {
			int rNew = rStart + x_dir[i];
			int cNew = cStart + y_dir[i];
			if (rNew >= 0 && rNew < N && cNew >= 0 && cNew < M) {
				if (picture[rNew][cNew] == 1 && !visited[rNew][cNew]) {
					SIZE++;
					dfs(rNew, cNew);

				}
			}
		}

	}

}
