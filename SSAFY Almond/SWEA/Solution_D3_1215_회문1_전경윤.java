package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author JKY
 * 00:23:45
 * M : 19388 KB
 * T : 113 ms
 */
public class Solution_D3_1215_회문1_전경윤 {
	static char[][] arr;
	static int N;
	static int[] pR = { 0, 1 };
	static int[] pC = { 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[8][];
			int[][] ck = new int[8][8];
			for (int i = 0; i < 8; i++) {
				arr[i] = br.readLine().toCharArray();
			} // end of input

			int sum = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (j <= 8 - N) {
						sum += palindrome(i, j, 0) ? 1 : 0;
					}
					if (i <= 8 - N) {
						sum += palindrome(i, j, 1) ? 1 : 0;
					}
				}
			}

			
			/*
			 * for (int i = 0; i < 8; i++) { for (int j = 0; j < 8; j++) {
			 * System.out.print(ck[i][j] + " "); } System.out.println(); }
			 */	 

			System.out.println("#" + t + " " + sum);
		} // end of test case
	}

	static boolean palindrome(int i, int j, int d) {
		Stack<Character> stack = new Stack<Character>();
		for (int k = 0, half = N / 2; k < N; k++) {
			if (k < half)
				stack.add(arr[i + (k * pR[d])][j + (k * pC[d])]);
			else if (k >= half) {
				if (k == half && N % 2 != 0)
					continue;
				else {
					if (stack.pop() != arr[i + (k * pR[d])][j + (k * pC[d])])
						return false;
				}
			}
		}

		return true;
	}
}
