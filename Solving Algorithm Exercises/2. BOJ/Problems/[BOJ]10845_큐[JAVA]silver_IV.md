# [BOJ]10845_큐[JAVA]silver_IV

## 문제

정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여섯 가지이다.

- push X: 정수 X를 큐에 넣는 연산이다.
- pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- size: 큐에 들어있는 정수의 개수를 출력한다.
- empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
- front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

**[입력]**

첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.


**[출력]**

출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

| 입력                                                         | 출력                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 15<br/>push 1<br/>push 2<br/>front<br/>back<br/>size<br/>empty<br/>pop<br/>pop<br/>pop<br/>size<br/>empty<br/>pop<br/>push 3<br/>empty<br/>front | 1<br/>2<br/>2<br/>0<br/>1<br/>2<br/>-1<br/>0<br/>1<br/>-1<br/>0<br/>3 |


## 풀이 방법

- 최초 풀이
  Queue 를 구현하는 간단한 코드. 알고리즘 기초 복습용.
  명령어 갯수 N의 최대값이 10,000 이므로 최대 10000개의 데이터가 push 될 수 있다는 가정 하에 array size를 10,000 개로 할당했고, start, end 변수를 이용해 Queue의 시작과 끝에 관한 pointer를 관리했다.

## 실행 코드

```java
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10845_큐 {
	static int que[], start, end;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		que = new int[10000];
		start = end = 0;
		
		for (int n = 0; n < N; n++) {
			String command;
			int X;
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			switch (command) {
			case "push":
				X = Integer.parseInt(st.nextToken());
				que[end++] = X;
				break;
			case "pop":
				if(start < end) {
					sb.append(que[start++]).append('\n');
				} else {
					sb.append(-1).append('\n');
				}
				break;
			case "size":
				sb.append(end - start).append('\n');
				break;
			case "empty":
				if(start < end) {
					sb.append(0).append('\n');
				} else {
					sb.append(1).append('\n');
				}
				break;
			case "front":
				if(start < end) {
					sb.append(que[start]).append('\n');
				} else {
					sb.append(-1).append('\n');
				}
				break;
			case "back":
				if(start < end) {
					sb.append(que[end - 1]).append('\n');
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
| 17404 kb | 128 ms   |

