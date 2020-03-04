# [SWEA]D4_8275_햄스터[JAVA]

## 문제

정우는 햄스터를 많이 기르고 있는데, 햄스터들에게 별 관심을 가지고 있지는 않다.

정우는 햄스터 우리를 N개 가지고 있으며, 각 우리에 1번에서 N번까지의 번호를 붙여 일렬로 놔두고 있다.

정우는 햄스터들에게 별 관심이 없지만, 각 우리에 0마리 이상 X마리 이하의 햄스터가 있다는 것은 알고 있다.

어느 날 경근이가 정우 집에 놀러 왔다.

경근이는 바쁜 정우와 노는 대신 햄스터의 수를 세면서 놀았다.

경근이는 M개의 기록을 남겼는데, 각 기록은 “l번 우리에서 r번 우리까지의 햄스터 수를 세었더니 s마리였다.” 하는 내용들이다.

경근이가 남긴 기록을 모두 만족하는 햄스터 수 배치를 구하는 프로그램을 작성하라.


**[입력]**

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 세 정수 N, X, M(1 ≤ N ≤ 6, 1 ≤ X, M ≤ 10)이 공백 하나로 구분되어 주어진다.

다음 M개의 줄의 i번째 줄에는 세 정수 li, ri, si(1 ≤ li ≤ ri ≤ N, 0 ≤ si ≤ 60)가 공백 하나로 구분되어 주어진다.

이는 li번 우리에서 ri번 우리까지의 햄스터 수를 세었더니 si마리였다는 것을 나타낸다.


**[출력]**

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

각 테스트 케이스마다 모든 기록을 만족하는 햄스터 수 배치가 있다면,

1번 우리부터 N번 우리의 순서대로 우리에 있는 햄스터 수를 공백 하나로 구분하여 출력한다.

만약 가능한 방법이 여러 가지일 경우, 햄스터 수가 가장 많은 것을 출력한다.

그래도 가능한 방법이 여러 가지일 경우, 사전순으로 가장 빠른 것을 출력한다.

만약 모든 기록을 만족하는 햄스터 배치가 없다면, -1을 출력하도록 한다.


| 입력                                                         |
| ------------------------------------------------------------ |
| 3 // 테스트 케이스 개수<br />3 5 1 // 첫 번째 테스트 케이스<br />1 2 5 <br />3 5 2 // 두 번째 테스트 케이스<br />1 2 6 <br />2 3 7 <br />4 5 2 // 세 번째 테스트 케이스<br />1 3 15 <br />3 4 4 |

| 출력                                                         |
| ------------------------------------------------------------ |
| #1 0 5 5 // 첫 번째 테스트 케이스 결과<br />#2 4 2 5 // 두 번째 테스트 케이스 결과<br />#3 -1 // 세 번째 테스트 케이스 결과 |

## 풀이 방법

- 모든 생각의 시작은 완탐으로부터 출발한다
  - Big-O 를 계산
    - N 최대 6이며 X, M 최대 10 이므로 대략 10<sup>6</sup> ~ 10<sup>7</sup> 


 * 입력
     * N : 우리 갯수 1~6
     * X : 우리 당 최대 마리 수
     * M : 정보의 갯수
 * 11^6 가능
 * 출력 형식 >
     * #1 0 5 5
 * 주의 사항 >
     * 1) M번을 만족하는 배치가 여러 경우일 경우 합계가 최대인 것 출력
     * 2) 합계가 최대인 것이 많을 경우 오름차순 빠른 것 출력
     * 3) 만족하는 배치가 없다면 -1 출력



## 실행 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * N : 우리 갯수 1~6
 * X : 우리 당 최대 마리 수
 * M : 정보의 갯수
 * 
 * 11^6 가능
 * 
 * 출력 형식 >
 * #1 0 5 5
 * 
 * 주의 사항 >
 * 1) M번을 만족하는 배치가 여러 경우일 경우 합계가 최대인 것 출력
 * 2) 합계가 최대인 것이 많을 경우 오름차순 빠른 것 출력
 * 3) 만족하는 배치가 없다면 -1 출력
 */
public class Solution_D4_8275_햄스터 {
	static int[] cage;	// 가능한 모든 햄스터 배치를 해볼 중복순열
	static int[] ans;
	static int N, X, M;
	static int[][] input; // l부터 r까지 s마리
	static int max;	// 답이 여러가지라면 합이 최대가 되는 경우 선택
	static StringBuilder sb;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			max = -1;
			N = Integer.parseInt(st.nextToken()); // 우리 갯수 1~6
			X = Integer.parseInt(st.nextToken()); // 우리 당 최대 마리 수 1~10
			M = Integer.parseInt(st.nextToken()); // 정보 갯수 1~10

			cage = new int[N+1];
			ans = new int[N+1];
			ans[0] = -1;
			
			input = new int[M][3];	// 1~N // 1~N // 0~60
			
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				input[m][0] = Integer.parseInt(st.nextToken());
				input[m][1] = Integer.parseInt(st.nextToken());
				input[m][2] = Integer.parseInt(st.nextToken());
			}
			perm(1, 0);
			
			if(ans[0] < 0) { 
				sb.append('#').append(tc).append(' ').append(-1).append('\n');
			} else {
				sb.append('#').append(tc).append(' ');
				for (int i = 1; i <= N; i++) {
					sb.append(ans[i]).append(' ');
				}
				sb.append('\n');
			}
		} // end of Testcase
		System.out.println(sb.toString());
	}
	static void perm(int idx, int sum) {	//idx: 케이지 번호
		if(idx > N) {	// 모든 정보와 부합하는지 검사
			if(check()) {	// 만족하는 경우
				if(max < sum) {	// 등호 없는 경우 => 합계가 같으면 무시
					max = sum;
					ans[0] = 0;
					for (int i = 1; i <= N; i++) {
						ans[i] = cage[i];
					}
				}
			}
			return;
		}
		
		for (int i = 0; i <= X; i++) {	//0 부터 채우므로 자동으로 오름차순
			cage[idx] = i;
			perm(idx+1, sum+i);
		}
	}
	static boolean check() {
		for (int m = 0; m < M; m++) {	//M번의 체크가 전부 가능한지
			int sum = 0;
			for (int i = input[m][0]; i <= input[m][1]; i++)
				sum += cage[i];
			if(sum != input[m][2]) 
				return false;
		}
		return true;
	}
}

```

