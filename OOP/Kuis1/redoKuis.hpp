#ifndef CWTime_H
#define CWTime_H

#include <string>
using namespace std;

class CWTime
{
private:
    /* isi atribut di sini: */
    int jam;
    int menit;
    int detik;
    string jenis_layanan;
public:
    CWTime();                                  /* ctor: membuat CWTime sebesar 0 detik */
    CWTime(int h, int m, int s, string l);     /* ctor: membuat CWTime sebesar h jam + m menit + s detik,
        untuk layanan l */
    CWTime(int m, string l);                   /* ctor: membuat CWTime sebesar m menit, untuk layanan l */
    CWTime(const CWTime &t);                   /* cctor */
    //~CWTime();                                 /* dtor */
    //CWTime &operator=(const CWTime &Ct);       /* operator assignment */
    float InMinutes() const;                   /* CWTime dalam satuan menit, misal:
                      CWTime(2,3,15, “automatic”).InMinutes() = 123.15 */
    CWTime operator+(int m);                   /* Menambahkan m menit ke CWTime */
    //friend CWTime operator+(int m, CWTime Ct); /* Menghasilkan CWTime Ct ditambah m menit. */
    CWTime &operator++();                      /* Menambahkan 1 menit ke CWTime */
    void Print() const;                        /* Mencetak CWTime dalam format HH:MM:SS serta jenis layanan*/
    string get_service();
};
class CarWash
{
private:
    /* isi atribut di sini: */
    CWTime *urutan;
    int tail;
    int max;
public:
    CarWash();                             /* ctor: size diset 100; tail diset -99. Alokasi array sebesar size. */
    CarWash(int _size);                    /* ctor: size diset _size; tail diset -99. Alokasi array sebesar size.
                                            */
    CarWash(const CarWash &C);             /* cctor */
    ~CarWash();                            /* dtor */
    //CarWash &operator=(const CarWash &C);  /* operator assignment */
    CarWash &operator<<(const CWTime &Ct); /* Menambahkan Ct pada tail. Asumsi car wash tidak penuh. */
    void operator>>(CWTime &Ct);           /* Menghapus elemen di head dan menyimpannya di Ct, dan menggeser
              sisanya (head selalu = 0). Asumsi: CarWash tidak kosong,
              minimum 1 elemen */
    long BiayaCuci(CWTime &Ct);            /*menghitung dan menghasilkan biaya cuci mobil sesuai jenis layanan*/
};
#endif