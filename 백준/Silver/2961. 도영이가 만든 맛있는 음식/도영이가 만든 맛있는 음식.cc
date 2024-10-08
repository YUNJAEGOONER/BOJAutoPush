#include <vector>
#include<iostream>
using namespace std;

vector<int> flag;
vector<vector<int>>ingredients;
int min_value;

void dfs_gogo(int start, int end, int count)
{
    int s = 1;
    int b = 0;

    if(count > 0)
    {
        for(int i = 0 ; i < flag.size() ; i ++ )
        {
            if(flag[i] != 1)
            {
                s = s * ingredients[i][0];
                b = b + ingredients[i][1];
            }
        }
       // cout << s << ' ' << b << abs(s-b) << '\n';
        min_value = (abs(s-b) < min_value) ? abs(s-b) : min_value;
    }
    for(int i = start ; i < end ; i ++ )
    {
        if(flag[i] == 0)continue;
        flag[i] = 0;
        dfs_gogo(i, end, count + 1);
        flag[i] = 1;
    }
}

int main()
{
    int n;
    cin >> n;

    for(int i = 0 ; i < n ; i ++ )
    {
        vector<int> element;
        int s, b;
        cin >> s >> b;
        element.push_back(s);
        element.push_back(b);
        ingredients.push_back(element);
        flag.push_back(1);
    }

    min_value = abs(ingredients[0][0] - ingredients[0][1]);
    dfs_gogo(0, n, 0);

    cout << min_value;

    return 0;
}
