package ssafy.baekjoon.L1;

import java.util.Scanner;

public class Main_2480_주사위세개_전경윤 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}

		int count = 0;
		int value = 0;
		int max = -1;

		for (int i = 0; i < 3; i++) {
			if (max < arr[i])
				max = arr[i];
			for (int j = 0; j < 3; j++)
				if ((i != j) && (arr[i] == arr[j])) {

					value = arr[i];
					count++;
				}
		}
		switch (count / 2) {
		case 0:
			System.out.println(max * 100);
			break;
		case 1:
			System.out.println(1000 + value * 100);
			break;
		case 3:
			System.out.println(10000 + value * 1000);
			break;
		default:
			System.out.println("망했습니다.");
		}
	}
}
