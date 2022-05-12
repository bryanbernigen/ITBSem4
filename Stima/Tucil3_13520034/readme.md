1) Deskripsi Singkat:
Ini adalah program untuk menyelesaikan persoalan fifteen puzzle menggunakan cara branch and bound
Heuristik (sesuai spek) yang dipakai untuk menghitung cost sebuah simpul adalah jumlah dari:
    1. Kedalaman Simpul tersebut
    2. Jumlah tiles yang tidak sesuai lokasi
---------------------------------------DISCLAIMER!!!------------------------------------------
Seluruh Puzzle yang tidak diberi pesan kesalahan "tidak dapat diselesaikan" dapat diselesaikan
oleh program ini, namun waktu untuk menyelesaikannya tidak dijamin cepat terutama untuk puzzle
yang memerlukan lebih dari 30 langkah untuk penyelesaiannya. Jika ingin menyelesaikan puzzle
dengan lebih cepat, maka heuristik harus diganti dengan herusitik lain seperti manhattan cost
---------------------------------------DISCLAIMER!!!------------------------------------------

2) Requerement untuk menjalankan Program:
    1. Python (author menggunakan Python 3.10.2)
    2. Pip (author menggunkan pip 22.0.3)
    3. Tkinter (install dengan commnad: "pip install tkinter")
    No 2 dan 3 Diperlukan jika ingin menjalankan gui.py

3) Cara menggunakan program:
    1. Download program dan unzip program
    2. Buka folder test dan masukkan puzzle yang akan diselesaikan dengan format:
        4 baris x 4 kolom
        lokasi kosong diganti dengan tanda "-"
    3. buka folder src pada terminal
    4.1. Jika ingin menggunakan CLI, jalankan program dengan cara:
        ```
        python main.py
        ```
    4.2. Jika ingin menggunakan GUI, maka jalanakan dengan cara:
        ```
        python gui.py
        ```
    5. masukkan nama file yang ada di folder test dan berisi puzzle yang akan di selesaikan
    6. pencel solve pada GUI atau enter pada CLI
    7. Silahkan tunggu sampai hasil ditemukan ^_^

4) Author:
    NIM:    13520034
    Nama:   Bryan Bernigen