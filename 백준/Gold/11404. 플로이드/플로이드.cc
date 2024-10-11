#include<iostream>
#include<vector>
#define max_distance 1000000000

using namespace std;

int main()
{
    vector<vector<int>>map;

    int n;
    cin >> n;
    for(int i = 0 ; i < n ; i ++ )
    {
        vector<int> element;
        for(int j = 0; j < n ; j ++ )
        {
            element.push_back(max_distance);
        }
        element[i] = 0;
        map.push_back(element);
    }

    int m;
    cin >> m;
    while(m -- )
    {
        int a,b,c;
        cin >> a >> b >> c;
        if(map[a - 1][b - 1] > c)
        {
            map[a - 1][b - 1] = c;
        }

    }
    
    for(int k = 0 ; k < n ; k ++ )
    {
        for(int i = 0 ; i < n ; i ++ )
        {
            for(int j = 0 ; j < n ; j ++ )
            {
                int i_j = map[i][j];
                int i_k_j = map[i][k] + map[k][j];
                if(i_j > i_k_j) map[i][j] = i_k_j;
            }
        }

    }

    for(int i = 0 ; i < n ; i ++ )
    {
        for(int j = 0; j < n ; j ++ )
        {
            if(map[i][j] == max_distance)
            {
                cout << 0 << ' ';
            }
            else
            {
                cout << map[i][j] << ' ';
            }
        }
        if(i != n - 1)
        {
            cout << '\n';
        }
    }


    return 0;
}