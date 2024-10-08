#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>>normal;
vector<vector<int>>abnormal;

int dfs_stack(vector<vector<int>> map, int rgb, int n)
{
    int result = 0;
     for(int k = 1; k < 1 + rgb ; k++ )
    {
        int island = 0;
        for(int i = 0 ; i < n ; i ++)
        {
            for(int j = 0 ; j < n ; j ++ )
            {
                if(map[i][j] == k)
                {
                    vector<vector<int>>stack;
                    map[i][j] = 0;
                    int cur_i = i;
                    int cur_j = j;
                    vector<int> idx;
                    idx.push_back(i);
                    idx.push_back(j);
                    stack.push_back(idx);
                    while(stack.size() != 0)
                    {
                        int flag = 1;
                        //top
                        if(cur_i - 1 >= 0 && map[cur_i - 1][cur_j] == k)
                        {
                            vector<int> idx;
                            idx.push_back(cur_i - 1);
                            idx.push_back(cur_j);
                            stack.push_back(idx);
                            map[cur_i - 1][cur_j] = 0;
                            flag = 0;
                        }
                        //buttom
                        if(cur_i + 1 < n && map[cur_i + 1][cur_j] == k)
                        {
                            vector<int> idx;
                            idx.push_back(cur_i + 1);
                            idx.push_back(cur_j);
                            stack.push_back(idx);
                            map[cur_i + 1][cur_j] = 0;
                            flag = 0;
                        }
                        //left
                        if(cur_j - 1 >= 0 && map[cur_i][cur_j - 1] == k)
                        {
                            vector<int> idx;
                            idx.push_back(cur_i);
                            idx.push_back(cur_j - 1);
                            stack.push_back(idx);
                            map[cur_i][cur_j - 1] = 0;
                            flag = 0;
                        }
                        //right
                        if(cur_j + 1 < n && map[cur_i][cur_j + 1] == k)
                        {
                            vector<int> idx;
                            idx.push_back(cur_i);
                            idx.push_back(cur_j + 1);
                            stack.push_back(idx);
                            map[cur_i][cur_j + 1] = 0;
                            flag = 0;
                        }

                        if(flag)
                        {
                            stack.pop_back();
                        }
                        if(stack.size() > 0 )
                        {
                            cur_i = stack.back()[0];
                            cur_j = stack.back()[1];
                        }

                    }
                    island ++;
                }

            }
        }
        // for(int i = 0 ; i < n ; i ++ )
        // {
        //     for(int j = 0 ; j < n ; j ++ )
        //     {
        //         cout << normal[i][j] << " ";
        //     }
        //     cout << '\n';
        // }
        // cout << k << " : " <<  island << " = \n ";
         result = result + island;
    }
    return result;

}

int main()
{
    int n;
    cin >> n;

    for(int i = 0 ; i < n ; i ++ )
    {
        vector<int> e;
        for(int j = 0 ; j < n ; j ++ )
        {
            char c;
            cin >> c;
            int num;
            if(c == 'B')
            {
                num = 1;
            }
            else if (c == 'G')
            {
                num = 2;
            }
            else
            {
                num = 3;
            }
            e.push_back(num);
        }
        normal.push_back(e);
    }

    for(int i = 0 ; i < n ; i ++ )
    {
        vector<int> e;
        for(int j = 0 ; j < n ; j ++ )
        {
            if(normal[i][j] == 1)
            {
                e.push_back(1);
            }
            else
            {
                e.push_back(2);
            }
        }
        abnormal.push_back(e);
    }

    int n_result = dfs_stack(normal, 3, n);
    int a_result = dfs_stack(abnormal, 2, n);
    cout << n_result << ' ' << a_result ;



    return 0;
}