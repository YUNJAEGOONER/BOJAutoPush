#include<iostream>
#include<vector>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> vec;
    for(int i = 0 ; i < n ; i ++ ) {
        int e;
        cin >> e;
        vec.push_back(e);
    }

    vector<int> dp;
    dp.push_back(0);
    dp.push_back(vec[0]);
    dp.push_back(vec[0] + vec[1]);

    for(int i = 2 ; i < n ; i ++) {
        int a = vec[i] + vec[i - 1] + dp[i - 2];
        int max = a;
        int b = vec[i] + dp[i - 1];
        if(max < b) max = b;
        int c = dp[i];
        if(max < c) max = c;
        dp.push_back(max);
    }

    cout << dp[n];

    return 0;
}