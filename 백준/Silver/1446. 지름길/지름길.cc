//
// Created by Yunjae on 2025-03-27.
//
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp1446(vector<int> vec1, vector<int> vec2) {
    if(vec1[0] == vec1[0]) {
        return vec1[1] < vec2[1];
    }
    return vec1[0] < vec2[0];
}

int main() {
    int N, D;
    cin >> N >> D;

    vector<int> vec;

    for(int i = 0 ; i < D + 1 ; i ++ ) {
        vec.push_back(i);
    }

    vector<vector<int>> mmap;
    for(int i = 0 ; i < N ; i ++ ) {
        int s, e, d;
        cin >> s >> e >> d;
        if(e - s > d && e <= D) {
            vector<int> row;
            row.push_back(s);
            row.push_back(e);
            row.push_back(d);
            mmap.push_back(row);
        }
    }

    sort(mmap.begin(), mmap.end(), cmp1446);


    for(auto a : mmap) {
        int s = a[0];
        int e = a[1];
        int d = vec[s] + a[2];
        for(int i = e; i < D + 1 ; i ++) {
            if(vec[i] > d) vec[i] = d;
            d ++;
        }
    }

    cout << vec[D];
    return 0;
}