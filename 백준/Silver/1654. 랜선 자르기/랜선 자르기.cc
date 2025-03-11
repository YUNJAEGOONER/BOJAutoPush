//
// Created by Yunjae on 2025-03-11.
//
#include<iostream>
#include<vector>
using namespace std;

int main() {

    int k, n;
    cin >> k >> n;

    int max = 0;
    vector<long> vec;
    for(int i = 0 ; i < k ; i ++ ) {
        long e;
        cin >> e;
        vec.push_back(e);
        if(e > max) max = e;
    }

    long s = 0;
    long e = max;
    long cnt = 0;

    while(e - s != 1) {
        long mid = (s + e) / 2;
        cnt = 0;

        for(int i = 0 ; i < k ; i ++ ){
            cnt += (vec[i] / mid);
        }

        //길이 늘리기
        if(cnt >= n) {
            s = mid;
        }
        else {
            e = mid;
        }
    }

    cnt = 0;
    for(int i = 0 ; i < k ; i ++ ){
        cnt += (vec[i] / e);
    }
    if(cnt == n) {
        cout << e;
    }
    else {
        cout << s;
    }

    return 0;
}