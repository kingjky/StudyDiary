package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * M : 24 mb
 * T : 571 ms
 *
 */
public class Main_2634_사냥꾼_전경윤 {
	static int M, N, L, Guns[], Result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		Guns = new int[M];
		int gunSize = Guns.length;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			Guns[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(Guns);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int gun = binary(0, gunSize - 1, x);
			if ((Math.abs(gun-x) + y) <= L)
				Result++;
		}
		System.out.println(Result);
	}

	private static int binary(int start, int end, int x) {
		if (end - start <= 1)
			return Math.abs(Guns[end] - x) < Math.abs(Guns[start] - x) ? Guns[end]:Guns[start];
			
		int half = (end + start) / 2;
		int half_gun = Guns[half];
		
		if (half_gun > x) {
			return binary(start, half, x);
		} else if (half_gun < x) {
			return binary(half, end, x);
		} else {
			return Guns[half];
		}
	}

}
