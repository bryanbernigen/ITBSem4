#ifndef CWTime_H
#define CWTime_H

#include <iostream>
#include <string>
using namespace std;

class CWTime{
    private:/* isi atribut di sini: */
        int hour;
        int minute;
        int second;
        string layanan;

    public:
        CWTime(); /*ctor: membuat CWTimesebesar 0 detik*/
        CWTime(int h, int m, int s, string l);/* ctor: membuat CWTimesebesar h jam+m menit+s detik, untuk layanan l*/
        CWTime(int m, string l);/* ctor: membuat CWTime sebesar m menit, untuk layanan l*/
        CWTime(const CWTime& t);/*cctor*/
        ~CWTime();/*dtor*/
        CWTime& operator=(const CWTime& Ct);/*operator assignment*/
        float InMinutes()const; /*CWTimedalam satuan menit, misal:CWTime(2,3,15, “automatic”).InMinutes() = 123.15*/
        CWTime operator+(int m);/*Menambahkanm menitke CWTime*/
        friend CWTime operator+(int m, CWTime Ct); /*Menghasilkan CWTime Ctditambah m menit. */
        CWTime& operator++();/*Menambahkan1 menitke CWTime*/
        void Print()const;/*Mencetak CWTimedalam format HH:MM:SSserta jenis layanan*/
        string get_service();
    };
class CarWash{
    private:/* isi atribut di sini: */
        CWTime* antrian;
        int size;
        int tail;
    public:
        CarWash();  /*ctor: size diset 100; tail diset -99. Alokasi arraysebesar size.*/
        CarWash(int _size); /*ctor: size diset _size; tail diset -99. Alokasi arraysebesar size.*/
        CarWash(const CarWash& C); /*cctor*/
        ~CarWash();  /*dtor*/
        CarWash& operator=(const CarWash& C); /*operator assignment*/
        CarWash&operator<<(const CWTime&Ct);/*Menambahkan Ctpada tail. Asumsi car washtidak penuh.*/
        void operator>>(CWTime& Ct); /*Menghapus elemen di head dan menyimpannya di Ct, dan menggeser sisanya (head selalu= 0).
                                        Asumsi: CarWashtidak kosong, minimum 1elemen*/
        long BiayaCuci(CWTime& Ct);  /*menghitung dan menghasilkan biaya cuci mobil sesuai jenis layanan*/
    };
#endif