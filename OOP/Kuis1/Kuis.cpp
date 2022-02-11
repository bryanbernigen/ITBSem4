#include "Kuis.hpp"
#include <string.h>

CWTime::CWTime(){
    this->jam =0;
    this->menit=0;
    this->detik=0;
    this->lama=0;
    this->jenis_layanan = 'a';
}

CWTime::CWTime(int h, int m, int s, char l){
    this->jam =h;
    this->menit=m;
    this->detik=s;
    this->lama = h*3600 + m*60 + s;
    this->jenis_layanan = l;
};

CWTime::CWTime(int m, char l){
    this->jam =0;
    this->menit=m;
    this->detik=0;
    this->lama = m*60;
    this->jenis_layanan = l;
}

CWTime::CWTime(const CWTime &t){
    this->jam =t.jam;
    this->menit=t.menit;
    this->detik=t.detik;
    this->lama = t.lama;
    this->jenis_layanan = t.jenis_layanan;
}


CWTime::~CWTime(){}

float CWTime::InMinutes()const{
    float temp = (float)this->lama;
    return(temp/60);
}

CWTime CWTime::operator+(int m){
    int temp;
    temp = m/60;
    this->jam += temp;
    this->menit+=m-temp*60;
    this->lama += m*60;
}  

void CWTime::Print() const{
    cout<< this->jam<<":"<<this->menit<<":"<<this->detik<<endl;
    if(this->jenis_layanan=='a'){
        cout<<"automatic"<<endl;
    }
    else{
        cout<<"handwash"<<endl;
    }
}

char CWTime::get_service(){
    return this->jenis_layanan;
}



CarWash::CarWash(){
    this->urutan = new CWTime[100];
    this->urutan_terakhir=-99;
    this->max_urutan =100;
}

CarWash::CarWash(int _size){
    this->urutan = new CWTime[_size];
    this->urutan_terakhir=-99;
    this->max_urutan=_size;
} 

CarWash::CarWash(const CarWash &C){
    int i;
    this->max_urutan = C.max_urutan;
    this->urutan_terakhir =C.urutan_terakhir;
    this->urutan = new CWTime[this->max_urutan];
    for ( i = 0; i < C.urutan_terakhir; i++)
    {
        this->urutan[i]=C.urutan[i];
    }
    
}

CarWash::~CarWash(){
    delete this->urutan;
}

CarWash CarWash::operator<<(const CWTime &Ct){
    this->urutan[this->urutan_terakhir] = Ct;
    this->urutan_terakhir++;
}

void CarWash::operator>>(CWTime &Ct){
    int i;
    Ct = this->urutan[0];
    for (i = 0; i < this->urutan_terakhir-1; i++)
    {
        this->urutan[i] = this->urutan[i+1];
    }
    this->urutan_terakhir--;
    
};

long CarWash::BiayaCuci(CWTime &Ct){
    long jumlah=0;
    float time=0;
    char temp;
    temp = Ct.get_service();
    if(temp=='a'){
        jumlah+=20000;
    }
    else{
        jumlah+=50000;
    }
    time = Ct.InMinutes();
    jumlah+= time*20000;
}