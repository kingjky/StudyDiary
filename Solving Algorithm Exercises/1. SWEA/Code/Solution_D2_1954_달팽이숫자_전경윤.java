package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author JKY
 * 00:19:17
 * M : 18552 KB
 * T : 122 ms
 */
public class Solution_D2_1954_달팽이숫자_전경윤 {
	static int[] pR = { 0, 1, 0, -1 };
	static int[] pC = { 1, 0, -1, 0 };
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][N];

			make(N);

			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		} // end of test case
	}

	static void make(int N) {
		int r = 0, c = 0, direction = 0, count = 1, newR = 0, newC = 0;
		while (count <= (N * N)) {
			if (newR < 0 || newR >= N || newC < 0 || newC >= N || arr[newR][newC] != 0) {
				direction++;
			} else {
				r = newR;
				c = newC;
				arr[r][c] = count++;
			}
			newR = r + pR[direction % 4];
			newC = c + pC[direction % 4];
		}
	}
}
