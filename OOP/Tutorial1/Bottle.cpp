#include "Bottle.hpp"

int Bottle::numOfBottle = 0;

Bottle::Bottle() : id(numOfBottle + 1)
{
    this->waterHeight = 0.0;
    this->height = 10.00;
    this->radius = 10.00;
    numOfBottle++;
}

Bottle::Bottle(float height, float radius) : id(numOfBottle + 1)
{
    this->waterHeight = 0.0;
    this->height = height;
    this->radius = radius;
    numOfBottle++;
}

Bottle::Bottle(const Bottle &bottle) : id(bottle.getId())
{
    this->waterHeight = bottle.waterHeight;
    this->height = bottle.height;
    this->radius = bottle.radius;
}

Bottle::~Bottle()
{
}

int Bottle::getId() const
{
    return this->id;
}

float Bottle::getWaterVolume() const
{
    return PI * radius * radius * waterHeight;
}

float Bottle::getBottleVolume() const
{
    return PI * radius * radius * height;
}

void Bottle::setHeight(float height)
{
    this->height = height;
    if (this->height < this->waterHeight)
    {
        this->waterHeight = this->height;
    }
}

void Bottle::addWater(float waterVolume)
{
    float air_sekarang = this->getWaterVolume();
    air_sekarang += waterVolume;
    this->waterHeight = this->getWaterHeightIfVolume(air_sekarang);
    if (this->waterHeight > this->height)
    {
        this->waterHeight = this->height;
    }
}

void Bottle::substractWater(float waterVolume)
{
    float air_sekarang = this->getWaterVolume();
    air_sekarang -= waterVolume;
    if (air_sekarang <= 0)
    {
        this->waterHeight = 0;
    }
    else
    {
        this->waterHeight = this->getWaterHeightIfVolume(air_sekarang);
    }
}

float Bottle::getWaterHeightIfVolume(float waterVolume) const
{
    return waterVolume / (PI * radius * radius);
}

void Bottle::pourWaterTo(Bottle &other)
{
    float volume_kosong = other.getBottleVolume() - other.getWaterVolume();
    float air = this->getWaterVolume();
    if (volume_kosong < air)
    {
        other.addWater(volume_kosong);
        this->substractWater(volume_kosong);
    }
    else
    {
        other.addWater(air);
        this->substractWater(air);
    }
}