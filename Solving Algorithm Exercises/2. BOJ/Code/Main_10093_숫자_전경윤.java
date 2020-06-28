package ssafy.baekjoon.L1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10093_¼ýÀÚ_Àü°æÀ± {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();

		if (A > B) {
			A = A + B;
			B = A - B;
			A = A - B;
		}

		long cha = B - A - 1;
		if (cha < 0)
			cha = 0;
		System.out.println(cha);
		for (long i = A + 1; i < B; i++) {
			System.out.print(i);

			System.out.print(" ");
		}
	}
}