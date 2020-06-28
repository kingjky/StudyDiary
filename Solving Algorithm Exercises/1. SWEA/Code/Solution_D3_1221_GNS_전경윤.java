import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author student
 * 00:15:20
 * M : 31324 kb
 * T : 166 ms
 */
public class Solution_D3_1221_GNS_전경윤 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine().split(" ")[1]);
			int[] arr = new int[10];
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for (int i = 0; i < N; i++) {
				switch (st.nextToken()) {
				case "ZRO":
					arr[0]++;
					break;
				case "ONE":
					arr[1]++;
					break;
				case "TWO":
					arr[2]++;
					break;
				case "THR":
					arr[3]++;
					break;
				case "FOR":
					arr[4]++;
					break;
				case "FIV":
					arr[5]++;
					break;
				case "SIX":
					arr[6]++;
					break;
				case "SVN":
					arr[7]++;
					break;
				case "EGT":
					arr[8]++;
					break;
				case "NIN":
					arr[9]++;
					break;
				}
			}
			
			System.out.println("#"+t);
			for (int i = 0; i < 10; i++) {
				while(arr[i]-->0) {
					switch (i) {
					case 0:
						System.out.print("ZRO ");
						break;
					case 1:
						System.out.print("ONE ");
						break;
					case 2:
						System.out.print("TWO ");
						break;
					case 3:
						System.out.print("THR ");
						break;
					case 4:
						System.out.print("FOR ");
						break;
					case 5:
						System.out.print("FIV ");
						break;
					case 6:
						System.out.print("SIX ");
						break;
					case 7:
						System.out.print("SVN ");
						break;
					case 8:
						System.out.print("EGT ");
						break;
					case 9:
						System.out.print("NIN ");
						break;
					}
				}
			}
		}
	}
}
