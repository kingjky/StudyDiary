package BAEKJOON;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 00:13:00
 * M : 18056 kb
 * T : 168 ms
 *
 */
public class Main_2985_롤케이크_전경윤 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] cake = new int[L], count = new int[N+1];
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		int max=-1, maxIndex = 0, realMax=-1, realIndex = 0;
		for (int i = 0; i < N; i++) {
			if(max < arr[i][1] - arr[i][0]) {
				max = arr[i][1] - arr[i][0];
				maxIndex = i;
			}
			for (int j = arr[i][0]; j <= arr[i][1]; j++) {
				if(cake[j-1] != 0)
					continue;
				cake[j-1] = i+1;
			}
		}
		System.out.println(maxIndex+1);
		
		for (int i = 0; i < L; i++) {
			count[cake[i]]++;
		}
		for (int i = 1; i < N+1; i++) {
			if(realMax < count[i]) {
				realMax = count[i];
				realIndex = i;
			}
		}
		System.out.println(realIndex);
	}
}
