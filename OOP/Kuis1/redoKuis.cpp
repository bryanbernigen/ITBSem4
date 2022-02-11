#include "redoKuis.hpp"

CWTime::CWTime()
{
    this->jam = 0;
    this->menit = 0;
    this->detik = 0;
    this->jenis_layanan = "automatic";
}

CWTime::CWTime(int h, int m, int s, string l)
{
    this->jam = h;
    this->menit = m;
    this->detik = s;
    this->jenis_layanan = l;
}

CWTime::CWTime(int m, string l)
{
    this->jam = m / 60;
    this->menit = m % 60;
    this->detik = 0;
    this->jenis_layanan = l;
}

CWTime::CWTime(const CWTime &t)
{
    this->jam = t.jam;
    this->menit = t.menit;
    this->detik = t.detik;
    this->jenis_layanan = t.jenis_layanan;
}

float CWTime::InMinutes() const
{
    float temp = this->jam * 60 + this->menit + this->detik / 60;
    return temp;
}

CWTime CWTime::operator+(int m)
{
    this->jam += m / 60;
    this->menit += m % 60;
}

CWTime &CWTime::operator++()
{
    this->menit++;
    return *this;
}

void CWTime::Print() const
{
    printf("%.2d:%.2d:%.2d, %s", this->jam, this->menit, this->detik, this->jenis_layanan);
}

string CWTime::get_service()
{
    return this->jenis_layanan;
}

CarWash::CarWash()
{
    this->max = 100;
    this->urutan = new CWTime[this->max];
    this->tail = -99;
}

CarWash::CarWash(int _size)
{
    this->max = _size;
    this->urutan = new CWTime[this->max];
    this->tail = -99;
}

CarWash::CarWash(const CarWash &C)
{
    int i;
    this->max = C.max;
    this->urutan = new CWTime[this->max];
    this->tail = C.tail;
    for (size_t i = 0; i < this->tail; i++)
    {
        this->urutan[i] = C.urutan[i];
    }
}

CarWash::~CarWash()
{
    delete this->urutan;
}

CarWash &CarWash::operator<<(const CWTime &Ct)
{
    this->urutan[this->tail] = Ct;
    this->tail++;
    return *this;
}

void CarWash::operator>>(CWTime &Ct)
{
    int i;
    Ct = this->urutan[0];
    this->tail--;
    for ( i = 0; i < this->tail; i++)
    {
        this->urutan[i]=this->urutan[i+1];
    }
}

long CarWash:: BiayaCuci(CWTime &Ct){
    long temp;
    temp = 2000 * Ct.InMinutes();
    if (Ct.get_service() == "automatic" )
    {
        temp+=20000;
    }
    else{
        temp+=50000;
    }
}   