package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10844_쉬운계단수_전경윤 {
	static final int K = 1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int memo[][] = new int[N][10];
		for (int i = 1; i < 10; i++) memo[0][i] = 1;
		
		for (int k = 1; k < N; k++) {
			for (int i = 0; i < 10; i++) {
				int tmp = 0;
				if(i>0) tmp += memo[k-1][i-1];
				if(i<9) tmp += memo[k-1][i+1];
				memo[k][i] = tmp%K;
			}
		}
		int sum = 0;
		for (int i : memo[N-1]) {
			sum+=i;
			sum%=K;
		}
		System.out.println(sum);
	}
}
