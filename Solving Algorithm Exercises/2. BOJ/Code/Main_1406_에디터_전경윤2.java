package ssafy.baekjoon.L2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_1406_에디터_전경윤2 {
	final static int limit = 600000;
	static int length;
	static int cursor;
	static LinkedList<Character> ll = new LinkedList<Character>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] s = str.toCharArray();

		for (int i = 0; i < s.length; i++)
			ll.add(s[i]);

		int N = sc.nextInt();
		length = s.length;
		cursor = length;

		for (int i = 0; i < N; i++) {
			char co = sc.next().charAt(0);
			char co2 = 0;
			if (co == 'P')
				co2 = sc.next().charAt(0);
			switch (co) {
			case 'L':
				L();
				break;
			case 'D':
				D();
				break;
			case 'B':
				B();
				break;
			case 'P':
				P(co2);
				break;
			}
		}
		for (int i = 0; i < ll.size(); i++) {
			System.out.print("");
		}
	}

//	public static void L() {
//		if (cursor.previous != null)
//			cursor = cursor.previous;
//		else
//			cursor = null;
//	}
//
//	public static void D() {
//		if (cursor == null)
//			cursor = ll.first;
//		else if (cursor.next != null)
//			cursor = cursor.next;
//	}
//
//	public static void B() {
//		if (cursor.previous != null) {
//			ll.remove(cursor);
//			length--;
//		}
//	}
//
//	public static void P(char ch) {
//		ll.add(ch);
//		length++;
//	}
}