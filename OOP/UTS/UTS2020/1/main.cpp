#include "Property.h"
#include <iostream>
using namespace std;
int main() {
    Property *hilton = new Hotel("Hotel Hilton", 2000, 5);
    Property *vio = new Hostel("Hostel Vio", 2003, 5);
    // cetak semua property dan informasi semua property
    // [gunakan Property::displayInfo()]
    hilton->displayInfo();
    vio->displayInfo();
    delete hilton;
    delete vio;
}