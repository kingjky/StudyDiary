# [PROG] 42841_숫자야구 [JAVA]

## 문제

###### 문제 설명

숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. [게임해보기](https://scratch.mit.edu/projects/131352991/)

각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.

```
* 숫자는 맞지만, 위치가 틀렸을 때는 볼
* 숫자와 위치가 모두 맞을 때는 스트라이크
* 숫자와 위치가 모두 틀렸을 때는 아웃
```

예를 들어, 아래의 경우가 있으면

```
A : 123
B : 1스트라이크 1볼.
A : 356
B : 1스트라이크 0볼.
A : 327
B : 2스트라이크 0볼.
A : 489
B : 0스트라이크 1볼.
```

이때 가능한 답은 324와 328 두 가지입니다.

질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.

##### 제한사항

- 질문의 수는 1 이상 100 이하의 자연수입니다.
- baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.

**[입출력]**

| baseball                                             | return |
| ---------------------------------------------------- | ------ |
| [[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]] | 2      |

##### 입출력 예 설명

- 문제에 나온 예와 같습니다.

## 풀이 방법

- 

## 실행 코드

```java
public int solution(int[][] baseball) {
        int N = baseball.length;
		int answer = 0;
        for (int i = 1; i <= 9; i++) {
        	for (int j = 1; j <= 9; j++) {
        		if(i==j) continue;
        		for (int k = 1; k <= 9; k++) {
        			if(j==k || i==k) continue;
        			int strike, ball, n;
        			for (n = 0; n < N; n++) {
						int cur = baseball[n][0];
						int x = cur/100;
						int y = cur%100/10;
						int z = cur%10;
						strike = ball = 0;
						if(x==i) strike++;
						else if(x==j || x==k) ball++;
						if(y==j) strike++;
						else if(y==i || y==k) ball++;
						if(z==k) strike++;
						else if(z==i || z==j) ball++;
						if(strike != baseball[n][1] || ball != baseball[n][2])
							break;
					}
        			if(n==N) answer++;
        			else continue;
        		}
        	}
		}
        return answer;
    }
```

```
정확성  테스트
테스트 1 〉	통과 (0.93ms, 50.9MB)
테스트 2 〉	통과 (0.93ms, 52.2MB)
테스트 3 〉	통과 (0.93ms, 52.6MB)
테스트 4 〉	통과 (0.89ms, 52.6MB)
테스트 5 〉	통과 (0.89ms, 52.3MB)
테스트 6 〉	통과 (0.82ms, 52.4MB)
테스트 7 〉	통과 (0.91ms, 52.4MB)
테스트 8 〉	통과 (0.96ms, 52.2MB)
테스트 9 〉	통과 (0.85ms, 50.2MB)
테스트 10 〉	통과 (0.91ms, 52.9MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
```