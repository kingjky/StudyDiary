# [BOJ]10828_스택[JAVA] [Silver IV]

## 문제

정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

- push X: 정수 X를 스택에 넣는 연산이다.
- pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- size: 스택에 들어있는 정수의 개수를 출력한다.
- empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
- top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.


**[입력]**

첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.


**[출력]**

출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

| 입력                                                         | 출력                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 14<br />push 1<br />push 2<br />top<br />size<br />empty<br />pop<br />pop<br />pop<br />size<br />empty<br />pop<br />push 3<br />empty<br />top | 2 <br />2 <br />0 <br />2 <br />1 <br />-1 <br />0 <br />1 <br />-1 <br />0 <br />3 |

| 입력                                                         | 출력                                    |
| ------------------------------------------------------------ | --------------------------------------- |
| 7<br/>pop<br/>top<br/>push 123<br/>top<br/>pop<br/>top<br/>pop | -1<br/>-1<br/>123<br/>123<br/>-1<br/>-1 |

## 풀이 방법

- 최초 풀이

  Stack 을 구현하는 간단한 코드. 알고리즘 기초 복습용으로 풀어본다
  명령어 갯수 N의 최대값이 10,000 이므로 최대 10000개의 데이터가 push 될 수 있다는 가정 하에 array size를 10,000 개로 할당했고 size 변수를 이용해 stack의 pointer를 관리했다.

## 실행 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10828_스택 {
	static int stack[], size;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		stack = new int[10000];
		size = 0;
		for (int n = 0; n < N; n++) {
			String command;
			int X;
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			switch (command) {
			case "push":
				X = Integer.parseInt(st.nextToken());
				stack[size] = X;
				size++;
				break;
			case "pop":
				if(size < 1) {
					sb.append(-1).append('\n');
				} else {
					sb.append(stack[--size]).append('\n');
				}
				break;
			case "size":
				sb.append(size).append('\n');
				break;
			case "empty":
				if(size < 1) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			case "top":
				if(size < 1) {
					sb.append(-1).append('\n');
				} else {
					sb.append(stack[size-1]).append('\n');
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
| 16232 kb | 120 ms   |

