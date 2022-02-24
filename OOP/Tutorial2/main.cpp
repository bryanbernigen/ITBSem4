#include "Vehicle.h"
#include "Car.h"
#include "Bike.h"

int main (){
    Car *c4 = new Car(4);
    Car *c10 = new Car(10);
    Bike *b2 = new Bike();
    Vehicle *v2 = new Vehicle(*b2);
    b2->~Bike();
    c10->Vehicle::drive();
    v2->clean();
    c4->drive();
    v2->park();
    c10->~Car();
    v2->~Vehicle();
    c4->~Car();
    return 0;
}