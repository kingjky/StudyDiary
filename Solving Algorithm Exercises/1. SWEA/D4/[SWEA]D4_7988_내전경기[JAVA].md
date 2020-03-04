# [SWEA]D4_7988_내전경기[JAVA]

## 문제

프로 게임 팀 RHS는 다가올 대회를 대비해서 내전을 하려고 한다.

게임은 2개의 팀으로 나눠서 진행된다. 각 팀에는 1명 이상의 사람이 필요하다.

RHS 팀원들은 다년간의 호흡으로 인해 서로 시너지 효과가 굉장히 좋은 관계가 여러 조합으로 존재한다.

내전은 그런 시너지 효과를 일절 발생시키지 않고 순수 자신들의 실력만으로 게임을 즐겨보려고 한다.

즉, 시너지 효과를 발생시키는 어떤 조합도 같은 팀에 배정하면 안 된다.

RHS 팀원들 간의 시너지 발생 조합이 주어졌을 때, 원하는 대로 팀을 2개로 만드는 것이 가능한지 확인하는 프로그램을 작성하라.


**[입력]**

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 시너지 효과를 일으키는 조합의 수 K(1 ≤ K ≤ 100)가 주어진다.

이어서 K개의 줄에 이어서 시너지 관계를 내는 두 명의 이름이 주어진다.

이름은 공백없이 주어지며 대소문자 알파벳과 ‘_’ 로, 50자 이하로 이루어져 있다.


**[출력]**

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

각 테스트 케이스마다 내전이 가능하게 팀 분배하는 것이 가능하면 Yes, 불가능하면 No를 출력하라. 

| 입력                                                         | 출력                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 3 // 테스트 케이스 개수<br/>2 // 첫 번째 테스트 케이스, K = 2<br/>Alex Tom<br/>Paul Alex<br/>4 // 두 번째 테스트 케이스, K = 4<br/>A B<br/>B C<br/>C D<br/>D A<br/>3 // 세 번째 테스트 케이스, K = 3<br/>z d<br/>d u_i<br/>z u_i | \#1 Yes // 첫 번째 테스트 케이스 결과<br/>\#2 Yes // 두 번째 테스트 케이스 결과<br/>\#3 No // 세 번째 테스트 케이스 결과 |


## 풀이 방법

> 때로는 모든 경우의 수를 따지는 것보다 사람의 생각 단계가 더 정확하고 빠를 수 있다


 * 문제 분석

    * 두명 사이의 시너지를  두 팀으로 무조건 쪼개야 한다. 가능한가? Y / N
 * 특이사항 1: 시너지의 정보 갯수 K 이지만 전체 총원 정보X

    * A B, C D, E F, ... 의 경우 최대 2K명
 * 특이사항 2: 팀의 배치에서 팀 순서와 관계없이 시너지를 반대 팀으로 보내면 됨.
   => 기준 정점 시너지를 반대로 보내는 BFS
 * 특이사항 3: 정점을 번호가 아닌 String으로 제공

    * 이름에 정점 번호를 붙여서 index 형태로 활용할 수 있도록 input 값 가공 필요

## 실행 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_D4_7988_내전경기 {
	static int K; // 시너지 효과 갯수
	static HashMap<String, Integer> player; // 이름, 번호
	static boolean[][] map;	// 두 정점 사이에 시너지가 있는지를 판단하는 용도
	static int[] teamInfo;	// 각 정점이 어느 팀에 위치해 있는지 기록
	static boolean ans; 	// 가능-불가능 기록할 변수
	static int pcnt;		// 총 인원 수동 Count
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			map = new boolean[2*K][2*K];	// 최대 인원으로 가정
			player = new HashMap<String, Integer>();
			pcnt = 0;	// 플레이어 번호 0번부터 시작\
			ans = true;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				String name1, name2;
				name1 = st.nextToken();
				name2 = st.nextToken();
				
				if(!player.containsKey(name1)) {
					player.put(name1, pcnt);
					pcnt++;
				}
				if(!player.containsKey(name2)) {
					player.put(name2, pcnt);
					pcnt++;
				}
				
				map[player.get(name1)][player.get(name2)]
				 = map[player.get(name2)][player.get(name1)]
				 = true;
			}
			
			teamInfo = new int[pcnt];	// 1팀, 2팀, 미정일 경우 0팀
			
			for (int i = 0; i < pcnt; i++) {	// 모든 플레이어에 대해서 시너지가 상대편으로 갔는지 확인
				if(teamInfo[i] == 0) {
					teamInfo[i] = 1;
					bfs(i);
				}
				if(!ans)
					break;
			}
			
			System.out.printf("#%d %s\n", t, ans?"Yes":"No");
		}
	}
	static void bfs(int idx) {	//출발하는 정점 시너지를 찢기 시작
		Queue<Integer> que = new LinkedList<>();
		que.add(idx);
		
		while(!que.isEmpty()) {
			int me = que.poll();	//나를 기준으로
			for (int i = 0; i < pcnt; i++) {	// 모든 플레이어 검사해서 시너지 있는 경우 반대 팀으로
				if(map[me][i]) {	// me와 시너지 있는 플레이어
					if(teamInfo[i] != 0 && teamInfo[i] == teamInfo[me]) { // 이미 팀이 결정된 시너지 플레이어가 나와 같은 팀 
						ans = false;
						return;
					}
					if(teamInfo[i] == 0) {	//
						teamInfo[i] = teamInfo[me]==1 ? 2: 1;
						que.add(i);
					}
				}
			}
		}
		
	}

}

```

