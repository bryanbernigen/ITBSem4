#include <iostream>
#include <queue>
#include <string>

using namespace std;

int main(){
    int i;
    priority_queue<int,string> pq;
    for ( i = 0; i < 50; i++)
    {
        pq.push('a'+i);
    }
    pq.pop();
}