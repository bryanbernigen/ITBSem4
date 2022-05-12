from operator import mod
from queue import PriorityQueue
from PriotizedItem import PrioritizedItem
import time
import os

class fifteen_puzzle:
    def __init__(self, list, up, down, left, right):
        self.list = list
        self.up = up
        self.down = down
        self.left = left
        self.right = right
        self.lokasi_kosong = 0
        self.nilai = 0
        self.kedalaman = 0
        self.id_parent = 0
    
    #Hitung total i yang lokasinya salah
    def hitungan_awal(self):
        hitunngan_awal = 0
        #iterasi untuk mencari posisi yang salah dari nilai 1 - 16
        for i in range (16):
            #cari posisi nilai ke-i di list
            for j in range (16):
                if(self.list[j] == i+1):
                    break

            #hitung banyaknya nilai k yang lebih kecil dari i tapi posisi lebih besar dari i
            for k in range(16-j-1):
                if(self.list[k+j+1] < i+1):
                    hitunngan_awal += 1
        return hitunngan_awal
    
    #Hitung apakah nilai kosong(nilai ke-16) ada di lokasi kosong
    def arsir_atau_tidak(self):
        for i in range (16):
            if(self.list[i] == 16):
                break
        i = mod(i,8)
        if(i==1 or i==3 or i==4 or i==6):
            return 1
        return 0

    #Menyatakan apakah puzzle bisa di selesaikan atau tidak
    def solveable(self):
        nilai = self.hitungan_awal() + self.arsir_atau_tidak()
        if(mod(nilai,2)==0):
            return True
        return False

    def salah_posisi(self):
        salah=0
        for i in range (16):
            if(self.list[i] != i+1):
                salah+=1
            if(self.list[i]==16):
                self.lokasi_kosong = i
        return salah
    
    #Menggerakan puzzle
    def move(self,queue,id_parent, hashmap):
        if(self.salah_posisi()==0):
            print("Puzzle berhasil diselesaikan!!")
            return False
        if(self.up):
            if(self.lokasi_kosong>3):
                self.moveup(queue,id_parent,hashmap)
        if(self.down):
            if(self.lokasi_kosong<12):
                self.movedown(queue,id_parent,hashmap)
        if(self.left):
            if(self.lokasi_kosong%4!=0):
                self.moveleft(queue,id_parent,hashmap)
        if(self.right):
            if(self.lokasi_kosong%4!=3):
                self.moveright(queue,id_parent,hashmap)
        return True

    #Menggerakan puzzle ke atas
    def moveup(self,queue,id_parent,hashmap):
        list = self.list[:]
        list[self.lokasi_kosong], list[self.lokasi_kosong-4] = list[self.lokasi_kosong-4], list[self.lokasi_kosong]
        list = fifteen_puzzle(list, False, True, True, True)
        list.kedalaman=self.kedalaman+1
        cek_hash, key = list.in_hashmap(hashmap)
        if(cek_hash):
            return
        else:  
            list.nilai+=list.kedalaman + list.salah_posisi()
            list.id_parent = id_parent
            queue.put(PrioritizedItem(list.nilai, list))
            hashmap[key] = True

    #Menggerakan puzzle ke bawah
    def movedown(self,queue,id_parent,hashmap):
        list = self.list[:]
        list[self.lokasi_kosong], list[self.lokasi_kosong+4] = list[self.lokasi_kosong+4], list[self.lokasi_kosong]
        list = fifteen_puzzle(list, False, True, True, True)
        cek_hash, key = list.in_hashmap(hashmap)
        if(cek_hash):
            return
        else:
            list.kedalaman=self.kedalaman+1
            list.nilai+=list.kedalaman + list.salah_posisi()
            list.id_parent = id_parent
            queue.put(PrioritizedItem(list.nilai, list))
            hashmap[key] = True
    
    #Menggerakan puzzle ke kiri
    def moveleft(self,queue,id_parent,hashmap):
        list = self.list[:]
        list[self.lokasi_kosong], list[self.lokasi_kosong-1] = list[self.lokasi_kosong-1], list[self.lokasi_kosong]
        list = fifteen_puzzle(list, True, True, True, False)
        cek_hash, key = list.in_hashmap(hashmap)
        if(cek_hash):
            return
        else:     
            list.kedalaman=self.kedalaman+1
            list.nilai+=list.kedalaman+list.salah_posisi()
            list.id_parent = id_parent
            queue.put(PrioritizedItem(list.nilai, list))
            hashmap[key] = True
    
    #Menggerakan puzzle ke kanan
    def moveright(self,queue,id_parent,hashmap):
        list = self.list[:]
        list[self.lokasi_kosong], list[self.lokasi_kosong+1] = list[self.lokasi_kosong+1], list[self.lokasi_kosong]
        list = fifteen_puzzle(list, True, True, False, True)
        cek_hash, key = list.in_hashmap(hashmap)
        if(cek_hash):
            return
        else: 
            list.kedalaman=self.kedalaman+1
            list.nilai+=list.kedalaman+list.salah_posisi()
            list.id_parent = id_parent
            queue.put(PrioritizedItem(list.nilai, list))
            hashmap[key] = True        
    
    #Mengecek sate puzzle dalam hash table
    def in_hashmap(self,hash_table):
        key=''
        for i in range(16):
            key+=str(self.list[i])+'-'
        if(key in hash_table):
            return True,"-"
        else:
            return False,key

    #Print Puzzle
    def print_puzzle(self):
        for i in range (4):
            print("   ",end="")
            for j in range (4):
                if(self.list[i*4+j] == 16):
                    print("  ", end=" ")
                else:
                    print("%2d" % self.list[i*4+j], end=" ")    
            print("")
        
#Fungsi Tambahan Untuk GUI
#Baca data dari file
def openFile(nama_file):
    curr_dir = os.path.dirname(os.path.abspath(__file__))
    try:
        f = open(curr_dir+"/../test/"+nama_file, "r")
    except:
        print("File tidak ditemukan")
        exit()
    array=[]
    for x in f:
        x = x.split(' ')
        array.append((x[0]))
        array.append((x[1]))
        array.append((x[2]))
        array.append((x[3]))
    for i in range(16):
        if array[i]=='-':
            array[i]=16
        else:
            array[i]=int(array[i])        
    f.close()
    return array

def solve(array):
    #inisialisasi variabel
    puzzle = fifteen_puzzle(array,True,True,True,True);
    selesai = False
    id_dikerjakan = 0
    queue = PriorityQueue()
    urutan_pengerjaan = []
    hasil_print = []
    puzzle.salah_posisi()
    puzzle_awal = puzzle
    hashmap = {}

    if(not puzzle.solveable()):
        return []

    #memasukkan akar ke queue
    start_time = time.time()
    queue.put(PrioritizedItem(puzzle.nilai, puzzle))
    while(not queue.empty() and not selesai):
        puzzle = queue.get().item
        urutan_pengerjaan.append(puzzle)
        id_dikerjakan += 1;
        if(not puzzle.move(queue, id_dikerjakan,hashmap)):
            stop_time = time.time()
            break
  
    #Menampilkan Hasil
    while(not queue.empty()):
        queue.get()
        id_dikerjakan+=1

    # Mnecari dan Mencetak Path yang menghasilkan tujuan
    hasil_print.append(puzzle_awal)
    while(puzzle.id_parent != 0):
        hasil_print.append(puzzle)
        puzzle = urutan_pengerjaan[puzzle.id_parent-1]
    return hasil_print