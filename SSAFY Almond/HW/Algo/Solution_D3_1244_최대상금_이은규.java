package workshop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_D3_1244_최대상금_이은규 {

	static int[] num;
	static int len;
	static boolean[] visited;
	static int[] tmp;
	static int max;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			String data = s.split(" ")[0];
			n = Integer.parseInt(s.split(" ")[1]);
			// 숫자 길이
			len = data.length();
			// 숫자 담을 배열
			num = new int[len];
			// 방문 여부 체크
			visited = new boolean[len];
			// swap 결과 담을 배열
			tmp = new int[len];
			// 최대값
			max = 0;
			
			// num 배열에 숫자 담음
			for (int i = 0; i < len; i++) {
				num[i] = data.charAt(i) - '0';
			}
			
			permu(0,0);
//			permu(0);
			bw.write("#" + tc + " " + max + "\n");
		}
		bw.flush();
		bw.close();
	}
//	private static void permu(int index) {
//		if(index == len) {
//			int tNum = trans(tmp);
//			if(tNum > max) max = tNum;
//			return;
//		}
//		for (int i = 0; i < len; i++) {
//			if(visited[i] != true) {
//				visited[i] = true;
//				tmp[index] = num[i];
//				permu(index+1);
//				visited[i] = false;
//			}
//		}
//	}

	private static void permu(int index) {
		if(index == n) {
			int tNum = trans(num);
			if(tNum > max) max = tNum;
			return;
		}
		for (int i = index; i < len; ++i) {
			swap(index, i);
			permu(index+1);
			swap(index, i);
		}
	}
	
	private static void permu(int cur, int index) {
		// n번 swap 후 max값 return
		if(index == n) {
			int tNum = trans(num);
			if(tNum > max) max = tNum;
			return;
		}
		// j = i + 1 부터 시작해서 모든 경우의수 따짐
		// num[i]와 num[j] swap
		for (int i = cur; i < len; ++i) {
			for (int j = i+1; j < len; ++j) {
				if(num[i] <= num[j]) {
					swap(i, j);
					permu(i, index+1);
					swap(i, j);
				}
			}
		}
	}
	// swap
	private static void swap(int index, int i) {
		int tmp = num[index];
		num[index] = num[i];
		num[i] = tmp;
	}
	// int형 배열에 담은 순서대로 정수로 변환
	private static int trans(int[] arr) {
		int result = 0;
		
		for (int i = len-1, j = 1; i >= 0; --i) {
			result += arr[i]*j;
			j *= 10;
		}
		return result;
	}
}
