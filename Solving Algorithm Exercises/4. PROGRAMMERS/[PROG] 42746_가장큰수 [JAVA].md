# [PROG] 42746_가장큰수 [JAVA]

## 문제

###### 문제 설명

0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

##### 제한 사항

- numbers의 길이는 1 이상 100,000 이하입니다.
- numbers의 원소는 0 이상 1,000 이하입니다.
- 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

**[입출력]**

| numbers           | return  |
| ----------------- | ------- |
| [6, 10, 2]        | 6210    |
| [3, 30, 34, 5, 9] | 9534330 |



## 풀이 방법

- 비교하는 수의 자릿수가 같으면 사전 순 정렬,  다르면 짧은 길이까지 비교해서 다를 경우 리턴하고 그때까지도 같다면 짧은 수의 1의 자리를 기준으로 두고 긴 수의 나머지 자리를 비교.. 끝까지 같을 경우 짧은 수의 맨 첫자리와 긴 수의 맨 마지막 수 
- 하던 것은 다 때려치고 직접 둘의 순서를 다르게 하여 붙인 두개의 수를 직접 비교했다

## 실행 코드

```java
package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_42746_가장큰수 {

	public static void main(String[] args) {
		Solution_42746_가장큰수 s = new Solution_42746_가장큰수();

		System.out.println(s.solution(new int[] {0,0,0,0}));
		System.out.println(s.solution(new int[] { 51,5}));
		System.out.println(s.solution(new int[] { 6, 10, 2 }));
		System.out.println(s.solution(new int[] { 3, 30, 34, 5, 9 }));
	}

	public String solution(int[] numbers) {
		int len = numbers.length;
		String[] arr = new String[len];
		for (int i = 0; i < len; i++) arr[i] = Integer.toString(numbers[i]);

		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int left = Integer.parseInt(o1.concat(o2));
				int right = Integer.parseInt(o2.concat(o1));
				return Integer.compare(right, left);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) sb.append(arr[i]);
		int i, l;
		for (i = 0, l = sb.length(); i < l-1; i++) {
			if(sb.charAt(i) != '0') break; 
		}
		return sb.substring(i);
	}
}

```

```

```