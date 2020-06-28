package baekjoon;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1406_에디터_전경윤 {
	final static int limit = 600000;
	static int cursor, length;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		ArrayList<String> s_arr = new ArrayList<String>();
		for(int i=0; i<str.length(); i++)
			s_arr.add(i, " ");
		
		cursor = str.length();
		int N = sc.nextInt();

//		for (int i = 0; i < N; i++) {
//			char co = sc.next().charAt(0);
//			char co2 = 0;
//			if (co == 'P')
//				co2 = sc.next().charAt(0);
//			switch (co) {
//			case 'L':
//				L(s_arr);
//				break;
//			case 'D':
//				D(s_arr);
//				break;
//			case 'B':
//				B(s_arr);
//				break;
//			case 'P':
//				P(co2, s_arr);
//				break;
//			}
//		}
		for (int j = 0; j < length; j++)
			System.out.print(s_arr.get(j));
	}

	public static void L(ArrayList<Character> arr) {
		if (cursor > 0)
			cursor--;
	}

	public static void D(ArrayList<Character> arr) {
		if (cursor < length)
			cursor++;
	}

	public static void B(ArrayList<Character> arr) {
		if (cursor > 0) {
			cursor--;
			for (int i = cursor; i < length; i++)
//				c[i] = c[i + 1];
			length--;
		}
	}

	public static void P(char ch, ArrayList<Character> arr) {
		for (int i = length - 1; i >= cursor; i--)
			if (i + 1 < limit)
//				c[i + 1] = c[i];
//		c[cursor++] = ch;
		length++;
	}
}