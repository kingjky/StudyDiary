# [PROG] 1829_카카오프렌즈컬러링북 [JAVA]

## 문제

## 카카오 프렌즈 컬러링북

출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다. 여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)

그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.

![alt text](http://t1.kakaocdn.net/codefestival/apeach.png)

위의 그림은 총 12개 영역으로 이루어져 있으며, 가장 넓은 영역은 어피치의 얼굴면으로 넓이는 120이다.

**[입출력]**

### 입력 형식

입력은 그림의 크기를 나타내는 `m`과 `n`, 그리고 그림을 나타내는 `m × n` 크기의 2차원 배열 `picture`로 주어진다. 제한조건은 아래와 같다.

- `1 <= m, n <= 100`
- `picture`의 원소는 `0` 이상 `2^31 - 1` 이하의 임의의 값이다.
- `picture`의 원소 중 값이 `0`인 경우는 색칠하지 않는 영역을 뜻한다.

### 출력 형식

리턴 타입은 원소가 두 개인 정수 배열이다. 그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.

### 예제 입출력

| m    | n    | picture                                                      | answer |
| ---- | ---- | ------------------------------------------------------------ | ------ |
| 6    | 4    | [[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]] | [4, 5] |

##### 입출력 예 설명

예제로 주어진 그림은 총 4개의 영역으로 구성되어 있으며, 왼쪽 위의 영역과 오른쪽의 영역은 모두 `1`로 구성되어 있지만 상하좌우로 이어져있지 않으므로 다른 영역이다. 가장 넓은 영역은 왼쪽 위 `1`이 차지하는 영역으로 총 5칸이다.

## 풀이 방법

- 전체 탐색하며 방문하지 않았고 색상이 0이 아닌 칸을 만나면 BFS 후 넓이 리턴.

## 실행 코드

```java
package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1829_카카오프렌즈컬러링북 {
	
	public static void main(String[] args) {
		Solution_1829_카카오프렌즈컬러링북 s = new Solution_1829_카카오프렌즈컬러링북();
		System.out.println(Arrays.toString(s.solution(6, 4,
				new int[][] {{1, 1, 1, 0},
							{1, 2, 2, 0},
							{1, 0, 0, 1},
							{0, 0, 0, 1},
							{0, 0, 0, 3},
							{0, 0, 0, 3}})));
	}
	static boolean[][] visit;
	static int[] dR = {0, 1, 0, -1};
	static int[] dC = {1, 0, -1, 0};
	public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visit = new boolean[m][n];
        for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if(picture[r][c]>0 && !visit[r][c]) {
					numberOfArea++;
					int tmp = go(r,c,picture[r][c],picture, m, n);
					if(maxSizeOfOneArea < tmp) maxSizeOfOneArea = tmp;
				}
			}
		}
        
        
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }
	private int go(int r, int c, int color, int[][] picture, int M, int N) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {r, c});
		visit[r][c] = true;
		int newR, newC, cnt = 0;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for (int k = 0; k < 4; k++) {
				newR = cur[0] + dR[k];
				newC = cur[1] + dC[k];
				if(newR<0 || newR>=M || newC<0 || newC>=N) continue;
				if(!visit[newR][newC] && picture[newR][newC] == color) {
					que.offer(new int[] {newR, newC});
					visit[newR][newC] = true;
				}
			}
			cnt++;
		}
		return cnt;
	}
}

```

```
정확성  테스트
테스트 1 〉	통과 (24.52ms, 53.9MB)
효율성  테스트
채점 결과
정확성: 100.0
효율성: 0.0
합계: 100.0 / 100.0
```