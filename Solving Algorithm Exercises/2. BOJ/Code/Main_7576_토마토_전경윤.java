package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * M : 122820 KB
 * T : 604 ms
 */
public class Main_7576_토마토_전경윤 {
	static Queue<int[]> tomatos;
	static boolean[][] visit;
	static int[][] arr;
	static int M, N, count;
	static int[] dR = {0, 1, 0, -1}, dC = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		tomatos = new LinkedList<>();
		count = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
				if(arr[n][m] == 0) count++;
				else if(arr[n][m] == 1) tomatos.add(new int[] {n,m}); 
			}
		}
		
		int days = 0;
		int before = count;
		visit = new boolean[N][M];
		while(count>0) {
			grow();
			if(count == before) {
				days = -1;
				break;
			} else before = count;
			days++;
		}
		System.out.println(days);
	}
	private static void grow() {
		int len = tomatos.size();
		for (int i = 0; i < len; i++) {
			int[] t = tomatos.poll();
			int r = t[0];
			int c = t[1];
				if(!visit[r][c] && arr[r][c] == 1) {
					visit[r][c] = true;
					int newR, newC;
					for (int k = 0; k < 4; k++) {
						newR = r + dR[k];
						newC = c + dC[k];
						if(newR<0 || newR>=N || newC<0 || newC>=M) continue;
						if(arr[newR][newC] == 0) {
							count--;
							arr[newR][newC] = 1;
							tomatos.offer(new int[] {newR,newC});
						}
					}
				}
		}
	}
}
