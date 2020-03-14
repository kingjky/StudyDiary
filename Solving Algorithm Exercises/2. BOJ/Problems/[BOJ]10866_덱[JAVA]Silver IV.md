# [BOJ]10866_덱[JAVA]Silver IV

## 문제

정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여덟 가지이다.

- push_front X: 정수 X를 덱의 앞에 넣는다.
- push_back X: 정수 X를 덱의 뒤에 넣는다.
- pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- size: 덱에 들어있는 정수의 개수를 출력한다.
- empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
- front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.


**[입력]**

첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

**[출력]**

출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

| 입력                                                         | 출력                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 15<br/>push_back 1<br/>push_front 2<br/>front<br/>back<br/>size<br/>empty<br/>pop_front<br/>pop_back<br/>pop_front<br/>size<br/>empty<br/>pop_back<br/>push_front 3<br/>empty<br/>front | 2<br/>1<br/>2<br/>0<br/>2<br/>1<br/>-1<br/>0<br/>1<br/>-1<br/>0<br/>3 |


## 풀이 방법

- 최초 풀이
  DeQue 를 구현하는 간단한 문제. 기초 복습용. DeQue 는 stack과 queue 의 결합된 구조.
  N의 갯수에 따라, push front/back 각각 최악의 경우를 고려해 array int[20000] 로 할당 후 10000 에서 시작. start, end 변수로 index 관리.

## 실행 코드

```java
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10866_덱 {
	static int deque[], start, end;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		deque = new int[20000];
		start = end = 10000;

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int X;
			switch (str) {
			case "push_front":
				X = Integer.parseInt(st.nextToken());
				deque[--start] = X;
				break;
			case "push_back":
				X = Integer.parseInt(st.nextToken());
				deque[end++] = X;
				break;
			case "pop_front":
				if (start < end) {
					sb.append(deque[start++]).append('\n');
				} else {
					sb.append(-1).append('\n');
				}
				break;
			case "pop_back":
				if (start < end) {
					sb.append(deque[--end]).append('\n');
				} else {
					sb.append(-1).append('\n');
				}
				break;
			case "size":
				sb.append(end - start).append('\n');
				break;
			case "empty":
				if (start < end) {
					sb.append(0).append('\n');
				} else {
					sb.append(1).append('\n');
				}
				break;
			case "front":
				if (start < end) {
					sb.append(deque[start]).append('\n');
				} else {
					sb.append(-1).append('\n');
				}
				break;
			case "back":
				if (start < end) {
					sb.append(deque[end-1]).append('\n');
				} else {
					sb.append(-1).append('\n');
				}
				break;
			}
		}
		System.out.print(sb.toString());
	}

}

```

| 메모리   | 실행시간 |
| -------- | -------- |
| 17768 kb | 136 ms   |

