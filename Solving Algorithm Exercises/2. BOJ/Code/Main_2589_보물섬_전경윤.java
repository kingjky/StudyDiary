package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_보물섬_전경윤 {
	static int map[][], max;
	static int[] dR= {0,1,0,-1}, dC= {1,0,-1,0};
	private static int N;
	private static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		String input;
		for (int n = 0; n < N; n++) {
			input = br.readLine();
			for (int m = 0; m < M; m++)	// 0:바다 1:육지
				map[n][m] = (input.charAt(m)=='W')?0:1;
		}
		max = -1;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if(map[n][m]>0) go(n,m);
			}
		}
		System.out.println(max);
	}
	private static void go(int n, int m) {
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {n, m, 0});
		visit[n][m] = true;
		while(!que.isEmpty()) {
			int[] loc = que.poll();
			int r = loc[0], c = loc[1], t = loc[2];
			if(t > max)
				max = t;
			int newR, newC;
			for (int k = 0; k < 4; k++) {
				newR = r+dR[k];
				newC = c+dC[k];
				if(newR<0 || newR>=N ||newC<0 || newC>=M) continue;
				if(!visit[newR][newC] && map[newR][newC]>0) {
					visit[newR][newC] = true;
					que.offer(new int[] {newR, newC, t+1});
				}
			}
		}
	}
}