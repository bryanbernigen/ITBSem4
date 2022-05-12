# DISCLAIMER!!!!
# Semua Puzzle yang bernilai Genap dapat diselesaikan dengan 
# Heuristik sesuai Spek, Namun tidak semua dapat diselesaikan
# Dengan cukup cepat sehingga jika puzzle kompleks (>30an langkah)
# Maka ada kemungkinan python akan mengalami error timeout sebelum hasil ditemukan

import queue
from fifteen_puzzle import *
from queue import PriorityQueue
from PriotizedItem import PrioritizedItem


nama_file = input("Masukkan nama file yang ada di Folder Test: ")
print("==================")
array = openFile(nama_file)
#===========================================
#Solve 15 Puzzle
puzzle = fifteen_puzzle(array, True, True, True, True)
if(not puzzle.solveable()):
    print("Puzzle tidak bisa di selesaikan")
    print("karena puzzle bernilai ganjil yakni: ",puzzle.hitungan_awal()+puzzle.arsir_atau_tidak())
    print("==================")
    puzzle.print_puzzle()
    print("==================")
    
else:
    #inisialisasi variabel
    selesai = False
    id_dikerjakan = 0
    queue = PriorityQueue()
    urutan_pengerjaan = []
    hasil_print = []
    puzzle.salah_posisi()
    puzzle_awal = puzzle
    hashmap = {}

    #memasukkan akar ke queue
    print("Searching.......")
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
    print("Total Pengecekan: ",id_dikerjakan-1)
    while(not queue.empty()):
        queue.get()
        id_dikerjakan+=1
    print("Total Pembangkitan: ",id_dikerjakan-1)

    # Mnecari dan Mencetak Path yang menghasilkan tujuan
    while(puzzle.id_parent != 0):
        hasil_print.append(puzzle)
        puzzle = urutan_pengerjaan[puzzle.id_parent-1]
    hasil_print.append(puzzle_awal)
    print("Puzzle diselesaikan dalam:",end=" ")
    print(len(hasil_print)-1,"langkah")
    print("Puzzle diselesaikan dalam:",end=" ")
    print("%.10s detik" % (stop_time - start_time))
    print("==================")
    for i in range (len(hasil_print)-1,-1,-1):
        hasil_print[i].print_puzzle()
        print("Command: ",end="")
        if(not hasil_print[i-1].up):
            print("Down")
        elif(not hasil_print[i-1].down):
            print("Up")
        elif(not hasil_print[i-1].left):
            print("Right")
        elif(not hasil_print[i-1].right):
            print("Left")
        else:
            print("-")
        print("==================")