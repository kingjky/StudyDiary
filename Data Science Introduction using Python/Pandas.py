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