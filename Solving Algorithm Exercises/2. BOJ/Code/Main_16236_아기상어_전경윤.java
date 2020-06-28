import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어_전경윤 {
	static int N, Map[][], T, babyLoc[], fishLoc[], ateNum, dis,
				dR[] = {-1,0,0,1}, dC[] = {0,-1,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 맵 크기
		StringTokenizer st;
		Map = new int[N][N];
		babyLoc = new int[3];
		fishLoc = new int[3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
				if(Map[i][j] == 9) {
					babyLoc[0] = i; 
					babyLoc[1] = j; 
					Map[i][j] = 0;
				}
			}
		}
		babyLoc[2] = 2;
		T = ateNum = 0;
		while(findFish()) {
			eatFish();
		}
		System.out.println(T);
	}
	private static boolean findFish() {	//BFS
		Queue<int[]> que = new LinkedList<int[]>();
		ArrayList<int[]> fish = new ArrayList<int[]>();
		boolean visit[][] = new boolean[N][N];
		que.offer(new int[] {babyLoc[0], babyLoc[1], babyLoc[2], 0});
		visit[babyLoc[0]][babyLoc[1]]=true;
		
		while(!que.isEmpty()) {
			int[] l = que.poll();
			int r = l[0], c = l[1], s = l[2], d = l[3], newR, newC;
			if(dis!=0 && d>dis) {
				break;
			} 
			if(s!=0 && s<babyLoc[2]) {
				if(dis == 0) {
					dis = d;
					fish.add(l);
				} else if(d == dis) fish.add(l);
			}
			for (int k = 0; k < 4; k++) {
				newR = r+dR[k];
				newC = c+dC[k];
				if(newR<0 || newR>=N ||newC<0 || newC>=N) continue;
				if(!visit[newR][newC]) {
					visit[newR][newC] = true;
					if(Map[newR][newC]>babyLoc[2]) continue;
					que.offer(new int[] {newR, newC, Map[newR][newC], d+1});
				}
			}
		}
		if(fish.isEmpty()) return false;
		Collections.sort(fish, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] != o2[0])
					return Integer.compare(o1[0], o2[0]);
				else
					return Integer.compare(o1[1], o2[1]);
			}
		});
		int[] f = fish.get(0);
		fishLoc[0] = f[0];
		fishLoc[1] = f[1];
		fishLoc[2] = f[2];
		return true;
	}
	private static void eatFish() {
		babyLoc[0] = fishLoc[0];
		babyLoc[1] = fishLoc[1];
		if(++ateNum == babyLoc[2]) {
			babyLoc[2]++;
			ateNum = 0;
		}
		T += dis;
//		System.out.println(fishLoc[0]+","+fishLoc[1]+" : "+fishLoc[2]+" 생선, " + dis +"초, 총"+ T +"초, 크기 : " + babyLoc[2]);
		dis = 0;
		Map[fishLoc[0]][fishLoc[1]] = 0;
	}
}