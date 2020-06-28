package day190815;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_1213_String_황란아 {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input_String.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			in.readLine();
			String sub = in.readLine();
			String sentence = in.readLine();
			int cnt = 0;
			if (sentence.contains(sub)) {
				int start = 0, result = -1;
				do {
					result = sentence.indexOf(sub, start);

					if (result != -1)
						cnt++;
					start = result + sub.length();

				} while (result != -1);

				System.out.println("#" + t + " " + cnt);
			}
		}

	}

}
