package ssafy.baekjoon.L1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1330_두수비교하기_전경윤 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b;
		a = sc.nextInt();
		b = sc.nextInt();
		
		if(a>b)
			System.out.println(">");
		else if(a<b)
			System.out.println("<");
		else
			System.out.println("==");
	}
}
