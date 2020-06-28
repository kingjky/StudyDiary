package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_2608_로마숫자_전경윤 {
	static final int I = 1
					,V = 5
					,X = 10
					,L = 50
					,C = 100
					,D = 500
					,M = 1000;
	static char input[][];
	static HashMap<Character, Integer> map;
	static HashMap<Integer, String> rom;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new HashMap<Character, Integer>();
		rom = new HashMap<Integer, String>();
		map.put('I', I);
		map.put('V', V);
		map.put('X', X);
		map.put('L', L);
		map.put('C', C);
		map.put('D', D);
		map.put('M', M);
		rom.put(1, "I");
		rom.put(2, "II");
		rom.put(3, "III");
		rom.put(4, "IV");
		rom.put(5, "V");
		rom.put(9, "IX");
		rom.put(10, "X");
		rom.put(50, "L");
		rom.put(100, "C");
		rom.put(500, "D");
		rom.put(1000, "M");
		input = new char[2][];
		input[0] = br.readLine().toCharArray();
		input[1] = br.readLine().toCharArray();
		int a = romToArab(input[0]);
		int b = romToArab(input[1]);
		System.out.println(a+b);
		System.out.println(arabToRom(a+b));
	}
	private static String arabToRom(int i) {
		int num;
		int ten = 1;
		String result = "", tmp;
		while(i>0) {
			tmp = "";
			num = i%10;
			if(num == 9)
				tmp = rom.get(ten) + rom.get(ten*10);
			else {
				if(num == 4)
					tmp = rom.get(ten);
				if(num>=4) {
					tmp = tmp + rom.get(5*ten);
					num -= 5;
				}
				while(num-- > 0) {
					tmp = tmp + rom.get(ten);
				}
			}
			result = tmp + result;
			i /= 10;
			ten *= 10;
		}
		return result;
	}
	private static int romToArab(char[] rom) {
		int sum = 0, start = 0, len = rom.length;
		int cur, next1, next2;
		while(start < len) {
			cur = map.get(rom[start]);
			next1 = start+1<len?map.get(rom[start+1]):-1;
			next2 = start+2<len?map.get(rom[start+2]):-1;
			if(cur > next1) {
				sum += cur;
				start++;
			} else if(cur == next1) {
				if(next1 > next2) {
					sum += cur+next1;
					start += 2;
				} else {	// next1 == next2
					sum += cur+next1+next2;
					start += 3;
				}
			} else {	//cur < next1
				sum+= next1-cur;
				start+=2;
			}
		}
		return sum;
	}

}
