package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형_전경윤2 {
	static int N, input[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		int memo[]= new int[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++)
				input[j] = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < N; j++) {
				memo[j] += maxValue(i, j);
			}
			System.out.println();
		}
		
		int max = -1;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, memo[i]);
		}
		System.out.println(max);
	}

	private static int maxValue(int layer, int cur) {
		int tmp = N-layer-1;
		int start = cur-tmp<0?0:cur-tmp;
		int end = cur>layer?layer:cur;
		int max = -1;
		for (int i = start; i <= end; i++) {
			max = Math.max(max, input[i]);
		}
		return max;
	}
}
