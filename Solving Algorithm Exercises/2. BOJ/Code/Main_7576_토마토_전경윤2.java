package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7576_토마토_전경윤2 {
	static boolean[][] visit;
	static int[][] arr;
	static int M, N;
	static int[] dR = {0, 1, 0, -1}, dC = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		int days = 0;
		int cnt = -1, tmp;
		visit = new boolean[N][M];
		while(isZero()) {
			tmp = cntOne();
			if(cnt == tmp) {
				days = -1;
				break;
			} else cnt = tmp;
			grow();
			days++;
			
		}
		System.out.println(days);
	}
	private static int cntOne() {
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(arr[r][c]>0) {
					if(arr[r][c] == 1) arr[r][c]++;
					cnt++;
				}
			}
		}
		return cnt;
	}
	private static void grow() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(!visit[r][c] && arr[r][c] == 2) {
					visit[r][c] = true;
					int newR, newC;
					for (int k = 0; k < 4; k++) {
						newR = r + dR[k];
						newC = c + dC[k];
						if(newR<0 || newR>=N || newC<0 || newC>=M) continue;
						if(arr[newR][newC] == 0) {
							arr[newR][newC] = 1;
						}
					}
				}
			}
		}
	}
	private static boolean isZero() {
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if(arr[n][m] == 0) return true;
			}
		}
		return false;
	}

}
