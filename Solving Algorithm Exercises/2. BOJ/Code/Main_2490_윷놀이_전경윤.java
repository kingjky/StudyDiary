package ssafy.baekjoon.L1;

import java.util.Scanner;

public class Main_2490_À·³îÀÌ_Àü°æÀ± {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tk = 0; tk < 3; tk++) {
			int[] arr = new int[4];
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			switch(sum) {
			case 0:
				System.out.println("D");
				break;
			case 1:
				System.out.println("C");
				break;
			case 2:
				System.out.println("B");
				break;
			case 3:
				System.out.println("A");
				break;
			case 4:
				System.out.println("E");
				break;
			}
		}		
	}
}
