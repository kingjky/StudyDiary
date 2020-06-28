package com.ssafy.exhaus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_D4_3378_스타일리쉬들여쓰기_전경윤2 {
	static int P, Q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] pq = br.readLine().split(" ");
			P = Integer.parseInt(pq[0]);
			Q = Integer.parseInt(pq[1]);
			char master[][] = new char[P][];
			char[][] mine = new char[Q][];
			for (int i = 0; i < P; i++)
				master[i] = br.readLine().toCharArray();
			for (int i = 0; i < Q; i++)
				mine[i] = br.readLine().toCharArray();

			int bracket[][] = new int[2][3];
			int point[] = new int[P];

			int[][] equation = new int[P][4];
			

			for (int i = 0; i < P; i++) {
				boolean pFlag = false, cFlag = false;
				for (int j = 0; j < master[i].length; j++) {
					if (pFlag && !cFlag) {
						equation[i][0] = bracket[0][0];
						equation[i][1] = bracket[0][1];
						equation[i][2] = bracket[0][2];
						equation[i][3] = point[i];
						cFlag = true;
					}
					switch (master[i][j]) {
					case '.':
						if (pFlag)
							break;
						else {
							point[i]++;
						}
						break;
					case '(':
						if (!pFlag)
							pFlag = true;
						bracket[1][0]++;
						break;
					case '{':
						if (!pFlag)
							pFlag = true;
						bracket[1][1]++;
						break;
					case '[':
						if (!pFlag)
							pFlag = true;
						bracket[1][2]++;
						break;
					case ')':
						if (!pFlag)
							pFlag = true;
						bracket[1][0]--;
						break;
					case '}':
						if (!pFlag)
							pFlag = true;
						bracket[1][1]--;
						break;
					case ']':
						if (!pFlag)
							pFlag = true;
						bracket[1][2]--;
						break;
					default:
						if (!pFlag)
							pFlag = true;
						break;
					}
				}
				bracket[0][0] = bracket[1][0];
				bracket[0][1] = bracket[1][1];
				bracket[0][2] = bracket[1][2];

			}
			bracket = new int[2][3];
			int[][] myE= new int[Q][3];
			
			for (int i = 0; i < Q; i++) {
				myE[i][0]=bracket[0][0];
				myE[i][1]=bracket[0][1];
				myE[i][2]=bracket[0][2];
				for (int j = 0; j < mine[i].length; j++) {
					switch (mine[i][j]) {
					case '(':
						bracket[1][0]++;
						break;
					case '{':
						bracket[1][1]++;
						break;
					case '[':
						bracket[1][2]++;
						break;
					case ')':
						bracket[1][0]--;
						break;
					case '}':
						bracket[1][1]--;
						break;
					case ']':
						bracket[1][2]--;
						break;
					default:
						break;
					}
				}
				bracket[0][0] = bracket[1][0];
				bracket[0][1] = bracket[1][1];
				bracket[0][2] = bracket[1][2];
			}
			
			int result[] = getRCS(equation, myE);
			
			System.out.printf("#%d", t);
			for (int i : result) {
				System.out.printf(" %d", i);
			}
			System.out.println();
		}
	}

	private static int[] getRCS(int[][] eq, int[][] myE) {
		int rcs[], result[], cnt=0;
		result = new int[Q];
		Arrays.fill(result, -2);
		
		for (int r = 1; r <= 20; r++) {
			for (int c = 1; c <= 20; c++) {
				outer: for (int s = 1; s <= 20; s++) {
					for (int i = 0; i < P; i++) {
						if((eq[i][0]*r)+(eq[i][1]*c)+(eq[i][2]*s)!=eq[i][3]) continue outer;
					}
					rcs = new int[] {r,c,s};
					for (int i = 0; i < Q; i++) {
						int temp = (rcs[0]*myE[i][0])+(rcs[1]*myE[i][1])+(rcs[2]*myE[i][2]);
						if(result[i]==-2) result[i] = temp;
						else if(result[i]!=temp) result[i] = -1;
					}
					
				}
			}
		}
		return result;
	}
}
