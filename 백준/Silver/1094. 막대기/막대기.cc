#include<iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;

    int answer = 0;
    while(n != 0)
    {
        if(n % 2)
        {
            answer ++;
        }
        n = n / 2;
    }
    cout << answer;
    return 0;
}