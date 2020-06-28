package ssafy.baekjoon.L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10845_Å¥_Àü°æÀ± {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = null, c;
		Queue<Integer> ll = new LinkedList<Integer>();
		int num = 0;
		for (int n = 0; n < N; n++) {
			str = br.readLine();
			c = str.split(" ")[0];
//			StringTokenizer st = new StringTokenizer(str);
			int t;
			switch (c) {
			case "push":
				num = Integer.parseInt(str.split(" ")[1]);
				ll.offer(num);
				break;
			case "pop":
				if (ll.isEmpty())
					System.out.println(-1);
				else
					System.out.println(ll.poll());
				break;
			case "size":
				System.out.println(ll.size());
				break;
			case "empty":
				if (ll.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "front":
				if (ll.isEmpty())
					t = -1;
				else {
					t = ll.peek();
				}
				System.out.println(t);
				break;
			case "back":
				if (ll.isEmpty())
					t = -1;
				else {
					t = num;
				}
				System.out.println(t);
				break;
			}
		}
	}
}
