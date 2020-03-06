# [SWEA] D5_7396_종구의딸이름짓기 [JAVA]

## 문제

딸을 얻은 종구는 이름을 짓기 위해 작명소를 찾았다.

작명소의 룰에 따르면, 종구는 딸의 이름을 얻기 위해서 N행 M열의 보드의 각 칸에 알파벳 소문자를 하나씩 기입하여 작명소에 제출해야 한다.

작명소는 이 보드를 이용하여 이름을 짓는데, 다음과 같은 방식을 이용한다.

보드의 왼쪽 위부터 오른쪽 혹은 아래쪽으로 이동하여 보드의 오른쪽 아래에 도달하는 경로를 선택한다.

경로에 속하는 알파벳을 순서대로 이어 붙여서 이름을 만드는데,

가능한 이름 중에서 사전 순으로 가장 앞선 것을 이름으로 택한다.

종구가 작성한 보드가 주어졌을 때, 해당 보드로는 어떤 이름이 얻어지는지 구하는 프로그램을 작성하라.


**[입력]**

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 두 정수 N, M(1 ≤ N, M ≤ 2,000)이 공백 하나로 구분되어 주어진다.

각 테스트 케이스의 두 번째 줄부터 N개의 줄에 걸쳐서 종구가 기입한 보드의 정보가 들어온다.

보드는 모두 알파벳 소문자로 이루어져 있다.


**[출력]**

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

주어진 보드에 맞는 이름을 출력하라.

| 입력                                                         | 출력                                       |
| ------------------------------------------------------------ | ------------------------------------------ |
| 3<br/>2 5<br/>adbfc<br/>dcghi<br/>5 5<br/>bbbbb<br/>bbbbb<br/>bazbb<br/>bzbbb<br/>bbbbb<br/>4 5<br/>ponoc<br/>ohoho<br/>hlepo<br/>mirko | #1 adbfci<br/>#2 bbbazbbbb<br/>#3 pohlepko |


## 풀이 방법

- 최초 풀이
  - Greedy 하게, (1,1) 에서 시작하여 우측, 아래측 중 알파벳 순으로 더 빠른 위치로 이동하며 (N,N)까지 이동
    => 우측과 아래측 알파벳이 같은 경우 불가능
- 더 나은 풀이
  - 생성된 이름의 0번 index는 출발지 알파벳이며 1번 index는 우측 또는 아래측 중 빠른 것 하나,
    => n번 index는 출발지로부터 n칸 떨어진 알파벳들 중 가장 빠른 것 하나
  - BFS_ver2 를 통해 출발지로부터 거리가 같은 칸끼리 비교하여 각 위치에서 사전 순 가장 빠른 알파벳을 선택

## 실행 코드

- 더 나은 풀이 실행 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D5_7396_종구의딸이름짓기 {

	static char[][] map;
	static boolean[][] visit;
	static int N, M;
	static int[] di = {0,1};
	static int[] dj = {1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][];
			visit = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			PriorityQueue<Point> pq = new PriorityQueue<>();
			ArrayList<Point> list = new ArrayList<>();
			pq.add(new Point(0,0, map[0][0])); //출발점
			visit[0][0] = true;
			
			while(!pq.isEmpty()) {
				int size = pq.size();
				
				Point first = pq.peek();	// 현재 큐에 있는 글자 중 알파벳 순 제일 빠른 것을 확보
				for (int s = 0; s < size; s++) { // 이름의 같은 index에 올 가능성이 있는 글자들 조사
					Point now = pq.poll();
					
					if(first.ch == now.ch) {
						for (int d = 0; d < 2; d++) {
							int ni = now.i + di[d];
							int nj = now.j + dj[d];
							
							if(ni>=0 && nj<N && nj>=0 && nj<M && !visit[ni][nj]) {
								list.add(new Point(ni, nj, map[ni][nj]));	// 리스트에 옮겨 담는 작업
								visit[ni][nj] = true;
							}
						}
					} else {
						break;
					}
				}	// 출발점에서 거리가 같은 좌표의 탐색이 끝난 시점
				pq.clear();	// 남은 알파벳은 버림
				pq.addAll(list);	// 다음 턴에 갈 알파벳들 pq에 삽입
				list.clear();
			}
		}
	}
	static class Point implements Comparable<Point> {
		int i, j;
		char ch;
		private Point(int i, int j, char ch) {
			super();
			this.i = i;
			this.j = j;
			this.ch = ch;
		}
		@Override
		public int compareTo(Point o) {
			return this.ch - o.ch;
		}
		
	}
}

```

| 메모리     | 실행시간 |
| ---------- | -------- |
| 100,940 kb | 264 ms   |

