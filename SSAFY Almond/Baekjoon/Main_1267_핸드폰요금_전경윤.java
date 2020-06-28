package ssafy.baekjoon.L1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1267_핸드폰요금_전경윤 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			arr[i]++;
		}
		int Y = cal_Y(arr);
		int M = cal_M(arr);

		if (Y < M)
			System.out.println("Y " + Y);
		else if (Y > M)
			System.out.println("M " + M);
		else
			System.out.println("Y M " + M);

	}

	public static int cal_Y(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += (arr[i] / 30) * 10;
			if (arr[i] % 30 != 0)
				sum += 10;
		}
		return sum;
	}

	public static int cal_M(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += (arr[i] / 60) * 15;
			if (arr[i] % 60 != 0)
				sum += 15;
		}
		return sum;
	}
}