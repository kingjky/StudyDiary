package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @author JKY
 * 01:13:00
 * M : 13040 KB
 * T : 76 ms
 */
public class Main_1541_잃어버린괄호_전경윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		Deque<String> q1 = new LinkedList<String>();
		Deque<String> q2 = new LinkedList<String>();

		Integer temp = 0;
		for (char c : str) {
			if (!Character.isDigit(c)) {
				q1.offer(temp.toString());
				q1.offer(c + "");
				temp = new Integer(0);
			} else {
				temp *= 10;
				temp += c - '0';
			}
		}
		q1.offer(temp.toString());
//		System.out.println(q1.toString());
		String t;
		while (q1.peek() != null) {
			t = q1.poll();
			
			if (t.equals("+")) {
				int sum = Integer.parseInt(q2.pollLast());
				do {
					t = q1.poll();
					try {
						int a = Integer.parseInt(t);
						sum += a;
					} catch (Exception e) {
					}

				} while (q1.peek() != null && !t.equals("-"));
				q2.offer(sum + "");
				if(t.equals("-")) {
					q2.offer(t + "");
				}
			} else {
				q2.offer(t);
			}
		}

//		System.out.println(q2.toString());

		int result = Integer.parseInt(q2.poll());
		while (q2.peek() != null) {
			t = q2.poll();
			try {
				int b = Integer.parseInt(t);
				result -= Integer.parseInt(t);
			} catch(Exception e) {}
		}

		System.out.println(result);

	}
}
