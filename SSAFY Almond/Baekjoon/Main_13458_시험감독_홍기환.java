package samsung;

import java.util.Scanner;

public class Main_13458 {
	static int N;
	static int B;
	static int C;
	static int[] room; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		room = new int [N];
		for(int i=0;i<N;i++) {
			room[i]=sc.nextInt();
		}
		B=sc.nextInt();
		C=sc.nextInt();
		long cnt=0;
		for(int i=0;i<N;i++) {
			room[i]=room[i]-B;
			cnt++;
			if(room[i]>0) {
				if(room[i]%C==0) {
					cnt+=room[i]/C;
				}else {
					cnt+=room[i]/C+1;
				}
			}
			
			
		}
		System.out.println(cnt);
	}
	
}
