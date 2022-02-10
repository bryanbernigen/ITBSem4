#include "SpacingGuildShip.hpp"

float SpacingGuildShip::totalGuildTravel = 0;
int SpacingGuildShip::producedShips = 0;

SpacingGuildShip::SpacingGuildShip() : maxPassengerCap(50), guildNavigatorCount(3), serialNum(producedShips + 1)
{
    this->passengerCount = 0;
    this->operatingGuildNavigator = 3;
    this->spiceStock = 50;
    producedShips++;
}

SpacingGuildShip::SpacingGuildShip(int maxPassengerCap, int guildNavigatorCount, int spiceStock) : maxPassengerCap(maxPassengerCap), guildNavigatorCount(guildNavigatorCount), serialNum(producedShips + 1)
{
    this->passengerCount = 0;
    this->operatingGuildNavigator = guildNavigatorCount;
    this->spiceStock = spiceStock;
    producedShips++;
}

SpacingGuildShip::SpacingGuildShip(const SpacingGuildShip &other) : maxPassengerCap(other.maxPassengerCap), guildNavigatorCount(other.guildNavigatorCount), serialNum(producedShips + 1)
{
    this->passengerCount = other.passengerCount;
    this->operatingGuildNavigator = other.operatingGuildNavigator;
    this->spiceStock = other.spiceStock;
    producedShips++;
}

SpacingGuildShip::~SpacingGuildShip()
{
}

int SpacingGuildShip::getShipSerialNum() const
{
    return this->serialNum;
}

int SpacingGuildShip::getPassengerCount() const
{
    return this->passengerCount;
}

void SpacingGuildShip::travel(float distance)
{
    if (this->operatingGuildNavigator != 0)
    {
        totalGuildTravel += distance / (E * E * this->operatingGuildNavigator);
        this->operatingGuildNavigator--;
    }
}

void SpacingGuildShip::boarding(int addedPassengers)
{
    this->passengerCount += addedPassengers;
    if (this->passengerCount > this->maxPassengerCap)
    {
        this->passengerCount = this->maxPassengerCap;
    }
}

void SpacingGuildShip::dropOff(int droppedPassengers)
{
    this->passengerCount -= droppedPassengers;
    if (this->passengerCount < 0)
    {
        this->passengerCount = 0;
    }
}

void SpacingGuildShip::refreshNavigator(int n)
{
    int reviveable = this->guildNavigatorCount - this->operatingGuildNavigator;
    int spice_terpakai;
    if (n > reviveable)
    {
        n = reviveable;
    }
    spice_terpakai = n * GUILD_NAVIGATOR_SPICE_DOSE;
    while (spice_terpakai > this->spiceStock)
    {
        n--;
        spice_terpakai -= GUILD_NAVIGATOR_SPICE_DOSE;
    }
    this->spiceStock -= spice_terpakai;
    this->operatingGuildNavigator += n;
}

void SpacingGuildShip::transitToArrakis(int addedSpice)
{
    this->spiceStock += addedSpice;
}