package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 2:00
 * 13592 KB
 * 472 ms
 */
public class Main_17281_야구_전경윤 {
	static int[] per = {0, 1, 2, 4, 5, 6, 7, 8 };
	private static int N;
	private static int[][] arr;
	static final int M = 9;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N][9];
		// 0 1 2 3 4 5 6 7 8
		//
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				arr[n][i] = Integer.parseInt(st.nextToken());
			}
		}
		int maxScore = -1;
		do {
			int tmpScore = cal();
			if (maxScore < tmpScore)
				maxScore = tmpScore;
		} while (nextPer());
		System.out.println(maxScore);
	}

	private static boolean nextPer() {
		int i, j;
		i = j = M - 2;
		while (i > 0 && per[i - 1] >= per[i])
			i--;
		if (i == 0)
			return false;
		while (per[i - 1] >= per[j])
			j--;
		swap(i - 1, j);
		j = M - 2;
		while (i < j) {
			swap(i, j);
			i++;
			j--;
		}
		return true;
	}

	private static void swap(int i, int j) {
		int tmp = per[i];
		per[i] = per[j];
		per[j] = tmp;

	}

	private static int cal() {
		int score = 0;
		int mount1, mount2, mount3, out;
		mount1 = mount2 = mount3 = out = 0;
		int idx = 0; // idx번 타자
		int cur = 0; // cur번 선수
		for (int n = 0; n < N; n++) { // n번쨰 이닝
			while(out<3) { //3out 까지 진행 
				if(idx == 3) cur = 0;
				else {
					for (int i = 0; i < M-1; i++) { // idx번 타자인 i번 선수 찾기
						if (idx == per[i]) {
							cur = i+1;
							break;
						}
					}
				}
				switch (arr[n][cur]) {
				case 0: // 아웃
					out++;
					break;
				case 1: // 안타
					score += mount3;
					mount3 = mount2;
					mount2 = mount1;
					mount1 = 1;
					break;
				case 2: // 2루타
					score += mount3 + mount2;
					mount3 = mount1;
					mount1 = 0;
					mount2 = 1;
					break;
				case 3: // 3루타
					score += mount3 + mount2 + mount1;
					mount3 = 1;
					mount2 = mount1 = 0;
					break;
				case 4: // 홈런
					score += mount3 + mount2 + mount1 + 1;
					mount3 = mount2 = mount1 = 0;
					break;
				}
				idx = (idx+1)%M;
			}
			mount1 = mount2 = mount3 = out = 0;
		}

		return score;
	}

}
