package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질_전경윤 {
	static final int E = 100001;
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] visit = new int[E];
		Arrays.fill(visit, E);
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {N,0});
		visit[N] = 0;
		int cur, cost = 0;
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			cur = arr[0];
			cost = arr[1];
			
			if(cur == K) break;
			
			if(cur+1 < E && cost < visit[cur+1]) {
				que.offer(new int[] {cur+1,cost+1});
				visit[cur+1] = cost;
			}
			
			if(cur-1 >= 0 && cost < visit[cur-1]) {
				que.offer(new int[] {cur-1,cost+1});
				visit[cur-1] = cost;
			}
			
			
			if(cur*2 < E && cost < visit[cur*2]) {
				que.offer(new int[] {cur*2,cost+1});
				visit[cur*2] = cost;
			}
		}
		System.out.println(cost);
	}
}
