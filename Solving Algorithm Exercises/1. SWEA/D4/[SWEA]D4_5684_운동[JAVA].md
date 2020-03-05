# [SWEA]PRO_5684_운동[JAVA]

## 문제

N개의 건물과 M개의 도로로 구성되어 있는 마을이 있다.

도로는 건물과 건물 사이에 놓여 있으며, 일방 통행 도로이다.

건물의 번호는 1번부터 N번까지 각각 주어져있다.


원철이는 마을의 도로를 따라 운동을 하기 위한 경로를 찾으려고 한다.

운동을 한 후에는 다시 시작점으로 돌아오는 것이 편하기 때문에, 원철이는 사이클을 찾기를 원한다.

단, 운동을 하는 도중 무슨 일이 생길지 모르므로, 사이클을 이루는 도로의 길이의 합이 최소가 되도록 찾으려고 한다.


도로의 정보가 주어졌을 때, 도로의 길이의 합이 가장 작은 사이클을 찾는 프로그램을 작성하시오.

두 마을을 왕복하는 경우도 사이클에 포함됨에 주의하시오.

**[입력]**

첫 줄에 테스트케이스의 개수 T가 주어진다. (1 ≤ T ≤ 20)

각 테스트 케이스의 첫 번째 줄에 건물의 수 N과 도로의 수 M이 주어진다. (2 ≤ N ≤ 400, 2 ≤ M ≤ N*(N-1))

각 테스트 케이스의 두 번째 줄부터 M개의 줄에 걸쳐 도로의 정보 s, e, c가 주어진다.

이는 s번 건물으로부터 e번 건물으로 이동하는 길이 c의 일방 통행 도로가 있다는 의미이다.

거리는 10,000 이하의 자연수이고, 같은 시작점과 도착점을 가진 간선은 최대 한 개 등장한다.


**[출력]**

각 테스트케이스마다 한 줄에 걸쳐, 테스트케이스 수 “#(TC) “를 출력하고, 도로의 길이의 합이 가장 작은 사이클의 길이를 출력한다. 만약, 그러한 사이클을 찾을 수 없다면 -1을 출력한다.



| 입력                                                         | 출력                     |
| ------------------------------------------------------------ | ------------------------ |
| 1      // 전체 테스트케이스 개수<br/>3 4    // 첫 번째 TC의 N M<br/>1 2 1  // 첫 번째 s e c<br/>3 2 1  // 두 번째 s e c<br/>1 3 5<br/>2 3 2 | #1 3 // 1번 TC의 출력 값 |


## 풀이 방법

- 최초 풀이

  - Floyd Warshall 알고리즘을 적용하여 정점간 최소거리를 모두 계산한 뒤,
    정점 n에서 n으로 가는, 즉 돌아오는 거리의 최소값을 답으로 출력한다.
- 실행 시간이 너무 오래 걸린다
- 더 나은 풀이
  - 문제분석
    - 가중치 방향성 그래프의 간선 정보가 주어졌을 때 N개의 정점 사이에서 최소비용의 사이클 찾기
    - 분석
      1. 모든 정점에서 출발해보는 시도 필요
      2. disjoint-set 사용? 유향 그래프이므로 불가능
      3. 방문처리 visit을 사용하는 방법? 재방문 필수인 케이스 존재
    - 주의사항
      1. 두 마을의 왕복도 사이클로 들어가야 함. 고려되는지 확인
      2. 간선의 길이는 자연수
      3. 사이클이 없다면 -1을 출력해야 하는 케이스도 존재

## 실행 코드 

- 최초 코드

```java
import java.util.Scanner;

public class Solution_D4_5684_운동 {

	static int N, M;
	static long adj[][], min;
	static boolean visit[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();

			adj = new long[N + 1][N + 1];
			visit = new boolean[N + 1][N + 1];
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++)
					adj[i][j] = Long.MAX_VALUE;
			

			int s, e, c;
			for (int m = 0; m < M; m++) {
				s = sc.nextInt();
				e = sc.nextInt();
				c = sc.nextInt();

				adj[s][e] = c;
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i == j) continue;
					for (int k = 1; k <= N; k++) {
						if(i == k) continue;
						if(adj[j][i] < Long.MAX_VALUE && adj[i][k] < Long.MAX_VALUE) {
							if(adj[j][k] > adj[j][i] + adj[i][k])
								adj[j][k] = adj[j][i] + adj[i][k];
						}
					}
				}
			}
			
			min = Long.MAX_VALUE;
			for (int n = 1; n <= N; n++) {
				if(min > adj[n][n]) min = adj[n][n];
			}
			sb.append('#').append(t).append(' ').append(min < Integer.MAX_VALUE ? min : -1).append('\n');
		}
		System.out.print(sb.toString());
	}
}
```

