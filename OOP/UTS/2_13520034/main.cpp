#include "queue.hpp"
#include <iostream>
using namespace std;

int main()
{
    queue<int> q;
    queue<double> q2;
    try
    {
        q.dequeue();
        q.enqueue(8);
        q.enqueue(6);
        q.enqueue(4);
        cout << q.dequeue() << endl;
        q.enqueue(2);
        cout << q.dequeue() << endl;
    }
    catch (BaseException *e) {
        QueueException qe = QueueException(e);
        qe.what();
    }
    catch (const char *data)
    {
        cout << data;
    };
    cout<<""<<endl;
    q.enqueue(8);
    cout<<q;
    q.enqueue(6);
    q.enqueue(4);
    cout << q << endl;

    q2.enqueue(1.5);
    cout<<q2<<endl;
    return 0;
}
