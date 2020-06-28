package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_2247_도서관_전경윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]!=o2[0]) return Integer.compare(o1[0], o2[0]);
				return Integer.compare(o1[1], o2[1]);
			}
		});
		int maxIn=-1, maxEmpty=-1, S=arr[0][0], E=arr[0][1];
		for (int i = 1; i < N; i++) {
			if(arr[i][0] <= E) {
				E = arr[i][1]>E?arr[i][1]:E;
			} else {
				int time = E-S;
				if(time>maxIn)maxIn = time;
				time = arr[i][0] - E;
				if(time>maxEmpty)maxEmpty = time;
				S=arr[i][0];
				E=arr[i][1];
			}
		}
		int time = E-S;
		if(time>maxIn)maxIn = time;
		System.out.printf("%d %d\n",maxIn, maxEmpty);
	}

}
