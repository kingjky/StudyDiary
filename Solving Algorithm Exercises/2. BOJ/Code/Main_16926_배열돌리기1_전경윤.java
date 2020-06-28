package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author JKY
 * 01:23:37
 * M : 43716 kb
 * T : 864 ms
 */
public class Main_16926_배열돌리기1_전경윤 {
	static int N, M, R;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of input

		int cycle = ((N + 1) / 2 < (M + 1) / 2) ? (N + 1) / 2 : (M + 1) / 2;
		for (int k = 0; k < R; k++) {
			for (int i = 0; i < cycle; i++) {
				int temp = arr[i][i];
				int r = 0 + i, c = 0 + i;
				while (c < M - i - 1) {
					arr[r][c] = arr[r][c + 1];
					c++;
				}
				r = 0 + i;
				c = M - i - 1;
				while (r < N - i - 1) {
					arr[r][c] = arr[r + 1][c];
					r++;
				}
				r = N - i - 1;
				c = M - i - 1;
				while (c > 0 + i) {
					arr[r][c] = arr[r][c - 1];
					c--;
				}
				r = N - i - 1;
				c = 0 + i;
				while (r > 0 + i) {
					if (r == 0 + i + 1)
						arr[r][c] = temp;
					else
						arr[r][c] = arr[r - 1][c];
					r--;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
