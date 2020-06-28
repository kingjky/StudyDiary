package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912_연속합_전경윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			int cur = arr[i];
			int bef = arr[i-1];
			arr[i] = cur >= cur + bef ? cur : cur + bef;
		}
		int max = -(Integer.MAX_VALUE-1);
		for (int i = 0; i < N; i++)
			max = Math.max(max, arr[i]);
		System.out.println(max);
	}

}
