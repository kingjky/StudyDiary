package BAEKJOON;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 00:13:52
 * M : 14180 kb
 * T : 108 ms
 *
 */
public class Main_2999_비밀이메일_전경윤 {
	static String msg;

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		msg = sc.nextLine();
		int size = msg.length();
		int C = 1, R = size;
		while (R > C) {
			C++;
			while (size % C != 0) {
				C++;
			}
			R = size / C;
		}
		
		char m[] = msg.toCharArray();
		char arr[][] = new char[C][R];
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				arr[i][j] = m[j + (R*i)];
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[j][i]);
			}
		}
		System.out.println();
	}
}
