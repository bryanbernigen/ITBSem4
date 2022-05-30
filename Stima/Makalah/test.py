import random

class pasien: 
    def __init__(self, nama, available, unavailable, lama, prediksi): 
        self.nama = nama
        self.available = available
        self.unavailable = unavailable
        self.lama = lama
        self.prediksi = self.available + self.lama
   
# creating list       
list = [] 
  
# appending instances to list 
# add 12 pasien with available time randomly from 7 until 12 dan unavailable time random from 12 until 15
# for i in range(20):
#     nama = "pasien" + str(i+1)
#     available = random.randint(7, 12)
#     unavailable = random.randint(18, 24)
#     lama = random.randint(1, 5)
#     list.append(pasien(nama, available, unavailable, lama))
'''
pasien1 8 19 2 10
pasien2 9 18 5 14
pasien3 11 23 4 15
pasien4 9 19 4 13
pasien5 11 20 3 14
pasien6 12 20 2 14
pasien7 11 24 3 14
pasien8 9 22 2 11
pasien9 12 23 5 17
pasien10 11 19 4 15
pasien11 10 18 5 15
pasien12 12 23 2 14
pasien13 10 21 5 15
pasien14 11 19 3 14
pasien15 9 23 2 11
pasien16 7 20 4 11
pasien17 7 18 4 11
pasien18 9 20 2 11
pasien19 11 20 5 16
pasien20 8 22 3 11
'''
list.append(pasien("pasien1", 8, 19, 2, 10))
list.append(pasien("pasien2", 9, 18, 5, 14))
list.append(pasien("pasien3", 11, 23, 4, 15))
list.append(pasien("pasien4", 9, 19, 4, 13))
list.append(pasien("pasien5", 11, 20, 3, 14))
list.append(pasien("pasien6", 12, 20, 2, 14))
list.append(pasien("pasien7", 11, 24, 3, 14))
list.append(pasien("pasien8", 9, 22, 2, 11))
list.append(pasien("pasien9", 12, 23, 5, 17))
list.append(pasien("pasien10", 11, 19, 4, 15))
list.append(pasien("pasien11", 10, 18, 5, 15))
list.append(pasien("pasien12", 12, 23, 2, 14))
list.append(pasien("pasien13", 10, 21, 5, 15))
list.append(pasien("pasien14", 11, 19, 3, 14))
list.append(pasien("pasien15", 9, 23, 2, 11))
list.append(pasien("pasien16", 7, 20, 4, 11))
list.append(pasien("pasien17", 7, 18, 4, 11))
list.append(pasien("pasien18", 9, 20, 2, 11))
list.append(pasien("pasien19", 11, 20, 5, 16))
list.append(pasien("pasien20", 8, 22, 3, 11))


for i in list:
    print(i.nama, i.available, i.unavailable, i.lama, i.prediksi)
print("\n")
result = []
max_selesai = 0
while(len(list)!=0):
    min_idx = 0
    n = len(list)
    i = 0
    while i < n:
        if(list[i].available < max_selesai):
            list[i].available = max_selesai
            list[i].prediksi = list[i].available + list[i].lama
        if(list[i].prediksi > list[i].unavailable):
            list.pop(i)
            i = i - 1
            n = n - 1
        else:
            if(list[min_idx].prediksi > list[i].prediksi):
                min_idx = i
        i = i + 1
    max_selesai = list[min_idx].prediksi
    result.append(list[min_idx].nama)
    print(list[min_idx].nama, "dikerjakan pada jam", list[min_idx].available, "selesai pada jam", list[min_idx].prediksi)
    list.pop(min_idx)