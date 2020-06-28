package baekjoon;
import java.util.Scanner;

public class Main_1475_방번호_전경윤 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // �л� �� N
		int K = sc.nextInt(); // �� �� �ִ� �ο� �� K
		int[][] arr = new int[6][2]; // [�г�][����] �ο� ��
		for (int n = 0; n < N; n++) {
			int S = sc.nextInt();
			int Y = sc.nextInt() - 1;
			arr[Y][S]++;
		} // end of Input

//		System.out.println("�� ��");
//		for (int i = 0; i < 6; i++) {
//			for (int j = 0; j < 2; j++)
//				System.out.print(arr[i][j] + " ");
//			System.out.print(" " + (i + 1) + "�г�");
//			System.out.println();
//		}
//		System.out.println();
		// start of Algorithm
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				sum += (arr[i][j] / K);
				if ((arr[i][j] % K) != 0)
					sum += 1;
			}
		}
		System.out.println(sum);
	}
}
