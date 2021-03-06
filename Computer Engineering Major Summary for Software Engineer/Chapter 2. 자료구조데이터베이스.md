# Chapter 2. 자료구조/데이터베이스

- 데이터에 관한 내용
- 전반적 흐름을 이해하자

## part 1. 자료구조

- 자료구조란 ?

  - 자료를 효율적으로 표현하고 저장하고 처리하기 위한 도구

- 자료의 분류

  - 단순 구조 : 숫자, 문자 등
  - 선형 구조 : 리스트, 스택, 큐 등
  - 비선형 구조 : 1:N 또는 N:N 관계, 트리, 그래프 등
  - 파일 구조 : 관련된 필드로 구성된 레코드의 집합인 파일에 관한 구조
    순차 파일, 색인 파일, 직접 파일 등

- 자료구조의 관계
  ![structure](![자료구조의 관계 이미지 검색결과](https://1.bp.blogspot.com/-xIvY2zPVe0E/XDsYHAO93BI/AAAAAAAAKx8/pRmZ4xKdNkwzbdJDlzsI3UX-j57KiKLKwCLcBGAs/s1600/111.png)

- 알고리즘이란?

  - 문제해결 방법을 추상화하여 단계적 절차를 논리적으로 기술해 놓은 명세서
  - 조건
    - 입력, 출력, 명확성, 유한성, 효과성

- 알고리즘의 표현 방법

  - 자연어를 이용
  - 순서도(Flow Chart) 이용
  - 언어를 이용
  - Pseudo code 이용

- 알고리즘 성능 기준

  - 정확성, 명확성, 수행량, 메모리 사용량, 최적성

- 알고리즘 성능 분석 방법

  - 공간 복잡도
    - 총 저장 공간의 양
  - 시간 복잡도
    - 완료까지의 총 소요시간

- ### 선형 자료구조

  - ### 순차 자료구조 vs 연결 자료구조

    - 순차 자료구조

      - 메모리에 연속 저장하는 방식

      - 논리적 순서 == 물리적 순서

      - 배열 같은 개념

      - #### Linear List ( 선형 리스트 )

        - Ordered List ( 순서 리스트 )
        - 논리적인 순서대로 메모리에 연속으로 저장
        - 삽입, 삭제 시 물리적으로 앞 뒤로 이동

    - 연결 자료구조

      - 포인터 같은 개념

      - 논리적 순서 != 물리적 순서

      - 주소에 의해 순서가 연결되는 방식

      - #### 단순 연결 리스트

        - 노드 간 연결이 노드 내부 링크 필드에 의해 결정됨
        - 연결 리스트, 선형 연결 리스트, 단순 연결 선형 리스트

      - #### 원형 연결 리스트

        - 마지막 노드가 첫번째 노드를 가리키게 함

      - #### 이중 연결 리스트

        - 양쪽 방향으로 순회할 수 있도록 이중으로 연결된 리스트

  - ### Stack

    - **LIFO ( Last-In, First-out ) : 후입선출 구조**
    - Push, Pop (top)
    - 응용 분야
      - 시스템 스택
        프로그램에서의 호출과 복귀에 따른 수행 순서 관리

  - ### Queue

    - FIFO (First-In, First-Out) : 선입선출 구조
    - Enqueue(rear), Dequeue(front)
    - 응용 분야
      - 프린터 버퍼 큐
        프린터로 보낸 데이터 순서대로 출력
      - 스케쥴링 큐
        CPU 사용 요청 프로세들의 순서를 스케쥴링

  - ### Deque (double-ended queue)

    - 큐 두개 중 하나를 뒤집어 붙인 구조
    - queue + stack
    - 양쪽 끝(rear, front) 에서 각자 삽입 삭제가 가능

- ### 비선형 자료구조
  - ### Tree 트리

    - 원소들 간 1:n 관계를 갖는다

    - 원소들 간 계층관계를 갖는다

    - 상위 계층에서 하위로 내려가며 확장되는 구조

    - ### Binary Tree (이진 트리)

      - 하나의 부모가 두개의 자식을 갖는 구조

      - #### Full Binary Tree (포화 이진트리)

        - 모든 레벨에서 노드가 꽉 차 있음

      - #### Complete Binary Tree (완전 이진트리)

        - 꽉 차 있지 않아도, 왼쪽부터 차곡차곡 채워진 형태

      - #### Skewed Binary Tree (편향 이진트리)

        - 좌우 한 방향으로만 자식이 뻗어나가는 구조

  - ### Graph ( 그래프 )

    - 연결된 원소 사이의 n:m 관계를 표현
    - 그래프 G
      - 정점(Vertex)과 정점을 잇는 간선(Edge)의 집합
      - G = (V, E)
    - **Undirected Graph ( 무방향 그래프 )**
    - **Directed Graph ( 방향 그래프 )**
    - **Complete Graph ( 완전 그래프 )**
      - 모든 정점이 다른 모든 정점으로의 간선을 가진 그래프
      - 간선 수 : (n-1) * n / 2 (무향 일 경우)
    - **Subgraph (서브 그래프)**
    - **Weight Graph ( 가중치 그래프 ), Network ( 네트워크 )**

  - ### Spanning Tree ( 신장 트리 )

    - 깊이 우선 신장 트리

    - 너비 우선 신장 트리

    - 최소 비용 신장 트리
      무방향 가중치 그래프에서 간선의 가중치 합이 최소인 신장 트리

    - **최소 비용 신장 트리 알고리즘**

      - #### Kruskal

        가중치가 가장 낮은 간선부터 삽입하며 cycle 체크

      - #### Prim

        임의의 정점으로부터 연결된 최소 간선을 선택하며 확장

  - ### Shortest Path ( 최단 경로 )

    - 시작 노드에서 끝 노드까지의 거리를 최소한의 비용으로 가는 경로

    - **최단 경로 알고리즘**

      - #### Dijkstra

        하나의 시작 정점에서 다른 정점까지의 최단 경로

      - #### Floyd Warshall

        모든 정점 사이의 최단 경로

- ### Sort (정렬) 의 이해

  - 배열된 자료를 오름차순, 내림차순으로 재배열

  - Key (키) : 자료 정렬 시 기준이 되는 특정 값

  - #### 정렬의 종류

    - #### Selection Sort ( 선택 정렬 )

    - #### Bubble Sort ( 버블 정렬 )

    - #### Quick Sort ( 퀵 정렬 )

    - #### Insert Sort ( 삽입 정렬 )

    - #### Shell Sort ( 셀 정렬 )

    - #### Merge Sort ( 병합 정렬 )

    - #### Radix Sort ( 기수 정렬 )

      원소의 키 값을 나타내는 기수를 이용한 정렬

    - #### Heap Sort (힙 정렬 )

    - #### Tree Sort ( 트리 정렬 )

- ### Search ( 검색 )

  - 탐색 키( Search Key )를 가진 항목을 찾는 행위

  - 삽입 / 삭제 시 위치를 찾는 행위

  - 수행 위치에 따른 분류

    - 내부 검색 : 메모리 내 자료
    - 외부 검색 : 보조 기억 장치 내 자료

  - 검색 방식에 따른 분류

    - 비교 검색 방식 : 키를 일일히 비교
      순차, 이진, 트리 검색
    - 계산 검색 방식 : 계수적 성질을 이용
      해싱

  - #### Sequential Search (순차 검색), Linear Search (선형 검색)

  - #### Index Sequential Search ( 색인 순차 검색 )

  - #### Binary Search (이진 검색)

  - #### Binary Tree Search (이진 탐색 트리 이용 검색)

  - #### Hashing ( 해싱 )







