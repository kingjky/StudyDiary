# [PROG] 42860_조이스틱 [JAVA]

## 문제

###### 문제 설명

조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

조이스틱을 각 방향으로 움직이면 아래와 같습니다.

```
▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동
```

예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.

```
- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
```

만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

##### 제한 사항

- name은 알파벳 대문자로만 이루어져 있습니다.
- name의 길이는 1 이상 20 이하입니다.

**[입출력]**

| name   | return |
| ------ | ------ |
| JEROEN | 56     |
| JAN    | 23     |



## 풀이 방법

- 

## 실행 코드

```java
package programmers;

public class Solution_42860_조이스틱 {
	
	public static void main(String[] args) {
		Solution_42860_조이스틱 s = new Solution_42860_조이스틱();
		System.out.println(s.solution("JEROEN"));
		System.out.println(s.solution("JAN"));
		System.out.println(s.solution("A"));
	}
	public int solution(String name) {
        int answer = 0;
        int len = name.length();
        for (int i = 0; i < len; i++) {
        	int dif = name.charAt(i) - 'A';
        	dif = dif<26-dif? dif: 26-dif;
			answer += dif;
		}
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
        	if(name.charAt(i)!='A') {
        		if(min > len - i) min = len - i;
        		break;
        	}
        }
        for (int i = len - 1; i > 0; i--) {
        	if(name.charAt(i)!='A') {
        		if(min > i) min = i;
        		break;
        	}
        }
        int mid = len/2;
        int left, right;
        left = right = 0;
        if(len%2==0) {
        	for (int i = 1; i < mid; i++) {
				if(name.charAt(mid+i)!='A') {
					if(left==0) left = len - (mid+i);
				}
				if(name.charAt(mid-i)!='A') {
					if(right==0) right = (mid-i);
				}
			}
        } else {
        	for (int i = 0; i < mid; i++) {
        		if(name.charAt(mid+i+1)!='A') {
        			if(left==0) left = len - (mid+i+1);
        		}
        		if(name.charAt(mid-i)!='A') {
        			if(right==0) right = (mid-i);
        		}
        	}
        }
    	int tmp;
    	if(left > right) {
    		if(name.charAt(mid)!='A') left = len - mid;
    		tmp = right*2 + left;
    	} else {
    		if(name.charAt(mid)!='A') right = mid;
    		tmp = left*2 + right;
    	}
    	if(min > tmp) min = tmp;
        
        answer+=min;
        
        return answer;
    }
}

```

```
정확성  테스트
테스트 1 〉	통과 (0.80ms, 52.5MB)
테스트 2 〉	통과 (0.78ms, 52.1MB)
테스트 3 〉	통과 (0.89ms, 44.3MB)
테스트 4 〉	통과 (0.84ms, 52.6MB)
테스트 5 〉	통과 (0.76ms, 52MB)
테스트 6 〉	통과 (0.77ms, 50.4MB)
테스트 7 〉	통과 (0.81ms, 53MB)
테스트 8 〉	통과 (0.86ms, 50.4MB)
테스트 9 〉	통과 (0.81ms, 54.1MB)
테스트 10 〉	통과 (0.80ms, 52.3MB)
테스트 11 〉	통과 (0.88ms, 42.6MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
```