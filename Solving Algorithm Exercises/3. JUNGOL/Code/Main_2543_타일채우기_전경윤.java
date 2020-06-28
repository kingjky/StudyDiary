package com.ssafy.hw;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main_2543_타일채우기_전경윤 {
	static int[][][] blocks = {{{0,1},{1,1}},{{2,0},{2,2}},{{3,3},{0,3}},{{4,4},{4,0}}};
	static int[][] arr;
	static int X, Y, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		X = Integer.parseInt(input[0]);
		Y = Integer.parseInt(input[1]);
		
		arr = new int[N][N];
		
		divide(0,0,N/2,X,Y);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void divide(int r, int c, int size, int tR, int tC) {
		int f = find(r,c,size,tR, tC);
		draw(r+size-1,c+size-1,f);
		if(size>1) {
			if(f==0) divide(r,c, size/2, tR, tC); 		else divide(r,c, size/2, r+size-1, c+size-1);
			if(f==1) divide(r,c+size, size/2, tR, tC); 		else divide(r,c+size, size/2, r+size-1, c+size);
			if(f==2) divide(r+size,c, size/2, tR, tC); 		else divide(r+size,c, size/2, r+size, c+size-1);
			if(f==3) divide(r+size,c+size, size/2, tR, tC); else divide(r+size,c+size, size/2, r+size, c+size);
		}
	}
	private static int find(int r, int c, int size, int tR, int tC) {
		int mR = size+r;
		int mC = size+c;
		if(tR-mR < 0) {
			if(tC-mC < 0) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if(tC-mC < 0) {
				return 2;
			} else {
				return 3;
			}
		}
	}
	private static void draw(int r, int c, int num) {
		for (int i = r; i <= r+1; i++) {
			for (int j = c; j <= c+1; j++) {
				arr[i][j] += blocks[num][i-r][j-c];
			}
		}		
	}
}