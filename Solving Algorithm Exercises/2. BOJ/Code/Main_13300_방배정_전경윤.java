package baekjoon;
import java.util.Scanner;

public class Main_13300_방배정_전경윤 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // �� ��ȣ N (0<=N<=1,000,000)
		// end of Input

		// start of Algorithm
		int[] arr = new int[10];
		// N / 1 % 10 : 1�� �ڸ���
		// N / 10 % 10 : 10�� �ڸ���
		// N / 100 % 10 : 100�� �ڸ���
		if (N != 0) {
			for (int i = 0; i < 8; i++) {
				int k = (int) (N / Math.pow(10, i));
				if (k != 0)
					arr[(k % 10)]++;
			}
		}
		else
			arr[0]++;

//		System.out.println("6, 9 ó�� ��");
//		for (int i = 0; i < 10; i++)
//			System.out.print(arr[i] + " ");
//		System.out.println();

		if ((arr[6] + arr[9]) % 2 != 0)
			arr[(arr[6]>arr[9]) ? 9 : 6]++;
		
		arr[6] = (arr[6] + arr[9]) / 2;
		arr[9] = arr[6];
		

//		System.out.println("6, 9 ó�� ��");
//		for (int i = 0; i < 10; i++)
//			System.out.print(arr[i] + " ");
//		System.out.println();

		int max = -1;
		for (int i = 0; i < 10; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		System.out.println(max);
	}
}
