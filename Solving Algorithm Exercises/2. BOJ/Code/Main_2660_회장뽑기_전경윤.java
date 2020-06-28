package baekjoon;

import java.util.Scanner;

/**
 * 99:99:99
 * M : 14480 kb
 * T : 112 ms
 *
 */
public class Main_2660_회장뽑기_전경윤 {
	static int N, relation[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		relation = new int[N][N];

		int a = 0, b = 0;
		while (true) {
			a = sc.nextInt() - 1;
			b = sc.nextInt() - 1;
			if (a == -2)
				break;
			relation[a][b] = 1;
			relation[b][a] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (relation[i][j] > 0) {
					update(i, j);
				}
			}
		}

		int[] score = new int[N];

		for (int i = 0; i < N; i++) {
			int max = -1;
			for (int j = 0; j < N; j++) {
				if (relation[i][j] > max)
					max = relation[i][j];
			}
			score[i] = max;
		}

		int min = N + 1;
		for (int i = 0; i < N; i++) {
			if (score[i] < min)
				min = score[i];
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (score[i] == min) {
				count++;
			}
		}
		System.out.print(min + " ");
		System.out.println(count);
		for (int i = 0; i < N; i++) {
			if (score[i] == min) {
				System.out.print((i + 1) + " ");
			}
		}
		System.out.println();
	}

	private static void update(int cur, int friend) {
		for (int i = 0; i < N; i++) {
			if (cur == i)
				continue;
			if (relation[friend][i] > 0) {
				if ((relation[cur][i] == 0) || (relation[cur][i] > relation[friend][i] + relation[cur][friend])) {
					relation[cur][i] = relation[friend][i] + relation[cur][friend];
					relation[i][cur] = relation[friend][i] + relation[cur][friend];
				}
			}
		}
	}
}
