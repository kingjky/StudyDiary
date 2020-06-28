package ssafy.baekjoon.L2;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10807_개수세기_전경윤 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int v = sc.nextInt();
		int count=0;
		for (int i = 0; i < arr.length; i++) {
			if(v==arr[i])
				count++;
		}
		System.out.println(count);
	}
}