#include "Tool.hpp"
#include "Pickaxe.hpp"
#include "ReinforcedAxe.hpp"

int main(){
    Pickaxe *p = new Pickaxe();
    p->use();
    p->enchant();
    Pickaxe *p2 = new Pickaxe(*p);
    Pickaxe *p3 = new Pickaxe();
    *p3 = *p2;
    ReinforcedAxe *ra = new ReinforcedAxe();
    ra->use();
    ReinforcedAxe *ra2 = new ReinforcedAxe(*ra);
    ra->enchant();
    ReinforcedAxe *ra3 = new ReinforcedAxe(*ra + *ra2);
    ra3->repair();
    ra->~ReinforcedAxe();
    ra2->~ReinforcedAxe();
    ra3->~ReinforcedAxe();
    p->~Pickaxe();
    p2->~Pickaxe();
}

