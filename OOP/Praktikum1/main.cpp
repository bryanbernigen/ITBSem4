#include "Card.hpp"

int main(){
    Card *c1 = new Card(1);
    Card *c0 = new Card();
    Card *c2 = new Card(2);
    *c0 = *c1;
    c1->gesek();
    Card *cc2 = new Card(*c2);
    c2->gesek();
    c0->~Card();
    c2->~Card();
    cc2->~Card();
    c1->~Card();
}