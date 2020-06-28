package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author JKY
 * 재시도
 * M : 12916 KB
 * T : 76 ms
 */
public class Main_1541_잃어버린괄호_전경윤2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("-");
		
		boolean start = false;
		int result = 0;
		for (String string : str) {
			String[] temp = string.split("\\+");
			int sum = 0;
			for (String string2 : temp) {
				sum += Integer.parseInt(string2);
			}
			if(result==0) {start = true; result = sum;}
			else result -= sum;
		}
		System.out.println(result);

	}
}