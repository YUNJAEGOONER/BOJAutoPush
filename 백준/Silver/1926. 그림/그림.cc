//
// Created by Yunjae on 2024-11-01.
//
#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    vector<vector<int>> map;
    for(int i = 0 ; i < n ; i ++ ) {
        vector<int> row;
        for(int j = 0 ; j < m ; j ++ ) {
            int e;
            cin >> e;
            row.push_back(e);
        }
        map.push_back(row);
    }

    int paint = 0;
    int max = 0;

    for(int i = 0 ; i < n ; i ++ ) {
        for(int j = 0 ; j < m ; j ++ ) {
            int width = 0;
            vector<vector<int>> myq;
            if(map[i][j]) {
                paint ++;
                vector<int> p;
                p.push_back(i);
                p.push_back(j);
                myq.push_back(p);
                map[i][j] = 0;
                while(!myq.empty()) {
                    int cur_i = myq[0][0];
                    int cur_j = myq[0][1];
                    myq.erase(myq.begin());
                    width++;

                    //top
                    if(cur_i - 1 >= 0 && map[cur_i - 1][cur_j]) {
                        vector<int> p;
                        p.push_back(cur_i - 1);
                        p.push_back(cur_j);
                        myq.push_back(p);
                        map[cur_i - 1][cur_j] = 0;
                    }
                    //down
                    if(cur_i + 1 < n && map[cur_i + 1][cur_j]) {
                        vector<int> p;
                        p.push_back(cur_i + 1);
                        p.push_back(cur_j);
                        myq.push_back(p);
                        map[cur_i + 1][cur_j] = 0;
                    }
                    //right
                    if(cur_j + 1 < m && map[cur_i][cur_j + 1]) {
                        vector<int> p;
                        p.push_back(cur_i);
                        p.push_back(cur_j + 1);
                        myq.push_back(p);
                        map[cur_i][cur_j + 1] = 0;
                    }
                    //left
                    if(cur_j - 1 >= 0 && map[cur_i][cur_j - 1]) {
                        vector<int> p;
                        p.push_back(cur_i);
                        p.push_back(cur_j - 1);
                        myq.push_back(p);
                        map[cur_i][cur_j - 1] = 0;
                    }
                }
                if(max < width) max = width;
                //cout << "width : " << width << '\n';
            }

        }
    }

    cout << paint << '\n' << max;

    return 0;
}