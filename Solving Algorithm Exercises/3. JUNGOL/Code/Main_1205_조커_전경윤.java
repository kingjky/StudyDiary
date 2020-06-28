package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 99:99:99
 * M : 9872 kb
 * T : 127 ms
 *
 */
public class Main_1205_조커_전경윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();

		int Joker = 0, temp;
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			temp = Integer.parseInt(input[i]);
			if (temp == 0) {
				Joker++;
			} else {
				list.add(temp);
			}
		}

		Collections.sort(list);
		int S = list.size();
		for (int i = 1; i < list.size(); i++) {
			int cur = list.get(i);
			int prev = list.get((i-1));
			if (list.get(i).equals(list.get((i - 1)))) {
				list.remove(i);
				i--;
			}
		}
		S = list.size();

		int mark[] = new int[S];

		int end = 0, start = 0, length = 1, curJ = Joker, max = -1;

		if (S > 0) {
			while (end < S) {
				if (end == S - 1) { // 탐색이 맨 끝에 도착했을 때
					length+=curJ;
					if (max < length)
						max = length;
					break;
				}

				int diff = list.get(end + 1) - list.get(end) - 1; // 현재와 그 다음칸의 차이값

				if (diff == 0) { // 차이가 1일 때 -> 스트레이트 일 때
					end++;
					length++;
					continue;
				} else { // 차이가 1이 아닐 때, 끊겼을 때
					if (diff > curJ) { // 현재 가진 조커로 커버가 안될 때
						length += curJ;
						if (max < length)
							max = length;
						if (start == end) { // start가 end와 같아질 때 -> 주어진 조커 다 써도 못 넘는 갭일 때
							start++;
							end++;
							length = 1;
							curJ = Joker;
							continue;
						}
						length -= curJ;
					} else { // 현재 가진 조커로 커버 될 때
						length += diff;
						end++;
						length++;
						mark[end] = diff;
						curJ -= diff;
						continue;
					}
				}
				while (start < end) {
					if (mark[start] == 0) {
						start++;
						length--;
					} else {
						curJ += mark[start];
						length -= mark[start];
						mark[start] = 0;
						break;
					}
				}
			}
		} else {
			max = Joker;
		}
		System.out.println(max);

	}

}
