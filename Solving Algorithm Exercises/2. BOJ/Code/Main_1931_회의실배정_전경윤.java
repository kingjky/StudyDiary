package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_1931_회의실배정_전경윤 {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
		} // end of input
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int value = o1[1] - o2[1];
				return value==0?o1[0]-o2[0]:value;
			}
		});
		
		int current = 0, count=0;
		for (int i = 0; i < N; i++) {
			if(arr[i][0] >= current) {
				current = arr[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}
