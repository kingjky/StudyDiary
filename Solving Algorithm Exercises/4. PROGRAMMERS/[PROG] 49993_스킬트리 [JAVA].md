# [PROG] 49993_스킬트리 [JAVA]

## 문제

###### 문제 설명

선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.

예를 들어 선행 스킬 순서가 `스파크 → 라이트닝 볼트 → 썬더`일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.

위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 `스파크 → 힐링 → 라이트닝 볼트 → 썬더`와 같은 스킬트리는 가능하지만, `썬더 → 스파크`나 `라이트닝 볼트 → 스파크 → 힐링 → 썬더`와 같은 스킬트리는 불가능합니다.

선행 스킬 순서 skill과 유저들이 만든 스킬트리[1](https://programmers.co.kr/learn/courses/30/lessons/49993#fn1)를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.

##### 제한 조건

- 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
- 스킬 순서와 스킬트리는 문자열로 표기합니다.
  - 예를 들어, `C → B → D` 라면 CBD로 표기합니다
- 선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
- skill_trees는 길이 1 이상 20 이하인 배열입니다.
- skill_trees의 원소는 스킬을 나타내는 문자열입니다.
  - skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.

**[입출력]**

| skill   | skill_trees                         | return |
| ------- | ----------------------------------- | ------ |
| `"CBD"` | `["BACDE", "CBADF", "AECB", "BDA"]` | 2      |

##### 입출력 예 설명

- BACDE: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
- CBADF: 가능한 스킬트리입니다.
- AECB: 가능한 스킬트리입니다.
- BDA: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.

## 풀이 방법

- 

## 실행 코드

```java
package programmers;

import java.util.HashSet;

public class Solution_49993_스킬트리 {
	
	public static void main(String[] args) {
		Solution_49993_스킬트리 s = new Solution_49993_스킬트리();
		System.out.println(s.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
	}
	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int len = skill.length();
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < len; i++) set.add(skill.charAt(i));
        int size = skill_trees.length;
        for (int i = 0; i < size; i++) {
        	int cnt = 0;
			String cur = skill_trees[i];
			len = cur.length();
			for (int j = 0; j < len; j++) {
				char c = cur.charAt(j);
				if(set.contains(c)) {
					if(skill.charAt(cnt) != c) {
						answer--;
						break;
					} else cnt++;
				}
			}
			answer++;
		}
        return answer;
    }
}

```

```
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.95ms, 50.4MB)
테스트 2 〉	통과 (0.94ms, 50.7MB)
테스트 3 〉	통과 (0.99ms, 52.6MB)
테스트 4 〉	통과 (1.04ms, 52.7MB)
테스트 5 〉	통과 (1.13ms, 50.2MB)
테스트 6 〉	통과 (0.91ms, 54.2MB)
테스트 7 〉	통과 (1.09ms, 50.7MB)
테스트 8 〉	통과 (1.05ms, 52MB)
테스트 9 〉	통과 (1.02ms, 52.3MB)
테스트 10 〉	통과 (1.00ms, 50.7MB)
테스트 11 〉	통과 (1.05ms, 51.9MB)
테스트 12 〉	통과 (1.00ms, 50.3MB)
테스트 13 〉	통과 (1.06ms, 52.4MB)
테스트 14 〉	통과 (1.03ms, 52.4MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
```