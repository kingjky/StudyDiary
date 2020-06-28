package BAEKJOON;

import java.util.Scanner;

public class Main_6603_로또_전경윤 {
	static int arr[], num[], k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while((k = sc.nextInt()) != 0) {
			arr = new int[k];
			for (int i = 0; i < k; i++) {
				arr[i] = sc.nextInt();
			}
			num = new int[6];
			combi(0, 0);
			System.out.println();
		}
	}
	private static void combi(int before, int size) {
		if(size==6) {
			for (int i : num) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = before; i < k; i++) {
			num[size] = arr[i];
			combi(i+1, size+1);
		}		
	}

}
