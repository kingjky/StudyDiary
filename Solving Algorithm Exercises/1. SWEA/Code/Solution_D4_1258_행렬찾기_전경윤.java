package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1258_행렬찾기_전경윤 {
	static int N, arr[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] rows = new int[N + 1];
			boolean flag = false;
			int length = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[j][i] > 0) {
						if (flag) {
							length++;
						} else {
							flag = true;
							length++;
						}
						if (j == N - 1) {
							flag = false;
							rows[length]++;
							length = 0;
						}
					} else {
						if (flag) {
							flag = false;
							rows[length]++;
							length = 0;
						}
					}
				}
			}

			System.out.printf("#%d ", t);
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (rows[i] > 0)
					count++;
			}

			System.out.printf("%d ", count);
			
			int min = Integer.MAX_VALUE, minIndex = -1;
			for (int c = 0; c < count; c++) {
				for (int i = 0; i < N; i++) {
					if (rows[i] == 0)
						continue;
					else {
						int multiple = rows[i] * i;
						if (min > multiple) {
							min = multiple;
							minIndex = i;
						}
					}
				}
				System.out.printf("%d %d ", minIndex, rows[minIndex]);
				rows[minIndex]=0;
				min = Integer.MAX_VALUE;
			}
			System.out.println();
		} // end of TC
	}
}
