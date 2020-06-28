package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *	00:31:27
 *	M : 7 MB
 *	T : 88 ms
 */
public class Main_1127_맛있는음식_전경윤 {
	static int Min, N, numbers[], SB[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		SB = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			SB[i][0] = Integer.parseInt(str[0]);
			SB[i][1] = Integer.parseInt(str[1]);
		} //end of Input
		Min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			numbers = new int[i];
			combination(0, 0, i);
		}
		
		System.out.println(Min);
	}

	static void combination(int before, int index, int R) {
		if(index == R) {
			int temp = cal();
			if(Min > temp)
				Min = temp;
			return;
		}
			
			for (int i = before; i < N; i++) {
				numbers[index] = i;
				combination(i+1, index+1, R);
			}
	}
	
	static int cal() {
		int s=1, b=0;
		for (int i : numbers) {
			s*=SB[i][0];
			b+=SB[i][1];
		}
		return Math.abs(s-b);
	}
}
