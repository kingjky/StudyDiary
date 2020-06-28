package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Baekjoon
 *	00:08:22
 *	M : 12944 KB
 *	T : 80 ms
 */
public class Main_2563_색종이_전경윤 {
	static int[][] map;
	static final int D = 100;
	static final int S = 10;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[D][D];
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int x, y;
			String[] str = br.readLine().split(" ");
			x = Integer.parseInt(str[0]);
			y = Integer.parseInt(str[1]);
			for (int j = x; j < x+S; j++) {
				for (int k = y; k < y+S; k++) {
					map[j][k] = 1;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < D; j++) {
				sum+=map[i][j];
			}
		}
		System.out.println(sum);
	}

}
