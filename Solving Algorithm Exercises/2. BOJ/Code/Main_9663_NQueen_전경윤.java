package BAEKJOON;

import java.util.Scanner;

public class Main_9663_NQueen_전경윤 {
	static int N, Result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Result = 0;
		method(0, 0, 0, 0, 0, 0);
		System.out.println(Result);
	}

	private static void method(int queen, int r, int rFlag, int cFlag, int leftTopFlag, int rightTopFlag) {
		if (queen == N) {
			Result++;
			return;
		}

		int i = r;
		for (int j = 0; j < N; j++) {
			if (((rFlag & (1 << i)) + (cFlag & (1 << j)) + (leftTopFlag & (1 << (j - i + N - 1)))
					+ (rightTopFlag & (1 << (i + j)))) > 0)
				continue;
			method(queen + 1, i + 1, (rFlag | (1 << i)), (cFlag | (1 << j)), (leftTopFlag | (1 << (j - i + N - 1))),
					(rightTopFlag | (1 << (i + j))));
		}
	}

}
