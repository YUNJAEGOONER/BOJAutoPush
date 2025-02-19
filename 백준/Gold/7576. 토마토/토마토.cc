//
// Created by Yunjae on 2025-02-19.
//

#include<iostream>
#include<vector>
#include<queue>

using namespace std;

int check_available(vector<vector<int>> vec) {
    for(int i = 0 ; i < vec.size() ; i ++ ) {
        for(int j = 0 ; j < vec[0].size() ; j ++ ) {
            if(vec[i][j] == 0) return 0;
        }
    }
    return 1;
}

int main(){
    int a, b;
    cin >> a >> b;

    int answer = 0;

    vector<vector<int>> mmap;
    queue <pair<int, int>>mqueue;

    for(int i = 0 ; i < b ; i ++ ) {
        vector<int> row;
        for(int j = 0 ; j < a ; j ++ ) {
            int e;
            cin >> e;
            if(e == 1) {
                mqueue.push(make_pair(i, j));
            }
            row.push_back(e);
        }
        mmap.push_back(row);
    }

    //모든 토마토가 익어있는 상태
    if(check_available(mmap)) {
        answer = 0;
    }
    else {
        queue<pair<int, int>> nqueue;
        while(!mqueue.empty()) {

            int cur_x = mqueue.front().first;
            int cur_y = mqueue.front().second;

            //left
            if(cur_y - 1 >= 0 && mmap[cur_x][cur_y - 1] == 0) {
                mmap[cur_x][cur_y - 1] = 1;
                nqueue.push(make_pair(cur_x, cur_y - 1));
            }

            //right
            if(cur_y + 1 < a && mmap[cur_x][cur_y + 1] == 0) {
                mmap[cur_x][cur_y + 1] = 1;
                nqueue.push(make_pair(cur_x, cur_y + 1));
            }

            //bottom
            if(cur_x + 1 < b && mmap[cur_x + 1][cur_y] == 0) {
                mmap[cur_x + 1][cur_y] = 1;
                nqueue.push(make_pair(cur_x + 1, cur_y));
            }

            //top
            if(cur_x - 1 >= 0 && mmap[cur_x - 1][cur_y] == 0) {
                mmap[cur_x - 1][cur_y] = 1;
                nqueue.push(make_pair(cur_x - 1, cur_y));
            }

            mqueue.pop();

            if(mqueue.empty() && !nqueue.empty()) {
                answer ++;
                mqueue = nqueue;
                queue<pair<int, int>> nqueue2;
                nqueue = nqueue2;

                // for(auto a : mmap) {
                //     for(auto b : a) {
                //         cout << b << ' ';
                //     }
                //     cout << '\n';
                // }
                // cout << "answer : " << answer << '\n';
                //break;
            }
        }
        if(!check_available(mmap)) {
            answer = -1;
        }
    }

    cout << answer << ' ';

    return 0;
}