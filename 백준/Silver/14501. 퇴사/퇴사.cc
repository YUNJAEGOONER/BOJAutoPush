//
// Created by Yunjae on 2025-03-13.
//
#include<iostream>
#include<vector>
using namespace std;


int main() {

    int n;
    cin >> n;

    int ans = 0;

    vector<pair<int, int>> task;
    task.push_back(make_pair(0,0));

    for(int i = 0 ; i < n ; i ++) {
        int a,b;
        cin >> a >> b;
        task.push_back(make_pair(a, b));
    }

    vector<int> dp(n + 1);

    int max = 0;

    for(int i = 1 ; i < task.size(); i ++ ) {

        if(max < dp[i - 1]) {
            max = dp[i - 1];
        }

        //해당 번째를 실행 할 수 있는 경우
        if(i + task[i].first - 1 <= n) {
            if(dp[i + task[i].first - 1] < dp[i - 1] + task[i].second) {
                dp[i + task[i].first - 1] = dp[i - 1] + task[i].second;
            }
            if(dp[i + task[i].first - 1] < max + task[i].second) {
                dp[i + task[i].first - 1] = max + task[i].second;
            }
        }

    }

    for(auto a : dp) {
        if(max < a) max = a;
    }

    cout << max;
    return 0;
}