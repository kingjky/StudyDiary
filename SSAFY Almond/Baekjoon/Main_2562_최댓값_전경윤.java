package ssafy.baekjoon.L1;

import java.util.Scanner;

public class Main_2562_�ִ�_������ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		int max = -1;
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}		
		System.out.println(max);
		System.out.println(index+1);
	}
}
