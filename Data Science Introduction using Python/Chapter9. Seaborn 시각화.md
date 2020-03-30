# Chapter9. Seaborn 시각화

1. ### Seaborn 소개

   - 다양한 그래프 제공
     - 근사한 그래프
     - 더 많은 insight
   
2. ### 확률 밀도 함수 (PDF)

   - Seaborn
     - Statistical Data Visualization : 통계를 기반으로 한 데이터 시각화
   - PDF ( Probability Density Function ) : 확률 밀도 함수
     - 확률 밀도 함수는 데이터셋의 분포를 나타낸다
     - 특정 구간의 확률은 그래프 아래 구간의 면적과 동일하다
     - 그래프 아래 모든 면적을 더하면 1이 된다

3. ### (Quiz) 확률 밀도 함수 개념 확인

4. ### KDE Plot

   - KDE ( Kernel Density Estimation )
     - 유한한 데이터의 한계를 극복하기 위해 추정을 통해 매끄러운 그래프 작성

   ```python
   import pandas as pd
   import seaborn as sns
   import matplotlib.pyplot as plt
   
   body_df  = pd.read_csv('data/body.csv', index_col=0)
   # print(body_df)
   # print(body_df.head())
   # body_df['Height'].value_counts().sort_index().plot()
   sns.kdeplot(body_df['Height'], bw=0.05)
   
   plt.show()
   ```

5. #### (Quiz) 서울 지하철 승차인원

6. #### (Quiz) 서울 지하철 승차인원 Solve

   ```python
   %matplotlib inline
   import pandas as pd
   import seaborn as sns
   
   df = pd.read_csv('data/subway.csv')
   
   sns.kdeplot(df['in'])
   ```

7. 
