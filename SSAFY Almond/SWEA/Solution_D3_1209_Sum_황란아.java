import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1209_Sum_황란아 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("input_1209.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			in.readLine();
			int[][] arr = new int[100][100];

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for (int i = 0; i < 100; i++) {
				// 가로
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[i][j];
				}
				if (max < sum)
					max = sum;

			}
			for (int i = 0; i < 100; i++) {
				// 세로
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[j][i];
				}
				if (max < sum)
					max = sum;

			}
			for (int i = 0; i < 100; i++) {

				int sum = 0;

				sum += arr[i][i];

				if (max < sum)
					max = sum;

			}
			for (int i = 0; i < 100; i++) {
				int sum = 0;

				sum += arr[i][99 - i];

				if (max < sum)
					max = sum;
			}
			System.out.println("#" + t + " " + max);

		}

	}

}
