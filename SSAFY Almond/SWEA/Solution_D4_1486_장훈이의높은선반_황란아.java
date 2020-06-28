package day190817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1486_장훈이의높은선반_황란아 {

	static int[] height;
	static int N, B, MIN;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			height = new int[N];
			B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine(), " ");
			MIN = 0;
			for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
				MIN += height[i];
			}
			subSetSum(0, 0);
			System.out.println("#" + t + " " + (MIN - B));
		}
	}

	public static void subSetSum(int index, int sum) {
		if (sum >= B) {
			if (sum < MIN)
				MIN = sum;
			return;
		}
		if (index == N) {
			return;
		}
		// 선택
		subSetSum(index + 1, sum + height[index]);
		// 비선택
		subSetSum(index + 1, sum);
	}
}