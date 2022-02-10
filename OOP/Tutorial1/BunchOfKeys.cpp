#include "BunchOfKeys.hpp"

BunchOfKeys::BunchOfKeys()
{
    this->n_keys = 0;
}

void BunchOfKeys::add()
{
    this->n_keys++;
}

void BunchOfKeys::shake()
{
    int i;
    if (this->n_keys <= 1)
    {
        cout << "Tidak terjadi apa-apa" << endl;
    }
    else
    {
        for (i = 0; i < this->n_keys; i++)
        {
            cout << "krincing" << endl;
        }
    }
}