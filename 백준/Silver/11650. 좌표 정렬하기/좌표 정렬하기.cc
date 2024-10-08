#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

int main()
{
    map<int, vector<int>> elements;
    int n;
    cin >> n;
    while(n--)
    {
        int a, b;
        cin >> a >>  b;
        elements[a].push_back(b);

    }
    for(auto itr : elements)
    {
        vector<int> inner_vec = itr.second;
        sort(inner_vec.begin(), inner_vec.end());
        for(auto e : inner_vec)
        {
            cout << itr.first << ' ' << e << '\n';
        }
    }

    return 0;
}