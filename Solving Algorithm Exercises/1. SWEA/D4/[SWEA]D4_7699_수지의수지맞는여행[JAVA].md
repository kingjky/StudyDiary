# [SWEA]D4_7699_수지의수지맞는여행[JAVA]

## 문제

평소에 여행을 즐기는 수지는 이번에 새로운 섬에 도착했다.

이 섬은 1행, 1열로 시작해서 R행, C열까지 있으며, 총 R*C 칸으로 이루어져 있다.

수지는 지금 1행 1열에 있으며 앞으로 있을 야근을 위하여 기회 있을 때 미리 여행을 떠나려고 한다.

이 섬의 각 칸에는 알파벳이 적혀있다. 이 알파벳은 섬의 명물이고, 같은 알파벳은 같은 명물이다.

이 섬에서는 명물을 볼 때마다 요금을 지급해야 하는데 각 알파벳 명물을 처음 볼 땐 무료로 볼 수 있다.

그리고, 수지는 여행을 할 때 자신이 있는 지점의 명물을 본 후 4방향(상, 하, 좌, 우) 중 한 방향으로 1칸 이동 후 다음 명물을 보는 행동을 반복한다.


올해 SGA사 1년 차인 수지는 현재 대출빚과 카드빚에 허덕이고 있다.

따라서, 명물을 최대한 많이 보되, 요금을 지급하지 않는 방법을 택해야 한다.

수지가 1행 1열에서 여행을 시작했을 때, 같은 알파벳 명물을 두 번 이상 보지 않도록 여행을 떠나는 방법 중에 볼 수 있는 명물의 최대 개수를 구하여라.


**[입력]**

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 섬의 크기 R,C(1≤R,C≤20)가 주어진다.

이어서 R개의 줄마다 C개의 알파벳 대문자가 빈 칸 없이 주어진다.

**[출력]**

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

각 테스트 케이스마다 수지가 여행하면서 볼 수 있는 명물 개수의 최대치를 출력하라.

| 입력                                                         | 출력                    |
| ------------------------------------------------------------ | ----------------------- |
| 3<br/>2 4<br/>CAAB<br/>ADCB<br/>3 6<br/>HFDFFB<br/>AJHGDH<br/>DGAGEH<br/>5 5<br/>IEFCJ<br/>FHFKC<br/>FFALF<br/>HFGCF<br/>HMCHH | #1 3<br/>#2 6<br/>#3 10 |


## 풀이 방법

- 최초 풀이
  - DFS로 4방 탐색하며 직접 방문한다
  - 알파벳 26개에 대한 방문 검사 배열을 통해 이미 관람한 명물의 경우 방문하지 않는다
  - 매 방문마다 관람 명물 갯수를 Max 값과 비교하며 갱신
    - 답의 최대값이 알파벳 갯수 26이므로, 26 일 경우 종료 조건을 추가했더니 실행시간 대폭 감소
  - ! 주의 : dfs(num++) 혹은 dfs(++num) 대신 dfs(num + 1)

## 실행 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7699_수지의수지맞는여행 {

	static int[] dR = {-1, 1, 0, 0};
	static int[] dC = {0, 0, -1, 1};
	static int R, C;
	static int map[][];
	static boolean visit[];
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			visit = new boolean['Z' - 'A' + 1];
			max = -1;
			
			String input;
			for (int r = 0; r < R; r++) {
				input = br.readLine();
				for (int c = 0; c < C; c++) {
					map[r][c] = input.charAt(c) - 'A';
				}
			}
			
			visit[map[0][0]] = true;
			dfs(0, 0, 1);
			sb.append('#').append(t).append(' ').append(max).append('\n');
		}
		System.out.print(sb.toString());
	}

	private static void dfs(int r, int c, int num) {
		if(max >= 26) return;
		if(max < num) max = num;
		int nR, nC;
		for (int k = 0; k < 4; k++) {
			nR = r + dR[k];
			nC = c + dC[k];
			if(nR < 0 || nR >= R || nC < 0 || nC >= C) continue;
			int next = map[nR][nC];
			if(visit[next]) continue;
			visit[next] = true;
			dfs(nR, nC, num+1);
			visit[next] = false;
		}
	}
}
```

| 메모리    | 실행시간 |
| --------- | -------- |
| 26,940 kb | 130 ms   |

