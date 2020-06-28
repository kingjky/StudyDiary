package ssafy.baekjoon.L2;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10808_¾ËÆÄºª°³¼ö_Àü°æÀ± {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		int[] arr = new int[26];

		char[] str = s.toCharArray();

		for (int i = 0; i < str.length; i++) {
			arr[(str[i] - 97)]++;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}