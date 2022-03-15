#include "Hotel.cpp"
#include <iostream>
using namespace std;
int main()
{
    bintang_empat aston = bintang_empat("Hotel Aston","bintang_empat", 2010, 5);
    bintang_lima padma = bintang_lima("Hotel Padma","bintang_lima", 2000, 100);
    // cetak semua hotel dan informasi semua hotel
    // [gunakan Hotel::displayInfo()]
    aston.Hotel::displayInfo();
    padma.Hotel::displayInfo();
}