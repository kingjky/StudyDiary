package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 백준
 * 00:56
 * 12848 KB
 * 72 ms
 */
public class Main_2591_숫자카드_전경윤 {
	static String N, s;
	static int cnt, t;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();
		cnt = 0;
		int len = N.length();
		int arr[][] = new int[len+1][2];
		arr[0][0] = 1;
		for (int i = 1; i <= len; i++) {
			s = N.substring(i-1, i);
			if(s.charAt(0)!='0')
				arr[i][0] = arr[i-1][0] + arr[i-1][1];
			if(i>1) {
				s = N.substring(i-2, i);
				if(s.charAt(0)!='0' && Integer.parseInt(s)<=34)
					arr[i][1] = arr[i-2][0] + arr[i-2][1];
			}
		}
		System.out.println(arr[len][0]+arr[len][1]);
	}
}
