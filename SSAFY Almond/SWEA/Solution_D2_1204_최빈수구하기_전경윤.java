package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author JKY
 *	00:15:36
 *	M : 21436 KB
 *	T : 133 ms
 */
public class Solution_D2_1204_최빈수구하기_전경윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			arr = new int[101];
			br.readLine();
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			while (st.hasMoreTokens()) {
				arr[Integer.parseInt(st.nextToken())]++;
			}
			int max = -1, maxIndex = -1;
			for (int i = 0; i < 101; i++) {
				if (max <= arr[i]) {
					max = arr[i];
					maxIndex = i;
				}
			}

			System.out.println("#" + t + " " + maxIndex);
		}
	}

}
