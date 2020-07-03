# [PROG] 42883_큰수만들기 [JAVA]

## 문제

###### 문제 설명

어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

##### 제한 조건

- number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
- k는 1 이상 `number의 자릿수` 미만인 자연수입니다.

**[입출력]**

| number     | k    | return |
| ---------- | ---- | ------ |
| 1924       | 2    | 94     |
| 1231234    | 3    | 3234   |
| 4177252841 | 4    | 775841 |



## 풀이 방법

- StringBuilder에 deleteCharAt(int index)라는 Method가 정의되어 있다

## 실행 코드

```java
package programmers;

public class Solution_42883_큰수만들기 {
	
	public static void main(String[] args) {
		Solution_42883_큰수만들기 s = new Solution_42883_큰수만들기();
		
//		System.out.println(s.solution("1", 0));
		System.out.println(s.solution("123455556789", 5));
		System.out.println(s.solution("1924", 2));
		System.out.println(s.solution("1231234", 3));
		System.out.println(s.solution("4177252841", 4));
	}
	public String solution(String number, int k) {
        StringBuilder a = new StringBuilder(number);
        int i = 0;
        int j = 0;
        int idx;
        int l;

        for (i = 0; i < k; i++) {
            l=a.length();
            idx = l - 1;
            for (j = 0; j < l - 1; j++) {
                if (a.charAt(j) < a.charAt(j + 1)) {
                    idx = j;
                    break;
                }
            }
            a.deleteCharAt(idx);
        }
        return a.toString();
    }
}

```

```
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.83ms, 52.4MB)
테스트 2 〉	통과 (0.88ms, 52.2MB)
테스트 3 〉	통과 (1.16ms, 50.8MB)
테스트 4 〉	통과 (1.48ms, 52.6MB)
테스트 5 〉	통과 (4.43ms, 51.8MB)
테스트 6 〉	통과 (23.78ms, 50.9MB)
테스트 7 〉	통과 (34.91ms, 51.4MB)
테스트 8 〉	통과 (149.75ms, 53.1MB)
테스트 9 〉	통과 (6.94ms, 54.9MB)
테스트 10 〉	통과 (4099.12ms, 54.9MB)
테스트 11 〉	통과 (0.90ms, 52.3MB)
테스트 12 〉	통과 (0.86ms, 50.4MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
```