package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 0:30
 * 13000 KB
 * 76 ms
 */
public class Main_2564_경비원_전경윤 {
	static int M, N, S; // 가로 세로 상점수
	private static int[] shop;
	private static int loc;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //가로
		N = Integer.parseInt(st.nextToken()); //세로
		S = Integer.parseInt(br.readLine());
		shop = new int[S]; 
		int dir;
		int dis;
		for (int s = 0; s < S; s++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			dis = Integer.parseInt(st.nextToken());
			switch (dir) {
			case 1:	//북
				shop[s] = dis;
				break;
			case 2:	//남
				shop[s] = M+N+M-dis;
				break;
			case 3:	//서
				shop[s] = M+N+M+N-dis;
				break;
			case 4:	//동
				shop[s] = M+dis;
				break;
			}
		}
		st = new StringTokenizer(br.readLine());
		dir = Integer.parseInt(st.nextToken());
		dis = Integer.parseInt(st.nextToken());
		switch (dir) {
		case 1:	//북
			loc = dis;
			break;
		case 2:	//남
			loc = M+N+M-dis;
			break;
		case 3:	//서
			loc = M+N+M+N-dis;
			break;
		case 4:	//동
			loc = M+dis;
			break;
		}
		long sum = 0;
		for (int i = 0; i < S; i++) {
			int s = shop[i];
			sum+= Math.min(Math.abs(loc-s), 2*M+2*N-Math.abs((loc-s)));
		}
		System.out.println(sum);
	}

}
