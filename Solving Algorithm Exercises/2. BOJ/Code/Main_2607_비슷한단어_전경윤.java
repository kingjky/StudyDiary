package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 12856 KB
 * 76 ms
 */
public class Main_2607_비슷한단어_전경윤 {
	static int pivot[], input[];
	static final int AZ = 26;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		pivot = new int[AZ];
		input = new int[AZ];
		for (char c : br.readLine().toCharArray()) {
			pivot[c-'A']++;
		}
		int cnt = 0;
		for (int n = 1; n < N; n++) if(check(br.readLine())) cnt++;
		System.out.println(cnt);
	}
	private static boolean check(String readLine) {
		Arrays.fill(input, 0);
		for (char c : readLine.toCharArray()) input[c-'A']++;
		int out, inMore, inLess;
		out = inLess = inMore = 0;
		for (int i = 0; i < AZ; i++) {
			if(pivot[i]>0) {
				if(pivot[i]>input[i]) inLess += pivot[i]-input[i];
				else inMore -= pivot[i]-input[i];
			} else out+=input[i];
		}
		if(inLess < 2) {
			if(out==1) {
				if(inMore < 1)
					return true;
			} else if(out==0){
				if(inMore<2) return true;
			}
		}
		
		return false;
	}
}