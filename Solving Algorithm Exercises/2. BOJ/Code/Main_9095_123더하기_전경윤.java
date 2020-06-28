package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095_123더하기_전경윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int memo[] = new int[N+1];
			memo[0] = 1;
			for (int i = 1; i <= N; i++) {
				int sum=0;
				if(i>=1) {
					sum+=memo[i-1];
					if(i>=2) {
						sum+=memo[i-2];
						if(i>=3) {
							sum+=memo[i-3];
						}
					}
				}
				memo[i] = sum;
			}
			System.out.println(memo[N]);
		}
	}

}
