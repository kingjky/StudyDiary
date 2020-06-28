package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JKY
 * 01:00:00
 * M : 50272 KB
 * T : 416 ms
 */
public class Main_1926_그림_전경윤 {
	static class point {
		int r, c;

		public point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "[" + r + ", " + c + "]";
		}

	}

	static int[] pR = { 0, 1, 0, -1 };
	static int[] pC = { 1, 0, -1, 0 };
	static int[][] arr;
	static boolean[][] visit;
	static int N, M;
	static Queue<point> que = new LinkedList<point>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		arr = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		// end of input
		int max = 0, count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && arr[i][j] == 1) {
					visit[i][j] = true;
					que.offer(new point(i,j));
					int temp = check(1);
					max = (max < temp) ? temp : max;
					count++;
				}
			}
		}
		System.out.println(count);
		System.out.println(max);
	}

	static int check(int size) {
		int r,c;
		int newR, newC;
		do {
			point p = que.poll();
			r = p.r;
			c = p.c;
			for (int i = 0; i < 4; i++) {
				newR = r + pR[i];
				newC = c + pC[i];
				if (newR < 0 || newR >= N || newC < 0 || newC >= M)
					continue;
				if (!visit[newR][newC] && arr[newR][newC] == 1) {
					visit[newR][newC] = true;
					size++;
					que.offer(new point(newR, newC));
				}
			}
		} while (!que.isEmpty());
		return size;
	}
}
