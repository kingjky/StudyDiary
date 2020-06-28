package samsung;

import java.util.Arrays;
import java.util.Scanner;

public class Main_14888 {
	static int[] num;
	static int[] op;
	static int N;
	static int cnt;
	static int[] express;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i]=sc.nextInt();
		}
		op = new int[4];
		cnt=0;
		for (int i = 0; i < 4; i++) {
			op[i]=sc.nextInt();
			cnt+=op[i];
		}
		express= new int[cnt];
		permu(express,0);
		System.out.println(max);
		System.out.println(min);
		
		
	}
	private static void permu(int[] express, int count) {
		
		if(count==cnt) {
			calculate();
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(op[i]!=0) {
				op[i]--;
				express[count]=i;
				permu(express,count+1);
				op[i]++;
			}
		}
		
	}
	private static void calculate() {
		int result=num[0];
		for(int i=0;i<cnt;i++) {
			switch (express[i]) {
			case 0:
				result+=num[i+1];
				break;
			case 1:
				result-=num[i+1];
				break;
			case 2:
				result*=num[i+1];
				break;
			case 3:
				result/=num[i+1];
				break;

			}
		}
		
		min = Math.min(result, min);
		max = Math.max(result, max);
		
	}

}
