//
// Created by Yunjae on 2025-03-24.
//
#include<iostream>
using namespace std;

int main() {

    int q;
    cin >> q;

    while(q--) {
        int M, N, x, y;
        cin >> M >> N >> x >> y;

        int answer = -1;

        int start = x;
        int cnt = 0;

        while(true) {

            int cur_N = start % N;
            if(cur_N == 0) cur_N = N;
            if(cur_N == y) answer = start;

            start += M;

            cnt += M;
            if(cnt % N == 0) break;
        }

        cout << answer << '\n';

    }

    return 0;
}