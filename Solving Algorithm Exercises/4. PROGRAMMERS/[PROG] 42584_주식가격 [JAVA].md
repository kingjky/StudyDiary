# [PROG] 42584_주식가격 [JAVA]

## 문제

###### 문제 설명

초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

##### 제한사항

- prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
- prices의 길이는 2 이상 100,000 이하입니다.

**[입출력]**

| prices          | return          |
| --------------- | --------------- |
| [1, 2, 3, 2, 3] | [4, 3, 1, 1, 0] |

##### 입출력 예 설명

- 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
- 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
- 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
- 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
- 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.

## 풀이 방법

- 

## 실행 코드

```java
import java.util.Stack;
class Solution {
    public int[] solution(int[] prices) {
		int len = prices.length;
        int[] answer = new int[len];
        Stack<int[]> stack = new Stack<int[]>();
        for (int i = 0; i < len; i++) {
        	int cur = prices[i];
        	while(!stack.isEmpty() && stack.peek()[0] > cur) {
        		int[] arr = stack.pop();
        		int idx = arr[1];
        		answer[idx] = i-idx;
        	}
        	stack.push(new int[] {cur, i});
		}
        while(!stack.isEmpty()) {
        	int[] arr = stack.pop();
    		int idx = arr[1];
    		answer[idx] = len-idx-1;
        }
        return answer;
    }
}
```

```
테스트 1 〉통과 (1.56ms, 52.4MB)
테스트 2 〉통과 (2.04ms, 52.3MB)
테스트 3 〉통과 (3.46ms, 50.8MB)
테스트 4 〉통과 (3.53ms, 52.9MB)
테스트 5 〉통과 (3.81ms, 52.9MB)
테스트 6 〉통과 (1.89ms, 52.4MB)
테스트 7 〉통과 (2.96ms, 50MB)
테스트 8 〉통과 (3.48ms, 53.1MB)
테스트 9 〉통과 (1.63ms, 52.1MB)
테스트 10 〉통과 (3.99ms, 52.6MB)
테스트 1 〉통과 (34.59ms, 66.8MB)
테스트 2 〉통과 (32.25ms, 60.1MB)
테스트 3 〉통과 (35.53ms, 69.7MB)
테스트 4 〉통과 (31.79ms, 62.5MB)
테스트 5 〉통과 (27.97ms, 60.2MB)
```