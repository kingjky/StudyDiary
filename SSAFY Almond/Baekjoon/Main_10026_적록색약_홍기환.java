package bfs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_10026 {
	static int map1[][];
	static int map2[][];
	static int N;
	static Queue<Point> q;
	static int dir[][]= {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=Integer.parseInt(sc.nextLine());
		map1 = new int [N][N];
		map2 = new int [N][N];
		for(int i=0;i<N;i++) {
			String st = sc.nextLine();
			for(int j=0;j<N;j++) {
				char c = st.charAt(j);
				switch (c) {
				case 'R':
					map1[i][j]=1;
					map2[i][j]=1;
					break;
				case 'G':
					map1[i][j]=2;
					map2[i][j]=1;
					break;
				case 'B':
					map1[i][j]=3;
					map2[i][j]=3;
					break;
				default:
					break;
				}
			}
		}
		
		int cnt1=0;
		int cnt2=0;
		q=new LinkedList<Point>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map1[i][j]!=0) {
					q.add(new Point(i,j));
					int f=map1[i][j];
					map1[i][j]=0;
					bfs1(f);
					cnt1++;
				}
				if(map2[i][j]!=0) {
					q.add(new Point(i,j));
					int g=map2[i][j];
					map2[i][j]=0;
					bfs2(g);
					cnt2++;
				}
			}
		}
		
		System.out.println(cnt1+" "+cnt2);
	}
	private static void bfs1(int flag) {
		while(!q.isEmpty()) {
			Point p = q.remove();
			int x=p.x;
			int y=p.y;
			for(int i=0;i<4;i++) {
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(map1[nx][ny]==flag) {
						map1[nx][ny]=0;
						q.add(new Point(nx,ny));
					}
				}
				
			}
		}
		
	}
	private static void bfs2(int flag) {
		while(!q.isEmpty()) {
			Point p = q.remove();
			int x=p.x;
			int y=p.y;
			for(int i=0;i<4;i++) {
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(map2[nx][ny]==flag) {
						map2[nx][ny]=0;
						q.add(new Point(nx,ny));
					}
				}
				
			}
		}
		
	}

}
