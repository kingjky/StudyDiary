package com.ssafy.hw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class Solution_D4_4366_정식이의은행업무_전경윤 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 1; t <= T; t++) {
			String num2 = sc.nextLine();
			String num3 = sc.nextLine();
			int[] nums2, nums3;
			nums2 = new int[num2.length()];
			nums3 = new int[num3.length()];

			for (int i = 0, end = nums2.length; i < end ; i++) {
				nums2[i] = (num2.charAt(end-1-i)) - '0';
			}
			for (int i = 0, end = nums3.length; i < end; i++) {
				nums3[i] = (num3.charAt(end-1-i)) - '0';
			}

			HashSet<Integer> set3 = new HashSet<>();

			for (int i = 0, end = nums3.length; i < end; i++) {
				for (int j = 0; j < 2; j++) {
					switch (nums3[i]) {
					case 0:
						nums3[i] = 1;
						break;
					case 1:
						nums3[i] = 2;
						break;
					case 2:
						nums3[i] = 0;
						break;
					}
					set3.add(cal3(nums3));
				}
				switch (nums3[i]) {
				case 0:
					nums3[i] = 1;
					break;
				case 1:
					nums3[i] = 2;
					break;
				case 2:
					nums3[i] = 0;
					break;
				}
			}
			int result = -1;
			for (int i = 0, end = nums2.length; i < end; i++) {
				switch (nums2[i]) {
				case 0:
					nums2[i] = 1;
					break;
				case 1:
					nums2[i] = 0;
					break;
				}
				int temp = cal2(nums2);
				if(set3.contains(temp)){
					result = temp;
					break;
				}
				
				switch (nums2[i]) {
				case 0:
					nums2[i] = 1;
					break;
				case 1:
					nums2[i] = 0;
					break;
				}
			}
			
			System.out.printf("#%d %d\n", t, result);
		}
	}

	private static int cal2(int[] arr) {
		int result = 0;
		int temp = 1;
		for (int i : arr) {
			result += i * temp;
			temp *= 2;
		}
		return result;
	}

	private static int cal3(int[] arr) {
		int result = 0;
		int temp = 1;
		for (int i : arr) {
			result += i * temp;
			temp *= 3;
		}
		return result;
	}
}
