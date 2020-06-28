package day190815;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1127_맛있는음식_황란아 {
	static int N, MIN;
	static int[][] set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		set = new int[N][2];
		MIN = 1000000000;
		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(in.readLine(), " ");
			set[n][0] = Integer.parseInt(st.nextToken()); // S: 신맛
			set[n][1] = Integer.parseInt(st.nextToken()); // B: 쓴맛
		}
		subsetPerket(0, 1, 0, 0);
		System.out.println(MIN);

	}

	private static void subsetPerket(int index, int s, int b, int choiceCnt) {
		if (index == N) {
			int result = Math.abs(s - b);
			// 적어도 하나 이상의 재료를 선택해야하므로 choiceCnt > 0
			if (choiceCnt > 0) {
				if (MIN > result)
					MIN = result;
			}
			return;
		}

		// index 재료 선택
		subsetPerket(index + 1, s * set[index][0], b + set[index][1], choiceCnt + 1);
		// index 재료 비선택
		subsetPerket(index + 1, s, b, choiceCnt);
	}

}
