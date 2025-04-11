//
// Created by Yunjae on 2025-04-11.
//
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    vector<vector<int>> vec;
    for(int i = 0 ; i < N ; i ++ ) {
        vector<int> row;
        for(int j = 0 ; j < N ; j ++) {
            int e;
            cin >> e;
            row.push_back(e);
        }
        vec.push_back(row);
    }

    vector<int> t;
    for(int i = 0 ; i < M ; i ++) {
        int e;
        cin >> e;
        t.push_back(e - 1);
    }

    string answer = "YES";
    bool result;
    for(int i = 0 ; i < t.size() - 1 ; i ++ ) {
        vector<int> visited (N);
        queue <int> mq;
        int start = t[i];
        int target = t[i + 1];
        mq.push(start);
        result = false;
        while(!mq.empty()) {
            int cur = mq.front();
            if(cur == target) {
                result = true;
                break;
            }
            mq.pop();
            for(int j = 0 ; j < vec[cur].size() ; j ++ ) {
                if(vec[cur][j] == 1 && visited[j] == 0) {
                    mq.push(j);
                    visited[j] = 1;
                }
            }
        }
        if(!result) {
            answer = "NO";
            break;
        }
    }
    cout << answer;

    return 0;
}