#ifndef __Queue_H
#define __Queue_H
#define MAX_CAP 10

template <class T>
class Queue {
protected:
    T *data;
    int size;
public:
    Queue();
    ~Queue();
    Queue(const Queue& q);
    void enqueue(T x);
    T dequeue();
    void print();
};

template <class T>
class PriorityQueue : public Queue<T> {
private:
    int *priorities;
public:
    PriorityQueue();
    ~PriorityQueue();
    void enqueue(const T& x, int prio);
};

//Only support for int, float, string
template class Queue<int>;
template class PriorityQueue<int>;
template class Queue<float>;
template class PriorityQueue<float>;

#endif