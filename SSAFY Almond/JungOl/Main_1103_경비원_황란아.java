package day190820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1103_경비원_황란아 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int numStore = Integer.parseInt(in.readLine());

		int[] dir = new int[numStore + 1]; // 방향
		int[] pos = new int[numStore + 1]; // 거리
		int[] far = new int[numStore + 1]; // 원점으로부터 떨어진 거리
		for (int i = 0; i < numStore + 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			dir[i] = Integer.parseInt(st.nextToken()); // 1.북 2.남 3.서 4.동
			pos[i] = Integer.parseInt(st.nextToken());

			// 원점(0,0)부터 시계방향으로의 거리
			switch (dir[i]) {
			case 1: // 북
				far[i] = pos[i];
				break;
			case 2: // 남
				far[i] = width + height + width - pos[i];
				break;
			case 3: // 서
				far[i] = width * 2 + height + height - pos[i];
				break;
			case 4: // 동
				far[i] = width + pos[i];
				break;
			}
		}

		int result = 0;
		for (int i = 0; i < numStore; i++) {
			int tmp = Math.abs(far[numStore] - far[i]); // 동근이와 상점 사이의 거리
			tmp = (tmp < 2 * width + 2 * height - tmp ? tmp : 2 * width + 2 * height - tmp);
			result += tmp;
		}
		System.out.println(result);

	}

}
