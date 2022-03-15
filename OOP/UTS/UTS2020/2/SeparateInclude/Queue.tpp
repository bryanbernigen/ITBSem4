#include <iostream>
using namespace std;

template <class T>
Queue<T>::Queue() {
    this->size = 0;
    this->data = new T[MAX_CAP];
}
template <class T>
Queue<T>::~Queue() {
    delete[] this->data;
}
template <class T>
Queue<T>::Queue(const Queue<T>& q) {
    this->size = q.size;
    delete[] this->data;
    this->data = new T[MAX_CAP];
    for (int i = 0; i < this->size; i++) {
        this->data[i] = q.data[i];
    }
}
template <class T>
void Queue<T>::enqueue(T x) {
    if (this->size == MAX_CAP) {
        throw "Queue is full";
    } else {
        this->data[this->size++] = x;
    }
}
template <class T>
T Queue<T>::dequeue() {
    if (this->size == 0) {
        throw "Queue is empty";
    } else {
        int r = this->data[0];
        for (int i = 0; i < this->size - 1; i++) {
            this->data[i] = this->data[i + 1];
        }
        this->size--;
        return r;
    }
}
template <class T>
void Queue<T>::print() {
    for (int i = 0; i < this->size; i++) {
        cout << this->data[i] << " ";
    }
    cout << endl;
}

template <class T>
PriorityQueue<T>::PriorityQueue() : Queue<T>() {
    this->priorities = new int[MAX_CAP];
}

template <class T>
PriorityQueue<T>::~PriorityQueue() {
    delete[] this->priorities;
}

template <class T>
void PriorityQueue<T>::enqueue(const T& x, int prio) {
    if (this->size == MAX_CAP) {
        throw "Queue is full";
    } else {
        int i;
        for (i = 0; i < this->size; i++){
            if (prio > this->priorities[i]) {
                for (int j = this->size; j > i; j--) {
                    this->data[j] = this->data[j - 1];
                    this->priorities[j] = this->priorities[j - 1];
                }
                break;
            }
        }
        this->data[i] = x;
        this->priorities[i] = prio;
        this->size++;
    }
}
