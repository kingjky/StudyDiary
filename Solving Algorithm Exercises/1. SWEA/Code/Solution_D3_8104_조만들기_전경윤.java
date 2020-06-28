package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 00:24:41
 * M : 44996 kb
 * T : 281 ms
 *
 */
public class Solution_D3_8104_조만들기_전경윤 {
	static int N, K, score[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);

			score = new int[K];
			make();
			System.out.printf("#%d",t);
			for (int i : score) {
				System.out.printf(" %d", i);
			}
			System.out.println();
		}
	}

	private static void make() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				count = i * K + 1;
			} else {
				count = (i + 1) * K;
			}
			for (int j = 0; j < K; j++) {
				if (i % 2 == 0) {
					score[j] += count++;
				} else {
					score[j] += count--;
				}
			}
		}
	}

}
