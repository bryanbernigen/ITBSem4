// Class Hotel
// File: Hotel.h
#ifndef HOTEL_H
#define HOTEL_H

#define CURRENT_YEAR 2022

#include <string>
using namespace std;
class Hotel
{
protected:
    // Atribut
    string name;
    string bintang; // Melati; bintang_tiga; bintang_empat; bintang_lima
    int openYear;

public:
    // User-defined constructor: set nilai atribut berdasarkan nilai parameter masukan
    Hotel(string name, string bintang, int openYear);
    // Default constructor: set nilai atribut sbb:
    // name = "noname"; openYear = 1900; bintang = "none"
    Hotel();
    // Copy constructor
    // Tidak Perlu cctor

    // Destructor
    // Tidak Perlu dtor

    // Operator Assignment
    // Tidak Perlu operator=

    // ... set_name(...)
    void set_name(string name);
    // ... get_name()
    string get_name() const;
    // ... set_bintang(...)
    void set_bintang(string bintang);
    // ... get_bintang()
    string get_bintang() const;
    // ... get_age(), asumsikan tahun saat ini dapat diakses dengan dengan makro CURRENT_YEAR
    int get_age() const;
    // ... displayInfo(): Mencetak nama, umur hotel, bintang, dan room_rate
    virtual void displayInfo() const;
    // ... rate(): menghitung biaya menginap sesuai dengan umur dan tergantung bintang hotel
    int rate() const;
};

class bintang_empat : public Hotel
{
private:
    int star;

public:
    bintang_empat();
    bintang_empat(string name, string bintang, int openYear, int star);
    void set_star(int star);
    int get_star() const;
    void displayInfo() const;
};

class bintang_lima : public Hotel
{
private:
   int facility;
public:
    bintang_lima();
    bintang_lima(string name, string bintang, int openYear, int facility);
    void set_facility(int facility);
    int get_facility() const;
    int calculateFacility() const;
    void displayInfo() const;
};


#endif // HOTEL_H