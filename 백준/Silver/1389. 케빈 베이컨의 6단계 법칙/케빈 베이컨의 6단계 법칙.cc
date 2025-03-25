//
// Created by Yunjae on 2025-03-24.
//
#include<iostream>
#include<vector>
#include<map>
#include<climits>
#include<queue>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    map<int, vector<int>> relation;
    for(int i = 0 ; i < M ; i ++ ) {
        int a, b;
        cin >> a >> b;
        //양방향 그래프
        relation[a - 1].push_back(b - 1);
        relation[b - 1].push_back(a - 1);
    }

    int min = INT_MAX;
    int idx = -1;

    queue<pair<int, int>>mq; //depth, destination;

    for(int i = 0 ; i < N ; i ++ ) {
        vector<int> visited(N);
        int sum = 0;

        visited[i] = 1;
        mq.push(make_pair(0, i));

        while(!mq.empty()) {
            int depth = mq.front().first;
            int node = mq.front().second;
            sum += depth;
            mq.pop();
            for(int j = 0 ; j < relation[node].size() ; j ++ ) {
                if(visited[relation[node][j]] == 0) {
                    mq.push(make_pair(depth + 1, relation[node][j]));
                    visited[relation[node][j]] = 1;
                }
            }
        }

        //cout << i << " : " << sum << '\n';

        if(min > sum) {
            min = sum;
            idx = i;
        }
    }

    cout << idx + 1;


    return 0;
}