# Chapter 5. DataFrame 인덱싱

1. ### DataFrame 인덱싱 I

   - DataFrame : pandas의 표 형식의 2차원 자료형

     - Series : pandas의 1차원 자료형

   - DataFrame Indexing : DataFrame 형식 데이터 중 일부를 발췌하는 것

     ```python
     import pandas as pd
     
     iphone_df = pd.read_csv('data/iphone.csv', index_col=0)
     print(type(iphone_df))
     
     print(iphone_df.loc['iPhone 8', '메모리']) # 아이폰8의 메모리 셀 정보
     print(iphone_df.loc['iPhone X', :])        # 아이폰8 row
     print(iphone_df.loc['iPhone X'])      # 위와 같음
     
     print(iphone_df.loc[:, '출시일'])           # 모든 기종의 출시일
     ```

     

2. ### (Quiz) 방송사 시청률 받아오기 I

3. ### (Quiz) 방송사 시청률 받아오기 I Solve

   ```python
   import pandas as pd
   
   df = pd.read_csv('data/broadcast.csv', index_col=0)
   
   # 코드를 작성하세요.
   df.loc[2016, 'KBS']
   ```

4. ### (Quiz) 방송사 시청률 받아오기 II

5. ### (Quiz) 방송사 시청률 받아오기 II Solve

   ```python
   import pandas as pd
   
   df = pd.read_csv('data/broadcast.csv', index_col=0)
   # 코드를 작성하세요.
   df['JTBC']
   ```

   - `df.loc[ : , 'JTBC']` 의 생략형

6. ### (Quiz) 방송사 시청률 받아오기 III

7. ### (Quiz) 방송사 시청률 받아오기 III Solve

   ```python
   import pandas as pd
   
   df = pd.read_csv('data/broadcast.csv', index_col=0)
   # 코드를 작성하세요.
   df[['SBS','JTBC']]
   ```

   - 여러 column에 대한 indexing은 리스트로 가능

8. ### (Quiz) 카드사 고객 분석

9. ### (Quiz) 카드사 고객 분석

   ```python
   import pandas as pd
   
   samsong_df = pd.read_csv('data/samsong.csv')
   hyundee_df = pd.read_csv('data/hyundee.csv')
   
   df = pd.DataFrame({
       'day': samsong_df['요일'],
       'samsong': samsong_df['문화생활비'],
       'hyundee': hyundee_df['문화생활비'],
   })
   
   df
   ```

   - DataFrame 을 생성하는 방법
     - Dictionary 활용

10. ### DataFrame 인덱싱 II

    - 여러 줄을 한꺼번에 받아오는 법

    ```python
    import pandas as pd
    
    iphone_df = pd.read_csv('data/iphone.csv', index_col=0)
    
    print(iphone_df.loc[['iPhone X', 'iPhone 8']]) # 여러 Row 받아오기
    print(iphone_df[['Face ID', '출시일', '메모리']]) # 여러 Column 받아오기
    
    print(iphone_df.loc['iPhone 8' : 'iPhone XS']) # from부터 to까지 의 Row 받아오기
    print(iphone_df.loc[: 'iPhone XS']) # 처음부터 to까지 의 Row 받아오기
    
    print(iphone_df.loc[:, '메모리':'Face ID']) # 메모리 부터 Face ID 까지 Column 의 모든 Row 받아오기
    print(iphone_df.loc['iPhone 8':'iPhone XS', '메모리':'Face ID'])
    # 메모리 부터 Face ID 까지 Column 의 아이폰8 부터 아이폰 XS Row 데이터 받아오기
    ```

    - Row의 경우 간단히 범위 선택이 가능
    - Column 은 범위 선택 시 축약형 사용 불가

11. ### (Quiz) 방송사 시청률 받아오기 IV

12. ### (Quiz) 방송사 시청률 받아오기 IV Solve

    ```python
    import pandas as pd
    
    df = pd.read_csv('data/broadcast.csv', index_col=0)
    # 코드를 작성하세요.
    df.loc[2012:2017, 'KBS':'SBS']
    ```

13. ### DataFrame 조건으로 인덱싱

    ```python
    import pandas as pd
    
    iphone_df = pd.read_csv('data/iphone.csv', index_col=0)
    
    print(iphone_df.loc[[True, False, True, True, False, True, False]])
    print(iphone_df.loc[:, [True, False, False, True, False]])
    
    print(iphone_df['디스플레이'] > 5)
    print(iphone_df.loc[iphone_df['디스플레이'] > 5])
    
    print(iphone_df['Face ID'] == 'Yes')
    print(iphone_df.loc[iphone_df['Face ID'] == 'Yes'])
    
    print((iphone_df['디스플레이'] > 5) & (iphone_df['Face ID'] == 'Yes'))
    print(iphone_df.loc[(iphone_df['디스플레이'] > 5) & (iphone_df['Face ID'] == 'Yes')])
    ```

    - DataFrame은 각 column 혹은 row 에 대한 Boolean 값으로도 indexing 이 가능
    - 조건식을 통해 column 혹은 row에 boolean 값 자동 생성 가능
    - 생성된 true, false 값을 다시 df.loc[] 내부의 index로 지정하면 조건에 맞는 row 또는 column 만 추출 가능

14. wait

15. wait

16. wait

17. wait

18. wait

19. ### DataFrame 인덱싱 문법 정리

    | 이름으로 인덱싱하기           | 기본 형태                             | 단축 형태                      |
    | ----------------------------- | ------------------------------------- | ------------------------------ |
    | 하나의 row 이름               | `df.loc["row4"]`                      |                                |
    | row 이름의 리스트             | `df.loc[["row4", "row5", "row3"]]`    |                                |
    | row 이름의 리스트 슬라이싱    | `df.loc["row2":"row5"]`               | `df["row2":"row5"]`            |
    | 하나의 column 이름            | `df.loc[:, "col1"]`                   | `df["col1"]`                   |
    | column 이름의 리스트          | `df.loc[:, ["col4", "col6", "col3"]]` | `df[["col4", "col6", "col3"]]` |
    | column 이름의 리스트 슬라이싱 | `df.loc[:, "col2":"col5"]`            |                                |

    | 위치로 인덱싱하기             | 기본 형태               | 단축 형태 |
    | ----------------------------- | ----------------------- | --------- |
    | 하나의 row 위치               | `df.iloc[8]`            |           |
    | row 위치의 리스트             | `df.iloc[[4, 5, 3]]`    |           |
    | row 위치의 리스트 슬라이싱    | `df.iloc[2:5]`          | `df[2:5]` |
    | 하나의 column 위치            | `df.iloc[:, 3]`         |           |
    | column 위치의 리스트          | `df.iloc[:, [3, 5, 6]]` |           |
    | column 위치의 리스트 슬라이싱 | `df.iloc[:, 3:7]`       |           |

