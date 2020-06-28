package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농배추_전경윤 {
	static int M, N, K, dR[] = {0, 1, 0, -1}, dC[] = {1, 0, -1, 0};
	static boolean visit[][], map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int c, r;
			map = new boolean[N][M];
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				c = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				map[r][c] = true;
			}
			visit = new boolean[N][M];
			int cnt = 0;
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if(map[n][m] && !visit[n][m]) {
						go(n,m);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	private static void go(int n, int m) {
		int newR, newC;
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {n,m});
		visit[n][m] = true;
		while(!que.isEmpty()) {
			int[] loc = que.poll();
			int r = loc[0];
			int c = loc[1];
			for (int k = 0; k < 4; k++) {
				newR = r + dR[k];
				newC = c + dC[k];
				
				if(newR<0 || newR>=N || newC<0 || newC>=M) continue;
				if(map[newR][newC] && !visit[newR][newC]) { 
					visit[newR][newC] = true;
					que.offer(new int[] {newR, newC});
				}
			}
		}
	}

}
