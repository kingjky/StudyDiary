package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 99:99:99
 * M : 13056 kb
 * T : 76 ms
 *
 */
public class Main_2643_색종이올려놓기_전경윤 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] papers = new int[N][2];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a, b;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			papers[i][0] = (a > b ? b : a);
			papers[i][1] = (a > b ? a : b);
		} // end of input

		Arrays.sort(papers, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});

		int[] count = new int[N];
		int maxNum=0;
		for (int i = 0; i < N; i++) {
			maxNum = 0;
			for (int j = 0; j < i; j++) {
				if(papers[j][1] > papers[i][1]) continue;
				else {
					if(count[j] > maxNum)
						maxNum = count[j];
				}
			}
			count[i] = maxNum+1;
		}
		
		maxNum = 0;
		for (int i = 0; i < N; i++) {
			if(count[i] > maxNum)
				maxNum = count[i];
		}
		System.out.println(maxNum);
	}
}
