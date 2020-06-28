package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6603_로또_이병훈 {
	static int k, count;
	static boolean selected[];
	static int numbers[];
	static int s[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0)
				return;
			s = new int[k];
			selected = new boolean[k];
			numbers = new int[6];
			for (int i = 0; i < k; ++i) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			count = 0;
			combination(-1, 0);
			System.out.println();

		}
	}

	private static void combination(int before, int index) {

		if (index >= 6) {
			for(int i: numbers) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for (int i = before + 1; i < k; ++i) {
			numbers[index] = s[i];
			combination(i, index + 1);
		}
	}
}
