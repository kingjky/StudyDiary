# Chapter 8. 시각화와 그래프

1. ### 시각화의 두 가지 목적

   - 분석에 도움이 된다
     - 보이지 않던 문제가 보인다
       ex) outlier (이상점)
     - 리포팅에 도움이 된다
   - 이해하기 쉽고 시각적 측면 강조
2. ### 선 그래프

   - 숫자 데이터에만 적용 가능

3. ### (Quiz) 국가별 경제 성장

4. ### (Quiz) 국가별 경제 성장 분석

   ```python
   %matplotlib inline
   import pandas as pd
   
   df = pd.read_csv('data/gdp.csv', index_col=0)
   
   # 코드를 작성하세요.
   df.plot(y = ["Korea_Rep", "United_States", "United_Kingdom", "Germany", "China", "Japan"])
   ```

5. ### 막대 그래프

   - 선 그래프와 달리 막대 그래프가 필요한 경우가 존재
   - 시간에 따른 추이 변화가 아닌, 항목별 차이

   ```python
   df.plot(kind='bar') # 막대 그래프
   df.plot(kind='barh') # horizontal 막대 그래프
   df.plot(kind='bar', stacked=True) # stack 막대 그래프
   df['Female'].plot(kind='bar') # 여성 데이터의 막대 그래프
   ```
   
   
   
6. ### (Quiz) 실리콘 밸리에는 누가 일할까? I

7. ### (Quiz) 실리콘 밸리에는 누가 일할까? I Solve

   ```python
   %matplotlib inline
   import pandas as pd
   
   df = pd.read_csv('data/silicon_valley_summary.csv')
   boolean_male = df['gender']=='Male'
   boolean_manager = df['job_category'] == 'Managers'
   boolean_not_all = df['race_ethnicity'] != 'All'
   
   df[boolean_male & boolean_manager & boolean_not_all].plot(kind='bar', x='race_ethnicity',  y='count')
   ```

8. ### 파이 그래프

   - 비율을 나타내는 그래프

     ```python
     df.loc[2017].plot(kind='pie')
     ```

     

9. ### (Quiz) 실리콘 밸리에는 누가 일할까? II

   ```python
   %matplotlib inline
   import pandas as pd
   
   df = pd.read_csv('data/silicon_valley_details.csv')
   
   # 코드를 작성하세요.
   boolean_adobe = (df['company']=='Adobe');
   boolean_all_race = (df['race']=='Overall_totals')
   boolean_not_total = ((df['job_category'] != 'Totals') & (df['job_category'] != 'Previous_totals'))
   boolean_not_zero = (df.loc[boolean_adobe & boolean_all_race & boolean_not_total].set_index('job_category')['count'] != 0)
   
   df.loc[boolean_adobe & boolean_all_race & boolean_not_total].set_index('job_category')[boolean_not_zero].plot(kind='pie', y='count')
   ```

10. ### (Quiz) 실리콘 밸리에는 누가 일할까? II Solve

    ```python
    %matplotlib inline
    import pandas as pd
    
    df = pd.read_csv('data/silicon_valley_details.csv')
    
    boolean_adobe = df['company'] == 'Adobe'
    boolean_all_races = df['race'] == 'Overall_totals'
    boolean_count = df['count'] != 0
    boolean_job_category = (df['job_category'] != 'Totals') & (df['job_category'] != 'Previous_totals')
    
    df_adobe = df[boolean_adobe & boolean_all_races & boolean_count & boolean_job_category]
    df_adobe.set_index('job_category', inplace=True)
    df_adobe.plot(kind='pie', y= 'count')
    ```

11. ### 히스토그램

    - 선 그래프 : 변화

    - 막대 그래프 : 항목 비교 

    - 파이 그래프 : 비율 비교

    - 히스토그램

      - 범위로 한 항목으로 묶음

      ```python
      df.plot(kind='hist', y='Height', bins=15) # bins default=10
      ```

      

12. ### (Quiz) 스타벅스 음료의 칼로리는? I

13. ### (Quiz) 스타벅스 음료의 칼로리는? I Solve

14. ### 박스 플롯

15. ### (Quiz)  스타벅스 음료의 칼로리는? II

16. ### (Quiz)  스타벅스 음료의 칼로리는? II Solve

17. ### 산점도

18. ### 국가 지표 분석하기

19. ### 어느 그래프가 어울릴까?

    
