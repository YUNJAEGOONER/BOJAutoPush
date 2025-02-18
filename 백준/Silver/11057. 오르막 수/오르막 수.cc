//
// Created by Yunjae on 2025-02-18.
//
#include<iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin >> n;
    int answer = 0;

    if(n == 1) {
        answer = 10;
    }
    else if (n == 2) {
        answer = 55;
    }
    else {
        vector<int> dp;
        for(int i = 1 ; i < 11 ; i ++ ) {
            dp.push_back(i);
        }

        for(int i = 2; i < n ; i ++ ) {
            for(int j = 1; j < 10 ; j ++ ) {
                dp[j] = (dp[j] + dp[j - 1]) % 10007;
            }
        }

        for(auto a : dp) {
            answer += a;
        }

    }

    cout << answer % 10007; ;
    return 0;
}