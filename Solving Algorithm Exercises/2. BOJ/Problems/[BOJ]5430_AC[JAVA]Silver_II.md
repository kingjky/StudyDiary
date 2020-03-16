# [BOJ]5430_AC[JAVA]Silver_II

## 문제

선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.

함수 R은 배열에 있는 숫자의 순서를 뒤집는 함수이고, D는 첫 번째 숫자를 버리는 함수이다. 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.

함수는 조합해서 한 번에 사용할 수 있다. 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 숫자를 버리는 함수이다.

배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.


**[입력]**

첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.

각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.

다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)

다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 수가 주어진다. (1 ≤ xi ≤ 100)

전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.


**[출력]**

각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다. 만약, 에러가 발생한 경우에는 error를 출력한다.

| 입력                                                         | 출력                                      |
| ------------------------------------------------------------ | ----------------------------------------- |
| 4<br/>RDD<br/>4<br/>[1,2,3,4]<br/>DD<br/>1<br/>[42]<br/>RRD<br/>6<br/>[1,1,2,3,5,8]<br/>D<br/>0<br/>[] | [2,1]<br/>error<br/>[1,2,3,5,8]<br/>error |


## 풀이 방법

- 최초 풀이
  - Deque를 사용한다. R 함수가 호출 될 때마다 bool 변수로 방향을 달리해주어 D를 만난 시점의 방향에 따라 pop, poll 을 통해 앞 혹은 뒤의 값을 제거한다. 동시에 size를 체크해 0 이하인 시점에 함수 D가 호출될 경우 error를 출력하고 break 한다.
    => 생각과는 다르게 pop과 poll이 제대로 동작하지 않는다.
  - 배열의 idx 변수 start, end 를 두고 R 함수에 의한 방향 전환에 따라 start를 전진시키거나 end를 후진시킴.

## 실행 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// Silver II
public class Main_5430_AC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			
			String p = br.readLine(); //length: 1~100000
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			int arr[], start, end;
			arr = new int[N];
			start = 0;
			end = N;
			boolean dirLR = true, possible = true;
			
			input = input.substring(1, input.length()-1);
			st = new StringTokenizer(input, ",");
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			outer: for (int i = 0, len = p.length(); i < len; i++) {
				char c = p.charAt(i);
				switch (c) {
				case 'R':
					dirLR = !dirLR;
					break;
				case 'D':
					if(end == start){
						possible = false;
						break outer;
					}
					
					if(dirLR) { // 좌->우 방향이면 start 지점을 이동
						start++;
					} else {	// 우->좌 방향이면 end 지점을 이동
						end--;
					}
					break;
				}
			}
			if(possible) {
				sb.append('[');
				if(dirLR) {
					for (int i = start; i < end; i++) {
						sb.append(arr[i]);
						if(i != end-1) sb.append(',');
					}
				} else {
					for (int i = end - 1; i >= start; i--) {
						sb.append(arr[i]);
						if(i != start) sb.append(',');
					}
				}
				sb.append(']');
			} else {
				sb.append("error");
			}
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}
}

```

| 메모리   | 실행시간 |
| -------- | -------- |
| 75264 kb | 536 ms   |

