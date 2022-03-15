#ifndef __Triplet_H
#define __Triplet_H

using namespace std;

template <class A, class B, class C>
class Triplet {
private:
    A a;
    B b;
    C c;
public:
    Triplet(A a, B b, C c) {
        this->a = a;
        this->b = b;
        this->c = c;
    }
    A getFirst() const {
        return this->a;
    }
    B getSecond() const {
        return this->b;
    }
    C getThird() const {
        return this->c;
    }
    bool operator==(const Triplet<A,B,C>& t) {
        return (
            this->a == t.getFirst()
            && this->b == t.getSecond()
            && this->c == t.getThird()
        );
    }
};

#endif