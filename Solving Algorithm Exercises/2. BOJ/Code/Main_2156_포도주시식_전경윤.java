package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156_포도주시식_전경윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int input, max = 0;
		int memo[][] = new int[N][3];
		for (int i = 0; i < N; i++) {
			input = Integer.parseInt(br.readLine());
			if(i==0) max = memo[0][0] = memo[0][1] = memo[0][2] = input;
			else if(i==1) {
				int t1 = memo[i-1][1], t2 = memo[i-1][2];
				memo[i][0] = Math.max(t1, t2) + input;
				memo[i][1] = input;
				memo[i][2] = input;
				
				max = Math.max(memo[i][0], max);
				max = Math.max(memo[i][1], max);
				max = Math.max(memo[i][2], max);
			}
			else if(i==2) {
				int t0 = memo[i-1][0], t1 = memo[i-1][1], t2 = memo[i-1][2];
				int u0 = memo[i-2][0], u1 = memo[i-2][1], u2 = memo[i-2][2];
				memo[i][0] = Math.max(t1, t2) + input;
				memo[i][1] = Math.max(u0, Math.max(u1, u2)) + input;
				memo[i][2] = input;
				
				max = Math.max(memo[i][0], max);
				max = Math.max(memo[i][1], max);
				max = Math.max(memo[i][2], max);
			}
			else {
				int t0 = memo[i-1][0], t1 = memo[i-1][1], t2 = memo[i-1][2];
				int u0 = memo[i-2][0], u1 = memo[i-2][1], u2 = memo[i-2][2];
				int v0 = memo[i-3][0], v1 = memo[i-3][1], v2 = memo[i-3][2];
				memo[i][0] = Math.max(t1, t2) + input;
				memo[i][1] = Math.max(u0, Math.max(u1, u2)) + input;
				memo[i][2] = Math.max(v0, Math.max(v1, v2)) + input;
				
				max = Math.max(memo[i][0], max);
				max = Math.max(memo[i][1], max);
				max = Math.max(memo[i][2], max);
			}
		}
		
		
		System.out.println(max);
	}

}
