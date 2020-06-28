package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2501_약수구하기_전경윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, K;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int r = 0, k = 0;
		for (int i = 1; i <= N; i++) {
			if(N%i==0) k++;
			if(k==K) {
				r = i;
				break;
			}
		}
		System.out.println(r);
	}

}