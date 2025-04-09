//
// Created by Yunjae on 2025-04-09.
//
#include <iostream>
#include <vector>
using namespace std;

vector<long long> dpvec(1000001);

long long dp15988(int num) {
    if(dpvec[num] != 0) {
        return dpvec[num];
    }
    return dpvec[num] = (dp15988(num - 1) + dp15988(num - 2) + dp15988(num - 3)) % 1000000009;
}

int main() {

    dpvec[0] = 1;
    dpvec[1] = 1;
    dpvec[2] = 2;

    int q;
    cin >> q;
    for(int i = 0 ; i < q ; i ++ ) {
        int n;
        cin >> n;
        cout << dp15988(n) % 1000000009 << '\n';
    }
    return 0;
}