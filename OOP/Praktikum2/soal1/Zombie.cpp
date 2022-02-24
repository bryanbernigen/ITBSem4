#include "Zombie.hpp"
#include <iostream>

using namespace std;

Zombie::Zombie(int _stamina) : Undead(_stamina)
{
}

void Zombie::attack(Player &player)
{
    if (this->stamina == 0)
    {
        cout << "oof" << endl;
    }
    else
    {
        this->stamina -= 1;
        if (player.getHealth() == 0)
        {
            cout << "nom nom nom" << endl;
        }
        else
        {
            player.setHealth(max(player.getHealth() - 3, 0));
        }
    }
}
