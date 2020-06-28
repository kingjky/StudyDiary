package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Stack;

public class Main_5397_키로거_전경윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		// end of Input

		for (int t = 0; t < T; t++) {
			Stack<Character> stack_L = new Stack<Character>();
			Stack<Character> stack_R = new Stack<Character>();
			// start of Algorithm
			String s = br.readLine();
			for (char c : s.toCharArray()) {
				if (c == '\n')
					break;
				else {
					switch (c) {
					case '<':
						if (!stack_L.isEmpty())
							stack_R.push(stack_L.pop());
						break;
					case '>':
						if (!stack_R.isEmpty())
							stack_L.push(stack_R.pop());
						break;
					case '-':
						if (!stack_L.isEmpty())
							stack_L.pop();
						break;
					default:
						stack_L.push(c);
						break;
					} // end of switch
				}
			} // end of for
//			while(!stack_R.isEmpty())
//				stack_L.push(stack_R.pop());
			while (!stack_L.isEmpty())
				stack_R.push(stack_L.pop());
			while (!stack_R.isEmpty())
				bw.write(stack_R.pop());
			bw.write('\n');
			bw.flush();
		} // end of testcase
		bw.close();
	}
}
