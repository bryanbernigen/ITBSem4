#include <iostream>
#include <map>
using namespace std;

int main()
{
    string input;
    map<string, int> katayangditebak{};
    map<string, int> katapenebak{};
    int n;
    int m;
    int i;
    cin >> n;
    for (i = 0; i < n; i++)
    {
        cin >> input;
        katayangditebak[input]++;
    }
    cin >> m;
    for (i = 0; i < m; i++)
    {
        cin >> input;
        katayangditebak[input]--;
    }
    for (auto x : katayangditebak)
    {
        for (i = 0; i < x.second; i++)
        {
            cout << x.first << endl;
        }
    }
}