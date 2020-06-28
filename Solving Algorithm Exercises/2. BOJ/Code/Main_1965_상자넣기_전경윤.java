package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1965_상자넣기_전경윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int box[] = new int[N+1];
		int lis[] = new int[N+1];
		Arrays.fill(lis, Integer.MAX_VALUE);
		lis[0] = 0;
		for (int i = 1; i <= N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			box[i] = tmp;
			for (int j = lis.length-1; j >= 0; j--) {
				if(lis[j] < tmp) {
					lis[j+1] = tmp;
					break;
				}
			}
		}
		int len = 0;
		for (int j = lis.length-1; j >= 0; j--) {
			if(lis[j] < Integer.MAX_VALUE) {
				len = j;
				break;
			}
		}
		System.out.println(len);
	}

}
