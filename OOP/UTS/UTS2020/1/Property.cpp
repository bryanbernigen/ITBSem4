#include "Property.h"
#include <iostream>

// User-defined constructor: set nilai atribut berdasarkan nilai
// parameter masukan
Property::Property(string name, string type, int openYear) {
    this->name = name;
    this->type = type;
    this->openYear = openYear;
}
// Default constructor: set nilai atribut sbb:
// name = "noname"; openYear = 1900; type = "none"
Property::Property() {
    this->name = "noname";
    this->type = "none";
    this->openYear = 1900;
}
// Copy constructor
// TIDAK BUTUH
// Destructor
// TIDAK BUTUH
// Operator Assignment
// ... set_name(...)
void Property::set_name(string name) {
    this->name = name;
}
// ... get_name()
string Property::get_name() const {
    return this->name;
}
// ... set_type(...)
void Property::set_type(string type) {
    this->type = type;
}
// ... get_type()
string Property::get_type() const {
    return this->type;
}
// ... get_age(), asumsikan tahun saat ini dapat diakses dengan
// makro CURRENT_YEAR
int Property::get_age() const {
    return CURRENT_YEAR - this->openYear;
}
// ... displayInfo(): Mencetak nama, umur, type, dan rate Property
void Property::displayInfo() const {
    cout << "Nama: " << this->name << endl;
    cout << "Umur: " << this->get_age() << endl;
    cout << "Tipe: " << this->type << endl;
    cout << "Rate: " << this->rate() << endl;
}
// ... rate(): menghitung biaya property sesuai dengan umur dan
// tergantung type property
int Property::rate() const {
    int rate = 0;
    if (this->type == "hotel") {
        rate = this->get_age() * 100;
    } else if (this->type == "hostels") {
        rate = this->get_age() * 80;
    } else if (this->type == "villas") {
        rate = this->get_age() * 50;
    } else if (this->type == "cottages") {
        rate = this->get_age() * 30;
    }
    return rate;
}

Hotel::Hotel() : Property() {
    this->star = 0;
}
Hotel::Hotel(string name, int openYear, int star) : Property(name, "hotel", openYear) {
    this->star = star;
}
void Hotel::set_star(int star) {
    this->star = star;
}
int Hotel::get_star() const {
    return this->star;
}
void Hotel::displayInfo() const {
    Property::displayInfo();
    cout << "Total rate: " << this->rate() * this->star << endl;
}

Hostel::Hostel() : Property() {
    this->facility = 0;
}
Hostel::Hostel(string name, int openYear, int facility) : Property(name, "hostels", openYear) {
    this->facility = facility;
}
void Hostel::set_facility(int facility) {
    this->facility = facility;
}
int Hostel::get_facility() const {
    return this->facility;
}
int Hostel::calculateFacility() const {
    return this->facility * 80000;
}
void Hostel::displayInfo() const {
    Property::displayInfo();
    cout << "Expense: " << this->calculateFacility() << endl;
}
