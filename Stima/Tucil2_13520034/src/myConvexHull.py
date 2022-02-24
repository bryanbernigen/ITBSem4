import numpy as np

from numpy.linalg import norm

#Menambahkan Nomor titik pada array of titik sekaligus mengurutkan data
def addNo(bucket):
    temp = []
    for i in range(len(bucket)):
        temp.append([i, bucket[i][0], bucket[i][1]])
    # Mengurutkan Data sesuai x dan y
    temp = sorted(temp, key=lambda x: (x[1], x[2]))
    return temp


# mengecek jika test didalam segitiga t0,t1,t2 dengan menggunakan area
#jika test bernilai true jika test berada dalam segitiga t1 t2 t3
def dalemSegitiga(t1, t2, t3, test):
    #menghitung luas segitiga
    def area(x1, y1, x2, y2, x3, y3):
        return abs((x1 * (y2 - y3) + x2 * (y3 - y1)
                + x3 * (y1 - y2)) / 2.0)
    #menghitung luas segitiga dari kombinasi 4 titik
    A123 = area(t1[1], t1[2], t2[1], t2[2], t3[1], t3[2])
    Atest23 = area(test[1], test[2], t2[1], t2[2], t3[1], t3[2])
    A1test3 = area(t1[1], t1[2], test[1], test[2], t3[1], t3[2])
    A12test = area(t1[1], t1[2], t2[1], t2[2], test[1], test[2])
    if(A123 - (Atest23 + A1test3 + A12test) > -10e-6 and A123 - (Atest23 + A1test3 + A12test) < 10e-6):
        return True
    else:
        return False


# mengecek jika titik test dikiri atau dikanan garis t1 t2
# bernilai true jika test berada di kanan garis t1 t2
def kiriOrKanan(t1, t2, test):
    result = t1[1]*t2[2] + test[1]*t1[2] + t2[1] * \
        test[2] - test[1]*t2[2]-t2[1]*t1[2] - t1[1]*test[2]
    if(result == 0):
        return -1
    if(result > 0):
        return 1
    else:
        return 0


# menghitung jarak titik test ke sebuah garis t1 t2
def jarakTitikKeGaris(t1, t2, test):
    p1 = [t1[1], t1[2]]
    p2 = [t2[1], t2[2]]
    p3 = [test[1], test[2]]
    p1 = np.asarray(p1)
    p2 = np.asarray(p2)
    p3 = np.asarray(p3)
    d = norm(np.cross(p2-p1, p1-p3))/norm(p2-p1)
    return d


# convexhull jika masih belum memilih 2 titik maximal
def MyConvexHull(bucket):
    bucket = addNo(bucket)
    t1 = bucket[0]
    t2 = bucket[len(bucket)-1]
    if(bucket == []):
        return[[t1[0], t2[0]]]
    else:
        kiri = []
        kanan = []
        for i in range(len(bucket)):
            if(kiriOrKanan(t1, t2, bucket[i]) == 1):
                kanan += ([bucket[i]])
            if(kiriOrKanan(t1, t2, bucket[i]) == 0):
                kiri += ([bucket[i]])
        a = smallerConvexHull(kanan, t1, t2)
        b = smallerConvexHull(kiri, t1, t2)
        a += b
        return(a)


# convexhull jika sudah ada 2 titik maximal
def smallerConvexHull(bucket, t1, t2):
    if(bucket == []):
        return[[t1[0], t2[0]]]
    else:
        titikmax = [0, 0, 0]
        jarakmax = 0
        for i in range(len(bucket)):
            d = jarakTitikKeGaris(t1, t2, bucket[i])
            if(d > jarakmax):
                titikmax = bucket[i]
                jarakmax = d

        luar = []
        for i in range(len(bucket)):
            if(not dalemSegitiga(t1, t2, titikmax, bucket[i])):
                luar.append(bucket[i])

        kanan = []
        kiri = []
        for i in range(len(luar)):
            if(luar[i][1] < titikmax[1]):
                kiri.append(luar[i])
            else:
                kanan.append(luar[i])

        a = smallerConvexHull(kiri, t1, titikmax)
        b = smallerConvexHull(kanan, titikmax, t2)
        a += (b)
        return(a)
