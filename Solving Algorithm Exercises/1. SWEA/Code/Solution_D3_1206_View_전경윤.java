package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author JKY
 *	00:12:15
 *	M : 21580 kb
 *	T : 146 ms
 */
public class Solution_D3_View_전경윤 {
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			int index = 0;
			for (String string : br.readLine().split(" ")) {
				arr[index++] = Integer.parseInt(string);
			}
			// end of input
			
			//start of Algorithm
			int sum = 0;
			for (int i = 2; i < N-2; i++) {
				int cal = Math.max(Math.max(arr[i-2], arr[i-1]), Math.max(arr[i+2], arr[i+1]));
				if(cal < arr[i])
					sum += arr[i]-cal;
			}
			
			System.out.printf("#%d %d\n",t,sum);
		} // end of testcase
	}

}
