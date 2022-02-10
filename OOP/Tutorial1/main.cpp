#include "Box.cpp"

int main()
{
    Box *box2 = new Box(2);
    Box *box0 = new Box();
    Box *box1 = new Box(1);
    (*box0) = (*box2);
    Box *box1_copy = new Box(*box1);
    (*box2).peek();
    (*box1).peek();
    delete box0;
    delete box1;
    delete box1_copy;
    delete box2;
}