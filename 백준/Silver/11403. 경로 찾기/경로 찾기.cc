//
// Created by Yunjae on 2025-03-24.
//
#include <iostream>
#include <vector>
#include <map>
#include <queue>
using namespace std;

int main() {
    int n;
    cin >> n;

    queue<pair<int, int>> mq; //출발지, 도착지;

    map<int, vector<int>> mmap;
    vector<vector<int>> vec;
    for(int i = 0 ; i < n ; i ++ ) {
        vector<int> row(n);
        for(int j = 0 ; j < n ; j ++ ) {
            int e;
            cin >> e;
            if(e) {
                mmap[i].push_back(j);
                mq.push(make_pair(i, j));
            }
        }
        vec.push_back(row);
    }

    while(!mq.empty()) {
        int start = mq.front().first;
        int end = mq.front().second;
        mq.pop();
        vec[start][end] = 1;
        for(int i = 0 ; i < mmap[end].size() ; i ++ ) {
            if(vec[start][mmap[end][i]] == 0) {
                mq.push(make_pair(start, mmap[end][i]));
            }

        }
    }

    for(auto a : vec) {
        for(auto b : a) {
            cout << b << ' ';
        }
        cout << '\n';
    }
    
    return 0;
}