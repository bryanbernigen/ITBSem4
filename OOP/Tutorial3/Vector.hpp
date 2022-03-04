#ifndef _VECTOR_HPP_
#define _VECTOR_HPP_

#include <iostream>

using namespace std;

template <class T, int N>
class Vector
{
private:
    T *elements;

public:
    Vector()
    {
        this->elements = new T[N];
    }
    Vector(const Vector<T, N> &other)
    {
        int i;
        this->elements = other.elements;
        for (i = 0; i < N; i++)
        {
            this->elements[i] = other.elements[i];
        }
    }
    ~Vector()
    {
        delete[] this->elements;
    }

    T &operator[](int idx)
    {
        return this->elements[idx];
    }

    Vector operator+(const Vector<T, N> &other)
    {
        int i;
        Vector<T, N> result;
        for (i = 0; i < N; i++)
        {
            result.elements[i] = this->elements[i] + other.elements[i];
        }
        return result;
    }
    Vector operator-(const Vector<T, N> &other)
    {
        int i;
        Vector<T, N> result;
        for (i = 0; i < N; i++)
        {
            result.elements[i] = this->elements[i] - other.elements[i];
        }
        return result;
    }

    bool operator<(const Vector<T, N> &other)
    {
        int i;
        for (i = 0; i < N; i++)
        {
            if (this->elements[i] != other.elements[i])
            {
                return this->elements[i] < other.elements[i];
            }
        }
        return false;
    }
    bool operator>(const Vector<T, N> &other)
    {
        int i;
        for (i = 0; i < N; i++)
        {
            if (this->elements[i] != other.elements[i])
            {
                return this->elements[i] > other.elements[i];
            }
        }
        return false;
    }

    friend ostream &operator<<(ostream &os, Vector<T, N> &vector)
    {
        int i;
        os << "<";
        for (i = 0; i < N; i++)
        {
            os << vector.elements[i];
            if (i != N - 1)
            {
                os << ",";
            }
        }
        os << ">";
        return os;
    }

    friend istream &operator>>(istream &is, Vector<T, N> &vector)
    {
        int i;
        for (i = 0; i < N; i++)
        {
            is >> vector.elements[i];
        }
        return is;
    }
};

#endif