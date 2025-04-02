//
// Created by Yunjae on 2025-04-02.
//
#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

int main() {
    int q;
    cin >> q;
    while(q--) {
        int n;
        cin >> n;

        vector<vector<int>> vec;
        vector<vector<int>> dp;

        for(int i = 0 ; i < 2 ; i ++ ){
            vector<int> row;
            row.push_back(0);
            for(int j = 0 ; j < n ; j ++) {
                int e;
                cin >> e;
                row.push_back(e);
            }
            vec.push_back(row);

            vector<int> dprow(n + 1);
            dp.push_back(dprow);
        }

        for(int j = 1 ; j < n + 1 ; j ++ ) {
            dp[0][j] = dp[1][j - 1] + vec[0][j];
            dp[1][j] = dp[0][j - 1] + vec[1][j];

            if(j >= 3) {
                if(dp[1][j] < dp[0][j - 2] + vec[1][j]) {
                    dp[1][j] = dp[0][j - 2] + vec[1][j];
                }
                if(dp[0][j] < dp[1][j - 2] + vec[0][j]) {
                    dp[0][j] = dp[1][j - 2] + vec[0][j];
                }
            }
        }

        if(dp[0][n] > dp[1][n]) cout << dp[0][n] << '\n';
        else cout << dp[1][n] << '\n';

    }

    return 0;
}

