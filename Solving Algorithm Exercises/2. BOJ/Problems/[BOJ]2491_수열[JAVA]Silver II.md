# [BOJ]2491_수열[JAVA]Silver II

## 문제

0에서부터 9까지의 숫자로 이루어진 N개의 숫자가 나열된 수열이 있다. 그 수열 안에서 연속해서 커지거나(같은 것 포함), 혹은 연속해서 작아지는(같은 것 포함) 수열 중 가장 길이가 긴 것을 찾아내어 그 길이를 출력하는 프로그램을 작성하라. 

예를 들어 수열 1 2 2 4 4 5 7 7 2 의 경우에는  1≤2≤2≤4≤4≤5≤7≤7 이 가장 긴 구간이 되므로 그 길이 8을 출력한다. 수열 4 1 3 3 2 2 9 2 3 의 경우에는 3≥3≥2≥2 가 가장 긴 구간이 되므로 그 길이 4를 출력한다. 또 1 5 3 6 4 7 1 3 2 9 5 의 경우에는 연속해서 커지거나 작아지는 수열의 길이가 3 이상인 경우가 없으므로 2를 출력하여야 한다.

**[입력]**

첫째 줄에는 수열의 길이 N이 주어지고, 둘째 줄에는 N개의 숫자가 빈칸을 사이에 두고 주어진다. N은 1 이상 100,000 이하의 정수이다.

**[출력]**

첫째 줄에 가장 긴 길이를 출력한다.

| 입력                     | 출력 |
| ------------------------ | ---- |
| 9<br />1 2 2 4 4 5 7 7 2 | 8    |


## 풀이 방법

- 최초 풀이

  - N개의 숫자를 앞에서부터 탐색하며 순차적으로 길이를 계산하여 max를 갱신

  

## 실행 코드

```java
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2491_수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		boolean up = true;
		int before = -1, current, length = 0, same = 0, max = -1;
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			current = Integer.parseInt(st.nextToken());
			if(up) { // 연속해서 커지는 중  //이번에도 커진다면
				if(before < current) {
					length++;
					same = 1;
				} else if(before == current) {
					length++;
					same++;
				} else { // 이번엔 작아진다면
					length = 1 + same;
					same = 1;
					up = false;
				}
			} else { // 연속해서 작아지는 중
				if(before > current) { //이번에도 작아진다면
					length++;
					same=1;
				} else if(before == current){
					length++;
					same++;
				} else {	// 이번엔 커진다면
					length = 1 + same;
					same = 1;
					up = true;
				}
			}
			before = current;
			if(max < length) max = length;
		}
		System.out.println(max);
	}

}

```

| 메모리   | 실행시간 |
| -------- | -------- |
| 21432 kb | 176 ms   |

