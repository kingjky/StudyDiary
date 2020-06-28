package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질_전경윤2 {
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[3]; // +, -, *2
		int cnt = 0;
		arr[0] = arr[1] = arr[2] = N;
		do {
			int a = select(0, arr);
			int b = select(1, arr);
			int c = select(2, arr);
			arr[0] = a;
			arr[1] = b;
			arr[2] = c;
			cnt++;
		}while(arr[0]!=K && arr[1]!=K && arr[2]!=K);
		System.out.println(cnt);
	}

	private static int select(int i, int[] arr) {
		switch (i) {
		case 0:
			return Math.min(Math.abs(arr[0]+1 - K), Math.abs(arr[1]+1 - K)) >= Math.abs(arr[2]+1 - K) ? arr[2]+1 : Math.abs(arr[0]+1 - K) >= Math.abs(arr[1]+1 - K) ? arr[1]+1 : arr[0]+1;
		case 1:
			return Math.min(Math.abs(arr[0]-1 - K), Math.abs(arr[1]-1 - K)) >= Math.abs(arr[2]-1 - K) ? arr[2]-1 : Math.abs(arr[0]-1 - K) >= Math.abs(arr[1]-1 - K) ? arr[1]-1 : arr[0]-1;
		case 2:
			return Math.min(Math.abs(arr[0]*2 - K), Math.abs(arr[1]*2 - K)) >= Math.abs(arr[2]*2 - K) ? arr[2]*2 : Math.abs(arr[0]*2 - K) >= Math.abs(arr[1]*2 - K) ? arr[1]*2 : arr[0]*2;
		}
		return 0;
	}
}
