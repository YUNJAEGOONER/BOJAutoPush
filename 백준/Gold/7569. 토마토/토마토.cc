//
// Created by Yunjae on 2025-03-21.
//
#include<iostream>
#include<vector>
#include<map>
#include<queue>
using namespace std;

int main() {

    int m, n, h;
    cin >> m >> n >> h;

    map<int, vector<vector<int>>> tomatos;

    queue<pair<int, vector<int>>> mq; //depth, vector(층, i, j);

    int zero = 0;

    for(int k = 0 ; k < h ; k ++ ) {
        vector<vector<int>> floor;
        for(int i = 0 ; i < n ; i ++ ) {
            vector<int> row;
            for(int j = 0 ; j < m ; j ++ ) {
                int t;
                cin >> t;
                row.push_back(t);
                if(t == 0) zero ++;
                if(t == 1) {
                    vector<int> info;
                    info.push_back(k);
                    info.push_back(i);
                    info.push_back(j);
                    mq.push(make_pair(0, info));
                }
            }
            floor.push_back(row);
        }
        tomatos[k] = floor;
    }

    int answer = 0;

    while(!mq.empty()) {
        pair<int, vector<int>> curtop = mq.front();
        int cur_d = curtop.first;
        answer = cur_d;
        int cur_f = curtop.second[0];
        int cur_i = curtop.second[1];
        int cur_j = curtop.second[2];
        mq.pop();

        //상
        if(cur_i - 1 >= 0 && tomatos[cur_f][cur_i - 1][cur_j] == 0) {
            tomatos[cur_f][cur_i - 1][cur_j] = 1;
            zero --;
            vector<int> info = {cur_f, cur_i - 1, cur_j};
            mq.push(make_pair(cur_d + 1, info));
        }
        //하
        if(cur_i + 1 < n && tomatos[cur_f][cur_i + 1][cur_j] == 0) {
            tomatos[cur_f][cur_i + 1][cur_j] = 1;
            zero --;
            vector<int> info = {cur_f, cur_i + 1, cur_j};
            mq.push(make_pair(cur_d + 1, info));
        }
        //우
        if(cur_j + 1 < m && tomatos[cur_f][cur_i][cur_j + 1] == 0) {
            tomatos[cur_f][cur_i][cur_j + 1] = 1;
            zero --;
            vector<int> info = {cur_f, cur_i, cur_j + 1};
            mq.push(make_pair(cur_d + 1, info));
        }
        //좌
        if(cur_j - 1 >= 0 && tomatos[cur_f][cur_i][cur_j - 1] == 0) {
            tomatos[cur_f][cur_i][cur_j - 1] = 1;
            zero --;
            vector<int> info = {cur_f, cur_i, cur_j - 1};
            mq.push(make_pair(cur_d + 1, info));
        }
        //위
        if(cur_f + 1 < h && tomatos[cur_f + 1][cur_i][cur_j] == 0) {
            tomatos[cur_f + 1][cur_i][cur_j] = 1;
            zero --;
            vector<int> info = {cur_f + 1, cur_i, cur_j};
            mq.push(make_pair(cur_d + 1, info));
        }
        //아래
        if(cur_f - 1 >= 0 && tomatos[cur_f - 1][cur_i][cur_j] == 0) {
            tomatos[cur_f - 1][cur_i][cur_j] = 1;
            zero --;
            vector<int> info = {cur_f - 1, cur_i, cur_j};
            mq.push(make_pair(cur_d + 1, info));
        }

    }

    if(!zero) cout << answer << '\n';
    else cout << -1 << '\n';

    return 0;
}