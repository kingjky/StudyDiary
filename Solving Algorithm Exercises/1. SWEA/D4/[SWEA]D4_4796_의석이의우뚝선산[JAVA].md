# [SWEA] D4_4796_의석이의우뚝선산 [JAVA]

## 문제

의석이는 동서 방향으로 늘어서 있는 산의 N개의 지점에 대한 높이를 측정했다.

서쪽에서 i번째 지점을 i번 지점이라고 하고, 이 지점의 높이는 h<sub>i</sub>이다.

특이하게도 두 지점이 같은 h<sub>i</sub>을 가지는 경우는 없었다.

의석이의 친구 상원이가 의석이에게 “우뚝 선 산”이 몇 개인지 찾는 게임을 제안했다.

어떤 두 지점 i,j(1≤i＜j≤N) 사이에 있는 모든 지점을 볼 때, 즉 구간 [i,j]에 대해 이들의 높이의 형태가 “우뚝 선 산”이라는 것을 다음과 같이 정의하기로 했다.


  다음을 만족하는 k(i＜k＜j)가 존재해야 한다.

  i≤l＜k인 모든 l에 대해 h<sub>l</sub>＜h<sub>(l+1)</sub>이 성립.

  k≤l＜j인 모든 l에 대해 h<sub>l</sub>＞h<sub>(l+1)</sub>이 성립.


이와 같은 정의에서 두 지점 i와 i+1사이는 우뚝 선 산이 될 수 없음에 주의해야 한다.

자존심이 강한 의석이는 “이 정도는 내가 좀 하지.”라며 자신만만하게 대답했지만, 속으로는 식은땀을 흘리고 있다.

의석이는 자존심을 지키기 위해 상원이 몰래 당신에게 도움을 요청했다.

각 지점의 높이가 주어질 때, 우뚝 선 산이 될 수 있는 구간의 개수를 구하는 프로그램을 만들어 정답을 출력하라.


**[입력]**

첫 번째 줄에 테스트 케이스의 수 T(1≤T≤10)가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 자연수 N(3≤N≤50,000)이 주어진다.

다음 줄에는 N개의 자연수 h<sub>1</sub>,…,h<sub>N</sub> (1≤h<sub>i</sub>≤10<sup>9</sup>)이 순서대로 공백 하나로 구분되어 주어진다.

모든 1≤i＜j≤N 에 대해 h<sub>i</sub>≠h<sub>j</sub> 이다.

**[출력]**

각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 우뚝 선 산이 될 수 있는 구간의 개수를 출력하라.

| 입력                                                         | 출력                   |
| ------------------------------------------------------------ | ---------------------- |
| 3<br/>3<br/>1 3 2<br/>3<br/>3 2 1<br/>9<br/>1 4 6 5 3 7 9 2 8 | #1 1<br/>#2 0<br/>#3 6 |


## 풀이 방법

- 최초 풀이
  - 모든 산을 시작점의 기준으로 삼아 구간을 하나씩 증가시키며 우뚝 선 산이 아닐때까지 count
  - i~k~j 구간이 '우뚝 선 산' 일 경우 i+1~k~j 또한 '우뚝 선 산' 이므로 (i+1 < k) memorization 가능
    - 어떤 출발점 i로부터 얻을 수 있는 우뚝 선 산의 갯수는 i~k 사이의 모든 출발점에 대해 동일하다
  - 완탐에 가까운 가지치기 풀이법으로 실행 시간이 매우 길다.
- 더 나은 풀이

## 실행 코드

- 최초 풀이 실행 코드

```java
import java.io.IOException;
import java.util.Scanner;

public class Solution_D4_4796_의석이의우뚝선산 {

	static int h[];
	static int memo[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			h = new int[N];
			memo = new int[N];
			for (int n = 0; n < N; n++) {
				h[n] = sc.nextInt();
			}
			
			int sum;
			boolean up;
			int length;
			for (int i = 0; i < N-1; i++) {
				if(memo[i] != 0) continue; 
				sum = 0;
				up = true;
				length = 0;
				int k = i;
				for (int j = i+1; j < N; j++) {
					if(up && length == 0 && h[j-1] > h[j]) {
						break;
					}
					length++;
					if(up && length > 0 && h[j-1] > h[j]) {
						up = false;
						k = j-1;
						sum++;
					} else if(!up && h[j-1] > h[j]) {
						sum++;
					} else if(!up && h[j-1] < h[j]) {
						break;
					}
				}
				for (int j = i; j < k; j++) {
					memo[j] = sum;
				}
			}
			int result = 0;
			for (int i : memo) {
				result += i;
			}
			System.out.printf("#%d %d\n", t, result);			
		}
	}

}

```

| 메모리     | 실행시간 |
| ---------- | -------- |
| 117,680 kb | 1,854 ms |

