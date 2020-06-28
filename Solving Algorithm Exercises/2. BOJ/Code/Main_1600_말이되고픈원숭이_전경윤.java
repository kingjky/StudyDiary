package day1112.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/* 
 * 시뮬레이션, DFS/BFS, 
 * 92220 KB
 * 544 ms
 */
public class Main_1600_말이되고픈원숭이_전경윤 {

	private static int K;
	private static int W;
	private static int H;
	private static int[][] map;
	private static int[][][] visit;
	static int[] dR = {1, 2, 2, 1, -1, -2, -2, -1, 0, 1, 0, -1}
				,dC = {2, 1, -1, -2, -2, -1, 1, 2, 1, 0, -1, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visit = new int[H][W][K+1];
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				Arrays.fill(visit[h][w], Integer.MAX_VALUE-10);
			}
		}
		for (int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			for (int w = 0; w < W; w++) {
				map[h][w] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { 0,0,0, 0});
		for (int k = 0; k <= K; k++) {
			visit[0][0][k] = -1;
		}
		boolean find = false;
		while(!que.isEmpty()) {
			int[] loc = que.poll();
			int r = loc[0];
			int c = loc[1];
			if(r==H-1 && c==W-1) find = true;
			int t = loc[2];
			int k = loc[3];
			int newR, newC;
			for (int i = k>=K?8:0; i < 12; i++) {
				newR = r + dR[i];
				newC = c + dC[i];
				if(newR<0 || newR>=H || newC<0 || newC>=W) continue;
				int tmp = (i<8)?1:0;
				if(map[newR][newC]<1 && visit[newR][newC][k+tmp]>t+1) {
					visit[newR][newC][k+tmp] = t+1;
					que.offer(new int[] {newR, newC, t+1, k+tmp});
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int k = 0; k <= K; k++) {
			if(min > visit[H-1][W-1][k])
				min = visit[H-1][W-1][k];
		}
		if(find)
			System.out.println(min);
		else 
			System.out.println(-1);
	}

}
