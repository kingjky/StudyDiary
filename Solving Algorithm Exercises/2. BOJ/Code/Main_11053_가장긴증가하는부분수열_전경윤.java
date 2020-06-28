package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 13396 kb
 * 96 ms
 */
public class Main_11053_가장긴증가하는부분수열_전경윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] memo = new int[N] , arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.fill(memo, 1);
		int result = 1;
		for (int i = 1; i < N; i++) {
			int max = -1;
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j])
					max = Math.max(memo[j], max);
			}
			memo[i] = max>0?max+1:1;
			if(result<memo[i]) result = memo[i];
		}
		System.out.println(result);
	}
}