| 메모리    | 실행시간 |
| --------- | -------- |
| 92,172 kb | 1,515 ms |

- 더 나은 코드, adjacency matrix

```java
import java.util.Scanner;

public class Solution_D4_5684_운동 {
    static int[][] graph; // 방향성 있는 가중치 그래프를 인접 행렬을 써보자.
    static int ans;
    static boolean[] visit;
    static int N, M; // 정점 갯수, 간선 갯수
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        
        for(int tc=1; tc<=TC; tc++) {
            ans = Integer.MAX_VALUE; 
            N = sc.nextInt();
            M = sc.nextInt();
            
            graph = new int[N+1][N+1]; // 1~N까지 정점번호 그대로 쓸 예정
            for(int m=0; m<M; m++) {
            	int s = sc.nextInt(); // start 정점
                int e = sc.nextInt(); // end 정점
                int c = sc.nextInt(); // cost
                
                graph[s][e] = c;
            }
            
            for(int now=1; now<=N; now++) {
                visit = new boolean[N+1]; // 출발할때 이전의 방문 정보는 초기화 해버리자!
                dfs(now, now, 0); // now에서 출발!
            }
            
            System.out.println("#"+tc+" "+(ans==Integer.MAX_VALUE?-1:ans));
        }
        
    }
    
    static void dfs(int now, int start, int dist) { // 현재 서있는 정점, 출발지 정점 어디였는지
        if(now==start && visit[now]) { // 출발점으로 돌아왔네 ?! 사이클이당 ~~ 
            if(dist < ans)
                ans = dist;
            return;
        }
        
        if(visit[now]){ // 출발점에 대한 재방문이면 위의 조건문이 걸렸을 거지만, 출발이 아닌 정점의 재방문은 지금 나한테는 관심없는 사이클 더 진행하지 말아라 !
            return;
        }
        
        if(dist >= ans) // 최소 사이클을 찾고 싶은건데 이미 이전에 찾은 사이클보다 넘 많이 걸었어.. 이 길은 안가봐도 되겠다~
            return;
        
        visit[now] = true;
        for(int i=1; i<=N; i++) {
            if(graph[now][i]>0) { // 현재 정점에서 이동가능한 다음 next 정점 찾는 작업.
                dfs(i, start, dist+graph[now][i]);
            }
        }
    }
}
```

| 메모리   | 실행시간 |
| -------- | -------- |
| 83,068kb | 296 ms   |
- 더 나은 코드, adjacency list

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_D4_5684_운동 {
    static int ans;
    static List<Edge>[] edgeList;
    static int N, M;
    static boolean[] visit;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            ans = Integer.MAX_VALUE;
            N = sc.nextInt();
            M = sc.nextInt();
            edgeList = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                edgeList[i] = new ArrayList();
            }

            for (int i = 0; i < M; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int c = sc.nextInt();
                edgeList[s].add(new Edge(e, c)); // 인접 리스트의 인덱스로 출발점을 처리함.
            }

            for (int i = 1; i <= N; i++) {
                visit = new boolean[N+1];
                dfs(i, i, 0); // 현재정점, 출발점, 누적거
            }
            System.out.println("#" + tc + " " + (ans==Integer.MAX_VALUE?-1:ans));
        }
    }

    public static void dfs(int now, int start, int sum) {
        
        if (visit[now] && now == start) { //출발하자 마자는 now == start 이므로 방문 처리 순서를 신경써야함.
            if (sum < ans)
                ans = sum;
            return;
        }
        if (visit[now] || sum>=ans) // 재귀를 호출할 때 방문에 대한 조건을 안걸었었음. 출발점으로 돌아오지 않았지만 이미 방문한 점이면 여기서 끊기.
            return;
        
        visit[now] = true;

        for (Edge next: edgeList[now]) { 
            // 보통 재귀 호출할 때 이미 방문했는지 체크해서 보내지만 우리는 그냥 보내기로 함. 이미 방문했던 출발점도 가야하니까. 
            dfs(next.num, start, sum+next.cost);
        }
    }

    static class Edge {
        int num, cost; //이 간선을 따라가면 있 정점번호, 비용.

        Edge(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
}
```

| 메모리    | 실행시간 |
| --------- | -------- |
| 84,864 kb | 276 ms   |