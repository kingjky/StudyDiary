package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9466_텀프로젝트_전경윤 {
	static int N, arr[];
	static boolean visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			visit = new boolean[N+1];
			st = new StringTokenizer(br.readLine());
			int cnt = 0;
			for (int n = 1; n <= N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			for (int n = 1; n <= N; n++) {
				if(!visit[n]) find(n);
			}
			for (int n = 1; n <= N; n++) {
				if(arr[n]<0) cnt++;
			}
			System.out.println(cnt);
		}
	}
	
	private static boolean find(int n) {
		if(!visit[n]) {
			visit[n] = true;
			if(find(arr[n])) {
				if(arr[n] == n) {
					return false;
				} else {
					arr[n] = n;
					return true;
				}
			} else {
				if(arr[n] != n)
					arr[n] = -1;
				return false;
			}
		} else {
			if(arr[n] == n || arr[n] < 0) {
				return false;
			} else {
				arr[n] = n;
				return true;
			}
		}
	}
}
