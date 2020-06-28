package ssafy.baekjoon.L2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1919_에너그램_전경윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1, s2;
		char[] c1, c2;
		int[] a1, a2;

		s1 = br.readLine();
		s2 = br.readLine();

		c1 = s1.toCharArray();
		c2 = s2.toCharArray();

		a1 = new int[26];
		a2 = new int[26];

		for (int i = 0; i < c1.length; i++)
			a1[(int) (c1[i] - 97)]++;
		for (int i = 0; i < c2.length; i++)
			a2[(int) (c2[i] - 97)]++;

//		for (int i = 0; i < a1.length; i++)
//			System.out.print(a1[i] + " ");
//		System.out.println();
//		for (int i = 0; i < a2.length; i++)
//			System.out.print(a2[i] + " ");
//		System.out.println();

		int sum = 0;
		for (int i = 0; i < a1.length; i++) {
			sum += Math.abs((a1[i] - a2[i]));
		}
		
		System.out.println(sum);
	}
}