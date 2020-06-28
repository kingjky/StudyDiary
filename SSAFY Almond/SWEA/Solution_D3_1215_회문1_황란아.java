package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_1215_회문1_황란아 {

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input_1215.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int result = 0;
			int N = Integer.parseInt(in.readLine());
			char[][] pan = new char[8][8];
			for (int r = 0; r < 8; r++) {
				pan[r] = in.readLine().toCharArray();
			}
			for (int c = 0; c < 8; c++) {
				for (int r = 0; r <= 8 - N; r++) {
					int start = r, end = r + N - 1;
					while (start < end) {
						if (pan[start][c] != pan[end][c])
							break;
						else {
							start++;
							end--;
						}
					}
					if (start >= end)
						result++;
				}
			}
			for (int r = 0; r < 8; r++) {
				for (int c = 0; c <= 8 - N; c++) {
					int start = c, end = c + N - 1;
					while (start < end) {
						if (pan[r][start] != pan[r][end])
							break;
						else {
							start++;
							end--;
						}
					}
					if (start >= end)
						result++;
				}
			}
			System.out.println("#" + t + " " + result);
		}

	}

}
