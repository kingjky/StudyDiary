package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1244_D3_최대상금_전경윤 {
	static int[] arr;
	static int maxSum;
	static int size;
	static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			maxSum = -1;
			String s = br.readLine();
			char[] temp = s.split(" ")[0].toCharArray();
			size = temp.length;
			arr = new int[size];

			int i = 0;
			for (char c : temp)
				arr[i++] = c - '0';

			int N = Integer.parseInt(s.split(" ")[1]);

			make(N, 0);

			System.out.printf("#%d %d\n", t, maxSum);
		} // end of testcase
	}

	static int cal() {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			//sum += arr[i] * Math.pow(10, size - 1 - i);
			sum *= 10;
			sum += arr[i];
		}
		return sum;
	}

	static void make(int count, int bI) {
		if (count == 0) {
			int sum = cal();
			if (maxSum < sum)
				maxSum = sum;
			return;
		}

		for (int i = bI; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (i == j)
					continue;
				else {
					if (arr[i] != arr[j]) {
						swap(i, j);
						make(count - 1, i);
						swap(i, j);
					} else {
						make(count - 1, i);
					}
//					}
				}
			}
		}
	}

	static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
