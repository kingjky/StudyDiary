package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_전경윤 {
	static int N, arr[][];
	static boolean check[];
	static int dR[] = { 0, 1, 0, -1 }, dC[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			check = new boolean[N * N + 1];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int newR, newC;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cur = arr[i][j];
					for (int k = 0; k < 4; k++) {
						newR = i + dR[k];
						newC = j + dC[k];
						if (newR >= 0 && newR < N && newC >= 0 && newC < N) {
							if (arr[newR][newC] == (cur + 1)) {
								check[cur] = true;
								break;
							}
						}
					}
				}
			}
			
			boolean flag = false;
			int length = 0, max = -1, curIndex = 0, maxIndex = 0;
			for (int i = 1, size = check.length; i < size; i++) {
				if(check[i]) {
					if(flag) {
						length++;
					} else {
						curIndex = i;
						flag = true;
						length++;
					}
				} else {
					if(flag) {
						length++;
						flag = false;
						if(length > max) {
							max = length;
							maxIndex = curIndex;
						}
						length = 0;
					}
				}
			}
			
			System.out.printf("#%d %d %d\n", t, maxIndex, max);
		} // end of TC
	}

}
