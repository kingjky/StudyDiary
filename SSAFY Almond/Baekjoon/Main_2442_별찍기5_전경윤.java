package ssafy.baekjoon.L1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2442_º°Âï±â5_Àü°æÀ± {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		draw(N);
	}
	
	public static void draw(int n) {
		int m = n*2-1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n+i; j++) {
				if(j>=n-i-1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}