# [BOJ]1874 스택 수열[JAVA]Silver III

## 문제

스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.


**[입력]**

첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.

**[출력]**

입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.

| 입력                                              | 출력                                                         |
| ------------------------------------------------- | ------------------------------------------------------------ |
| 8<br/>4<br/>3<br/>6<br/>8<br/>7<br/>5<br/>2<br/>1 | +<br/>+<br/>+<br/>+<br/>-<br/>-<br/>+<br/>+<br/>-<br/>+<br/>+<br/>-<br/>-<br/>-<br/>-<br/>- |
| 5<br/>1<br/>2<br/>5<br/>3<br/>4                   | NO                                                           |


## 풀이 방법

- 최초 풀이
  - 스택에 넣거나 빼는 두 가지의 경우를 1~N 까지의 수에 대해 각각 적용해 완전 탐색해봐야 할 것 같다
    => N의 최대가 100,000 인데 너무 많아질 듯.
  - 출력될 수 k 하나가 제시될 때 마다 이전의 수보다 크다면 아직 넣지 않은 수부터 k 까지 push 하고,
    이전의 수보다 작다면 pop 을 통해 확인하며 틀린 결과가 나오면 불가능으로 판단하자.

## 실행 코드

```java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1874_스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int cur = 0;
		Stack<Integer> stack = new Stack<Integer>();
		boolean possible = true;

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			int k = Integer.parseInt(br.readLine());
			if (k > cur) {
				while (cur < k) {
					cur++;
					stack.push(cur);
					sb.append('+').append('\n');
				}
				stack.pop();
				sb.append('-').append('\n');
			} else {
				if (!stack.empty() && stack.pop() == k) {
					sb.append('-').append('\n');
				} else {
					possible = false;
					break;
				}
			}
		}
		if (possible) {
			System.out.print(sb.toString());
		} else {
			System.out.println("NO");
		}
	}
}
```

| 메모리   | 실행시간 |
| -------- | -------- |
| 29184 kb | 288 ms   |

