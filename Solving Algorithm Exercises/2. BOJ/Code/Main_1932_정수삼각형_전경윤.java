package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형_전경윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input[] = new int[N];
		int memo[] = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				if(j>0) input[j] = Math.max(memo[j-1], memo[j]) + Integer.parseInt(st.nextToken());
				else input[j] = memo[j] + Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j <= i; j++) {
				memo[j] = input[j];
			}
		}
		Arrays.sort(memo);
		System.out.println(memo[N-1]);
	}

=======
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형_전경윤 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int input[] = new int[N+1];
		int memo[]= new int[N+1];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				input[j] = Integer.parseInt(st.nextToken());
				memo[j] += Math.max(input[j], input[j+1]);
			}
			for (int j = i+1; j < N; j++) {
				memo[j]+=input[i];
			}
			System.out.println();
		}
		
		int max = -1;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, memo[i]);
		}
		System.out.println(max);
	}
}
