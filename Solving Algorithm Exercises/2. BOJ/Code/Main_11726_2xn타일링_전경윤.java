package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 12936 KB
 * 72 ms
 */
public class Main_11726_2xn타일링_전경윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int m[] = new int[N+1];
		m[0] = m[1] = 1;
		for (int i = 2; i <= N; i++)
			m[i] = (m[i-1] + m[i-2]) % 10007;
		System.out.println(m[N]);
	}

}
