package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606_바이러스_전경윤 {
	static int arr[][], N;
	static boolean virus[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		virus = new boolean[N+1];
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[r][c] = arr[c][r] = 1;
		}
		go(1);
		int cnt = -1; 
		for (boolean b : virus) if(b) cnt++;
		System.out.println(cnt);
	}
	private static void go(int n) {
		virus[n] = true;
		for (int i = 1; i <= N; i++) if(!virus[i] && arr[n][i]>0) go(i);
	}
}