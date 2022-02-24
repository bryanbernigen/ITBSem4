#include "Hero.hpp"
#include "Mage.hpp"
#include "Warrior.hpp"
#include "MagicWarrior.hpp"

MagicWarrior::MagicWarrior(std::string name):Hero(name){

}

void MagicWarrior::attack(Hero* h){
    h->setHealth(h->getHealth()-this->getPower());
}

void MagicWarrior::heal(Hero* h){
    h->setHealth(h->getHealth()+(this->getPower()/2));
}

void MagicWarrior:: magicAttack(Hero* h){
    h->setHealth(h->getHealth()/2);
}

void MagicWarrior::powerUp(){
    this->setPower(this->getPower()*2);
}