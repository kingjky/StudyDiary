package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_1494_사랑의카운슬러_전경윤 {
	static int arr[][], N;
	static long Min;
	static boolean select[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				arr[i][0] = Integer.parseInt(str[0]);
				arr[i][1] = Integer.parseInt(str[1]);
			}
			// end of input

			Min = Long.MAX_VALUE;
			select = new boolean[N];
			combi(0, 0);

			System.out.printf("#%d %d\n",t,Min);
		} // end of TC
	}

	private static void combi(int i, int num) {
		if (i == N) {
			long temp = cal();
			if(temp < Min) {
				Min = temp;
			}
		}
		for (int j = 0; j < N; j++) {
			select[i] = false;
			combi(i+1, num);
			select[i] = true;
		}
	}

	private static long cal() {
		long X=0, Y=0;
		for (int i = 0; i < N; i++) {
			if(select[i]) {
				X+=arr[i][0];
				Y+=arr[i][1];
			} else {
				X-=arr[i][0];
				Y-=arr[i][1];
			}
		}
		return X*X + Y*Y;
	}
}
