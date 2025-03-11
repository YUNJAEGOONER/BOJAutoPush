//
// Created by Yunjae on 2025-03-11.
//
#include<vector>
#include<iostream>
#include<queue>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    int si, sj;

    vector<vector<int>>vec;

    vector<vector<int>>res;

    for(int i = 0 ; i < n ; i ++ ) {
        vector<int> row;
        vector<int> rows(m, -1);
        for(int j = 0 ; j < m ; j ++ ) {
            int e;
            cin >> e;
            if(e == 2) {
                si = i;
                sj = j;
            }
            if(e == 0) {
                rows[j] = 0;
            }
            row.push_back(e);
        }
        res.push_back(rows);
        vec.push_back(row);
    }

    queue<pair<pair<int, int>, int>> mq;
    mq.push(make_pair(make_pair(si, sj), 0));

    while(!mq.empty()) {
        int cur_x = mq.front().first.first;
        int cur_y = mq.front().first.second;
        int depth = mq.front().second;
        res[cur_x][cur_y] = depth;
        mq.pop();

        if(cur_x - 1 >=0 && vec[cur_x - 1][cur_y] == 1) {
            mq.push(make_pair(make_pair(cur_x - 1, cur_y), depth + 1));
            vec[cur_x - 1][cur_y] = 0;
        }

        if(cur_x + 1 < n && vec[cur_x + 1][cur_y] == 1) {
            mq.push(make_pair(make_pair(cur_x + 1, cur_y), depth + 1));
            vec[cur_x + 1][cur_y] = 0;
        }

        if(cur_y - 1 >= 0 && vec[cur_x][cur_y - 1] == 1) {
            mq.push(make_pair(make_pair(cur_x, cur_y - 1), depth + 1));
            vec[cur_x][cur_y - 1] = 0;
        }

        if(cur_y + 1 < m && vec[cur_x][cur_y + 1] == 1) {
            mq.push(make_pair(make_pair(cur_x, cur_y + 1), depth + 1));
            vec[cur_x][cur_y + 1] = 0;
        }
    }



    for(auto a : res) {
        for(auto b : a) {
            cout << b << ' ';
        }
        cout << '\n';
    }

    return 0;
}