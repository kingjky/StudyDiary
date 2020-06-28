package day190817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1219_길찾기_황란아 {
	static int[][] Matrix;
	static int Result;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input_1219_길찾기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(in.readLine(), " ");
			int tc = Integer.parseInt(st.nextToken()); // testCase numbering
			int n = Integer.parseInt(st.nextToken()); // number of ways

			Matrix = new int[100][100];
			st = new StringTokenizer(in.readLine(), " ");
			// (x, y) 좌표를 입력받아 Matrix 배열에 1을 저장
			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(st.nextToken()); // x좌표
				int y = Integer.parseInt(st.nextToken()); // y좌표
				Matrix[x][y] = 1;
			}

			Result = 0; // 경로가 존재하지 않으면 0, 존재하면 1
			bfs(0); // 출발점 0

			System.out.println("#" + t + " " + Result);
		} // end-for

	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[100]; // 도시 방문여부

		int current = start;
		visited[current] = true;
		// System.out.print(current + "->");

		q.offer(current);

		while (!q.isEmpty()) {
			current = q.poll();
			for (int i = 0; i < 100; i++) {
				if (Matrix[current][i] == 1 && !visited[i]) {
					visited[i] = true;
					// System.out.print(i + "->");
					// 최종 도착점이 99인 경우, A->B 경로가 존재하므로 Result=1한 뒤, return
					if (i == 99) {
						Result = 1;
						// System.out.println();
						return;
					}
					q.offer(i);
				}
			}
		}
		// System.out.println();
	}
}
