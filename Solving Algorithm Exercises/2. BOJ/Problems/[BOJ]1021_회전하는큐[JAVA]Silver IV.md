# [BOJ]1021_회전하는큐[JAVA]Silver IV

## 문제

지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다. 지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.

지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.

1. 첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
2. 왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
3. 오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.

큐에 처음에 포함되어 있던 수 N이 주어진다. 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다. (이 위치는 가장 처음 큐에서의 위치이다.) 이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.

**[입력]**

첫째 줄에 큐의 크기 N과 뽑아내려고 하는 수의 개수 M이 주어진다. N은 50보다 작거나 같은 자연수이고, M은 N보다 작거나 같은 자연수이다. 둘째 줄에는 지민이가 뽑아내려고 하는 수의 위치가 순서대로 주어진다. 위치는 1보다 크거나 같고, N보다 작거나 같은 자연수이다.

**[출력]**

첫째 줄에 문제의 정답을 출력한다.

| 입력                           | 출력 |
| ------------------------------ | ---- |
| 10 3<br/>1 2 3                 | 0    |
| 10 3<br/>2 9 5                 | 8    |
| 32 6<br/>27 16 30 11 6 23      | 59   |
| 10 10<br/>1 6 3 2 7 9 8 4 10 5 | 14   |


## 풀이 방법

- 최초 풀이
  - N+1 size의 boolean array 생성 후 출력된 것은 true 처리한다.
  - 이동 횟수는 해당 index가 false 인 것만 count 한다.
  - left 방향으로 탐색했을 때의 count 값과 right 방향의 count 값 중 작은 것을 sum에 더함

## 실행 코드

```java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1021_회전하는큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean chk[] = new boolean[N+1];
		int k, cur, left, right, tmp, sum;
		cur = 1;
		sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			left = right = 0;
			k = Integer.parseInt(st.nextToken());
			// calc of left
			tmp = cur;
			while(tmp != k) {
				if(!chk[tmp]) left++;
				tmp--;
				if(tmp == 0) tmp = N;
			}
			// calc of right
			tmp = cur;
			while(tmp != k) {
				if(!chk[tmp]) right++;
				tmp++;
				if(tmp > N) tmp = 1;
			}
			if(left < right) sum += left;
			else sum += right;
			
			chk[k] = true;
			cur = k + 1;
			if(cur > N) cur = 1;
			while(cur != k && chk[cur]) {
				cur++;
				if(cur > N) cur = 1;
			}
		}
		System.out.println(sum);
	}

}

```

| 메모리   | 실행시간 |
| -------- | -------- |
| 12964 kb | 72 ms    |

