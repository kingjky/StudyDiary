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

## 실행 코드 

- 나의 코드

```java
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_PRO_5684_운동 {

	static int N, M;
	static long adj[][], min;
	static boolean visit[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
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



