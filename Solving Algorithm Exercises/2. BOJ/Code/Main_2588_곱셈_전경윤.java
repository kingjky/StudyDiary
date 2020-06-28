package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2588_곱셈_전경윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int b1 = b%10, b10 = b/10%10, b100 = b/100;
		StringBuilder sb = new StringBuilder();
		sb.append(a*b1 + "\n");
		sb.append(a*b10 + "\n");
		sb.append(a*b100 + "\n");
		sb.append(a*b);
		System.out.println(sb);
	}
}
