package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 00:22:29
 * M : 33068 kb
 * T : 108 ms
 *
 */
public class Main_1463_1로만들기_전경윤 {
	static int[] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		memo = new int[X + 1];
		int count = check(X);
		System.out.println(count);
	}

	static int check(int x) {
		if (x == 1)
			return 0;
		if (memo[x] != 0) {
			return memo[x];
		} else {
			int a, b, c;
			a = b = c = Integer.MAX_VALUE;
			if (x % 3 == 0) {
				a = check(x / 3)+1;
			}
			if (x % 2 == 0) {
				b = check(x / 2)+1;
			}
			c = check(x - 1)+1;
			int min = Math.min(a, Math.min(b, c));
			memo[x] = min;
			return min;
		}
	}
}
