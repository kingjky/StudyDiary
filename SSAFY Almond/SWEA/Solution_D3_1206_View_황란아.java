import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1206_View_황란아 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("input_1206.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(in.readLine());
			int[][] building = new int[255][N];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			for (int col = 0; col < N; col++) {
				int R = Integer.parseInt(st.nextToken());
				for (int row = 254; row >= 255 - R; row--) {
					building[row][col] = 1;
				}
			}

//			for (int[] is : building) {
//				System.out.println(Arrays.toString(is));
//			}

			int cnt = 0;

			for (int col = 2; col < N - 2; col++) {
				for (int row = 254; row >= 0 && building[row][col] == 1; row--) {
					if (building[row][col - 1] != 1 && building[row][col - 2] != 1 && building[row][col + 1] != 1
							&& building[row][col + 2] != 1)
						cnt++;
				}
			}

			System.out.println("#" + t + " " + cnt);

		}

	}

}
