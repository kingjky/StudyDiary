package ssafy.baekjoon.L1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2753_À±³â_Àü°æÀ± {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Y = sc.nextInt();
		
		if(Y % 400 == 0) {
			System.out.println("1");
			return;
		}else if((Y%4==0) && !(Y%100==0)) {
			System.out.println("1");
			return;
		}
		else {
			System.out.println("0");
			return;
		}			
	}
}
