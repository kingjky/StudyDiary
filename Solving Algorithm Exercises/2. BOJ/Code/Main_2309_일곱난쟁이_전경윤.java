package ssafy.baekjoon.L1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2309_ÀÏ°ö³­ÀïÀÌ_Àü°æÀ± {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		int i1 = 0, i2 = 0;
		first: for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (sum - arr[i] - arr[j] == 100) {
					i1 = i;
					i2 = j;
					break first;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if(i!=i1 && i!=i2)
			System.out.println(arr[i]);
		}
	}

}