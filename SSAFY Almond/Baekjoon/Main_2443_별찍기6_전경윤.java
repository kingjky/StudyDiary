package ssafy.baekjoon.L1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2443_º°Âï±â6_Àü°æÀ± {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		draw(N);
	}
	
	public static void draw(int n) {
		int m = n*2-1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m-i; j++) {
				if(j>=i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}