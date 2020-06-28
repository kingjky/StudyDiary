package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class XMain_17135_캐슬디펜스_전경윤 {
	static int N, M, D, Result, Max, bow[], dR[] = { 0, -1, 0 }, dC[] = { -1, 0, 1 }; // 좌 상 우
	static Queue<int[]> que;
	static boolean map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		map = new boolean[N][M];
		int tmp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp = sc.nextInt();
				if (tmp == 1)
					map[i][j] = true;
				else
					map[i][j] = false;
			}
		} // end of input

		bow = new int[M];
		Result = 0;
		Max = -1;
		que = new LinkedList<>();
		for (int i = 1; i <= 3; i++)
			bow[M - i] = 1;

		do {
			Result = 0;
			while (cal()) { // 적이 남아 있는지 확인
				for (int i = 0; i < M; i++) { // 가까운 적 찾기
					if (bow[i] == 1) {
						BFS(i);
					}
				}

				while (!que.isEmpty()) { // 적 죽이기
					int[] enemy = que.poll();
					if (map[enemy[0]][enemy[1]]) {
						Result++;
						map[enemy[0]][enemy[1]] = false;
					}
				}

				for (int i = N - 1; i >= 0; i--) { // 적 1 칸씩 이동시키기
					for (int j = 0; j < M; j++) {
						if (map[i][j]) {
							map[i][j] = false;
							if (i + 1 < N) {
								map[i + 1][j] = true;
							}
						}
					}
				}
			}

			if (Result > Max)
				Max = Result;

		} while (nextPer());

		System.out.println(Max);
	}

	private static boolean cal() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j])
					return true;
			}
		}
		return false;
	}

	private static void BFS(int i) {
		Queue<int[]> bfsQue = new LinkedList<>(); // r, c
		boolean visit[][] = new boolean[N][M];
		bfsQue.offer(new int[] { N, i });
		int cnt = 0;
		outer: while (cnt < D && !bfsQue.isEmpty()) {
			int[] cur = bfsQue.poll();
			int newR, newC;
			for (int k = 0; k < 3; k++) {
				newR = cur[0] + dR[k];
				newC = cur[1] + dC[k];
				if (newR < 0 || newR >= N || newC < 0 || newC >= M)
					continue;
				if (map[newR][newC]) {
					que.offer(new int[] { newR, newC });
					break outer;
				} else {
					visit[newR][newC] = true;
					bfsQue.offer(new int[] { newR, newC });
				}
			}
			cnt++;
		}
	}

	private static boolean nextPer() {
		int i, j;
		i = j = M - 1;
		while (i > 0) {
			if (bow[i - 1] < bow[i])
				break;
			i--;
		}
		if (i == 0)
			return false;

		while (bow[j] <= bow[i - 1])
			j--;
		swap(i - 1, j);

		j = M - 1;
		while (i < j) {
			swap(i++, j--);
		}

		return true;
	}

	private static void swap(int i, int j) {
		int tmp = bow[i];
		bow[i] = bow[j];
		bow[j] = tmp;
	}

}
