package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * JungOl
 *	00:36:34
 *	M : 8 MB
 *	T : 88 ms
 *
 */
public class Main_1103_경비원_전경윤 {
	static int X, Y, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] Shops;
		int[] Me;
		String[] str = br.readLine().split(" ");
		X = Integer.parseInt(str[0]);
		Y = Integer.parseInt(str[1]);
		N = Integer.parseInt(br.readLine());
		Shops = new int[N][2];
		Me = new int[2];

		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			Shops[i][0] = Integer.parseInt(str[0]);
			Shops[i][1] = Integer.parseInt(str[1]);
		}
		str = br.readLine().split(" ");
		Me[0] = Integer.parseInt(str[0]);
		Me[1] = Integer.parseInt(str[1]);

		// end of input
		// 1: 북 2: 남 3: 서 4: 동

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += cal(Shops[i], Me);
		}
		System.out.println(sum);
	}

	private static int cal(int[] s, int[] m) {

		switch (m[0]) {
		case 1: // 북
			switch (s[0]) {
			case 1:
				return Math.abs(m[1] - s[1]);
			case 2:
				if (m[1] + s[1] <= X) {
					return m[1] + s[1] + Y;
				} else {
					return (2 * X) - (m[1] + s[1]) + Y;
				}
			case 3:
				return s[1] + m[1];
			case 4:
				return (X - m[1]) + s[1];
			}
			break;
		case 2: // 남
			switch (s[0]) {
			case 1:
				if (m[1] + s[1] <= X) {
					return m[1] + s[1] + Y;
				} else {
					return (2 * X) - (m[1] + s[1]) + Y;
				}
			case 2:
				return Math.abs(m[1] - s[1]);
			case 3:
				return (Y - s[1]) + m[1];
			case 4:
				return (X - m[1]) + (Y - s[1]);
			}
			break;
		case 3: // 서
			switch (s[0]) {
			case 1:
				return m[1] + s[1];
			case 2:
				return (Y - m[1]) + s[1];
			case 3:
				return Math.abs(m[1] - s[1]);
			case 4:
				if (m[1] + s[1] <= Y) {
					return m[1] + s[1] + X;
				} else {
					return (2 * Y) - (m[1] + s[1]) + X;
				}
			}
			break;
		case 4: // 동
			switch (s[0]) {
			case 1:
				return m[1] + (X - s[1]);
			case 2:
				return (X - s[1]) + (Y - m[1]);
			case 3:
				if (m[1] + s[1] <= Y) {
					return m[1] + s[1] + X;
				} else {
					return (2 * Y) - (m[1] + s[1]) + X;
				}
			case 4:
				return Math.abs(m[1] - s[1]);
			}
			break;
		}
		return -1;
	}

}
