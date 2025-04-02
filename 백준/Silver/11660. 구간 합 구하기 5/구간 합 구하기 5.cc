//
// Created by Yunjae on 2025-04-02.
//
#include<iostream>
#include<vector>
using namespace std;

int main() {
    
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
    
    int N, M;
    cin >> N >> M;

    vector<vector<int>> dp;

    int sum = 0;
    for(int i = 0 ; i < N ; i ++ ) {
        vector<int> row;
        row.push_back(sum);
        for(int j = 0 ; j < N ; j++ ) {
            int e;
            cin >> e;
            sum += e;
            row.push_back(sum);
        }
        dp.push_back(row);
    }
    
    while(M --) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;

        int result = 0;
        for(int i = x1 - 1 ; i < x2 ; i ++ ) {
            result += dp[i][y2] - dp[i][y1 - 1];
        }

        cout << result << '\n';
    }


    return 0;
}