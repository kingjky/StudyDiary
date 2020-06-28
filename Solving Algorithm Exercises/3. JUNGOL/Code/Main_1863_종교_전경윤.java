package JungOl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
	1863 : 종교
제한시간: 1000 ms    메모리제한: 64 MB
해결횟수: 570 회    시도횟수: 3849 회   



오늘날 아주 많은 다른 종교들이 있고 이들 모두를 추적하는 것은 어려운 일이다.
당신이 다니는 학교에서 학생들이 믿고 있는 종교가 총 몇 가지 있는가를 알고자 한다.


학교에는 n (0 < n ≤ 50,000)명의 학생이 있다.
모든 학생에게 자기가 가진 종교가 무엇인지를 물어보는 것은 힘든 일이고 

게다가 많은 학생들은 그들의 종교를 나타내는 것을 좋아하지 않는다.


이 문제를 해결하기 위한 한 가지 방법은 같은 종교를 가지는 사람들 끼리 짝을 짓도록 하는 것이다.


쌍의 수는 m ( 0 ≤ m ≤ 100,000 ) 이다. 

이 데이터로 당신은 모든 학생들이 어떤 종교를 가지고 있는가는 알지 못하지만 

학생들이 최대한 가질 수 있는 종교의 가지 수를 알 수 있다.


모든 학생들이 최대 한 가지 종교를 가지고 있다고 하자.



 
정수 n , m 이 주어진다. 다음 m 라인은 두 정수 i , j 가 주어진다.
i, j 는 i번 학생과 j번 학생이 같은 종교를 가진 학생의 쌍이다(1≤i, j≤n).




종교의 가지 수를 출력한다.




10 9
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10

1
 */
public class Main_1863_종교_전경윤 {
	static int N, M, religion;
	static int[][] arr;
	static boolean[] visited;
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		parents = new int[N];
		Arrays.fill(parents, -1);

		for (int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0])-1;
			int b = Integer.parseInt(str[1])-1;
			union(a, b);
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			if(parents[i]<0)
				count++;
		}
		System.out.println(count);
	}
	
	private static boolean union(int a, int b) {
		//2. find set : 자신이 속한 집합 찾기
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot) {		//3. union set : 두 노드의 집합이 다르면 합치기
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}
	private static int find(int a) {
		if(parents[a]<0) return a;	//루트노드이면 자신의 번호 리턴
		// 루트노드가 아니면 부모노드 따라가서 루트노드 알아온다.
		return parents[a] = find(parents[a]); // path compression :  루트 노드를 리턴받아 자신의 부모노드로 등록
	}
}
