package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2_전경윤 {
	private static int N;
	private static int M;
	private static char[][] map;
	static int[] R, B;
	private static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		String s;
		map = new char[N][M];
		R = new int[2];
		B = new int[2];
		char c;
		for (int n = 0; n < N; n++) {
			s = br.readLine();
			for (int m = 0; m < M; m++) {
				c = s.charAt(m);
				if(c=='R') {
					R[0] = n;
					R[1] = m;
					map[n][m] = '.';
				} else if(c=='B') {
					B[0] = n;
					B[1] = m;
					map[n][m] = '.';
				} else {
					map[n][m] = c;
				}
			}
		}
		min = 11;
		if(dfs(0, 0))
			System.out.println(min);
		else
			System.out.println(-1);
	}
	private static boolean dfs(int i, int prev) {
		if(i>=10) {
			return false;
		}
		int tmp = -1; //0: 다음 1:실패 2:성공
		boolean result = false;
		int rR = R[0];
		int rC = R[1];
		int bR = B[0];
		int bC = B[1];
		
		if(prev != 1) {
			tmp = right();
			if(tmp==0) {
				result |= dfs(i+1, 1);
			} else if (tmp==2) {
				min = Math.min(min, i+1);
				return true;
			}
			R[0] = rR;
			R[1] = rC;
			B[0] = bR;
			B[1] = bC;
		}
		
		if(prev != 2) {
			tmp =  down();
			if(tmp==0) {
				result |= dfs(i+1, 2);
			} else if (tmp==2) {
				min = Math.min(min, i+1);
				return true;
			}
			R[0] = rR;
			R[1] = rC;
			B[0] = bR;
			B[1] = bC;
		}
		
		if(prev != 3) {
			tmp = left();
			if(tmp==0) {
				result |= dfs(i+1, 3);
			} else if (tmp==2) {
				min = Math.min(min, i+1);
				return true;
			}
			R[0] = rR;
			R[1] = rC;
			B[0] = bR;
			B[1] = bC;
		}
		
		if(prev != 4) {
			tmp = up();
			if(tmp==0) {
				result |= dfs(i+1, 4);
			} else if (tmp==2) {
				min = Math.min(min, i+1);
				return true;
			}
			R[0] = rR;
			R[1] = rC;
			B[0] = bR;
			B[1] = bC;
		}		
		return result;
	}
	private static int up() {
		int rR = R[0], rC = R[1];
		int bR = B[0], bC = B[1];
		boolean upperRed = rR>bR;
		while(map[rR][rC]!='#' && map[rR][rC]!='O') {
			rR--;
		}
		boolean holeIn = (map[rR][rC]=='O');
		rR++;
		while(map[bR][bC]!='#' && map[bR][bC]!='O') {
			bR--;
		}
		if(map[bR][bC] == 'O') 
			return 1;
		bR++;
		if(rC == bC && rR == bR) {
			if(upperRed) {
				rR++;
			} else {
				bR++;
			}
		}
		if(!holeIn && R[0] == rR && R[1] == rC && B[0] == bR && B[1] == bC)
			return 1;
		else {
			R[0] = rR;
			R[1] = rC;
			B[0] = bR;
			B[1] = bC;
			return holeIn?2:0;
		}		
	}
	private static int left() {
		int rR = R[0], rC = R[1];
		int bR = B[0], bC = B[1];
		boolean upperRed = rC>bC;
		while(map[rR][rC]!='#' && map[rR][rC]!='O') {
			rC--;
		}
		boolean holeIn = (map[rR][rC]=='O');
		rC++;
		while(map[bR][bC]!='#' && map[bR][bC]!='O') {
			bC--;
		}
		if(map[bR][bC] == 'O') 
			return 1;
		bC++;
		if(rC == bC && rR == bR) {
			if(upperRed) {
				rC++;
			} else {
				bC++;
			}
		}
		if(!holeIn && R[0] == rR && R[1] == rC && B[0] == bR && B[1] == bC)
			return 1;
		else {
			R[0] = rR;
			R[1] = rC;
			B[0] = bR;
			B[1] = bC;
			return holeIn?2:0;
		}	
	}
	private static int down() {
		int rR = R[0], rC = R[1];
		int bR = B[0], bC = B[1];
		boolean upperRed = rR<bR;
		while(map[rR][rC]!='#' && map[rR][rC]!='O') {
			rR++;
		}
		boolean holeIn = (map[rR][rC]=='O');
		rR--;
		while(map[bR][bC]!='#' && map[bR][bC]!='O') {
			bR++;
		}
		if(map[bR][bC] == 'O') 
			return 1;
		bR--;
		if(rC == bC && rR == bR) {
			if(upperRed) {
				rR--;
			} else {
				bR--;
			}
		}
		if(!holeIn && R[0] == rR && R[1] == rC && B[0] == bR && B[1] == bC)
			return 1;
		else {
			R[0] = rR;
			R[1] = rC;
			B[0] = bR;
			B[1] = bC;
			return holeIn?2:0;
		}	
	}
	private static int right() {
		int rR = R[0], rC = R[1];
		int bR = B[0], bC = B[1];
		boolean upperRed = rC<bC;
		while(map[rR][rC]!='#' && map[rR][rC]!='O') {
			rC++;
		}
		boolean holeIn = (map[rR][rC]=='O');
		rC--;
		while(map[bR][bC]!='#' && map[bR][bC]!='O') {
			bC++;
		}
		if(map[bR][bC] == 'O') 
			return 1;
		bC--;
		if(rC == bC && rR == bR) {
			if(upperRed) {
				rC--;
			} else {
				bC--;
			}
		}
		if(!holeIn && R[0] == rR && R[1] == rC && B[0] == bR && B[1] == bC)
			return 1;
		else {
			R[0] = rR;
			R[1] = rC;
			B[0] = bR;
			B[1] = bC;
			return holeIn?2:0;
		}
	}
}
