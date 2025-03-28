//
// Created by Yunjae on 2025-03-28.
//
#include<iostream>
#include<vector>
using namespace std;

int main() {
    int N, X;
    cin >> N >> X;

    vector<int> vec;
    int sum = 0;
    for(int i = 0 ; i < N ; i ++ ) {
        int e;
        cin >> e;
        if(i < X) sum += e;
        vec.push_back(e);
    }

    int max = sum;
    vector<int> cnt;
    cnt.push_back(sum);
    for(int i = X ; i < N ; i ++ ) {
        sum -= vec[i - X];
        sum += vec[i];
        cnt.push_back(sum);
        if(max < sum) max = sum;
    }

    int max_cnt = 0;
    for(auto a : cnt) {
        if(a == max) max_cnt ++;
    }

    if(max == 0) {
        cout << "SAD";
    }
    else {
        cout << max << '\n' << max_cnt;
    }

    return 0;
}