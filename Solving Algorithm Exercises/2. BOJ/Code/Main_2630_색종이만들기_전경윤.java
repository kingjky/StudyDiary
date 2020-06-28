package com.ssafy.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기_전경윤 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[][] arr = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				if (Integer.parseInt(st.nextToken()) == 1)
					arr[i][j] = true;
		}

		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] { 0, 0, -1 });
		int white = 0, blue = 0;
		boolean flag = true;
		do {
			flag = true;
			outer: for (int k = 0, end = list.size(); k < end; k++) {
				int[] is = list.get(k);
				if (is[2] < 0) {
					boolean b = arr[is[0]][is[1]];
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							if (arr[is[0] + i][is[1] + j] != b) {
								flag = false;
								list.add(new int[] { is[0], is[1] + N / 2, -1 });
								list.add(new int[] { is[0] + N / 2, is[1], -1 });
								list.add(new int[] { is[0] + N / 2, is[1] + N / 2, -1 });
								continue outer;
							}
						}
					}
					is[2] = N;
					if (arr[is[0]][is[1]]) blue++;
					else white++;
				}
			}
			N /= 2;

		} while (!flag && N >= 1);

		System.out.println(white);
		System.out.println(blue);
	}
}
