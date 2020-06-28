package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author JKY
 * 00:13:00
 * M : 13116 KB
 * T : 84 ms
 */
public class Main_9012_괄호_전경윤 {
	static Stack<Character> stack;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			stack = new Stack<Character>();
			System.out.println(VPS(br.readLine().toCharArray())?"YES":"NO");
		} // end of Testcase
	}

	public static boolean VPS(char[] arr) {
		for (Character c : arr) {
			if (c == '(')
				stack.add(c);
			else {
				char p;
				if (!stack.isEmpty() && (p = stack.pop()) == '(') {
					continue;
				} else {
					return false;
				}
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
}
