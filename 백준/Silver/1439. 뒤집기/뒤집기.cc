#include <iostream>
#include <vector>
using namespace std;

int main()
{
    string s;
    cin >> s;
    vector<int> check (2);

    int current = -1;
    for(int i = 0 ; i < s.length(); i ++ )
    {
        if(current != (s[i] - 48))
        {
            check[(s[i] -  48)]++;
            current = (s[i] - 48);
        }
    }

    int result = check[0] < check[1] ? check[0] : check[1];
    cout << result;
    return 0;
}