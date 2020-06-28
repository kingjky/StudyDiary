package ssafy.baekjoon.L1;

import java.util.Scanner;

public class Main_2576_È¦¼ö_Àü°æÀ± {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[7];
		for (int i = 0; i < 7; i++) {
			arr[i] = sc.nextInt();
		}
		int sum=0;
		int min=101;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%2==1) {
				sum+=arr[i];
				if(min>arr[i])
					min = arr[i];
			}
		}
		if(sum==0)
			System.out.println("-1");
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
