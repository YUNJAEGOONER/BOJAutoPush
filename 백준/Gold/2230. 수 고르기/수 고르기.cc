//
// Created by Yunjae on 2025-04-11.
//
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    vector<int> vec;
    for(int i = 0 ; i < N ; i ++ ) {
        int e;
        cin >> e;
        vec.push_back(e);
    }

    sort(vec.begin(), vec.end());

    int end = 0;
    int MIN = vec[vec.size() - 1] - vec[0];

    for(int i = 0 ; i < vec.size() ; i ++) {
        int c = abs(vec[i] - vec[end]);
        while(c >= M && i >= end) {
            if(MIN > c) MIN = c;
            end ++;
            c = abs(vec[i] - vec[end]);
        }
    }

    cout << MIN << ' ';


    return 0;
}