package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2583_영역구하기_황란아 {
	static int N, M, K, CNT, SIZE;
	static int[][] picture;
	static boolean[][] visited;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int[] x_dir = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] y_dir = { 0, 0, -1, 1 }; // 상 하 좌 우

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int xStart = 0, yStart = 0, xEnd = 0, yEnd = 0;

		picture = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			xStart = Integer.parseInt(st.nextToken());
			yStart = Integer.parseInt(st.nextToken());
			xEnd = Integer.parseInt(st.nextToken());
			yEnd = Integer.parseInt(st.nextToken());

			for (int r = yStart; r < yEnd; r++) {
				for (int c = xStart; c < xEnd; c++) {
					picture[r][c] = 1;
				}
			}
		}

		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c] && picture[r][c] == 0) {
					SIZE = 1;
					dfs(r, c);
					CNT++;
					list.add(SIZE);

				}
			}
		}

		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (Integer li : list) {
			sb.append(li + " ");
		}
		System.out.println(CNT);
		if (SIZE > 0) {

			System.out.println(sb);
		} else
			System.out.println(0);

	}

	static void dfs(int rStart, int cStart) {
		visited[rStart][cStart] = true;

		for (int i = 0; i < 4; i++) {
			int rNew = rStart + x_dir[i];
			int cNew = cStart + y_dir[i];
			if (rNew >= 0 && rNew < M && cNew >= 0 && cNew < N) {
				if (picture[rNew][cNew] == 0 && !visited[rNew][cNew]) {
					SIZE++;
					dfs(rNew, cNew);

				}
			}
		}

	}

}
