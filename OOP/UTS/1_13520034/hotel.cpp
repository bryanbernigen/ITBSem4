#include "hotel.h"
#include <iostream>

// User-defined constructor: set nilai atribut berdasarkan nilai parameter masukan
Hotel::Hotel(string name, string bintang, int openYear)
{
    this->name = name;
    this->bintang = bintang;
    this->openYear = openYear;
}

// Default constructor: set nilai atribut sbb:
// name = "noname"; openYear = 1900; bintang = "none"
Hotel::Hotel()
{
    this->name = "noname";
    this->bintang = "none";
    this->openYear = 1900;
}

// ... set_name(...)
void Hotel::set_name(string name)
{
    this->name = name;
}
// ... get_name()
string Hotel::get_name() const
{
    return this->name;
}
// ... set_type(...)
void Hotel::set_bintang(string type)
{
    this->bintang = type;
}
// ... get_type()
string Hotel::get_bintang() const
{
    return this->bintang;
}

// ... get_age(), asumsikan tahun saat ini dapat diakses dengan dengan makro CURRENT_YEAR
int Hotel::get_age() const
{
    return CURRENT_YEAR - this->openYear;
}
// ... displayInfo(): Mencetak nama, umur, type, dan rate Hotel
void Hotel::displayInfo() const
{
    cout << "Nama       : " << this->name << endl;
    cout << "Umur       : " << this->get_age() << endl;
    cout << "Bintang    : " << this->bintang << endl;
    cout << "Rate       : " << this->rate() << endl;
}

// ... rate(): menghitung biaya Hotel sesuai dengan umur dan tergantung type Hotel
int Hotel::rate() const
{
    int rate = 0;
    if (this->bintang == "Melati")
    {
        rate = this->get_age() * 50;
    }
    else if (this->bintang == "bintang_tiga")
    {
        rate = this->get_age() * 100;
    }
    else if (this->bintang == "bintang_empat")
    {
        rate = this->get_age() * 200;
    }
    else if (this->bintang == "bintang_lima")
    {
        rate = this->get_age() * 400;
    }
    return rate;
}





bintang_empat::bintang_empat() : Hotel() {
    this->star = 0;
}
bintang_empat::bintang_empat(string name,string bintang, int openYear, int star) : Hotel(name, bintang, openYear) {
    this->star = star;
}
void bintang_empat::set_star(int star) {
    this->star = star;
}
int bintang_empat::get_star() const {
    return this->star;
}
void bintang_empat::displayInfo() const {
    Hotel::displayInfo();
    cout << "Total rate : " << this->rate() * this->star << endl;
}






bintang_lima::bintang_lima() : Hotel() {
    this->facility = 0;
}
bintang_lima::bintang_lima(string name, string bintang, int openYear, int facility) : Hotel(name, bintang, openYear) {
    this->facility = facility;
}
void bintang_lima::set_facility(int facility) {
    this->facility = facility;
}
int bintang_lima::get_facility() const {
    return this->facility;
}
int bintang_lima::calculateFacility() const {
    return this->facility * 100000;
}
void bintang_lima::displayInfo() const {
    Hotel::displayInfo();
    cout << "Expense    : " << this->calculateFacility() << endl;
}