//
// Created by Yunjae on 2025-03-30.
//
#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(pair<string, int> p1, pair<string, int> p2) {
    if(p1.second == p2.second) {
        if(p1.first.size() == p2.first.size()) {
            return p1.first < p2.first;
        }
        return p1.first.size() > p2.first.size();
    }
    return p1.second > p2.second;
}

int main() {

    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int N, M;
    cin >> N >> M;

    map<string, int> mmap;
    for(int i = 0 ; i < N ; i ++) {
        string word;
        cin >> word;
        if(word.size() >= M) mmap[word]++;
    }

    vector<pair<string, int>> vec;

    for(auto a : mmap) {
        vec.push_back(a);
    }

    sort(vec.begin(), vec.end(), cmp);

    for(auto a : vec) {
        cout << a.first << '\n';
    }

    return 0;
}