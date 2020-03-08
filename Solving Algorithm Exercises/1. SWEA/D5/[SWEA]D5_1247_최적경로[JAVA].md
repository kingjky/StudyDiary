# [SWEA]D5_1247_최적경로[JAVA]

## 문제

삼성전자의 서비스 기사인 김대리는 회사에서 출발하여 냉장고 배달을 위해 N명의 고객을 방문하고 자신의 집에 돌아가려한다.

회사와 집의 위치, 그리고 각 고객의 위치는 이차원 정수 좌표 (x, y)로 주어지고 (0 ≤ x ≤ 100, 0 ≤ y ≤ 100)

두 위치 (x1, y1)와 (x2, y2) 사이의 거리는 |x1-x2| + |y1-y2|으로 계산된다.

여기서 |x|는 x의 절대값을 의미하며 |3| = |-3| = 3이다. 회사의 좌표, 집의 좌표, 고객들의 좌표는 모두 다르다.

회사에서 출발하여 N명의 고객을 모두 방문하고 집으로 돌아오는 경로 중 가장 짧은 것을 찾으려 한다.

회사와 집의 좌표가 주어지고, 2명에서 10명 사이의 고객 좌표가 주어질 때,

회사에서 출발해서 이들을 모두 방문하고 집에 돌아가는 경로 중 총 이동거리가 가장 짧은 경로를 찾는 프로그램을 작성하라.

여러분의 프로그램은 가장 짧은 경로의 이동거리만 밝히면 된다.

이 문제는 가장 짧은 경로를 ‘효율적으로’ 찾는 것이 목적이 아니다.

여러분은 모든 가능한 경로를 살펴서 해를 찾아도 좋다.

모든 경우를 체계적으로 따질 수 있으면 정답을 맞출 수 있다.

**[제약사항]**

고객의 수 N은 2≤N≤10 이다.

그리고 회사의 좌표, 집의 좌표를 포함한 모든 N+2개의 좌표는 서로 다른 위치에 있으며 좌표의 값은 0이상 100 이하의 정수로 이루어진다.

**[입력]**

가장 첫줄은 전체 테스트케이스의 수이다.

이후, 두 줄에 테스트 케이스 하나씩이 차례로 주어진다.

각 테스트 케이스의 첫째 줄에는 고객의 수 N이 주어진다. 둘째 줄에는 회사의 좌표,집의 좌표, N명의 고객의 좌표가 차례로 나열된다.

좌표는 (x,y)쌍으로 구성되는데 입력에서는 x와 y가 공백으로 구분되어 제공된다.


**[출력]**

총 10줄에 10개의 테스트 케이스 각각에 대한 답을 출력한다.

각 줄은 ‘#x’로 시작하고 공백을 하나 둔 다음 최단 경로의 이동거리를 기록한다. 여기서 x는 테스트 케이스의 번호다.

| 입력                                                         | 출력                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 10<br/>5<br/>0 0 100 100 70 40 30 10 10 5 90 70 50 20<br/>6<br/>88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14<br/>7<br/>22 47 72 42 61 93 8 31 72 54 0 64 26 71 93 87 84 83<br/>8<br/>30 20 43 14 58 5 91 51 55 87 40 91 14 55 28 80 75 24 74 63<br/>9<br/>3 9 100 100 16 52 18 19 35 67 42 29 47 68 59 38 68 81 80 37 94 92<br/>10<br/>39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36<br/>10<br/>26 100 72 2 71 100 29 48 74 51 27 0 58 0 35 2 43 47 50 49 44 100 66 96<br/>10<br/>46 25 16 6 48 82 80 21 49 34 60 25 93 90 26 96 12 100 44 69 28 15 57 63<br/>10<br/>94 83 72 42 43 36 59 44 52 57 34 49 65 79 14 20 41 9 0 39 100 94 53 3<br/>10<br/>32 79 0 0 69 58 100 31 67 67 58 66 83 22 44 24 68 3 76 85 63 87 7 86 | #1 200<br/>#2 304<br/>#3 265<br/>#4 307<br/>#5 306<br/>#6 366<br/>#7 256<br/>#8 399<br/>#9 343<br/>#10 391 |


## 풀이 방법

- 풀이

  고객의 수 N의 범위가 2~10으로 매우 작으므로,

  만들 수 있는 모든 고객 방문 순서를 NextPermutation으로 생성하여 각각의 총 이동거리를 계산해 최소값을 구한다.

  

## 실행 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_D5_1247_최적경로 {
 
    static int p[], N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            int[][] customers = new int[N][2];  // N명의 고객집 좌표
            int[][] distance = new int[N+2][2]; // 회사 좌표(0), N명의 집 좌표(순열로 순서 결정:1~N), 집 좌표(N+1)
            p = new int[N];
            int min = Integer.MAX_VALUE;
             
            st = new StringTokenizer(br.readLine());
            distance[0][0] = Integer.parseInt(st.nextToken());      //회사
            distance[0][1] = Integer.parseInt(st.nextToken());
            distance[N+1][0] = Integer.parseInt(st.nextToken());    //집
            distance[N+1][1] = Integer.parseInt(st.nextToken());
             
            for (int i = 0; i < N; i++) {
                customers[i][0] = Integer.parseInt(st.nextToken());
                customers[i][1] = Integer.parseInt(st.nextToken());
                p[i] = i+1;
            }   // p[] = {1,2,3,4,5,...}
             
            do {
                for (int i = 0; i < N; i++) {
                    distance[p[i]] = customers[i];
                }
                int temp = 0;
                for (int i = 0; i <= N; i++) {   // 앞집부터 뒷집(인접한 두 집 처리)
                    temp += Math.abs(distance[i][0] - distance[i+1][0]);
                    temp += Math.abs(distance[i][1] - distance[i+1][1]);
                }
                if(min > temp) min = temp;
            }while(nextPer());
            System.out.printf("#%d %d\n", t, min);
        } // end of TC
 
    }
 
 
    private static boolean nextPer() {
        int i, j;
        i = j = N - 1;
        while (i > 0 && p[i - 1] >= p[i]) i--;
        if(i == 0) return false;
        while(p[j] <= p[i-1]) j--;
        swap(i-1, j);
        j = N-1;
        while(i<j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }
 
    private static void swap(int i, int j) {
        int tmp = p[i];
        p[i] = p[j];
        p[j] = tmp;
    }
 
}
```

| 메모리    | 실행시간 |
| --------- | -------- |
| 32,604 kb | 1,778 ms |

