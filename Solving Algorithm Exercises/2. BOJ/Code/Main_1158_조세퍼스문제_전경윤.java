package baekjoon;
import java.util.Scanner;

public class Main_1158_조세퍼스문제_전경윤 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // �ο� �� N (1<=N<=5000)
		int K = sc.nextInt(); // ���� ���� K(1<=K<=N)
		// end of Input

		// start of Algorithm
		int[] arr = new int[N];
		int[] answer = new int[N];

		int cursor = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= K;) {
				if (arr[cursor % N] == 0) {
					if (j == K) {
						answer[i] = (cursor % N) + 1;
						arr[cursor % N] = 1;
					}
					j++;
				}
				cursor++;
			}
		}

		System.out.print("<");
		for (int i = 0; i < N; i++) {
			if (i == N - 1)
				System.out.print(answer[i] + ">");
			else
				System.out.print(answer[i] + ", ");
		}
	}
}
