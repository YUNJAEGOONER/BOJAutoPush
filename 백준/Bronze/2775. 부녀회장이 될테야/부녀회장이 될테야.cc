#include<iostream>
using namespace std;

int floor [15][15]  = {0,};

int people(int i, int j)
{
    //cout << i << "floor " << j << "ho" << '\n';
    if(floor[i][j])
    {
        //cout << "Return value : " << floor[i][j] << '\n';
        return floor[i][j];

    }
    else if(j == 0)
    {
        return 0;
    }
    return floor[i][j] = people(i - 1, j) + people(i, j - 1);
}

int main()
{

    int n;
    cin >> n;
    while(n -- )
    {
        int k, n;
        cin >> k >> n;
        for(int i = 0 ; i < 15 ; i ++ )
        {
            floor[0][i] = i;
            floor[i][1] = 1;
        }


        // for(int i = 0 ; i < 15 ; i ++ )
        // {
        //     for(int j = 0 ; j < 15 ; j ++ )
        //     {
        //         cout << floor[i][j] << ' ';
        //     }
        //     cout << '\n';
        // }

        int result = people(k, n - 1) + people(k - 1, n);
        cout << result << '\n';
    }
    return 0;
}