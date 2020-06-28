package com.ssafy.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2636_치즈_전경윤 {
	static int R, C, arr[][], cheese;
	static int dR[] = {0,1,0,-1};
	static int dC[] = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		arr = new int[R][C];
		
		cheese = 0;
		for (int r = 0; r < R; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < C; c++) {
				arr[r][c] = Integer.parseInt(input[c]);
				if(arr[r][c]>0) cheese++;
			}
		}
		int num = -1, time = 0;
		while(cheese>0) {
			air_check();
			num = melt_cheese();
			melting();
			air_uncheck();
			cheese -= num;
			time++;
		}
		System.out.println(time);
		System.out.println(num);
	}
	private static void air_uncheck() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(arr[r][c]==8) arr[r][c]=0;
			}
		}
	}
	private static void melting() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(arr[r][c]==9) arr[r][c]=8;
			}
		}
	}
	private static int melt_cheese() {
		int count = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(arr[r][c] == 1) {
					int newR, newC;
					for (int i = 0; i < 4; i++) {
						newR = r+dR[i];
						newC = c+dC[i];
						
						if(arr[newR][newC]==8) {
							arr[r][c] = 9;
							count++;
							break;
						}
					}
				}
			}
		}
		return count;
	}
	
	private static void air_check() {
		int newR, newC;
		
		Queue<int[]> que = new LinkedList<int[]>(); 
		que.offer(new int[] {0, 0});
		
		while(!que.isEmpty()) {
			int[] p = que.poll();
			for (int i = 0; i < 4; i++) {
				newR = p[0] + dR[i];
				newC = p[1] + dC[i];
				if(newR < 0 || newR >= R || newC < 0 || newC >= C) continue;
				else if(arr[newR][newC]==0) {
					arr[newR][newC] = 8;
					que.offer(new int[] {newR, newC});
				}
			}
		}
	}
}