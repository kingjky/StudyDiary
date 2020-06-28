package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2239_스도쿠_전경윤 {
	static int[][] map, index[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		index = new int[3][9][10];
		//0: row 1: column 2: box
		String input;
		for (int r = 0; r < 9; r++) {
			input = br.readLine();
			for (int c = 0; c < 9; c++) {
				int t = map[r][c] = input.charAt(c)-'0';
				index[0][r][t]++;
				index[1][c][t]++;
				index[2][r/3*3+c/3][t]++;
			}
		}
		
		outer: for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if(map[r][c] == 0) {
					dfs(r,c);
					break outer;
				}
			}
		}
	}
	private static boolean dfs(int r, int c) {
		int num = 0;
		int i=r, j = c+1;
		if(j >= 9) {
			i++;
			j = 0;
		}
		boolean find = false;
		outer: for (; i < 9; i++) {
			for (; j < 9; j++) {
				if (map[i][j] == 0) {
					find = true;
					break outer;
				}
			}
			j = 0;
		}
		boolean end = false;
		while((num = nextFind(r,c, num+1)) > 0) {
			map[r][c] = num;
			
			if(find) {
				end = dfs(i, j);
				if(end) return true;
				else {
					index[0][r][num] = index[1][c][num] = index[2][r/3*3+c/3][num] = 0;
					map[r][c] = 0;
				}
			}
			else {
				printMap();
				return true;
			}
		}
		return false;
	}
	private static void printMap() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.printf("%d",map[i][j]);
			}
			System.out.println();
		}		
	}
	private static int nextFind(int r, int c, int num) {
		for (int i = num; i <= 9; i++) {
			if(index[0][r][i] == 0) {
				if(index[1][c][i] == 0) {
					if(index[2][r/3*3+c/3][i] == 0) {
						index[0][r][i] = index[1][c][i] = index[2][r/3*3+c/3][i] = 1;
						return num = i;
					}
				}
			}
		}
		return -1;
	}
}
