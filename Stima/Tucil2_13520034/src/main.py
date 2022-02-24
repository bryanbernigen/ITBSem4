from audioop import mul
from json import load
from scipy.spatial import ConvexHull
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn import datasets, multiclass
from myConvexHull import MyConvexHull
#UBAH DATA YANG INGIN DI PLOT DI SINI=======================================
data = datasets.load_linnerud()
#UBAH DATA YANG INGIN DI PLOT DI SINI=======================================

# create a DataFrame
df = pd.DataFrame(data.data, columns=data.feature_names)
df['Target'] = pd.DataFrame(data.target)

# visualisasi hasil ConvexHull
#masukkan index kolom data yang ingin di plot 
#UBAH YANG INGIN DI PLOT DI BAGIAN SINI=====================================
#index parameter yang akan di plot di sumbu_x dan sumbu_y 
sumbu_x= 0
sumbu_y = 1
judul_plot = 'BMI vs Average Blood Pressure'
colors = ['b', 'r', 'g']
#UBAH YANG INGIN DI PLOT DI BAGIAN SINI=====================================
plt.figure(figsize=(10, 6))
plt.title(judul_plot)
plt.xlabel(data.feature_names[sumbu_x])
plt.ylabel(data.feature_names[sumbu_y])

#CEK TABEL DATA YANG AKAN DI PLOT===========================================
multiple_class=True
multiple_taget=True
#cek banyaknya kelas
try:
    data.target_names
except:
    multiple_class=False

#cek tipe target
try:
    a=df[df['Target']==0]
    a[0]
except:
    multiple_taget=False

loop=1
if (multiple_class):
    loop = len(data.target_names)
#CEK TABEL DATA YANG AKAN DI PLOT===========================================

for i in range(loop):
    if(multiple_taget):
        bucket = df[df['Target']==i]
    else:
        bucket = df[df['Target']>0]
    bucket = bucket.iloc[:, [sumbu_x, sumbu_y]].values
    #CONVEX HULL USING MY OWN ALGORITHM===================================================
    hull = MyConvexHull(bucket)
    if(multiple_class):
        plt.scatter(bucket[:, 0], bucket[:, 1],label=data.target_names[i])
    else:
        plt.scatter(bucket[:, 0], bucket[:, 1],label=judul_plot)
    for simplex in hull:
        plt.plot(bucket[simplex, 0], bucket[simplex, 1], colors[i])
    #CONVEX HULL USING MY OWN ALGORITHM===================================================
plt.legend()
plt.show()

