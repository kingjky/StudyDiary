package ssafy.baekjoon.L1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10804_카드역배치_전경윤 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] card = new int[20];

		for (int i = 0; i < 20; i++)
			card[i] = i + 1;

		for (int i = 0; i < 10; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			reverse(a-1, b-1, card);
		}
		for (int i = 0; i < 20; i++)
			System.out.print(card[i] + " ");
	}

	public static void reverse(int a, int b, int[] arr) {
		int tmp;
		while(b>a) {
			tmp = arr[a];
			arr[a] = arr[b];
			arr[b] = tmp;
			a++;
			b--;
		}
	}
}