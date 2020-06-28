package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author JKY
 * 00:15:05
 * M : 27724 KB
 * T : 165 ms
 */
public class Solution_D3_1209_Sum_전경윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] sumArr;
		int sumDiago1, sumDiago2;
		for (int t = 1; t <= 10; t++) {
			sumArr = new int[100];
			sumDiago1 = sumDiago2 = 0;
			br.readLine();
			int max = -1;
			int sum;
			for (int i = 0; i < 100; i++) {
				sum = 0;
				String str = br.readLine();
				st = new StringTokenizer(str);
				for (int j = 0; j < 100; j++) {
					int num = Integer.parseInt(st.nextToken());
					sum += num;
					sumArr[j] += num;
					if (i == j)
						sumDiago1 += num;
					if (i + j == 99)
						sumDiago2 += num;
				}
				if (max < sum)
					max = sum;
			}
			for (int i = 0; i < 100; i++) {
				if (max < sumArr[i])
					max = sumArr[i];
			}
			if(max < sumDiago1)
				max = sumDiago1;
			if(max < sumDiago2)
				max = sumDiago2;

			System.out.println("#" + t + " " + max);
		}
	}

}
