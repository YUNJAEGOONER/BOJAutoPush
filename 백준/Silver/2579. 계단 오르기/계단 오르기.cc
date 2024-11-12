#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> vec(n + 1);

    for(int i = 1; i < n + 1; i++) {
        int p;
        cin >> p;
        vec[i] = p;
    }

    vector<vector<int>> dp(n + 1);

    dp[1].push_back(vec[1]);
    dp[1].push_back(vec[1]);

    if(n > 1) {
        dp[2].push_back(vec[1] + vec[2]);
        dp[2].push_back(vec[2]);
    }

    for(int i = 3; i <= n ; i ++ ) {
        //+1칸(이전에 2칸 점프한 경우에만 1칸 올라가기가 가능함)
        dp[i].push_back(dp[i - 1][1] + vec[i]);
        //+2칸(이전에 1칸 점프한 경우 > 이전에 2칸 점프한 경우)
        if(dp[i - 2][0] + vec[i] > dp[i - 2][1] + vec[i]) {
            dp[i].push_back(dp[i - 2][0] + vec[i]);
        }
        else {
            dp[i].push_back(dp[i - 2][1] + vec[i]);
        }
    }

    int answer = dp[n][0];
    if(answer < dp[n][1]) answer = dp[n][1];

    cout << answer;

    return 0;
}