# [SWEA]D4_8382_방향전환[JAVA]

## 문제

(x1, y1 )에서 (x2, y2)로 이동하려고 한다.

(x, y)에서 한 번 이동하면 (x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)로 이동할 수 있다.

이 중에서, (x + 1, y), (x - 1, y)로 이동하는 것은 가로 이동, (x, y + 1), (x , y - 1)로 이동하는 것은 세로 이동이라고 한다.

정우는 그냥 (x1, y1)에서 (x2, y2)로 이동하는 것은 재미가 없다고 생각한다.

그래서 이전 이동이 가로 이동이었다면, 이번에는 세로 이동으로 이동하고, 이전 이동이 세로 이동이었다면, 이번에는 가로 이동으로 이동하여 (x1, y1)에서 (x2, y2)로 이동하려고 한다.

가장 첫 이동은 어떤 이동 이어도 상관 없다.

이 때, 최소 몇 번의 이동을 해야 (x1, y1)에서 (x2, y2)로 이동할 수 있는지 구하는 프로그램을 작성하라.


**[입력]**

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 네 정수 x1, y1, x2, y2 (-100 ≤ x1, y1, x2, y2 ≤ 100)이 공백 하나로 구분되어 주어진다.


**[출력]**

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

각 테스트 케이스마다 최소 몇 번의 이동을 해야 하는지 출력한다.


| 입력                                                         | 출력                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 3 // 테스트 케이스 개수<br/>0 0 1 0 // 첫 번째 테스트 케이스 (0, 0) (1,0)<br/>-1 -1 0 0 // 두 번째 테스트 케이스<br/>0 0 0 2 // 세 번째 테스트 케이스 | #1 1 // 첫 번째 테스트 케이스 결과<br/>#2 2 // 두 번째 테스트 케이스 결과<br/>#3 4 // 세 번째 테스트 케이스 결과 |


## 풀이 방법

1. ### BFS 탐색

2. ### 규칙성을 이용한 수학적 풀이



## 실행 코드

### 방향 전환1

```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BFS
public class Solution_D4_8382_방향전환 {
	private static class Point{
		int x, y, cnt;
		boolean dir;
		private Point(int x, int y, int c, boolean d) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = c;
			this.dir = d;
		}		
	}
	static int sx, sy, fx, fy;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sx = sc.nextInt() + 100;
			sy = sc.nextInt() + 100;
			fx = sc.nextInt() + 100;
			fy = sc.nextInt() + 100;
			
			//BFS탐색을 위한 Queue자료구조를 준비
			Queue<Point> queue = new LinkedList<>();
			//방문체크를 위한 방문체크 변수를 준비
			boolean[][][] visited = new boolean[201][201][2];
			//시작점을 큐에 삽입
			// 첫 시작점을 현재 위치로, 다음 이동을 가로로 이동할 수 있는 상태
			queue.add(new Point(sx, sy, 0, true));
			// 첫 시작점을 현재 위치로, 다음 이동을 세로로 이동할 수 있는 상태
			queue.add(new Point(sx, sy, 0, false));
			//큐에 이미 삽입된 상태에 대해서는 방문체크
			visited[sx][sy][0] = true;
			visited[sx][sy][1] = true;
			
			//큐가 빌때까지 상태를 탐색
			while(!queue.isEmpty()) {
				Point point = queue.poll();
				// 현재 도달한 상태의 좌표가 목적지라면 종료
				if(point.x == fx && point.y == fy) {
					System.out.printf("#%d %d\n", tc, point.cnt);
					break;
				}
				
				if(point.dir) {
					//	현재 자신의 방향이 가로로 허용된 경우
					//	두가지 세로이동에 대해서 유효하다면(범위체크, 방문체크), 상태노드를 큐에 추가 후 방문 체크
					for (int d = 0; d < 2; d++) {
						int nx = point.x + dx[d];
						int ny = point.y + dy[d];
						if(nx < 0 || nx > 200 || ny < 0 || ny > 200) continue;
						if(visited[nx][ny][0]) continue;
						queue.add(new Point(nx, ny, point.cnt + 1, !point.dir));
						visited[nx][ny][0] = true;
					}
				} else {
					//	현재 자신의 방향이 세로로 허용된 경우
					//		두가지 가로이동에 대해서 유효하다면(범위체크, 방문체크), 상태노드를 큐에 추가 후 방문 체크
					for (int d = 2; d < 4; d++) {
						int nx = point.x + dx[d];
						int ny = point.y + dy[d];
						if(nx < 0 || nx > 200 || ny < 0 || ny > 200) continue;
						if(visited[nx][ny][1]) continue;
						queue.add(new Point(nx, ny, point.cnt + 1, !point.dir));
						visited[nx][ny][1] = true;
					}
				}
			}
		}
	}
}
```

### 방향 전환2

```java
import java.util.Scanner;

public class Solution_D4_8382_방향전환2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int fx = sc.nextInt();
			int fy = sc.nextInt();
			
			int dx = Math.abs(sx-fx);
			int dy = Math.abs(sy-fy);
			
			int min = Math.min(dx, dy);
			int d = Math.abs(dx-dy);
			
			int result = 0;
			result += min*2;
			if(d > 0)
			result += (d%2 == 0)? d*2 : (d-1)*2 +1; 
			
			System.out.printf("#%d %d\n", tc, result);
		}
	}
}
```

