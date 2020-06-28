package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_3109_빵집_전경윤 {
	static int R, C, arr[][], copy[][], result;
	static int dR[] = { -1, 0, 1 }, dC[] = { 1, 1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		str = br.readLine();
		R = Integer.parseInt(str.split(" ")[0]);
		C = Integer.parseInt(str.split(" ")[1]);

		arr = new int[R][C];

		for (int i = 0; i < R; i++) {
			str = br.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == '.')
					arr[i][j] = 0;
				else
					arr[i][j] = 2;
			}
		}

		result = 0;
		for (int k = 0; k < R; k++) {
			arr[k][0] = 1;
			if (DFS(k, 0)) {
				result++;
				continue;
			}
//			arr[k][0] = 0;
		}
		
		System.out.println(result);
	}

	private static boolean DFS(int r, int c) {
		if (c == C - 1)
			return true;
		int newR, newC;
		for (int i = 0; i < 3; i++) {
			newR = r + dR[i];
			newC = c + dC[i];
			if (newR >= 0 && newR < R && newC >= 0 && newC < C) {
				if (arr[newR][newC] > 0)
					continue;
				else {
					arr[newR][newC] = 1;
					if (DFS(newR, newC)) {
						return true;
					}
//					arr[newR][newC] = 0;
				}
			}
		}
		return false;
	}
}
