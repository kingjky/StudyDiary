package ssafy.baekjoon.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10815_숫자카드_전경윤 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		long[] cards = new long[N];
		for (int i = 0; i < N; i++) {
			cards[i] = Long.parseLong(arr[i]);
		}
		Arrays.sort(cards);
		
		int M = Integer.parseInt(br.readLine());
		arr = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			if(Arrays.binarySearch(cards, Long.parseLong(arr[i]))>=0)
				System.out.print(1+" ");
			else
				System.out.print(0+" ");
		}
	}
}
