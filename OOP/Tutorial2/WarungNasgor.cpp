#include "WarungNasgor.hpp"
#include "WarungNasi.hpp"

WarungNasgor::WarungNasgor(int uang, int nasi, int telur, int kecap) : WarungNasi(uang, nasi, telur)
{
    this->kecap = kecap;
}

bool WarungNasgor::masak(int pesanan)
{
    if (getNasi() < pesanan || getTelur() < pesanan || this->kecap < pesanan)
    {
        return false;
    }
    else
    {
        setNasi(getNasi() - pesanan);
        setTelur(getTelur() - pesanan);
        this->kecap = this->kecap - pesanan;
        setUang(getUang() + 15000 * pesanan);
        return true;
    }
}
