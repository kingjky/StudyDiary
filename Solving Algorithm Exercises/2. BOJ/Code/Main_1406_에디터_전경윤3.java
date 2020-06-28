package ssafy.baekjoon.L2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_1406_에디터_전경윤3 {
	final static int limit = 600000;
	static int cursor, length;
	static LinkedList<Character> ll;
	private static char co2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] s = str.toCharArray();
		ll = new LinkedList<Character>();
		
		for (int i = 0; i < s.length; i++)
			ll.add(s[i]);

		int N = br.read();
		cursor = s.length;
		length = s.length;

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			char co = line.charAt(0);
			if (co == 'P') {
				char co2 = line.charAt(1);
			}
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
			System.out.print(ll.get(i));
		}
	}

	public static void L() {
		if (cursor > 0)
			cursor--;
	}

	public static void D() {
		if (cursor < length)
			cursor++;
	}

	public static void B() {
		if (cursor > 0) {
			cursor--;
			ll.remove(cursor);
			length--;
		}
	}

	public static void P(char ch) {
		ll.add(cursor++, ch);
		length++;
	}
}