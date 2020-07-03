# [PROG] 42839_소수찾기 [JAVA]

## 문제

###### 문제 설명

한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

##### 제한사항

- numbers는 길이 1 이상 7 이하인 문자열입니다.
- numbers는 0~9까지 숫자만으로 이루어져 있습니다.
- 013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

**[입출력]**

| numbers | return |
| ------- | ------ |
| 17      | 3      |
| 011     | 2      |

##### 입출력 예 설명

예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

- 11과 011은 같은 숫자로 취급합니다.

## 풀이 방법

- 무식하게 DFS 완전탐색으로 다 찾기

## 실행 코드

```java
package programmers;

import java.util.Arrays;
import java.util.HashSet;

public class Solution_42839_소수찾기 {
	
	public static void main(String[] args) {
		Solution_42839_소수찾기 s = new Solution_42839_소수찾기();
		System.out.println(s.solution("17"));
		System.out.println(s.solution("011"));
		System.out.println(s.solution("1234567"));
	}
	static boolean[] visit;
	static int[] arr;
	static HashSet<Integer> set;
	public int solution(String numbers) {
		int len = numbers.length();
		arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = numbers.charAt(i) - '0';
		}
		Arrays.sort(arr);
		visit = new boolean[len];
		set = new HashSet<Integer>();
		dfs(0);		
		
        int answer = set.size();
        return answer;
    }
	private void dfs(int n) {
		int l = arr.length;
		n *= 10;
		for (int i = 0; i < l; i++) {
			if(visit[i]) continue;
			n+=arr[i];
			visit[i] = true;
			if(chk(n)) set.add(n);
			dfs(n);
			n-=arr[i];
			visit[i] = false;
		}
	}
	private boolean chk(int n) {
		if(n<2) return false;
		for (int i = 2; i < n; i++) {
			if(n%i==0) return false;
		}
		return true;		
	}
}

```

```

```