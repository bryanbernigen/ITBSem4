#include "reference.hpp"

CWTime::CWTime(){
    this->hour = 0;
    this->minute = 0;
    this->second = 0;
    this->layanan = "handwash"; //default handwash
}

CWTime::CWTime(int h, int m, int s, string l){
    this->hour = h;
    this->minute = m;
    this->second = s;
    this->layanan = l;
}

CWTime::CWTime(int m, string l){
    this->hour = m/60;
    this->minute = m%60;
    this->second = 0;
    this->layanan = l;
}

CWTime::CWTime(const CWTime& t){
    this->hour = t.hour;
    this->minute = t.minute;
    this->second = t.second;
    this->layanan = t.layanan;
}

CWTime::~CWTime(){};

CWTime& CWTime::operator=(const CWTime& Ct){
    CWTime hasil(Ct.hour,Ct.minute,Ct.second, Ct.layanan);
    return hasil;
}

float CWTime::InMinutes()const{
    float res =this->hour*60 + this->minute + (this->second/60);
    return res;
}

CWTime CWTime::operator+(int m){
    CWTime hasil(this->hour + (m/60),this->minute + (m%60),this->second,this->layanan);
    return hasil;
}

CWTime operator+(int m, CWTime Ct){
    Ct.hour = Ct.hour + (m/60);
    Ct.minute = Ct.minute + (m%60);
    return Ct;
}

CWTime& CWTime::operator++(){
    CWTime ret(this->hour, this->minute,this->second, this->layanan);
    int over = 0;
    if(ret.minute = 59){
        over = 0;
        ret.minute = 0;
        ret.hour++;
    }
    else{
        ret.minute++;
    }
    return ret;

}

void CWTime::Print()const{
    printf("%2d:%2d%2d ", this->hour, this->minute, this->second);
    cout << this->layanan << endl;
}

string CWTime::get_service(){
    return this->layanan;
}

CarWash::CarWash(){
    this->size = 100;
    this->tail = -99;
    this->antrian = new CWTime[100];
}

CarWash::CarWash(int _size){
    this->size = _size;
    this->tail = -99;
    this->antrian = new CWTime[_size];
}

CarWash::CarWash(const CarWash& C){
    this->size = C.size;
    this->tail = C.tail;
    this->antrian = new CWTime[this->size];
    for (int i = 0; i<tail ; i++){
        this->antrian[i] = C.antrian[i];
    }
}

CarWash::~CarWash(){
    delete[] antrian;
}

CarWash& CarWash::operator=(const CarWash& C){
    CarWash CW(C);
    return CW;
}

CarWash& CarWash::operator<<(const CWTime&Ct){
    CarWash CW(this->size);
    CW.tail = this->tail;
    for(int i= 0; i < this->tail; i++){
        CW.antrian[i] = this->antrian[i];
    }
    if(CW.tail == -99){
        CW.antrian[0] = Ct;
    }
    else{
        CW.antrian[CW.tail] = Ct;
    }
    return CW;
}

void CarWash::operator>>(CWTime& Ct){
    Ct = this->antrian[0];
    for(int i = 0; i<this->tail-1;i++){
        this->antrian[i] = this->antrian[i+1];
    }
    this->tail--;
}

 long CarWash::BiayaCuci(CWTime& Ct){
     long biaya = 0;
     if (Ct.get_service() == "automatic"){
         biaya = 20000;
     }
     else {biaya = 50000;}
     biaya += Ct.InMinutes() * 2000;
     return biaya;
 }