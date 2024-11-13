#include <iostream>
#include <vector>
using namespace std;

int main(){
    int n;
    cin >> n;

    vector<int> vec;
    vector<int> dp;
    for(int i = 0 ; i < n ; i ++ ) {
        int e;
        cin >> e;
        vec.push_back(e);
        dp.push_back(e);
    }

    int result = -1;

    for(int i = 1 ; i < n ; i ++ ) {
        int max_sum = -1;
        int max_idx = -1;
        for(int j = 0 ; j < i ; j ++) {
            if(vec[j] < vec[i]) {
                if(max_sum < dp[j]) {
                    max_sum = dp[j];
                    max_idx = j;
                }
            }
        }
        if(max_idx != -1) {
            dp[i] = max_sum + vec[i];
            if(result < dp[i]) result = dp[i];
        }
    }
    
    if(result == -1) result = dp[0];
    cout << result;

    return 0;
}