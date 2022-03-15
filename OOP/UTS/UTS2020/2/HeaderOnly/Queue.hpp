#ifndef __Queue_H
#define __Queue_H
#define MAX_CAP 10

#include <iostream>
using namespace std;

template <class T>
class Queue {
protected:
    T *data;
    int size;
public:
    Queue() {
        this->size = 0;
        this->data = new T[MAX_CAP];
    }
    ~Queue() {
        delete[] this->data;
    }
    Queue(const Queue& q) {
        this->size = q.size;
        delete[] this->data;
        this->data = new T[MAX_CAP];
        for (int i = 0; i < this->size; i++) {
            this->data[i] = q.data[i];
        }
    }
    void enqueue(T x) {
        if (this->size == MAX_CAP) {
            throw "Queue is full";
        } else {
            this->data[this->size++] = x;
        }
    }
    T dequeue() {
        if (this->size == 0) {
            throw "Queue is empty";
        } else {
            T r = this->data[0];
            for (int i = 0; i < this->size - 1; i++) {
                this->data[i] = this->data[i + 1];
            }
            this->size--;
            return r;
        }
    }
    void print() {
        for (int i = 0; i < this->size; i++) {
            cout << this->data[i] << " ";
        }
        cout << endl;
    }
};

template <class T>
class PriorityQueue : public Queue<T> {
private:
    int *priorities;
public:
    PriorityQueue() : Queue<T>() {
        this->priorities = new int[MAX_CAP];
    }
    ~PriorityQueue() {
        delete[] this->priorities;
    }
    void enqueue(const T& x, int prio) {
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
};


#endif