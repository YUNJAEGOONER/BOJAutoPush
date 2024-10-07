
#include<iostream>
#include<vector>
using namespace std;

int main()
{
    while(true)
    {
        int w, h;
        cin >> w >> h;
        if (w == 0 && h == 0)
        {
            break;
        }
        vector<vector<int>>map;
        for(int i = 0 ; i < h  ; i ++ )
        {
            vector<int> element;
            for(int j = 0 ; j < w ; j ++ )
            {
                int e;
                cin >> e;
                element.push_back(e);
            }
            map.push_back(element);
        }

        int island_count = 0;

        for(int i = 0 ; i < h ; i ++ )
        {
            for(int j = 0 ; j < w ; j ++ )
            {
                if(map[i][j] == 1)
                {
                    vector<vector<int>>stack;
                    vector<int> idx;
                    idx.push_back(i);
                    idx.push_back(j);
                    stack.push_back(idx);
                    int cur_i = i;
                    int cur_j = j;
                    map[cur_i][cur_j] = 0;
                    while(stack.size() != 0)
                    {
                        int flag = 1;
                        //left
                        if(cur_j - 1 >= 0 && map[cur_i][cur_j-1] == 1)
                        {
                            vector<int> idx;
                            idx.push_back(cur_i);
                            idx.push_back(cur_j - 1);
                            stack.push_back(idx);
                            map[cur_i][cur_j - 1] = 0;
                            flag = 0;
                        }
                        //right
                        if(cur_j + 1 < w && map[cur_i][cur_j + 1] == 1)
                        {
                            vector<int> idx;
                            idx.push_back(cur_i);
                            idx.push_back(cur_j + 1);
                            stack.push_back(idx);
                            map[cur_i][cur_j + 1] = 0;
                            flag = 0;
                        }
                        //top
                        if(cur_i - 1 >= 0 && map[cur_i - 1][cur_j] == 1)
                        {
                            vector<int> idx;
                            idx.push_back(cur_i - 1);
                            idx.push_back(cur_j);
                            stack.push_back(idx);
                            map[cur_i - 1][cur_j] = 0;
                            flag = 0;
                        }
                        //under
                        if(cur_i + 1 < h && map[cur_i + 1][cur_j] == 1)
                        {
                            vector<int> idx;
                            idx.push_back(cur_i + 1);
                            idx.push_back(cur_j);
                            stack.push_back(idx);
                            map[cur_i + 1][cur_j] = 0;
                            flag = 0;
                        }
                        //- -
                        if(cur_j - 1 >= 0 && cur_i - 1 >= 0 && map[cur_i - 1][cur_j - 1] == 1)
                        {
                            vector<int> idx;
                            idx.push_back(cur_i - 1);
                            idx.push_back(cur_j - 1);
                            stack.push_back(idx);
                            map[cur_i - 1][cur_j - 1] = 0;
                            flag = 0;
                        }
                        // + +
                        if(cur_j + 1 < w && cur_i + 1 < h && map[cur_i + 1][cur_j + 1] == 1)
                        {
                            vector<int> idx;
                            idx.push_back(cur_i + 1);
                            idx.push_back(cur_j + 1);
                            stack.push_back(idx);
                            map[cur_i + 1][cur_j + 1] = 0;
                            flag = 0;
                        }
                        // - +
                        if(cur_i - 1 >= 0 && cur_j + 1 < w && map[cur_i - 1][cur_j + 1] == 1)
                        {
                            vector<int> idx;
                            idx.push_back(cur_i - 1);
                            idx.push_back(cur_j + 1);
                            stack.push_back(idx);
                            map[cur_i - 1][cur_j + 1] = 0;
                            flag = 0;
                        }
                        // + -
                        if(cur_i + 1 < h &&  cur_j - 1 >= 0  && map[cur_i + 1][cur_j - 1] == 1)
                        {
                            vector<int> idx;
                            idx.push_back(cur_i + 1);
                            idx.push_back(cur_j - 1);
                            stack.push_back(idx);
                            map[cur_i + 1][cur_j - 1] = 0;
                            flag = 0;
                        }
                        //더 이상 갈 데가 없다면
                        if(flag)
                        {
                            stack.pop_back();
                        }
                        if(stack.size() > 0)
                        {
                            cur_i = stack.back()[0];
                            cur_j = stack.back()[1];
                        }
                    }

                    island_count = island_count + 1;

                }
            }
        }

        cout << island_count << '\n';
    }
    return 0;
}