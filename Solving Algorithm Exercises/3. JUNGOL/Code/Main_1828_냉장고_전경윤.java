package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1828_냉장고_전경윤 {
	static class Refrigerator implements Comparable<Refrigerator> {
		int low, high;

		private Refrigerator(int low, int high) {
			super();
			this.high = high;
			this.low = low;
		}
		@Override
		public String toString() {
			return "Refrigerator [low=" + low + ", high=" + high + "]";
		}

		@Override
		public int compareTo(Refrigerator o) {
			int temp = this.low - o.low;
			if(temp == 0)
				return this.high - o.high;
			else
				return temp;
		}

	}

	static int arr[][];
	static List<Refrigerator> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		list = new ArrayList<Refrigerator>();
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
//			arr[i] = new int[] {Integer.parseInt(str[0]), Integer.parseInt(str[1])};
			list.add(new Refrigerator(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
		}

//		Collections.sort(list);

		int maxLow, minHigh, count;
		maxLow = Integer.MIN_VALUE;
		minHigh = Integer.MAX_VALUE;
		count = 1;
		Refrigerator cur;
		for (int i = 0; i < N; i++) {
			cur = list.get(i);
//			System.out.println(cur);
			if (maxLow <= cur.high && minHigh >= cur.low) {
				if (maxLow < cur.low) {
					maxLow = cur.low;
//					System.out.println("\tmaxLow : " + maxLow);
				}
				if (minHigh > cur.high) {
					minHigh = cur.high;
//					System.out.println("\tminHigh : " + minHigh);
				}
			} else {
				count++;
				maxLow = cur.low;
				minHigh = cur.high;
//				System.out.println("\tcount++ : " + count);
			}
		}

		System.out.println(count);
	}
}
