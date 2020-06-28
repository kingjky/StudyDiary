package JungOl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main_1671_색종이중_전경윤 {
	static int arr[][], map[][], Result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		/**
		 * 000000000
		 * 011110000
		 * 011111110
		 * 000001110
		 * 000000000
		 */

		/**
		 * 01 10
		 * 
		 * 0 1
		 * 1 0
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int [N][2];
		int a, b, minC = Integer.MAX_VALUE, maxC = Integer.MIN_VALUE, minR = Integer.MAX_VALUE, maxR = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			if(minC > a)
				minC = a;
			if(minR > b)
				minR = b;
			if(maxC < a)
				maxC = a;
			if(maxR < b)
				maxR = b;
			arr[i][0] = a;
			arr[i][1] = b;
		}
		int R = maxR - minR + 3 + 10;
		int C = maxC - minC + 3 + 10;
		map = new int[maxR - minR + 3 + 10][maxC - minC + 3 + 10];
		for (int i = 0; i < N; i++) {
			for (int r = 0; r < 10; r++) {
				for (int c = 0; c < 10; c++) {
					map[arr[i][1]+1-minR+r][arr[i][0]+1-minC+c] = 1;
				}
			}
		}
		Result = 0;
		for (int r = 1; r < R-1; r++) {
			for (int c = 1; c < C-1; c++) {
				if(map[r][c]>0) {
					if(map[r-1][c]==0)
						Result++;
					if(map[r+1][c]==0)
						Result++;
					if(map[r][c-1]==0)
						Result++;
					if(map[r][c+1]==0)
						Result++;
				}
			}
		}
		
		System.out.println(Result);
	}

}
