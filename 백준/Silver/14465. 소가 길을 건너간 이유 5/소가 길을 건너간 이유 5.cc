//
// Created by Yunjae on 2025-03-28.
//
#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N, K, B;
    cin >> N >> K >> B;

    vector<int> vec(N + 1, 1);

    //고장난 신호등
    for(int i = 0 ; i < B; i ++ ) {
        int e;
        cin >> e;
        vec[e] = 0;
    }

    //초기sum
    int sum = 0;
    for(int i = 1; i < 1 + K ; i ++ ) {
        sum += vec[i];
    }

    int min = K - sum;

    for(int i = K + 1 ; i < N + 1 ; i ++ ) {
        sum -= vec[i - K];
        sum += vec[i];
        //cout << K - sum << ' ';
        if(min > K - sum) min = K - sum;
    }

    cout << min << ' ';

    return 0;
}