#include "Triplet.hpp"
#include <string>
#include <iostream>

int main() {
    Triplet<int, int, int> a(3, 2, -5);
    cout << a.getFirst() << endl;
    cout << a.getSecond() << endl;
    cout << a.getThird() << endl;

    // Triplet<string, float, string> a("abc", 4.5, "def");
    // Triplet<string, float, string> b("ghi", -1.0, "def");
    // Triplet<string, float, string> c("abc", 4.5, "def");
    // if (a == b) {
    //     cout << "a == b" << endl;
    // }
    // if (a == c) {
    //     cout << "a == c" << endl;
    // }
    return 0;
}