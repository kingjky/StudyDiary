package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2565_전깃줄_전경윤 {
	private static int N;
	private static int[][] lines;
	private static ArrayList<int[]> lis;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		lines = new int[N+1][3];
		lis = new ArrayList<>();
		lis.add(new int[] {0,0});
		int max = 0;
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			lines[n][0] = Integer.parseInt(st.nextToken());
			lines[n][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(lines, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		for (int i = 1; i <= N; i++) {
			for (int j = lis.size()-1; j >= 0; j--) {
				if(lis.get(j)[1] < lines[i][1]) {
					lines[i][2] = lis.get(j)[0] + 1;
					if(lines[i][2] > max) {
						lis.add(new int[] {lines[i][2], lines[i][1]});
						max = lines[i][2];
					} else if(lis.get(j+1)[1] > lines[i][1]) {
						lis.get(j+1)[1] = lines[i][1];
					}
					break;
				}
			}
		}
		System.out.println(N - lis.get(lis.size()-1)[0]);
	}
}