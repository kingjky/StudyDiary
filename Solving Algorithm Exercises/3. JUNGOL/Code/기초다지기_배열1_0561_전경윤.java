package ssafy.jungol;

import java.util.Scanner;

public class 기초다지기_배열1_0561_전경윤 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tmp;
		int max, min;
		max = -1; min = 10000;
		for (int i = 0; i < 10; i++) {
			tmp = sc.nextInt();
			if(tmp<100 && max<tmp)
				max = tmp;
			else if(tmp>=100 && min>tmp)
				min = tmp;
		}
		if(max != -1)
			System.out.print(max + " ");
		else
			System.out.print("100 ");
		
		if(min != 10000)
			System.out.print(min);
		else
			System.out.print("100");
		
	}

}
