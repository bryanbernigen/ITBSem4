#include "WarungSaltedEgg.hpp"
#include "WarungNasi.hpp"

WarungSaltedEgg::WarungSaltedEgg(int uang, int nasi, int telur, int telurAsin, int ayam): WarungNasi(uang, nasi, telur)
{
    this->telurAsin = telurAsin;
    this->ayam = ayam;
}

bool WarungSaltedEgg::masak(int pesanan){
    if(getNasi()<pesanan || getTelur()<pesanan|| 3*this->telurAsin<pesanan || this->ayam<pesanan){
        return false;
    }
    else{
        setNasi(getNasi() - pesanan);
        setTelur(getTelur() - pesanan);
        this->telurAsin = this->telurAsin-3*pesanan;
        this->ayam = this->ayam-pesanan;
        setUang(getUang()+30000*pesanan);
    }
}