import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1492_원재의벽꾸미기_황란아 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			double N = Double.parseDouble(st.nextToken());
			double A = Double.parseDouble(st.nextToken());
			double B = Double.parseDouble(st.nextToken());

			double min = A * N + B * N;
			for (int row = 1; row <= N; row++) {
				for (int col = 1; row * col <= N; col++) {
					double result = A * Math.abs(row - col) + B * (N - row * col);
					if (result < min)
						min = result;
				}
			}

			System.out.printf("#%d %.0f\n", t, min);

		}

	}

}
