package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/* ployed warshall*/
public class Main_2606_바이러스_전경윤2 {
	static int arr[][], N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[r][c] = arr[c][r] = 1;
		}
		for (int k = 1; k <= N; k++) {
			for (int j = 1; j <= N; j++) {
				if(k==j) continue;
				for (int i = 1; i <= N; i++) {
					if(j==i || k==i) continue;
					if(arr[i][k] > 0 && arr[k][j] > 0) {
						arr[i][j] = arr[j][i] = 1;
					}
				}
			}
		}
		int sum = 0;
		for (int i : arr[1]) sum += i;
		System.out.println(sum);
	}
}
