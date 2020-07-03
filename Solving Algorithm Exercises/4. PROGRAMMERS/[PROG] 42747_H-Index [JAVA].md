# [PROG] 42747_H-Index [JAVA]

## 문제

###### 문제 설명

H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과[1](https://programmers.co.kr/learn/courses/30/lessons/42747#fn1)에 따르면, H-Index는 다음과 같이 구합니다.

어떤 과학자가 발표한 논문 `n`편 중, `h`번 이상 인용된 논문이 `h`편 이상이고 나머지 논문이 h번 이하 인용되었다면 `h`의 최댓값이 이 과학자의 H-Index입니다.

어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

##### 제한사항

- 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
- 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.

**[입출력]**

| citations       | return |
| --------------- | ------ |
| [3, 0, 6, 1, 5] | 3      |

##### 입출력 예 설명

이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다. 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.

## 풀이 방법

- 

## 실행 코드

```java
package programmers;

public class Solution_42747_HIndex {
	
	public static void main(String[] args) {
		Solution_42747_HIndex s = new Solution_42747_HIndex();
		System.out.println(s.solution(new int[] {3,0,6,1,5}));
	}
	public int solution(int[] citations) {
        int h;
        for (h = citations.length; h >= 0; h--) {
        	int cnt = 0;
			for (int i = 0, len = citations.length; i < len; i++) {
				if(citations[i] >= h) cnt++;
			}
			if(cnt>=h) break;
		}
        return h;
    }
}

```

```
정확성  테스트
테스트 1 〉	통과 (1.22ms, 52.3MB)
테스트 2 〉	통과 (2.23ms, 54.7MB)
테스트 3 〉	통과 (1.41ms, 50.8MB)
테스트 4 〉	통과 (1.21ms, 52.9MB)
테스트 5 〉	통과 (1.99ms, 52.6MB)
테스트 6 〉	통과 (2.29ms, 52.6MB)
테스트 7 〉	통과 (0.85ms, 52.3MB)
테스트 8 〉	통과 (0.82ms, 52.5MB)
테스트 9 〉	통과 (0.78ms, 52.2MB)
테스트 10 〉	통과 (0.93ms, 51.7MB)
테스트 11 〉	통과 (2.84ms, 50.5MB)
테스트 12 〉	통과 (0.77ms, 52.5MB)
테스트 13 〉	통과 (1.86ms, 53.2MB)
테스트 14 〉	통과 (1.65ms, 52.3MB)
테스트 15 〉	통과 (2.25ms, 51.8MB)
테스트 16 〉	통과 (0.81ms, 52MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
```