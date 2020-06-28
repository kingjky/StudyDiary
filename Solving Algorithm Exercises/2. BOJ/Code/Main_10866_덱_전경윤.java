package ssafy.baekjoon.L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main_10866_µ¦_Àü°æÀ± {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
		String str = null, c;
		Deque<Integer> ll = new LinkedList<Integer>();
		int num = 0;
		
		ll.addFirst(1);
		ll.addLast(2);
		ll.addFirst(3);
		
		System.out.println(ll.pollFirst());
		System.out.println(ll.pollLast());
		System.out.println(ll.pollLast());
		System.out.println(ll.pollLast());
		
		/*for (int n = 0; n < N; n++) {
			str = br.readLine();
			c = str.split(" ")[0];
//			StringTokenizer st = new StringTokenizer(str);
			int t;
			switch (c) {
			case "push_front":
				num = Integer.parseInt(str.split(" ")[1]);
				ll.addFirst(num);
				break;
			case "push_back":
				num = Integer.parseInt(str.split(" ")[1]);
				ll.addLast(num);
				break;
			case "pop_front":
				num = ll.pollFirst();
//				System.out.println((num!=null)?-1:num);
				break;
			case "pop_back":
				break;
			case "size":
				break;
			case "empty":
				break;
			case "front":
				break;
			case "back":
				break;
			}
		}*/

	}

}
