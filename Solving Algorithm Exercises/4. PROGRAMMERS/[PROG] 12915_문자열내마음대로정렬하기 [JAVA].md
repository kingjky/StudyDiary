# [PROG] 12915_문자열내마음대로정렬하기 [JAVA]

## 문제

###### 문제 설명

문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.

##### 제한 조건

- strings는 길이 1 이상, 50이하인 배열입니다.
- strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
- strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
- 모든 strings의 원소의 길이는 n보다 큽니다.
- 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.

**[입출력]**

| strings           | n    | return            |
| ----------------- | ---- | ----------------- |
| [sun, bed, car]   | 1    | [car, bed, sun]   |
| [abce, abcd, cdx] | 2    | [abcd, abce, cdx] |

##### 입출력 예 설명

**입출력 예 1**
sun, bed, car의 1번째 인덱스 값은 각각 u, e, a 입니다. 이를 기준으로 strings를 정렬하면 [car, bed, sun] 입니다.

**입출력 예 2**
abce와 abcd, cdx의 2번째 인덱스 값은 c, c, x입니다. 따라서 정렬 후에는 cdx가 가장 뒤에 위치합니다. abce와 abcd는 사전순으로 정렬하면 abcd가 우선하므로, 답은 [abcd, abce, cdx] 입니다.

## 풀이 방법

- 

## 실행 코드

```java
package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_12915_문자열내마음대로정렬하기 {
	
	public static void main(String[] args) {
		Solution_12915_문자열내마음대로정렬하기 s = new Solution_12915_문자열내마음대로정렬하기();
		System.out.println(Arrays.toString(s.solution(new String[] {"sun", "bed", "car"}, 1)));
		System.out.println(Arrays.toString(s.solution(new String[] {"abce", "abcd", "cdx"}, 2)));
	}
	public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.charAt(n) != o2.charAt(n))
					return Character.compare(o1.charAt(n), o2.charAt(n));
				else {
					return o1.compareTo(o2);
				}
			}
		});
        return strings;
    }
}


```

```
정확성  테스트
테스트 1 〉	통과 (1.74ms, 52.4MB)
테스트 2 〉	통과 (1.97ms, 51.1MB)
테스트 3 〉	통과 (2.19ms, 43.6MB)
테스트 4 〉	통과 (1.96ms, 52MB)
테스트 5 〉	통과 (1.89ms, 52.2MB)
테스트 6 〉	통과 (1.73ms, 52.1MB)
테스트 7 〉	통과 (1.99ms, 52.3MB)
테스트 8 〉	통과 (1.87ms, 44.9MB)
테스트 9 〉	통과 (1.80ms, 52.3MB)
테스트 10 〉	통과 (1.66ms, 52.2MB)
테스트 11 〉	통과 (1.88ms, 52.9MB)
테스트 12 〉	통과 (2.32ms, 50MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
```