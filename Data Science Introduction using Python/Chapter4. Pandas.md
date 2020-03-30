# Chapter 4. Pandas

1. ## pandas란?

   - 파이썬이 R의 장점을 갖게 해준 라이브러리
     - 데이터 보관
     - 데이터 정리
     - 데이터 분석
     - 외부 데이터 읽고 쓰기
   - numpy 를 기반으로 만들어짐
   - 표 형식의 데이터를 다루는데 능함

2. ## DataFrame 소개

   1. DataFrame
      - 2차원 형태 데이터를 다루기 위한 자료형
      - 표 형식(column, row(index))의 데이터를 담음
        - column : 데이터의 특징
        - row : 레코드
      - numpy 2차원 array 와의 차이?
        - row, column 에 이름을 붙이고 탐색할 수 있음
        - column 마다 각기 다른 자료형을 다룰 수 있음

3. ## DataFrame 사용해 보기

4. ### DataFrame을 만드는 다양한 방법

5. ### (Quiz) 스타들의 생일은 언제?

   ```python
   import pandas as pd
   
   # 코드를 작성하세요.
   columns = (
       "name",
       "birthday",
       "occupation",
   )
   
   data = [['Taylor Swift', 'December 13, 1989', 'Singer-songwriter'],
          ['Aaron Sorkin', 'June 9, 1961', 'Screenwriter'],
          ['Harry Potter', 'July 31, 1980', 'Wizard'],
          ['Ji-Sung Park', 'February 25, 1981', 'Footballer']]
   
   df = pd.DataFrame(data, columns=columns);
   # 정답 출력
   df
   ```

6. ### (Quiz) 스타들의 생일은 언제? Solve

7. ### pandas의 데이터 타입

   ```python
   import pandas as pd
   
   two_dimensional_list = [['dongwook', 50, 86], ['sineui', 89, 31], ['ikjoong', 68, 91], ['yoonsoo', 88, 75]]
   
   my_df = pd.DataFrame(two_dimensional_list, columns=['name', 'english_score', 'math_score'], index=['a', 'b', 'c', 'd'])
   
   print(my_df.dtypes)
   ```

   ```python
   name             object
   english_score     int64
   math_score        int64
   dtype: object
   ```

   | dtype        | 설명            |
   | ------------ | --------------- |
   | `int64`      | 정수            |
   | `float64`    | 소수            |
   | `object`     | 텍스트          |
   | `bool`       | 불린(참과 거짓) |
   | `datetime64` | 날짜와 시간     |
   | `category`   | 카테고리        |

8. ### pandas로 데이터 읽어들이기

   ```python
   import pandas as pd
   iphone_df = pd.read_csv('data/iphone.csv', index_col=0)
   #	0번 column을 index로 사용한다.
   iphone_df
   ```

   

9. ### (Quiz) 가장 인기 있는 아기 이름은?

10. ### (Quiz) 가장 인기 있는 아기 이름은? Solve

    ```python
    import pandas as pd
    
    # 코드를 작성하세요.
    df = pd.read_csv('data/popular_baby_names.csv')
    # 정답 출력
    df
    ```

11. ### (Quiz) 메가밀리언 로또 당첨 번호

12. ### (Quiz) 메가밀리언 로또 당첨 번호 Solve

    ```python
    import pandas as pd
    
    df = pd.read_csv('data/mega_millions.csv', index_col='Draw Date')
    df # 정답 출력
    ```

    

