package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * M : 124116 KB
 * T : 636 ms
 */
public class Main_7569_토마토_전경윤 {
	static int M, N, H, Count;
			// C, R, H
	//위, 아래, 좌, 우, 앞, 뒤
	static int[] dR = {0, 0, 0, 0, -1, 1} 
				,dC = {0, 0, -1, 1, 0, 0}
				,dH = {-1, 1, 0, 0, 0, 0};
	static boolean[][][] visit;
	static Queue<int[]> que;
	private static int[][][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		visit = new boolean[H][N][M];
		que = new LinkedList<int[]>();
		
		int tmp;
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					tmp = map[h][n][m] = Integer.parseInt(st.nextToken());
					if(tmp == 1)
						que.offer(new int[] {h,n,m});
					else if(tmp == 0)
						Count++;
				}
			}
		}
		int days = 0;
		int before = Count;
		while(Count>0) {
			for(int i=0, len=que.size(); i< len; i++) {
				int[] t = que.poll();
				int h = t[0], r = t[1], c = t[2];
				int newH, newR, newC;
				for (int k = 0; k < 6; k++) {
					newH = h + dH[k];
					newR = r + dR[k];
					newC = c + dC[k];
					if(newH<0 || newH>=H || newR<0 || newR>=N || newC<0 || newC>=M) continue;
					if(!visit[newH][newR][newC] && map[newH][newR][newC]==0) {
						visit[newH][newR][newC] = true;
						map[newH][newR][newC]++;
						que.offer(new int[] {newH,newR,newC});
						Count--;
					}
				}
			}
			if(before == Count) {
				days = -1;
				break;
			} before = Count;
			days++;
		}
		System.out.println(days);
	}
}
