import itertools
from collections import Counter
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
import matplotlib.font_manager as fm



body_df  = pd.read_csv('data/body.csv', index_col=0)
# print(body_df)
# print(body_df.head())
# body_df['Height'].value_counts().sort_index().plot()
sns.kdeplot(body_df['Height'])

plt.show()