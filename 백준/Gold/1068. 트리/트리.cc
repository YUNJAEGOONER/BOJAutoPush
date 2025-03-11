//
// Created by Yunjae on 2025-03-11.
//
#include<map>
#include<vector>
#include<iostream>
#include<queue>
using namespace std;

int main() {

    int n;
    cin >> n;

    vector<int> leaf(n, 1);

    map<int, vector<int>> trees;
    int root = 0;

    for(int i = 0 ; i < n ; i ++ ) {
        int parent;
        cin >> parent;
        if(parent == - 1) {
            root = i;
        }
        else {
            trees[parent].push_back(i);
        }
    }

    int del;
    cin >> del;

    queue<int> mq;
    if(del != root) {
        mq.push(root);
    }

    int cnt = 0;
    while(!mq.empty()) {
        int cur = mq.front();
        mq.pop();
        bool leaf = true;
        for(int i = 0 ; i < trees[cur].size() ; i ++ ) {
            if(trees[cur][i] != del) {
                mq.push(trees[cur][i]);
                leaf = false;
            }
        }
        if(leaf) cnt++;
    }

    cout << cnt;

    return 0;
}