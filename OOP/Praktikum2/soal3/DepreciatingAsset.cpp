#include "DepreciatingAsset.hpp"
#include "math.h"

double DepreciatingAsset::getValue(int years)
{
    return (this->x->getValue(years) * pow((1 - this->rate), years));
}