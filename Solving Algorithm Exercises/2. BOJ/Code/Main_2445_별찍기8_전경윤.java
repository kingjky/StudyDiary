package ssafy.baekjoon.L1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2445_º°Âï±â8_Àü°æÀ± {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		draw(N);
	}

	public static void draw(int n) {
		int m = n * 2 - 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n * 2; j++) {
				if (j < i || j >= 2 * n - i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		for (int i = n-1; i >= 1; i--) {
			for (int j = 0; j < n * 2; j++) {
				if (j < i || j >= 2 * n - i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}