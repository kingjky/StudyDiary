package ssafy.baekjoon.L2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1406_에디터_전경윤4 {
	static Stack<Character> stack_L, stack_R;
	private static char co2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] s = str.toCharArray();
		stack_L = new Stack<Character>();
		stack_R = new Stack<Character>();

		for (int i = 0; i < s.length; i++)
			stack_L.add(s[i]);

		int N = Integer.parseInt(br.readLine());
		
		String line;
		char co;
		char co2 = 0;
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			co = line.charAt(0);
			if (co == 'P') {
				co2 = line.charAt(2);
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
		while(!stack_L.isEmpty())
			stack_R.push(stack_L.pop());
		while(!stack_R.isEmpty())
			System.out.print(stack_R.pop());
	}

	public static void L() {
		if (!stack_L.isEmpty())
			stack_R.push(stack_L.pop());
	}

	public static void D() {
		if (!stack_R.isEmpty())
			stack_L.push(stack_R.pop());
	}

	public static void B() {
		if (!stack_L.isEmpty())
			stack_L.pop();
	}

	public static void P(char ch) {
		stack_L.push(ch);
	}
}