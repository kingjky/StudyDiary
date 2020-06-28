package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 0:30
 * 12952 KB
 * 80 ms
 */
public class Main_2578_빙고_전경윤 {
	static int bingo[][], num[];
	static int row[], col[], dia[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		bingo = new int[5][5];
		num = new int[25];
		row = new int[5];
		col = new int[5];
		dia = new int[2];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				num[i*5+j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int result = 0;
		outer: for (int c = 0; c < 25; c++) {
			result++;
			int cur = num[c];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if(cur == bingo[i][j]) {
						row[i]++;
						col[j]++;
						if(i==j) dia[0]++;
						if(i+j==4) dia[1]++;
						for (int k = 0; k < 5; k++) {
							if(row[k] == 5) {
								cnt++;
								row[k] = 6;
							}
							if(col[k] == 5) {
								cnt++;
								col[k] = 6;
							}
						}
						if(dia[0] == 5) {
							cnt++;
							dia[0] = 6;
						}
						if(dia[1] == 5) {
							cnt++;
							dia[1] = 6;
						}
						if(cnt>=3) break outer;
						continue;
					}
				}
			}
		}
		System.out.println(result);
	}

}
