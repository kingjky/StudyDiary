package BAEKJOON;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 00:11:07
 * M : 14332 kb
 * T : 124 ms
 *
 */
public class Main_1592_영식이와친구들_전경윤 {
	static int[] count;
	static int N, M, L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();

		count = new int[N];
		count[1]++;
		
		int cur = 1, next;
		while(CalMax() < M) {
			if(count[cur] % 2 == 0) { // 짝수 일 때
				count[(cur+L)%N]++;
				cur = (cur+L)%N;
			} else { // 홀수 일 때
				count[(cur+N-L)%N]++;
				cur = (cur+N-L)%N;
			}
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum+=count[i];
		}
		System.out.println(sum-1);
	}
	
	static int CalMax() {
		int max = -1;
		for (int i = 0; i < N; i++) {
			if(count[i] > max)
				max = count[i];
		}
		return max;
	}
}
