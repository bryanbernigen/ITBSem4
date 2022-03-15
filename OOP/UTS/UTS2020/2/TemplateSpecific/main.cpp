#include "Queue.hpp"
#include <iostream>
using namespace std;

int main() {
    Queue<int> q;
    try {
        q.enqueue(8);
        q.enqueue(6);
        q.enqueue(4);
        cout << q.dequeue() << endl;
        q.enqueue(2);
        cout << q.dequeue() << endl;
    } catch (const char* m) {
        cout << m << endl;
    }
    q.print();
    PriorityQueue<int> pq;
    try {
        pq.enqueue(8, 1);
        pq.enqueue(6, 2);
        pq.enqueue(4, 1);
        cout << pq.dequeue() << endl;
        pq.enqueue(2, 3);
        cout << pq.dequeue() << endl;
    } catch (const char* m) {
        cout << m << endl;
    }
    pq.print();
    return 0;
}
