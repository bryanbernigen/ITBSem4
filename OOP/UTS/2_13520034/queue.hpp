#ifndef QUEUE_H
#define QUEUE_H
#define MAX_CAP 3
#define EMPTY -1

#include <iostream>
using namespace std;

template<class T>
class queue
{
protected:
    T *data;
    int tail;

public:
    queue()
    {
        this->tail = EMPTY;
        this->data = new T[MAX_CAP];
    }
    ~queue()
    {
        delete[] this->data;
    }
    queue(const queue<T> &q)
    {
        this->tail = q.tail;
        delete[] this->data;
        this->data = new T[MAX_CAP];
        for (int i = 0; i < this->tail+1; i++)
        {
            this->data[i] = q.data[i];
        }
    }
    void enqueue(T x)
    {
        if (this->tail == MAX_CAP-1)
        {
            throw new QueueFullException();
            //throw "Queue Telah Penuh";
        }
        else
        {
            this->tail++;
            this->data[this->tail] = x;
        }
    }
    //dequeue denga intepretasi mengeluarkan elemen ke LUAR (di soal ke dalam) queue
    T dequeue()
    {
        if (this->tail == EMPTY)
        {
            throw new QueueEmptyException();
            //throw "Queue Telah Kosong";
        }
        else
        {
            T elemen = this->data[0];
            for (int i = 0; i < this->tail; i++)
            {
                this->data[i] = this->data[i + 1];
            }
            this->tail--;
            return elemen;
        }
    }

    friend ostream& operator<<(ostream& os, queue& q) 
    {
        int i;
        if(q.tail==EMPTY){
            os<<"[]";
        }
        else{
            os<<"[";
            for ( i = 0; i < q.tail+1; i++)
            {
                if(i==q.tail){
                    os<<q.data[i];
                }
                else{
                    os<<q.data[i]<<",";
                }
            }
            os<<"]";
        }
        return os;
    }
};


class BaseException
{
private:
    /* data */
public:
    BaseException(/* args */);
    virtual void what() = 0;
};

class QueueException
{
private:
    BaseException *exc;
public:
    QueueException(BaseException *exc){
        this->exc = exc;
    };
    void what(){
        return this->what();
    };
};



class QueueFullException : public BaseException
{
private:
    /* data */
public:
    QueueFullException(/* args */);
    void what(){
        cout<<"Queue Telah Penuh"<<endl;
    }
};

class QueueEmptyException : BaseException
{
private:
    /* data */
public:
    QueueEmptyException(/* args */);
    void what(){
        cout<<"Queue Telah Kosong"<<endl;
    }
};



#endif