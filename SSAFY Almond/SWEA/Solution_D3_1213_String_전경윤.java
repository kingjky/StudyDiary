package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author JKY
 * 00:14:35
 * M : 18548 KB
 * T : 122 ms
 */
public class Solution_D3_1213_String_전경윤 {
	static char[] word, str;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			word = br.readLine().toCharArray();
			str = br.readLine().toCharArray();
			int sum = 0;
			for (int i = 0, size = str.length - word.length; i <= size; i++) {
				sum += isContain(i) ? 1 : 0;
			}
			System.out.println("#" + t + " " + sum);
		} // end of test case
	}
	
	static boolean isContain(int start) {
		for (int i = 0, size = word.length; i < size; i++) {
			if(word[i] != str[start+i]) {
				if( (str[start+i] - word[i]) == ('A'-'a')) {
					continue;
				}
				return false;
			}
		}
		return true;
	}
}
